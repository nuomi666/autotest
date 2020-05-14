//package com.xjy.autotest.pay;
//
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.testbase.PayTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.pay.api.settlement.info.PaymentInfo;
//import dal.model.pay.PaymentInstructionDO;
//import dal.model.pay.TransOrderRecordDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import com.alibaba.dubbo.config.annotation.Reference;
//
//import java.util.*;
//
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.pay.api.settlement.service.BalancePaymentService;
//import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentApplyOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.lang.String;
//
//
///**
// * @author huairen
// * Created on 2019/06/24.
// */
//public class BalancePaymentServiceDirectPayTest extends SpringBootTestBase {
//
//    @Reference(version = DUBBO_VERSION)
//    BalancePaymentService balancePaymentService;
//
//    @Autowired
//    PayTestBase payTestBase;
//
//    @Autowired
//    UserTestBase userTestBase;
//
//    /**
//     * 1001 免密余额支付,付款人支付101
//     * 1002 免密余额支付,同一商户下不同账户支付102
//     * 1003 免密余额支付,重复请求
//     */
//    @AutoTest(file = "pay/balancePaymentServiceDirectPayTestSuccess.csv")
//    @DisplayName("免密余额支付--成功用例")
//    public void balancePaymentServiceDirectPayTestSuccess(
//            // 基本参数
//            int testId,
//            // 业务参数
//            BizResult bizResult,
//            BalancePaymentApplyOrder order
//    ) {
//        // 清除数据
//        payTestBase.cleanTransOrderRecordByMerchantOrderNo(order.getMerchantOrderNo());
//        payTestBase.cleanTransferInstructionByMerchantOrderNo(order.getMerchantOrderNo());
//        // 准备数据
//        //付款方账务余额
//        AccountDO payerAccountDO = userTestBase.findAccountByUserIdAndTag(order.getPayerUserId(), order.getPayerUserTag()).get(0);
//        payerAccountDO.setBalance(payerAccountDO.getBalance() + order.getAmount().getCent());
//        userTestBase.updateAccountByUserIdAndTag(order.getPayerUserId(), order.getPayerUserTag(), payerAccountDO);
//        // 测试过程
//        if (testId == 1003) {
//            balancePaymentService.directPay(order);
//        }
//        // 调用接口
//        BizResult<PaymentInfo> result = balancePaymentService.directPay(order);
//        // 结果验证
//        print(result);
//        assertEquals(bizResult.getCode(), result.getCode());
//        assertEquals(bizResult.getStatus(), result.getStatus());
//        assertFalse(result.toString().contains("privateKey"));
//        // 数据验证
//        PaymentInfo paymentInfo = result.getInfo();
//        PaymentInstructionDO paymentInstructionDO = payTestBase.findPaymentInstructionByReqId(order.getReqId()).get(0);
//        assertEquals("PAYMENT", paymentInstructionDO.getTransType());
//        assertEquals("BALANCE", paymentInstructionDO.getTransTag());
//        assertEquals(paymentInfo.getBizNo(), paymentInstructionDO.getBizNo());
//        assertEquals(order.getGid(), paymentInstructionDO.getGid());
//        assertEquals(order.getPartnerId(), paymentInstructionDO.getPartnerId());
//        assertEquals(order.getMerchantOrderNo(), paymentInstructionDO.getMerchantOrderNo());
//        assertEquals(order.getPlatPartnerId(), paymentInstructionDO.getPlatPartnerId());
//        assertEquals(order.getPlatMerchantOrderNo(), paymentInstructionDO.getPlatMerchantOrderNo());
//        assertEquals(order.getPayerUserId(), paymentInstructionDO.getPayerUserId());
//        assertEquals(order.getPartnerId(), paymentInstructionDO.getPayeeUserId());
//        assertEquals(payerAccountDO.getAccountNo(), paymentInstructionDO.getPayerAccountNo());
//        //关联账户
//        assertEquals(order.getAmount().getCent(), paymentInstructionDO.getPayAmount());
//        assertEquals(order.getAmount().getCent(), paymentInstructionDO.getRealPayAmount());
//        assertEquals("SUCCESS", paymentInstructionDO.getStatus());
//        assertEquals("finished", paymentInstructionDO.getState());
//        assertEquals("comn_00_0000", paymentInstructionDO.getCode());
//        assertEquals(order.getMemo(), paymentInstructionDO.getMemo());
//        assertEquals(order.getExternalMetaData(), paymentInstructionDO.getExternalmetadata());
//
//        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByBizNo(paymentInfo.getBizNo()).get(0);
//        assertEquals("PAYMENT", transOrderRecordDO.getTransType());
//        assertEquals("BALANCE", transOrderRecordDO.getTransTag());
//        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
//        assertEquals(order.getGid(), transOrderRecordDO.getGid());
//        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
//        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
//        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
//        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
//        //账务验证
//        AccountDO payerAccountAfter = userTestBase.findAccountByUserIdAndTag(order.getPayerUserId(), order.getPayerUserTag()).get(0);
//        assertEquals(payerAccountDO.getBalance() - paymentInstructionDO.getPayAmount(), payerAccountAfter.getBalance());
//        //余额验证
//        Money balance = result.getInfo().getBalance();
//        assertEquals(balance.getCent(), payerAccountAfter.getBalance() - payerAccountAfter.getFreezeBalance());
//        assertEquals(balance.getCent(), paymentInstructionDO.getPayerBalance());
//        // 清除数据
//        payTestBase.cleanPaymentInstructionByMerchantOrderNo(order.getMerchantOrderNo());
//        payTestBase.cleanTransOrderRecordByMerchantOrderNo(order.getMerchantOrderNo());
//    }
//
//    /**
//     * 1001 免密余额支付,付款人余额不足
//     * 1002 免密余额支付,付款人可用余额不足
//     * 1003 免密余额支付,付款人账户不存在
//     */
//    @AutoTest(file = "pay/balancePaymentServiceDirectPayTestFailTwo.csv")
//    @DisplayName("免密余额支付--失败用例")
//    public void balancePaymentServiceDirectPayTestFailTwo(
//            // 基本参数
//            int testId,
//            // 业务参数
//            BizResult bizResult,
//            BalancePaymentApplyOrder order
//    ) {
//        // 清除数据
//        // 准备数据
//        //付款方账务余额
//        AccountDO payerAccountDO = null;
//        if (testId <= 1002) {
//            payerAccountDO = userTestBase.findAccountByUserIdAndTag(order.getPayerUserId(), order.getPayerUserTag()).get(0);
//            if (testId == 1001) {
//                payerAccountDO.setBalance(order.getAmount().getCent() - 1L);
//            }
//            if (testId == 1002) {
//                payerAccountDO.setBalance(order.getAmount().getCent());
//                payerAccountDO.setFreezeBalance(1L);
//            }
//            userTestBase.updateAccountByUserIdAndTag(order.getPayerUserId(), order.getPayerUserTag(), payerAccountDO);
//        }
//        // 测试过程
//        // 调用接口
//        BizResult<PaymentInfo> result = balancePaymentService.directPay(order);
//        // 结果验证
//        print(result);
//        assertEquals(bizResult.getCode(), result.getCode());
//        assertEquals(bizResult.getStatus(), result.getStatus());
//        assertFalse(result.toString().contains("privateKey"));
//        if (testId <= 1002) {
//            AccountDO payerAccountAfter = userTestBase.findAccountByUserIdAndTag(order.getPayerUserId(), order.getPayerUserTag()).get(0);
//            assertEquals(payerAccountDO, payerAccountAfter);
//        }
//    }
//
//}
