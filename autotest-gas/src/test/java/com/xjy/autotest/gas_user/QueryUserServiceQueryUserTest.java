package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.user.api.QueryUserService;
import com.xyb.gas.user.api.enums.*;
import com.xyb.gas.user.api.order.QueryUserByMobileOrder;
import com.xyb.gas.user.api.result.info.QueryUserInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/16.
 */
public class QueryUserServiceQueryUserTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    QueryUserService queryUserService;

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

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryUserTestSuccess.csv")
    @DisplayName("通过手机号和短信验证码查询用户相关信息--成功用例")
    public void queryUserServiceQueryUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String userId1,
            String nickName1, String mobile1,
            String entityNo, String innerNo,
            String carNumber, String carType,
            String operatorMobile, String password,
            QueryUserByMobileOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserCarInfoByUserId(userId);
        // 准备数据
        String cardNo = null;
        Date userRawAddTIme = DateUtils.parseDate2("2019-12-25 15:16:17");
        Date entryAddTIme = DateUtils.parseDate2("2019-12-25 16:16:17");
        Date carRawAddTIme = DateUtils.parseDate2("2019-12-31 12:10:11");
        Date applyDate = DateUtils.parseDate2("2020-01-01 16:17:18");
        Date auditDate = DateUtils.parseDate2("2020-01-10 18:19:20");
        String key = order.getPlatPartnerId() + order.getMobile();
        redisTemplate.opsForValue().set(key, order.getSmsValidateCode());
        //操作员
        Map<String, Object> merchantParams = gasMerchantInitDataBase.initMerchantUser(partnerId, "18825814769",
                "wxa2557eabb23b47e8", "Merchant", "ABLE",
                "test001", "糯米测试油站", UserType.UNLOGIN.code(),
                "NORMAL", RoleType.Nonoperation.code(), "地推员", null,
                null, "admin", "123456", operatorMobile);
        String operatorId = merchantParams.get("userId").toString();
        String stationId = merchantParams.get("stationId").toString();
        Long roleId = Long.valueOf(merchantParams.get("roleId").toString());
        //实体卡
        gasMerchantInitDataBase.initGasMerchantCard(partnerId, 1L, "Admin", entityNo,
                null, null, null);
        //会员
        gasUserInitDataBase.initUser(partnerId, userId1, password, nickName1,
                mobile1, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, userRawAddTIme, userRawAddTIme);
        if (testId == 1001) {
            Map<String, Object> userParams = gasUserInitDataBase.initUser(partnerId, userId, password, nickName, mobile,
                    registerFrom,
                    null, null, null, null, userRawAddTIme, userRawAddTIme);
            cardNo = userParams.get("accountNo").toString();
        }
        if (testId == 1002) {
            Map<String, Object> userParams = gasUserInitDataBase.initUser(partnerId, userId, password, nickName, mobile,
                    registerFrom,
                    userId1, mobile1, null, null, userRawAddTIme, userRawAddTIme);
            cardNo = userParams.get("accountNo").toString();
        }
        if (testId == 1003) {
            Map<String, Object> userParams = gasUserInitDataBase.initUser(partnerId, userId, password, nickName, mobile,
                    registerFrom,
                    operatorId, operatorMobile, stationId, null, userRawAddTIme, userRawAddTIme);
            cardNo = userParams.get("accountNo").toString();
        }
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, entityNo, innerNo,
                null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                cardNo, CardStatus.NORMAL.code(), entryAddTIme, entryAddTIme);
        //车辆信息
        userTestBase.insertUserCarInfo(0L, userId, carNumber, carType, null, AuditStatus.AGREE.code(),
                applyDate, auditDate, carRawAddTIme, carRawAddTIme);
        // 测试过程
        // 调用接口
        BizResult<QueryUserInfo> result = queryUserService.queryUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            userAssert(result.getInfo(), partnerId, userId, mobile,
                    null, nickName, null,
                    null, carNumber, MemberType.NORMAL.code(),
                    cardNo, registerFrom,
                    null, null,
                    null, false);
        }
        if (testId == 1002) {
            userAssert(result.getInfo(), partnerId, userId, mobile,
                    null, nickName, null,
                    null, carNumber, MemberType.NORMAL.code(),
                    cardNo, registerFrom, userId1, mobile1,
                    null, true);
        }
        if (testId == 1003) {
            userAssert(result.getInfo(), partnerId, userId, mobile,
                    null, nickName, null,
                    null, carNumber, MemberType.NORMAL.code(),
                    cardNo, registerFrom, operatorId, operatorMobile,
                    null, true);
        }
        if (testId == 1004) {
            assertEquals(null, result.getInfo());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserCardInfoByUserId(userId1);
        userTestBase.cleanUserCarInfoByUserId(userId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantCardByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasRoleById(roleId);
        merchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantStationByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryUserTestFailOne.csv")
    @DisplayName("通过手机号和短信验证码查询用户相关信息--参数非法")
    public void queryUserServiceQueryUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserByMobileOrder order
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
        BizResult<QueryUserInfo> result = queryUserService.queryUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.短信验证码错误
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryUserTestFailTwo.csv")
    @DisplayName("通过手机号和短信验证码查询用户相关信息--失败用例")
    public void queryUserServiceQueryUserTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserByMobileOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult<QueryUserInfo> result = queryUserService.queryUser(order);
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
            QueryUserInfo userInfo,
            String partnerId,
            String userId,
            String mobile,
            String realName,
            String nickName,
            String headImgUrl,
            String sex,
            String carNumber,
            String memberType,
            String cardNo,
            String source,
            String recommendId,
            String recommendMobile,
            Date birthday,
            boolean existPayPwd
    ) {
        assertEquals(partnerId, userInfo.getPlatPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(cardNo, userInfo.getCardNo());//不是取的加好油这边的卡号？明显有问题
        assertEquals(mobile, userInfo.getMobile());
        assertEquals(realName, userInfo.getRealName());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(headImgUrl, userInfo.getHeadImgUrl());
        assertEquals(sex, userInfo.getSex());
        assertEquals(carNumber, userInfo.getCarNumber());
        assertEquals(memberType, userInfo.getMemberType().code());
        assertEquals(source, userInfo.getSource().code());
        assertEquals(recommendId, userInfo.getRecommendId());
        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals(false, userInfo.isPayed());
        assertEquals(birthday, userInfo.getBirthday());
        assertEquals(existPayPwd, userInfo.isExistPayPwd());
    }
}
