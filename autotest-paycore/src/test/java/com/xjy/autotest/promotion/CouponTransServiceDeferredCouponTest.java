package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.promotion.api.coupon.CouponTransService;
import com.xyb.promotion.api.coupon.params.CouponInfo;
import com.xyb.promotion.api.coupon.params.CouponTransResult;
import com.xyb.promotion.api.coupon.params.DeferredCouponOrder;
import com.xyb.promotion.api.coupon.params.DeferredCouponResult;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @author huairen
 * Created on 2019/05/15.
 */
public class CouponTransServiceDeferredCouponTest extends SpringBootTestBase {


    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponTransService couponTransService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 延长券有效期一年
     * 1002 延长券有效期一个月
     * 1003 延长券有效期一天
     * 1004 延长券有效期一个小时
     * 1005 延长券有效期一分钟
     * 1006 延长券有效期3年
     * 1007 延长券有效期3个月
     * 1008 延长券有效期3天
     * 1009 延长券有效期3个小时
     * 1010 延长券有效期3分钟
     */
    @AutoTest(file = "promotion/couponTransServiceDeferredCouponTestSuccess.csv")
    @DisplayName("延长优惠券有效时间--成功用例")
    public void couponTransServiceDeferredCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeferredCouponOrder order,
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
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        //couponDO.setDefinitionJson(couponDefinitionDO.getDefinitionJson());
        //couponDO1.setDefinitionJson(couponDefinitionDO1.getDefinitionJson());
        //couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程

        // 调用接口
        DeferredCouponResult result = couponTransService.deferredCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponDO cDO = promotionTestBase.findCouponByCouponId(order.getCouponId()).get(0);
        Date beforeDate = couponDO.getValidEndTime();
        Date afterDate = cDO.getValidEndTime();
        assertEquals(beforeDate, result.getOldValidEndTime());
        assertEquals(afterDate, result.getNewValidEndTime());
        CouponInfo couponInfo = result.getCouponInfo();
        assertEquals(cDO.getCouponId(), couponInfo.getCouponId());
        assertEquals(cDO.getDefinitionId(), couponInfo.getDefinitionId());
        assertEquals(cDO.getUserId(), couponInfo.getUserId());
        assertEquals(cDO.getCouponType(), couponInfo.getCouponType().name());
        assertEquals(cDO.getStatus(), couponInfo.getStatus().name());
        assertEquals(cDO.getPlatPartnerId(), couponInfo.getPlatPartnerId());
        assertEquals(cDO.getPartnerId(), couponInfo.getPartnerId());
        assertEquals(cDO.getName(), couponInfo.getName());
        assertEquals(cDO.getInnerName(), couponInfo.getInnerName());
        assertEquals(cDO.getTakenTime(), couponInfo.getTakenTime());
        assertEquals(cDO.getAppliedTime(), couponInfo.getAppliedTime());
        assertEquals(cDO.getValidStartTime(), couponInfo.getValidStartTime());
        //assertEquals(cDO.getValidEndTime(), couponInfo.getValidEndTime());
        assertEquals(cDO.getInstructionId(), couponInfo.getInstructionId());
        if (testId >= 1006) {
            beforeDate = couponDO1.getValidEndTime();
        }
        int minutes = (int) ((afterDate.getTime() - beforeDate.getTime()) / 60000L);
        int days = DateUtil.countDaysBetweenTwoDays(beforeDate, afterDate);
        if (testId == 1001) {
            assertTrue(365 <= days && days <= 366);
        }
        if (testId == 1002) {
            assertTrue(28 <= days && days <= 31);
        }
        if (testId == 1003) {
            assertEquals(1, days);
        }
        if (testId == 1004) {
            assertEquals(60, minutes);
        }
        if (testId == 1005) {
            assertEquals(1, minutes);
        }
        if (testId == 1006) {
            assertTrue(365 * 3 <= days && days <= 366 * 3);
        }
        if (testId == 1007) {
            assertTrue(28 * 3 <= days && days <= 31 * 3);
        }
        if (testId == 1008) {
            assertEquals(3, days);
        }
        if (testId == 1009) {
            assertEquals(180, minutes);
        }
        if (testId == 1010) {
            assertEquals(3, minutes);
        }
        // 清除数据
        //promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        //promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        //promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        //promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO.getDefinitionId());
        //promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO1.getDefinitionId());
        //promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO2.getDefinitionId());
        //promotionTestBase.cleanCouponLogByCouponId(couponDO.getCouponId());
        //promotionTestBase.cleanCouponLogByCouponId(couponDO1.getCouponId());
        //promotionTestBase.cleanCouponLogByCouponId(couponDO2.getCouponId());
    }


    /**
     * 1001 couponId传空
     * 1002 timeUnit传空
     * 1003 gid传空
     * 1004 reqId传空
     * 1005 partnerId传空
     * 1006 merchantOrderNo传空
     */
    @AutoTest(file = "promotion/couponTransServiceDeferredCouponTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void couponTransServiceDeferredCouponTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeferredCouponOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        CouponTransResult result = couponTransService.deferredCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 优惠券不存在
     * 1002 优惠券延长后还是过期
     * 1003 优惠券已使用
     * 1004 优惠券已赠送
     */
    @AutoTest(file = "promotion/couponTransServiceDeferredCouponTestFailTwo.csv")
    @DisplayName("延长优惠券失败--失败用例")
    public void couponTransServiceDeferredCouponTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeferredCouponOrder order,
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
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        couponDO.setDefinitionJson(couponDefinitionDO.getDefinitionJson());
        couponDO1.setDefinitionJson(couponDefinitionDO1.getDefinitionJson());
        couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程

        // 调用接口
        CouponTransResult result = couponTransService.deferredCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponDO cDO = promotionTestBase.findCouponByCouponId(couponDO.getCouponId()).get(0);
        assertEquals(couponDO, cDO);
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
    }
}
