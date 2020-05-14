package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.user.api.enums.AccountStatus;
import com.xyb.user.api.info.account.AccountInfo;
import dal.model.user.AccountDO;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountManageService;
import com.xyb.user.api.order.account.RegisterAccountOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：注册账户
 * Created on 2018年06月11日.
 */
public class AccountManageServiceRegisterAccountTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountManageService accountManageService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，注册标准账户
     * 1002 全填参数，注册信用账户
     * 1003 全填参数，注册结算账户
     * 1004 全填参数，注册中间过渡账户
     * 1005 全填参数，注册系统账户
     * 1006 全填参数，注册保证金账户
     */
    @AutoTest(file = "user/accountManageServiceRegisterAccountTestSuccess.csv")
    @DisplayName("注册账户--成功用例")
    public void accountManageServiceRegisterAccountTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            RegisterAccountOrder registerAccountOrder,
            //数据库参数
            UserDO userDO,
            //结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        userTestBase.cleanAccountByUserId(userDO.getUserId());
        userTestBase.cleanUserByUserId(userDO.getUserId());
        userTestBase.cleanUserById(userDO.getId());
        // 准备数据
        userTestBase.insertUser(userDO);
        // 测试过程
        if (testId == 1001) {
            registerAccountOrder.setMemo(null);
            registerAccountOrder.setTag(null);
        }
        // 调用接口
        BizResult<AccountInfo> result = accountManageService.registerAccount(registerAccountOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        assertEquals(description, result.getDescription());
        // 数据验证
        if (testId != 1001) {
            assertEquals(registerAccountOrder.getMemo(), result.getInfo().getMemo());
            assertEquals(registerAccountOrder.getTag(), result.getInfo().getTag());
        }
        assertEquals(AccountStatus.ACTIVE, result.getInfo().getStatus());
        assertEquals(new Money(0), result.getInfo().getHisOutAmount());
        assertEquals(new Money(0), result.getInfo().getHisInAmount());
        assertEquals(new Money(0), result.getInfo().getFreezeBalance());
        assertNotNull(result.getInfo().getAccountNo());
        assertEquals(registerAccountOrder.getAccountType(), result.getInfo().getAccountType());
        assertEquals(new Money(0), result.getInfo().getBalance());
        assertNotNull(result.getInfo().getRawAddTime());
        assertEquals(registerAccountOrder.getUserId(), result.getInfo().getUserId());

        AccountDO DO = userTestBase.findAccountByUserId(registerAccountOrder.getUserId()).get(0);

        assertEquals(registerAccountOrder.getMemo(), DO.getMemo());
        if (testId == 1001) {
            assertEquals(DO.getAccountNo(), DO.getTag());
        } else {
            assertEquals(registerAccountOrder.getTag(), DO.getTag());
        }

        assertEquals(AccountStatus.ACTIVE.toString(), DO.getStatus());
        assertNotNull(DO.getRawAddTime());
        assertNotNull(DO.getPayModel());
        assertNotNull(DO.getId());
        assertNotNull(DO.getAccountNo());
        assertEquals(new Long(0), DO.getBalance());
        assertEquals(registerAccountOrder.getAccountType().toString(), DO.getAccountType());
        assertEquals(new Long(0), DO.getHisInAmount());
        assertEquals(registerAccountOrder.getUserId(), DO.getUserId());
        assertEquals(new Long(0), DO.getFreezeBalance());
        assertNotNull(DO.getRawUpdateTime());

        // 清除数据
        userTestBase.cleanAccountByUserId(userDO.getUserId());
        userTestBase.cleanUserByUserId(userDO.getUserId());
    }

    /**
     * 1001  order为空，提示order不能为空
     * 1002  gid为空，提示gid不能为空
     * 1003  userId为空，提示userId不能为空
     * 1004  accountType为空，提示accountType不能为空
     * 1005  gid长度为34，提示gid长度只能为35
     * 1006  gid长度为36，提示gid长度只能为35
     * 1007  userId长度为19，提示userId长度只能为20
     * 1008  userId长度为21，提示userId长度只能为20
     * 1009  memo长度为257，提示memo长度只能为0-256
     */
    @AutoTest(file = "user/accountManageServiceRegisterAccountTestFailOne.csv")
    @DisplayName("注册账户--失败用例一")
    public void accountManageServiceRegisterAccountTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            RegisterAccountOrder registerAccountOrder,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        registerAccountOrder.setUserId(OID.newID());
        if (testId == 1001) {
            registerAccountOrder = null;
        }
        if (testId == 1002) {
            registerAccountOrder.setGid(null);
        }
        if (testId == 1003) {
            registerAccountOrder.setUserId(null);
        }
        if (testId == 1004) {
            registerAccountOrder.setAccountType(null);
        }
        // 调用接口
        BizResult<AccountInfo> result = accountManageService.registerAccount(registerAccountOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        // 参数校验
        assertNull(result.getInfo());
        if (testId != 1001 && testId != 1003) {
            ArrayList list = new ArrayList();
            assertEquals(list, userTestBase.findAccountByUserId(registerAccountOrder.getUserId()));
        }
        // 清除数据
    }

    /**
     * 1001  用户不存在，添加账户失败
     */
    @AutoTest(file = "user/accountManageServiceRegisterAccountTestFailTwo.csv")
    @DisplayName("注册账户--失败用例二")
    public void accountManageServiceRegisterAccountTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            RegisterAccountOrder registerAccountOrder,
            //数据库参数
            AccountDO accountDO,
            UserDO userDO,
            //结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        userTestBase.cleanUserById(userDO.getId());
        userTestBase.cleanUserByUserId(userDO.getUserId());
        userTestBase.cleanAccountById(accountDO.getId());
        userTestBase.cleanAccountByUserId(accountDO.getUserId());
        // 准备数据
        userTestBase.insertUser(userDO);
        //userTestBase.insertAccount(accountDO);
        // 测试过程
        // 调用接口
        BizResult<AccountInfo> result = accountManageService.registerAccount(registerAccountOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        // 参数校验
        assertNull(result.getInfo());
        ArrayList list = new ArrayList();
        assertEquals(list, userTestBase.findAccountByUserId(registerAccountOrder.getUserId()));
        // 清除数据
        userTestBase.cleanUserByUserId(userDO.getUserId());
        userTestBase.cleanAccountByUserId(accountDO.getUserId());
    }
}
