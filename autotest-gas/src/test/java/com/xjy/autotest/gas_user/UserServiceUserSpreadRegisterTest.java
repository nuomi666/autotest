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
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.order.UserSpreadRegisterOrder;
import com.xyb.gas.user.api.result.RegisterUserResult;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserCarInfoDO;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserPayToolInfoDO;
import dal.model.gas_user.UserSpreadLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author nuomi
 * Created on 2020/02/12.
 */
public class UserServiceUserSpreadRegisterTest extends SpringBootTestBase {

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
     * 1001.只传必填项
     * 1002.传入所有
     */
    @AutoTest(file = "gas_user/userServiceUserSpreadRegisterTestSuccess.csv")
    @DisplayName("员工推广注册--成功用例")
    public void userServiceUserSpreadRegisterTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String stationCode,
            String stationName, String userType,
            String roleName, String deviceType, String account,
            String password, String operatorMobile,
            UserSpreadRegisterOrder order
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
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantUser(partnerId, mobile,
                sourceKey, "Merchant", "ABLE", stationCode,
                stationName, userType, "NORMAL", RoleType.Station.code(), roleName,
                deviceType, null, account, password, operatorMobile);
        String operstorId = params.get("userId").toString();
        String stationId = params.get("stationId").toString();
        Long roleId = Long.valueOf(params.get("roleId").toString());
        // 测试过程
        order.setOperatorId(operstorId);
        if (testId != 1001) {
            order.setBirthday(birth);
        }
        // 调用接口
        RegisterUserResult result = userService.userSpreadRegister(order);
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
        List<UserSpreadLogDO> spreadLogs = userTestBase.findUserSpreadLogByUserId(userIdxx);
        List<dal.model.gas_silverbolt.UserSpreadLogDO> spreadLogDOS =
                silverboltTestBase.findUserSpreadLogByUserId(userIdxx);
        if (testId == 1001) {
            userAssert(userInfo, partnerId, userIdxx, order.getMobile(),
                    null, null, null,
                    null, MemberType.NORMAL.code(),
                    GeneralizeSource.STAFF_GENERALIZE.code(), operstorId,
                    operatorMobile, null, null);
            silverboltUserAssert(silverUsers.get(0), partnerId, userIdxx, order.getMobile(),
                    null, null, null,
                    null, MemberType.NORMAL.code(),
                    GeneralizeSource.STAFF_GENERALIZE.code(), operstorId,
                    operatorMobile, null, null);
            spreatAssert(spreadLogs.get(0), partnerId, userIdxx, null,
                    stationId, stationCode, stationName, operstorId,
                    "用户名", operatorMobile);
            silverboltSpreatAssert(spreadLogDOS.get(0), partnerId, userIdxx, null,
                    stationId, stationCode, stationName, operstorId,
                    "用户名", operatorMobile);
        } else {
            userAssert(userInfo, partnerId, userIdxx, order.getMobile(),
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    GeneralizeSource.STAFF_GENERALIZE.code(), operstorId,
                    operatorMobile, DateUtil.dtSimpleFormat(order.getBirthday()).substring(5), order.getBirthday());
            silverboltUserAssert(silverUsers.get(0), partnerId, userIdxx, order.getMobile(),
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    GeneralizeSource.STAFF_GENERALIZE.code(), operstorId,
                    operatorMobile, DateUtil.dtSimpleFormat(order.getBirthday()).substring(5), order.getBirthday());
            spreatAssert(spreadLogs.get(0), partnerId, userIdxx, order.getNickName(),
                    stationId, stationCode, stationName, operstorId,
                    "用户名", operatorMobile);
            silverboltSpreatAssert(spreadLogDOS.get(0), partnerId, userIdxx, order.getNickName(),
                    stationId, stationCode, stationName, operstorId,
                    "用户名", operatorMobile);
        }
        if (testId == 1002) {
            assertEquals(1, cars.size());
            assertEquals(order.getCarNumber(), cars.get(0).getCarNumber());
        }
        assertEquals(1, toolInfos.size());
        assertEquals(order.getOpenId(), toolInfos.get(0).getOpenId());
        // 清除数据
        userTestBase.cleanUserByUserId(userIdxx);
        userTestBase.cleanUserCarInfoByUserId(userIdxx);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        userTestBase.cleanUserSpreadLogByUserId(userIdxx);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userIdxx);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantStationByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userIdxx);
        silverboltTestBase.cleanUserSpreadLogByUserId(userIdxx);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/userServiceUserSpreadRegisterTestFailOne.csv")
    @DisplayName("员工推广注册--参数非法")
    public void userServiceUserSpreadRegisterTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserSpreadRegisterOrder order
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
        RegisterUserResult result = userService.userSpreadRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.商户不存在
     * 1002.推广人不存在
     */
    @AutoTest(file = "gas_user/userServiceUserSpreadRegisterTestFailTwo.csv")
    @DisplayName("员工推广注册--失败用例")
    public void userServiceUserSpreadRegisterTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            UserSpreadRegisterOrder order
    ) {
        // 清除数据
        // 准备数据
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wxa2557eabb23b47e8",
                    "糯米", OID.newID(), OID.newID(),
                    OID.newID(), "Merchant", "18825814769", "ABLE");
        }
        // 测试过程
        merchantTestBase.cleanGasMerchantUserByUserId(order.getOperatorId());
        // 调用接口
        RegisterUserResult result = userService.userSpreadRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
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
//        assertEquals(recommendId, userInfo.getRecommendId());
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
            UserSpreadLogDO userInfo,
            String partnerId,
            String userId,
            String nickName,
            String staionId,
            String staionCode,
            String staionName,
            String operatorId,
            String operatorName,
            String operatorMobile
    ) {
        assertEquals(partnerId, userInfo.getPlatPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(staionCode, userInfo.getStationCode());
        assertEquals(staionId, userInfo.getStationId());
        assertEquals(staionName, userInfo.getStationName());
        assertEquals(operatorId, userInfo.getOperatorId());
        assertEquals(operatorMobile, userInfo.getOperatorMobile());
        assertEquals(operatorName, userInfo.getOperatorName());
    }

    /**
     * 推荐人信息
     */
    private void silverboltSpreatAssert(
            dal.model.gas_silverbolt.UserSpreadLogDO userInfo,
            String partnerId,
            String userId,
            String nickName,
            String staionId,
            String staionCode,
            String staionName,
            String operatorId,
            String operatorName,
            String operatorMobile
    ) {
        assertEquals(partnerId, userInfo.getPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(staionCode, userInfo.getStationCode());
        assertEquals(staionId, userInfo.getStationId());
        assertEquals(staionName, userInfo.getStationName());
        assertEquals(operatorId, userInfo.getOperatorId());
        assertEquals(operatorMobile, userInfo.getOperatorMobile());
        assertEquals(operatorName, userInfo.getOperatorName());
    }
}
