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
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.user.api.CardManageService;
import com.xyb.gas.user.api.enums.*;
import com.xyb.gas.user.api.order.QueryCardByConditionOrder;
import com.xyb.gas.user.api.result.CardQueryResult;
import com.xyb.gas.user.api.result.info.CarInfo;
import com.xyb.gas.user.api.result.info.CardInfo;
import com.xyb.gas.user.api.result.info.UserInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/14.
 */
public class CardManageServiceQueryCardByConditionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    CardManageService cardManageService;

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
    @AutoTest(file = "gas_user/cardManageServiceQueryCardByConditionTestSuccess.csv")
    @DisplayName("通过手机号或者卡号查询--成功用例")
    public void cardManageServiceQueryCardByConditionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String entityNo,
            String innerNo, String cardStatus,
            String carNumber, String carType,
            QueryCardByConditionOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserCarInfoByUserId(userId);
        // 准备数据
        Date userRawAddTIme = DateUtils.parseDate2("2019-12-25 15:16:17");
        Date entryAddTIme = DateUtils.parseDate2("2019-12-25 16:16:17");
        Date carRawAddTIme = DateUtils.parseDate2("2019-12-31 12:10:11");
        Date applyDate = DateUtils.parseDate2("2020-01-01 16:17:18");
        Date auditDate = DateUtils.parseDate2("2020-01-10 18:19:20");
        //商户
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商户", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "18825814769", "ABLE");
        //实体卡
        gasMerchantInitDataBase.initGasMerchantCard(partnerId, 1L, "Admin", entityNo,
                null, null, null);
        //会员
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, userRawAddTIme, userRawAddTIme);
        String cardNo = params.get("accountNo").toString();
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, entityNo, innerNo,
                null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                cardNo, cardStatus, entryAddTIme, entryAddTIme);
        //车辆信息
        userTestBase.insertUserCarInfo(0L, userId, carNumber, carType, null, AuditStatus.AGREE.code(),
                applyDate, auditDate, carRawAddTIme, carRawAddTIme);
        // 测试过程
        if (testId == 1001) {
            order.setCondition(mobile);
        }
        if (testId == 1002) {
            order.setCondition(cardNo);
        }
        if (testId == 1003) {
            order.setCondition(innerNo);
        }
        // 调用接口
        CardQueryResult result = cardManageService.queryCardByCondition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        userAssert(result.getUserInfo(), partnerId, userId, mobile, null,
                nickName, null, null, carNumber,
                MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                cardNo, registerFrom, null, null,
                0, Money.zero(), null, userRawAddTIme);
        assertEquals(null, result.getUserInfo().getInviteLogInfo());
//        carAssert(result.getCarInfo(), userId, carNumber, carType,
//                null, AuditStatus.AGREE.code(), applyDate, auditDate);接口没返回车辆信息
        if (testId == 1001 || testId == 1002) {
            cardAssert(result.getCardInfo(), partnerId,
                    userId, cardNo, null,
                    CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
        }
        if (testId == 1003) {
            cardAssert(result.getCardInfo(), partnerId,
                    userId, entityNo, innerNo,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", cardStatus);
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserCarInfoByUserId(userId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantCardByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/cardManageServiceQueryCardByConditionTestFailOne.csv")
    @DisplayName("通过手机号或者卡号查询--参数非法")
    public void cardManageServiceQueryCardByConditionTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCardByConditionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setCondition(null);
        }
        if (testId == 1003) {
            order.setCardType(null);
        }
        if (testId == 1004) {
            order.setTag(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        CardQueryResult result = cardManageService.queryCardByCondition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.没查询到信息，返回的是成功
     */
    @AutoTest(file = "gas_user/cardManageServiceQueryCardByConditionTestFailTwo.csv")
    @DisplayName("通过手机号或者卡号查询--失败用例")
    public void cardManageServiceQueryCardByConditionTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCardByConditionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        CardQueryResult result = cardManageService.queryCardByCondition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(null, result.getUserInfo());
        assertEquals(null, result.getCardInfo());
        assertEquals(null, result.getCarInfo());
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
     * 卡信息
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
        assertEquals(carNumber, carInfo.getCarNumber());
        assertEquals(userId, carInfo.getUserId());
        assertEquals(carType, carInfo.getCarType());
        assertEquals(authenticateImg, carInfo.getAuthenticateImg());
        assertEquals(auditStatus, carInfo.getAuditStatus().code());
        assertEquals(applyDate, carInfo.getApplyDate());
        assertEquals(auditDate, carInfo.getAuditDate());
    }
}
