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
import com.xyb.pay.api.settlement.info.BatchTransferInfo;
import com.xyb.pay.api.settlement.order.transfer.BatchTranferOrder;
import com.xyb.pay.api.settlement.service.TransferService;
import dal.model.pay.TransferInstructionDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author ychaoyang
 * Created on 2018/08/29.
 */
public class TransferServiceBatchTransferTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    TransferService transferService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 单笔转账
     * 1002 2笔转账
     * 1003 5笔转账
     */
    @AutoTest(file = "pay/transferServiceBatchTransferTestSuccess.csv")
    @DisplayName("批量转账--成功用例")
    public void transferServiceBatchTransferTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BatchTranferOrder order,
            BatchTransferInfo batInfo,
            BatchTransferInfo batInfo1
    ) {
        // 清除数据
        // 准备数据
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        //转账前余额
        AccountDO payerAccountDO = userTestBase.findAccountByUserId(batInfo.getPayerUserId()).stream().filter(
                (acc) -> (batInfo.getPayerUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO payeeAccountDO = userTestBase.findAccountByUserId(batInfo.getPayeeUserId()).stream().filter(
                (acc) -> (batInfo.getPayeeUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO payerAccountDO1 = userTestBase.findAccountByUserId(batInfo1.getPayerUserId()).stream().filter(
                (acc) -> (batInfo1.getPayerUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO payeeAccountDO1 = userTestBase.findAccountByUserId(batInfo1.getPayeeUserId()).stream().filter(
                (acc) -> (batInfo1.getPayeeUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        // 测试过程
        List<BatchTransferInfo> infos = new ArrayList<BatchTransferInfo>();
        infos.add(batInfo);
        if (testId == 1001) {
            payerAccountDO.setBalance(payerAccountDO.getBalance() + batInfo.getAmount().getCent());
            userTestBase.updateAccountByAccountNo(batInfo.getPayerUserId(), payerAccountDO);
        }
        if (testId == 1002) {
            infos.add(batInfo1);
            payerAccountDO.setBalance(payerAccountDO.getBalance() + batInfo.getAmount().getCent() + batInfo1.getAmount().getCent());
            userTestBase.updateAccountByAccountNo(batInfo.getPayerUserId(), payerAccountDO);
        }
        if (testId == 1003) {
            infos.add(batInfo);
            infos.add(batInfo);
            infos.add(batInfo1);
            infos.add(batInfo1);
            payerAccountDO.setBalance(payerAccountDO.getBalance() + batInfo.getAmount().getCent() * 3 + batInfo1.getAmount().getCent() * 2);
            userTestBase.updateAccountByAccountNo(batInfo.getPayerUserId(), payerAccountDO);
        }
        order.setInfos(infos);
        // 调用接口
        BizResult result = transferService.batchTransfer(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        TransferInstructionDO transferInstructionDO = payTestBase.findTransferInstructionByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
        assertEquals("TRANSFER", transferInstructionDO.getTransType());
        assertEquals("ONLINE", transferInstructionDO.getTransTag());
        assertEquals("BATCH", transferInstructionDO.getTransferType());
        //assertEquals("", transferInstructionDO.getBizNo());
        assertEquals(order.getReqId(), transferInstructionDO.getReqId());
        assertEquals(order.getGid(), transferInstructionDO.getGid());
        assertEquals(order.getPartnerId(), transferInstructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), transferInstructionDO.getMerchantOrderNo());
        assertEquals(order.getPlatPartnerId(), transferInstructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), transferInstructionDO.getPlatMerchantOrderNo());
        assertEquals("SUCCESS", transferInstructionDO.getStatus());
        assertEquals("finished", transferInstructionDO.getState());
        //余额验证
        AccountDO payerAccount = userTestBase.findAccountByUserId(batInfo.getPayerUserId()).stream().filter(
                (acc) -> (batInfo.getPayerUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO payeeAccount = userTestBase.findAccountByUserId(batInfo.getPayeeUserId()).stream().filter(
                (acc) -> (batInfo.getPayeeUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO payerAccount1 = userTestBase.findAccountByUserId(batInfo1.getPayerUserId()).stream().filter(
                (acc) -> (batInfo1.getPayerUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        AccountDO payeeAccount1 = userTestBase.findAccountByUserId(batInfo1.getPayeeUserId()).stream().filter(
                (acc) -> (batInfo1.getPayeeUserTag().equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        if (testId == 1001) {
            assertEquals(payerAccountDO.getBalance() - batInfo.getAmount().getCent(), payerAccount.getBalance());
            assertEquals(payeeAccountDO.getBalance() + batInfo.getAmount().getCent(), payeeAccount.getBalance());
        }
        if (testId == 1002) {
            assertEquals(payerAccountDO.getBalance() - batInfo.getAmount().getCent() - batInfo1.getAmount().getCent(), payerAccount.getBalance());
            assertEquals(payeeAccountDO.getBalance() + batInfo.getAmount().getCent(), payeeAccount.getBalance());
            assertEquals(payeeAccountDO1.getBalance() + batInfo1.getAmount().getCent(), payeeAccount1.getBalance());
        }
        if (testId == 1003) {
            long allAmount = batInfo.getAmount().getCent() * 3 + batInfo1.getAmount().getCent() * 2;
            assertEquals(payerAccountDO.getBalance() - allAmount, payerAccount.getBalance());
            assertEquals(payeeAccountDO.getBalance() + batInfo.getAmount().getCent() * 3, payeeAccount.getBalance());
            assertEquals(payeeAccountDO1.getBalance() + batInfo1.getAmount().getCent() * 2, payeeAccount1.getBalance());
        }
        // 清除数据
    }

    /**
     * 1001 余额不足
     * 1002 付款方userId不存在
     * 1003 付款方tag不存在
     * 1004 收款方userId不存在
     * 1005 收款方tag不存在
     */
    @AutoTest(file = "pay/transferServiceBatchTransferTestFailTwo.csv")
    @DisplayName("转账失败--失败用例")
    public void transferServiceBatchTransferTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BatchTranferOrder order,
            BatchTransferInfo batInfo,
            BatchTransferInfo batInfo1
    ) {
        // 清除数据
        // 准备数据
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        print(order);
        //转账前余额
        // 测试过程
        List<BatchTransferInfo> infos = new ArrayList<BatchTransferInfo>();
        infos.add(batInfo);
        infos.add(batInfo1);
        order.setInfos(infos);
        // 调用接口
        BizResult result = transferService.batchTransfer(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
