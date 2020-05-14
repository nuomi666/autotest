package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.order.product.MerchantRelationProductOrder;
import dal.model.gas_merchant.MerchantProductDO;
import dal.model.gas_merchant.RolePermissionDO;
import dal.model.gas_merchant.RoleProductDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/08.
 */
public class ProductServiceMerchantRelationProductTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 给商家分配产品时，会给商家创建的默认操作员赋权限
     * 1001.category为COMMON
     * 1002.category为MERCHANT，category1为STATION
     * 1003.category为STATION
     */
    @AutoTest(file = "gas_merchant/productServiceMerchantRelationProductTestSuccess.csv")
    @DisplayName("商户关联产品信息--成功用例")
    public void productServiceMerchantRelationProductTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String roleNo,
            String roleNo1,
            String roleNo2,
            String productId,
            String productId1,
            String productName,
            String productName1,
            String type,
            String type1,
            String category,
            String category1,
            String parentId,
            String permissionId,
            String permissionId1,
            MerchantRelationProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId1);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo2);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo2);
        // 准备数据
        //默认操作员
        gasMerchantTestBase.insertRole(0L, roleNo, "00000000000000000000", "Supplier", order.getPlatPartnerId(),
                "商家管理员", "系统预设商家管理员", null, null);
        gasMerchantTestBase.insertRole(0L, roleNo1, "00000000000000000000", "Station", order.getPlatPartnerId(),
                "站长", "系统预设站长", null, null);
        gasMerchantTestBase.insertRole(0L, roleNo2, "00000000000000000000", "Terminal", order.getPlatPartnerId(),
                "收银员", "系统预设收银员", null, null);
        //产品
        gasMerchantTestBase.insertProduct(0L, productId, productName, type, category,
                "ABLE", productName, null, null);
        gasMerchantTestBase.insertProduct(0L, productId1, productName1, type1, category1,
                "ABLE", productName1, null, null);
        //权限
        gasMerchantTestBase.insertPermission(0L, type, parentId, null, "会员规则",
                "MENU0482", null, "MENU", category,
                1, null, null, null, null);
        gasMerchantTestBase.insertPermission(0L, type, permissionId, parentId, "会员分组管理",
                "MENU0483", null, "MENU", category,
                2, null, null, null, null);
        gasMerchantTestBase.insertPermission(0L, type1, permissionId1, null, "员工管理",
                "MENU0583", null, "MENU", category1,
                1, null, null, null, null);
        gasMerchantTestBase.insertProductPermission(0L, productId, parentId);
        gasMerchantTestBase.insertProductPermission(0L, productId, permissionId);
        gasMerchantTestBase.insertProductPermission(0L, productId1, permissionId1);
        // 测试过程
        List<String> productList = new ArrayList<String>();
        productList.add(productId);
        if (testId == 1002) {
            productList.add(productId1);
        }
        order.setProductList(productList);
        // 调用接口
        SimpleResult result = productService.merchantRelationProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<MerchantProductDO> merchantProductDOS =
                gasMerchantTestBase.findMerchantProductByPlatPartnerId(order.getPlatPartnerId());
        if (testId == 1002) {
            assertEquals(2, merchantProductDOS.size());
            List<String> productIds = new ArrayList<>();
            for (MerchantProductDO merchantProductDO : merchantProductDOS) {
                assertEquals(order.getPlatPartnerId(), merchantProductDO.getPlatPartnerId());
                productIds.add(merchantProductDO.getProductId());
            }
            assertTrue(productIds.contains(productId));
            assertTrue(productIds.contains(productId1));
        } else {
            assertEquals(1, merchantProductDOS.size());
            assertEquals(order.getPlatPartnerId(), merchantProductDOS.get(0).getPlatPartnerId());
            assertEquals(productId, merchantProductDOS.get(0).getProductId());
        }
        List<RoleProductDO> roleProductDOS = gasMerchantTestBase.findRoleProductByRoleNo(roleNo);
        if (testId == 1001 || testId == 1002) {
            assertEquals(1, roleProductDOS.size());
            assertEquals(productId, roleProductDOS.get(0).getProductId());
        } else {
            assertEquals(0, roleProductDOS.size());
        }
        List<RoleProductDO> roleProductDOS1 = gasMerchantTestBase.findRoleProductByRoleNo(roleNo1);
        if (testId == 1001 || testId == 1003) {
            assertEquals(1, roleProductDOS1.size());
            assertEquals(productId, roleProductDOS1.get(0).getProductId());
        }
        if (testId == 1002) {
            assertEquals(1, roleProductDOS1.size());
            assertEquals(productId1, roleProductDOS1.get(0).getProductId());
        }
        List<RoleProductDO> roleProductDOS2 = gasMerchantTestBase.findRoleProductByRoleNo(roleNo2);
        assertEquals(0, roleProductDOS2.size());
        List<RolePermissionDO> rolePermissionDOS = gasMerchantTestBase.findRolePermissionByRoleNo(roleNo);
        if (testId == 1001 || testId == 1002) {
            assertEquals(2, rolePermissionDOS.size());
            List<String> permissionIds = new ArrayList<>();
            for (RolePermissionDO rolePermissionDO : rolePermissionDOS) {
                assertEquals(productId, rolePermissionDO.getProductId());
                permissionIds.add(rolePermissionDO.getPermissionId());
            }
            assertTrue(permissionIds.contains(parentId));
            assertTrue(permissionIds.contains(permissionId));
        } else {
            assertEquals(0, rolePermissionDOS.size());
        }
        List<RolePermissionDO> rolePermissionDOS1 = gasMerchantTestBase.findRolePermissionByRoleNo(roleNo1);
        if (testId == 1001 || testId == 1003) {
            assertEquals(2, rolePermissionDOS1.size());
            List<String> permissionIds = new ArrayList<>();
            for (RolePermissionDO rolePermissionDO : rolePermissionDOS1) {
                assertEquals(productId, rolePermissionDO.getProductId());
                permissionIds.add(rolePermissionDO.getPermissionId());
            }
            assertTrue(permissionIds.contains(parentId));
            assertTrue(permissionIds.contains(permissionId));
        }
        if (testId == 1002) {
            assertEquals(1, rolePermissionDOS1.size());
            assertEquals(productId1, rolePermissionDOS1.get(0).getProductId());
            assertEquals(permissionId1, rolePermissionDOS1.get(0).getPermissionId());
        }
        List<RolePermissionDO> rolePermissionDOS2 = gasMerchantTestBase.findRolePermissionByRoleNo(roleNo2);
        assertEquals(0, rolePermissionDOS2.size());
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId1);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo2);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo2);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/productServiceMerchantRelationProductTestFailOne.csv")
    @DisplayName("商户关联产品信息--参数非法")
    public void productServiceMerchantRelationProductTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String productId,
            MerchantRelationProductOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> productList = new ArrayList<String>();
        productList.add(productId);
        order.setProductList(productList);
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setProductList(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = productService.merchantRelationProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
