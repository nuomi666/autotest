package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.CouponTransService;
import com.xyb.promotion.api.coupon.params.CouponInfo;
import com.xyb.promotion.api.coupon.params.GiftCouponOrder;
import com.xyb.promotion.api.coupon.params.GiftCouponResult;
import dal.model.promotion.*;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/05/15.
 */
public class CouponTransServiceGiftCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponTransService couponTransService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 赠送一张直减券
     * 1002 赠送一张折扣券
     * 1003 赠送一张满减券
     * 1004 幂等请求
     */
    @AutoTest(file = "promotion/couponTransServiceGiftCouponTestSuccess.csv")
    @DisplayName("赠送优惠券--成功用例")
    public void couponTransServiceGiftCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GiftCouponOrder order,
            //coupon表
            CouponDO couponDO,
            CouponDO couponDO1,
            CouponDO couponDO2,
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponLogByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponLogByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponLogByCouponId(couponDO2.getCouponId());
        promotionTestBase.cleanCouponTransferLogByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponTransferLogByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponTransferLogByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
        promotionTestBase.cleanCouponByUserId(order.getUserId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        if (testId == 1001) {
            order.setCouponId(couponDO.getCouponId());
        }
        if (testId == 1002) {
            order.setCouponId(couponDO1.getCouponId());
        }
        if (testId >= 1003) {
            order.setCouponId(couponDO2.getCouponId());
        }
        if (testId == 1004) {
            couponTransService.giftCoupon(order);
        }
        print(order);
        // 调用接口
        GiftCouponResult result = couponTransService.giftCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        String instructionId = result.getInstructionId();
        // 数据验证
        CouponDO cDO = promotionTestBase.findCouponByCouponId(order.getCouponId()).get(0);
        assertEquals("GIFTED", cDO.getStatus());
        CouponDO cDO1 = promotionTestBase.findCouponByUserId(order.getUserId()).get(0);
        assertEquals("TAKEN", cDO1.getStatus());
        assertEquals(cDO.getDefinitionId(), cDO1.getDefinitionId());
        assertEquals(cDO.getName(), cDO1.getName());
        assertEquals(cDO.getPartnerId(), cDO1.getPartnerId());
        assertEquals(cDO.getPlatPartnerId(), cDO1.getPlatPartnerId());
        assertEquals(cDO.getCouponType(), cDO1.getCouponType());
        assertEquals(cDO.getAmountData(), cDO1.getAmountData());
        assertEquals(cDO.getValidStartTime(), cDO1.getValidStartTime());
        assertEquals(cDO.getValidEndTime(), cDO1.getValidEndTime());
        assertEquals(cDO.getAppliedTime(), cDO1.getAppliedTime());
        assertEquals(cDO.getCanApplyTime(), cDO1.getCanApplyTime());
        assertEquals(cDO.getExpireNotifyTime(), cDO1.getExpireNotifyTime());
        CouponInfo oldCouponInfo = result.getOldCouponInfo();
        assertEquals(order.getCouponId(),oldCouponInfo.getCouponId());
        assertEquals(cDO.getUserId(),oldCouponInfo.getUserId());
        CouponInfo newCouponInfo = result.getNewCouponInfo();
        assertEquals(cDO1.getCouponId(),newCouponInfo.getCouponId());
        assertEquals(order.getUserId(),newCouponInfo.getUserId());
        CouponLogDO couponLogDO = promotionTestBase.findCouponLogByCouponId(order.getCouponId()).get(0);
        assertEquals(order.getCouponId(), couponLogDO.getCouponId());
        assertEquals(order.getPartnerId(), couponLogDO.getPartnerId());
        assertEquals("giftCoupon", couponLogDO.getType());
        assertEquals(instructionId, couponLogDO.getInstructionId());
        if (testId == 1001) {
            assertEquals(couponDO.getDefinitionId(), couponLogDO.getDefinitionId());
            assertEquals(couponDO.getUserId(), couponLogDO.getUserId());
            assertEquals(couponDO.getName(), couponLogDO.getName());
        }
        if (testId == 1002) {
            assertEquals(couponDO1.getDefinitionId(), couponLogDO.getDefinitionId());
            assertEquals(couponDO1.getUserId(), couponLogDO.getUserId());
            assertEquals(couponDO1.getName(), couponLogDO.getName());
        }
        if (testId >= 1003) {
            assertEquals(couponDO2.getDefinitionId(), couponLogDO.getDefinitionId());
            assertEquals(couponDO2.getUserId(), couponLogDO.getUserId());
            assertEquals(couponDO2.getName(), couponLogDO.getName());
        }
        InstructionDO instructionDO = promotionTestBase.findInstructionByInstructionId(instructionId).get(0);
        assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        assertEquals(order.getGid(), instructionDO.getGid());
        assertEquals(order.getReqId(), instructionDO.getReqId());
        assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getMerchantOrderNo(), instructionDO.getMerchantOrderNo());
        assertEquals("giftCoupon", instructionDO.getInstructionType());
        assertEquals("SUCCESS", instructionDO.getStatus());

        CouponTransferLogDO couponTDO = promotionTestBase.findCouponTransferLogByReqId(order.getReqId()).get(0);
        assertEquals(order.getGid(), couponTDO.getGid());
        assertEquals(order.getReqId(), couponTDO.getReqId());
        assertEquals(instructionId, couponTDO.getInstructionId());
        assertEquals(order.getPartnerId(), couponTDO.getPartnerId());
        assertEquals(order.getPlatPartnerId(), couponTDO.getPlatPartnerId());
        assertEquals(cDO.getUserId(), couponTDO.getDonorUserId());
        assertEquals(order.getUserId(), couponTDO.getReceiveUserId());
        assertEquals(order.getCouponId(), couponTDO.getOldCouponId());
        assertEquals(cDO1.getCouponId(), couponTDO.getNewCouponId());
        assertEquals(cDO1.getDefinitionId(), couponTDO.getDefinitionId());
        assertEquals(cDO.getCouponType(), couponTDO.getCouponType());
        assertEquals(cDO.getName(), couponTDO.getName());
        assertEquals(cDO.getTakenTime(), couponTDO.getTakenTime());
        assertEquals(cDO1.getValidEndTime(), couponTDO.getValidEndTime());
        assertNotNull(couponTDO.getRawAddTime());
        assertNotNull(couponTDO.getRawUpdateTime());
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponLogByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponLogByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponLogByCouponId(couponDO2.getCouponId());
        promotionTestBase.cleanCouponTransferLogByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponTransferLogByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponTransferLogByDefinitionId(couponDefinitionDO2.getDefinitionId());
    }

    /**
     * 1001 userId缺省
     * 1002 couponId缺省
     * 1003 gid缺省
     * 1004 reqId缺省
     * 1005 partnerId缺省
     * 1006 merchantOrderNo缺省
     */
    @AutoTest(file = "promotion/couponTransServiceGiftCouponTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void couponTransServiceGiftCouponTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GiftCouponOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        print(order);
        // 调用接口
        GiftCouponResult result = couponTransService.giftCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 赠送券不存在
     * 1002 赠送券已过期
     * 1003 赠送券已使用
     * 1004 赠送券对象为自己
     */
    @AutoTest(file = "promotion/couponTransServiceGiftCouponTestFailTwo.csv")
    @DisplayName("赠送优惠券失败--失败用例")
    public void couponTransServiceGiftCouponTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GiftCouponOrder order,
            //coupon表
            CouponDO couponDO,
            CouponDO couponDO1,
            CouponDO couponDO2,
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByUserId(couponDO.getUserId());
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        print(order);
        // 调用接口
        GiftCouponResult result = couponTransService.giftCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponDO cDO = promotionTestBase.findCouponByCouponId(couponDO.getCouponId()).get(0);
        assertEquals(couponDO.getStatus(), cDO.getStatus());

        // 清除数据
    }


}
