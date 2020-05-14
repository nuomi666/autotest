package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import dal.model.user.AccountBatchLogDO;
import dal.model.user.AccountDO;
import dal.model.user.AccountFreezeCodeAmountDO;
import dal.model.user.AccountFreezeLogDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountTransService;
import com.xyb.user.api.order.account.AccountBatchFreezeOrUnFreezeOrder;
import com.xyb.user.api.order.account.AccountBaseFreezeOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/05/31.
 */
public class AccountTransServiceBatchFreezeOrUnFreezeBalanceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 批量冻结一个账户余额
     * 1002 批量冻结3个账户余额
     * 1003 批量冻结3个账户余额,重复请求
     * 1004 批量解冻一个账户余额
     * 1005 批量解冻3个账户余额
     * 1006 批量解冻3个账户余额,重复请求
     */
    @AutoTest(file = "user/accountTransServiceBatchFreezeOrUnFreezeBalanceTestSuccess.csv")
    @DisplayName("批量账户余额冻结/解冻--成功用例")
    public void accountTransServiceBatchFreezeOrUnFreezeBalanceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountBatchFreezeOrUnFreezeOrder accountBatchFreezeOrUnFreezeOrder,
            AccountBaseFreezeOrder accountBaseFreezeOrder,
            AccountBaseFreezeOrder accountBaseFreezeOrder1,
            AccountBaseFreezeOrder accountBaseFreezeOrder2,
            //数据准备
            AccountDO accountDO,
            AccountDO accountDO1,
            AccountDO accountDO2,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO2
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO2.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccount(accountDO2);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO1);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO2);
        // 测试过程
        List<AccountBaseFreezeOrder> orders = new ArrayList<AccountBaseFreezeOrder>();
        orders.add(accountBaseFreezeOrder);
        if (testId != 1001 && testId != 1004) {
            orders.add(accountBaseFreezeOrder1);
            orders.add(accountBaseFreezeOrder2);
        }
        accountBatchFreezeOrUnFreezeOrder.setOrders(orders);
        if (testId == 1003 || testId == 1006) {
            accountTransService.batchFreezeOrUnFreezeBalance(accountBatchFreezeOrUnFreezeOrder);
        }
        // 调用接口
        BizResult result = accountTransService.batchFreezeOrUnFreezeBalance(accountBatchFreezeOrUnFreezeOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        AccountBatchLogDO accountBatchLogDO = userTestBase.findAccountBatchLogByReqId(accountBatchFreezeOrUnFreezeOrder.getReqId()).get(0);
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getGid(), accountBatchLogDO.getGid());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getReqId(), accountBatchLogDO.getReqId());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getPartnerId(), accountBatchLogDO.getPartnerId());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatPartnerId(), accountBatchLogDO.getPlatPartnerId());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getMerchantOrderNo(), accountBatchLogDO.getMerchantOrderNo());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatMerchantOrderNo(), accountBatchLogDO.getPlatMerchantOrderNo());

        AccountDO accDO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        AccountDO accDO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);
        AccountDO accDO2 = userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0);
        assertEquals(accountDO.getBalance(), accDO.getBalance());
        if (testId <= 1003) {
            assertEquals(accountDO.getFreezeBalance() + accountBaseFreezeOrder.getAmount().getCent(), accDO.getFreezeBalance());
        }
        if (testId >= 1004) {
            assertEquals(accountDO.getFreezeBalance() - accountBaseFreezeOrder.getAmount().getCent(), accDO.getFreezeBalance());
        }
        if (testId == 1001 || testId == 1004) {
            assertEquals(accountDO1, accDO1);
            assertEquals(accountDO2, accDO2);
        }
        if (testId == 1002 || testId == 1003) {
            assertEquals(accountDO1.getBalance(), accDO1.getBalance());
            assertEquals(accountDO1.getFreezeBalance() + accountBaseFreezeOrder1.getAmount().getCent(), accDO1.getFreezeBalance());
            assertEquals(accountDO2.getBalance(), accDO2.getBalance());
            assertEquals(accountDO2.getFreezeBalance() + accountBaseFreezeOrder2.getAmount().getCent(), accDO2.getFreezeBalance());
        }
        if (testId == 1005 || testId == 1006) {
            assertEquals(accountDO1.getBalance(), accDO1.getBalance());
            assertEquals(accountDO1.getFreezeBalance() - accountBaseFreezeOrder1.getAmount().getCent(), accDO1.getFreezeBalance());
            assertEquals(accountDO2.getBalance(), accDO2.getBalance());
            assertEquals(accountDO2.getFreezeBalance() - accountBaseFreezeOrder2.getAmount().getCent(), accDO2.getFreezeBalance());
        }
        AccountFreezeCodeAmountDO accFreezeDO = null;
        AccountFreezeCodeAmountDO accFreezeDO1 = null;
        AccountFreezeCodeAmountDO accFreezeDO2 = null;
        accFreezeDO = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo()).get(0);
        if (testId >= 1002) {
            accFreezeDO1 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo()).get(0);
            accFreezeDO2 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo()).get(0);
        }
        if (testId <= 1003) {
            assertEquals(accountFreezeCodeAmountDO.getFreezeAmount() + accountBaseFreezeOrder.getAmount().getCent(), accFreezeDO.getFreezeAmount());
            assertEquals(accountFreezeCodeAmountDO.getUnfreezeAmount(), accFreezeDO.getUnfreezeAmount());
            if (testId == 1002 || testId == 1003) {
                assertEquals(accountFreezeCodeAmountDO1.getFreezeAmount() + accountBaseFreezeOrder1.getAmount().getCent(), accFreezeDO1.getFreezeAmount());
                assertEquals(accountFreezeCodeAmountDO2.getFreezeAmount() + accountBaseFreezeOrder2.getAmount().getCent(), accFreezeDO2.getFreezeAmount());
                assertEquals(accountFreezeCodeAmountDO1.getUnfreezeAmount(), accFreezeDO1.getUnfreezeAmount());
                assertEquals(accountFreezeCodeAmountDO2.getUnfreezeAmount(), accFreezeDO2.getUnfreezeAmount());
            }
        }
        if (testId >= 1004) {
            assertEquals(accountFreezeCodeAmountDO.getFreezeAmount(), accFreezeDO.getFreezeAmount());
            assertEquals(accountFreezeCodeAmountDO.getUnfreezeAmount() + accountBaseFreezeOrder.getAmount().getCent(), accFreezeDO.getUnfreezeAmount());
            if (testId == 1005 || testId == 1006) {
                assertEquals(accountFreezeCodeAmountDO1.getFreezeAmount(), accFreezeDO1.getFreezeAmount());
                assertEquals(accountFreezeCodeAmountDO2.getFreezeAmount(), accFreezeDO2.getFreezeAmount());
                assertEquals(accountFreezeCodeAmountDO1.getUnfreezeAmount() + accountBaseFreezeOrder1.getAmount().getCent(), accFreezeDO1.getUnfreezeAmount());
                assertEquals(accountFreezeCodeAmountDO2.getUnfreezeAmount() + accountBaseFreezeOrder2.getAmount().getCent(), accFreezeDO2.getUnfreezeAmount());
            }
        }

        AccountFreezeLogDO accountFreezeLogDO = userTestBase.findAccountFreezeLogByReqId(accountBaseFreezeOrder.getReqId()).get(0);
        assertEquals(accountBaseFreezeOrder.getAmount().getCent(), accountFreezeLogDO.getAmount());
        assertEquals(accountBaseFreezeOrder.getAccountNo(), accountFreezeLogDO.getAccountNo());
        assertEquals(accountBaseFreezeOrder.getFreezeCode().code(), accountFreezeLogDO.getFreezeCode());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getFreezeType().code(), accountFreezeLogDO.getFreezeType());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getGid(), accountFreezeLogDO.getGid());
        assertEquals(accountBaseFreezeOrder.getReqId(), accountFreezeLogDO.getReqId());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getPartnerId(), accountFreezeLogDO.getPartnerId());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatPartnerId(), accountFreezeLogDO.getPlatPartnerId());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getMerchantOrderNo(), accountFreezeLogDO.getMerchantOrderNo());
        assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatMerchantOrderNo(), accountFreezeLogDO.getPlatMerchantOrderNo());
        if (testId <= 1003) {
            assertEquals(accountDO.getFreezeBalance() + accountBaseFreezeOrder.getAmount().getCent(), accountFreezeLogDO.getFreezeBalance());
        }
        if (testId >= 1004) {
            assertEquals(accountDO.getFreezeBalance() - accountBaseFreezeOrder.getAmount().getCent(), accountFreezeLogDO.getFreezeBalance());
        }
        if (testId != 1001 && testId != 1004) {
            AccountFreezeLogDO accountFreezeLogDO1 = userTestBase.findAccountFreezeLogByReqId(accountBaseFreezeOrder1.getReqId()).get(0);
            assertEquals(accountBaseFreezeOrder1.getAmount().getCent(), accountFreezeLogDO1.getAmount());
            assertEquals(accountDO1.getAccountNo(), accountFreezeLogDO1.getAccountNo());
            assertEquals(accountBaseFreezeOrder1.getFreezeCode().code(), accountFreezeLogDO1.getFreezeCode());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getFreezeType().code(), accountFreezeLogDO1.getFreezeType());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getGid(), accountFreezeLogDO1.getGid());
            assertEquals(accountBaseFreezeOrder1.getReqId(), accountFreezeLogDO1.getReqId());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getPartnerId(), accountFreezeLogDO1.getPartnerId());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatPartnerId(), accountFreezeLogDO1.getPlatPartnerId());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getMerchantOrderNo(), accountFreezeLogDO1.getMerchantOrderNo());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatMerchantOrderNo(), accountFreezeLogDO1.getPlatMerchantOrderNo());
            AccountFreezeLogDO accountFreezeLogDO2 = userTestBase.findAccountFreezeLogByReqId(accountBaseFreezeOrder2.getReqId()).get(0);
            assertEquals(accountBaseFreezeOrder2.getAmount().getCent(), accountFreezeLogDO2.getAmount());
            assertEquals(accountDO2.getAccountNo(), accountFreezeLogDO2.getAccountNo());
            assertEquals(accountBaseFreezeOrder2.getFreezeCode().code(), accountFreezeLogDO2.getFreezeCode());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getFreezeType().code(), accountFreezeLogDO2.getFreezeType());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getGid(), accountFreezeLogDO2.getGid());
            assertEquals(accountBaseFreezeOrder2.getReqId(), accountFreezeLogDO2.getReqId());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getPartnerId(), accountFreezeLogDO2.getPartnerId());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatPartnerId(), accountFreezeLogDO2.getPlatPartnerId());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getMerchantOrderNo(), accountFreezeLogDO2.getMerchantOrderNo());
            assertEquals(accountBatchFreezeOrUnFreezeOrder.getPlatMerchantOrderNo(), accountFreezeLogDO2.getPlatMerchantOrderNo());
            if (testId <= 1003) {
                assertEquals(accountDO1.getFreezeBalance() + accountBaseFreezeOrder1.getAmount().getCent(), accountFreezeLogDO1.getFreezeBalance());
                assertEquals(accountDO2.getFreezeBalance() + accountBaseFreezeOrder2.getAmount().getCent(), accountFreezeLogDO2.getFreezeBalance());
            }
            if (testId >= 1004) {
                assertEquals(accountDO1.getFreezeBalance() - accountBaseFreezeOrder1.getAmount().getCent(), accountFreezeLogDO1.getFreezeBalance());
                assertEquals(accountDO2.getFreezeBalance() - accountBaseFreezeOrder2.getAmount().getCent(), accountFreezeLogDO2.getFreezeBalance());
            }

        }
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo());
    }

    /**
     * 1001 批量冻结一个账户余额不足
     * 1002 批量冻结其中一个账户余额不足
     * 1003 批量冻结其中一个账户余额不足，重复请求
     * 1004 批量解冻一个账户冻结余额不足
     * 1005 批量解冻其中一个账户冻结余额不足
     * 1006 批量解冻其中一个账户冻结余额不足，重复请求
     * 1007 批量冻结其中一个账户不存在
     * 1008 批量解冻冻结码不正确
     * 1009 批量冻结其中accountNo+reqId重复
     */
    @AutoTest(file = "user/accountTransServiceBatchFreezeOrUnFreezeBalanceTestFailTwo.csv")
    @DisplayName("批量账户余额冻结/解冻--失败用例")
    public void accountTransServiceBatchFreezeOrUnFreezeBalanceTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountBatchFreezeOrUnFreezeOrder accountBatchFreezeOrUnFreezeOrder,
            AccountBaseFreezeOrder accountBaseFreezeOrder,
            AccountBaseFreezeOrder accountBaseFreezeOrder1,
            AccountBaseFreezeOrder accountBaseFreezeOrder2,
            //数据准备
            AccountDO accountDO,
            AccountDO accountDO1,
            AccountDO accountDO2,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO2
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo());
        // userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        // userTestBase.cleanAccountFreezeLogByAccountNo(accountDO1.getAccountNo());
        // userTestBase.cleanAccountFreezeLogByAccountNo(accountDO2.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccount(accountDO2);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO1);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO2);
        // 测试过程
        List<AccountBaseFreezeOrder> orders = new ArrayList<AccountBaseFreezeOrder>();
        orders.add(accountBaseFreezeOrder);
        if (testId != 1001 && testId != 1004 && testId != 1009) {
            orders.add(accountBaseFreezeOrder1);
            orders.add(accountBaseFreezeOrder2);
        }
        accountBatchFreezeOrUnFreezeOrder.setOrders(orders);
        if (testId == 1003 || testId == 1006 || testId == 1009) {
            BizResult result = accountTransService.batchFreezeOrUnFreezeBalance(accountBatchFreezeOrUnFreezeOrder);
        }
        if (testId == 1009) {
            orders.add(accountBaseFreezeOrder1);
            orders.add(accountBaseFreezeOrder2);
            accountBatchFreezeOrUnFreezeOrder.setOrders(orders);
            accountBatchFreezeOrUnFreezeOrder.setReqId(OID.newID());
        }
        // 调用接口
        BizResult result = accountTransService.batchFreezeOrUnFreezeBalance(accountBatchFreezeOrUnFreezeOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        AccountDO accDO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        AccountDO accDO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);
        AccountDO accDO2 = userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0);
        if (testId == 1009) {
            assertEquals(accountDO.getFreezeBalance() + accountBaseFreezeOrder.getAmount().getCent(), accDO.getFreezeBalance());
        } else {
            assertEquals(accountDO, accDO);
        }
        assertEquals(accountDO1, accDO1);
        assertEquals(accountDO2, accDO2);
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo());
    }
}
