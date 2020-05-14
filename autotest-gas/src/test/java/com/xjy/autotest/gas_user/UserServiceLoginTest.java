package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.order.UserLoginOrder;
import com.xyb.gas.user.api.result.info.SimpleUserInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @author nuomi
 * Created on 2020/01/17.
 */
public class UserServiceLoginTest extends SpringBootTestBase {

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

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 目前只支持微信登录
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceLoginTestSuccess.csv")
    @DisplayName("用户登录--成功用例")
    public void userServiceLoginTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String openId, String sourceFrom,
            UserLoginOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        // 准备数据
        gasUserInitDataBase.initUser(partnerId, userId, null, "sorami",
                "15215689745", GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, null, null);
        userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId, sourceFrom, null,
                null);
        // 测试过程
        // 调用接口
        BizResult<SimpleUserInfo> result = userService.login(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        SimpleUserInfo userInfo = result.getInfo();
        userAssert(userInfo, partnerId, userId, "15215689745",
                null, "sorami", null,
                Sex.OTHER.code(), MemberType.NORMAL.code(),
                GeneralizeSource.AUTONOMY_GENERALIZE.code(), null, null, null);
        // 清除数据
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     * 目前只支持微信登录
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceLoginTestFailOne.csv")
    @DisplayName("用户登录--参数非法")
    public void userServiceLoginTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserLoginOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setOpenId(null);
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
        BizResult<SimpleUserInfo> result = userService.login(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.用户不存在
     */
    @AutoTest(file = "gas_user/userServiceLoginTestFailTwo.csv")
    @DisplayName("用户登录--失败用例")
    public void userServiceLoginTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserLoginOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<SimpleUserInfo> result = userService.login(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 用户信息
     */
    private void userAssert(
            SimpleUserInfo userInfo,
            String partnerId,
            String userId,
            String mobile,
            String realName,
            String nickName,
            String headImgUrl,
            String sex,
            String memberType,
            String source,
            String recommendId,
            String recommendMobile,
            Date birthday
    ) {
        assertEquals(partnerId, userInfo.getPlatPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(mobile, userInfo.getMobile());
        assertEquals(realName, userInfo.getRealName());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(headImgUrl, userInfo.getHeadImgUrl());
        assertEquals(sex, userInfo.getSex().code());
        assertEquals(memberType, userInfo.getMemberType().code());
        assertEquals(source, userInfo.getSource().code());
        assertEquals(recommendId, userInfo.getRecommendId());
        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals(false, userInfo.isPayed());
        assertEquals(birthday, userInfo.getBirthday());
    }
}
