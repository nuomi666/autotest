package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.user.api.enums.*;
import com.xyb.user.api.info.user.UserQueryAccountInfo;
import com.xyb.user.api.info.user.UserResultInfo;
import dal.model.user.AccountDO;
import dal.model.user.UserBankCardDO;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.user.QueryUserService;
import com.xyb.user.api.order.user.QueryAccountByUserOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：根据用户查询账号
 * Created on 2018年06月12日.
 */
public class QueryUserServiceGetAccountByUserTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    QueryUserService queryUserService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001  单一会员，单一账户，查询成功
     * 1002  单一会员下存在多个账户，查询成功
     */
    @AutoTest(file = "user/queryUserServiceGetAccountByUserTestSuccess.csv")
    @DisplayName("根据用户查询账号--成功用例")
    public void queryUserServiceGetAccountByUserTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            QueryAccountByUserOrder queryAccountByUserOrder,
            //数据库参数
            UserDO userDO,
            AccountDO accountDO,
            AccountDO accountDO2,
            //干扰数据
            UserDO userDO1,
            AccountDO accountDO1,
            //结果参数
            String code,
            String description,
            String message

    ) {
        // 清除数据
        userTestBase.cleanUserByUserName(userDO.getUserName());
        userTestBase.cleanUserByUserName(userDO1.getUserName());
        userTestBase.cleanAccountByUserId(accountDO.getUserId());
        userTestBase.cleanAccountByUserId(accountDO1.getUserId());
        // 准备数据
        userTestBase.insertUser(userDO);
        userTestBase.insertAccount(accountDO);
        if (testId == 1002) {
            userTestBase.insertAccount(accountDO2);
        }
        //干扰数据
        userTestBase.insertUser(userDO1);
        userTestBase.insertAccount(accountDO1);
        // 测试过程
        // 调用接口
        BizResult<UserQueryAccountInfo> result = queryUserService.getAccountByUser(queryAccountByUserOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        assertEquals(description, result.getDescription());
        // 数据验证
        //userInfo数据校验
        assertEquals(userDO.getZipCode(), result.getInfo().getUserInfo().getZipCode());
        assertEquals(userDO.getUserName(), result.getInfo().getUserInfo().getUserName());
        assertEquals(userDO.getUserType(), result.getInfo().getUserInfo().getUserType().toString());
        assertEquals(userDO.getUserStatus(), result.getInfo().getUserInfo().getUserStatus().toString());
        assertEquals(userDO.getUserId(), result.getInfo().getUserInfo().getUserId());
        assertEquals(userDO.getRegisterIp(), result.getInfo().getUserInfo().getRegisterIp());
        assertEquals(userDO.getRegisterFrom(), result.getInfo().getUserInfo().getRegisterFrom().toString());
        assertEquals(userDO.getRealName(), result.getInfo().getUserInfo().getRealName());
        assertEquals(userDO.getProvince(), result.getInfo().getUserInfo().getProvince());
        assertEquals(userDO.getPhone(), result.getInfo().getUserInfo().getPhone());
        assertEquals(userDO.getPartnerId(), result.getInfo().getUserInfo().getPartnerId());
        assertEquals(userDO.getMobile(), result.getInfo().getUserInfo().getMobile());
        assertEquals(userDO.getMerchantUserId(), result.getInfo().getUserInfo().getMerchantUserId());
        assertEquals(userDO.getMemo(), result.getInfo().getUserInfo().getMemo());
        assertEquals(userDO.getDistrict(), result.getInfo().getUserInfo().getDistrict());
        assertEquals(userDO.getCountry(), result.getInfo().getUserInfo().getCountry());
        assertEquals(userDO.getCity(), result.getInfo().getUserInfo().getCity());
        assertEquals(userDO.getCertType(), result.getInfo().getUserInfo().getCertType().toString());
        assertEquals(userDO.getCertNo(), result.getInfo().getUserInfo().getCertNo());
        assertEquals(userDO.getCertifyStatus(), result.getInfo().getUserInfo().getCertifyStatus().toString());
        assertEquals(userDO.getAddress(), result.getInfo().getUserInfo().getAddress());
        assertEquals(userDO.getParentUserId(), result.getInfo().getUserInfo().getParentUserId());
        //accountInfo数据校验
        assertEquals(accountDO.getUserId(), result.getInfo().getAccountInfo().getUserId());
        assertEquals(accountDO.getTag(), result.getInfo().getAccountInfo().getTag());
        assertEquals(accountDO.getRawAddTime(), result.getInfo().getAccountInfo().getRawAddTime());
        assertEquals(accountDO.getBalance(), result.getInfo().getAccountInfo().getBalance().getCent());
        assertEquals(accountDO.getAccountType(), result.getInfo().getAccountInfo().getAccountType().toString());
        assertEquals(accountDO.getAccountNo(), result.getInfo().getAccountInfo().getAccountNo());
        assertEquals(accountDO.getFreezeBalance(), result.getInfo().getAccountInfo().getFreezeBalance().getCent());
        ;
        assertEquals(accountDO.getHisInAmount(), result.getInfo().getAccountInfo().getHisInAmount().getCent());
        assertEquals(accountDO.getHisOutAmount(), result.getInfo().getAccountInfo().getHisOutAmount().getCent());
        assertEquals(accountDO.getMemo(), result.getInfo().getAccountInfo().getMemo());
        assertEquals(accountDO.getRawUpdateTime(), result.getInfo().getAccountInfo().getRawUpdateTime());
        assertEquals(accountDO.getStatus(), result.getInfo().getAccountInfo().getStatus().toString());
        assertEquals(accountDO.getBandAccountNo(), result.getInfo().getAccountInfo().getBandAccountNo());
        // 清除数据
        userTestBase.cleanUserByUserName(userDO.getUserName());
        userTestBase.cleanUserByUserName(userDO1.getUserName());
        userTestBase.cleanAccountByUserId(accountDO.getUserId());
        userTestBase.cleanAccountByUserId(accountDO1.getUserId());
    }

    /**
     * 1001  order为空，提示order不能为空
     * 1002  gid为空，提示gid不能为空
     * 1003  userId为空，提示userId不能为空
     * 1004  payModel为空，提示payModel不能为空
     * 1006  gid长度为34，提示gid长度只能为35
     * 1007  gid长度为36，提示gid长度只能为35
     * 1008  userId长度为19，提示userId长度只能为20
     * 1009  userId长度为21，提示userId长度只能为20
     */
    @AutoTest(file = "user/queryUserServiceGetAccountByUserTestFailOne.csv")
    @DisplayName("根据用户查询账号--失败用例一")
    public void queryUserServiceGetAccountByUserTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            QueryAccountByUserOrder queryAccountByUserOrder,
            //结果参数
            String code,
            String description,
            String message
    ) {
        //清除数据
        //准备数据
        //测试过程
        if (testId == 1001) {
            queryAccountByUserOrder = null;
        }
        if (testId == 1002) {
            queryAccountByUserOrder.setGid(null);
        }
        if (testId == 1003) {
            queryAccountByUserOrder.setUserId(null);
        }
        if (testId == 1004) {
            queryAccountByUserOrder.setPayModel(null);
        }
        if (testId == 1005) {
            //AccountType已不存在
            //queryAccountByUserOrder.setAccountType(null);
        }
        //调用接口
        BizResult<UserQueryAccountInfo> result = queryUserService.getAccountByUser(queryAccountByUserOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        //参数校验
        assertNull(result.getInfo());
        //清除数据
    }

    /**
     * 1001  用户不存在，查询不到数据
     * 1002  用户状态为未激活，查询失败
     * 1003  账户不存在，查询失败
     * 1004  账户状态为冻结，查询失败
     * 1005  账户不支持该操作，查询失败
     */
    @AutoTest(file = "user/queryUserServiceGetAccountByUserTestFailTwo.csv")
    @DisplayName("根据用户查询账号--失败用例二")
    public void queryUserServiceGetAccountByUserTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            QueryAccountByUserOrder queryAccountByUserOrder,
            // 数据库参数
            UserDO userDO,
            // 账户参数
            AccountDO accountDO,
            //结果参数
            String code,
            String description,
            String message
    ) {
        //清除数据
        userTestBase.cleanUserByUserId(userDO.getUserId());
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        userTestBase.cleanAccountById(accountDO.getId());
        userTestBase.cleanAccountByUserId(userDO.getUserId());
        //准备数据
        userTestBase.insertUser(userDO);
        if (testId != 1003) {
            userTestBase.insertAccount(accountDO);
        }
        //测试过程
        //调用接口
        BizResult<UserQueryAccountInfo> result = queryUserService.getAccountByUser(queryAccountByUserOrder);
        //结果检查
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        //参数校验
        assertNull(result.getInfo());
        //清除数据
        userTestBase.cleanUserByUserId(userDO.getUserId());
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
    }
}
