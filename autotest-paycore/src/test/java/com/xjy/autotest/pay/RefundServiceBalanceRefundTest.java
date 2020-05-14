package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.info.RefundInfo;
import com.xyb.pay.api.settlement.order.RefundOrder;
import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentApplyOrder;
import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentConfirmOrder;
import com.xyb.pay.api.settlement.service.BalancePaymentService;
import com.xyb.pay.api.settlement.service.RefundService;
import dal.model.pay.AccountOperateRecordDO;
import dal.model.pay.PaymentInstructionDO;
import dal.model.pay.RefundInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;


/**
 * @author ychaoyang
 * Created on 2018/07/19.
 */
public class RefundServiceBalanceRefundTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    RefundService refundService;

    @Reference(version = DUBBO_VERSION)
    BalancePaymentService balancePaymentService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 余额支付退款
     */
    @AutoTest(file = "pay/refundServiceBalanceRefundTestSuccess.csv")
    @DisplayName("支付退款--成功用例")
    public void refundServiceBalanceRefundTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            RefundOrder order,
            // 准备数据
            BalancePaymentApplyOrder balancePaymentApplyOrder,
            BalancePaymentConfirmOrder balancePaymentConfirmOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 申请余额支付
        balancePaymentApplyOrder.setReqId(OID.newID());
        balancePaymentApplyOrder.setGid(GID.newGID());
        balancePaymentApplyOrder.setMerchantOrderNo(GID.newGID());
        BizResult<PaymentInfo> result1 = balancePaymentService.apply(balancePaymentApplyOrder);
        String bizNo = result1.getInfo().getBizNo();
        // 确认余额支付
        balancePaymentConfirmOrder.setReqId(OID.newID());
        balancePaymentConfirmOrder.setGid(GID.newGID());
        balancePaymentConfirmOrder.setBizNo(bizNo);
        BizResult<PaymentInfo> result2 = balancePaymentService.confirm(balancePaymentConfirmOrder);
        print(result2);
        PaymentInstructionDO paymentInstructionDO1 = payTestBase.findPaymentInstructionByBizNo(bizNo).get(0);
        //账务余额
        AccountDO PayerAccountDO = userTestBase.findAccountByAccountNo(paymentInstructionDO1.getPayerUserId()).get(0);
        //AccountDO relationAccountDO = userTestBase.findAccountByAccountNo(paymentInstructionDO1.getRelationAccountNo()).get(0);
        //AccountDO refundAccountDO = userTestBase.findAccountByUserId(paymentInstructionDO1.getPayeeUserId()).stream().filter(
        //        (acc) -> ("refund".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        // 调用接口
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setBizNo(bizNo);
        order.setMerchantOrderNo(OID.newID());
        BizResult<RefundInfo> result = refundService.refund(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        String refundBizNo = result.getInfo().getBizNo();
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(balancePaymentApplyOrder.getReqId()).get(0);
        RefundInstructionDO refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", refundInstructionDO.getTransType());
        //assertEquals("REFUND", refundInstructionDO.getTransTag());
        //assertEquals(order.getBizNo(), refundInstructionDO.getBizNo());
        assertEquals(order.getReqId(), refundInstructionDO.getReqId());
        assertEquals(order.getGid(), refundInstructionDO.getGid());
        assertEquals(order.getPartnerId(), refundInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), refundInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), refundInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), refundInstructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getBizNo(), refundInstructionDO.getPaymentBizNo());
        assertEquals(paymentInstructionDO.getPayeeUserId(), refundInstructionDO.getPayerUserId());
        assertEquals(paymentInstructionDO.getPayerUserId(), refundInstructionDO.getPayeeUserId());
        //TODO：退款表付款账户，需再确认
        //assertEquals(refundAccountDO.getAccountNo(), refundInstructionDO.getPayerAccountNo());
        assertEquals(paymentInstructionDO.getRelationAccountNo(), refundInstructionDO.getRelationAccountNo());
        //assertEquals("20180615001234567803", refundInstructionDO.getPayeeAccountNo());
        assertEquals(paymentInstructionDO.getPayAmount(), refundInstructionDO.getPayAmount());
        assertEquals(order.getRefundAmount().getCent(), refundInstructionDO.getRefundAmount());
        assertEquals(order.getRefundAmount().getCent(), refundInstructionDO.getRefundAmount());
        assertEquals("SUCCESS", refundInstructionDO.getStatus());
        assertEquals("finished", refundInstructionDO.getState());
        assertEquals(order.getMemo(), refundInstructionDO.getMemo());
        assertEquals(order.getExternalMetaData(), refundInstructionDO.getExternalMetaData());

        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", transOrderRecordDO.getTransType());
        assertEquals("BALANCE", transOrderRecordDO.getTransTag());
        assertEquals(refundBizNo, transOrderRecordDO.getBizNo());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());

/*
        AccountOperateRecordDO accountOperateRecordDO = payTestBase.findAccountOperateRecordByMerchantOrderNo(refundInstructionDO.getMerchantOrderNo()).get(0);
        assertEquals("REFUND", accountOperateRecordDO.getTransType());
        assertEquals(refundInstructionDO.getBizNo(), accountOperateRecordDO.getBizNo());
        //assertEquals(order.getReqId(), accountOperateRecordDO.getReqId());
        //assertEquals(order.getGid(), accountOperateRecordDO.getGid());
        assertEquals(refundInstructionDO.getPartnerId(), accountOperateRecordDO.getPartnerId());
        assertEquals(refundInstructionDO.getMerchantOrderNo(), accountOperateRecordDO.getMerchantOrderNo());
        assertEquals(refundInstructionDO.getPlatPartnerId(), accountOperateRecordDO.getPlatPartnerId());
        assertEquals(refundInstructionDO.getPlatMerchantOrderNo(), accountOperateRecordDO.getPlatMerchantOrderNo());
        assertEquals(refundInstructionDO.getPayerAccountNo(), accountOperateRecordDO.getAccountNo());
        assertEquals(order.getRefundAmount().getCent(), accountOperateRecordDO.getPayAmount());
        assertEquals("UP_BALANCE", accountOperateRecordDO.getExecuteType());
        assertEquals("WAIT_EXECUTE", accountOperateRecordDO.getState());
        //调定时任务上账
        scheduleCallBackService.justDoIT();
        sleep(2);
        assertEquals("EXECUTED", payTestBase.findAccountOperateRecordByMerchantOrderNo(refundInstructionDO.getMerchantOrderNo()).get(0).getState());
*/
        //账务验证
        AccountDO payerAccountAfter = userTestBase.findAccountByAccountNo(paymentInstructionDO1.getPayerUserId()).get(0);
        //AccountDO payeeAccountAfter = userTestBase.findAccountByUserId(paymentInstructionDO1.getPayeeUserId()).stream().filter(
        //        (acc) -> ("refund".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        //AccountDO relationAccountAfter = userTestBase.findAccountByAccountNo(paymentInstructionDO1.getRelationAccountNo()).get(0);
        assertEquals(PayerAccountDO.getBalance() + order.getRefundAmount().getCent(), payerAccountAfter.getBalance());
        //assertEquals(relationAccountDO.getBalance() + order.getRefundAmount().getCent(), relationAccountAfter.getBalance());
        //assertEquals(refundAccountDO.getBalance() + order.getRefundAmount().getCent(), payeeAccountAfter.getBalance());
        // 清除数据
        payTestBase.cleanPaymentInstructionByPartnerId(order.getPartnerId());
    }
}
