package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.pay.api.settlement.info.PaymentInfo;
import com.xyb.pay.api.settlement.info.RefundInfo;
import com.xyb.pay.api.settlement.order.AccountPaymentOrder;
import com.xyb.pay.api.settlement.order.RefundOrder;
import com.xyb.pay.api.settlement.service.AccountPaymentService;
import com.xyb.pay.api.settlement.service.RefundService;
import dal.model.pay.RefundInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;


/**
 * @author ychaoyang
 * Created on 2018/07/27.
 */
public class RefundServiceOfflineDepositRefundTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    RefundService refundService;

    @Reference(version = DUBBO_VERSION)
    AccountPaymentService accountPaymentService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;


    /**
     * 1001 线下充值退款
     */
    @AutoTest(file = "pay/refundServiceOfflineDepositRefundTestSuccess.csv")
    @DisplayName("线下充值退款--成功用例")
    public void refundServiceOfflineDepositRefundTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            RefundOrder order,
            //充值
            AccountPaymentOrder depositOrder
    ) {
        // 清除数据
        // 准备数据
        //账务余额
        AccountDO PayeeAccountDO = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        AccountDO relationAccountDO = userTestBase.findAccountByUserId(depositOrder.getPartnerId()).stream().filter(
                (acc) -> ("balance".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO refundAccountDO = userTestBase.findAccountByUserId(depositOrder.getPartnerId()).stream().filter(
                (acc) -> ("refund".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        // 测试过程
        depositOrder.setReqId(OID.newID());
        depositOrder.setGid(GID.newGID());
        depositOrder.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(depositOrder);
        // 调用接口
        BizResult<PaymentInfo> result1 = accountPaymentService.chargePay(depositOrder);
        print(result1);
        String bizNo = result1.getInfo().getBizNo();
        //账务余额
        AccountDO PayeeAccountDO1 = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        //AccountDO relationAccountDO1 = userTestBase.findAccountByUserId(depositOrder.getPartnerId()).stream().filter(
        //        (acc) -> ("balance".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        assertEquals(PayeeAccountDO.getBalance() + depositOrder.getPayAmount().getCent(), PayeeAccountDO1.getBalance());
        //assertEquals(relationAccountDO.getBalance() + depositOrder.getPayAmount().getCent(), relationAccountDO1.getBalance());
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setBizNo(bizNo);
        order.setRefundAmount(depositOrder.getPayAmount());
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
        //账务余额
        AccountDO PayeeAccountDO2 = userTestBase.findAccountByAccountNo(depositOrder.getPayeeUserId()).get(0);
        AccountDO relationAccountDO2 = userTestBase.findAccountByUserId(depositOrder.getPartnerId()).stream().filter(
                (acc) -> ("refund".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO refundAccountDO2 = userTestBase.findAccountByUserId(depositOrder.getPartnerId()).stream().filter(
                (acc) -> ("refund".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        assertEquals(PayeeAccountDO.getBalance() , PayeeAccountDO2.getBalance());
        //assertEquals(refundAccountDO.getBalance() + depositOrder.getDepositAmount().getCent(), refundAccountDO2.getBalance());
        // 清除数据
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
        assertEquals(bizNo, refundInstructionDO.getPaymentBizNo());
        //assertEquals(depositOrder.getPayeeUserId(), refundInstructionDO.getPayeeUserId());
        assertEquals(depositOrder.getPayAmount().getCent(), refundInstructionDO.getPayAmount());
        assertEquals(order.getRefundAmount().getCent(), refundInstructionDO.getRefundAmount());
        assertEquals("SUCCESS", refundInstructionDO.getStatus());
        assertEquals("finished", refundInstructionDO.getState());

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
    }
}
