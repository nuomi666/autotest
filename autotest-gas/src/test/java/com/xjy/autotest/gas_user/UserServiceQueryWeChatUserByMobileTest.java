package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.order.QueryUserAndWeChatByMobileOrder;
import com.xyb.gas.user.api.result.info.UserAndWeChatMessageInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/01/17.
 */
public class UserServiceQueryWeChatUserByMobileTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserService userService;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001.手机号注册了，未绑定微信
     * 1002.手机号注册了，绑定一个微信
     * 1003.手机号注册了，绑定多个微信
     * 1004.手机号未注册
     */
    @AutoTest(file = "gas_user/userServiceQueryWeChatUserByMobileTestSuccess.csv")
    @DisplayName("验证手机号是否已经注册--成功用例")
    public void userServiceQueryWeChatUserByMobileTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerId1,
            String userId, String userId1,
            String mobile, String openId,
            String openId1, String openId2,
            String sourceFrom,
            QueryUserAndWeChatByMobileOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByMobile(mobile);
        userTestBase.cleanUserByMobile(order.getMobile());
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(openId1);
        userTestBase.cleanUserPayToolInfoByOpenId(openId2);
        silverboltTestBase.cleanGasUserByMobile(mobile);
        silverboltTestBase.cleanGasUserByMobile(order.getMobile());
        // 准备数据
        gasUserInitDataBase.initUser(partnerId, userId, null, "sorami",
                mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, null, null);
        //绑定微信
        if (testId >= 1002) {
            userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId, sourceFrom, null,
                    null);
        }
        if (testId == 1003) {
            userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId1, sourceFrom, null,
                    null);
        }
        //干扰数据
        gasUserInitDataBase.initUser(partnerId1, userId1, null, "sorami",
                mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, null, null);
        //绑定微信
        userTestBase.insertUserPayToolInfo(0L, userId1, partnerId1, partnerId1, openId2, sourceFrom, null,
                null);
        // 测试过程
        // 调用接口
        BizResult<UserAndWeChatMessageInfo> result = userService.queryWeChatUserByMobile(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            partnerAssert(result.getInfo(), order.getPlatPartnerId(),
                    userId, order.getMobile(), 0);
        }
        if (testId == 1002) {
            partnerAssert(result.getInfo(), order.getPlatPartnerId(),
                    userId, order.getMobile(), 1);
        }
        if (testId == 1003) {
            partnerAssert(result.getInfo(), order.getPlatPartnerId(),
                    userId, order.getMobile(), 2);
        }
        if (testId == 1004) {
            assertEquals(null, result.getInfo());
        }
        // 清除数据
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId1);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId1);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserCardInfoByUserId(userId1);
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(openId1);
        userTestBase.cleanUserPayToolInfoByOpenId(openId2);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId1);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByMobile(mobile);
        silverboltTestBase.cleanGasUserByMobile(order.getMobile());
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/userServiceQueryWeChatUserByMobileTestFailOne.csv")
    @DisplayName("验证手机号是否已经注册--参数非法")
    public void userServiceQueryWeChatUserByMobileTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserAndWeChatByMobileOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setMobile(null);
        }
        if (testId == 1002) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizResult<UserAndWeChatMessageInfo> result = userService.queryWeChatUserByMobile(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 注册信息
     */
    private void partnerAssert(
            UserAndWeChatMessageInfo partnerInfo,
            String partnerId,
            String userId,
            String mobile,
            int openIdNum
    ) {
        assertEquals(partnerId, partnerInfo.getPlatPartnerId());
        assertEquals(userId, partnerInfo.getUserId());
        assertEquals(mobile, partnerInfo.getMobile());
        assertEquals(openIdNum, partnerInfo.getOpenIdNum());
    }
}
