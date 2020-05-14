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
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.facade.MerchantUserService;
import com.xyb.gas.merchant.api.order.UpdUserPwdOrder;
import dal.model.gas_merchant.GasMerchantUserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/06.
 */
public class MerchantUserServiceUpdPwdTest extends SpringBootTestBase {

    @Reference(version = "1.0")
    MerchantUserService merchantUserService;

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
    @AutoTest(file = "gas_merchant/merchantUserServiceUpdPwdTestSuccess.csv")
    @DisplayName("修改用户密码--成功用例")
    public void merchantUserServiceUpdPwdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String stationCode,
            String stationName, String userType,
            String userStatus, String roleType,
            String roleName, String deviceType,
            String sourceName, String account,
            String password, String operatorMobile,
            UpdUserPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantUser(partnerId, mobile,
                sourceKey, "Merchant", "ABLE", stationCode,
                stationName, userType, userStatus, roleType, roleName,
                deviceType, account, sourceName, password, operatorMobile);
        String userId = params.get("userId").toString();
        String stationId = params.get("stationId").toString();
        String roleId = params.get("roleNo").toString();
        // 测试过程
        order.setUserId(userId);
        // 调用接口
        SimpleResult result = merchantUserService.updPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        GasMerchantUserDO userInfo = gasMerchantTestBase.findGasMerchantUserByUserId(userId).get(0);
        String pwdEnu = gasMerchantInitDataBase.encrypt(order.getNewPwd(), userInfo.getSalt());
        assertEquals(pwdEnu, userInfo.getPassword());
        sleep(3);//MQ接收如果延时会导致下面用例校验不过
        dal.model.gas_silverbolt.GasMerchantUserDO userInfo1 =
                silverboltTestBase.findGasMerchantUserByUserId(userId).get(0);
        assertNotEquals(pwdEnu, userInfo1.getPassword());
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanRoleByRoleNo(roleId);
        gasMerchantTestBase.cleanUserUniqueKeyByUserId(userId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceUpdPwdTestFailOne.csv")
    @DisplayName("修改用户密码--参数非法")
    public void merchantUserServiceUpdPwdTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdUserPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setOldPwd(null);
        }
        if (testId == 1003) {
            order.setNewPwd(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantUserService.updPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.用户不存在
     * 1002.密码错误
     * 1003.修改的用户已经登录
     */
    @AutoTest(file = "gas_merchant/merchantUserServiceUpdPwdTestFailTwo.csv")
    @DisplayName("修改用户密码--失败用例")
    public void merchantUserServiceUpdPwdTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String stationCode,
            String stationName, String userType,
            String userStatus, String roleType,
            String roleName, String deviceType,
            String sourceName, String account,
            String password, String operatorMobile,
            UpdUserPwdOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantUser(partnerId, mobile,
                sourceKey, "Merchant", "ABLE", stationCode,
                stationName, userType, userStatus, roleType, roleName,
                deviceType, account, sourceName, password, operatorMobile);
        String userId = params.get("userId").toString();
        String stationId = params.get("stationId").toString();
        String roleId = params.get("roleNo").toString();
        if (testId == 1003) {
            gasMerchantInitDataBase.initGasMerchantDevice(partnerId, userId,
                    "B1814738591", UserLoginStatus.login.code());
        }
        // 测试过程
        if (testId != 1001) {
            order.setUserId(userId);
        }
        // 调用接口
        SimpleResult result = merchantUserService.updPwd(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        GasMerchantUserDO userInfo = gasMerchantTestBase.findGasMerchantUserByUserId(userId).get(0);
        String pwdEnu = gasMerchantInitDataBase.encrypt(password, userInfo.getSalt());
        assertEquals(pwdEnu, userInfo.getPassword());
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanRoleByRoleNo(roleId);
        gasMerchantTestBase.cleanUserUniqueKeyByUserId(userId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantStationByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }
}
