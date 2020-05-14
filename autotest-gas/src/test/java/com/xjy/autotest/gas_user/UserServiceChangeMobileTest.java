package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.order.ChangeMobileOrder;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author nuomi
 * Created on 2020/02/13.
 */
public class UserServiceChangeMobileTest extends SpringBootTestBase {

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

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceChangeMobileTestSuccess.csv")
    @DisplayName("修改手机--成功用例")
    public void userServiceChangeMobileTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String userId,
            ChangeMobileOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByMobile(order.getOldMobile());
        userTestBase.cleanUserByMobile(order.getNewMobile());
        silverboltTestBase.cleanGasUserByMobile(order.getOldMobile());
        silverboltTestBase.cleanGasUserByMobile(order.getNewMobile());
        // 准备数据
        String key = order.getPlatPartnerId() + order.getNewMobile();
        redisTemplate.opsForValue().set(REDIS_PREFIX + key, order.getSmsValidateCode(), 5 * 60, SECONDS);//验证码
        redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);//错误次数
        gasUserInitDataBase.initUser(partnerId, userId, null, "sorami",
                order.getOldMobile(), GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userService.changeMobile(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        UserDO userInfo = userTestBase.findUserByUserId(userId).get(0);
        sleep(3);
        List<GasUserDO> silverUsers = silverboltTestBase.findGasUserByUserId(userId);
        userAssert(userInfo, partnerId, userId, order.getNewMobile(),
                null, "sorami", null,
                Sex.OTHER.code(), MemberType.NORMAL.code(),
                GeneralizeSource.AUTONOMY_GENERALIZE.code(), null, null,
                null, null);
        silverboltUserAssert(silverUsers.get(0), partnerId, userId, order.getNewMobile(),
                null, "sorami", null,
                Sex.OTHER.code(), MemberType.NORMAL.code(),
                GeneralizeSource.AUTONOMY_GENERALIZE.code(), null, null,
                null, null);
        assertEquals(order.getNewMobile(), xybUserTestBase.findUserByUserId(userId).get(0).getMobile());
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        redisTemplate.delete(REDIS_PREFIX + key);
        redisTemplate.delete(REDIS_PREFIX + "validate_" + key);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceChangeMobileTestFailOne.csv")
    @DisplayName("修改手机--参数非法")
    public void userServiceChangeMobileTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ChangeMobileOrder order
    ) {
        // 清除数据
        // 准备数据
        String key = order.getPlatPartnerId() + order.getNewMobile();
        redisTemplate.opsForValue().set(REDIS_PREFIX + key, order.getSmsValidateCode(), 5 * 60, SECONDS);//验证码
        redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);//错误次数
        // 测试过程
        if (testId == 1001) {
            order.setOldMobile(null);
        }
        if (testId == 1002) {
            order.setNewMobile(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userService.changeMobile(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        redisTemplate.delete(REDIS_PREFIX + key);
        redisTemplate.delete(REDIS_PREFIX + "validate_" + key);
    }

    /**
     * 1001.验证码错误
     * 1002.修改的手机号相同
     * 1003.修改的手机号已经被使用
     * 1004.用户不存在
     */
    @AutoTest(file = "gas_user/userServiceChangeMobileTestFailTwo.csv")
    @DisplayName("修改手机--失败用例")
    public void userServiceChangeMobileTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String userId,
            String userId1,
            ChangeMobileOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByMobile(order.getOldMobile());
        userTestBase.cleanUserByMobile(order.getNewMobile());
        silverboltTestBase.cleanGasUserByMobile(order.getOldMobile());
        silverboltTestBase.cleanGasUserByMobile(order.getNewMobile());
        // 准备数据
        String key = order.getPlatPartnerId() + order.getNewMobile();
        if (testId == 1001) {
            redisTemplate.opsForValue().set(REDIS_PREFIX + key, "2587", 5 * 60, SECONDS);//验证码
            redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);//错误次数
        } else {
            redisTemplate.opsForValue().set(REDIS_PREFIX + key, order.getSmsValidateCode(), 5 * 60, SECONDS);//验证码
            redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);//错误次数
        }
        if (testId != 1004) {
            gasUserInitDataBase.initUser(partnerId, userId, null, "sorami",
                    order.getOldMobile(), GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                    null, null, null, null, null, null);
        }
        if (testId == 1003) {
            gasUserInitDataBase.initUser(partnerId, userId1, null, "sorami",
                    order.getNewMobile(), GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                    null, null, null, null, null, null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = userService.changeMobile(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId != 1004) {
            UserDO userInfo = userTestBase.findUserByUserId(userId).get(0);
            List<GasUserDO> silverUsers = silverboltTestBase.findGasUserByUserId(userId);
            userAssert(userInfo, partnerId, userId, order.getOldMobile(),
                    null, "sorami", null,
                    null, MemberType.NORMAL.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null, null,
                    null, null);
            silverboltUserAssert(silverUsers.get(0), partnerId, userId, order.getOldMobile(),
                    null, "sorami", null,
                    null, MemberType.NORMAL.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null, null,
                    null, null);
            assertEquals(order.getNewMobile(), xybUserTestBase.findUserByUserId(userId).get(0).getMobile());
        }
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        merchantTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        redisTemplate.delete(REDIS_PREFIX + key);
        redisTemplate.delete(REDIS_PREFIX + "validate_" + key);
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

    /**
     * 用户信息
     */
    private void silverboltUserAssert(
            dal.model.gas_silverbolt.GasUserDO userInfo,
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
        assertEquals(partnerId, userInfo.getPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(mobile, userInfo.getMobile());
        assertEquals(realName, userInfo.getRealName());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(headImgUrl, userInfo.getHeadImgUrl());
        assertEquals(sex, userInfo.getSex());
        assertEquals(memberType, userInfo.getMemberType());
        assertEquals(recommendId, userInfo.getRecommendId());
        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals(birthday, userInfo.getBirthday());
        assertEquals(shortBirthday, userInfo.getShortBirthday());
    }
}
