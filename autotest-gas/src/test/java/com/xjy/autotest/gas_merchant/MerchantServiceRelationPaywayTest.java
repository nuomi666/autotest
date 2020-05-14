//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MerchantService;
//import com.xyb.gas.merchant.api.order.RelationMerchantPaywayOrder;
//import org.junit.jupiter.api.DisplayName;
//
//import java.util.Set;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/09/27.
// */
//public class MerchantServiceRelationPaywayTest extends SpringBootTestBase {
//
//    @Reference(version = DUBBO_VERSION_1)
//    MerchantService merchantService;
//
//    /**
//     * 1001.接口废弃了
//     */
//    @AutoTest(file = "gas_merchant/merchantServiceRelationPaywayTestSuccess.csv")
//    @DisplayName("配置支付方式--成功用例")
//    public void merchantServiceRelationPaywayTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            RelationMerchantPaywayOrder.Payway payway,
//            RelationMerchantPaywayOrder.Payway payway1,
//            RelationMerchantPaywayOrder order
//    ) {
//        // 清除数据
//        // 准备数据
//
//        // 测试过程
//        Set<RelationMerchantPaywayOrder.Payway> payways = Sets.newHashSet();
//        payways.add(payway);
//        payways.add(payway1);
//        order.setPayways(payways);
//        // 调用接口
//        SimpleResult result = merchantService.relationPayway(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        // 清除数据
//    }
//}
