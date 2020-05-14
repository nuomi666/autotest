package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.order.ValidatePayPwdOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/02/14.
 */
public class UserServiceValidatePayPwdTest extends SpringBootTestBase {

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
    @AutoTest(file = "gas_user/userServiceValidatePayPwdTestSuccess.csv")
    @DisplayName("校验支付密码--成功用例")
    public void userServiceValidatePayPwdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String mobile,
            ValidatePayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        gasUserInitDataBase.initUser(partnerId, order.getUserId(), order.getPayPwd(), "sorami",
                mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                null, null, null, null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userService.validatePayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserByUserId(order.getUserId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(order.getUserId());
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanAccountByUserId(order.getUserId());
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(order.getUserId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceValidatePayPwdTestFailOne.csv")
    @DisplayName("校验支付密码--参数非法")
    public void userServiceValidatePayPwdTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ValidatePayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setPayPwd(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userService.validatePayPwd(order);
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
    @AutoTest(file = "gas_user/userServiceValidatePayPwdTestFailTwo.csv")
    @DisplayName("校验支付密码--失败用例")
    public void userServiceValidatePayPwdTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String mobile,
            String pwd,
            ValidatePayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        if (testId != 1001) {
            gasUserInitDataBase.initUser(partnerId, order.getUserId(), pwd, "sorami",
                    mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null, null, null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = userService.validatePayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserByUserId(order.getUserId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(order.getUserId());
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(order.getUserId());
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(order.getUserId());
    }
}
