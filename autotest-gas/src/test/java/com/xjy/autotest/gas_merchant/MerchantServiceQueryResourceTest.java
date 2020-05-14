package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.info.ResourceInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantDeviceResourceOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/11/25.
 */
public class MerchantServiceQueryResourceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceQueryResourceTestSuccess.csv")
    @DisplayName("查询商家终端菜单资源--成功用例")
    public void merchantServiceQueryResourceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String deviceType, String fatherType, String type,
            String fatherName, String name, String fatherCode, String childCode,
            QueryMerchantDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        Long parentResourceId = null;
        Long childResourceId = null;
        Map<String, Object> sourceIds = gasMerchantInitDataBase.initDeviceResourceChild(deviceType, fatherType, type,
                fatherName, name, fatherCode, childCode);
        parentResourceId = Long.valueOf(sourceIds.get("parentId").toString());
        childResourceId = Long.valueOf(sourceIds.get("childId").toString());
        gasMerchantInitDataBase.initGasMerchantResource(order.getPlatPartnerId(), parentResourceId, childResourceId,
                null);
        // 测试过程
        // 调用接口
        BizCollectionResult<ResourceInfo> result = merchantService.queryResource(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        for (ResourceInfo resourceInfo : result.getInfos()) {
            if (parentResourceId.equals(resourceInfo.getId())) {
                assertEquals(fatherName, resourceInfo.getName());
                assertEquals(fatherCode, resourceInfo.getCode());
                assertEquals(null, resourceInfo.getParentId());
                assertEquals(null, resourceInfo.getParentName());
                assertEquals(null, resourceInfo.getParentCode());
                assertEquals(null, resourceInfo.getUrl());
                assertEquals(fatherType, resourceInfo.getResourceType().code());
                assertEquals(null, resourceInfo.getOrderNo());
                assertEquals(null, resourceInfo.getIcon());
                assertEquals(null, resourceInfo.getMemo());
            }
            if (childResourceId.equals(resourceInfo.getId())) {
                assertEquals(name, resourceInfo.getName());
                assertEquals(childCode, resourceInfo.getCode());
                assertEquals(parentResourceId, resourceInfo.getParentId());
                assertEquals(fatherName, resourceInfo.getParentName());
                assertEquals(fatherCode, resourceInfo.getParentCode());
                assertEquals(null, resourceInfo.getUrl());
                assertEquals(type, resourceInfo.getResourceType().code());
                assertEquals(null, resourceInfo.getOrderNo());
                assertEquals(null, resourceInfo.getIcon());
                assertEquals(null, resourceInfo.getMemo());
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(code);
        gasMerchantTestBase.cleanGasMerchantRoleResourceByResourceId(parentResourceId);
        gasMerchantTestBase.cleanGasMerchantRoleResourceByResourceId(childResourceId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceQueryResourceTestFailOne.csv")
    @DisplayName("查询商家终端菜单资源--参数非法")
    public void merchantServiceQueryResourceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setDeviceType(null);
        }
        if (testId == 1003) {
            order.setDeviceType(DeviceType.BOSS);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<ResourceInfo> result = merchantService.queryResource(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
