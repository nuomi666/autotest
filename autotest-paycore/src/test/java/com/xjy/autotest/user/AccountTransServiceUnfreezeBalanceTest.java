package com.xjy.autotest.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.enums.FreezeType;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import com.xyb.user.api.order.account.AccountFreezeOrder;
import com.xyb.user.api.service.account.AccountTransService;
import dal.model.user.AccountDO;
import dal.model.user.AccountFreezeCodeAmountDO;
import dal.model.user.AccountFreezeLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/**
 * @author lvdou
 * 服务名：解冻余额
 * Created on 2018年06月20日.
 */
public class AccountTransServiceUnfreezeBalanceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，标准账户，账户余额1000，已冻结1000，解冻500
     * 1002 全填参数，信用账户，账户余额1000，已冻结1000，解冻1000
     * 1003 全填参数，结算账户，账户余额1000，已冻结500，解冻500
     * 1004 全填参数，中间过度账户，账户余额1000，已冻结500，解冻300
     * 1005 全填参数，系统账户，账户余额1000，已冻结200，解冻200
     * 1006 全填参数，保证金账户，账户余额1000，已冻结200，解冻100
     * 1007 重复解冻，只解冻一次
     * 1008 解冻账户存在关联账户，解冻关联账户，解冻100，关联账户一样解冻
     * 1009 解冻账户userId+tag存在关联账户，解冻关联账户，解冻100，关联账户一样解冻
     * 1010 解冻账户userId+tag存在关联账户userId+tag，解冻关联账户，解冻100，关联账户一样解冻
     * 1011 userId+tag全填参数，信用账户，账户余额1000，已冻结1000，解冻1000
     */
    @AutoTest(file = "user/accountTransServiceUnfreezeBalanceTestSuccess.csv")
    @DisplayName("解冻余额--成功用例")
    public void accountTransServiceUnfreezeBalanceTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            AccountFreezeOrder accountFreezeOrder,
            // 数据库参数
            AccountDO accountDO,
            // 干扰参数
            AccountDO accountDO1,
            // 关联账户参数
            AccountDO accountDO2,
            // 结果参数
            String code,
            String description,
            // 冻结金额表
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1
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
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountFreezeCodeAmountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountFreezeCodeAmountDO1.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccount(accountDO2);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO1);
        // 测试过程
        if (testId == 1001) {
            accountFreezeOrder.setMemo(null);
            //accountFreezeOrder.setTag(null);
            accountFreezeOrder.setTransType(null);
            accountFreezeOrder.setPayChannel(null);
            accountFreezeOrder.setLinkAccountNo(null);
        }
        if (testId == 1007) {
            // 重复调用接口
            accountTransService.unfreezeBalance(accountFreezeOrder);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.unfreezeBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        if (testId == 1007) {
            assertEquals(description, result.getMessage());
        } else {
            assertEquals(description, result.getDescription());
        }
        // 数据验证
        if (testId == 1001) {
            assertEquals(accountFreezeOrder.getMemo(), result.getInfo().getMemo());
        }
        assertEquals(accountFreezeOrder.getReqId(), result.getInfo().getReqId());
        assertNotNull(result.getInfo().getRawAddTime());
        assertNotNull(result.getInfo().getBizNo());
        String accountNo = "";
        if (testId <= 1008) {
            accountNo = accountFreezeOrder.getAccountNo();
        }
        if (testId >= 1009) {
            accountNo = userTestBase.findAccountByUserIdAndTag(accountFreezeOrder.getUserId(), accountFreezeOrder.getTag()).get(0).getAccountNo();
        }
        assertEquals(accountNo, result.getInfo().getAccountNo());
        // 数据库校验

        AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        assertEquals(accountDO.getFreezeBalance() - accountFreezeOrder.getAmount().getCent(), DO.getFreezeBalance());
        assertEquals(accountDO.getBalance(), DO.getBalance());
        assertEquals(accountDO.getBandAccountNo(), DO.getBandAccountNo());
        if (testId <= 1007) {
            assertEquals(accountDO2.getFreezeBalance(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getFreezeBalance());
        }
        if (testId >= 1008) {
            assertEquals(accountDO2.getFreezeBalance() - accountFreezeOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getFreezeBalance());
            assertEquals(accountDO2.getBalance(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getBalance());

        }
        if (testId != 1007) {
            assertEquals(DO.getBalance() - DO.getFreezeBalance(), result.getInfo().getBalance().getCent());
        }
        AccountFreezeLogDO DO1 = userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()).get(0);
        if (testId != 1001) {
            assertEquals(accountFreezeOrder.getMemo(), DO1.getMemo());
        }
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
        assertNotNull(DO1.getRawUpdateTime());
        assertEquals(accountFreezeOrder.getPlatPartnerId(), DO1.getPlatPartnerId());
        assertEquals(accountFreezeOrder.getPlatMerchantOrderNo(), DO1.getPlatMerchantOrderNo());
        assertNotNull(DO1.getBillDate());

        AccountFreezeCodeAmountDO DO2 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo()).get(0);
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO2.getUnfreezeAmount());
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO2.getFreezeAmount());
        assertEquals(accountNo, DO2.getAccountNo());
        assertEquals(accountFreezeOrder.getFreezeCode().getCode(), DO2.getFreezeCode());
        assertNotNull(DO2.getId());
        assertNotNull(DO2.getRawAddTime());
        assertNotNull(DO2.getRawUpdateTime());

        if (testId >= 1008) {
            AccountFreezeCodeAmountDO DO3 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo()).get(0);
            assertEquals(accountFreezeOrder.getAmount().getCent(), DO3.getUnfreezeAmount());
            assertEquals(accountFreezeOrder.getAmount().getCent(), DO3.getFreezeAmount());
        }
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
     * 1020 platPartnerId为空，提示platPartnerId不能为空
     * 1023 platPartnerId长度为21，提示platPartnerId长度只能为20
     * 1025 platMerchantOrderNo长度为65，提示platMerchantOrderNo长度只能为1-64
     */
    @AutoTest(file = "user/accountTransServiceUnfreezeBalanceTestFailOne.csv")
    @DisplayName("解冻余额--失败用例一")
    public void accountTransServiceUnfreezeBalanceTestFailOne(
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
        BizResult<AccountTradeResultInfo> result = accountTransService.unfreezeBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());
        // 清除数据
    }

    /**
     * 1001 账户不存在，解冻金额失败
     * 1002 账户状态为冻结，解冻金额失败
     * 1003 主账户解冻金额大于冻结金额，解冻失败
     * 1004 解冻码不正确，解冻失败
     * 1005 关联账户可解冻余额不足，解冻失败
     * 1006 关联账户不存在
     * 1007 主账户userId+tag不存在，关联账户存在
     * 1008 主账户userId+tag不存在，关联账户userId+tag存在
     * 1009 主账户userId+tag存在，关联账户userId+tag不存在
     * 1010 主账户userId+tag不存在，关联账户userId+tag不存在
     */
    @AutoTest(file = "user/accountTransServiceUnfreezeBalanceTestFailTwo.csv")
    @DisplayName("解冻余额--失败用例二")
    public void accountTransServiceUnfreezeBalanceTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            AccountFreezeOrder accountFreezeOrder,
            // 数据库参数
            AccountDO accountDO,
            AccountDO accountDO1,
            // 结果参数
            String code,
            String description,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO,
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO1
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountFreezeOrder.getLinkAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO1);
        // 测试过程
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.unfreezeBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        ArrayList list = new ArrayList();
        assertEquals(list, userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()));
        assertEquals(accountDO, userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0));
        assertEquals(accountDO1, userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0));
        assertEquals(accountFreezeCodeAmountDO, userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo()).get(0));
        assertEquals(accountFreezeCodeAmountDO1, userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo()).get(0));
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
    }
}
