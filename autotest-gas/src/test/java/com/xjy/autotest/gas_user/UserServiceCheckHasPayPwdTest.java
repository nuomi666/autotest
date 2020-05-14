package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserService;
import com.xyb.gas.user.api.enums.GeneralizeSource;
import com.xyb.gas.user.api.order.CheckHasPayPwdOrder;
import com.xyb.gas.user.api.result.CheckHasPayPwdResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/02/14.
 */
public class UserServiceCheckHasPayPwdTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserService userService;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceCheckHasPayPwdTestSuccess.csv")
    @DisplayName("是否设置过支付密码--成功用例")
    public void userServiceCheckHasPayPwdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String mobile,
            String pwd,
            CheckHasPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        if (testId == 1001) {
            gasUserInitDataBase.initUser(partnerId, order.getUserId(), null, "sorami",
                    mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null, null, null);
        } else {
            gasUserInitDataBase.initUser(partnerId, order.getUserId(), pwd, "sorami",
                    mobile, GeneralizeSource.AUTONOMY_GENERALIZE.code(), null,
                    null, null, null, null, null);
        }
        // 测试过程
        // 调用接口
        CheckHasPayPwdResult result = userService.checkHasPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertFalse(result.isExistPayPwd());
        } else {
            assertTrue(result.isExistPayPwd());
        }
        // 清除数据
        userTestBase.cleanUserByUserId(order.getUserId());
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(order.getUserId());
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(order.getUserId());
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(order.getUserId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userServiceCheckHasPayPwdTesFailOne.csv")
    @DisplayName("是否设置过支付密码--参数非法")
    public void userServiceCheckHasPayPwdTesFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CheckHasPayPwdOrder order
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
        CheckHasPayPwdResult result = userService.checkHasPayPwd(order);
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
    @AutoTest(file = "gas_user/userServiceCheckHasPayPwdTestFailTwo.csv")
    @DisplayName("是否设置过支付密码--失败用例")
    public void userServiceCheckHasPayPwdTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CheckHasPayPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        CheckHasPayPwdResult result = userService.checkHasPayPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
