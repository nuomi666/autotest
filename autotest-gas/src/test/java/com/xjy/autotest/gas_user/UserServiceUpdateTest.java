package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.order.UserUpdateOrder;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserCarInfoDO;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserPayToolInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/02/13.
 */
public class UserServiceUpdateTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserService userService;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;


    /**
     * 1001.用户没填写生日、车辆信息，更新用户信息
     * 1002.用户已经填写了生日、车辆信息，更新用户信息
     */
    @AutoTest(file = "gas_user/userServiceUpdateTestSuccess.csv")
    @DisplayName("修改用户--成功用例")
    public void userServiceUpdateTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String payPassword, String openId,
            String nickName, String mobile,
            String carNum,
            String registerFrom, String userInviteId,
            String userInviteMobile, String stationId,
            UserUpdateOrder order
    ) {
        // 清除数据
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2019-12-12");
        Date rawUpdateTime = DateUtils.parseDate("2019-12-12");
        Date birth = DateUtils.parseDate("2009-10-11");
        Date birthxx = DateUtils.parseDate("2012-12-12");
        if (testId == 1001) {
            birth = null;
        }
        gasUserInitDataBase.initUserAll(partnerId, userId, payPassword, openId,
                nickName, mobile, carNum, registerFrom, userInviteId,
                userInviteMobile, stationId, birth, rawAddTime, rawUpdateTime);
        // 测试过程
        order.setBirthday(birthxx);
        // 调用接口
        SimpleResult result = userService.update(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        sleep(3);
        UserDO userInfo = userTestBase.findUserByUserId(userId).get(0);
        List<UserCarInfoDO> cars = userTestBase.findUserCarInfoByUserId(userId);
        List<GasUserDO> silverUsers = silverboltTestBase.findGasUserByUserId(userId);
        List<UserPayToolInfoDO> toolInfos = userTestBase.findUserPayToolInfoByUserId(userId);
        if (testId == 1001) {
            userAssert(userInfo, partnerId, userId, mobile,
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    registerFrom, userInviteId, userInviteMobile,
                    DateUtil.dtSimpleFormat(order.getBirthday()).substring(5), order.getBirthday());
            silverboltUserAssert(silverUsers.get(0), partnerId, userId, mobile,
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    registerFrom, userInviteId, userInviteMobile,
                    DateUtil.dtSimpleFormat(order.getBirthday()).substring(5), order.getBirthday());
        } else {
            userAssert(userInfo, partnerId, userId, mobile,
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    registerFrom, userInviteId, userInviteMobile,
                    DateUtil.dtSimpleFormat(birth).substring(5), birth);
            silverboltUserAssert(silverUsers.get(0), partnerId, userId, mobile,
                    order.getRealName(), order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    registerFrom, userInviteId, userInviteMobile,
                    DateUtil.dtSimpleFormat(birth).substring(5), birth);
        }
        assertEquals(1, cars.size());
        assertEquals(order.getCarNumber(), cars.get(0).getCarNumber());
        assertEquals(order.getRealName(), xybUserTestBase.findUserByUserId(userId).get(0).getRealName());
        //推荐人信息没修改
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserSpreadLogByUserId(userId);
        userTestBase.cleanUserInviteLogByUserId(userId);
        userTestBase.cleanUserCarInfoByUserId(userId);
        userTestBase.cleanUserPayToolInfoByUserId(userId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanUserSpreadLogByUserId(userId);
        silverboltTestBase.cleanUserInviteLogByUserId(userId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/userServiceUpdateTestFailOne.csv")
    @DisplayName("修改用户--参数非法")
    public void userServiceUpdateTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserUpdateOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userService.update(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.用户不存在
     */
    @AutoTest(file = "gas_user/userServiceUpdateTestFailTwo.csv")
    @DisplayName("修改用户--失败用例")
    public void userServiceUpdateTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserUpdateOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(order.getUserId());
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = userService.update(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //推荐人信息没修改
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
}
