package com.xjy.autotest.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.enums.TransAmountType;
import com.xyb.user.api.info.account.AccountTradeResultInfo;
import com.xyb.user.api.order.account.AccountTransferOrder;
import com.xyb.user.api.service.account.AccountTransService;
import dal.model.user.AccountDO;
import dal.model.user.AccountTransLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/**
 * @author lvdou
 * 服务名：转账
 * Created on 2018年06月20日.
 */
public class AccountTransServiceTransferTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，转账成功
     * 1002 全填参数，转账成功
     * 1003 重复转账，只成功一次
     */
    @AutoTest(file = "user/accountTransServiceTransferTestSuccess.csv")
    @DisplayName("转账--成功用例")
    public void accountTransServiceTransferTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransferOrder accountTransferOrder,
            // 数据库参数
            AccountDO accountDO,
            // 干扰数据
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
        if (testId == 1001) {
            //accountTransferOrder.setPayerTag(null);
            //accountTransferOrder.setPayeeTag(null);
            accountTransferOrder.setMemo(null);
            accountTransferOrder.setTransType(null);
        }
        if (testId == 1003) {
            // 重复调用接口
            accountTransService.transfer(accountTransferOrder);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.transfer(accountTransferOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        if (testId == 1003) {
            assertEquals(description, result.getMessage());
        } else {
            assertEquals(description, result.getDescription());
        }
        // 数据验证

        assertNotNull(result.getInfo().getBizNo());
        assertNotNull(result.getInfo().getRawAddTime());
        assertEquals(accountTransferOrder.getReqId(), result.getInfo().getReqId());
        if (testId != 1001) {
            assertEquals(accountTransferOrder.getMemo(), result.getInfo().getMemo());
        }
        // 数据库校验

        assertEquals(accountDO.getBalance() - accountTransferOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0).getBalance());

        assertEquals(accountDO1.getBalance() + accountTransferOrder.getAmount().getCent(), userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0).getBalance());

        AccountTransLogDO DO = userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()).get(0);
        if (testId != 1001) {
            assertEquals(accountTransferOrder.getTransType().toString(), DO.getTransType());
            assertEquals(accountTransferOrder.getMemo(), DO.getMemo());
        }
        assertNull(DO.getPayChannel());
        assertEquals(TransAmountType.BALANCE_OUT.toString(), DO.getTransAmountType());
        assertEquals(accountTransferOrder.getReqId(), DO.getReqId());
        assertNotNull(DO.getRawAddTime());
        assertEquals(accountTransferOrder.getPartnerId(), DO.getPartnerId());
        assertEquals(accountTransferOrder.getMerchantOrderNo(), DO.getMerchantOrderNo());
        assertNotNull(DO.getId());
        assertEquals(accountTransferOrder.getGid(), DO.getGid());
        assertNotNull(DO.getBizNo());
        assertEquals(accountDO.getBalance() - accountTransferOrder.getAmount().getCent(), DO.getBalance());
        assertEquals(accountDO.getAccountNo(), DO.getAccountNo());
        assertEquals(accountTransferOrder.getAmount().getCent(), DO.getAmount());
        assertNotNull(DO.getRawUpdateTime());
        assertEquals(accountTransferOrder.getPlatPartnerId(), DO.getPlatPartnerId());
        assertEquals(accountTransferOrder.getPlatMerchantOrderNo(), DO.getPlatMerchantOrderNo());
        assertNotNull(DO.getBillDate());

        AccountTransLogDO DO1 = userTestBase.findAccountTransLogByAccountNo(accountDO1.getAccountNo()).get(0);

        if (testId != 1001) {
            assertEquals(accountTransferOrder.getTransType().toString(), DO1.getTransType());
            assertEquals(accountTransferOrder.getMemo(), DO1.getMemo());
        }
        assertNull(DO1.getPayChannel());
        assertEquals(TransAmountType.BALANCE_IN.toString(), DO1.getTransAmountType());
        assertEquals(accountTransferOrder.getReqId(), DO1.getReqId());
        assertNotNull(DO1.getRawAddTime());
        assertEquals(accountTransferOrder.getPartnerId(), DO1.getPartnerId());
        assertEquals(accountTransferOrder.getMerchantOrderNo(), DO1.getMerchantOrderNo());
        assertNotNull(DO1.getId());
        assertEquals(accountTransferOrder.getGid(), DO1.getGid());
        assertNotNull(DO1.getBizNo());
        assertEquals(accountDO1.getBalance() + accountTransferOrder.getAmount().getCent(), DO1.getBalance());
        assertEquals(accountDO1.getAccountNo(), DO1.getAccountNo());
        assertEquals(accountTransferOrder.getAmount().getCent(), DO1.getAmount());
        assertNotNull(DO1.getRawUpdateTime());
        assertEquals(accountTransferOrder.getPlatPartnerId(), DO1.getPlatPartnerId());
        assertEquals(accountTransferOrder.getPlatMerchantOrderNo(), DO1.getPlatMerchantOrderNo());
        assertNotNull(DO1.getBillDate());

        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
    }

    /**
     * 1001 order为空，提示order不能为空
     * 1002 gid为空，提示gid不能为空
     * 1003 reqId为空，提示reqId不能为空
     * 1004 partnerId为空，提示partnerId不能为空
     * 1005 merchOrderNo为空，提示merchOrderNo不能为空
     * 1006 payerAccountNo为空，提示payerAccountNo不能为空
     * 1007 payeeAccountNo为空，提示payeeAccountNo不能为空
     * 1008 gid长度为34，提示gid长度只能为35
     * 1009 gid长度为36，提示gid长度只能为35
     * 1012 partnerId长度为19，提示parnterId长度只能为20
     * 1013 partnerId长度为21，提示partnerId长度只能为20
     * 1014 merchOrderNo长度为0，提示merchOrderNo长度只能为1-64
     * 1015 merchOrderNo长度为65，提示merchOrderNo长度只能为1-64
     * 1018 platPartnerId长度为19，提示platPartnerId长度只能为20
     * 1019 platPartnerId长度为21，提示platPartnerId长度只能为20
     * 1021 platMerchantOrderNo长度为65，提示platMerchantOrderNo长度只能为1-64
     */
    @AutoTest(file = "user/accountTransServiceTransferTestFailOne.csv")
    @DisplayName("转账--失败用例一")
    public void accountTransServiceTransferTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransferOrder accountTransferOrder,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            accountTransferOrder = null;
        }
        if (testId == 1002) {
            accountTransferOrder.setGid(null);
        }
        if (testId == 1003) {
            accountTransferOrder.setReqId(null);
        }
        if (testId == 1004) {
            accountTransferOrder.setPartnerId(null);
        }
        if (testId == 1005) {
            accountTransferOrder.setMerchantOrderNo(null);
        }
        if (testId == 1006) {
            accountTransferOrder.setPayerAccountNo(null);
        }
        if (testId == 1007) {
            accountTransferOrder.setPayeeAccountNo(null);
        }
        if (testId == 1016) {
            accountTransferOrder.setPlatPartnerId(null);
        }
        if (testId == 1017) {
            accountTransferOrder.setPlatMerchantOrderNo(null);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.transfer(accountTransferOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());

        // 参数校验
        assertNull(result.getInfo());
        // 清除数据
    }

    /**
     * 1001 支付人账号不存在，转账失败
     * 1002 收款人账号不存在，转账失败
     * 1003 支付人账号内余额不足，转账失败
     * 1004 支付人账号与收款人账号相同，转账失败
     */
    @AutoTest(file = "user/accountTransServiceTransferTestFailTwo.csv")
    @DisplayName("转账--失败用例二")
    public void accountTransServiceTransferTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransferOrder accountTransferOrder,
            // 数据库参数
            AccountDO accountDO,
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
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.transfer(accountTransferOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());

        ArrayList list = new ArrayList();
        assertEquals(list, userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()));

        assertEquals(list, userTestBase.findAccountTransLogByAccountNo(accountDO1.getAccountNo()));

        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
    }
}
