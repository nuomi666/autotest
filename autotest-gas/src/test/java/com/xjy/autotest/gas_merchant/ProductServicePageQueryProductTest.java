package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.info.product.ProductInfo;
import com.xyb.gas.merchant.api.order.product.PageQueryProductOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/08.
 */
public class ProductServicePageQueryProductTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServicePageQueryProductTestSuccess.csv")
    @DisplayName("分页查询产品信息--成功用例")
    public void productServicePageQueryProductTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String productId,
            String productId1,
            String productId2,
            String productName,
            String productName1,
            String productName2,
            String type,
            String type1,
            String type2,
            String category,
            String category1,
            String category2,
            PageQueryProductOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanProductByProductId(productId2);
        // 准备数据
        gasMerchantTestBase.insertProduct(0L, productId, productName, type, category,
                "ABLE", productName, null, null);
        gasMerchantTestBase.insertProduct(0L, productId1, productName1, type1, category1,
                "ABLE", productName1, null, null);
        gasMerchantTestBase.insertProduct(0L, productId2, productName2, type2, category2,
                "ABLE", productName2, null, null);
        // 测试过程
        // 调用接口
        PagedResult<ProductInfo> result = productService.pageQueryProduct(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<ProductInfo> infos = result.getInfoList();
        if (testId == 1001 || testId == 1002) {
            assertEquals(3, result.getPageInfo().getTotalCount());
        } else {
            assertEquals(1, result.getPageInfo().getTotalCount());
        }
        if (testId == 1001) {
            assertEquals(3, infos.size());
            productAssert(infos.get(0), productId2, productName2, type2,
                    category2, "ABLE", productName2);
            productAssert(infos.get(1), productId1, productName1, type1,
                    category1, "ABLE", productName1);
            productAssert(infos.get(2), productId, productName, type,
                    category, "ABLE", productName);
        } else {
            assertEquals(1, infos.size());
            productAssert(infos.get(0), productId, productName, type,
                    category, "ABLE", productName);
        }
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanProductByProductId(productId1);
        gasMerchantTestBase.cleanProductByProductId(productId2);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServicePageQueryProductTestFailOne.csv")
    @DisplayName("分页查询产品信息--参数非法")
    public void productServicePageQueryProductTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryProductOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order = null;
        }
        // 调用接口
        PagedResult<ProductInfo> result = productService.pageQueryProduct(order);
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
}
