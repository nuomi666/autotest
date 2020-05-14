package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.order.payment.PaymentOrder;
import com.xyb.pay.api.settlement.service.PaymentService;
import dal.model.pay.PaymentInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/07/11.
 */
public class PaymentServiceOfflineOrderPayTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    PaymentService paymentService;

    @Autowired
    PayTestBase payTestBase;

    /**
     * 1001 必填参数，线下支付，100元
     * 1002 全填参数，线下支付，101.11元
     */
    @AutoTest(file = "pay/paymentServiceOfflineOrderPayTestSuccess.csv")
    @DisplayName("线下支付--成功用例")
    public void paymentServiceOfflineOrderPayTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            PaymentOrder order
    ) {
        // 清除数据
        payTestBase.cleanDepositInstructionByPartnerId(order.getPartnerId());
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        // 调用接口
        BizResult<PaymentInfo> result = paymentService.orderPay(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
        assertEquals("PAYMENT", paymentInstructionDO.getTransType());
        assertEquals("OFFLINE", paymentInstructionDO.getTransTag());
        assertEquals(order.getGid(), paymentInstructionDO.getGid());
        assertEquals(order.getPartnerId(), paymentInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), paymentInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), paymentInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), paymentInstructionDO.getPlatMerchantOrderNo());
        //assertEquals(order.getPayeeUserId(), paymentInstructionDO.getPayeeUserId());
        assertEquals(order.getPayAmount().getCent(), paymentInstructionDO.getPayAmount());
        assertEquals(null, paymentInstructionDO.getPayChannel());
        assertEquals("SUCCESS", paymentInstructionDO.getStatus());
        assertEquals("finished", paymentInstructionDO.getState());
        assertEquals(order.getMemo(), paymentInstructionDO.getMemo());
        assertEquals(order.getExternalMetaData(), paymentInstructionDO.getExternalmetadata());
        assertEquals(result.getInfo().getBizNo(), paymentInstructionDO.getBizNo());

        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("PAYMENT", transOrderRecordDO.getTransType());
        assertEquals("OFFLINE", transOrderRecordDO.getTransTag());
        assertEquals(paymentInstructionDO.getBizNo(), transOrderRecordDO.getBizNo());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
        // 清除数据
        payTestBase.cleanDepositInstructionByPartnerId(order.getPartnerId());
    }

}
