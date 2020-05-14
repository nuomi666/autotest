package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.order.product.AddProductOrder;
import dal.model.gas_merchant.ProductDO;
import dal.model.gas_merchant.ProductPermissionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/07.
 */
public class ProductServiceAddProductTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceAddProductTestSuccess.csv")
    @DisplayName("新增产品--成功用例")
    public void productServiceAddProductTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String permissionId,
            String deviceType,
            String name,
            String permissionCode,
            String url,
            String category,
            String resourceType,
            AddProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanProductByProductName(order.getProductName());
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        // 准备数据
        gasMerchantTestBase.insertPermission(0L, deviceType, permissionId, null, name,
                permissionCode, url, resourceType, category,
                1, null, null, null, null);
        // 测试过程
        List<String> permissionList = new ArrayList<String>();
        if (testId == 1002) {
            permissionList.add(permissionId);
        }
        order.setPermissionList(permissionList);
        // 调用接口
        SimpleResult result = productService.addProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<ProductDO> productDOS = gasMerchantTestBase.findProductByProductName(order.getProductName());
        productAssert(productDOS.get(0), order.getProductName(), order.getProductType().code(),
                order.getProductCategory().code(), "ABLE", order.getMemo());
        List<ProductPermissionDO> productPermissionDOS =
                gasMerchantTestBase.findProductPermissionByProductId(productDOS.get(0).getProductId());
        if (testId == 1002) {
            assertEquals(permissionId, productPermissionDOS.get(0).getPermissionId());
        } else {
            assertEquals(0, productPermissionDOS.size());
        }
        // 清除数据
        gasMerchantTestBase.cleanProductByProductName(order.getProductName());
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productDOS.get(0).getProductId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceAddProductTestFailOne.csv")
    @DisplayName("新增产品--参数非法")
    public void productServiceAddProductTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddProductOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setProductName(null);
        }
        if (testId == 1002) {
            order.setProductType(null);
        }
        if (testId == 1003) {
            order.setProductCategory(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = productService.addProduct(order);
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
            String name,
            String type,
            String category,
            String status,
            String memo
    ) {
//        assertEquals(productId, product.getProductId());
        assertEquals(name, product.getProductName());
        assertEquals(type, product.getProductType());
        assertEquals(category, product.getProductCategory());
        assertEquals(status, product.getStatus());
        assertEquals(memo, product.getMemo());
    }
}
