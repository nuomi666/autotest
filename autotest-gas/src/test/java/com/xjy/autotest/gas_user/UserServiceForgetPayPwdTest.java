package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.AutoTestBase;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.order.ForgetPayPwdOrder;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author nuomi
 * Created on 2020/02/14.
 */
public class UserServiceForgetPayPwdTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserService userService;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceForgetPayPwdTestSuccess.csv")
    @DisplayName("找回支付密码--成功用例")
    public void userServiceForgetPayPwdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String userId,
            String pwd,
            ForgetPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        String key = order.getPlatPartnerId() + order.getMobile();
        redisTemplate.opsForValue().set(REDIS_PREFIX + key, order.getSmsValidateCode(), 5 * 60, SECONDS);//验证码
        redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);//错误次数
        gasUserInitDataBase.initUser(partnerId, userId, pwd, "sorami",
                order.getMobile(), GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                null, null, null, null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userService.forgetPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        String passwordEnm = AutoTestBase.getUserPassword(userId, order.getPayPwd());
        UserDO userInfo = userTestBase.findUserByUserId(userId).get(0);
        userAssert(userInfo, partnerId, userId, order.getMobile(),
                null, "sorami", null,
                Sex.OTHER.code(), MemberType.NORMAL.code(),
                GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                null, null, null);
        List<dal.model.user.UserDO> users = xybUserTestBase.findUserByUserId(userId);
        assertEquals(passwordEnm, users.get(0).getPayPassword());
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceForgetPayPwdTestFailOne.csv")
    @DisplayName("找回支付密码--参数非法")
    public void userServiceForgetPayPwdTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ForgetPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setMobile(null);
        }
        if (testId == 1002) {
            order.setPayPwd(null);
        }
        if (testId == 1003) {
            order.setSmsValidateCode(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userService.forgetPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceForgetPayPwdTestFailTwo.csv")
    @DisplayName("找回支付密码--失败用例")
    public void userServiceForgetPayPwdTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String userId,
            String pwd,
            String smsValidateCode,
            ForgetPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        String key = order.getPlatPartnerId() + order.getMobile();
        redisTemplate.opsForValue().set(REDIS_PREFIX + key, smsValidateCode, 5 * 60, SECONDS);//验证码
        redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);//错误次数
        if (testId != 1001) {
            gasUserInitDataBase.initUser(partnerId, userId, pwd, "sorami",
                    order.getMobile(), GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null, null, null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = userService.forgetPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     * 用户信息
     */
    private void userAssert(
            UserDO userInfo,
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
            String shortBirthday,
            Date birthday
    ) {
        assertEquals(partnerId, userInfo.getPlatPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(mobile, userInfo.getMobile());
        assertEquals(realName, userInfo.getRealName());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(headImgUrl, userInfo.getHeadImgUrl());
        assertEquals(sex, userInfo.getSex());
        assertEquals(memberType, userInfo.getMemberType());
        assertEquals(source, userInfo.getSource());
        assertEquals(recommendId, userInfo.getRecommendId());
        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals("false", userInfo.getPayed());
        assertEquals(birthday, userInfo.getBirthday());
        assertEquals(shortBirthday, userInfo.getShortBirthday());
        assertEquals("default", userInfo.getImportSource());
    }
}
