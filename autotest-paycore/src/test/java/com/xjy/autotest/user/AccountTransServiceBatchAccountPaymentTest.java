package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.user.AccountBatchLogDO;
import dal.model.user.AccountDO;
import dal.model.user.AccountTransLogDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountTransService;
import com.xyb.user.api.order.account.AccountBatchPaymentOrder;
import com.xyb.user.api.order.account.AccountPaymentBaseOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/06/03.
 */
public class AccountTransServiceBatchAccountPaymentTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 批量账户支付一个账户
     * 1002 批量账户支付三个账户
     * 1003 批量账户支付三个账户，重复支付
     */
    @AutoTest(file = "user/accountTransServiceBatchAccountPaymentTestSuccess.csv")
    @DisplayName("批量账户支付--成功用例")
    public void accountTransServiceBatchAccountPaymentTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountBatchPaymentOrder accountBatchPaymentOrder,
            AccountPaymentBaseOrder accountPaymentBaseOrder,
            AccountPaymentBaseOrder accountPaymentBaseOrder1,
            AccountPaymentBaseOrder accountPaymentBaseOrder2,
            //数据准备
            AccountDO accountDO,
            AccountDO accountDO1,
            AccountDO accountDO2
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO2.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccount(accountDO2);
        // 测试过程
        List<AccountPaymentBaseOrder> orders = new ArrayList<AccountPaymentBaseOrder>();
        orders.add(accountPaymentBaseOrder);
        if (testId != 1001) {
            orders.add(accountPaymentBaseOrder1);
            orders.add(accountPaymentBaseOrder2);
        }
        accountBatchPaymentOrder.setOrders(orders);
        if (testId == 1003) {
            accountTransService.batchAccountPayment(accountBatchPaymentOrder);
        }
        // 调用接口
        BizResult result = accountTransService.batchAccountPayment(accountBatchPaymentOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        AccountBatchLogDO accountBatchLogDO = userTestBase.findAccountBatchLogByReqId(accountBatchPaymentOrder.getReqId()).get(0);
        assertEquals(accountBatchPaymentOrder.getGid(), accountBatchLogDO.getGid());
        assertEquals(accountBatchPaymentOrder.getReqId(), accountBatchLogDO.getReqId());
        assertEquals(accountBatchPaymentOrder.getPartnerId(), accountBatchLogDO.getPartnerId());
        assertEquals(accountBatchPaymentOrder.getPlatPartnerId(), accountBatchLogDO.getPlatPartnerId());
        assertEquals(accountBatchPaymentOrder.getMerchantOrderNo(), accountBatchLogDO.getMerchantOrderNo());
        assertEquals(accountBatchPaymentOrder.getPlatMerchantOrderNo(), accountBatchLogDO.getPlatMerchantOrderNo());

        AccountDO accDO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        AccountDO accDO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);
        AccountDO accDO2 = userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0);
        assertEquals(accountDO.getBalance() - accountPaymentBaseOrder.getAmount().getCent(), accDO.getBalance());
        assertEquals(accountDO.getFreezeBalance(), accDO.getFreezeBalance());
        if (testId != 1001) {
            assertEquals(accountDO1.getBalance() - accountPaymentBaseOrder1.getAmount().getCent(), accDO1.getBalance());
            assertEquals(accountDO1.getFreezeBalance(), accDO1.getFreezeBalance());
            assertEquals(accountDO2.getBalance() - accountPaymentBaseOrder2.getAmount().getCent(), accDO2.getBalance());
            assertEquals(accountDO2.getFreezeBalance(), accDO2.getFreezeBalance());
        }

        AccountTransLogDO accountTransLogDO = userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()).get(0);
        assertEquals(accountPaymentBaseOrder.getAmount().getCent(), accountTransLogDO.getAmount());

        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
    }
}
