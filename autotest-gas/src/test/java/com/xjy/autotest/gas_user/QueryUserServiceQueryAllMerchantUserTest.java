package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.user.api.QueryUserService;
import com.xyb.gas.user.api.enums.*;
import com.xyb.gas.user.api.order.QueryAllMerchantUserOrder;
import com.xyb.gas.user.api.result.info.UserInfo;
import com.xyb.gas.user.api.result.info.UserInviteLogInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/15.
 */
public class QueryUserServiceQueryAllMerchantUserTest extends SpringBootTestBase {

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
     * 1001.只传商户ID查询，查出多条，每页显示10条，显示第1页
     * 1002.只传商户ID查询，查出多条，每页显示2条，显示第1页
     * 1003.只传商户ID查询，查出多条，每页显示2条，显示第2页
     * 1004.传入商户ID、开始时间和结束时间查询，查出多条，每页显示10条，显示第1页
     * 1005.传入商户ID和手机号查询，查出1条，每页显示10条，显示第1页
     * 1006.传入商户ID和关键字查询，查出1条，每页显示10条，显示第1页
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryAllMerchantUserTestSuccess.csv")
    @DisplayName("根据商户id分页查询该商户下的用户列表--成功用例")
    public void queryUserServiceQueryAllMerchantUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String userId1, String nickName1,
            String mobile1, String userId2,
            String nickName2, String mobile2,
            String entityNo, String innerNo,
            String carNumber, String carType,
            String operatorMobile,
            QueryAllMerchantUserOrder order
    ) {
        // 清除数据
        // 准备数据
        Date userRawAddTIme = DateUtils.parseDate2("2019-12-25 15:16:17");
        Date userRawAddTIme1 = DateUtils.parseDate2("2020-01-10 15:16:17");
        Date userRawAddTIme2 = DateUtils.parseDate2("2020-01-15 15:16:17");
        Date startTime = DateUtils.parseDate2("2020-01-01 15:16:17");
        Date endTime = DateUtils.parseDate2("2020-01-31 15:16:17");
        Date entryAddTIme = DateUtils.parseDate2("2019-12-25 16:16:17");
        Date carRawAddTIme = DateUtils.parseDate2("2019-12-31 12:10:11");
        Date applyDate = DateUtils.parseDate2("2020-01-01 16:17:18");
        Date auditDate = DateUtils.parseDate2("2020-01-10 18:19:20");
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
        //推荐人
        Map<String, Object> userParams = gasUserInitDataBase.initUser(partnerId, userId1, null, nickName1,
                mobile1, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, null, userRawAddTIme, userRawAddTIme);
        String cardNo = userParams.get("accountNo").toString();
        //会员推广
        Map<String, Object> userParams1 = gasUserInitDataBase.initUser(partnerId, userId2, null, nickName2,
                mobile2, GeneralizeSource.USER_GENERALIZE.code(),
                userId1, mobile1, null, null, userRawAddTIme1, userRawAddTIme1);
        String cardNo1 = userParams1.get("accountNo").toString();
        //员工推广
        Map<String, Object> userParams2 = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                GeneralizeSource.STAFF_GENERALIZE.code(),
                operatorId, operatorMobile, stationId, null, userRawAddTIme2, userRawAddTIme2);
        String cardNo2 = userParams2.get("accountNo").toString();

        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, entityNo, innerNo,
                null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                cardNo, CardStatus.NORMAL.code(), entryAddTIme, entryAddTIme);
        //车辆信息
        userTestBase.insertUserCarInfo(0L, userId, carNumber, carType, null, AuditStatus.AGREE.code(),
                applyDate, auditDate, carRawAddTIme, carRawAddTIme);
        // 测试过程
        if (testId == 1004) {
            order.setStartTime(startTime);
            order.setEndTime(endTime);
        }
        if (testId == 1005) {
            order.setMobile(mobile1);
        }
        if (testId == 1006) {
            order.setKeywords(mobile1);
        }
        // 调用接口
        PagedResult<UserInfo> result = queryUserService.queryAllMerchantUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserInfo> userInfos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(3, userInfos.size());
            userAssert(userInfos.get(0), partnerId, userId, mobile, null,
                    nickName, null, null, carNumber,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), entityNo,
                    cardNo2, GeneralizeSource.STAFF_GENERALIZE.code(), operatorId, operatorMobile,
                    0, Money.zero(), null, userRawAddTIme2);
            userAssert(userInfos.get(1), partnerId, userId2, mobile2, null,
                    nickName2, null, null, null,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                    cardNo1, GeneralizeSource.USER_GENERALIZE.code(), userId1, mobile1,
                    0, Money.zero(), null, userRawAddTIme1);
            userAssert(userInfos.get(2), partnerId, userId1, mobile1, null,
                    nickName1, null, null, null,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                    cardNo, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null, null,
                    0, Money.zero(), null, userRawAddTIme);

            inviteAssert(userInfos.get(0).getInviteLogInfo(), partnerId, operatorId, operatorMobile,
                    null, "地推员", null, null,
                    null, null, null, null);
            inviteAssert(userInfos.get(1).getInviteLogInfo(), partnerId, userId1, mobile1,
                    null, nickName1, null, null,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null);
            assertEquals(null, userInfos.get(2).getInviteLogInfo());
        }
        if (testId == 1002 || testId == 1004) {
            assertEquals(2, userInfos.size());
            userAssert(userInfos.get(0), partnerId, userId, mobile, null,
                    nickName, null, null, carNumber,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), entityNo,
                    cardNo2, GeneralizeSource.STAFF_GENERALIZE.code(), operatorId, operatorMobile,
                    0, Money.zero(), null, userRawAddTIme2);
            userAssert(userInfos.get(1), partnerId, userId2, mobile2, null,
                    nickName2, null, null, null,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                    cardNo1, GeneralizeSource.USER_GENERALIZE.code(), userId1, mobile1,
                    0, Money.zero(), null, userRawAddTIme1);

            inviteAssert(userInfos.get(0).getInviteLogInfo(), partnerId, operatorId, operatorMobile,
                    null, "地推员", null, null,
                    null, null, null, null);
            inviteAssert(userInfos.get(1).getInviteLogInfo(), partnerId, userId1, mobile1,
                    null, nickName1, null, null,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null);
        }
        if (testId == 1003 || testId == 1005 || testId == 1006) {
            assertEquals(1, userInfos.size());
            userAssert(userInfos.get(0), partnerId, userId1, mobile1, null,
                    nickName1, null, null, null,
                    MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null,
                    cardNo, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null, null,
                    0, Money.zero(), null, userRawAddTIme);
            assertEquals(null, userInfos.get(0).getInviteLogInfo());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanUserByUserId(userId2);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(userId2);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserByUserId(userId2);
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserCardInfoByUserId(userId1);
        userTestBase.cleanUserCardInfoByUserId(userId2);
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
        silverboltTestBase.cleanGasUserByUserId(userId2);
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryAllMerchantUserTestFailOne.csv")
    @DisplayName("根据商户id分页查询该商户下的用户列表--参数非法")
    public void queryUserServiceQueryAllMerchantUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryAllMerchantUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<UserInfo> result = queryUserService.queryAllMerchantUser(order);
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
}
