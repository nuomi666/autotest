package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.order.product.DeleteProductOrder;
import dal.model.gas_merchant.ProductDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/08.
 */
public class ProductServiceDeleteProductTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceDeleteProductTestSuccess.csv")
    @DisplayName("删除产品--成功用例")
    public void productServiceDeleteProductTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String productId1,
            String productName,
            String productName1,
            String type,
            String type1,
            String category,
            String category1,
            DeleteProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        gasMerchantTestBase.cleanProductByProductId(productId1);
        // 准备数据
        gasMerchantTestBase.insertProduct(0L, order.getProductId(), productName, type, category,
                "ABLE", productName, null, null);
        gasMerchantTestBase.insertProduct(0L, productId1, productName1, type1, category1,
                "ABLE", productName1, null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = productService.deleteProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<ProductDO> productDOS = gasMerchantTestBase.findProductByProductId(order.getProductId());
        assertEquals(0, productDOS.size());
        List<ProductDO> productDOS1 = gasMerchantTestBase.findProductByProductId(productId1);
        productAssert(productDOS1.get(0), productId1, productName1, type1,
                category1, "ABLE", productName1);
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        gasMerchantTestBase.cleanProductByProductId(productId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceDeleteProductTestFailOne.csv")
    @DisplayName("删除产品--参数非法")
    public void productServiceDeleteProductTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeleteProductOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setProductId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = productService.deleteProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceDeleteProductTestFailTwo.csv")
    @DisplayName("删除产品--失败用例")
    public void productServiceDeleteProductTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String permissionId,
            String permissionName,
            String permissionCode,
            String productName,
            String type,
            String category,
            DeleteProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanProductPermissionByProductId(order.getProductId());
        gasMerchantTestBase.cleanMerchantProductByProductId(order.getProductId());
        // 准备数据
        if (testId != 1001) {
            gasMerchantTestBase.insertProduct(0L, order.getProductId(), productName, type, category,
                    "ABLE", productName, null, null);
        }
        if (testId == 1002) {
            gasMerchantTestBase.insertPermission(0L, type, permissionId, null, permissionName,
                    permissionCode, null, category, "MENU",
                    1, null, null, null, null);
            gasMerchantTestBase.insertProductPermission(0L, order.getProductId(), permissionId);
        }
        if (testId == 1003) {
            gasMerchantTestBase.insertMerchantProduct(0L, order.getProductId(), platPartnerId, "ABLE");
        }
        // 测试过程
        // 调用接口
        SimpleResult result = productService.deleteProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<ProductDO> productDOS = gasMerchantTestBase.findProductByProductId(order.getProductId());
        if (testId != 1001) {
            productAssert(productDOS.get(0), order.getProductId(), productName, type,
                    category, "ABLE", productName);
        }
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanProductPermissionByProductId(order.getProductId());
        gasMerchantTestBase.cleanMerchantProductByProductId(order.getProductId());
    }

    /**
     * 产品信息
     */
    private void productAssert(
            ProductDO product,
            String id,
            String name,
            String type,
            String category,
            String status,
            String memo
    ) {
        assertEquals(id, product.getProductId());
        assertEquals(name, product.getProductName());
        assertEquals(type, product.getProductType());
        assertEquals(category, product.getProductCategory());
        assertEquals(status, product.getStatus());
        assertEquals(memo, product.getMemo());
    }
}
