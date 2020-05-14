package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.UserStatus;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.merchant.api.facade.UserLoginService;
import com.xyb.gas.merchant.api.order.UserLogoutBossOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/02.
 */
public class UserLoginServiceLogoutTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserLoginService userLoginService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLogoutTestSuccess.csv")
    @DisplayName("登出商户平台--成功用例")
    public void userLoginServiceLogoutTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String model,
            String merchantStatus, String account,
            String password, String operatorMobile,
            UserLogoutBossOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initBossGasRole(partnerId, mobile,
                sourceKey, model, merchantStatus, UserType.BOSS.code(), UserStatus.NORMAL.code(), account,
                password, operatorMobile);
        String roleNo = param.get("roleNo").toString();
        String productId = param.get("productId").toString();
        String userId = param.get("userId").toString();
        String permissionId = param.get("permissionId").toString();
        // 测试过程
        order.setUserId(userId);
        // 调用接口
        SimpleResult result = userLoginService.logout(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanUserUniqueKeyByUserId(userId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLogoutTestFailOne.csv")
    @DisplayName("登出商户平台--参数非法")
    public void userLoginServiceLogoutTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UserLogoutBossOrder order
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
        SimpleResult result = userLoginService.logout(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
