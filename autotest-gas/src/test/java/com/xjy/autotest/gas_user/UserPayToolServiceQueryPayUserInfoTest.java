package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserPayToolService;
import com.xyb.gas.user.api.enums.SourceFrom;
import com.xyb.gas.user.api.order.QueryPayUserOrder;
import com.xyb.gas.user.api.result.info.UserOpenIdInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/01/16.
 */
public class UserPayToolServiceQueryPayUserInfoTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserPayToolService userPayToolService;

    @Autowired
    Gas_userTestBase userTestBase;

    /**
     * 1001.查询的用户绑定了一个微信
     * 1002.查询的用户绑定了多个微信
     */
    @AutoTest(file = "gas_user/userPayToolServiceQueryPayUserInfoTestSuccess.csv")
    @DisplayName("查詢openid--成功用例")
    public void userPayToolServiceQueryPayUserInfoTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String openId, String openId1,
            QueryPayUserOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(openId1);
        // 准备数据
        userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId, SourceFrom.WE_CHAT.code(), null,
                null);
        if (testId == 1002) {
            userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId1, SourceFrom.WE_CHAT.code(),
                    null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<UserOpenIdInfo> result = userPayToolService.queryPayUserInfo(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        UserOpenIdInfo userOpenId = result.getInfo();
        if (testId == 1001) {
            assertEquals(openId, userOpenId.getOpenid());
        } else {//绑定多个微信时，是随机返回的一个
//            assertEquals(openId, userOpenId.getOpenid());
        }
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(openId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userPayToolServiceQueryPayUserInfoTestFailOne.csv")
    @DisplayName("查詢openid--参数非法")
    public void userPayToolServiceQueryPayUserInfoTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryPayUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setType(null);
        }
        if (testId == 1003) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizResult<UserOpenIdInfo> result = userPayToolService.queryPayUserInfo(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.未查询到信息
     */
    @AutoTest(file = "gas_user/userPayToolServiceQueryPayUserInfoTestFailTwo.csv")
    @DisplayName("查詢openid--失败用例")
    public void userPayToolServiceQueryPayUserInfoTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryPayUserOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(order.getUserId());
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<UserOpenIdInfo> result = userPayToolService.queryPayUserInfo(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
