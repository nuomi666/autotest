package com.xjy.autotest.promotion;

import com.google.common.collect.Maps;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.enums.CouponType;
import com.xyb.promotion.api.coupon.params.*;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.coupon.CouponTransService;

import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/02/28.
 */
public class CouponTransServiceRefundCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponTransService couponTransService;

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 回退一张已使用的券
     * 1002 回退一张已领取的券
     * 1003 回退一张已使用的券,一张已领取券
     * 1004 回退四张已使用的券
     * 1005 回退四张已领取的券
     */
    @AutoTest(file = "promotion/couponTransServiceRefundCouponTestSuccess.csv")
    @DisplayName("退券--成功用例")
    public void couponTransServiceRefundCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RefundCouponOrder order,
            String couponId,
            String couponId1,
            String couponId2,
            String couponId3,
            // 创建券
            CreateCouponDefinitionOrder createCouponDefinitionOrder,
            CreateCouponDefinitionOrder createCouponDefinitionOrder1,
            CreateCouponDefinitionOrder createCouponDefinitionOrder2,
            CreateCouponDefinitionOrder createCouponDefinitionOrder3,
            // 领取券
            TakeCouponOrder takeCouponOrder,
            TakeCouponOrder takeCouponOrder1,
            // 使用券
            ApplyCouponOrder applyCouponOrder
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByPartnerId(createCouponDefinitionOrder.getPartnerId());
        promotionTestBase.cleanCouponByUserId(takeCouponOrder.getUserId());
        promotionTestBase.cleanCouponByUserId(takeCouponOrder1.getUserId());
        // 准备数据
        if (CouponType.INSTANT.equals(createCouponDefinitionOrder.getCouponType())) {
            createCouponDefinitionOrder.setAmountData(new Money(createCouponDefinitionOrder.getAmountData().toString()));
        }
        if (CouponType.OVER.equals(createCouponDefinitionOrder1.getCouponType())) {
            CouponType.OverCouponAmountData overCouponAmountData = new CouponType.OverCouponAmountData();
            overCouponAmountData.add(new Money(10), new Money(1000000), new Money(createCouponDefinitionOrder1.getAmountData().toString()));
            createCouponDefinitionOrder1.setAmountData(overCouponAmountData);
        }
        if (CouponType.DISCOUNT.equals(createCouponDefinitionOrder2.getCouponType())) {
            createCouponDefinitionOrder2.setAmountData(Double.parseDouble(createCouponDefinitionOrder2.getAmountData().toString()));
        }
        if (CouponType.EXCHANGE.equals(createCouponDefinitionOrder3.getCouponType())) {
            createCouponDefinitionOrder3.setAmountData(new Money(createCouponDefinitionOrder3.getAmountData().toString()));
        }
        //创建券
        CreateCouponDefinitionResult createCouponrResult = couponManageService.createCouponDefinition(createCouponDefinitionOrder);
        CreateCouponDefinitionResult createCouponrResult1 = couponManageService.createCouponDefinition(createCouponDefinitionOrder1);
        CreateCouponDefinitionResult createCouponrResult2 = couponManageService.createCouponDefinition(createCouponDefinitionOrder2);
        CreateCouponDefinitionResult createCouponrResult3 = couponManageService.createCouponDefinition(createCouponDefinitionOrder3);
        CouponDefinitionDO couponDefinitionDO = promotionTestBase.findCouponDefinitionByDefinitionId(createCouponrResult.getDefinitionId()).get(0);
        //领取券
        Map<String, Integer> takeItems = Maps.newHashMap();
        takeItems.put(createCouponrResult.getDefinitionId(), 1);
        takeItems.put(createCouponrResult1.getDefinitionId(), 1);
        takeItems.put(createCouponrResult2.getDefinitionId(), 1);
        takeItems.put(createCouponrResult3.getDefinitionId(), 1);
        takeCouponOrder.setTakeItems(takeItems);
        takeCouponOrder.setGid(GID.newGID());
        takeCouponOrder.setReqId(OID.newID());
        takeCouponOrder.setMerchantOrderNo(OID.newID());
        takeCouponOrder.setPlatMerchantOrderNo(OID.newID());
        TakeCouponResult takeCouponResult = couponTransService.takeCoupon(takeCouponOrder);

        couponId = takeCouponResult.getCouponInfos().get(0).getCouponId();
        couponId1 = takeCouponResult.getCouponInfos().get(1).getCouponId();
        couponId2 = takeCouponResult.getCouponInfos().get(2).getCouponId();
        couponId3 = takeCouponResult.getCouponInfos().get(3).getCouponId();

        List<String> coupIds = new ArrayList<String>();
        coupIds.add(couponId);
        if (testId == 1004) {
            coupIds.add(couponId1);
            coupIds.add(couponId2);
            coupIds.add(couponId3);
        }
        applyCouponOrder.setCouponIds(coupIds);
        // 使用券
        if (testId != 1002 && testId != 1005) {
            ApplyCouponResult applyCouponResult = couponTransService.applyCoupon(applyCouponOrder);
            assertEquals(status, applyCouponResult.getStatus());
        }
        // 测试过程
        List<String> couponIds = new ArrayList<>();
        couponIds.add(couponId);
        if (testId == 1003) {
            couponIds.add(couponId1);
        }
        if (testId == 1004 || testId == 1005) {
            couponIds.add(couponId1);
            couponIds.add(couponId2);
            couponIds.add(couponId3);
        }
        order.setCouponIds(couponIds);
        // 调用接口
        CouponTransResult result = couponTransService.refundCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponDO cDO = promotionTestBase.findCouponByCouponId(couponId).get(0);
        CouponDO cDO1 = promotionTestBase.findCouponByCouponId(couponId1).get(0);
        CouponDO cDO2 = promotionTestBase.findCouponByCouponId(couponId2).get(0);
        CouponDO cDO3 = promotionTestBase.findCouponByCouponId(couponId3).get(0);
        if (testId == 1001) {
            assertEquals("TAKEN", cDO.getStatus());
        }
        if (testId == 1002) {
            assertEquals("RETURNED", cDO.getStatus());
        }
        if (testId == 1003) {
            assertEquals("TAKEN", cDO.getStatus());
            assertEquals("RETURNED", cDO1.getStatus());
        }
        if (testId == 1004) {
            assertEquals("TAKEN", cDO.getStatus());
            assertEquals("TAKEN", cDO1.getStatus());
            assertEquals("TAKEN", cDO2.getStatus());
            assertEquals("TAKEN", cDO3.getStatus());
        }
        if (testId == 1005) {
            assertEquals("RETURNED", cDO.getStatus());
            assertEquals("RETURNED", cDO1.getStatus());
            assertEquals("RETURNED", cDO2.getStatus());
            assertEquals("RETURNED", cDO3.getStatus());
        }
        CouponDefinitionDO couponDefinitionDO1 = promotionTestBase.findCouponDefinitionByDefinitionId(createCouponrResult.getDefinitionId()).get(0);
        assertEquals(couponDefinitionDO, couponDefinitionDO1);
        // 清除数据
    }
}
