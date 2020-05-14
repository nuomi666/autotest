package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.PermissionManageService;
import com.xyb.gas.merchant.api.info.permission.PermissionInfo;
import com.xyb.gas.merchant.api.order.permission.QueryPermissionOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/04/03.
 */
public class PermissionManageServiceDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    PermissionManageService permissionManageService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceDetailTestSuccess.csv")
    @DisplayName("查询权限详情--成功用例")
    public void permissionManageServiceDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String deviceType,
            String parentId,
            String parentName,
            String name,
            String parentCode,
            String permissionCode,
            String url,
            String category,
            String resourceType,
            int orderNo,
            QueryPermissionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(order.getPermissionId());
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        // 准备数据
        gasMerchantTestBase.insertPermission(0L, deviceType, order.getPermissionId(), parentId, name,
                permissionCode, url, category, resourceType,
                orderNo, null, null, null, null);
        if (testId == 1002) {
            gasMerchantTestBase.insertPermission(0L, deviceType, parentId, null, parentName,
                    parentCode, url, category, resourceType,
                    orderNo, null, null, null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<PermissionInfo> result = permissionManageService.detail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1002) {
            permissionAssert(result.getInfo(), parentId, permissionCode,
                    name, deviceType, resourceType, category, null,
                    null, url, orderNo, parentCode, parentName);
        } else {
            permissionAssert(result.getInfo(), null, permissionCode,
                    name, deviceType, resourceType, category, null,
                    null, url, orderNo, null, null);
        }
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(order.getPermissionId());
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceDetailTestFailOne.csv")
    @DisplayName("查询权限详情--参数非法")
    public void permissionManageServiceDetailTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryPermissionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPermissionId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<PermissionInfo> result = permissionManageService.detail(order);
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
            PermissionInfo Permission,
            String parentId,
            String code,
            String name,
            String deviceType,
            String resourceType,
            String category,
            String icon,
            String memo,
            String url,
            int orderNo,
            String parentCode,
            String parentName
    ) {
        assertEquals(deviceType, Permission.getDeviceType().code());
        assertEquals(parentId, Permission.getParentId());
        assertEquals(name, Permission.getName());
        assertEquals(code, Permission.getCode());
        assertEquals(url, Permission.getUrl());
        assertEquals(category, Permission.getPermissionCategory().code());
        assertEquals(resourceType, Permission.getResourceType().code());
        assertEquals(orderNo, Permission.getOrderNo());
        assertEquals(icon, Permission.getIcon());
        assertEquals(memo, Permission.getMemo());
        assertEquals(parentCode, Permission.getParentCode());
        assertEquals(parentName, Permission.getParentName());
    }
}
