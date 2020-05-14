package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.PermissionManageService;
import com.xyb.gas.merchant.api.order.permission.AddPermissionOrder;
import dal.model.gas_merchant.PermissionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/04/03.
 */
public class PermissionManageServiceAddTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    PermissionManageService permissionManageService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceAddTestSuccess.csv")
    @DisplayName("创建权限--成功用例")
    public void permissionManageServiceAddTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String deviceType,
            String permissionId,
            String name,
            String permissionCode,
            String url,
            String category,
            String resourceType,
            int orderNo,
            AddPermissionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanPermissionByCode(permissionCode);
        gasMerchantTestBase.cleanPermissionByCode(order.getCode());
        // 准备数据
        gasMerchantTestBase.insertPermission(0L, deviceType, permissionId, null, name,
                permissionCode, url, category, resourceType,
                orderNo, null, null, null, null);
        // 测试过程
        if (testId == 1002) {
            order.setParentId(permissionId);
        }
        // 调用接口
        SimpleResult result = permissionManageService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        PermissionDO Permission = gasMerchantTestBase.findPermissionByCode(order.getCode()).get(0);
        permissionAssert(Permission, order.getParentId(),
                order.getCode(), order.getName(), order.getDeviceType().code(),
                order.getResourceType().code(), order.getPermissionCategory().code(),
                order.getIcon(), order.getMemo(), order.getUrl(), order.getOrderNo());
        // 清除数据
        gasMerchantTestBase.cleanPermissionByCode(permissionCode);
        gasMerchantTestBase.cleanPermissionByCode(order.getCode());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceAddTestFailOne.csv")
    @DisplayName("创建权限--参数非法")
    public void permissionManageServiceAddTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddPermissionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setName(null);
        }
        if (testId == 1002) {
            order.setCode(null);
        }
        if (testId == 1003) {
            order.setDeviceType(null);
        }
        if (testId == 1004) {
            order.setResourceType(null);
        }
        if (testId == 1005) {
            order.setPermissionCategory(null);
        }
        if (testId == 1006) {
            order.setGid(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        SimpleResult result = permissionManageService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 终端资源表
     */
    private void permissionAssert(
            PermissionDO Permission,
            String parentId,
            String code,
            String name,
            String deviceType,
            String resourceType,
            String category,
            String icon,
            String memo,
            String url,
            int orderNo
    ) {
        assertEquals(deviceType, Permission.getDeviceType());
        assertEquals(parentId, Permission.getParentId());
        assertEquals(name, Permission.getName());
        assertEquals(code, Permission.getCode());
        assertEquals(url, Permission.getUrl());
        assertEquals(category, Permission.getPermissionCategory());
        assertEquals(resourceType, Permission.getResourceType());
        assertEquals(orderNo, Permission.getOrderNo());
        assertEquals(icon, Permission.getIcon());
        assertEquals(memo, Permission.getMemo());
    }
}
