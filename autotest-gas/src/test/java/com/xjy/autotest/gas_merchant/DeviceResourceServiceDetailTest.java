package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.ResourceType;
import com.xyb.gas.merchant.api.facade.DeviceResourceService;
import com.xyb.gas.merchant.api.info.ResourceInfo;
import com.xyb.gas.merchant.api.order.common.CommonAbstractOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/10/14.
 */
public class DeviceResourceServiceDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    DeviceResourceService deviceResourceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.查询父级资源
     * 1002.查询子级资源
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceDetailTestSuccess.csv")
    @DisplayName("查询资源详情--成功用例")
    public void deviceResourceServiceDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long childId, Long parentId, DeviceType deviceType,
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
                parentId = Long.valueOf(param.get(key).toString());
            }
            if ("childId".equals(key)) {
                childId = Long.valueOf(param.get(key).toString());
            }
        }
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setId(parentId);
        } else {
            order.setId(childId);
        }
        // 调用接口
        BizResult<ResourceInfo> result = deviceResourceService.detail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            gasDeviceResourceAssert(result.getInfo(), parentId, null, fatherName, null, fatherCode, null, null,
                    resourceType.code(), null, null, null);
        } else {
            gasDeviceResourceAssert(result.getInfo(), childId, parentId, childName, fatherName, childCode, fatherCode
                    , null, resourceType.code(), null, null, null);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceById(parentId);
        gasMerchantTestBase.cleanGasDeviceResourceById(childId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceDetailTestFailOne.csv")
    @DisplayName("查询资源详情--参数非法")
    public void deviceResourceServiceDetailTestFailOne(
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
            order.setGid(null);
        }
        if (testId == 1002) {
            order.setId(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<ResourceInfo> result = deviceResourceService.detail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.资源不存在
     */
    @AutoTest(file = "gas_merchant/deviceResourceServiceDetailTestFailTwo.csv")
    @DisplayName("查询资源详情--失败用例")
    public void deviceResourceServiceDetailTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonAbstractOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceById(order.getId());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        BizResult<ResourceInfo> result = deviceResourceService.detail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(null, result.getInfo());
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceById(order.getId());
    }

    /**
     * 资源详情校验
     *
     * @param deviceInfo
     * @param id
     * @param parentId
     * @param name
     * @param parentName
     * @param code
     * @param parentCode
     * @param url
     * @param resourceType
     * @param orderNo
     * @param icon
     * @param memo
     */
    private void gasDeviceResourceAssert(
            ResourceInfo deviceInfo,
            Long id,
            Long parentId,
            String name,
            String parentName,
            String code,
            String parentCode,
            String url,
            String resourceType,
            Integer orderNo,
            String icon,
            String memo
    ) {
        assertEquals(id, deviceInfo.getId());
        assertEquals(name, deviceInfo.getName());
        assertEquals(code, deviceInfo.getCode());
        assertEquals(parentId, deviceInfo.getParentId());
        assertEquals(parentName, deviceInfo.getParentName());
        assertEquals(parentCode, deviceInfo.getParentCode());
        assertEquals(url, deviceInfo.getUrl());
        assertEquals(resourceType, deviceInfo.getResourceType().code());
        assertEquals(orderNo, deviceInfo.getOrderNo());
        assertEquals(icon, deviceInfo.getIcon());
        assertEquals(memo, deviceInfo.getMemo());
    }
}
