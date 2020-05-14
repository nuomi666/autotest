package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.info.product.QueryProductInfo;
import com.xyb.gas.merchant.api.order.product.QueryProductOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/04/08.
 */
public class ProductServiceQueryProductTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceQueryProductTestSuccess.csv")
    @DisplayName("查询单个产品信息--成功用例")
    public void productServiceQueryProductTestSuccess(
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
            String platPartnerId,
            String platPartnerId1,
            String parentId,
            String permissionId,
            QueryProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanProductPermissionByProductId(order.getProductId());
        gasMerchantTestBase.cleanMerchantProductByProductId(order.getProductId());
        // 准备数据
        gasMerchantTestBase.insertProduct(0L, order.getProductId(), productName, type, category,
                "ABLE", productName, null, null);
        gasMerchantTestBase.insertProduct(0L, productId1, productName1, type1, category1,
                "ABLE", productName1, null, null);
        //权限
        gasMerchantTestBase.insertPermission(0L, type, parentId, null, "统计报表",
                "MENU0482", null, "MENU", category,
                1, null, null, null, null);
        gasMerchantTestBase.insertPermission(0L, type, permissionId, parentId, "财务报表",
                "MENU0483", null, "MENU", category,
                2, null, null, null, null);
        gasMerchantTestBase.insertProductPermission(0L, order.getProductId(), parentId);
        gasMerchantTestBase.insertProductPermission(0L, order.getProductId(), permissionId);
        if (testId == 1002) {
            gasMerchantTestBase.insertMerchantProduct(0L, order.getProductId(), platPartnerId, "ABLE");
            gasMerchantTestBase.insertMerchantProduct(0L, order.getProductId(), platPartnerId1, "ABLE");
        }
        // 测试过程
        // 调用接口
        BizResult<QueryProductInfo> result = productService.queryProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        productAssert(result.getInfo(), order.getProductId(), productName, type,
                category, "ABLE", productName);
        assertTrue(result.getInfo().getPermissionList().contains(parentId));
        assertTrue(result.getInfo().getPermissionList().contains(permissionId));
        if (testId == 1002) {
            assertTrue(result.getInfo().getMerchantList().contains(platPartnerId));
            assertTrue(result.getInfo().getMerchantList().contains(platPartnerId1));
        } else {
            assertEquals(null, result.getInfo().getMerchantList());
        }
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanPermissionByPermissionId(parentId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanProductPermissionByProductId(order.getProductId());
        gasMerchantTestBase.cleanMerchantProductByProductId(order.getProductId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceQueryProductTestFailOne.csv")
    @DisplayName("查询单个产品信息--参数非法")
    public void productServiceQueryProductTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryProductOrder order
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
        BizResult<QueryProductInfo> result = productService.queryProduct(order);
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
            QueryProductInfo product,
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
}
