package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountTransService;
import com.xyb.user.api.order.account.AccountCreditAmountOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/10/12.
 */
@DisplayName("账户信用额度上调")
public class AccountTransServiceUpCreditAmountTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 通过accountNo上调账户信用额度
     * 1002 通过userId+tag上调账户信用额度
     */
    @AutoTest(file = "user/accountTransServiceUpCreditAmountTestSuccess.csv")
    @DisplayName("成功用例")
    public void accountTransServiceUpCreditAmountTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountCreditAmountOrder order
    ) {
        // 清除数据
        // 准备数据
        AccountDO accountDO = userTestBase.findAccountByAccountNo(order.getTag()).get(0);
        // 测试过程
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo(OID.newID());
        order.setPlatMerchantOrderNo(OID.newID());
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.upCreditAmount(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        AccountDO accountDO1 = userTestBase.findAccountByAccountNo(order.getTag()).get(0);
        assertEquals(accountDO.getCreditAmount() + order.getAmount().getCent(), accountDO1.getCreditAmount());
        // 清除数据
    }

    /**
     * 1001 amount传空
     * 1002 amount等于0
     * 1003 amount小于0
     * 1004 账户传空
     */
    @AutoTest(file = "user/accountTransServiceUpCreditAmountTestFailOne.csv")
    @DisplayName("参数缺省")
    public void accountTransServiceUpCreditAmountTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountCreditAmountOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.upCreditAmount(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 账户不存在
     * 1002 会员tag不存在
     * 1003 账户不是信用账户
     */
    @AutoTest(file = "user/accountTransServiceUpCreditAmountTestFailTwo.csv")
    @DisplayName("失败用例")
    public void accountTransServiceUpCreditAmountTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AccountCreditAmountOrder order
    ) {
        // 清除数据
        // 准备数据
        AccountDO accountDO = null;
        if (testId == 1003) {
            accountDO = userTestBase.findAccountByAccountNo(order.getAccountNo()).get(0);
        }
        // 测试过程
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo(OID.newID());
        order.setPlatMerchantOrderNo(OID.newID());
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.upCreditAmount(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        AccountDO accountDO1 = null;
        if (testId == 1003) {
            accountDO1 = userTestBase.findAccountByAccountNo(order.getAccountNo()).get(0);
            assertEquals(accountDO.getCreditAmount(), accountDO1.getCreditAmount());
        }
        // 清除数据
    }


}
