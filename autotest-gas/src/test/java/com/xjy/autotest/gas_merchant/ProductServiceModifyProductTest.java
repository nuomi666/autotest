package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.order.product.ModifyProductOrder;
import dal.model.gas_merchant.*;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/04/07.
 */
public class ProductServiceModifyProductTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.只更新产品
     * 1002.更新产品+权限
     * 1003.更新已经分配给商户的产品信息
     * 1004.更新已经分配给商户的产品权限信息
     */
    @AutoTest(file = "gas_merchant/productServiceModifyProductTestSuccess.csv")
    @DisplayName("修改产品--成功用例")
    public void productServiceModifyProductTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String platPartnerId1,
            String productId,
            String productId1,
            String productName,
            String productName1,
            String productName2,
            String permissionId,
            String permissionName,
            String permissionName1,
            String permissionCode,
            String permissionCode1,
            String resourceType,
            String type,
            String category,
            ModifyProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId1);
        gasMerchantTestBase.cleanProductByProductName(productName);
        gasMerchantTestBase.cleanProductByProductName(productName1);
        gasMerchantTestBase.cleanProductByProductName(productName2);
        gasMerchantTestBase.cleanPermissionByCode(permissionCode);
        gasMerchantTestBase.cleanPermissionByCode(permissionCode1);
        // 准备数据
        //产品
        gasMerchantTestBase.insertProduct(0L, productId, productName, type, category,
                "ABLE", productName, null, null);
        //干扰数据
        gasMerchantTestBase.insertProduct(0L, productId1, productName1, type, category,
                "ABLE", productName1, null, null);
        //已经分配了商家的产品权限
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantProduct(platPartnerId, platPartnerId1,
                productName2, type,
                category, permissionName, permissionCode, resourceType, 1);
        String permissionIdxx = params.get("permissionId").toString();
        String productIdxx = params.get("productId").toString();
        String merchantRoleNo = params.get("merchantRoleNo").toString();
        String merchantRoleNo1 = params.get("merchantRoleNo1").toString();
        String stationRoleNo = params.get("stationRoleNo").toString();
        String stationRoleNo1 = params.get("stationRoleNo1").toString();
        //权限
        gasMerchantTestBase.insertPermission(0L, type, permissionId, null, permissionName1,
                permissionCode1, null, resourceType, order.getProductCategory().code(),
                2, null, null, null, null);
        // 测试过程
        List<String> permissionList = new ArrayList<String>();
        if (testId == 1002 || testId == 1004) {
            permissionList.add(permissionId);
        }
        order.setPermissionList(permissionList);
        if (testId == 1001 || testId == 1002) {
            order.setProductId(productId);
        } else {
            order.setProductId(productIdxx);
        }
        // 调用接口
        SimpleResult result = productService.modifyProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<ProductDO> productDOS = gasMerchantTestBase.findProductByProductId(order.getProductId());
        productAssert(productDOS.get(0), order.getProductId(), order.getProductName(), order.getProductType().code(),
                order.getProductCategory().code(), order.getStatus().code(), order.getMemo());
        List<ProductPermissionDO> productPermissionDOS =
                gasMerchantTestBase.findProductPermissionByProductId(order.getProductId());
        if (testId == 1001 || testId == 1003) {
            assertEquals(0, productPermissionDOS.size());
        }
        if (testId == 1002 || testId == 1004) {
            assertEquals(permissionId, productPermissionDOS.get(0).getPermissionId());
        }
        List<MerchantProductDO> merchantProductDOS =
                gasMerchantTestBase.findMerchantProductByProductId(order.getProductId());
        List<RoleProductDO> roleProductDOS1 = gasMerchantTestBase.findRoleProductByRoleNo(merchantRoleNo);
        List<RoleProductDO> roleProductDOS2 = gasMerchantTestBase.findRoleProductByRoleNo(stationRoleNo);
        List<RoleProductDO> roleProductDOS3 = gasMerchantTestBase.findRoleProductByRoleNo(merchantRoleNo1);
        List<RoleProductDO> roleProductDOS4 = gasMerchantTestBase.findRoleProductByRoleNo(stationRoleNo1);
        List<RolePermissionDO> rolePermissionDOS1 = gasMerchantTestBase.findRolePermissionByRoleNo(merchantRoleNo);
        List<RolePermissionDO> rolePermissionDOS2 = gasMerchantTestBase.findRolePermissionByRoleNo(stationRoleNo);
        List<RolePermissionDO> rolePermissionDOS3 = gasMerchantTestBase.findRolePermissionByRoleNo(merchantRoleNo1);
        List<RolePermissionDO> rolePermissionDOS4 = gasMerchantTestBase.findRolePermissionByRoleNo(stationRoleNo1);
        if (testId == 1003) {
            assertEquals(0, rolePermissionDOS1.size());
            assertEquals(0, roleProductDOS1.size());
            assertEquals(0, rolePermissionDOS3.size());
            assertEquals(0, roleProductDOS3.size());
            assertEquals(0, rolePermissionDOS2.size());
            assertEquals(1, roleProductDOS2.size());
            assertEquals(0, rolePermissionDOS4.size());
            assertEquals(1, roleProductDOS4.size());
        }
        if (testId == 1004) {
            assertEquals(1, rolePermissionDOS1.size());
            assertEquals(1, roleProductDOS1.size());
            assertEquals(1, rolePermissionDOS2.size());
            assertEquals(1, roleProductDOS2.size());
            assertEquals(1, rolePermissionDOS3.size());
            assertEquals(1, roleProductDOS3.size());
            assertEquals(1, rolePermissionDOS4.size());
            assertEquals(1, roleProductDOS4.size());
            assertEquals(productId, rolePermissionDOS1.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS2.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS3.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS4.get(0).getProductId());
            assertEquals(productIdxx, rolePermissionDOS1.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS1.get(0).getPermissionId());
            assertEquals(productIdxx, rolePermissionDOS2.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS2.get(0).getPermissionId());
            assertEquals(productIdxx, rolePermissionDOS3.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS3.get(0).getPermissionId());
            assertEquals(productIdxx, rolePermissionDOS4.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS4.get(0).getPermissionId());
        }
        // 清除数据
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId1);
        gasMerchantTestBase.cleanProductByProductName(productName);
        gasMerchantTestBase.cleanProductByProductName(productName1);
        gasMerchantTestBase.cleanPermissionByCode(permissionCode);
        gasMerchantTestBase.cleanPermissionByCode(permissionCode1);
        gasMerchantTestBase.cleanMerchantProductByProductId(productIdxx);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId1);
        gasMerchantTestBase.cleanProductPermissionByProductId(productIdxx);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId1);
        gasMerchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(stationRoleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo1);
        gasMerchantTestBase.cleanRoleProductByRoleNo(stationRoleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo1);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/productServiceModifyProductTestFailOne.csv")
    @DisplayName("修改产品--参数非法")
    public void productServiceModifyProductTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyProductOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> permissionList = new ArrayList<String>();
        order.setPermissionList(permissionList);
        if (testId == 1001) {
            order.setProductId(null);
        }
        if (testId == 1002) {
            order.setProductName(null);
        }
        if (testId == 1003) {
            order.setProductType(null);
        }
        if (testId == 1004) {
            order.setProductCategory(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        SimpleResult result = productService.modifyProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/productServiceModifyProductTestFailTwo.csv")
    @DisplayName("修改产品--失败用例")
    public void productServiceModifyProductTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        // 准备数据
        // 测试过程
        List<String> permissionList = new ArrayList<String>();
        order.setPermissionList(permissionList);
        // 调用接口
        SimpleResult result = productService.modifyProduct(order);
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
            ProductDO product,
            String productId,
            String name,
            String type,
            String category,
            String status,
            String memo
    ) {
        assertEquals(productId, product.getProductId());
        assertEquals(name, product.getProductName());
        assertEquals(type, product.getProductType());
        assertEquals(category, product.getProductCategory());
        assertEquals(status, product.getStatus());
        assertEquals(memo, product.getMemo());
    }
}
