package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.user.api.enums.FreezeType;
import com.xyb.user.api.enums.TransAmountType;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import dal.model.user.AccountDO;
import dal.model.user.AccountFreezeCodeAmountDO;
import dal.model.user.AccountFreezeLogDO;
import dal.model.user.AccountTransLogDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountTransService;
import com.xyb.user.api.order.account.AccountFreezeOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：解冻并下账
 * Created on 2018年06月22日.
 */
public class AccountTransServiceUnfreezeAndDownBalanceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，账户余额1000，冻结500，下账500
     * 1002 全填参数，账户余额1000，冻结500，下账200
     * 1003 全填参数，账户余额1000，冻结1000，下账800
     * 1004 全填参数，账户余额1000，冻结1000，下账1000
     * 1005 重复申请，解冻并下账一次
     * 1006 解冻下账账户存在联动账户，联动解冻下账，下账1000
     * 1007 解冻下账账户userId+tag存在联动账户，联动解冻下账，下账1000
     * 1008 解冻下账账户userId+tag存在联动账户userId+tag，联动解冻下账，下账1000
     * 1009 解冻下账账户存在联动账户userId+tag，联动解冻下账，下账1000
     */
    @AutoTest(file = "user/accountTransServiceUnfreezeAndDownBalanceTestSuccess.csv")
    @DisplayName("解冻并下账--成功用例")
    public void accountTransServiceUnfreezeAndDownBalanceTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            AccountFreezeOrder accountFreezeOrder,
            // 数据库参数
            AccountDO accountDO,
            AccountDO accountDO1,
            // 联动账户参数
            AccountDO accountDO2,
            // 结果参数
            String code,
            String description,
            String message,
            // 冻结金额表
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountFreezeCodeAmountDO.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccount(accountDO2);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        if (testId >= 1006) {
            userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO1);
        }
        // 测试过程
        if (testId == 1001) {
            accountFreezeOrder.setMemo(null);
            //accountFreezeOrder.setTag(null);
            accountFreezeOrder.setTransType(null);
            accountFreezeOrder.setPayChannel(null);
            accountFreezeOrder.setLinkAccountNo(null);
        }
        if (testId == 1005) {
            //重复调用接口
            accountTransService.unfreezeAndDownBalance(accountFreezeOrder);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.unfreezeAndDownBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        if (testId == 1005) {
            assertEquals(description, result.getMessage());
        } else {
            assertEquals(description, result.getDescription());
        }
        // 数据验证
        if (testId != 1001) {
            assertEquals(accountFreezeOrder.getMemo(), result.getInfo().getMemo());
        }
        assertEquals(accountFreezeOrder.getReqId(), result.getInfo().getReqId());
        assertNotNull(result.getInfo().getRawAddTime());
        assertNotNull(result.getInfo().getBizNo());
        assertEquals(accountDO.getAccountNo(), result.getInfo().getAccountNo());


        // 数据库校验
        // account表

        assertEquals(accountDO.getFreezeBalance() - accountFreezeOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0).getFreezeBalance());

        assertEquals(accountDO.getBalance() - accountFreezeOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0).getBalance());

        assertEquals(accountDO1.getFreezeBalance(), userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0).getFreezeBalance());

        assertEquals(accountDO1.getBalance(), userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0).getBalance());

        if (testId >= 1006) {
            assertEquals(accountDO2.getBalance() - accountFreezeOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getBalance());
            assertEquals(accountDO2.getFreezeBalance() - accountFreezeOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getFreezeBalance());
        }

        // account_trans_log表

        AccountTransLogDO DO = userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()).get(0);

        if (testId != 1001) {
            assertEquals(accountFreezeOrder.getTransType().toString(), DO.getTransType());
        }
        assertEquals(accountFreezeOrder.getMemo(), DO.getMemo());
        assertEquals(accountFreezeOrder.getPayChannel(), DO.getPayChannel());

        assertEquals(TransAmountType.BALANCE_OUT.toString(), DO.getTransAmountType());
        assertEquals(accountFreezeOrder.getReqId(), DO.getReqId());
        assertNotNull(DO.getRawAddTime());
        assertEquals(accountFreezeOrder.getPartnerId(), DO.getPartnerId());
        assertEquals(accountFreezeOrder.getMerchantOrderNo(), DO.getMerchantOrderNo());
        assertNotNull(DO.getId());
        assertEquals(accountFreezeOrder.getGid(), DO.getGid());
        assertNotNull(DO.getBizNo());
        assertEquals(accountDO.getBalance() - accountFreezeOrder.getAmount().getCent(), DO.getAccountBalance());
        assertEquals(accountDO.getAccountNo(), DO.getAccountNo());
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO.getAmount());
        assertNotNull(DO.getRawUpdateTime());
        assertEquals(accountFreezeOrder.getPlatPartnerId(), DO.getPlatPartnerId());
        assertEquals(accountFreezeOrder.getPlatMerchantOrderNo(), DO.getPlatMerchantOrderNo());
        assertNotNull(DO.getBillDate());

        if (testId >= 1006) {

            AccountTransLogDO DO3 = userTestBase.findAccountTransLogByAccountNo(accountDO2.getAccountNo()).get(0);
            assertEquals(accountFreezeOrder.getTransType().toString(), DO3.getTransType());
            assertEquals(accountFreezeOrder.getMemo(), DO3.getMemo());
            assertEquals(accountFreezeOrder.getPayChannel(), DO3.getPayChannel());
            assertEquals(TransAmountType.BALANCE_OUT.toString(), DO3.getTransAmountType());
            assertEquals(accountFreezeOrder.getReqId(), DO3.getReqId());
            assertNotNull(DO3.getRawAddTime());
            assertEquals(accountFreezeOrder.getPartnerId(), DO3.getPartnerId());
            assertEquals(accountFreezeOrder.getMerchantOrderNo(), DO3.getMerchantOrderNo());
            assertNotNull(DO3.getId());
            assertEquals(accountFreezeOrder.getGid(), DO3.getGid());
            assertNotNull(DO3.getBizNo());
            assertEquals(accountDO2.getBalance() - accountFreezeOrder.getAmount().getCent(), DO3.getAccountBalance());
            assertEquals(accountDO2.getAccountNo(), DO3.getAccountNo());
            assertEquals(accountFreezeOrder.getAmount().getCent(), DO3.getAmount());
            assertNotNull(DO3.getRawUpdateTime());
            assertEquals(accountFreezeOrder.getPlatPartnerId(), DO3.getPlatPartnerId());
            assertEquals(accountFreezeOrder.getPlatMerchantOrderNo(), DO3.getPlatMerchantOrderNo());
            assertNotNull(DO3.getBillDate());
        }

        // account_freeze_log表
        AccountFreezeLogDO DO1 = userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()).get(0);

        assertEquals(accountFreezeOrder.getMemo(), DO1.getMemo());

        assertNotNull(DO1.getRawUpdateTime());
        assertEquals(accountFreezeOrder.getReqId(), DO1.getReqId());
        assertNotNull(DO1.getRawAddTime());
        assertEquals(accountFreezeOrder.getPartnerId(), DO1.getPartnerId());
        assertEquals(accountFreezeOrder.getMerchantOrderNo(), DO1.getMerchantOrderNo());
        assertNotNull(DO1.getId());
        assertEquals(accountFreezeOrder.getGid(), DO1.getGid());
        assertEquals(FreezeType.UNFREEZE.toString(), DO1.getFreezeType());
        assertEquals(accountFreezeOrder.getFreezeCode().toString(), DO1.getFreezeCode());
        assertEquals(accountDO.getFreezeBalance() - accountFreezeOrder.getAmount().getCent(), DO1.getFreezeBalance());
        assertNotNull(DO1.getBizNo());
        assertEquals(accountDO.getAccountNo(), DO1.getAccountNo());
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO1.getAmount());
        assertEquals(accountFreezeOrder.getPlatPartnerId(), DO1.getPlatPartnerId());
        assertEquals(accountFreezeOrder.getPlatMerchantOrderNo(), DO1.getPlatMerchantOrderNo());
        assertNotNull(DO1.getBillDate());

        ArrayList list = new ArrayList();
        if (testId <= 1005) {
            assertEquals(list, userTestBase.findAccountFreezeLogByAccountNo(accountDO2.getAccountNo()));
            assertEquals(list, userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo()));
        }
        // account_freeze_code_amount表
        AccountFreezeCodeAmountDO DO2 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo()).get(0);
        assertNotNull(DO2.getRawAddTime());
        assertNotNull(DO2.getId());
        assertEquals(accountFreezeOrder.getFreezeCode().toString(), DO2.getFreezeCode());
        assertEquals(accountDO.getAccountNo(), DO2.getAccountNo());
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO2.getFreezeAmount());
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO2.getUnfreezeAmount());
        assertNotNull(DO2.getRawUpdateTime());
        if (testId >= 1006) {
            AccountFreezeCodeAmountDO DO3 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo()).get(0);
            assertEquals(accountFreezeOrder.getFreezeCode().toString(), DO2.getFreezeCode());
            assertEquals(accountFreezeOrder.getAmount().getCent(), DO3.getFreezeAmount());
            assertEquals(accountFreezeOrder.getAmount().getCent(), DO3.getUnfreezeAmount());
        }
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo());
    }

    /**
     * 1001 order为空，提示order不能为空
     * 1002 gid为空，提示gid不能为空
     * 1003 reqId为空，提示reqId不能为空
     * 1004 partnerId为空，提示partnerId不能为空
     * 1005 merchOrderNo为空，提示merchOrderNo不能为空
     * 1006 freezeCode为空，提示freezeCode不能为空
     * 1007 accountNo为空，提示accountNo不能为空
     * 1008 gid长度为34，提示gid长度只能为35
     * 1009 gid长度为36，提示gid长度只能为35
     * 1012 partnerId长度为19，提示partnerId长度只能为20
     * 1013 partnerId长度为21，提示partnerId长度只能为20
     * 1014 merchOrderNo长度为0，提示merchOrderNo长度只能为1-64
     * 1015 merchOrderNo长度为65，提示merchOrderNo长度只能为1-64
     * 1016 accountNo长度为19，提示accountNo长度只能为20
     * 1017 accountNo长度为21，提示accountNo长度只能为20
     * 1018 amount长度为0，提示amount长度最小只能为1
     * 1019 memo长度为257，提示memo长度只能为1-256
     * 1022 platPartnerId长度为19，提示platPartnerId长度只能为20
     * 1023 platPartnerId长度为21，提示platPartnerId长度只能为20
     * 1025 platMerchantOrderNo长度为65，提示platMerchantOrderNo长度只能为1-64
     */
    @AutoTest(file = "user/accountTransServiceUnfreezeAndDownBalanceTestFailOne.csv")
    @DisplayName("解冻并下账--失败用例一")
    public void accountTransServiceUnfreezeAndDownBalanceTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            AccountFreezeOrder accountFreezeOrder,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            accountFreezeOrder = null;
        }
        if (testId == 1002) {
            accountFreezeOrder.setGid(null);
        }
        if (testId == 1003) {
            accountFreezeOrder.setReqId(null);
        }
        if (testId == 1004) {
            accountFreezeOrder.setPartnerId(null);
        }
        if (testId == 1005) {
            accountFreezeOrder.setMerchantOrderNo(null);
        }
        if (testId == 1006) {
            accountFreezeOrder.setFreezeCode(null);
        }
        if (testId == 1007) {
            accountFreezeOrder.setAccountNo(null);
        }
        if (testId == 1020) {
            accountFreezeOrder.setPlatPartnerId(null);
        }
        if (testId == 1021) {
            accountFreezeOrder.setPlatMerchantOrderNo(null);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.unfreezeAndDownBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());
        // 清除数据
    }

    /**
     * 1001 账户不存在，解冻下账失败
     * 1002 账户状态为冻结，解冻下账失败
     * 1003 解冻下账金额超过冻结金额，解冻下账失败
     * 1004 解冻下账金额超过账户余额，解冻下账失败
     * 1005 联动账户不存在，整体解冻下账失败
     * 1006 联动账户账户状态为冻结，整体解冻下账失败
     * 1007 联动账户余额不足，整体解冻下账失败
     * 1008 账户与联动账户相同，整体解冻下账失败
     * 1009 账户与联动账户userId+tag相同，整体解冻下账失败
     * 1010 账户userId+tag与联动账户userId+tag相同，整体解冻下账失败
     * 1011 账户与联动账户userId+tag不存在
     * 1012 账户userId+tag不存在与联动账户userId+tag存在
     * 1013 账户userId+tag不存在与联动账户userId+tag不存在
     */
    @AutoTest(file = "user/accountTransServiceUnfreezeAndDownBalanceTestFailTwo.csv")
    @DisplayName("解冻并下账--失败用例二")
    public void accountTransServiceUnfreezeAndDownBalanceTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            AccountFreezeOrder accountFreezeOrder,
            // 数据库参数
            AccountDO accountDO,
            // 联动账户参数
            AccountDO accountDO1,
            // 结果参数
            String code,
            String description
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        // 测试过程
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.unfreezeAndDownBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());
        // 数据库校验
        ArrayList list = new ArrayList();
        assertEquals(list, userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()));
        assertEquals(list, userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()));
        assertEquals(list, userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo()));

        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
    }
}
