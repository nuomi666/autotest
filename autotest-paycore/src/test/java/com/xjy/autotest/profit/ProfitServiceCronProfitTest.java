package com.xjy.autotest.profit;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Maps;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.KryoUtil;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.profit.api.order.TransactionProfitOrder;
import com.xyb.profit.api.result.TransactionProfitResult;
import com.xyb.profit.api.service.ProfitService;
import dal.model.profit.*;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.mvel2.MVEL;
import org.mvel2.compiler.CompiledExpression;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

/**
 * @author huairen
 * Created on 18/7/2.
 */
public class ProfitServiceCronProfitTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "profit_provider_group")
    public ProfitService profitService;

    @Reference(version = DUBBO_VERSION, group = "com.xyb.profit.biz.schedule.CronTaskScheduler")
    public ScheduleCallBackService scheduleCallBackService;

    @Autowired
    public ProfitTestBase profitTestBase;

    @Autowired
    public UserTestBase userTestBase;

    /**
     * 事务性分润暂时只有固定金额分润
     * 1001 事务性分润-条件策略金额大于100-固定分润2分
     * 1002 事务性分润-条件策略金额大于100-多笔固定分润2分
     */
    @AutoTest(file = "profit/profitServiceCronProfitTestSuccess.csv")
    @DisplayName("周期性分润--成功用例")
    public void profitServiceCronProfitTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            TransactionProfitResult transactionProfitResult,
            TransactionProfitOrder order,
            //准备数据
            RuleDO ruleDO,
            ConditionStrategyDO conditionStrategyDO,
            ConditionStrategyDO conditionStrategyDO1,
            ActionStrategyDO actionStrategyDO,
            ActionStrategyDO actionStrategyDO1,
            ActionItemDO actionItemDO,
            ActionItemDO actionItemDO1,
            CronTaskDO cronTaskDO
    ) {
        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO1.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO1.getId());
        profitTestBase.cleanProfitOrderByTradeNo(order.getTradeNo());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
        profitTestBase.cleanTaskExecuteRecordByRuleId(ruleDO.getId());
        profitTestBase.cleanCronTaskById(cronTaskDO.getId());
        // 准备数据
        profitTestBase.insertRule(ruleDO);
        conditionStrategyDO.setSerialExpress(KryoUtil.serializationObject(MVEL.compileExpression(conditionStrategyDO
                .getConditionExpress())));
        conditionStrategyDO1.setSerialExpress(KryoUtil.serializationObject(MVEL.compileExpression
                (conditionStrategyDO1.getConditionExpress())));
        profitTestBase.insertConditionStrategy(conditionStrategyDO);
        profitTestBase.insertConditionStrategy(conditionStrategyDO1);
        profitTestBase.insertActionStrategy(actionStrategyDO);
        profitTestBase.insertActionStrategy(actionStrategyDO1);
        actionItemDO.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO.getActionExpr())));
        actionItemDO1.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO1.getActionExpr()
        )));
        profitTestBase.insertActionItem(actionItemDO);
        profitTestBase.insertActionItem(actionItemDO1);
        cronTaskDO.setNextScheduleTime(new Date());
        profitTestBase.insertCronTask(cronTaskDO);

        //分润前转出方账户
        AccountDO sourceAccount = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        //分润前第二转出方账户
        AccountDO sourceAccount1 = userTestBase.findAccountByAccountNo(actionItemDO1.getSource()).get(0);
        //分润前转入方账户
        AccountDO terminiAccount = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        //分润前第二转入方账户
        AccountDO terminiAccount1 = userTestBase.findAccountByAccountNo(actionItemDO1.getTermini()).get(0);

        // 测试过程
        String gid = GID.newGID();
        String reqId = OID.newID();
        order.setGid(gid);
        order.setReqId(reqId);
        order.setMerchantOrderNo(OID.newID());
        print(order);
        // 调用接口
        TransactionProfitResult result = profitService.transactionProfit(order);
        // 结果验证
        assertResultInfo(testId, transactionProfitResult, result);

        //调用定时任务
        scheduleCallBackService.justDoIT();

        //task_execute_record表数据验证
        TaskExecuteRecordDO taskExecuteRecordDO = profitTestBase.findTaskExecuteRecordByRuleId(ruleDO.getId()).get(0);
//		assertEquals(order.getTradeNo(), taskExecuteRecordDO.getTradeNo());
//		assertEquals(order.getReqId(), taskExecuteRecordDO.getSerialNo());
//		assertEquals(order.getAmount().getCent(), taskExecuteRecordDO.getAmount());
        assertEquals("FINISH", taskExecuteRecordDO.getState());
        //TODO：未写数据
//		assertTrue(null != taskExecuteRecordDO.getFinishTime());
        assertTrue(null != taskExecuteRecordDO.getRawAddTime());
        assertTrue(null != taskExecuteRecordDO.getRawUpdateTime());
        assertEquals(actionStrategyDO.getId(), taskExecuteRecordDO.getActionStrategyId());
        assertEquals(ruleDO.getId(), taskExecuteRecordDO.getRuleId());
        assertEquals("CRON", taskExecuteRecordDO.getRuleType());

        //profit_order表数据验证
        ProfitOrderDO profitOrderDO = profitTestBase.findProfitOrderByReqId(order.getReqId()).get(0);
        assertEquals(order.getTradeNo(), profitOrderDO.getTradeNo());
        assertEquals("INIT", profitOrderDO.getState());
        assertEquals(order.getPartnerId(), profitOrderDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), profitOrderDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), profitOrderDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), profitOrderDO.getPlatMerchantOrderNo());
        assertEquals(order.getReqId(), profitOrderDO.getReqId());
        assertEquals(order.getGid(), profitOrderDO.getGid());
        assertTrue(null != profitOrderDO.getRawAddTime());
        assertTrue(null != profitOrderDO.getRawUpdateTime());

        long amount = 0;
        long amount1 = 0;
        Map<String, Object> vars = Maps.newHashMap();
        vars.put("amount", order.getAmount().getCent());
        //action_execute_record表数据验证
        ActionExecuteRecordDO actionExecuteRecordDO = profitTestBase.findActionExecuteRecordByTaskRecordId
                (taskExecuteRecordDO.getId()).get(0);
        assertEquals(taskExecuteRecordDO.getId(), actionExecuteRecordDO.getTaskRecordId());
        assertEquals(actionItemDO.getSource(), actionExecuteRecordDO.getSource());
        assertEquals(actionItemDO.getTermini(), actionExecuteRecordDO.getTermini());
        assertEquals(actionItemDO.getSequence(), actionExecuteRecordDO.getSequence());
        amount = Long.valueOf(MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO
                .getSerialExpr(), CompiledExpression.class), vars).toString());
        assertEquals(amount, actionExecuteRecordDO.getAmount());
        assertEquals("FINISH", actionExecuteRecordDO.getState());

        if (testId == 1002) {
            ActionExecuteRecordDO actionExecuteRecordDO1 = profitTestBase.findActionExecuteRecordByTaskRecordId
                    (taskExecuteRecordDO.getId()).get(1);
            assertEquals(taskExecuteRecordDO.getId(), actionExecuteRecordDO1.getTaskRecordId());
            assertEquals(actionItemDO1.getSource(), actionExecuteRecordDO1.getSource());
            assertEquals(actionItemDO1.getTermini(), actionExecuteRecordDO1.getTermini());
            assertEquals(actionItemDO1.getSequence(), actionExecuteRecordDO1.getSequence());
            amount1 = Long.valueOf(MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO1
                    .getSerialExpr(), CompiledExpression.class), vars).toString());
            assertEquals(amount1, actionExecuteRecordDO1.getAmount());
            assertEquals("FINISH", actionExecuteRecordDO1.getState());
        }
        //分润后转出方账户
        AccountDO sourceAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        //分润后第二转出方账户
        AccountDO sourceAccountM1 = userTestBase.findAccountByAccountNo(actionItemDO1.getSource()).get(0);
        //分润后转入方账户
        AccountDO terminiAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        //分润后第二转入方账户
        AccountDO terminiAccountM1 = userTestBase.findAccountByAccountNo(actionItemDO1.getTermini()).get(0);
        if (testId == 1001) {
            assertEquals(sourceAccount.getBalance() - amount, sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance() + amount, terminiAccountM.getBalance());
        }
        if (testId == 1002) {
            assertEquals(sourceAccount.getBalance() - amount, sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance() + amount - amount1, terminiAccountM.getBalance());
            assertEquals(terminiAccount1.getBalance() + amount1, terminiAccountM1.getBalance());
        }
        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO1.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO1.getId());
        profitTestBase.cleanProfitOrderByGid(order.getGid());
        profitTestBase.cleanActionExecuteRecordByTaskRecordId(taskExecuteRecordDO.getId());
        profitTestBase.cleanTaskExecuteRecordByRuleId(ruleDO.getId());
        profitTestBase.cleanCronTaskById(cronTaskDO.getId());
    }

    /**
     * 1001 事务性分润-余额不足
     * 1001 事务性分润-账户不存在
     */
    @AutoTest(file = "profit/profitServiceCronProfitTestFailTwo.csv")
    @DisplayName("周期性分润失败--失败用例")
    public void profitServiceCronProfitTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            TransactionProfitResult transactionProfitResult,
            TransactionProfitOrder order,
            //准备数据
            RuleDO ruleDO,
            ConditionStrategyDO conditionStrategyDO,
            ConditionStrategyDO conditionStrategyDO1,
            ActionStrategyDO actionStrategyDO,
            ActionStrategyDO actionStrategyDO1,
            ActionItemDO actionItemDO,
            ActionItemDO actionItemDO1,
            CronTaskDO cronTaskDO
    ) {
        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO1.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO1.getId());
        profitTestBase.cleanProfitOrderByTradeNo(order.getTradeNo());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
        profitTestBase.cleanTaskExecuteRecordByRuleId(ruleDO.getId());
        profitTestBase.cleanCronTaskById(cronTaskDO.getId());
        // 准备数据
        profitTestBase.insertRule(ruleDO);
        conditionStrategyDO.setSerialExpress(KryoUtil.serializationObject(MVEL.compileExpression(conditionStrategyDO
                .getConditionExpress())));
        conditionStrategyDO1.setSerialExpress(KryoUtil.serializationObject(MVEL.compileExpression
                (conditionStrategyDO1.getConditionExpress())));
        profitTestBase.insertConditionStrategy(conditionStrategyDO);
        profitTestBase.insertConditionStrategy(conditionStrategyDO1);
        profitTestBase.insertActionStrategy(actionStrategyDO);
        profitTestBase.insertActionStrategy(actionStrategyDO1);
        actionItemDO.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO.getActionExpr())));
        actionItemDO1.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO1.getActionExpr()
        )));
        profitTestBase.insertActionItem(actionItemDO);
        profitTestBase.insertActionItem(actionItemDO1);
        cronTaskDO.setNextScheduleTime(new Date());
        profitTestBase.insertCronTask(cronTaskDO);

        //分润前转出方账户
        AccountDO sourceAccount = null;
        //分润前转入方账户
        AccountDO terminiAccount = null;
        if (testId == 1001) {
            sourceAccount = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
            terminiAccount = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        }
        if (testId == 1002) {
            sourceAccount = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        }
        // 测试过程
        String gid = GID.newGID();
        String reqId = OID.newID();
        order.setGid(gid);
        order.setReqId(reqId);
        order.setMerchantOrderNo(OID.newID());
        print(order);
        // 调用接口
        TransactionProfitResult result = profitService.transactionProfit(order);
        // 结果验证
        assertResultInfo(testId, transactionProfitResult, result);

        //调用定时任务
        scheduleCallBackService.justDoIT();

        //task_execute_record表数据验证
        TaskExecuteRecordDO taskExecuteRecordDO = profitTestBase.findTaskExecuteRecordByRuleId(ruleDO.getId()).get(0);
        assertEquals("PROCESSING", taskExecuteRecordDO.getState());
        assertTrue(null != taskExecuteRecordDO.getRawAddTime());
        assertTrue(null != taskExecuteRecordDO.getRawUpdateTime());
        assertEquals(actionStrategyDO.getId(), taskExecuteRecordDO.getActionStrategyId());
        assertEquals(ruleDO.getId(), taskExecuteRecordDO.getRuleId());
        assertEquals("CRON", taskExecuteRecordDO.getRuleType());

        //profit_order表数据验证
        ProfitOrderDO profitOrderDO = profitTestBase.findProfitOrderByReqId(order.getReqId()).get(0);
        assertEquals(order.getTradeNo(), profitOrderDO.getTradeNo());
        assertEquals("INIT", profitOrderDO.getState());
        assertEquals(order.getPartnerId(), profitOrderDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), profitOrderDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), profitOrderDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), profitOrderDO.getPlatMerchantOrderNo());
        assertEquals(order.getReqId(), profitOrderDO.getReqId());
        assertEquals(order.getGid(), profitOrderDO.getGid());
        assertTrue(null != profitOrderDO.getRawAddTime());
        assertTrue(null != profitOrderDO.getRawUpdateTime());

        long amount = 0L;
        Map<String, Object> vars = Maps.newHashMap();
        vars.put("amount", order.getAmount().getCent());
        //action_execute_record表数据验证
        ActionExecuteRecordDO actionExecuteRecordDO = profitTestBase.findActionExecuteRecordByTaskRecordId
                (taskExecuteRecordDO.getId()).get(0);
        assertEquals(taskExecuteRecordDO.getId(), actionExecuteRecordDO.getTaskRecordId());
        assertEquals(actionItemDO.getSource(), actionExecuteRecordDO.getSource());
        assertEquals(actionItemDO.getTermini(), actionExecuteRecordDO.getTermini());
        assertEquals(actionItemDO.getSequence(), actionExecuteRecordDO.getSequence());
        amount = Long.valueOf(MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO
                .getSerialExpr(), CompiledExpression.class), vars).toString());
        assertEquals(amount, actionExecuteRecordDO.getAmount());
        assertEquals("FAIL", actionExecuteRecordDO.getState());

        //分润后转出方账户
        AccountDO sourceAccountM = null;
        //分润后转入方账户
        AccountDO terminiAccountM = null;
        if (testId == 1001) {
            sourceAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
            terminiAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        }
        if (testId == 1002) {
            sourceAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        }
        if (testId == 1001) {
            assertEquals(sourceAccount.getBalance(), sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance(), terminiAccountM.getBalance());
        }
        if (testId == 1002) {
            assertEquals(sourceAccount.getBalance(), sourceAccountM.getBalance());
        }
        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO1.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO1.getId());
        profitTestBase.cleanProfitOrderByGid(order.getGid());
        profitTestBase.cleanActionExecuteRecordByTaskRecordId(taskExecuteRecordDO.getId());
        profitTestBase.cleanTaskExecuteRecordByRuleId(ruleDO.getId());
        profitTestBase.cleanCronTaskById(cronTaskDO.getId());
    }
}
