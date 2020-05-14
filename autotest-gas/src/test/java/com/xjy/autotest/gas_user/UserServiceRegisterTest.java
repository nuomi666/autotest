package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.order.RegisterOrder;
import com.xyb.gas.user.api.result.RegisterUserResult;
import dal.model.gas_user.UserCarInfoDO;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserPayToolInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author nuomi
 * Created on 2020/01/17.
 */
public class UserServiceRegisterTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserService userService;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 当新用户注册成功后会给营销、分析以及微信发送消息；由于发送成功后Notify表的数据就会删，这里就没校验
     * 1001.新增用户，只传必填信息
     * 1002.新增用户，传入所有信息
     * 1003.更新用户（绑定多个微信的情况）
     */
    @AutoTest(file = "gas_user/userServiceRegisterTestSuccess.csv")
    @DisplayName("自主注册--成功用例")
    public void userServiceRegisterTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String openId, String sourceFrom,
            RegisterOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserByPlatPartnerIdAndMobile(partnerId, order.getMobile());
        silverboltTestBase.cleanGasUserByPartnerIdAndMobile(partnerId, order.getMobile());
        // 准备数据
        Date birth = DateUtils.parseDate("2008-11-27");
        String key = order.getPlatPartnerId() + order.getMobile();
        redisTemplate.opsForValue().set(REDIS_PREFIX + key, order.getSmsValidateCode(), 5 * 60, SECONDS);
        redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", "18825814769", "ABLE");
        if (testId == 1003) {
            gasUserInitDataBase.initUser(partnerId, userId, null, "sorami",
                    order.getMobile(), GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                    null, null, null, null, null, null);
            userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId, sourceFrom, null,
                    null);
        }
        // 测试过程
        if (testId != 1001) {
            order.setBirthday(birth);
        }
        // 调用接口
        RegisterUserResult result = userService.register(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        sleep(3);
        String userIdxx = result.getUserId();
        List<String> openIds = new ArrayList<>();
        UserDO userInfo = userTestBase.findUserByUserId(userIdxx).get(0);
        List<UserCarInfoDO> cars = userTestBase.findUserCarInfoByUserId(userIdxx);
        List<UserPayToolInfoDO> toolInfos = userTestBase.findUserPayToolInfoByUserId(userIdxx);
        if (testId == 1001) {
            userAssert(userInfo, partnerId, userIdxx, order.getMobile(),
                    null, null, null,
                    null, MemberType.NORMAL.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null);
        } else {
            userAssert(userInfo, partnerId, userIdxx, order.getMobile(),
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, DateUtil.dtSimpleFormat(order.getBirthday()).substring(5), order.getBirthday());
        }
        if (testId == 1002) {
            assertEquals(1, cars.size());
            assertEquals(order.getCarNumber(), cars.get(0).getCarNumber());
        }
        if (testId == 1003) {
            assertEquals(2, toolInfos.size());
            for (UserPayToolInfoDO toolInfo : toolInfos) {
                openIds.add(toolInfo.getOpenId());
            }
            assertTrue(openIds.contains(openId));
            assertTrue(openIds.contains(order.getOpenId()));
        } else {
            assertEquals(1, toolInfos.size());
            assertEquals(order.getOpenId(), toolInfos.get(0).getOpenId());
        }
        // 清除数据
        userTestBase.cleanUserByUserId(userIdxx);
        userTestBase.cleanUserCarInfoByUserId(userIdxx);
        userTestBase.cleanUserPayToolInfoByOpenId(openId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        xybUserTestBase.cleanUserByUserId(userIdxx);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userIdxx);
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/userServiceRegisterTestFailOne.csv")
    @DisplayName("自主注册--参数非法")
    public void userServiceRegisterTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RegisterOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setMobile(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        RegisterUserResult result = userService.register(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商户不存在
     */
    @AutoTest(file = "gas_user/userServiceRegisterTestFailTwo.csv")
    @DisplayName("自主注册--失败用例")
    public void userServiceRegisterTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RegisterOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        // 测试过程
        // 调用接口
        RegisterUserResult result = userService.register(order);
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
