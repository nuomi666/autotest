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
import com.xyb.gas.merchant.api.order.ModifyDeviceResourceOrder;
import dal.model.gas_merchant.GasDeviceResourceDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class DeviceResourceServiceModifyTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    DeviceResourceService deviceResourceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceModifyTestSuccess.csv")
    @DisplayName("修改终端资源--成功用例")
    public void deviceResourceServiceModifyTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long deviceId, DeviceType deviceType,
            ResourceType resourceType, String fatherName,
            String childName, String fatherCode, String childCode,
            ModifyDeviceResourceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(order.getCode());
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initDeviceResourceChild(deviceType.code(),
                resourceType.code(), resourceType.code(), fatherName, childName, fatherCode, childCode);
        for (String key : param.keySet()) {
            if (testId == 1001) {
                if ("parentId".equals(key)) {
                    deviceId = Long.valueOf(param.get(key).toString());
                }
            } else {
                if ("childId".equals(key)) {
                    deviceId = Long.valueOf(param.get(key).toString());
                }
            }
        }
        // 测试过程
        if (testId == 1001) {
            order.setIcon(null);
            order.setMemo(null);
            order.setOrderNo(null);
            order.setParentId(null);
            order.setUrl(null);
        }
        order.setId(deviceId);
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = deviceResourceService.modify(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        gasDeviceResourceAssert(deviceId, order.getDeviceType().code(), order.getParentId(), order.getName(),
                order.getCode(), order.getUrl(), order.getResourceType().code(), order.getOrderNo(), order.getIcon(),
                order.getMemo());
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(order.getCode());
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceModifyTestFailOne.csv")
    @DisplayName("修改终端资源--参数非法")
    public void deviceResourceServiceModifyTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setId(null);
        }
        if (testId == 1002) {
            order.setCode(null);
        }
        if (testId == 1003) {
            order.setName(null);
        }
        if (testId == 1004) {
            order.setDeviceType(null);
        }
        if (testId == 1005) {
            order.setResourceType(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        SimpleResult result = deviceResourceService.modify(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.终端资源不存在
     * 1002.修改的父级ID为本身
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceModifyTestFailTwo.csv")
    @DisplayName("修改终端资源--失败用例")
    public void deviceResourceServiceModifyTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long deviceId, DeviceType deviceType,
            ResourceType resourceType, String fatherName,
            String childName, String fatherCode, String childCode,
            ModifyDeviceResourceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(order.getCode());
        gasMerchantTestBase.cleanGasDeviceResourceById(order.getId());
        // 准备数据
        Map<String, Object> param = gasMerchantInitDataBase.initDeviceResourceChild(deviceType.code(),
                resourceType.code(), resourceType.code(), fatherName, childName, fatherCode, childCode);
        for (String key : param.keySet()) {
            if ("parentId".equals(key)) {
                deviceId = Long.valueOf(param.get(key).toString());
            }
        }
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1002) {
            order.setId(deviceId);
            order.setParentId(deviceId);
        }
        // 调用接口
        SimpleResult result = deviceResourceService.modify(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1002) {
            gasDeviceResourceAssert(deviceId, deviceType.code(), null, fatherName,
                    fatherCode, null, resourceType.code(), null, null, null);
        } else {
            gasDeviceResourceAssert(deviceId, deviceType.code(), order.getParentId(), fatherName,
                    fatherCode, null, resourceType.code(), null, null, null);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode);
    }

    /**
     * 终端资源表数据校验
     *
     * @param id
     * @param deviceType
     * @param parentId
     * @param deviceName
     * @param code
     * @param url
     * @param resourceType
     * @param orderNo
     * @param icon
     * @param memo
     */
    private void gasDeviceResourceAssert(
            Long id,
            String deviceType,
            Long parentId,
            String deviceName,
            String code,
            String url,
            String resourceType,
            Integer orderNo,
            String icon,
            String memo
    ) {
        List<GasDeviceResourceDO> deviceInfos = gasMerchantTestBase.findGasDeviceResourceById(id);
        assertEquals(1, deviceInfos.size());
        for (GasDeviceResourceDO deviceInfo : deviceInfos) {
            assertEquals(deviceType, deviceInfo.getDeviceType());
            assertEquals(parentId, deviceInfo.getParentId());
            assertEquals(deviceName, deviceInfo.getName());
            assertEquals(code, deviceInfo.getCode());
            assertEquals(url, deviceInfo.getUrl());
            assertEquals(resourceType, deviceInfo.getResourceType());
            assertEquals(orderNo, deviceInfo.getOrderNo());
            assertEquals(icon, deviceInfo.getIcon());
            assertEquals(memo, deviceInfo.getMemo());
            // 创建时间等于更新时间？？
//            assertEquals(deviceInfo.getRawAddTime(), deviceInfo.getRawUpdateTime());
        }
    }
}
