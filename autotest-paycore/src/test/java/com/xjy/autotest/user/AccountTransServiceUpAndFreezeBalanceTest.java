package com.xjy.autotest.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.enums.FreezeType;
import com.xyb.user.api.enums.TransAmountType;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import com.xyb.user.api.order.account.AccountFreezeOrder;
import com.xyb.user.api.service.account.AccountTransService;
import dal.model.user.AccountDO;
import dal.model.user.AccountFreezeLogDO;
import dal.model.user.AccountTransLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/**
 * @author lvdou
 * 服务名：上账并冻结
 * Created on 2018年06月21日.
 */
public class AccountTransServiceUpAndFreezeBalanceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，原冻结金额为0，原余额1000，上账并冻结1000
     * 1002 全填参数，原冻结金额为1000，原余额1000，上账并冻结1000
     * 1003 全填参数，原冻结金额为0，原余额0，上账并冻结1000
     * 1004 重复调用接口，只冻结上账一次
     * 1005 冻结上账账户存在联动账户，联动冻结上账，上账并冻结1000
     * 1006 冻结上账账户userId+tag存在联动账户，联动冻结上账，上账并冻结1000
     * 1007 冻结上账账户存在联动账户userId+tag，联动冻结上账，上账并冻结1000
     * 1008 冻结上账账户userId+tag存在联动账户userId+tag，联动冻结上账，上账并冻结1000
     * 1009 冻结上账账户存在联动账户userId+tag，联动冻结上账，上账并冻结1000
     */
    @AutoTest(file = "user/accountTransServiceUpAndFreezeBalanceTestSuccess.csv")
    @DisplayName("上账并冻结--成功用例")
    public void accountTransServiceUpAndFreezeBalanceTestSuccess(
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
            String description
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO2.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccount(accountDO2);
        // 测试过程
        if (testId == 1001) {
            accountFreezeOrder.setMemo(null);
            //accountFreezeOrder.setTag(null);
            accountFreezeOrder.setTransType(null);
            accountFreezeOrder.setPayChannel(null);
            accountFreezeOrder.setLinkAccountNo(null);
        }
        accountFreezeOrder.setReqId(OID.newID());
        if (testId == 1004) {
            //重复调用接口
            accountTransService.upAndFreezeBalance(accountFreezeOrder);
        }
        // 调用接口

        BizResult<AccountTradeResultInfo> result = accountTransService.upAndFreezeBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        if (testId == 1004) {
            assertEquals(description, result.getMessage());
        } else {
            assertEquals(description, result.getDescription());
        }
        // 数据验证

        assertEquals(accountDO.getAccountNo(), result.getInfo().getAccountNo());
        assertNotNull(result.getInfo().getBizNo());
        assertNotNull(result.getInfo().getRawAddTime());
        assertEquals(accountFreezeOrder.getReqId(), result.getInfo().getReqId());
        if (testId != 1001) {
            assertEquals(accountFreezeOrder.getMemo(), result.getInfo().getMemo());
        }
        // 数据库校验
        // account表
        AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        assertEquals(accountDO.getBalance() + accountFreezeOrder.getAmount().getCent(), DO.getBalance());

        assertEquals(accountDO.getFreezeBalance() + accountFreezeOrder.getAmount().getCent(), DO.getFreezeBalance());

        if (testId >= 1005) {
            assertEquals(accountDO2.getBalance() + accountFreezeOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getBalance());
            assertEquals(accountDO2.getFreezeBalance() + accountFreezeOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getFreezeBalance());
        }
        if (testId != 1004) {
            assertEquals(DO.getBalance() - DO.getFreezeBalance(), result.getInfo().getBalance().getCent());
        }
        // account_trans_log表
        AccountTransLogDO DO1 = userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()).get(0);

        assertNotNull(DO1.getRawUpdateTime());
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO1.getAmount());
        assertEquals(accountDO.getAccountNo(), DO1.getAccountNo());
        assertEquals(accountDO.getBalance() + accountFreezeOrder.getAmount().getCent(), DO1.getBalance());
        assertNotNull(DO1.getBizNo());
        assertEquals(accountFreezeOrder.getGid(), DO1.getGid());
        assertNotNull(DO1.getId());
        assertEquals(accountFreezeOrder.getMerchantOrderNo(), DO1.getMerchantOrderNo());
        assertEquals(accountFreezeOrder.getPartnerId(), DO1.getPartnerId());
        assertNotNull(DO1.getRawAddTime());
        assertEquals(accountFreezeOrder.getReqId(), DO1.getReqId());
        assertEquals(TransAmountType.BALANCE_IN.toString(), DO1.getTransAmountType());
        assertNotNull(DO1.getBillDate());
        if (testId != 1001) {
            assertEquals(accountFreezeOrder.getPayChannel(), DO1.getPayChannel());
            assertEquals(accountFreezeOrder.getMemo(), DO1.getMemo());
            assertEquals(accountFreezeOrder.getTransType().toString(), DO1.getTransType());
        }

        if (testId >= 1005) {
            AccountTransLogDO DO3 = userTestBase.findAccountTransLogByAccountNo(accountDO2.getAccountNo()).get(0);

            assertNotNull(DO3.getRawUpdateTime());
            assertEquals(accountFreezeOrder.getAmount().getCent(), DO3.getAmount());
            assertEquals(accountDO2.getAccountNo(), DO3.getAccountNo());
            assertEquals(accountDO2.getBalance() + accountFreezeOrder.getAmount().getCent(), DO3.getBalance());
            assertNotNull(DO3.getBizNo());
            assertEquals(accountFreezeOrder.getGid(), DO3.getGid());
            assertNotNull(DO3.getId());
            assertEquals(accountFreezeOrder.getMerchantOrderNo(), DO3.getMerchantOrderNo());
            assertEquals(accountFreezeOrder.getPartnerId(), DO3.getPartnerId());
            assertNotNull(DO3.getRawAddTime());
            assertEquals(accountFreezeOrder.getReqId(), DO3.getReqId());
            assertEquals(TransAmountType.BALANCE_IN.toString(), DO3.getTransAmountType());
            assertEquals(accountFreezeOrder.getPayChannel(), DO3.getPayChannel());
            assertEquals(accountFreezeOrder.getMemo(), DO3.getMemo());
            assertEquals(accountFreezeOrder.getTransType().toString(), DO3.getTransType());
            assertNotNull(DO3.getBillDate());
        }

        // account_freeze_log

        AccountFreezeLogDO DO2 = userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()).get(0);
        if (testId == 1001) {
            assertEquals(accountFreezeOrder.getMemo(), DO2.getMemo());
        }
        assertEquals(accountFreezeOrder.getAmount().getCent(), DO2.getAmount());
        assertEquals(accountDO.getAccountNo(), DO2.getAccountNo());
        assertNotNull(DO2.getBizNo());
        assertEquals(accountDO.getFreezeBalance() + accountFreezeOrder.getAmount().getCent(), DO2.getFreezeBalance());
        assertEquals(accountFreezeOrder.getFreezeCode().toString(), DO2.getFreezeCode());
        assertEquals(FreezeType.FREEZE.toString(), DO2.getFreezeType());
        assertEquals(accountFreezeOrder.getGid(), DO2.getGid());
        assertNotNull(DO2.getId());
        assertEquals(accountFreezeOrder.getMerchantOrderNo(), DO2.getMerchantOrderNo());
        assertEquals(accountFreezeOrder.getPartnerId(), DO2.getPartnerId());
        assertNotNull(DO2.getRawAddTime());
        assertEquals(accountFreezeOrder.getReqId(), DO2.getReqId());
        assertNotNull(DO2.getRawUpdateTime());
        assertNotNull(DO2.getBillDate());

        ArrayList list = new ArrayList();
        if (testId <= 1004) {
            assertEquals(list, userTestBase.findAccountFreezeLogByAccountNo(accountDO2.getAccountNo()));
        }
        if (testId >= 1005) {
            AccountFreezeLogDO DO3 = userTestBase.findAccountFreezeLogByAccountNo(accountDO2.getAccountNo()).get(0);
            assertEquals(accountFreezeOrder.getAmount().getCent(), DO3.getAmount());
            assertEquals(accountDO2.getAccountNo(), DO3.getAccountNo());
        }

        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
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
    @AutoTest(file = "user/accountTransServiceUpAndFreezeBalanceTestFailOne.csv")
    @DisplayName("上账并冻结--失败用例一")
    public void accountTransServiceUpAndFreezeBalanceTestFailOne(
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
        BizResult<AccountTradeResultInfo> result = accountTransService.upAndFreezeBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        // 清除数据
    }


    /**
     * 1001 账户不存在，上账冻结失败
     * 1002 账户状态为冻结
     * 1003 联动账户不存在，整体上账冻结失败
     * 1004 联动账户状态为冻结，整体上账冻结失败
     * 1005 联动账户和账户相同，整体上账冻结失败
     * 1006 联动账户userId+tag和账户相同
     * 1007 联动账户userId+tag和账户相同userId+tag
     * 1008 联动账户userId+tag不存在，联动账户存在
     * 1009 联动账户userId+tag存在，联动账户不存在
     * 1010 联动账户userId+tag存在，联动账户userId+tag不存在
     * 1011 联动账户userId+tag不存在，联动账户userId+tag不存在
     */
    @AutoTest(file = "user/accountTransServiceUpAndFreezeBalanceTestFailTwo.csv")
    @DisplayName("上账并冻结--失败用例二")
    public void accountTransServiceUpAndFreezeBalanceTestFailTwo(
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
            String description,
            String message
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        // 测试过程
        print(accountFreezeOrder);
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.upAndFreezeBalance(accountFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());
        ArrayList list = new ArrayList();
        assertEquals(list, userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()));
        assertEquals(list, userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()));
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
    }
}
