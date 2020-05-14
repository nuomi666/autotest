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
import com.xyb.profit.api.order.TransactionProfitOrder;
import com.xyb.profit.api.result.TransactionProfitResult;
import com.xyb.profit.api.service.ProfitService;
import dal.model.profit.*;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.mvel2.MVEL;
import org.mvel2.compiler.CompiledExpression;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author ychaoyang
 * Created on 2018/06/12.
 */
public class ProfitServiceTransactionProfitTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "profit_provider_group")
    public ProfitService profitService;

    @Autowired
    public ProfitTestBase profitTestBase;

    @Autowired
    public UserTestBase userTestBase;

    /**
     * 1001 事务性分润-条件策略金额大于100-固定分润1元
     * 1002 事务性分润-条件策略金额等于102-百分比1%分润,标准舍入
     * 1003 事务性分润-条件策略金额大于10-百分比 0.02%分润1,向上舍入
     * 1004 事务性分润-条件策略金额大于10-百分比0.02%分润0,标准舍入
     * 1005 事务性分润-条件策略金额等于100.2-百分比2%分润,向上舍入
     * 1006 事务性分润-条件策略金额等于100.3-百分比2%分润,向下舍入
     * 1007 事务性分润-条件策略金额等于100.3-百分比2%分润,标准舍入
     * 1008 事务性分润-条件策略金额小于100-阶梯分润A->B，B->C
     * 1009 事务性分润-条件策略金额小于100-阶梯百分比分润
     * 1010 事务性分润-条件策略金额大于100,大于50,>100优先-固定分润1.01元
     * 1011 事务性分润-条件策略金额大于100,大于50,>100优先-固定分润0元
     */
    @AutoTest(file = "profit/profitServiceTransactionProfitTestSuccess.csv")
    @DisplayName("事务性分润--成功用例")
    public void profitServiceTransactionProfitTestSuccess(
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
//		profitTestBase.insertCronTask(cronTaskDO);

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
        ProfitOrderDO profitOrderDO = profitTestBase.findProfitOrderByReqId(order.getReqId()).get(0);
        transactionProfitResult.setOrderNo(profitOrderDO.getOrderNo());
        assertResultInfo(testId, transactionProfitResult, result);
        // 数据验证
        //task_execute_record表数据验证
        TaskExecuteRecordDO taskExecuteRecordDO = profitTestBase.findTaskExecuteRecordByTradeNo(order.getTradeNo())
                .get(0);
        assertEquals(order.getTradeNo(), taskExecuteRecordDO.getTradeNo());
        assertEquals(order.getReqId(), taskExecuteRecordDO.getSerialNo());
        assertEquals(order.getAmount().getCent(), taskExecuteRecordDO.getAmount());
        assertEquals("FINISH", taskExecuteRecordDO.getState());
        assertTrue(null != taskExecuteRecordDO.getExecuteTime());
        //TODO：未写数据
//		assertTrue(null != taskExecuteRecordDO.getFinishTime());
        assertTrue(null != taskExecuteRecordDO.getRawAddTime());
        assertTrue(null != taskExecuteRecordDO.getRawUpdateTime());
        if (testId <= 1009) {
            assertEquals(conditionStrategyDO.getId(), taskExecuteRecordDO.getConditionStrategyId());
            assertEquals(conditionStrategyDO.getConditionExpress(), taskExecuteRecordDO.getConditionExpr());
            assertEquals(actionStrategyDO.getId(), taskExecuteRecordDO.getActionStrategyId());
        }
        if (testId == 1010 || testId == 1011) {
            assertEquals(conditionStrategyDO1.getId(), taskExecuteRecordDO.getConditionStrategyId());
            assertEquals(conditionStrategyDO1.getConditionExpress(), taskExecuteRecordDO.getConditionExpr());
            assertEquals(actionStrategyDO1.getId(), taskExecuteRecordDO.getActionStrategyId());
        }
        assertEquals(ruleDO.getId(), taskExecuteRecordDO.getRuleId());
        assertEquals("TRANSACTION", taskExecuteRecordDO.getRuleType());
        //profit_order表数据验证
        assertEquals(order.getTradeNo(), profitOrderDO.getTradeNo());
        assertEquals("FINISH", profitOrderDO.getState());
        assertEquals(order.getPartnerId(), profitOrderDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), profitOrderDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), profitOrderDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), profitOrderDO.getPlatMerchantOrderNo());
        assertEquals(order.getReqId(), profitOrderDO.getReqId());
        assertEquals(order.getGid(), profitOrderDO.getGid());
        assertTrue(null != profitOrderDO.getRawAddTime());
        assertTrue(null != profitOrderDO.getRawUpdateTime());
        //action_execute_record表数据验证
        Map<String, Object> vars = Maps.newHashMap();
        vars.put("amount", order.getAmount().getCent());
        long amount = 0;
        if (testId <= 1009) {
            ActionExecuteRecordDO actionExecuteRecordDO = profitTestBase.findActionExecuteRecordByGid(order.getGid())
                    .get(0);
            assertEquals(taskExecuteRecordDO.getId(), actionExecuteRecordDO.getTaskRecordId());
            assertEquals(actionItemDO.getSource(), actionExecuteRecordDO.getSource());
            assertEquals(actionItemDO.getTermini(), actionExecuteRecordDO.getTermini());
            assertEquals(actionItemDO.getSequence(), actionExecuteRecordDO.getSequence());
            if (testId == 1002 || testId == 1009) {
                amount = Math.round((Double) MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO
                        .getSerialExpr(), CompiledExpression.class), vars));
            } else if (testId == 1003) {
                amount = 1L;
            } else if (testId == 1004) {
                amount = 0L;
            } else if (testId == 1005) {
                amount = 201L;
            } else if (testId == 1006) {
                amount = 200L;
            } else if (testId == 1007) {
                amount = 201L;
            } else {
                amount = Long.valueOf(MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO
                        .getSerialExpr(), CompiledExpression.class), vars).toString());
            }
            assertEquals(amount, actionExecuteRecordDO.getAmount());
            assertEquals("FINISH", actionExecuteRecordDO.getState());
            assertEquals(order.getGid(), actionExecuteRecordDO.getGid());
        }
        long amount1 = 0;
        ActionExecuteRecordDO actionExecuteRecordDO1 = null;
        Map<String, Object> vars1 = Maps.newHashMap();
        vars1.put("amount", order.getAmount().getCent());
        if (testId >= 1008) {
            if (testId <= 1009) {
                assertEquals(2, profitTestBase.findActionExecuteRecordByGid(order.getGid()).size());
                actionExecuteRecordDO1 = profitTestBase.findActionExecuteRecordByGid(order.getGid()).get(1);
            }
            if (testId == 1010 || testId == 1011) {
                assertEquals(1, profitTestBase.findActionExecuteRecordByGid(order.getGid()).size());
                actionExecuteRecordDO1 = profitTestBase.findActionExecuteRecordByGid(order
                        .getGid()).get(0);
            }
            assertEquals(actionItemDO1.getSource(), actionExecuteRecordDO1.getSource());
            assertEquals(actionItemDO1.getTermini(), actionExecuteRecordDO1.getTermini());
            assertEquals(actionItemDO1.getSequence(), actionExecuteRecordDO1.getSequence());
            if (testId == 1009) {
                amount1 = Math.round((Double) MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO1
                        .getSerialExpr(), CompiledExpression.class), vars1));
            } else {
                amount1 = Long.valueOf(MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO1.getSerialExpr(), CompiledExpression.class), vars).toString());
            }
            assertEquals(amount1, actionExecuteRecordDO1.getAmount());
            assertEquals("FINISH", actionExecuteRecordDO1.getState());
            assertEquals(order.getGid(), actionExecuteRecordDO1.getGid());
        }
        //分润后转出方账户
        AccountDO sourceAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        //分润后第二转出方账户
        AccountDO sourceAccountM1 = userTestBase.findAccountByAccountNo(actionItemDO1.getSource()).get(0);
        //分润后转入方账户
        AccountDO terminiAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        //分润后第二转入方账户
        AccountDO terminiAccountM1 = userTestBase.findAccountByAccountNo(actionItemDO1.getTermini()).get(0);
        if (testId <= 1007) {
            assertEquals(sourceAccount.getBalance() - amount, sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance() + amount, terminiAccountM.getBalance());
        }
        if (testId == 1008 || testId == 1009) {
            assertEquals(sourceAccount.getBalance() - amount, sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance() + amount - amount1, terminiAccountM.getBalance());
            assertEquals(terminiAccount1.getBalance() + amount1, terminiAccountM1.getBalance());
        }
        if (testId == 1010 || testId == 1011) {
            assertEquals(sourceAccount1.getBalance() - amount1, sourceAccountM1.getBalance());
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
        profitTestBase.cleanActionExecuteRecordByGid(order.getGid());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
    }

    /**
     * 1001 partnerId传空
     * 1002 merchantOrderNo传空
     * 1003 platPartnerId传空
     * 1004 platMerchantOrderNo传空
     * 1005 reqId传空
     * 1006 gid传空
     * 1007 tradeNo传空
     * 1008 amount传空
     */
    @AutoTest(file = "profit/profitServiceTransactionProfitTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void profitServiceTransactionProfitTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            TransactionProfitResult transactionProfitResult,
            TransactionProfitOrder order
            //准备数据
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        TransactionProfitResult result = profitService.transactionProfit(order);
        // 结果验证
        assertResultInfo(testId, transactionProfitResult, result);
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 分润规则不存在
     * 1002 条件策略不存在
     * 1003 动作策略不存在
     * 1004 执行动作不存在
     * 1005 条件策略状态关闭
     * 1006 动作策略状态关闭
     * 1007 条件策略没有符合项
     * 1008 重复请求
     * 1009 订单已分润
     * 1010 调转账余额不足
     * 1011 转账转出用户不存在
     * 1012 转账转入用户不存在
     * 1013 转账调用超时
     */
    @AutoTest(file = "profit/profitServiceTransactionProfitTestFailTwo.csv")
    @DisplayName("分润失败--失败用例")
    public void profitServiceTransactionProfitTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            TransactionProfitOrder order,
            TransactionProfitResult transactionProfitResult,
            //准备数据
            RuleDO ruleDO,
            ConditionStrategyDO conditionStrategyDO,
            ActionStrategyDO actionStrategyDO,
            ActionItemDO actionItemDO
    ) {
        // 清除数据
        profitTestBase.cleanRuleByPartnerId(order.getPartnerId());
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanProfitOrderByPartnerId(order.getPartnerId());
        profitTestBase.cleanProfitOrderByTradeNo(order.getTradeNo());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
        // 准备数据
        if (testId != 1001) {
            profitTestBase.insertRule(ruleDO);
            if (testId != 1002) {
                conditionStrategyDO.setSerialExpress(KryoUtil.serializationObject(MVEL.compileExpression
                        (conditionStrategyDO.getConditionExpress())));
                profitTestBase.insertConditionStrategy(conditionStrategyDO);
                if (testId != 1003) {
                    profitTestBase.insertActionStrategy(actionStrategyDO);
                    if (testId != 1004) {
                        actionItemDO.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO
                                .getActionExpr())));
                        profitTestBase.insertActionItem(actionItemDO);
                    }
                }
            }
        }
        // 测试过程
        String gid = GID.newGID();
        String reqId = OID.newID();
        order.setGid(gid);
        order.setReqId(reqId);
        order.setMerchantOrderNo(OID.newID());
        print(order);
        if (testId == 1008 || testId == 1009) {
            profitService.transactionProfit(order);
            sleep(2);
            if (testId == 1009) {
                order.setReqId(OID.newID());
            }
        }
        //分润前转出方账户
        AccountDO sourceAccount = null;
        //分润前转入方账户
        AccountDO terminiAccount = null;
        if (testId <= 1010) {
            sourceAccount = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
            terminiAccount = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        }
        if (testId == 1011) {
            terminiAccount = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        }
        if (testId == 1012) {
            sourceAccount = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        }

        // 调用接口
        TransactionProfitResult result = profitService.transactionProfit(order);
        // 结果验证
        if (testId >= 1008) {
            ProfitOrderDO profitOrderDO = profitTestBase.findProfitOrderByTradeNo(order.getTradeNo()).get(0);
            transactionProfitResult.setOrderNo(profitOrderDO.getOrderNo());
        }
        assertResultInfo(testId, transactionProfitResult, result);
        // 数据验证
        if (testId >= 1010) {
            //task_execute_record表数据验证
            TaskExecuteRecordDO taskExecuteRecordDO = profitTestBase.findTaskExecuteRecordByTradeNo(order.getTradeNo()).get(0);
            assertEquals(order.getTradeNo(), taskExecuteRecordDO.getTradeNo());
            assertEquals(order.getReqId(), taskExecuteRecordDO.getSerialNo());
            assertEquals(order.getAmount().getCent(), taskExecuteRecordDO.getAmount());
            assertEquals("PROCESSING", taskExecuteRecordDO.getState());
            assertTrue(null != taskExecuteRecordDO.getExecuteTime());
            //TODO：未写数据
//		assertTrue(null != taskExecuteRecordDO.getFinishTime());
            assertTrue(null != taskExecuteRecordDO.getRawAddTime());
            assertTrue(null != taskExecuteRecordDO.getRawUpdateTime());
            assertEquals(conditionStrategyDO.getId(), taskExecuteRecordDO.getConditionStrategyId());
            assertEquals(conditionStrategyDO.getConditionExpress(), taskExecuteRecordDO.getConditionExpr());
            assertEquals(actionStrategyDO.getId(), taskExecuteRecordDO.getActionStrategyId());

            //profit_order表数据验证
            ProfitOrderDO profitOrderDO = profitTestBase.findProfitOrderByReqId(order.getReqId()).get(0);
            assertEquals(order.getTradeNo(), profitOrderDO.getTradeNo());
            assertEquals("PROCESSING", profitOrderDO.getState());
            assertEquals(order.getPartnerId(), profitOrderDO.getPartnerId());
            assertEquals(order.getMerchantOrderNo(), profitOrderDO.getMerchantOrderNo());
            assertEquals(order.getPlatPartnerId(), profitOrderDO.getPlatPartnerId());
            assertEquals(order.getPlatMerchantOrderNo(), profitOrderDO.getPlatMerchantOrderNo());
            assertEquals(order.getReqId(), profitOrderDO.getReqId());
            assertEquals(order.getGid(), profitOrderDO.getGid());
            assertTrue(null != profitOrderDO.getRawAddTime());
            assertTrue(null != profitOrderDO.getRawUpdateTime());

            //action_execute_record表数据验证
            Map<String, Object> vars = Maps.newHashMap();
            vars.put("amount", order.getAmount().getCent());
            ActionExecuteRecordDO actionExecuteRecordDO = profitTestBase.findActionExecuteRecordByGid(order.getGid())
                    .get(0);
            assertEquals(taskExecuteRecordDO.getId(), actionExecuteRecordDO.getTaskRecordId());
            assertEquals(actionItemDO.getSource(), actionExecuteRecordDO.getSource());
            assertEquals(actionItemDO.getTermini(), actionExecuteRecordDO.getTermini());
            assertEquals(actionItemDO.getSequence(), actionExecuteRecordDO.getSequence());
            long amount = Long.valueOf(MVEL.executeExpression(KryoUtil.deserializationObject(actionItemDO
                    .getSerialExpr(), CompiledExpression.class), vars).toString());
            assertEquals(amount, actionExecuteRecordDO.getAmount());
            assertEquals("FAIL", actionExecuteRecordDO.getState());
            assertEquals(order.getGid(), actionExecuteRecordDO.getGid());

        }

        //分润后转出方账户
        AccountDO sourceAccountM = null;
        //分润后转入方账户
        AccountDO terminiAccountM = null;
        if (testId <= 1010) {
            sourceAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
            terminiAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        }
        if (testId == 1011) {
            terminiAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        }
        if (testId == 1012) {
            sourceAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        }

        if (testId <= 1007 || testId == 1010) {
            assertEquals(sourceAccount.getBalance(), sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance(), terminiAccountM.getBalance());
        }
        if (testId == 1008 || testId == 1009) {
            assertEquals(sourceAccount.getBalance() - 100L, sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance() + 100L, terminiAccountM.getBalance());
        }
        if (testId == 1011) {
            assertEquals(terminiAccount.getBalance(), terminiAccountM.getBalance());
        }
        if (testId == 1012) {
            assertEquals(sourceAccount.getBalance(), sourceAccountM.getBalance());
        }
        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanProfitOrderByReqId(order.getReqId());
        profitTestBase.cleanActionExecuteRecordByReqId(order.getReqId());
        profitTestBase.cleanProfitOrderByGid(order.getGid());
        profitTestBase.cleanActionExecuteRecordByGid(order.getGid());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
    }
}
