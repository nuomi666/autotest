package com.xjy.autotest.profit;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.KryoUtil;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.profit.api.order.ProfitRefundOrder;
import com.xyb.profit.api.order.TransactionProfitOrder;
import com.xyb.profit.api.result.ProfitRefundResult;
import com.xyb.profit.api.result.TransactionProfitResult;
import com.xyb.profit.api.service.ProfitService;
import dal.model.profit.*;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.mvel2.MVEL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author ychaoyang
 * Created on 2018/06/13.
 */
public class ProfitServiceRefundTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "profit_provider_group")
    public ProfitService profitService;

    @Autowired
    public ProfitTestBase profitTestBase;

    @Autowired
    public UserTestBase userTestBase;

    /**
     * 1001 事务性单笔分润退款
     * 1002 事务性多笔分润退款
     */
    @AutoTest(file = "profit/profitServiceRefundTestSuccess.csv")
    @DisplayName("分润退款--成功用例")
    public void profitServiceRefundTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            ProfitRefundResult profitRefundResult,
            ProfitRefundOrder order,
            //准备数据
            TransactionProfitOrder transactionProfitOrder,
            RuleDO ruleDO,
            ConditionStrategyDO conditionStrategyDO,
            ActionStrategyDO actionStrategyDO,
            ActionItemDO actionItemDO,
            ActionItemDO actionItemDO1
    ) {
        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO1.getId());
        profitTestBase.cleanProfitOrderByTradeNo(order.getTradeNo());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
        profitTestBase.cleanRefundExecuteRecordByTradeNo(order.getTradeNo());
        // 准备数据
        profitTestBase.insertRule(ruleDO);
        conditionStrategyDO.setSerialExpress(KryoUtil.serializationObject(MVEL.compileExpression(conditionStrategyDO
                .getConditionExpress())));
        profitTestBase.insertConditionStrategy(conditionStrategyDO);
        profitTestBase.insertActionStrategy(actionStrategyDO);
        actionItemDO.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO.getActionExpr())));
        actionItemDO1.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO1.getActionExpr()
        )));
        profitTestBase.insertActionItem(actionItemDO);
        if (testId != 1001) {
            profitTestBase.insertActionItem(actionItemDO1);
        }
        //分润前转出方账户
        AccountDO sourceAccount = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        //分润前转入方账户
        AccountDO terminiAccount = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        //分润前第二转入方账户
        AccountDO terminiAccount1 = userTestBase.findAccountByAccountNo(actionItemDO1.getTermini()).get(0);
        String gid = GID.newGID();
        String reqId = OID.newID();
        transactionProfitOrder.setGid(gid);
        transactionProfitOrder.setReqId(reqId);
        // 调用分润接口
        TransactionProfitResult transactionProfitResult = profitService.transactionProfit(transactionProfitOrder);
        //分润后转出方账户
        AccountDO sourceAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        //分润后转入方账户
        AccountDO terminiAccountM = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        //分润后第二转入方账户
        AccountDO terminiAccountM1 = userTestBase.findAccountByAccountNo(actionItemDO1.getTermini()).get(0);
        if (testId == 1001) {
            assertEquals(sourceAccount.getBalance() - 100L, sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance() + 100L, terminiAccountM.getBalance());
        }
        if (testId == 1002) {
            assertEquals(sourceAccount.getBalance() - 100L, sourceAccountM.getBalance());
            assertEquals(terminiAccount.getBalance() + 98L, terminiAccountM.getBalance());
            assertEquals(terminiAccount1.getBalance() + 2L, terminiAccountM1.getBalance());
        }
        // 测试过程
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setProfitOrderNo(OID.newID());
        // 调用分润退款接口
        ProfitRefundResult result = profitService.refund(order);
        // 结果验证
        ProfitRefundDO profitRefundDO = profitTestBase.findProfitRefundByReqId(order.getReqId()).get(0);
        profitRefundResult.setRefundNo(profitRefundDO.getRefundNo());
        assertResultInfo(testId, profitRefundResult, result);
        // 数据验证
        assertEquals(order.getTradeNo(), profitRefundDO.getTradeNo());
        assertEquals("FINISH", profitRefundDO.getState());
        assertEquals(order.getPartnerId(), profitRefundDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), profitRefundDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), profitRefundDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), profitRefundDO.getPlatMerchantOrderNo());
        assertEquals(order.getGid(), profitRefundDO.getGid());
        //退款后转出方账户
        AccountDO sourceAccountF = userTestBase.findAccountByAccountNo(actionItemDO.getSource()).get(0);
        //退款后转入方账户
        AccountDO terminiAccountF = userTestBase.findAccountByAccountNo(actionItemDO.getTermini()).get(0);
        //退款后第二转入方账户
        AccountDO terminiAccountF1 = userTestBase.findAccountByAccountNo(actionItemDO1.getTermini()).get(0);
        //金额验证
        assertEquals(sourceAccount.getBalance(), sourceAccountF.getBalance());
        assertEquals(terminiAccount.getBalance(), terminiAccountF.getBalance());
        assertEquals(terminiAccount1.getBalance(), terminiAccountF1.getBalance());

        List<RefundExecuteRecordDO> list = profitTestBase.findRefundExecuteRecordByTradeNo(order.getTradeNo());
        if (testId == 1001) {
            assertEquals(1, list.size());
            RefundExecuteRecordDO refundExecuteRecordDO = list.get(0);
            assertEquals(profitRefundDO.getRefundNo(), refundExecuteRecordDO.getRefundNo());
            assertEquals(actionItemDO.getTermini(), refundExecuteRecordDO.getPayer());
            assertEquals(actionItemDO.getSource(), refundExecuteRecordDO.getPayee());
            assertEquals(100L, refundExecuteRecordDO.getAmount());
            assertEquals("FINISH", refundExecuteRecordDO.getState());
            assertEquals(order.getGid(), refundExecuteRecordDO.getGid());
            assertEquals(order.getPartnerId(), refundExecuteRecordDO.getPartnerId());
        }

        if (testId == 1002) {
            assertEquals(2, list.size());
            RefundExecuteRecordDO refundExecuteRecordDO = list.get(0);
            assertEquals(profitRefundDO.getRefundNo(), refundExecuteRecordDO.getRefundNo());
            assertEquals(actionItemDO1.getTermini(), refundExecuteRecordDO.getPayer());
            assertEquals(actionItemDO1.getSource(), refundExecuteRecordDO.getPayee());
            assertEquals(2L, refundExecuteRecordDO.getAmount());
            assertEquals("FINISH", refundExecuteRecordDO.getState());
            assertEquals(order.getGid(), refundExecuteRecordDO.getGid());
            assertEquals(order.getPartnerId(), refundExecuteRecordDO.getPartnerId());

            RefundExecuteRecordDO refundExecuteRecordDO1 = list.get(1);
            assertEquals(profitRefundDO.getRefundNo(), refundExecuteRecordDO1.getRefundNo());
            assertEquals(actionItemDO.getTermini(), refundExecuteRecordDO1.getPayer());
            assertEquals(actionItemDO.getSource(), refundExecuteRecordDO1.getPayee());
            assertEquals(100L, refundExecuteRecordDO1.getAmount());
            assertEquals("FINISH", refundExecuteRecordDO1.getState());
            assertEquals(order.getGid(), refundExecuteRecordDO1.getGid());
            assertEquals(order.getPartnerId(), refundExecuteRecordDO1.getPartnerId());
        }

        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO1.getId());
        profitTestBase.cleanProfitOrderByTradeNo(order.getTradeNo());
        profitTestBase.cleanActionExecuteRecordByGid(order.getGid());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
        profitTestBase.cleanRefundExecuteRecordByTradeNo(order.getTradeNo());
    }

    /**
     * 1001 gid传空
     * 1002 partnerId传空
     * 1003 reqId传空
     * 1004 merchantOrderNo传空
     * 1005 platPartnerId传空
     * 1006 platMerchantOrderNo传空
     * 1007 tradeNo传空
     * 1008 profitOrderNo传空
     */
    @AutoTest(file = "profit/profitServiceRefundTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void profitServiceRefundTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            ProfitRefundResult profitRefundResult,
            ProfitRefundOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用分润退款接口
        ProfitRefundResult result = profitService.refund(order);
        // 结果验证
        assertResultInfo(testId, profitRefundResult, result);
        // 数据验证
    }

    /**
     * 1001 分润订单不存在
     * 1002 重复请求
     * 1003 订单多次退款
     * 1004 原订单未成功
     * 1005 订单不属于该商户
     * 1006 退款转账失败-余额不足
     */
    @AutoTest(file = "profit/profitServiceRefundTestFailTwo.csv")
    @DisplayName("分润退款--失败用例")
    public void profitServiceRefundTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            ProfitRefundResult profitRefundResult,
            ProfitRefundOrder order,
            //准备数据
            TransactionProfitOrder transactionProfitOrder,
            RuleDO ruleDO,
            ConditionStrategyDO conditionStrategyDO,
            ActionStrategyDO actionStrategyDO,
            ActionItemDO actionItemDO
    ) {
        // 清除数据
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanProfitOrderByTradeNo(order.getTradeNo());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
        profitTestBase.cleanRefundExecuteRecordByTradeNo(order.getTradeNo());
        // 准备数据
        if (testId >= 1002) {
            profitTestBase.insertRule(ruleDO);
            conditionStrategyDO.setSerialExpress(KryoUtil.serializationObject(MVEL.compileExpression(conditionStrategyDO
                    .getConditionExpress())));
            profitTestBase.insertConditionStrategy(conditionStrategyDO);
            profitTestBase.insertActionStrategy(actionStrategyDO);
            actionItemDO.setSerialExpr(KryoUtil.serializationObject(MVEL.compileExpression(actionItemDO.getActionExpr())));
            profitTestBase.insertActionItem(actionItemDO);
            String gid = GID.newGID();
            String reqId = OID.newID();
            transactionProfitOrder.setGid(gid);
            transactionProfitOrder.setReqId(reqId);
            // 调用分润接口
            TransactionProfitResult transactionProfitResult = profitService.transactionProfit(transactionProfitOrder);
        }
        // 测试过程
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setProfitOrderNo(OID.newID());
        if (testId == 1002) {
            profitService.refund(order);
        }
        if (testId == 1003) {
            profitService.refund(order);
            order.setGid(GID.newGID());
            order.setReqId(OID.newID());
            order.setProfitOrderNo(OID.newID());
        }
        // 调用分润退款接口
        ProfitRefundResult result = profitService.refund(order);
        // 结果验证
        assertResultInfo(testId, profitRefundResult, result);
        // 数据验证
        profitTestBase.cleanRuleById(ruleDO.getId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
        profitTestBase.cleanActionStrategyById(actionStrategyDO.getId());
        profitTestBase.cleanActionItemById(actionItemDO.getId());
        profitTestBase.cleanProfitOrderByTradeNo(order.getTradeNo());
        profitTestBase.cleanActionExecuteRecordByGid(order.getGid());
        profitTestBase.cleanTaskExecuteRecordByTradeNo(order.getTradeNo());
        profitTestBase.cleanRefundExecuteRecordByTradeNo(order.getTradeNo());
    }

}
