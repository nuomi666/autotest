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
import com.xyb.gas.merchant.api.order.AddDeviceResourceOrder;
import dal.model.gas_merchant.GasDeviceResourceDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class DeviceResourceServiceAddTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    DeviceResourceService deviceResourceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001只填必填项，终端为POS，资源为菜单
     * 1002填所有项，终端为BOSS，资源为功能，无父ID
     * 1003填所有项，终端为BOSS，资源为菜单，有父ID
     * 1004填所有项，终端为BOSS，资源为菜单，父ID为子菜单
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceAddTestSuccess.csv")
    @DisplayName("创建终端资源--成功用例")
    public void deviceResourceServiceAddTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long parentId,
            AddDeviceResourceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(order.getCode());
        // 准备数据
        if (testId == 1002) {//父级
            Map<String, Object> param = gasMerchantInitDataBase.initDeviceResource(DeviceType.BOSS.code(),
                    ResourceType.MENU.code(), "会员中心", "MENU0488");
            for (String key : param.keySet()) {
                if ("parentId".equals(key)) {
                    parentId = Long.valueOf(param.get(key).toString());
                }
            }
        }
        if (testId == 1003 || testId == 1004) {//子级
            Map<String, Object> param = gasMerchantInitDataBase.initDeviceResourceChild(DeviceType.BOSS.code(),
                    ResourceType.MENU.code(), ResourceType.MENU.code(), "订单中心", "消费订单", "MENU0489", "MENU0490");
            for (String key : param.keySet()) {
                if (testId == 1003) {
                    if ("parentId".equals(key)) {
                        parentId = Long.valueOf(param.get(key).toString());
                    }
                }
                if (testId == 1004) {
                    if ("childId".equals(key)) {
                        parentId = Long.valueOf(param.get(key).toString());
                    }
                }
            }
        }
        // 测试过程
        if (testId >= 1002) {
            order.setParentId(parentId);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = deviceResourceService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        gasDeviceResourceAssert(1, order.getDeviceType().code(), order.getParentId(), order.getName(),
                order.getCode(), order.getUrl(), order.getResourceType().code(), order.getOrderNo(), order.getIcon(),
                order.getMemo());
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(order.getCode());
        gasMerchantTestBase.cleanGasDeviceResourceByCode("MENU0488");
        gasMerchantTestBase.cleanGasDeviceResourceByCode("MENU0489");
        gasMerchantTestBase.cleanGasDeviceResourceByCode("MENU0490");
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceAddTestFailOne.csv")
    @DisplayName("创建终端资源--参数非法")
    public void deviceResourceServiceAddTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setCode(null);
        }
        if (testId == 1002) {
            order.setName(null);
        }
        if (testId == 1003) {
            order.setResourceType(null);
        }
        if (testId == 1004) {
            order.setDeviceType(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = deviceResourceService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001相同类型的资源已经存在
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceAddTestFailTwo.csv")
    @DisplayName("创建终端资源--失败用例")
    public void deviceResourceServiceAddTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initDeviceResource(order.getDeviceType().code(), ResourceType.MENU.code(), "会员中心",
                order.getCode());
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = deviceResourceService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        gasDeviceResourceAssert(1, order.getDeviceType().code(), order.getParentId(), "会员中心",
                order.getCode(), null, ResourceType.MENU.code(), null, null,
                null);
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(order.getDeviceType().code());
    }

    /**
     * 终端资源表数据校验
     *
     * @param count
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
            int count,
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
        List<GasDeviceResourceDO> deviceInfos = gasMerchantTestBase.findGasDeviceResourceByCode(code);
        assertEquals(count, deviceInfos.size());
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
