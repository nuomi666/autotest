package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.order.product.MerchantProductStatusChangeOrder;
import dal.model.gas_merchant.MerchantProductDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/10.
 */
public class ProductServiceMerchantProductStatusChangeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceMerchantProductStatusChangeTestSuccess.csv")
    @DisplayName("修改商户关联产品状态信息--成功用例")
    public void productServiceMerchantProductStatusChangeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String platPartnerId1,
            String productId,
            String productId1,
            String productStatus,
            MerchantProductStatusChangeOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerIdAndProductId(platPartnerId, productId);
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerIdAndProductId(platPartnerId1, productId1);
        // 准备数据
        gasMerchantTestBase.insertMerchantProduct(0L, productId, platPartnerId, productStatus);
        gasMerchantTestBase.insertMerchantProduct(0L, productId1, platPartnerId1, productStatus);
        // 测试过程
        // 调用接口
        SimpleResult result = productService.merchantProductStatusChange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<MerchantProductDO> merchantProductDOS =
                gasMerchantTestBase.findMerchantProductByPlatPartnerIdAndProductId(order.getPlatPartnerId(),
                        order.getProductId());
        List<MerchantProductDO> merchantProductDOS1 =
                gasMerchantTestBase.findMerchantProductByPlatPartnerIdAndProductId(platPartnerId1, productId1);
        assertEquals(order.getStatus().code(), merchantProductDOS.get(0).getStatus());
        assertEquals(productStatus, merchantProductDOS1.get(0).getStatus());
        // 清除数据
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerIdAndProductId(platPartnerId, productId);
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerIdAndProductId(platPartnerId1, productId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceMerchantProductStatusChangeTestFailOne.csv")
    @DisplayName("修改商户关联产品状态信息--参数非法")
    public void productServiceMerchantProductStatusChangeTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            MerchantProductStatusChangeOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setProductId(null);
        }
        if (testId == 1003) {
            order.setStatus(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = productService.merchantProductStatusChange(order);
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
    @AutoTest(file = "gas_merchant/productServiceMerchantProductStatusChangeTestFailTwo.csv")
    @DisplayName("修改商户关联产品状态信息--失败用例")
    public void productServiceMerchantProductStatusChangeTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            MerchantProductStatusChangeOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = productService.merchantProductStatusChange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanMerchantProductByPlatPartnerId(order.getPlatPartnerId());
    }
}
