package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.ResourceType;
import com.xyb.gas.merchant.api.facade.DeviceResourceService;
import com.xyb.gas.merchant.api.order.common.CommonAbstractOrder;
import dal.model.gas_merchant.GasDeviceResourceDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class DeviceResourceServiceDeleteTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    DeviceResourceService deviceResourceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.删除终端类型为POS的
     * 1002.删除终端类型为BOSS的
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceDeleteTestSuccess.csv")
    @DisplayName("删除终端资源--成功用例")
    public void deviceResourceServiceDeleteTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long deviceId, DeviceType deviceType,
            ResourceType resourceType, String fatherName,
            String childName, String fatherCode, String childCode,
            CommonAbstractOrder order
    ) {
        // 清除数据
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initDeviceResourceChild(deviceType.code(),
                resourceType.code(), resourceType.code(), fatherName, childName, fatherCode, childCode);
        for (String key : param.keySet()) {
            if ("parentId".equals(key)) {
                deviceId = Long.valueOf(param.get(key).toString());
            }
        }
        // 测试过程
        order.setId(deviceId);
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = deviceResourceService.delete(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasDeviceResourceDO> gasDeviceResourcexx =
                gasMerchantTestBase.findGasDeviceResourceById(deviceId);
        assertTrue(gasDeviceResourcexx.size() == 0);
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceById(deviceId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceDeleteTestFailOne.csv")
    @DisplayName("删除终端资源--参数非法")
    public void deviceResourceServiceDeleteTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonAbstractOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = deviceResourceService.delete(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.资源不存在
     * 1002.资源已经分配给商户，不能删除
     * 1003.资源已经分配给角色，不能删除
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceDeleteTestFailTwo.csv")
    @DisplayName("删除终端资源--失败用例")
    public void deviceResourceServiceDeleteTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long deviceId, DeviceType deviceType,
            ResourceType resourceType, String fatherName,
            String childName, String fatherCode, String childCode,
            CommonAbstractOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceById(order.getId());
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initDeviceResourceChild(deviceType.code(),
                resourceType.code(), resourceType.code(), fatherName, childName, fatherCode, childCode);
        for (String key : param.keySet()) {
            if ("parentId".equals(key)) {
                deviceId = Long.valueOf(param.get(key).toString());
            }
        }
        if (testId == 1002) {
            gasMerchantInitDataBase.initGasMerchantResource("S0301810232300000120", deviceId, null, null);
        }
        if (testId == 1003) {
            gasMerchantInitDataBase.initGasRoleResource(1L, deviceId, null, null);
        }
        // 测试过程
        if (testId == 1002 || testId == 1003) {
            order.setId(deviceId);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = deviceResourceService.delete(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasDeviceResourceDO> gasDeviceResourcexx =
                gasMerchantTestBase.findGasDeviceResourceById(deviceId);
        assertTrue(gasDeviceResourcexx.size() > 0);
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceById(deviceId);
        gasMerchantTestBase.cleanGasMerchantResourceByResourceId(deviceId);
        gasMerchantTestBase.cleanGasMerchantRoleResourceByResourceId(deviceId);
    }
}
