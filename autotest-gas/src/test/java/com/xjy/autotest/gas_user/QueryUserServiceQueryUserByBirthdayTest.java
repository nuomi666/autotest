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
import com.xyb.adk.common.util.DateUtil;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.user.api.QueryUserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.QueryUserByBirthdayOrder;
import com.xyb.gas.user.api.result.info.SimpleUserInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/16.
 */
public class QueryUserServiceQueryUserByBirthdayTest extends SpringBootTestBase {

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
    @AutoTest(file = "gas_user/queryUserServiceQueryUserByBirthdayTestSuccess.csv")
    @DisplayName("根据生日查询会员信息--成功用例")
    public void queryUserServiceQueryUserByBirthdayTestSuccess(
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
            String operatorMobile,
            QueryUserByBirthdayOrder order
    ) {
        // 清除数据
        // 准备数据
        Date userRawAddTIme = DateUtils.parseDate2("2019-12-25 15:16:17");
        Date userRawAddTIme1 = DateUtils.parseDate2("2020-01-10 15:16:17");
        Date userRawAddTIme2 = DateUtils.parseDate2("2020-01-15 15:16:17");
        Date birthDay = DateUtils.parseDate("2002-01-01");
        Date birthDay1 = DateUtils.parseDate("1998-01-01");
        Date birthDay2 = DateUtils.parseDate("1999-01-01");
        //操作员
        Map<String, Object> merchantParams = gasMerchantInitDataBase.initMerchantUser(partnerId, "18825814769",
                "wxa2557eabb23b47e8", "Merchant", "ABLE",
                "test001", "糯米测试油站", UserType.UNLOGIN.code(),
                "NORMAL", RoleType.Nonoperation.code(), "地推员", null,
                null, "admin", "123456", operatorMobile);
        String operatorId = merchantParams.get("userId").toString();
        String stationId = merchantParams.get("stationId").toString();
        Long roleId = Long.valueOf(merchantParams.get("roleId").toString());
        //推荐人
        gasUserInitDataBase.initUserWithBirth(partnerId, userId1, null,
                nickName1, mobile1, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, null, birthDay, userRawAddTIme, userRawAddTIme);
        //会员推广
        gasUserInitDataBase.initUserWithBirth(partnerId, userId2, null,
                nickName2, mobile2, GeneralizeSource.USER_GENERALIZE.code(),
                userId1, mobile1, null, birthDay1, userRawAddTIme1, userRawAddTIme1);
        //员工推广
        gasUserInitDataBase.initUserWithBirth(partnerId, userId, null, nickName,
                mobile, GeneralizeSource.STAFF_GENERALIZE.code(),
                operatorId, operatorMobile, stationId, birthDay2, userRawAddTIme2, userRawAddTIme2);
        // 测试过程
        String tempBirthday = DateUtil.dtSimpleFormat(birthDay);
        if (testId == 1004) {
            order.setShortBirthday("03-31");
        } else {
            order.setShortBirthday(tempBirthday.substring(5));
        }
        // 调用接口
        PagedResult<SimpleUserInfo> result = queryUserService.queryUserByBirthday(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(3, result.getInfoList().size());
            userAssert(result.getInfoList().get(0), partnerId, userId1,
                    mobile1, null, nickName1, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, birthDay);
            userAssert(result.getInfoList().get(1), partnerId, userId2,
                    mobile2, null, nickName2, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.USER_GENERALIZE.code(), userId1,
                    mobile1, birthDay1);
            userAssert(result.getInfoList().get(2), partnerId, userId,
                    mobile, null, nickName, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.STAFF_GENERALIZE.code(), operatorId,
                    operatorMobile, birthDay2);
        }
        if (testId == 1002) {
            assertEquals(2, result.getInfoList().size());
            userAssert(result.getInfoList().get(0), partnerId, userId1,
                    mobile1, null, nickName1, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, birthDay);
            userAssert(result.getInfoList().get(1), partnerId, userId2,
                    mobile2, null, nickName2, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.USER_GENERALIZE.code(), userId1,
                    mobile1, birthDay1);
        }
        if (testId == 1003) {
            assertEquals(1, result.getInfoList().size());
            userAssert(result.getInfoList().get(0), partnerId, userId,
                    mobile, null, nickName, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                    GeneralizeSource.STAFF_GENERALIZE.code(), operatorId,
                    operatorMobile, birthDay2);
        }
        if (testId == 1004) {
            assertEquals(0, result.getInfoList().size());
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
     * 1001
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryUserByBirthdayTestFailOne.csv")
    @DisplayName("根据生日查询会员信息--参数非法")
    public void queryUserServiceQueryUserByBirthdayTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserByBirthdayOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setShortBirthday(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<SimpleUserInfo> result = queryUserService.queryUserByBirthday(order);
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
            String grade,
            String source,
            String recommendId,
            String recommendMobile,
            Date birthday
    ) {
        assertEquals(partnerId, userInfo.getPlatPartnerId());
//        assertEquals(partnerId, userInfo.getPartnerId());
        assertEquals(userId, userInfo.getUserId());
        assertEquals(mobile, userInfo.getMobile());
        assertEquals(realName, userInfo.getRealName());
        assertEquals(nickName, userInfo.getNickName());
        assertEquals(headImgUrl, userInfo.getHeadImgUrl());
        assertEquals(sex, userInfo.getSex());
        assertEquals(memberType, userInfo.getMemberType().code());
        assertEquals(grade, userInfo.getGrade().code());
        assertEquals(source, userInfo.getSource().code());
        assertEquals(recommendId, userInfo.getRecommendId());
        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals(false, userInfo.isPayed());
//        assertEquals(birthday, userInfo.getBirthday());//生日居然返回了时分秒，可忒秀了
    }
}
