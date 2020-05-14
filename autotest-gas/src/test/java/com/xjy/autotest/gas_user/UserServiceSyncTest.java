package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.SyncWeChatInfoOrder;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @author nuomi
 * Created on 2020/02/14.
 */
public class UserServiceSyncTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserService userService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 同步微信信息，当修改时，原来的用户性别不为空和other时，则不进行修改
     * 这里微信相关的信息没有同步修改分析，应该有问题
     * 1001.新增微信信息
     * 1002.修改性别为other的微信信息
     * 1003.修改性别不为other的微信信息
     */
    @AutoTest(file = "gas_user/userServiceSyncTestSuccess.csv")
    @DisplayName("同步微信信息--成功用例")
    public void userServiceSyncTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String mobile, String nickName,
            String headImgUrl, String sex,
            String sourceFrom,
            SyncWeChatInfoOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        // 准备数据
        //插入加好油会员
        userTestBase.insertUser(0L, userId, partnerId, partnerId, mobile, null, null,
                nickName, null, headImgUrl, sex, MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, GeneralizeSource.AUTONOMY_GENERALIZE.code(),
                null, null, "false", "default", null, null);
        silverboltTestBase.insertGasUser(0L, userId, partnerId, mobile, null, null, nickName,
                null, null, null, headImgUrl, null, null,
                sex, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                null, null, null, null, null,
                null, null, null, null, null, null,
                null, null);
        if (testId != 1001) {
            userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId, order.getOpenId(), sourceFrom, null,
                    null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = userService.sync(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        UserDO userInfo = userTestBase.findUserByUserId(userId).get(0);
        if (testId == 1003) {
            userAssert(userInfo, partnerId, userId, mobile,
                    null, order.getNickName(), order.getHeadImgUrl(),
                    sex, MemberType.NORMAL.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null);
        } else {
            userAssert(userInfo, partnerId, userId, mobile,
                    null, order.getNickName(), order.getHeadImgUrl(),
                    order.getSex().code(), MemberType.NORMAL.code(),
                    GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null);
        }
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/userServiceSyncTestFailOne.csv")
    @DisplayName("同步微信信息--参数非法")
    public void userServiceSyncTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            SyncWeChatInfoOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setOpenId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userService.sync(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 这里当用户信息和微信信息都为空时，没判断到。会导致数据库有脏数据
     * 1001.修改微信信息时，用户不存在
     */
    @AutoTest(file = "gas_user/userServiceSyncTestFailTwo.csv")
    @DisplayName("同步微信信息--失败用例")
    public void userServiceSyncTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String sourceFrom,
            SyncWeChatInfoOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = userService.sync(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserPayToolInfoByOpenId(order.getOpenId());
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
}
