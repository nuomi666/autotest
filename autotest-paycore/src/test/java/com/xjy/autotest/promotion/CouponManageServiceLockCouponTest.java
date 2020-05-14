package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.enums.LockType;
import com.xyb.promotion.api.coupon.params.CouponTransResult;
import com.xyb.promotion.api.coupon.params.LockCouponsOrder;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponLogDO;
import dal.model.promotion.InstructionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author huairen
 * Created on 2019/01/31.
 */
public class CouponManageServiceLockCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 锁定单张优惠券
     * 1002 锁定多张优惠券
     * 1003 解锁多张优惠券
     * 1004 解锁单张优惠券
     * 1005 锁定单张优惠券,已过期，传一个有效期的时间
     * 1006 锁定单张优惠券,未到有效期，传一个有效期的时间
     * 1007 锁定单张优惠券,重复锁定
     * 1008 解锁单张优惠券,重复解锁
     * 1009 锁定单张优惠券,解锁后锁定
     * 1010 解锁单张优惠券,锁定后解锁
     * 1011 解锁单张优惠券,锁定后解锁
     */
    @AutoTest(file = "promotion/couponManageServiceLockCouponTestSuccess.csv")
    @DisplayName("锁定解锁优惠券--成功用例")
    public void couponManageServiceLockCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            LockCouponsOrder order,
            String couponId,
            String couponId1,
            String couponId2,
            //coupon表
            CouponDO couponDO,
            CouponDO couponDO1,
            CouponDO couponDO2,
            LockType lockType1
    ) {
        // 清除数据
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
        // 准备数据
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        List<String> couponIds = new ArrayList<String>();
        couponIds.add(couponId);
        if (testId == 1002 || testId == 1003) {
            couponIds.add(couponId1);
            couponIds.add(couponId2);
        }
        order.setCouponIds(couponIds);
        order.setMerchantOrderNo(OID.newID());
        order.setPlatMerchantOrderNo(OID.newID());
        order.setReqId(OID.newID());
        if (testId >= 1007) {
            couponManageService.lockCoupon(order);
        }
        if (testId >= 1009 && testId <= 1011) {
            order.setLockType(lockType1);
        }
        if (testId == 1011) {
            order.setReqId(OID.newID());
            order.setGid(GID.newGID());
            order.setMerchantOrderNo(OID.newID());
            order.setPlatMerchantOrderNo(OID.newID());
        }
        // 调用接口
        CouponTransResult result = couponManageService.lockCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        String instructionId = result.getInstructionId();
        if (testId == 1007 || testId == 1008) {
            assertTrue(result.isIdempotent());
        } else {
            assertFalse(result.isIdempotent());
        }
        // 数据验证
        if (testId == 1001) {
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId).get(0).getStatus());
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId1).get(0).getStatus());
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId2).get(0).getStatus());
        }
        if (testId == 1002) {
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId).get(0).getStatus());
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId1).get(0).getStatus());
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId2).get(0).getStatus());
        }
        if (testId == 1003) {
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId).get(0).getStatus());
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId1).get(0).getStatus());
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId2).get(0).getStatus());
        }
        if (testId == 1004) {
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId).get(0).getStatus());
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId1).get(0).getStatus());
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId2).get(0).getStatus());
        }
        if (testId == 1005 || testId == 1006) {
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId).get(0).getStatus());
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId1).get(0).getStatus());
            assertEquals("TAKEN", promotionTestBase.findCouponByCouponId(couponId2).get(0).getStatus());
        }
        InstructionDO instructionDO = promotionTestBase.findInstructionByReqIdAndInstructionType(order.getReqId(), order.getLockType().name()).get(0);
        assertEquals(instructionId, instructionDO.getInstructionId());
        assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        assertEquals(order.getGid(), instructionDO.getGid());
        assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getMerchantOrderNo(), instructionDO.getMerchantOrderNo());
        assertEquals(order.getLockType().name(), instructionDO.getInstructionType());
        assertEquals("SUCCESS", instructionDO.getStatus());
        assertEquals("comn_00_0000", instructionDO.getCode());
        assertNotNull(instructionDO.getRawAddTime());
        assertNotNull(instructionDO.getRawUpdateTime());

        CouponLogDO couponLogDO = promotionTestBase.findCouponLogByReqIdAndType(order.getReqId(), order.getLockType().name()).get(0);
        assertEquals(instructionId, couponLogDO.getInstructionId());
        assertEquals(couponId, couponLogDO.getCouponId());
        assertEquals(couponDO.getDefinitionId(), couponLogDO.getDefinitionId());
        assertEquals(order.getGid(), couponLogDO.getGid());
        assertEquals(order.getReqId(), couponLogDO.getReqId());
        assertEquals(order.getPlatPartnerId(), couponLogDO.getPlatPartnerId());
        assertEquals(order.getPartnerId(), couponLogDO.getPartnerId());
        assertEquals(couponDO.getUserId(), couponLogDO.getUserId());
        assertEquals(order.getLockType().name(), couponLogDO.getType());
        assertNotNull(couponLogDO.getRawAddTime());
        assertNotNull(couponLogDO.getRawUpdateTime());
        if (testId == 1009 || testId == 1010) {
            InstructionDO instructionDO1 = promotionTestBase.findInstructionByReqIdAndInstructionType(order.getReqId(), lockType1.name()).get(0);
            instructionDO1.setInstructionType(instructionDO.getInstructionType());
            assertEquals(instructionDO, instructionDO1);
            CouponLogDO couponLogDO1 = promotionTestBase.findCouponLogByReqIdAndType(order.getReqId(), lockType1.name()).get(0);
            couponLogDO1.setType(couponLogDO.getType());
            assertEquals(couponLogDO, couponLogDO1);
        }
        // 清除数据
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
    }

    /**
     * 1001 锁定优惠券失败，过了有效期
     * 1002 锁定优惠券失败，没在有效期
     * 1003 锁定优惠券失败，未到有效期
     * 1004 锁定优惠券失败，不是领取状态
     * 1005 解锁优惠券失败，不是锁定状态
     * 1006 重复锁定，锁定成功
     * 1007 重复锁定，锁定优惠券失败
     * 1008 优惠券不存在
     */
    @AutoTest(file = "promotion/couponManageServiceLockCouponTestFailTwo.csv")
    @DisplayName("锁定解锁优惠券失败--失败用例")
    public void couponManageServiceLockCouponTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            LockCouponsOrder order,
            String couponId,
            String couponId1,
            String couponId2,
            //coupon表
            CouponDO couponDO,
            CouponDO couponDO1,
            CouponDO couponDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
        // 准备数据
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        List<String> couponIds = new ArrayList<String>();
        couponIds.add(couponId);
        if (testId == 1002 || testId == 1003) {
            couponIds.add(couponId1);
            couponIds.add(couponId2);
        }
        order.setCouponIds(couponIds);
        order.setMerchantOrderNo(OID.newID());
        order.setPlatMerchantOrderNo(OID.newID());
        order.setReqId(OID.newID());
        if (testId >= 1006 && testId <= 1007) {
            couponManageService.lockCoupon(order);
        }
        // 调用接口
        CouponTransResult result = couponManageService.lockCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        if (testId != 1006) {
            assertEquals(couponDO.getStatus(), promotionTestBase.findCouponByCouponId(couponDO.getCouponId()).get(0).getStatus());
        }
        assertEquals(couponDO1.getStatus(), promotionTestBase.findCouponByCouponId(couponId1).get(0).getStatus());
        assertEquals(couponDO2.getStatus(), promotionTestBase.findCouponByCouponId(couponId2).get(0).getStatus());
        if (testId == 1006) {
            assertEquals("LOCKED", promotionTestBase.findCouponByCouponId(couponId).get(0).getStatus());
        }
        // 数据验证
        // 清除数据
    }


}
