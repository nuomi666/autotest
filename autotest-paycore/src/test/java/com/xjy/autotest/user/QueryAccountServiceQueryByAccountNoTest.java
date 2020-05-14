package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.account.AccountInfo;
import com.xyb.user.api.order.account.QueryAccountNoOrder;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.QueryAccountService;
import com.xyb.user.api.order.account.ModifyAccountOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：根据账号编号查询账号信息
 * Created on 2018年06月19日.
 */
public class QueryAccountServiceQueryByAccountNoTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    QueryAccountService queryAccountService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 必填参数，根据账号查询成功
     * 1002 全填参数，根据账号查询成功
     */
    @AutoTest(file = "user/queryAccountServiceQueryByAccountNoTestSuccess.csv")
    @DisplayName("根据账号编号查询账号信息--成功用例")
    public void queryAccountServiceQueryByAccountNoTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            QueryAccountNoOrder modifyAccountOrder,
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
        // 准备数据
        userTestBase.insertAccount(accountDO);
        // 干扰数据
        userTestBase.insertAccount(accountDO1);
        // 测试过程
        if (testId == 1001) {
            //modifyAccountOrder.setTag(null);
        }
        // 调用接口
        BizResult<AccountInfo> result = queryAccountService.queryByAccountNo(modifyAccountOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        assertEquals(description, result.getDescription());
        // 数据验证
        assertEquals(accountDO.getStatus(), result.getInfo().getStatus().toString());
        assertEquals(accountDO.getRawAddTime(), result.getInfo().getRawAddTime());
        assertEquals(accountDO.getTag(), result.getInfo().getTag());
        assertEquals(accountDO.getMemo(), result.getInfo().getMemo());
        assertEquals(accountDO.getRawUpdateTime(), result.getInfo().getRawUpdateTime());
        assertEquals(accountDO.getHisOutAmount(), result.getInfo().getHisOutAmount().getCent());
        assertEquals(accountDO.getHisInAmount(), result.getInfo().getHisInAmount().getCent());
        assertEquals(accountDO.getFreezeBalance(), result.getInfo().getFreezeBalance().getCent());
        assertEquals(accountDO.getAccountNo(), result.getInfo().getAccountNo());
        assertEquals(accountDO.getAccountType(), result.getInfo().getAccountType().toString());
        assertEquals(accountDO.getBalance(), result.getInfo().getBalance().getCent());
        assertEquals(accountDO.getUserId(), result.getInfo().getUserId());
        assertEquals(accountDO.getBandAccountNo(), result.getInfo().getBandAccountNo());
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
    }

    /**
     * 1001 order为空，提示order不能为空
     * 1002 gid为空，提示gid不能为空
     * 1003 accountNo为空，提示accountNo不能为空
     * 1004 gid长度为34，提示gid长度只能为35
     * 1005 gid长度为36，提示gid长度只能为35
     * 1006 accountNo长度为19，提示accountNo长度只能为20
     * 1007 accountNo长度为21，提示accountNo长度只能为20
     */
    @AutoTest(file = "user/queryAccountServiceQueryByAccountNoTestFailOne.csv")
    @DisplayName("根据账号编号查询账号信息--失败用例一")
    public void queryAccountServiceQueryByAccountNoTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            QueryAccountNoOrder modifyAccountOrder,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            modifyAccountOrder = null;
        }
        if (testId == 1002) {
            modifyAccountOrder.setGid(null);
        }
        if (testId == 1003) {
            modifyAccountOrder.setAccountNo(null);
        }
        // 调用接口
        BizResult<AccountInfo> result = queryAccountService.queryByAccountNo(modifyAccountOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        // 参数校验
        assertNull(result.getInfo());
        // 清除数据
    }

    /**
     * 1001 账号编号对应的账号信息不存在，查询成功，返回结果为空
     */
    @AutoTest(file = "user/queryAccountServiceQueryByAccountNoTestFailTwo.csv")
    @DisplayName("根据账号编号查询账号信息--失败用例二")
    public void queryAccountServiceQueryByAccountNoTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            QueryAccountNoOrder modifyAccountOrder,
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
        BizResult<AccountInfo> result = queryAccountService.queryByAccountNo(modifyAccountOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        assertEquals(description, result.getDescription());
        // 参数校验
        assertEquals(0L, result.getInfo().getFreezeBalance().getCent());
        assertNull(result.getInfo().getAccountType());
        assertNull(result.getInfo().getRawAddTime());
        assertNull(result.getInfo().getStatus());
        assertNull(result.getInfo().getRawUpdateTime());
        assertNull(result.getInfo().getMemo());
        assertEquals(0L,result.getInfo().getHisOutAmount().getCent());
        assertEquals(0L,result.getInfo().getHisInAmount().getCent());
        assertNull(result.getInfo().getAccountNo());
        assertEquals(0L,result.getInfo().getBalance().getCent());
        assertNull(result.getInfo().getTag());
        // 清除数据
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
    }
}
