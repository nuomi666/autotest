package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.account.AccountInfo;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountManageService;
import com.xyb.user.api.order.account.ModifyAccountPayModelOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：修改账户支付模型
 * Created on 2018年06月15日.
 */
public class AccountManageServiceModifyAccountPayModelTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    AccountManageService accountManageService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001  必填参数，修改支付模型为000，修改成功
     * 1002  全填参数，修改支付模型为001，修改成功
     * 1003  全填参数，修改支付模型为010，修改成功
     * 1004  全填参数，修改支付模型为011，修改成功
     * 1005  全填参数，修改支付模型为100，修改成功
     * 1006  全填参数，修改支付模型为101，修改成功
     * 1007  全填参数，修改支付模型为110，修改成功
     * 1008  全填参数，修改支付模型为111，修改成功
     * 1009  不修改支付模型
     */
    @AutoTest(file = "user/accountManageServiceModifyAccountPayModelTestSuccess.csv")
    @DisplayName("修改账户支付模型--成功用例")
    public void accountManageServiceModifyAccountPayModelTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            ModifyAccountPayModelOrder modifyAccountPayModelOrder,
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
        userTestBase.cleanAccountByUserId(accountDO.getUserId());
        userTestBase.cleanAccountByUserId(accountDO1.getUserId());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        userTestBase.insertAccount(accountDO1);
        // 测试过程
        // 调用接口
        BizResult<AccountInfo> result = accountManageService.modifyAccountPayModel(modifyAccountPayModelOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        assertEquals(description, result.getDescription());
        // 数据验证
        assertEquals(accountDO.getUserId(), result.getInfo().getUserId());
        assertNotNull(result.getInfo().getRawAddTime());
        assertEquals(accountDO.getBalance(), result.getInfo().getBalance().getCent());
        assertEquals(accountDO.getAccountType(), result.getInfo().getAccountType().toString());
        assertEquals(accountDO.getAccountNo(), result.getInfo().getAccountNo());
        assertEquals(accountDO.getFreezeBalance(), result.getInfo().getFreezeBalance().getCent());
        assertEquals(accountDO.getHisInAmount(), result.getInfo().getHisInAmount().getCent());
        assertEquals(accountDO.getHisOutAmount(), result.getInfo().getHisOutAmount().getCent());
        assertNotNull(result.getInfo().getRawUpdateTime());
        assertEquals(accountDO.getStatus(), result.getInfo().getStatus().toString());
        assertEquals(accountDO.getMemo(), result.getInfo().getMemo());
        assertEquals(accountDO.getBandAccountNo(), result.getInfo().getBandAccountNo());

        assertEquals(accountDO.getTag(), result.getInfo().getTag());

        AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
        assertEquals(accountDO.getTag(), DO.getTag());


        assertNotNull(DO.getRawUpdateTime());
        assertEquals(accountDO.getFreezeBalance(), DO.getFreezeBalance());
        assertEquals(accountDO.getUserId(), DO.getUserId());
        assertEquals(accountDO.getHisOutAmount(), DO.getHisOutAmount());
        assertEquals(accountDO.getHisInAmount(), DO.getHisInAmount());
        assertEquals(accountDO.getAccountType(), DO.getAccountType());
        assertEquals(accountDO.getBalance(), DO.getBalance());
        assertEquals(accountDO.getAccountNo(), DO.getAccountNo());
        assertNotNull(DO.getId());
        assertEquals(accountDO.getMemo(), DO.getMemo());
        assertEquals(modifyAccountPayModelOrder.getPayModel(), DO.getPayModel());
        assertNotNull(DO.getRawAddTime());
        assertEquals(accountDO.getStatus(), DO.getStatus());
        assertEquals(accountDO.getBandAccountNo(), DO.getBandAccountNo());


        AccountDO DO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);

        assertNotNull(DO1.getRawUpdateTime());
        assertEquals(accountDO1.getFreezeBalance(), DO1.getFreezeBalance());
        assertEquals(accountDO1.getUserId(), DO1.getUserId());
        assertEquals(accountDO1.getHisOutAmount(), DO1.getHisOutAmount());
        assertEquals(accountDO1.getHisInAmount(), DO1.getHisInAmount());
        assertEquals(accountDO1.getAccountType(), DO1.getAccountType());
        assertEquals(accountDO1.getBalance(), DO1.getBalance());
        assertEquals(accountDO1.getAccountNo(), DO1.getAccountNo());
        assertNotNull(DO1.getId());
        assertEquals(accountDO1.getMemo(), DO1.getMemo());
        assertEquals(accountDO1.getPayModel(), DO1.getPayModel());
        assertNotNull(DO1.getRawAddTime());
        assertEquals(accountDO1.getStatus(), DO1.getStatus());
        assertEquals(accountDO1.getBandAccountNo(), DO1.getBandAccountNo());

        // 清除数据
        userTestBase.cleanAccountByUserId(accountDO.getUserId());
        userTestBase.cleanAccountByUserId(accountDO1.getUserId());
    }

    /**
     * 1001  order为空，提示order不能为空
     * 1002  gid为空，提示gid不能为空
     * 1003  payModel为空，提示payModel不能为空
     * 1004  accountNo为空，提示accountNo不能为空
     * 1005  gid长度为34，提示gid长度只能为35
     * 1006  gid长度为36，提示gid长度只能为35
     * 1007  payModel长度为2，提示payModel长度只能为3
     * 1008  payModel长度为4，提示payModel长度只能为3
     * 1009  accountNo长度为19，提示accountNo长度只能为20
     * 1010  accountNo长度为21，提示accountNo长度只能为20
     */
    @AutoTest(file = "user/accountManageServiceModifyAccountPayModelTestFailOne.csv")
    @DisplayName("修改账户支付模型--失败用例一")
    public void accountManageServiceModifyAccountPayModelTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            ModifyAccountPayModelOrder modifyAccountPayModelOrder,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            modifyAccountPayModelOrder = null;
        }
        if (testId == 1002) {
            modifyAccountPayModelOrder.setGid(null);
        }
        if (testId == 1003) {
            modifyAccountPayModelOrder.setPayModel(null);
        }
        if (testId == 1004) {
            modifyAccountPayModelOrder.setAccountNo(null);
        }
        // 调用接口
        BizResult<AccountInfo> result = accountManageService.modifyAccountPayModel(modifyAccountPayModelOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getInfo());
    }

    /**
     * 1001  账户不存在，修改支付模型失败
     */
    @AutoTest(file = "user/accountManageServiceModifyAccountPayModelTestFailTwo.csv")
    @DisplayName("修改账户支付模型--失败用例二")
    public void accountManageServiceModifyAccountPayModelTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            ModifyAccountPayModelOrder modifyAccountPayModelOrder,
            // 数据库参数
            AccountDO accountDO,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        // 准备数据
        userTestBase.insertAccount(accountDO);
        // 测试过程
        // 调用接口
        BizResult<AccountInfo> result = accountManageService.modifyAccountPayModel(modifyAccountPayModelOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        // 参数校验

        AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);

        assertNotNull(DO.getRawUpdateTime());
        assertEquals(accountDO.getFreezeBalance(), DO.getFreezeBalance());
        assertEquals(accountDO.getUserId(), DO.getUserId());
        assertEquals(accountDO.getHisOutAmount(), DO.getHisOutAmount());
        assertEquals(accountDO.getHisInAmount(), DO.getHisInAmount());
        assertEquals(accountDO.getAccountType(), DO.getAccountType());
        assertEquals(accountDO.getBalance(), DO.getBalance());
        assertEquals(accountDO.getAccountNo(), DO.getAccountNo());
        assertNotNull(DO.getId());
        assertEquals(accountDO.getMemo(), DO.getMemo());
        assertEquals(accountDO.getPayModel(), DO.getPayModel());
        assertNotNull(DO.getRawAddTime());
        assertEquals(accountDO.getStatus(), DO.getStatus());
        assertEquals(accountDO.getBandAccountNo(), DO.getBandAccountNo());
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
    }
}
