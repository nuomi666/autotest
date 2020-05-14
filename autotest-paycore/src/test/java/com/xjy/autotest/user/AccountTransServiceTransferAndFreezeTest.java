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
import com.xyb.user.api.order.account.AccountTransferAndFreezeOrder;
import com.xyb.user.api.service.account.AccountTransService;
import dal.model.user.AccountDO;
import dal.model.user.AccountFreezeCodeAmountDO;
import dal.model.user.AccountFreezeLogDO;
import dal.model.user.AccountTransLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


/**
 * @author lvdou
 * 服务名：混合转账，包含冻结解冻操作
 * Created on 2018年06月22日.
 */
public class AccountTransServiceTransferAndFreezeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountTransService accountTransService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 普通转账，不进行冻结解冻操作
     * 1002 只进行冻结操作，转账成功
     * 1003 只进行解冻操作，转账成功
     * 1004 进行冻结解冻操作，解冻部分，冻结全部，转账成功
     * 1005 进行冻结解冻操作，解冻全部，冻结部分，转账成功
     * 1006 进行冻结解冻操作，解冻部分，冻结部分，转账成功
     * 1007 进行冻结解冻操作，解冻全部，冻结全部，转账成功
     * 1008 重复请求，转账成功一次
     */
    @AutoTest(file = "user/accountTransServiceTransferAndFreezeTestSuccess.csv")
    @DisplayName("混合转账--成功用例")
    public void accountTransServiceTransferAndFreezeTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransferAndFreezeOrder accountTransferAndFreezeOrder,
            // 数据库参数
            // 支付人账号
            AccountDO accountDO,
            // 收款人账号
            AccountDO accountDO1,
            // 结果参数
            String code,
            String description,
            String message,
            // 冻结金额表
            AccountFreezeCodeAmountDO accountFreezeCodeAmountDO
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountFreezeCodeAmountDO.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        userTestBase.insertAccountFreezeCodeAmount(accountFreezeCodeAmountDO);
        // 测试过程
        if (testId == 1001) {
            accountTransferAndFreezeOrder.setPayeeFreezeAmount(null);
            accountTransferAndFreezeOrder.setPayeeFreezeCode(null);
            accountTransferAndFreezeOrder.setPayerFreezeCode(null);
            accountTransferAndFreezeOrder.setPayerUnfreezeAmount(null);
        }
        if (testId == 1002) {
            accountTransferAndFreezeOrder.setPayerUnfreezeAmount(null);
            accountTransferAndFreezeOrder.setPayerFreezeCode(null);
        }
        if (testId == 1003) {
            accountTransferAndFreezeOrder.setPayeeFreezeCode(null);
            accountTransferAndFreezeOrder.setPayeeFreezeAmount(null);
        }
        accountTransferAndFreezeOrder.setMerchantOrderNo(OID.newID());
        if (testId == 1008) {
            // 重复调用接口
            accountTransService.transferAndFreeze(accountTransferAndFreezeOrder);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.transferAndFreeze(accountTransferAndFreezeOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        if (testId == 1008) {
            assertEquals(description, result.getMessage());
        } else {
            assertEquals(description, result.getDescription());
        }
        // 数据验证

        assertEquals(accountTransferAndFreezeOrder.getMemo(), result.getInfo().getMemo());
        assertEquals(accountTransferAndFreezeOrder.getReqId(), result.getInfo().getReqId());
        assertNotNull(result.getInfo().getRawAddTime());
        assertNotNull(result.getInfo().getAccountNo());
        AccountTradeResultInfo info = result.getInfo();

        // 数据库校验
        // account表
        AccountDO acc = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        AccountDO acc1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);
        if (testId != 1008) {
            assertEquals(acc1.getBalance() - acc1.getFreezeBalance(), info.getBalance().getCent());
        }
        if (testId == 1001) {
            assertEquals(accountDO.getFreezeBalance(), acc.getFreezeBalance());
            assertEquals(accountDO1.getFreezeBalance(), acc1.getFreezeBalance());
        } else if (testId == 1002) {
            assertEquals(accountDO.getFreezeBalance(), acc.getFreezeBalance());
            assertEquals(accountDO1.getFreezeBalance() + accountTransferAndFreezeOrder.getPayeeFreezeAmount().getCent(), acc1.getFreezeBalance());
        } else if (testId == 1003) {
            assertEquals(accountDO1.getFreezeBalance(), acc1.getFreezeBalance());
            assertEquals(accountDO.getFreezeBalance() - accountTransferAndFreezeOrder.getPayerUnfreezeAmount().getCent(), acc.getFreezeBalance());
        } else {
            assertEquals(accountDO.getFreezeBalance() - accountTransferAndFreezeOrder.getPayerUnfreezeAmount().getCent(), acc.getFreezeBalance());
            assertEquals(accountDO1.getFreezeBalance() + accountTransferAndFreezeOrder.getPayeeFreezeAmount().getCent(), acc1.getFreezeBalance());
        }
        assertEquals(accountDO.getBalance() - accountTransferAndFreezeOrder.getAmount().getCent(), acc.getBalance());
        assertEquals(accountDO1.getBalance() + accountTransferAndFreezeOrder.getAmount().getCent(), acc1.getBalance());

        // account_trans_log表
        AccountTransLogDO DO = userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()).get(0);

        assertNotNull(DO.getRawUpdateTime());
        assertEquals(accountTransferAndFreezeOrder.getAmount().getCent(), DO.getAmount());
        assertEquals(accountTransferAndFreezeOrder.getPayerAccountNo(), DO.getAccountNo());
        assertEquals(accountDO.getBalance() - accountTransferAndFreezeOrder.getAmount().getCent(), DO.getAccountBalance());
        assertNotNull(DO.getBizNo());
        assertEquals(accountTransferAndFreezeOrder.getGid(), DO.getGid());
        assertNotNull(DO.getId());
        assertEquals(accountTransferAndFreezeOrder.getMerchantOrderNo(), DO.getMerchantOrderNo());
        assertEquals(accountTransferAndFreezeOrder.getPartnerId(), DO.getPartnerId());
        assertNull(DO.getPayChannel());
        assertNotNull(DO.getRawAddTime());
        assertEquals(accountTransferAndFreezeOrder.getReqId(), DO.getReqId());
        assertEquals(accountTransferAndFreezeOrder.getMemo(), DO.getMemo());
        assertEquals(accountTransferAndFreezeOrder.getTransType().toString(), DO.getTransType());
        assertEquals(TransAmountType.BALANCE_OUT.toString(), DO.getTransAmountType());
        assertNotNull(DO.getBillDate());

        AccountTransLogDO DO1 = userTestBase.findAccountTransLogByAccountNo(accountDO1.getAccountNo()).get(0);

        assertNotNull(DO1.getRawUpdateTime());
        assertEquals(accountTransferAndFreezeOrder.getAmount().getCent(), DO1.getAmount());
        assertEquals(accountTransferAndFreezeOrder.getPayeeAccountNo(), DO1.getAccountNo());
        assertEquals(accountDO1.getBalance() + accountTransferAndFreezeOrder.getAmount().getCent(), DO1.getAccountBalance());
        assertNotNull(DO1.getBizNo());
        assertEquals(accountTransferAndFreezeOrder.getGid(), DO1.getGid());
        assertNotNull(DO1.getId());
        assertEquals(accountTransferAndFreezeOrder.getMerchantOrderNo(), DO1.getMerchantOrderNo());
        assertEquals(accountTransferAndFreezeOrder.getPartnerId(), DO1.getPartnerId());
        assertNotNull(DO1.getRawAddTime());
        assertEquals(accountTransferAndFreezeOrder.getReqId(), DO1.getReqId());
        assertEquals(accountTransferAndFreezeOrder.getMemo(), DO1.getMemo());
        assertEquals(accountTransferAndFreezeOrder.getTransType().toString(), DO1.getTransType());
        assertEquals(TransAmountType.BALANCE_IN.toString(), DO1.getTransAmountType());
        assertNotNull(DO1.getBillDate());

        // account_freeze_log表

        if (testId != 1001 && testId != 1002) {
            AccountFreezeLogDO DO2 = userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()).get(0);

            assertEquals(accountTransferAndFreezeOrder.getPayerUnfreezeAmount().getCent(), DO2.getAmount());
            assertEquals(accountTransferAndFreezeOrder.getPayerAccountNo(), DO2.getAccountNo());
            assertNotNull(DO2.getBizNo());
            assertEquals(accountDO.getFreezeBalance() - accountTransferAndFreezeOrder.getPayerUnfreezeAmount().getCent(), DO2.getFreezeBalance());
            assertEquals(accountTransferAndFreezeOrder.getPayerFreezeCode().toString(), DO2.getFreezeCode());
            assertEquals(FreezeType.UNFREEZE.toString(), DO2.getFreezeType());
            assertEquals(accountTransferAndFreezeOrder.getGid(), DO2.getGid());
            assertNotNull(DO2.getId());
            assertEquals(accountTransferAndFreezeOrder.getMemo(), DO2.getMemo());
            assertEquals(accountTransferAndFreezeOrder.getMerchantOrderNo(), DO2.getMerchantOrderNo());
            assertEquals(accountTransferAndFreezeOrder.getPartnerId(), DO2.getPartnerId());
            assertNotNull(DO2.getRawAddTime());
            assertEquals(accountTransferAndFreezeOrder.getReqId(), DO2.getReqId());
            assertNotNull(DO2.getRawUpdateTime());
            assertNotNull(DO2.getBillDate());
        }
        if (testId != 1001 && testId != 1003) {
            AccountFreezeLogDO DO3 = userTestBase.findAccountFreezeLogByAccountNo(accountDO1.getAccountNo()).get(0);

            assertEquals(accountTransferAndFreezeOrder.getPayeeFreezeAmount().getCent(), DO3.getAmount());
            assertEquals(accountTransferAndFreezeOrder.getPayeeAccountNo(), DO3.getAccountNo());
            assertNotNull(DO3.getBizNo());
            assertEquals(accountDO1.getFreezeBalance() + accountTransferAndFreezeOrder.getPayeeFreezeAmount().getCent(), DO3.getFreezeBalance());
            assertEquals(accountTransferAndFreezeOrder.getPayeeFreezeCode().toString(), DO3.getFreezeCode());
            assertEquals(FreezeType.FREEZE.toString(), DO3.getFreezeType());
            assertEquals(accountTransferAndFreezeOrder.getGid(), DO3.getGid());
            assertNotNull(DO3.getId());
            assertEquals(accountTransferAndFreezeOrder.getMemo(), DO3.getMemo());
            assertEquals(accountTransferAndFreezeOrder.getMerchantOrderNo(), DO3.getMerchantOrderNo());
            assertEquals(accountTransferAndFreezeOrder.getPartnerId(), DO3.getPartnerId());
            assertNotNull(DO3.getRawAddTime());
            assertEquals(accountTransferAndFreezeOrder.getReqId(), DO3.getReqId());
            assertNotNull(DO3.getRawUpdateTime());
            assertNotNull(DO3.getBillDate());
        }
        // account_freeze_code_amount表
        if (testId != 1001 && testId != 1002) {
            AccountFreezeCodeAmountDO DO4 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo()).get(0);

            assertNotNull(DO4.getRawUpdateTime());
            assertEquals(accountTransferAndFreezeOrder.getPayerFreezeCode().toString(), DO4.getFreezeCode());
            assertEquals(accountTransferAndFreezeOrder.getPayerUnfreezeAmount().getCent(), DO4.getFreezeAmount());
            assertEquals(accountTransferAndFreezeOrder.getPayerAccountNo(), DO4.getAccountNo());
            assertNotNull(DO4.getId());
            assertEquals(accountTransferAndFreezeOrder.getPayerUnfreezeAmount().getCent(), DO4.getUnfreezeAmount());
            assertNotNull(DO4.getRawAddTime());
        }

        if (testId != 1001 && testId != 1003) {
            AccountFreezeCodeAmountDO DO5 = userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo()).get(0);

            assertNotNull(DO5.getRawUpdateTime());
            assertEquals(accountTransferAndFreezeOrder.getPayeeFreezeCode().toString(), DO5.getFreezeCode());
            assertEquals(accountTransferAndFreezeOrder.getPayeeFreezeAmount().getCent(), DO5.getFreezeAmount());
            assertEquals(accountTransferAndFreezeOrder.getPayeeAccountNo(), DO5.getAccountNo());
            assertNotNull(DO5.getId());
            assertEquals(new Long(0), DO5.getUnfreezeAmount());
            assertNotNull(DO5.getRawAddTime());
        }
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
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

    @AutoTest(file = "user/accountTransServiceTransferAndFreezeTestFailOne.csv")
    @DisplayName("混合转账--失败用例一")
    public void accountTransServiceTransferAndFreezeTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransferAndFreezeOrder accountTransferAndFreezeOrder,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            accountTransferAndFreezeOrder = null;
        }
        if (testId == 1002) {
            accountTransferAndFreezeOrder.setGid(null);
        }
        if (testId == 1003) {
            accountTransferAndFreezeOrder.setReqId(null);
        }
        if (testId == 1004) {
            accountTransferAndFreezeOrder.setPartnerId(null);
        }
        if (testId == 1005) {
            accountTransferAndFreezeOrder.setMerchantOrderNo(null);
        }
        if (testId == 1006) {
            accountTransferAndFreezeOrder.setPayerAccountNo(null);
        }
        if (testId == 1007) {
            accountTransferAndFreezeOrder.setPayeeAccountNo(null);
        }
        if (testId == 1016) {
            accountTransferAndFreezeOrder.setPlatPartnerId(null);
        }
        if (testId == 1017) {
            accountTransferAndFreezeOrder.setPlatMerchantOrderNo(null);
        }
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.transferAndFreeze(accountTransferAndFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        // 参数校验
        assertNull(result.getInfo());
        ArrayList list = new ArrayList();
        // 清除数据

    }

    /**
     * 1001 支付人账户不存在，混合转账失败
     * 1002 收款人账户不存在，混合转账失败
     * 1003 支付人账户余额不足，混合转账失败
     * 1004 解冻金额大于支付人账户冻结金额，混合转账失败
     */
    @AutoTest(file = "user/accountTransServiceTransferAndFreezeTestFailTwo.csv")
    @DisplayName("混合转账--失败用例二")
    public void accountTransServiceTransferAndFreezeTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            AccountTransferAndFreezeOrder accountTransferAndFreezeOrder,
            // 数据库参数
            // 支付人账号
            AccountDO accountDO,
            // 收款人账号
            AccountDO accountDO1,
            // 结果参数
            String code,
            String description
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        // 测试过程
        // 调用接口
        BizResult<AccountTradeResultInfo> result = accountTransService.transferAndFreeze(accountTransferAndFreezeOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        ArrayList list = new ArrayList();
        assertEquals(list, userTestBase.findAccountTransLogByAccountNo(accountDO.getAccountNo()));
        assertEquals(list, userTestBase.findAccountTransLogByAccountNo(accountDO1.getAccountNo()));
        assertEquals(list, userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo()));
        assertEquals(list, userTestBase.findAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo()));
        assertEquals(list, userTestBase.findAccountFreezeLogByAccountNo(accountDO.getAccountNo()));
        assertEquals(list, userTestBase.findAccountFreezeLogByAccountNo(accountDO1.getAccountNo()));
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountTransLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeLogByAccountNo(accountDO1.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountFreezeCodeAmountByAccountNo(accountDO1.getAccountNo());
    }
}
