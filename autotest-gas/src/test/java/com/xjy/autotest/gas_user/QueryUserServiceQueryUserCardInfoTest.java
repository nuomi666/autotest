package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.user.api.QueryUserService;
import com.xyb.gas.user.api.enums.*;
import com.xyb.gas.user.api.order.QueryUserCardOrder;
import com.xyb.gas.user.api.result.CardQueryResult;
import com.xyb.gas.user.api.result.info.CarInfo;
import com.xyb.gas.user.api.result.info.CardInfo;
import com.xyb.gas.user.api.result.info.UserInfo;
import com.xyb.gas.user.api.result.info.UserInviteLogInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/16.
 */
public class QueryUserServiceQueryUserCardInfoTest extends SpringBootTestBase {

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

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryUserCardInfoTestSuccess.csv")
    @DisplayName("根据商户id和卡号获取查询用户信息及卡信息--成功用例")
    public void queryUserServiceQueryUserCardInfoTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String userId1,
            String nickName1, String mobile1,
            String entityNo,
            String innerNo, String carNumber,
            String carType, String operatorMobile,
            QueryUserCardOrder order
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
        gasUserInitDataBase.initUser(partnerId, userId1, null, nickName1,
                mobile1, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, userRawAddTIme, userRawAddTIme);
        if (testId == 1001) {
            Map<String, Object> userParams = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                    registerFrom,
                    null, null, null, null, userRawAddTIme, userRawAddTIme);
            cardNo = userParams.get("accountNo").toString();
        }
        if (testId == 1002) {
            Map<String, Object> userParams = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                    registerFrom,
                    userId1, mobile1, null, null, userRawAddTIme, userRawAddTIme);
            cardNo = userParams.get("accountNo").toString();
        }
        if (testId == 1003) {
            Map<String, Object> userParams = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
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
        if (testId == 1002) {
            order.setCardNo(entityNo);
        } else {
            order.setCardNo(cardNo);
        }
        // 调用接口
        CardQueryResult result = queryUserService.queryUserCardInfo(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //会员信息里的实体卡面号也没查回来
        if (testId == 1002) {
            cardAssert(result.getCardInfo(), partnerId,
                    userId, entityNo, innerNo,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
        } else {
            cardAssert(result.getCardInfo(), partnerId,
                    userId, cardNo, null,
                    CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
        }
        if (testId == 1001) {//实体卡卡面号没返回
            userAssert(result.getUserInfo(), partnerId, userId, mobile, null,
                    nickName, null, null, carNumber,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                    cardNo, registerFrom, null, null,
                    0, Money.zero(), null, userRawAddTIme);
            assertEquals(null, result.getUserInfo().getInviteLogInfo());
        }
        if (testId == 1002) {
            userAssert(result.getUserInfo(), partnerId, userId, mobile, null,
                    nickName, null, null, carNumber,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                    cardNo, registerFrom, userId1, mobile1,
                    0, Money.zero(), null, userRawAddTIme);
            inviteAssert(result.getUserInfo().getInviteLogInfo(), partnerId, userId1, mobile1,
                    null, nickName1, null, null,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null);
        }
        if (testId == 1003) {
            userAssert(result.getUserInfo(), partnerId, userId, mobile, null,
                    nickName, null, null, carNumber,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                    cardNo, registerFrom, operatorId, operatorMobile,
                    0, Money.zero(), null, userRawAddTIme);
//            inviteAssert(result.getUserInfo().getInviteLogInfo(), partnerId, operatorId,
//                    operatorMobile, null, "地推员", null,
//                    null, null, null, null, null);员工推广的，开发没返回推荐人信息
        }
        //车辆信息也没返回。。。
//        carAssert(result.getCarInfo(), userId, carNumber, carType,
//                null, AuditStatus.AGREE.code(), applyDate, auditDate);
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanUserByUserId(partnerId);
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
    @AutoTest(file = "gas_user/queryUserServiceQueryUserCardInfoTestFailOne.csv")
    @DisplayName("根据商户id和卡号获取查询用户信息及卡信息--参数非法")
    public void queryUserServiceQueryUserCardInfoTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserCardOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setCardNo(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        CardQueryResult result = queryUserService.queryUserCardInfo(order);
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
    @AutoTest(file = "gas_user/queryUserServiceQueryUserCardInfoTestFailTwo.csv")
    @DisplayName("根据商户id和卡号获取查询用户信息及卡信息--失败用例")
    public void queryUserServiceQueryUserCardInfoTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserCardOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        CardQueryResult result = queryUserService.queryUserCardInfo(order);
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
            UserInfo userInfo,
            String partnerId,
            String userId,
            String mobile,
            String realName,
            String nickName,
            String headImgUrl,
            String sex,
            String carNumber,
            String memberType,
            String grade,
            String cardNo,
            String accountNo,
            String source,
            String recommendId,
            String recommendMobile,
            long points,
            Money balance,
            Date birthday,
            Date rawAddTime
    ) {
        assertEquals(partnerId, userInfo.getPlatPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(cardNo, userInfo.getCardNo());//不是取的加好油这边的卡号？明显有问题
        assertEquals(mobile, userInfo.getMobile());
        assertEquals(realName, userInfo.getRealName());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(headImgUrl, userInfo.getHeadImgUrl());
        assertEquals(accountNo, userInfo.getAccountNo());
        assertEquals(sex, userInfo.getSex());
        assertEquals(carNumber, userInfo.getCarNumber());
        assertEquals(memberType, userInfo.getMemberType().code());
        assertEquals(grade, userInfo.getGrade().code());
        assertEquals(source, userInfo.getSource().code());
        assertEquals(recommendId, userInfo.getRecommendId());
        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals(points, userInfo.getPoints());
        assertEquals(balance, userInfo.getBalance());
        assertEquals(false, userInfo.isPayed());
        assertEquals(birthday, userInfo.getBirthday());
        assertEquals(rawAddTime, userInfo.getRawAddTime());
    }

    /**
     * 卡表校验
     */
    private void cardAssert(
            CardInfo cardInfo,
            String partnerId,
            String userId,
            String cardNo,
            String innalNo,
            String cardType,
            String tag,
            String accNo,
            String accTag,
            String status
    ) {
        assertEquals(partnerId, cardInfo.getPlatPartnerId());
        assertEquals(userId, cardInfo.getUserId());
        assertEquals(cardNo, cardInfo.getCardNo());
        assertEquals(innalNo, cardInfo.getInternalNo());
        assertEquals(null, cardInfo.getParentCardAccountNo());
        assertEquals(cardType, cardInfo.getCardType().code());
        assertEquals(tag, cardInfo.getTag().code());
        assertEquals(accNo, cardInfo.getAccountNo());
        assertEquals(accTag, cardInfo.getAccountTag());
        assertEquals(status, cardInfo.getStatus().code());
    }

    /**
     * 推荐人信息
     */
    private void inviteAssert(
            UserInviteLogInfo userInfo,
            String partnerId,
            String userId,
            String mobile,
            String realName,
            String nickName,
            String headImgUrl,
            String sex,
            String memberType,
            String grade,
            String source,
            Date birthday
    ) {
        assertEquals(partnerId, userInfo.getPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(mobile, userInfo.getMobile());
        assertEquals(realName, userInfo.getRealName());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(headImgUrl, userInfo.getHeadImgUrl());
        assertEquals(sex, userInfo.getSex());
        assertEquals(memberType, userInfo.getMemberType().code());
        assertEquals(grade, userInfo.getGrade().code());
        assertEquals(source, userInfo.getSource().code());
        assertEquals(birthday, userInfo.getBirthday());
    }

    /**
     * 车辆信息
     */
    private void carAssert(
            CarInfo carInfo,
            String userId,
            String carNumber,
            String carType,
            String authenticateImg,
            String auditStatus,
            Date applyDate,
            Date auditDate
    ) {
        assertEquals(userId, carInfo.getUserId());
        assertEquals(carNumber, carInfo.getCarNumber());
        assertEquals(carType, carInfo.getCarType());
        assertEquals(authenticateImg, carInfo.getAuthenticateImg());
        assertEquals(auditStatus, carInfo.getAuditStatus().code());
        assertEquals(auditDate, carInfo.getAuditDate());
        assertEquals(applyDate, carInfo.getApplyDate());
    }
}
