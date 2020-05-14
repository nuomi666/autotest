package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.AutoTestBase;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.order.UpdPayPwdOrder;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/02/14.
 */
public class UserServiceUpdPayPwdTest extends SpringBootTestBase {

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
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceUpdPayPwdTestSuccess.csv")
    @DisplayName("修改支付密码--成功用例")
    public void userServiceUpdPayPwdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String mobile,
            UpdPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        gasUserInitDataBase.initUser(partnerId, userId, order.getOldPayPwd(), "sorami",
                mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                null, null, null, null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userService.updPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        String passwordEnm = AutoTestBase.getUserPassword(order.getUserId(), order.getNewPayPwd());
        UserDO userInfo = userTestBase.findUserByUserId(userId).get(0);
        userAssert(userInfo, partnerId, userId, mobile,
                null, "sorami", null,
                Sex.OTHER.code(), MemberType.NORMAL.code(),
                GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                null, null, null);
        List<dal.model.user.UserDO> users = xybUserTestBase.findUserByUserId(userId);
        assertEquals(passwordEnm, users.get(0).getPayPassword());
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceUpdPayPwdTestFailOne.csv")
    @DisplayName("修改支付密码--参数非法")
    public void userServiceUpdPayPwdTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String mobile,
            UpdPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setOldPayPwd(null);
        }
        if (testId == 1003) {
            order.setNewPayPwd(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userService.updPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.用户不存在
     * 1002.旧密码错误
     */
    @AutoTest(file = "gas_user/userServiceUpdPayPwdTestFailTwo.csv")
    @DisplayName("修改支付密码--失败用例")
    public void userServiceUpdPayPwdTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String mobile, String oldPwd,
            UpdPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        if (testId != 1001) {
            gasUserInitDataBase.initUser(partnerId, userId, oldPwd, "sorami",
                    mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null, null, null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = userService.updPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        String passwordEnm = AutoTestBase.getUserPassword(order.getUserId(), order.getOldPayPwd());
        UserDO userInfo = userTestBase.findUserByUserId(userId).get(0);
        userAssert(userInfo, partnerId, userId, mobile,
                null, "sorami", null,
                null, MemberType.NORMAL.code(),
                GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                null, null, null);
        List<dal.model.user.UserDO> users = xybUserTestBase.findUserByUserId(userId);
        assertEquals(passwordEnm, users.get(0).getPayPassword());
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
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
        assertEquals(recommendId, userInfo.getRecommendId());
        assertEquals(recommendMobile, userInfo.getRecommendMobile());
        assertEquals("false", userInfo.getPayed());
        assertEquals(birthday, userInfo.getBirthday());
        assertEquals(shortBirthday, userInfo.getShortBirthday());
        assertEquals("default", userInfo.getImportSource());
    }
}
