package com.xjy.autotest.promotion;

import com.google.common.collect.Maps;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.adk.common.util.money.Money;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.enums.CouponType;
import com.xyb.promotion.api.coupon.params.*;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import dal.model.promotion.InstructionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.coupon.CouponTransService;

import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/01/24.
 */
public class CouponTransServiceRecycleCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponTransService couponTransService;

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 全部回收
     * 1002 部分回收
     * 1003 通过bizInstructionId回收
     * 1004 过期券回收
     */
    @AutoTest(file = "promotion/couponTransServiceRecycleCouponTestSuccess.csv")
    @DisplayName("回收券--成功用例")
    public void couponTransServiceRecycleCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RecycleCouponOrder order,
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
            TakeCouponOrder takeCouponOrder1
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
        Map<String, Integer> takeItems1 = Maps.newHashMap();
        takeItems1.put(createCouponrResult.getDefinitionId(), 1);
        takeItems1.put(createCouponrResult2.getDefinitionId(), 1);
        takeItems1.put(createCouponrResult1.getDefinitionId(), 1);
        takeItems1.put(createCouponrResult3.getDefinitionId(), 1);
        takeCouponOrder1.setTakeItems(takeItems1);
        takeCouponOrder1.setGid(GID.newGID());
        takeCouponOrder1.setReqId(OID.newID());
        takeCouponOrder1.setMerchantOrderNo(OID.newID());
        takeCouponOrder1.setPlatMerchantOrderNo(OID.newID());
        TakeCouponResult takeCouponResult1 = couponTransService.takeCoupon(takeCouponOrder1);

        couponId = takeCouponResult.getCouponInfos().get(0).getCouponId();
        couponId1 = takeCouponResult.getCouponInfos().get(1).getCouponId();
        couponId2 = takeCouponResult.getCouponInfos().get(2).getCouponId();
        couponId3 = takeCouponResult.getCouponInfos().get(3).getCouponId();
        // 设置过期券
        if (testId == 1004) {
            CouponDO couponDO = promotionTestBase.findCouponByCouponId(couponId).get(0);
            couponDO.setValidStartTime(DateUtils.getStartDateOfMonth(new Date()));
            couponDO.setValidEndTime(DateUtils.getStartDateOfMonth(new Date()));
            promotionTestBase.updateCouponByCouponId(couponId, couponDO);
        }
        // 测试过程
        List<String> couponIds = new ArrayList<>();
        couponIds.add(couponId);
        if (testId != 1002) {
            couponIds.add(couponId1);
            couponIds.add(couponId2);
            couponIds.add(couponId3);
        }
        if (testId <= 1002) {
            order.setCouponIds(couponIds);
        }
        if (testId >= 1003) {
            order.setBizInstructionId(takeCouponResult.getInstructionId());
        }
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo(OID.newID());
        order.setPlatMerchantOrderNo(OID.newID());
        // 调用接口
        CouponTransResult result = couponTransService.recycleCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        InstructionDO instructionDO = promotionTestBase.findInstructionByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
        assertEquals(order.getGid(), instructionDO.getGid());
        assertEquals(order.getReqId(), instructionDO.getReqId());
        assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        assertEquals(result.getInstructionId(), instructionDO.getInstructionId());
        assertEquals(result.getStatus() + "", instructionDO.getStatus());
        assertEquals(result.getCode(), instructionDO.getCode());

        CouponDO couponDO = promotionTestBase.findCouponByCouponId(couponId).get(0);
        assertEquals("RETURNED", couponDO.getStatus());
        if (testId == 1001 || testId >= 1003) {
            CouponDO couponDO1 = promotionTestBase.findCouponByCouponId(couponId1).get(0);
            CouponDO couponDO2 = promotionTestBase.findCouponByCouponId(couponId2).get(0);
            CouponDO couponDO3 = promotionTestBase.findCouponByCouponId(couponId3).get(0);
            assertEquals("RETURNED", couponDO1.getStatus());
            assertEquals("RETURNED", couponDO2.getStatus());
            assertEquals("RETURNED", couponDO3.getStatus());
        }
        if (testId == 1002) {
            CouponDO couponDO1 = promotionTestBase.findCouponByCouponId(couponId1).get(0);
            CouponDO couponDO2 = promotionTestBase.findCouponByCouponId(couponId2).get(0);
            CouponDO couponDO3 = promotionTestBase.findCouponByCouponId(couponId3).get(0);
            assertEquals("TAKEN", couponDO1.getStatus());
            assertEquals("TAKEN", couponDO2.getStatus());
            assertEquals("TAKEN", couponDO3.getStatus());
        }

        // 清除数据
        promotionTestBase.cleanCouponDefinitionByPartnerId(createCouponDefinitionOrder.getPartnerId());
        promotionTestBase.cleanCouponByUserId(takeCouponOrder.getUserId());
        promotionTestBase.cleanCouponByUserId(takeCouponOrder1.getUserId());
        promotionTestBase.cleanInstructionByMerchantOrderNo(order.getMerchantOrderNo());
    }

    /**
     * 1001 券不存在
     * 1002 券已使用
     * 1003 券已使用
     */
    @AutoTest(file = "promotion/couponTransServiceRecycleCouponTestFailOne.csv")
    @DisplayName("回收券--成功用例")
    public void couponTransServiceRecycleCouponTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RecycleCouponOrder order,
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
            TakeCouponOrder takeCouponOrder1
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
        Map<String, Integer> takeItems1 = Maps.newHashMap();
        takeItems1.put(createCouponrResult.getDefinitionId(), 1);
        takeItems1.put(createCouponrResult2.getDefinitionId(), 1);
        takeItems1.put(createCouponrResult1.getDefinitionId(), 1);
        takeItems1.put(createCouponrResult3.getDefinitionId(), 1);
        takeCouponOrder1.setTakeItems(takeItems1);
        takeCouponOrder1.setGid(GID.newGID());
        takeCouponOrder1.setReqId(OID.newID());
        takeCouponOrder1.setMerchantOrderNo(OID.newID());
        takeCouponOrder1.setPlatMerchantOrderNo(OID.newID());
        TakeCouponResult takeCouponResult1 = couponTransService.takeCoupon(takeCouponOrder1);

        couponId = takeCouponResult.getCouponInfos().get(0).getCouponId();
        couponId1 = takeCouponResult.getCouponInfos().get(1).getCouponId();
        couponId2 = takeCouponResult.getCouponInfos().get(2).getCouponId();
        couponId3 = takeCouponResult.getCouponInfos().get(3).getCouponId();

        CouponDO couponDO = promotionTestBase.findCouponByCouponId(couponId).get(0);
        couponDO.setStatus("APPLIED");
        promotionTestBase.updateCouponByCouponId(couponId, couponDO);
        if (testId == 1001) {
            couponId = "3333333";
        }
        // 测试过程
        List<String> couponIds = new ArrayList<>();
        couponIds.add(couponId);
        if (testId != 1002) {
            couponIds.add(couponId1);
            couponIds.add(couponId2);
            couponIds.add(couponId3);
        }
        if (testId <= 1002) {
            order.setCouponIds(couponIds);
        }
        if (testId == 1003) {
            order.setBizInstructionId(takeCouponResult.getInstructionId());
        }
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo(OID.newID());
        order.setPlatMerchantOrderNo(OID.newID());
        // 调用接口
        CouponTransResult result = couponTransService.recycleCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // InstructionDO instructionDO = promotionTestBase.findInstructionByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
        // assertEquals(order.getGid(), instructionDO.getGid());
        // assertEquals(order.getReqId(), instructionDO.getReqId());
        // assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        // assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        // assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        // assertEquals(result.getInstructionId(), instructionDO.getInstructionId());
        // assertEquals(result.getStatus() + "", instructionDO.getStatus());
        // assertEquals(result.getCode(), instructionDO.getCode());

        if (testId >= 1002) {
            CouponDO couponDO1 = promotionTestBase.findCouponByCouponId(couponId).get(0);
            assertEquals("APPLIED", couponDO1.getStatus());
        }

        // 清除数据
        promotionTestBase.cleanCouponDefinitionByPartnerId(createCouponDefinitionOrder.getPartnerId());
        promotionTestBase.cleanCouponByUserId(takeCouponOrder.getUserId());
        promotionTestBase.cleanCouponByUserId(takeCouponOrder1.getUserId());
        promotionTestBase.cleanInstructionByMerchantOrderNo(order.getMerchantOrderNo());
    }
}
