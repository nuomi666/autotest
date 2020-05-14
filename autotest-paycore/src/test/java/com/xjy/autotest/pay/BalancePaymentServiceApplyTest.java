package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentApplyOrder;
import com.xyb.pay.api.settlement.service.BalancePaymentService;
import dal.model.pay.PaymentInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/07/10.
 */
public class BalancePaymentServiceApplyTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    BalancePaymentService balancePaymentService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 请求余额支付
     * 1002 请求余额支付收款人为partnerId
     * 1003 重复请求
     * 1004 关联账户下账
     */
    @DisplayName("请求余额支付--成功用例")
    @AutoTest(file = "pay/balancePaymentServiceApplyTestSuccess.csv")
    public void balancePaymentServiceApplyTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            BalancePaymentApplyOrder order
    ) {
        // 清除数据
        payTestBase.cleanPaymentInstructionByPartnerId(order.getPartnerId());
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        // 调用接口
        BizResult<PaymentInfo> result = balancePaymentService.apply(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getCode(), result.getCode());
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertFalse(result.toString().contains("privateKey"));
        PaymentInfo paymentInfo = result.getInfo();
        // 数据验证
        PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
        assertEquals("PAYMENT", paymentInstructionDO.getTransType());
        assertEquals("BALANCE", paymentInstructionDO.getTransTag());
        assertEquals(paymentInfo.getBizNo(), paymentInstructionDO.getBizNo());
        assertEquals(order.getGid(), paymentInstructionDO.getGid());
        assertEquals(order.getPartnerId(), paymentInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), paymentInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), paymentInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), paymentInstructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getPayerUserId(), paymentInstructionDO.getPayerUserId());
        assertEquals(order.getPartnerId(), paymentInstructionDO.getPayeeUserId());
        assertEquals(order.getPayerUserId(), paymentInstructionDO.getPayerAccountNo());
        //关联账户
        assertEquals(order.getAmount().getCent(), paymentInstructionDO.getPayAmount());
        assertEquals(order.getAmount().getCent(), paymentInstructionDO.getRealPayAmount());
        assertEquals("PROCESSING", paymentInstructionDO.getStatus());
        assertEquals("valida_user_success", paymentInstructionDO.getState());
        assertEquals("comn_00_0000", paymentInstructionDO.getCode());
        assertEquals(order.getMemo(), paymentInstructionDO.getMemo());
        assertEquals(order.getExternalMetaData(), paymentInstructionDO.getExternalmetadata());

        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByBizNo(paymentInfo.getBizNo()).get(0);
        assertEquals("PAYMENT", transOrderRecordDO.getTransType());
        assertEquals("BALANCE", transOrderRecordDO.getTransTag());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
        // 清除数据
        payTestBase.cleanPaymentInstructionByPartnerId(order.getPartnerId());
        payTestBase.cleanTransOrderRecordByPartnerId(order.getPartnerId());
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerid传空
     * 1004 merchantOrderNo传空
     * 1007 payerUserId传空
     * 1008 payerUserTag传空
     * 1009 amount传空
     * 1010 amount传0
     */
    @AutoTest(file = "pay/balancePaymentServiceApplyTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void balancePaymentServiceApplyTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            BalancePaymentApplyOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        print(order);
        // 调用接口
        BizResult result = balancePaymentService.apply(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        if (testId <= 1008) {
            assertEquals(bizResult.getMessage(), result.getMessage());
        }
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 付款方会员不存在
     * 1002 付款方账户不存在
     */
    @AutoTest(file = "pay/balancePaymentServiceApplyTestFailTwo.csv")
    @DisplayName("余额支付--失败用例")
    public void balancePaymentServiceApplyTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            BalancePaymentApplyOrder order
    ) {
        // 清除数据
        payTestBase.cleanPaymentInstructionByPartnerId(order.getPartnerId());
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        // 调用接口
        BizResult result = balancePaymentService.apply(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getCode(), result.getCode());
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }
}
