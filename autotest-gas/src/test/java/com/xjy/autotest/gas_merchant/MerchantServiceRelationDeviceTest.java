package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.UserLoginStatus;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.RelationMerchantDeviceOrder;
import dal.model.gas_merchant.GasMerchantDeviceDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/11/26.
 */
public class MerchantServiceRelationDeviceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001.新增pos机配置
     * 1002.原来存在已登录的pos机配置，再新增新的pos机
     * 1003.原来存在未登录的pos机配置，修改原来的pos机配置信息
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationDeviceTestSuccess.csv")
    @DisplayName("配置终端--成功用例")
    public void merchantServiceRelationDeviceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String userId,
            String deviceCode, String deviceCode1,
            String deviceCode2, String loginStatus,
            RelationMerchantDeviceOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchantDevice(order.getPlatPartnerId(), userId, deviceCode, loginStatus);
        }
        // 测试过程
        Set<String> deviceCodes = Sets.newHashSet();
        deviceCodes.add(deviceCode1);
        deviceCodes.add(deviceCode2);
        if (testId == 1002) {
            deviceCodes.add(deviceCode);
        }
        order.setDeviceCodes(deviceCodes);
        // 调用接口
        SimpleResult result = merchantService.relationDevice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1002) {
            gasMerchantDeviceAssert(order.getPlatPartnerId(), userId, deviceCode, loginStatus);
            gasMerchantDeviceAssert(order.getPlatPartnerId(), null, deviceCode1, null);
            gasMerchantDeviceAssert(order.getPlatPartnerId(), null, deviceCode2, null);
        }
        if (testId == 1001 || testId == 1003) {
            gasMerchantDeviceAssert(order.getPlatPartnerId(), null, deviceCode1, null);
            gasMerchantDeviceAssert(order.getPlatPartnerId(), null, deviceCode2, null);
        }
        // 清除数据
        merchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001.商家id为空
     * 1002.终端类型为空
     * 1003.pos机编号为空
     * 1004.gid为空
     * 1005.order为空
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationDeviceTestFailOne.csv")
    @DisplayName("配置终端--参数非法")
    public void merchantServiceRelationDeviceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String deviceCode,
            RelationMerchantDeviceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        Set<String> deviceCodes = Sets.newHashSet();
        if (testId != 1003) {
            deviceCodes.add(deviceCode);
        }
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setDeviceType(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        order.setDeviceCodes(deviceCodes);
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantService.relationDevice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.删除已经登录的终端
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationDeviceTestFailTwo.csv")
    @DisplayName("配置终端--失败用例")
    public void merchantServiceRelationDeviceTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String userId,
            String deviceCode, String deviceCode1,
            RelationMerchantDeviceOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantDevice(order.getPlatPartnerId(), userId, deviceCode,
                UserLoginStatus.login.code());
        // 测试过程
        Set<String> deviceCodes = Sets.newHashSet();
        deviceCodes.add(deviceCode1);
        order.setDeviceCodes(deviceCodes);
        // 调用接口
        SimpleResult result = merchantService.relationDevice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        gasMerchantDeviceAssert(order.getPlatPartnerId(), userId, deviceCode, UserLoginStatus.login.code());
        // 清除数据
        merchantTestBase.cleanGasMerchantDeviceByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 断言商家终端配置表
     *
     * @param platPartnerId
     * @param userId
     * @param deviceCode
     * @param loginStatus
     */
    private void gasMerchantDeviceAssert(
            String platPartnerId,
            String userId,
            String deviceCode,
            String loginStatus
    ) {
        List<GasMerchantDeviceDO> deviceInfos = merchantTestBase.findGasMerchantDeviceByDeviceCode(deviceCode);
        assertTrue(deviceInfos.size() > 0);
        for (GasMerchantDeviceDO deviceInfo : deviceInfos) {
            assertEquals(platPartnerId, deviceInfo.getPlatPartnerId());
            assertEquals(platPartnerId, deviceInfo.getPartnerId());
            assertEquals(DeviceType.POS.code(), deviceInfo.getDeviceType());
            assertEquals(deviceCode, deviceInfo.getDeviceCode());
            assertEquals(userId, deviceInfo.getLoginUserId());
            assertEquals(loginStatus, deviceInfo.getLoginStatus());
        }
    }
}
