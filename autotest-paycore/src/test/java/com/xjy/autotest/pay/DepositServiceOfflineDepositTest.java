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
import com.xyb.pay.api.settlement.order.AccountPaymentOrder;
import com.xyb.pay.api.settlement.service.AccountPaymentService;
import dal.model.pay.DepositInstructionDO;
import dal.model.pay.TransOrderRecordDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;


/**
 * @author ychaoyang
 * Created on 2018/07/11.
 */
public class DepositServiceOfflineDepositTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountPaymentService accountPaymentService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 线下充值1.1元
     * 1002 线下充值100元
     * 1003 重复请求
     */
    @AutoTest(file = "pay/depositServiceOfflineDepositTestSuccess.csv")
    @DisplayName("线下充值--成功用例")
    public void depositServiceOfflineDepositTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            AccountPaymentOrder order
    ) {
        // 清除数据
        payTestBase.cleanDepositInstructionByPartnerId(order.getPartnerId());
        // 准备数据
        //账务余额
        AccountDO PayeeAccountDO = userTestBase.findAccountByAccountNo(order.getPayeeUserId()).get(0);
        AccountDO relationAccountDO = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter(
                (acc) -> ("balance".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        if (testId == 1003) {
            accountPaymentService.chargePay(order);
        }
        // 调用接口
        BizResult<PaymentInfo> result = accountPaymentService.chargePay(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        assertEquals(order.getMerchantOrderNo(), result.getInfo().getMerchantOrderNo());
        // 数据验证
        DepositInstructionDO depositInstructionDO = payTestBase.findDepositInstructionByReqId(order.getReqId()).get(0);
        print(depositInstructionDO);
        assertEquals("DEPOSIT", depositInstructionDO.getTransType());
        assertEquals("OFFLINE", depositInstructionDO.getTransTag());
        assertEquals(result.getInfo().getBizNo(), depositInstructionDO.getBizNo());
        assertEquals(order.getReqId(), depositInstructionDO.getReqId());
        assertEquals(order.getGid(), depositInstructionDO.getGid());
        assertEquals(order.getPartnerId(), depositInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), depositInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), depositInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), depositInstructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getPayeeUserId(), depositInstructionDO.getPayeeUserId());
        //assertEquals(order.getPayeeUserId(), depositInstructionDO.getAccountNo());
        //assertEquals(relationAccountDO.getAccountNo(), depositInstructionDO.getLinkAccountNo());
        assertEquals(order.getPayAmount().getCent(), depositInstructionDO.getPayAmount());
        assertEquals(order.getPayAmount().getCent(), depositInstructionDO.getRealPayAmount());
        assertEquals("SUCCESS", depositInstructionDO.getStatus());
        assertEquals("finished", depositInstructionDO.getState());
        assertEquals(order.getMemo(), depositInstructionDO.getMemo());
        assertEquals(order.getExternalMetaData(), depositInstructionDO.getExternalmetadata());

        TransOrderRecordDO transOrderRecordDO = payTestBase.findTransOrderRecordByReqId(order.getReqId()).get(0);
        assertEquals("DEPOSIT", transOrderRecordDO.getTransType());
        assertEquals("OFFLINE", transOrderRecordDO.getTransTag());
        assertEquals(depositInstructionDO.getBizNo(), transOrderRecordDO.getBizNo());
        assertEquals(order.getReqId(), transOrderRecordDO.getReqId());
        assertEquals(order.getGid(), transOrderRecordDO.getGid());
        assertEquals(order.getPartnerId(), transOrderRecordDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transOrderRecordDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transOrderRecordDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transOrderRecordDO.getPlatMerchantOrderNo());
        //账务余额
        AccountDO payeeAccountDO1 = userTestBase.findAccountByAccountNo(order.getPayeeUserId()).get(0);
        //AccountDO relationAccountDO1 = userTestBase.findAccountByUserId(order.getPartnerId()).stream().filter(
        //        (acc) -> ("balance".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        assertEquals(PayeeAccountDO.getBalance() + order.getPayAmount().getCent(), payeeAccountDO1.getBalance());
        //assertEquals(relationAccountDO.getBalance() + order.getPayAmount().getCent(), relationAccountDO1.getBalance());
        if (testId != 1003) {
            assertEquals(result.getInfo().getBalance().getCent(), payeeAccountDO1.getBalance() - payeeAccountDO1.getFreezeBalance());
        }
        // 清除数据
        payTestBase.cleanDepositInstructionByReqId(order.getReqId());
    }

    /**
     * 1001 userId不存在
     */
    @AutoTest(file = "pay/depositServiceOfflineDepositTestFailTwo.csv")
    @DisplayName("线下充值失败--失败用例")
    public void depositServiceOfflineDepositTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            BizResult bizResult,
            AccountPaymentOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        // 调用接口
        BizResult<PaymentInfo> result = accountPaymentService.chargePay(order);
        // 结果验证
        print(result);
        assertEquals(bizResult.getStatus(), result.getStatus());
        assertEquals(bizResult.getCode(), result.getCode());
        assertFalse(result.toString().contains("privateKey"));
        // 数据验证
        // 清除数据
    }

}
