package com.xjy.autotest.promotion;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.base.PromotionResult;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.ModifyCouponDefinitionOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/02/21.
 */
public class CouponManageServiceDisableCouponDefinitionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 停用券
     */
    @AutoTest(file = "promotion/couponManageServiceDisableCouponDefinitionTestSuccess.csv")
    @DisplayName("停用券--成功用例")
    public void couponManageServiceDisableCouponDefinitionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyCouponDefinitionOrder order,
            // 准备券
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        // 测试过程
        // 调用接口
        PromotionResult result = couponManageService.disableCouponDefinition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponDefinitionDO couponDefiDO = promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId()).get(0);
        assertEquals("DISABLED", couponDefiDO.getDefinitionStatus());
        CouponDefinitionDO couponDefiDO1 = promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId()).get(0);
        assertEquals(couponDefinitionDO1, couponDefiDO1);
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());

    }

    /**
     * 1001 definitionId传空
     */
    @AutoTest(file = "promotion/couponManageServiceDisableCouponDefinitionTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void couponManageServiceDisableCouponDefinitionTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyCouponDefinitionOrder order,
            // 准备券
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        // 准备数据
        // 测试过程
        // 调用接口
        PromotionResult result = couponManageService.disableCouponDefinition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 券Id不存在
     */
    @AutoTest(file = "promotion/couponManageServiceDisableCouponDefinitionTestFailTwo.csv")
    @DisplayName("停用券失败--失败用例")
    public void couponManageServiceDisableCouponDefinitionTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyCouponDefinitionOrder order,
            // 准备券
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        // 测试过程
        // 调用接口
        PromotionResult result = couponManageService.disableCouponDefinition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponDefinitionDO couponDefiDO = promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId()).get(0);
        assertEquals(couponDefinitionDO, couponDefiDO);
        CouponDefinitionDO couponDefiDO1 = promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId()).get(0);
        assertEquals(couponDefinitionDO1, couponDefiDO1);
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());

    }
}
