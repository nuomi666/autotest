package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.info.RefundInfo;
import com.xyb.pay.api.settlement.order.RefundOrder;
import com.xyb.pay.api.settlement.order.payment.PaymentOrder;
import com.xyb.pay.api.settlement.service.PaymentService;
import com.xyb.pay.api.settlement.service.RefundService;
import dal.model.pay.PaymentInstructionDO;
import dal.model.pay.RefundInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/07/27.
 */
public class RefundServiceOfflinePayRefundTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    RefundService refundService;

    @Reference(version = DUBBO_VERSION)
    PaymentService paymentService;

    @Autowired
    PayTestBase payTestBase;


    /**
     * 1001 线下支付退款
     */
    @AutoTest(file = "pay/refundServiceOfflinePayRefundTestSuccess.csv")
    @DisplayName("--成功用例")
    public void refundServiceOfflinePayRefundTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            RefundOrder order,
            PaymentOrder paymentOrder
    ) {
        // 清除数据
        // 准备数据
        //线下支付
        paymentOrder.setReqId(OID.newID());
        paymentOrder.setGid(GID.newGID());
        paymentOrder.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(paymentOrder);
        // 调用接口
        BizResult<PaymentInfo> result1 = paymentService.orderPay(paymentOrder);
        print(result1);
        String bizNo = result1.getInfo().getBizNo();
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setBizNo(bizNo);
        order.setMerchantOrderNo(OID.newID());
        // 调用接口
        BizResult<RefundInfo> result = refundService.refund(order);
        // 结果验证
        print(result);
        print(result.getInfo());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals("comn_00_0000", result.getCode());
        String refundBizNo = result.getInfo().getBizNo();
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(paymentOrder.getReqId()).get(0);
        RefundInstructionDO refundInstructionDO = payTestBase.findRefundInstructionByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", refundInstructionDO.getTransType());
        //assertEquals("OFFLINE", refundInstructionDO.getTransTag());
        //assertEquals(order.getBizNo(), refundInstructionDO.getBizNo());
        assertEquals(order.getReqId(), refundInstructionDO.getReqId());
        assertEquals(order.getGid(), refundInstructionDO.getGid());
        assertEquals(order.getPartnerId(), refundInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), refundInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), refundInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), refundInstructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getBizNo(), refundInstructionDO.getPaymentBizNo());
        assertEquals(paymentInstructionDO.getPayerUserId(), refundInstructionDO.getPayerUserId());
        assertEquals(paymentInstructionDO.getPayeeUserId(), refundInstructionDO.getPayeeUserId());
        assertEquals(paymentInstructionDO.getPayerAccountNo(), refundInstructionDO.getPayerAccountNo());
        assertEquals(paymentInstructionDO.getRelationAccountNo(), refundInstructionDO.getRelationAccountNo());
        //assertEquals("20180615001234567803", refundInstructionDO.getPayeeAccountNo());
        assertEquals(paymentInstructionDO.getPayAmount(), refundInstructionDO.getPayAmount());
        assertEquals(order.getRefundAmount().getCent(), refundInstructionDO.getRefundAmount());
        assertEquals("SUCCESS", refundInstructionDO.getStatus());
        assertEquals("finished", refundInstructionDO.getState());
        assertEquals(order.getMemo(), refundInstructionDO.getMemo());
        assertEquals(order.getExternalMetaData(), refundInstructionDO.getExternalMetaData());

        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("REFUND", transOrderRecordDO.getTransType());
        assertEquals("OFFLINE", transOrderRecordDO.getTransTag());
        assertEquals(refundBizNo, transOrderRecordDO.getBizNo());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
        // 清除数据
    }
}
