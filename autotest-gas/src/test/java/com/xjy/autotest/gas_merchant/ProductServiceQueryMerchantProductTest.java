package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizListResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.Category;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.info.permission.PermissionInfo;
import com.xyb.gas.merchant.api.info.product.MerchantProductInfo;
import com.xyb.gas.merchant.api.info.product.ProductInfo;
import com.xyb.gas.merchant.api.order.product.QueryMerchantProductOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/08.
 */
public class ProductServiceQueryMerchantProductTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceQueryMerchantProductTestSuccess.csv")
    @DisplayName("根据商户查询产品信息列表--成功用例")
    public void productServiceQueryMerchantProductTestSuccess(
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
            Category category,
            Category category1,
            String resourceType,
            String resourceType1,
            int orderNo,
            int orderNo1,
            String productId,
            String productId1,
            String productName,
            String productName1,
            QueryMerchantProductOrder order
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
                parentCode, url, resourceType, category.code(),
                orderNo, null, null, null, null);
        gasMerchantTestBase.insertPermission(0L, order.getDeviceType().code(), permissionId, parentId, name,
                permissionCode, url1, resourceType, category.code(),
                orderNo1, null, null, null, null);
        //干扰数据
        gasMerchantTestBase.insertPermission(0L, deviceType1, permissionId1, null, name1,
                permissionCode1, url2, resourceType1, category1.code(),
                orderNo, null, null, null, null);
        //产品
        gasMerchantTestBase.insertProduct(0L, productId, productName, order.getDeviceType().code(), category.code(),
                "ABLE", productName, null, null);
        gasMerchantTestBase.insertProductPermission(0L, productId, parentId);
        gasMerchantTestBase.insertProductPermission(0L, productId, permissionId);
        //干扰数据
        gasMerchantTestBase.insertProduct(0L, productId1, productName1, deviceType1, category1.code(),
                "ABLE", productName1, null, null);
        if (testId == 1003) {
            gasMerchantTestBase.insertProductPermission(0L, productId1, permissionId1);
        }
        //商家产品
        if (testId != 1001) {
            gasMerchantTestBase.insertMerchantProduct(0L, productId, order.getPlatPartnerId(), "ABLE");
        }
        if (testId >= 1003) {
            gasMerchantTestBase.insertMerchantProduct(0L, productId1, order.getPlatPartnerId(), "ABLE");
        }
        // 测试过程
        List<Category> productCategoryList = new ArrayList<Category>();
        productCategoryList.add(category);
        if (testId == 1003 || testId == 1004) {
            productCategoryList.add(category1);
        }
        if (testId >= 1003) {
            order.setProductCategoryList(productCategoryList);
        }
        // 调用接口
        BizListResult<MerchantProductInfo> result = productService.queryMerchantProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<MerchantProductInfo> merchantProductInfos = result.getListInfo();
        if (testId == 1001) {
            assertEquals(0, merchantProductInfos.size());
        }
        if (testId == 1002 || testId >= 1004) {
            assertEquals(1, merchantProductInfos.size());
            ProductInfo productInfo = merchantProductInfos.get(0).getProductInfo();
            productAssert(productInfo, productId, productName, order.getDeviceType().code(),
                    category.code(), "ABLE", productName);
            List<PermissionInfo> permissionInfoList = merchantProductInfos.get(0).getPermissionInfoList();
            List<String> permissionIds = new ArrayList<>();
            for (PermissionInfo permission : permissionInfoList) {
                if (parentId.equals(permission.getPermissionId())) {
                    permissionAssert(permission, null, parentId, parentCode,
                            parentName, order.getDeviceType().code(), resourceType, category.code(), null,
                            null, url, orderNo, null, null);
                }
                if (permissionId.equals(permission.getPermissionId())) {
                    permissionAssert(permission, parentId, permissionId, permissionCode,
                            name, order.getDeviceType().code(), resourceType, category.code(), null,
                            null, url1, orderNo1, parentCode, parentName);
                }
                permissionIds.add(permission.getPermissionId());
            }
        }
        if (testId == 1003) {
            assertEquals(2, merchantProductInfos.size());
            List<String> productIds = new ArrayList<>();
            for (MerchantProductInfo info : merchantProductInfos) {
                if (productId.equals(info.getProductInfo().getProductId())) {
                    productAssert(info.getProductInfo(), productId, productName, order.getDeviceType().code(),
                            category.code(), "ABLE", productName);
                    List<String> permissionIds = new ArrayList<>();
                    for (PermissionInfo permission : info.getPermissionInfoList()) {
                        if (parentId.equals(permission.getPermissionId())) {
                            permissionAssert(permission, null, parentId, parentCode,
                                    parentName, order.getDeviceType().code(), resourceType, category.code(), null,
                                    null, url, orderNo, null, null);
                        }
                        if (permissionId.equals(permission.getPermissionId())) {
                            permissionAssert(permission, parentId, permissionId, permissionCode,
                                    name, order.getDeviceType().code(), resourceType, category.code(), null,
                                    null, url1, orderNo1, parentCode, parentName);
                        }
                        permissionIds.add(permission.getPermissionId());
                    }
                    assertTrue(permissionIds.contains(parentId));
                    assertTrue(permissionIds.contains(permissionId));
                }
                if (productId1.equals(info.getProductInfo().getProductId())) {
                    productAssert(info.getProductInfo(), productId1, productName1, deviceType1,
                            category1.code(), "ABLE", productName1);
                    permissionAssert(info.getPermissionInfoList().get(0), null, permissionId1, permissionCode1,
                            name1, deviceType1, resourceType1, category1.code(), null,
                            null, url2, orderNo, null, null);
                }
                productIds.add(info.getProductInfo().getProductId());
            }
            assertTrue(productIds.contains(productId));
            assertTrue(productIds.contains(productId1));
        }
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
    @AutoTest(file = "gas_merchant/productServiceQueryMerchantProductTestFailOne.csv")
    @DisplayName("根据商户查询产品信息列表--参数非法")
    public void productServiceQueryMerchantProductTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantProductOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizListResult<MerchantProductInfo> result = productService.queryMerchantProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 产品信息
     */
    private void productAssert(
            ProductInfo product,
            String id,
            String name,
            String type,
            String category,
            String status,
            String memo
    ) {
        assertEquals(id, product.getProductId());
        assertEquals(name, product.getProductName());
        assertEquals(type, product.getProductType().code());
        assertEquals(category, product.getProductCategory().code());
        assertEquals(status, product.getStatus().code());
        assertEquals(memo, product.getMemo());
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
