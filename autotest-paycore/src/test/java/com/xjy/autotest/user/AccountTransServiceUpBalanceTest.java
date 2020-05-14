package com.xjy.autotest.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.enums.TransAmountType;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import com.xyb.user.api.order.account.AccountTransOrder;
import com.xyb.user.api.service.account.AccountTransService;
import dal.model.user.AccountDO;
import dal.model.user.AccountTransLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：上账
 * Created on 2018年06月19日.
 */
public class AccountTransServiceUpBalanceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，账户状态激活，标准账户，账户余额为0，上账100，上账成功
     * 1002 全填参数，账户状态激活，信用账户，账户余额为0，上账200，上账成功
     * 1003 全填参数，账户状态激活，结算账户，账户余额为0，上账300，上账成功
     * 1004 全填参数，账户状态激活，中间过度账户，账户余额为0，上账400，上账成功
     * 1005 全填参数，账户状态激活，系统账户，账户余额为0，上账500，上账成功
     * 1006 全填参数，账户状态激活，保证金账户，账户余额为0，上账600，上账成功
     * 1007 全填参数，账户状态激活，标准账户，账户余额为100，上账100，上账成功
     * 1008 全填参数，账户状态激活，信用账户，账户余额为100，上账200，上账成功
     * 1009 全填参数，账户状态激活，结算账户，账户余额为100，上账300，上账成功
     * 1010 全填参数，账户状态激活，中间过度账户，账户余额为100，上账400，上账成功
     * 1011 全填参数，账户状态激活，系统账户，账户余额为100，上账500，上账成功
     * 1012 全填参数，账户状态激活，保证金账户，账户余额为100，上账100，上账成功
     * 1013 重复上账，只上账一次金额
     * 1014 上账账户存在关联账户，联动上账，上账100
     * 1015 上账账户userId+tag存在关联账户，联动上账，上账100
     * 1016 上账账户userId+tag存在关联账户userId+tag，联动上账，上账100
     * 1017 上账账户存在关联账户userId+tag，联动上账，上账100
     * 1018 上账账户存在关联账户，联动上账，上账100，重复上账
     */
    @AutoTest(file = "user/accountTransServiceUpBalanceTestSuccess.csv")
    @DisplayName("上账--成功用例")
    public void accountTransServiceUpBalanceTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransOrder accountTransOrder,
            // 数据库参数
            AccountDO accountDO,
            // 干扰参数
            AccountDO accountDO1,
            // 关联账户参数
            AccountDO accountDO2,
            // 结果参数
            String code,
            String description
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountByUserIdAndTag(accountDO.getUserId(), accountDO.getTag());
        userTestBase.cleanAccountByUserIdAndTag(accountDO2.getUserId(), accountDO2.getTag());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO2.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        // 干扰数据
        userTestBase.insertAccount(accountDO1);
        // 联动账户数据
        userTestBase.insertAccount(accountDO2);
        // 测试过程
        if (testId == 1001) {
            accountTransOrder.setMemo(null);
            //accountTransOrder.setTag(null);
            accountTransOrder.setTransType(null);
            accountTransOrder.setPayChannel(null);
            accountTransOrder.setLinkAccountNo(null);
        }
        if (testId == 1013 || testId == 1018) {
            // 重复调用接口
            accountTransService.upBalance(accountTransOrder);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.upBalance(accountTransOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        if (testId == 1013 || testId == 1018) {
            assertEquals(description, result.getMessage());
        } else {
            assertEquals(description, result.getDescription());
        }
        AccountTradeResultInfo info = result.getInfo();
        // 数据验证
        if (testId != 1001) {
            assertEquals(accountTransOrder.getMemo(), info.getMemo());
        }
        assertEquals(accountDO.getAccountNo(), info.getAccountNo());
        assertNotNull(info.getBizNo());
        assertNotNull(info.getRawAddTime());
        assertEquals(accountTransOrder.getReqId(), info.getReqId());
        AccountTransLogDO accTransLogDO = userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()).get(0);
        // 数据库校验
        if (testId != 1001) {
            assertEquals(accountTransOrder.getPayChannel(), accTransLogDO.getPayChannel());
            assertEquals(accountTransOrder.getTransType().toString(), accTransLogDO.getTransType());
        }
        assertEquals(accountDO.getBalance() + accountTransOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0).getBalance());
        assertEquals(accountDO1.getBalance(), userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0).getBalance());

        assertEquals(accountTransOrder.getAmount().getCent(), accTransLogDO.getAmount());
        assertEquals(accountDO.getAccountNo(), accTransLogDO.getAccountNo());
        assertEquals(accountDO.getBalance() + accountTransOrder.getAmount().getCent(), accTransLogDO.getBalance());
        assertEquals(info.getBizNo(), accTransLogDO.getBizNo());
        assertEquals(accountTransOrder.getGid(), accTransLogDO.getGid());
        assertNotNull(accTransLogDO.getId());
        assertEquals(accountTransOrder.getMemo(), accTransLogDO.getMemo());
        assertEquals(accountTransOrder.getMerchantOrderNo(), accTransLogDO.getMerchantOrderNo());
        assertEquals(accountTransOrder.getPartnerId(), accTransLogDO.getPartnerId());
        assertNotNull(accTransLogDO.getRawAddTime());
        assertNotNull(accTransLogDO.getRawUpdateTime());
        assertEquals(accountTransOrder.getReqId(), accTransLogDO.getReqId());
        assertEquals(TransAmountType.BALANCE_IN.toString(), accTransLogDO.getTransAmountType());
        assertEquals(accountTransOrder.getPlatMerchantOrderNo(), accTransLogDO.getPlatMerchantOrderNo());
        assertEquals(accountTransOrder.getPlatPartnerId(), accTransLogDO.getPlatPartnerId());
        assertNotNull(accTransLogDO.getBillDate());

        AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        if (testId != 1018) {
            assertEquals(DO.getBalance() - DO.getFreezeBalance(), info.getBalance().getCent());
        }
        assertEquals(accountDO.getBandAccountNo(), DO.getBandAccountNo());
        assertEquals(accountDO.getStatus(), DO.getStatus());
        assertEquals(accountDO.getFreezeBalance(), DO.getFreezeBalance());
        assertEquals(accountDO.getBalance() + accountTransOrder.getAmount().getCent(), DO.getBalance());
        assertEquals(accountDO.getPayModel(), DO.getPayModel());
        assertEquals(accountDO.getRawAddTime(), DO.getRawAddTime());
        assertEquals(accountDO.getMemo(), DO.getMemo());
        assertEquals(accountDO.getId(), DO.getId());
        assertEquals(accountDO.getAccountNo(), DO.getAccountNo());
        assertEquals(accountDO.getAccountType(), DO.getAccountType());
        assertEquals(accountDO.getHisInAmount() + accountTransOrder.getAmount().getCent(), DO.getHisInAmount());
        assertEquals(accountDO.getHisOutAmount(), DO.getHisOutAmount());
        assertEquals(accountDO.getUserId(), DO.getUserId());
        assertNotNull(DO.getRawUpdateTime());
        assertEquals(accountDO.getTag(), DO.getTag());

        AccountDO DO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);

        assertEquals(accountDO1.getBandAccountNo(), DO1.getBandAccountNo());
        assertEquals(accountDO1.getStatus(), DO1.getStatus());
        assertEquals(accountDO1.getFreezeBalance(), DO1.getFreezeBalance());
        assertEquals(accountDO1.getBalance(), DO1.getBalance());
        assertEquals(accountDO1.getPayModel(), DO1.getPayModel());
        assertEquals(accountDO1.getRawAddTime(), DO1.getRawAddTime());
        assertEquals(accountDO1.getMemo(), DO1.getMemo());
        assertEquals(accountDO1.getId(), DO1.getId());
        assertEquals(accountDO1.getAccountNo(), DO1.getAccountNo());
        assertEquals(accountDO1.getAccountType(), DO1.getAccountType());
        assertEquals(accountDO1.getHisInAmount(), DO1.getHisInAmount());
        assertEquals(accountDO1.getHisOutAmount(), DO1.getHisOutAmount());
        assertEquals(accountDO1.getUserId(), DO1.getUserId());
        assertEquals(accountDO1.getRawUpdateTime(), DO1.getRawUpdateTime());
        assertEquals(accountDO1.getTag(), DO1.getTag());
        if (testId >= 1014 && testId <= 1018) {
            AccountDO DO2 = userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0);

            assertEquals(accountDO2.getBandAccountNo(), DO2.getBandAccountNo());
            assertEquals(accountDO2.getStatus(), DO2.getStatus());
            assertEquals(accountDO2.getFreezeBalance(), DO2.getFreezeBalance());
            assertEquals(accountDO2.getBalance() + accountTransOrder.getAmount().getCent(), DO2.getBalance());
            assertEquals(accountDO2.getPayModel(), DO2.getPayModel());
            assertEquals(accountDO2.getRawAddTime(), DO2.getRawAddTime());
            assertEquals(accountDO2.getMemo(), DO2.getMemo());
            assertEquals(accountDO2.getId(), DO2.getId());
            assertEquals(accountDO2.getAccountNo(), DO2.getAccountNo());
            assertEquals(accountDO2.getAccountType(), DO2.getAccountType());
            assertEquals(accountDO2.getHisInAmount() + accountTransOrder.getAmount().getCent(), DO2.getHisInAmount());
            assertEquals(accountDO2.getHisOutAmount(), DO2.getHisOutAmount());
            assertEquals(accountDO2.getUserId(), DO2.getUserId());
            assertNotNull(DO2.getRawUpdateTime());
            assertEquals(accountDO2.getTag(), DO2.getTag());
            AccountTransLogDO accTransLogDO2 = userTestBase.findAccountTransLogByAccountNo(accountDO2.getAccountNo()).get(0);

            assertEquals(accountTransOrder.getPayChannel(), accTransLogDO2.getPayChannel());
            assertEquals(accountTransOrder.getTransType().toString(), accTransLogDO2.getTransType());
            assertEquals(accountDO2.getBalance() + accountTransOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0).getBalance());
            assertEquals(accountTransOrder.getAmount().getCent(), accTransLogDO2.getAmount());
            assertEquals(accountDO2.getAccountNo(), accTransLogDO2.getAccountNo());
            assertEquals(accountDO2.getBalance() + accountTransOrder.getAmount().getCent(), accTransLogDO2.getBalance());
            assertEquals(info.getBizNo(), accTransLogDO2.getBizNo());
            assertEquals(accountTransOrder.getGid(), accTransLogDO2.getGid());
            assertNotNull(accTransLogDO2.getId());
            assertEquals(accountTransOrder.getMemo(), accTransLogDO2.getMemo());
            assertEquals(accountTransOrder.getMerchantOrderNo(), accTransLogDO2.getMerchantOrderNo());
            assertEquals(accountTransOrder.getPartnerId(), accTransLogDO2.getPartnerId());
            assertNotNull(accTransLogDO2.getRawAddTime());
            assertNotNull(accTransLogDO2.getRawUpdateTime());
            assertEquals(accountTransOrder.getReqId(), accTransLogDO2.getReqId());
            assertEquals(TransAmountType.BALANCE_IN.toString(), accTransLogDO2.getTransAmountType());
            assertEquals(accountTransOrder.getPlatMerchantOrderNo(), accTransLogDO2.getPlatMerchantOrderNo());
            assertEquals(accountTransOrder.getPlatPartnerId(), accTransLogDO2.getPlatPartnerId());
            assertNotNull(accTransLogDO2.getBillDate());
        }
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO2.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO2.getAccountNo());
    }

    /**
     * 1001 order为空，提示order不能为空
     * 1002 gid为空，提示gid不能为空
     * 1003 reqId为空，提示reqId不能为空
     * 1004 partnerId为空，提示partnerId不能为空
     * 1005 merchOrderNo为空，提示merchOrderNo不能为空
     * 1006 accountNo为空，提示accountNo不能为空
     * 1009 gid长度为34，提示gid长度只能为35
     * 1010 gid长度为36，提示gid长度只能为35
     * 1013 partnerId长度为19，提示partnerId长度只能为20
     * 1014 partnerId长度为21，提示partnerId长度只能为20
     * 1015 merchantOrderNo长度为0，提示merchOrderNo长度只能为1-64
     * 1016 merchantOrderNo长度为65，提示merchOrderNo长度只能为1-64
     * 1017 platPartnerId长度为19，提示platPartnerId长度只能为20
     * 1018 platPartnerId长度为21，提示platPartnerId长度只能为20
     * 1020 platMerchantOrderNo长度为65，提示platMerchantOrderNo长度只能为1-64
     * 1021 accountNo长度为19，提示accountNo长度只能为20
     * 1022 accountNo长度为21，提示accountNo长度只能为20
     * 1023 amount长度为0，提示amount长度最小只能为1
     * 1024 memo长度为257，提示memo长度只能为0-256
     */
    @AutoTest(file = "user/accountTransServiceUpBalanceTestFailOne.csv")
    @DisplayName("上账--失败用例一")
    public void accountTransServiceUpBalanceTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransOrder accountTransOrder,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            accountTransOrder = null;
        }
        if (testId == 1002) {
            accountTransOrder.setGid(null);
        }
        if (testId == 1003) {
            accountTransOrder.setReqId(null);
        }
        if (testId == 1004) {
            accountTransOrder.setPartnerId(null);
        }
        if (testId == 1005) {
            accountTransOrder.setMerchantOrderNo(null);
        }
        if (testId == 1006) {
            accountTransOrder.setAccountNo(null);
        }
        if (testId == 1007) {
            accountTransOrder.setPlatPartnerId(null);
        }
        if (testId == 1008) {
            accountTransOrder.setPlatMerchantOrderNo(null);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.upBalance(accountTransOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());
        // 清除数据
    }

    /**
     * 1001 账户状态为冻结，上账失败
     * 1002 账户不存在，上账失败
     * 1003 关联账户状态为冻结，整体上账失败
     * 1004 关联账户不存在，整体上账失败
     * 1005 userId+tag账户不存在关联账户存在，整体上账失败
     * 1006 主账户存在，userId+tag关联账户不存在，整体上账失败
     * 1007 userId+tag主账户不存在，userId+tag关联账户不存在，整体上账失败
     * 1008 主账户不存在，关联账户不存在，整体上账失败
     */
    @AutoTest(file = "user/accountTransServiceUpBalanceTestFailTwo.csv")
    @DisplayName("上账--失败用例二")
    public void accountTransServiceUpBalanceTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransOrder accountTransOrder,
            // 数据库参数
            AccountDO accountDO,
            // 关联账户参数
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
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        // 测试过程
        print(accountTransOrder);
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.upBalance(accountTransOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());
        assertEquals(accountDO, userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0));
        assertEquals(accountDO1, userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0));
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
    }
}
