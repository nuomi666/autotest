package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PayTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.enums.CurrencyEnum;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.pay.api.settlement.info.TransferInfo;
import com.xyb.pay.api.settlement.order.TransferOrder;
import com.xyb.pay.api.settlement.service.TransferService;
import dal.model.pay.TransferInstructionDO;
import dal.model.user.AccountDO;
import dal.model.user.AccountFreezeCodeAmountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/10/25.
 */
@DisplayName("单笔转账")
public class TransferServiceTransferTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    TransferService transferService;

    @Autowired
    PayTestBase payTestBase;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 普通单笔转账0.01元
     * 1002 解冻转账1.01元
     * 1003 转账2.01元，收款方冻结2.01元
     * 1004 转账3.01元，收款方冻结1元
     * 1005 解冻转账4.01元，收款方冻结2元
     * 1006 解冻3元转账5.01元，收款方冻结5.01元
     * 1007 同一会员下不同账户之间转账
     * 1008 普通单笔转账0.01元,重复请求
     */
    @AutoTest(file = "pay/transferServiceTransferTestSuccess.csv")
    @DisplayName("单笔转账--成功用例")
    public void transferServiceTransferTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            TransferOrder order,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO
    ) {
        // 清除数据
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(order.getPayerUserTag());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(order.getPayeeUserTag());
        // 准备数据
        long amount = order.getPayAmount().getCent();
        AccountDO payerAccountDO = userTestBase.findAccountByAccountNo(order.getPayerUserTag()).get(0);
        AccountDO payeeAccountDO = userTestBase.findAccountByAccountNo(order.getPayeeUserTag()).get(0);
        if (testId == 1001 || testId == 1008) {
            payerAccountDO.setBalance(payerAccountDO.getBalance() + amount);
            userTestBase.updateAccountByAccountNo(order.getPayerUserId(), payerAccountDO);
        }
        if (testId == 1002) {
            payerAccountDO.setBalance(payerAccountDO.getBalance() + amount);
            payerAccountDO.setFreezeBalance(payerAccountDO.getFreezeBalance() + amount);
            userTestBase.updateAccountByAccountNo(order.getPayerUserId(), payerAccountDO);
            userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        }
        if (testId == 1003) {
            payerAccountDO.setBalance(payerAccountDO.getBalance() + amount);
            userTestBase.updateAccountByAccountNo(order.getPayerUserId(), payerAccountDO);
            userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        }
        if (testId == 1004) {
            payerAccountDO.setBalance(payerAccountDO.getBalance() + amount);
            userTestBase.updateAccountByAccountNo(order.getPayerUserId(), payerAccountDO);
            userTestBase.cleanAccountFreezeCodeAmountByAccountNo(order.getPayeeUserId());
        }
        if (testId == 1005 || testId == 1006 || testId == 1007) {
            payerAccountDO.setBalance(payerAccountDO.getBalance() + amount);
            payerAccountDO.setFreezeBalance(payerAccountDO.getFreezeBalance() + order.getPayerUnFreezeAmount().getCent());
            userTestBase.updateAccountByAccountNo(order.getPayerUserId(), payerAccountDO);
            userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        }
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        if (testId == 1008) {
            transferService.transfer(order);
        }
        // 调用接口
        BizResult<TransferInfo> result = transferService.transfer(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        TransferInstructionDO transferInstructionDO = payTestBase.findTransferInstructionByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
        assertEquals("TRANSFER", transferInstructionDO.getTransType());
        assertEquals("ONLINE", transferInstructionDO.getTransTag());
        assertEquals("NORMAL", transferInstructionDO.getTransferType());
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
        AccountDO payerAccountDO1 = userTestBase.findAccountByAccountNo(order.getPayerUserTag()).get(0);
        AccountDO payeeAccountDO1 = userTestBase.findAccountByAccountNo(order.getPayeeUserTag()).get(0);
        if (testId == 1001 || testId == 1008) {
            //付款方余额减少0.01元，收款方余额增加0.01元，收付款方冻结金额不变
            assertEquals(payerAccountDO.getBalance() - amount, payerAccountDO1.getBalance());
            assertEquals(payerAccountDO.getFreezeBalance(), payerAccountDO1.getFreezeBalance());
            assertEquals(payeeAccountDO.getBalance() + amount, payeeAccountDO1.getBalance());
            assertEquals(payeeAccountDO.getFreezeBalance(), payeeAccountDO1.getFreezeBalance());
        }
        if (testId == 1002) {
            //付款方余额和冻结金额减少1.01元，收款方余额增加1.01元，收款方冻结金额不变
            assertEquals(payerAccountDO.getBalance() - amount, payerAccountDO1.getBalance());
            assertEquals(payerAccountDO.getFreezeBalance() - amount, payerAccountDO1.getFreezeBalance());
            assertEquals(payeeAccountDO.getBalance() + amount, payeeAccountDO1.getBalance());
            assertEquals(payeeAccountDO.getFreezeBalance(), payeeAccountDO1.getFreezeBalance());
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1 = userTestBase.findAccountFreezeCodeAmountByAccountNo(order.getPayerUserId()).get(0);
            assertEquals(accountFreezeCodeAmountDO.getUnfreezeAmount() + amount, accountFreezeCodeAmountDO1.getUnfreezeAmount());
        }
        if (testId == 1003) {
            //付款方余额减少2.01元，付款方冻结金额不变，收款方余额增加2.01元，收款方冻结金额增加2.01元
            assertEquals(payerAccountDO.getBalance() - amount, payerAccountDO1.getBalance());
            assertEquals(payerAccountDO.getFreezeBalance(), payerAccountDO1.getFreezeBalance());
            assertEquals(payeeAccountDO.getBalance() + amount, payeeAccountDO1.getBalance());
            assertEquals(payeeAccountDO.getFreezeBalance() + order.getPayeeFreezeAmount().getCent(), payeeAccountDO1.getFreezeBalance());
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1 = userTestBase.findAccountFreezeCodeAmountByAccountNo(order.getPayeeUserId()).get(0);
            assertEquals(accountFreezeCodeAmountDO.getFreezeAmount() + amount, accountFreezeCodeAmountDO1.getFreezeAmount());
        }
        if (testId == 1004) {
            //付款方余额减少3.01元，付款方冻结金额不变，收款方余额增加3.01元，收款方冻结金额增加1元
            assertEquals(payerAccountDO.getBalance() - amount, payerAccountDO1.getBalance());
            assertEquals(payerAccountDO.getFreezeBalance(), payerAccountDO1.getFreezeBalance());
            assertEquals(payeeAccountDO.getBalance() + amount, payeeAccountDO1.getBalance());
            assertEquals(payeeAccountDO.getFreezeBalance() + order.getPayeeFreezeAmount().getCent(), payeeAccountDO1.getFreezeBalance());
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1 = userTestBase.findAccountFreezeCodeAmountByAccountNo(order.getPayeeUserId()).get(0);
            assertEquals(order.getPayeeFreezeAmount().getCent(), accountFreezeCodeAmountDO1.getFreezeAmount());
        }
        if (testId == 1005) {
            //付款方余额减少4.01元，付款方冻结金额减少4.01元，收款方余额增加4.01元，收款方冻结金额增加2元
            assertEquals(payerAccountDO.getBalance() - amount, payerAccountDO1.getBalance());
            assertEquals(payerAccountDO.getFreezeBalance() - amount, payerAccountDO1.getFreezeBalance());
            assertEquals(payeeAccountDO.getBalance() + amount, payeeAccountDO1.getBalance());
            assertEquals(payeeAccountDO.getFreezeBalance() + order.getPayeeFreezeAmount().getCent(), payeeAccountDO1.getFreezeBalance());
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1 = userTestBase.findAccountFreezeCodeAmountByAccountNo(order.getPayeeUserId()).get(0);
            assertEquals(order.getPayeeFreezeAmount().getCent(), accountFreezeCodeAmountDO1.getFreezeAmount());
            assertEquals(order.getPayeeFreezeCode(), accountFreezeCodeAmountDO1.getFreezeCode());
        }
        if (testId == 1006 || testId == 1007) {
            //付款方余额减少5.01元，付款方冻结金额减少3元，收款方余额增加5.01元，收款方冻结金额增加5.01元
            assertEquals(payerAccountDO.getBalance() - amount, payerAccountDO1.getBalance());
            assertEquals(payerAccountDO.getFreezeBalance() - order.getPayerUnFreezeAmount().getCent(), payerAccountDO1.getFreezeBalance());
            assertEquals(payeeAccountDO.getBalance() + amount, payeeAccountDO1.getBalance());
            assertEquals(payeeAccountDO.getFreezeBalance() + order.getPayeeFreezeAmount().getCent(), payeeAccountDO1.getFreezeBalance());
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1 = userTestBase.findAccountFreezeCodeAmountByAccountNo(order.getPayeeUserTag()).get(0);
            assertEquals(order.getPayeeFreezeAmount().getCent(), accountFreezeCodeAmountDO1.getFreezeAmount());
            assertEquals(order.getPayeeFreezeCode(), accountFreezeCodeAmountDO1.getFreezeCode());
        }
        TransferInfo info = result.getInfo();
        assertEquals(order.getPayerUserId(), info.getPayerUserId());
        assertEquals(order.getPayeeUserId(), info.getPayeeUserId());
        assertEquals(order.getPayAmount(), info.getPayAmount());
        //assertEquals(payeeAccountDO1.getBalance() - payeeAccountDO1.getFreezeBalance(), info.getPayeeBalance().getCent());
        // 清除数据
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(order.getPayerUserId());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(order.getPayeeUserId());
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerId传空
     * 1004 merchOrderNo传空
     * 1007 payeeUserId传空
     * 1008 payeeUserTag传空
     * 1009 payerUserId传空
     * 1010 payerUserTag传空
     * 1011 payAmount传空
     */
    @AutoTest(file = "pay/transferServiceTransferTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void transferServiceTransferTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            TransferOrder order,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult result = transferService.transfer(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 付款方不存在
     * 1002 收款方不存在
     * 1003 付款方余额不足
     * 1004 付款方解冻余额不足
     * 1005 付款方未冻结余额
     * 1006 收款方冻结金额大于收款金额
     * 1007 收付款方账户相同
     * 1008 付款方余额不足，重复请求
     */
    @AutoTest(file = "pay/transferServiceTransferTestFailTwo.csv")
    @DisplayName("单笔转账失败--失败用例")
    public void transferServiceTransferTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            TransferOrder order,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO
    ) {
        // 清除数据
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountFreezeCodeAmountDO.getAccountNo());
        // 准备数据
        long amount = order.getPayAmount().getCent();
        AccountDO payerAccountDO = null;
        AccountDO payeeAccountDO = null;
        if (testId >= 1003) {
            payerAccountDO = userTestBase.findAccountByAccountNo(order.getPayerUserId()).get(0);
            payeeAccountDO = userTestBase.findAccountByAccountNo(order.getPayeeUserId()).get(0);
            payerAccountDO.setBalance(payerAccountDO.getBalance() + amount);
            payerAccountDO.setFreezeBalance(payerAccountDO.getFreezeBalance() + amount);
            userTestBase.updateAccountByAccountNo(order.getPayerUserId(), payerAccountDO);
        }
        if (testId == 1003 || testId == 1008) {
            order.setPayAmount(new Money(payerAccountDO.getBalance() + 1, CurrencyEnum.CNY));
        }
        if (testId == 1004) {
            userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        }
        if (testId == 1006) {
            payerAccountDO.setBalance(payerAccountDO.getBalance() + amount);
            userTestBase.updateAccountByAccountNo(order.getPayerUserId(), payerAccountDO);
            payeeAccountDO.setBalance(0L);
            payeeAccountDO.setFreezeBalance(0L);
            userTestBase.updateAccountByAccountNo(order.getPayeeUserId(), payeeAccountDO);
        }
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        if (testId == 1008) {
            transferService.transfer(order);
        }
        // 调用接口
        BizResult result = transferService.transfer(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId != 1007) {
            TransferInstructionDO transferInstructionDO = payTestBase.findTransferInstructionByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
            assertEquals("TRANSFER", transferInstructionDO.getTransType());
            assertEquals("ONLINE", transferInstructionDO.getTransTag());
            assertEquals("NORMAL", transferInstructionDO.getTransferType());
            //assertEquals("", transferInstructionDO.getBizNo());
            assertEquals(order.getReqId(), transferInstructionDO.getReqId());
            assertEquals(order.getGid(), transferInstructionDO.getGid());
            assertEquals(order.getPartnerId(), transferInstructionDO.getPartnerId());
            assertEquals(order.getMerchantOrderNo(), transferInstructionDO.getMerchantOrderNo());
            assertEquals(order.getPlatPartnerId(), transferInstructionDO.getPlatPartnerId());
            assertEquals(order.getPlatMerchantOrderNo(), transferInstructionDO.getPlatMerchantOrderNo());
            assertEquals("FAIL", transferInstructionDO.getStatus());
            if (testId <= 1002) {
                assertEquals("user_valida_fail", transferInstructionDO.getState());
            } else {
                assertEquals("transfer_account_fail", transferInstructionDO.getState());
            }
            //余额验证
            AccountDO payerAccountDO1 = null;
            AccountDO payeeAccountDO1 = null;
            if (testId >= 1003) {
                payerAccountDO1 = userTestBase.findAccountByAccountNo(order.getPayerUserId()).get(0);
                payeeAccountDO1 = userTestBase.findAccountByAccountNo(order.getPayeeUserId()).get(0);
                assertEquals(payerAccountDO, payerAccountDO1);
                assertEquals(payeeAccountDO, payeeAccountDO1);
            }
        }
        // 清除数据
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(order.getPayerUserId());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(order.getPayeeUserId());
    }
}
