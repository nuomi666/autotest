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
import com.xyb.gas.user.api.order.UserInviteRegisterOrder;
import com.xyb.gas.user.api.result.RegisterUserResult;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserCarInfoDO;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserInviteLogDO;
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
 * Created on 2020/02/13.
 */
public class UserServiceUserInviteRegisterTest extends SpringBootTestBase {

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
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceUserInviteRegisterTestSuccess.csv")
    @DisplayName("会员推广注册--成功用例")
    public void userServiceUserInviteRegisterTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String mobile,
            UserInviteRegisterOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByPlatPartnerIdAndMobile(partnerId, mobile);
        userTestBase.cleanUserByPlatPartnerIdAndMobile(partnerId, order.getMobile());
        silverboltTestBase.cleanGasUserByPartnerIdAndMobile(partnerId, mobile);
        silverboltTestBase.cleanGasUserByPartnerIdAndMobile(partnerId, order.getMobile());
        // 准备数据
        Date birth = DateUtils.parseDate("2008-11-27");
        String key = order.getPlatPartnerId() + order.getMobile();
        redisTemplate.opsForValue().set(REDIS_PREFIX + key, order.getSmsValidateCode(), 5 * 60, SECONDS);//验证码
        redisTemplate.opsForValue().set(REDIS_PREFIX + "validate_" + key, "3", 5 * 60, SECONDS);//错误次数
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", "18825814769", "ABLE");
        gasUserInitDataBase.initUser(partnerId, userId, null, "sorami",
                mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, null, null);
//        userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, openId, sourceFrom, null,
//                null);
        // 测试过程
        order.setInviteId(userId);
        if (testId != 1001) {
            order.setBirthday(birth);
        }
        // 调用接口
        RegisterUserResult result = userService.userInviteRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        sleep(3);
        String userIdxx = result.getUserId();
        List<String> openIds = new ArrayList<>();
        UserDO userInfo = userTestBase.findUserByUserId(userIdxx).get(0);
        List<GasUserDO> silverUsers = silverboltTestBase.findGasUserByUserId(userIdxx);
        List<UserCarInfoDO> cars = userTestBase.findUserCarInfoByUserId(userIdxx);
        List<UserPayToolInfoDO> toolInfos = userTestBase.findUserPayToolInfoByUserId(userIdxx);
        List<UserInviteLogDO> spreadLogs = userTestBase.findUserInviteLogByUserId(userIdxx);
        List<dal.model.gas_silverbolt.UserInviteLogDO> spreadLogDOS =
                silverboltTestBase.findUserInviteLogByUserId(userIdxx);
        if (testId == 1001) {
            userAssert(userInfo, partnerId, userIdxx, order.getMobile(),
                    null, null, null,
                    null, MemberType.NORMAL.code(),
                    GeneralizeSource.USER_GENERALIZE.code(), userId,
                    mobile, null, null);
            silverboltUserAssert(silverUsers.get(0), partnerId, userIdxx, order.getMobile(),
                    null, null, null,
                    null, MemberType.NORMAL.code(),
                    GeneralizeSource.USER_GENERALIZE.code(), userId,
                    mobile, null, null);
            spreatAssert(spreadLogs.get(0), partnerId, userIdxx, null,
                    userId, mobile, null);
            silverboltSpreatAssert(spreadLogDOS.get(0), partnerId, userIdxx, null,
                    userId, mobile, null);
        } else {
            userAssert(userInfo, partnerId, userIdxx, order.getMobile(),
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    GeneralizeSource.USER_GENERALIZE.code(), userId,
                    mobile, DateUtil.dtSimpleFormat(order.getBirthday()).substring(5), order.getBirthday());
            silverboltUserAssert(silverUsers.get(0), partnerId, userIdxx, order.getMobile(),
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    GeneralizeSource.USER_GENERALIZE.code(), userId,
                    mobile, DateUtil.dtSimpleFormat(order.getBirthday()).substring(5), order.getBirthday());
            spreatAssert(spreadLogs.get(0), partnerId, userIdxx, order.getNickName(),
                    userId, mobile, null);
            silverboltSpreatAssert(spreadLogDOS.get(0), partnerId, userIdxx, order.getNickName(),
                    userId, mobile, null);
        }
        if (testId == 1002) {
            assertEquals(1, cars.size());
            assertEquals(order.getCarNumber(), cars.get(0).getCarNumber());
        }
        assertEquals(1, toolInfos.size());
        assertEquals(order.getOpenId(), toolInfos.get(0).getOpenId());
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userIdxx);
        userTestBase.cleanUserCarInfoByUserId(userIdxx);
        userTestBase.cleanUserInviteLogByUserId(userIdxx);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userIdxx);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userIdxx);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userIdxx);
        silverboltTestBase.cleanUserInviteLogByUserId(userIdxx);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceUserInviteRegisterTestFailOne.csv")
    @DisplayName("会员推广注册--参数非法")
    public void userServiceUserInviteRegisterTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserInviteRegisterOrder order
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
        RegisterUserResult result = userService.userInviteRegister(order);
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
    @AutoTest(file = "gas_user/userServiceUserInviteRegisterTestFailTwo.csv")
    @DisplayName("会员推广注册--失败用例")
    public void userServiceUserInviteRegisterTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String mobile,
            UserInviteRegisterOrder order
    ) {
        // 清除数据
        // 准备数据
        String key = order.getPlatPartnerId() + order.getMobile();
        redisTemplate.opsForValue().set(key, order.getSmsValidateCode());
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wxa2557eabb23b47e8",
                    "糯米", OID.newID(), OID.newID(),
                    OID.newID(), "Merchant", "18825814769", "ABLE");
        }
        if (testId != 1002) {
            gasUserInitDataBase.initUser(partnerId, userId, null, "sorami",
                    mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                    null, null, null, null, null, null);
        }
        // 测试过程
        order.setInviteId(userId);
        // 调用接口
        RegisterUserResult result = userService.userInviteRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
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
//        assertEquals(recommendId, userInfo.getRecommendId());user表的这两个字段已经没用了
//        assertEquals(recommendMobile, userInfo.getRecommendMobile());
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
        assertEquals(source, userInfo.getRecommendSource());
//        assertEquals(recommendId, userInfo.getRecommendId());
//        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals(birthday, userInfo.getBirthday());
        assertEquals(shortBirthday, userInfo.getShortBirthday());
    }

    /**
     * 推荐人信息
     */
    private void spreatAssert(
            UserInviteLogDO userInfo,
            String partnerId,
            String userId,
            String nickName,
            String inviteId,
            String inviteMobile,
            String inviteName
    ) {
        assertEquals(partnerId, userInfo.getPlatPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(inviteId, userInfo.getUserInviteId());
        assertEquals(inviteMobile, userInfo.getUserInviteMobile());
        assertEquals(inviteName, userInfo.getUserInviteName());
    }

    /**
     * 推荐人信息
     */
    private void silverboltSpreatAssert(
            dal.model.gas_silverbolt.UserInviteLogDO userInfo,
            String partnerId,
            String userId,
            String nickName,
            String inviteId,
            String inviteMobile,
            String inviteName
    ) {
        assertEquals(partnerId, userInfo.getPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(inviteId, userInfo.getUserInviterId());
        assertEquals(inviteMobile, userInfo.getUserInviterMobile());
        assertEquals(inviteName, userInfo.getUserInviterName());
    }
}
