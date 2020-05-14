package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.PermissionManageService;
import com.xyb.gas.merchant.api.info.permission.PermissionInfo;
import com.xyb.gas.merchant.api.order.permission.PageQueryPermissionOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/03.
 */
public class PermissionManageServicePageQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    PermissionManageService permissionManageService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServicePageQueryTestSuccess.csv")
    @DisplayName("分页查询权限--成功用例")
    public void permissionManageServicePageQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String deviceType,
            String deviceType1,
            String parentId,
            String permissionId,
            String permissionId1,
            String permissionId2,
            String parentName,
            String name,
            String name1,
            String name2,
            String parentCode,
            String permissionCode,
            String permissionCode1,
            String permissionCode2,
            String url,
            String url1,
            String url2,
            String url3,
            String category,
            String category1,
            String resourceType,
            String resourceType1,
            int orderNo,
            int orderNo1,
            int orderNo2,
            PageQueryPermissionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId1);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId2);
        // 准备数据
        gasMerchantTestBase.insertPermission(0L, deviceType, parentId, null, parentName,
                parentCode, url, category, resourceType,
                orderNo, null, null, null, null);
        gasMerchantTestBase.insertPermission(0L, deviceType, permissionId, parentId, name,
                permissionCode, url1, category, resourceType,
                orderNo1, null, null, null, null);
        gasMerchantTestBase.insertPermission(0L, deviceType, permissionId1, parentId, name1,
                permissionCode1, url2, category, resourceType,
                orderNo2, null, null, null, null);
        //干扰数据
        gasMerchantTestBase.insertPermission(0L, deviceType1, permissionId2, null, name2,
                permissionCode2, url3, category1, resourceType1,
                orderNo, null, null, null, null);
        // 测试过程
        // 调用接口
        PagedResult<PermissionInfo> result = permissionManageService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<PermissionInfo> infos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(3, infos.size());
            permissionAssert(infos.get(0), parentId, permissionId1, permissionCode1,
                    name1, deviceType, resourceType, category, null,
                    null, url2, orderNo2, parentCode, parentName);
            permissionAssert(infos.get(1), parentId, permissionId, permissionCode,
                    name, deviceType, resourceType, category, null,
                    null, url1, orderNo1, parentCode, parentName);
            permissionAssert(infos.get(2), null, parentId, parentCode,
                    parentName, deviceType, resourceType, category, null,
                    null, url, orderNo, null, null);
        }
        if (testId == 1002 || testId == 1003) {
            assertEquals(1, infos.size());
            permissionAssert(infos.get(0), null, parentId, parentCode,
                    parentName, deviceType, resourceType, category, null,
                    null, url, orderNo, null, null);
        }
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId1);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId2);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServicePageQueryTestFailOne.csv")
    @DisplayName("分页查询权限--参数非法")
    public void permissionManageServicePageQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryPermissionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setDeviceType(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<PermissionInfo> result = permissionManageService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 权限信息
     */
    private void permissionAssert(
            PermissionInfo Permission,
            String parentId,
            String PermissionId,
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
        assertEquals(PermissionId, Permission.getPermissionId());
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
