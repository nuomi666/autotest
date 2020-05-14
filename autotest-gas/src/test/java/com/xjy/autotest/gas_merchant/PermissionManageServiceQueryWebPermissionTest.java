package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizListResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.PermissionManageService;
import com.xyb.gas.merchant.api.info.permission.PermissionInfo;
import com.xyb.gas.merchant.api.order.permission.QueryWebPermissionOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/07.
 */
public class PermissionManageServiceQueryWebPermissionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    PermissionManageService permissionManageService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceQueryWebPermissionTestSuccess.csv")
    @DisplayName("查询指定产品类型的权限--成功用例")
    public void permissionManageServiceQueryWebPermissionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String deviceType1,
            String parentId,
            String permissionId,
            String permissionId1,
            String parentName,
            String name,
            String name1,
            String parentCode,
            String permissionCode,
            String permissionCode1,
            String url,
            String url1,
            String url2,
            String category,
            String category1,
            String resourceType,
            String resourceType1,
            int orderNo,
            int orderNo1,
            String productId,
            String productId1,
            String productName,
            String productName1,
            QueryWebPermissionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId1);
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId1);
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        //权限
        gasMerchantTestBase.insertPermission(0L, order.getDeviceType().code(), parentId, null, parentName,
                parentCode, url, category, resourceType,
                orderNo, null, null, null, null);
        gasMerchantTestBase.insertPermission(0L, order.getDeviceType().code(), permissionId, parentId, name,
                permissionCode, url1, category, resourceType,
                orderNo1, null, null, null, null);
        //干扰数据
        gasMerchantTestBase.insertPermission(0L, deviceType1, permissionId1, null, name1,
                permissionCode1, url2, category1, resourceType1,
                orderNo, null, null, null, null);
        //产品
        gasMerchantTestBase.insertProduct(0L, productId, productName, order.getDeviceType().code(), category,
                "ABLE", productName, null, null);
        gasMerchantTestBase.insertProductPermission(0L, productId, parentId);
        gasMerchantTestBase.insertProductPermission(0L, productId, permissionId);
        if (testId == 1002) {
            gasMerchantTestBase.insertProductPermission(0L, productId, permissionId1);
        }
        //干扰数据
        gasMerchantTestBase.insertProduct(0L, productId1, productName1, order.getDeviceType().code(), category,
                "ABLE", productName1, null, null);
        gasMerchantTestBase.insertProductPermission(0L, productId1, permissionId1);
        //商家产品权限
        gasMerchantTestBase.insertMerchantProduct(0L, productId, order.getPlatPartnerId(), "ABLE");
        // 测试过程
        // 调用接口
        BizListResult<PermissionInfo> result = permissionManageService.queryWebPermission(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<PermissionInfo> infos = result.getListInfo();
        assertEquals(2, infos.size());
        permissionAssert(infos.get(1), parentId, permissionId, permissionCode,
                name, order.getDeviceType().code(), resourceType, category, null,
                null, url1, orderNo1, parentCode, parentName);
        permissionAssert(infos.get(0), null, parentId, parentCode,
                parentName, order.getDeviceType().code(), resourceType, category, null,
                null, url, orderNo, null, null);
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId1);
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId1);
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceQueryWebPermissionTestFailOne.csv")
    @DisplayName("查询指定产品类型的权限--参数非法")
    public void permissionManageServiceQueryWebPermissionTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryWebPermissionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setDeviceType(null);
        }
        if (testId == 1002) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizListResult<PermissionInfo> result = permissionManageService.queryWebPermission(order);
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
        //开发没返回这两字段
//        assertEquals(parentCode, Permission.getParentCode());
//        assertEquals(parentName, Permission.getParentName());
    }
}
