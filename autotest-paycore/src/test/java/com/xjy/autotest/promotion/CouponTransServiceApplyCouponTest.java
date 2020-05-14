package com.xjy.autotest.promotion;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.params.TakeCouponOrder;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.coupon.params.ApplyCouponResult;
import com.xyb.promotion.api.coupon.CouponTransService;
import com.xyb.promotion.api.coupon.params.ApplyCouponOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.String;


/**
 * @author ychaoyang
 * Created on 2018/10/26.
 */
@DisplayName("使用优惠券")
public class CouponTransServiceApplyCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponTransService couponTransService;

    @Autowired
    PromotionTestBase promotionTestBase;


    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 1001 使用一张满减券
     * 1002 使用一张直减券
     * 1003 使用一张折扣券
     * 1004 使用一张满减券+直减券
     * 1005 使用一张满减券+折扣券
     * 1006 使用一张直减券+折扣券
     * 1007 使用一张满减券+直减券+折扣券
     * 1008 使用一张满减券,已锁定
     * 1009 使用一张满减券,已锁定，已过期
     * 1010 使用一张满减券,已锁定，未到有效期
     */
    @AutoTest(file = "promotion/couponTransServiceApplyCouponTestSuccess.csv")
    @DisplayName("使用优惠券--成功用例")
    public void couponTransServiceApplyCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ApplyCouponOrder order,
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
        String key = "xyb-promotion:couponDefinitionId_" + couponDefinitionDO.getDefinitionId();
        String key1 = "xyb-promotion:couponDefinitionId_" + couponDefinitionDO1.getDefinitionId();
        String key2 = "xyb-promotion:couponDefinitionId_" + couponDefinitionDO2.getDefinitionId();
        if (testId == 1001) {
            redisTemplate.delete(key);
            redisTemplate.delete(key1);
            redisTemplate.delete(key2);
        }
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("platMerchNo" + System.currentTimeMillis());
        List<String> couponIds = new ArrayList<String>();
        if (testId == 1001) {
            couponIds.add(couponDO.getCouponId());
        }
        if (testId == 1002) {
            couponIds.add(couponDO1.getCouponId());
        }
        if (testId == 1003) {
            couponIds.add(couponDO2.getCouponId());
        }
        if (testId == 1004) {
            couponIds.add(couponDO.getCouponId());
            couponIds.add(couponDO1.getCouponId());
        }
        if (testId == 1005) {
            couponIds.add(couponDO.getCouponId());
            couponIds.add(couponDO2.getCouponId());
        }
        if (testId == 1006) {
            couponIds.add(couponDO1.getCouponId());
            couponIds.add(couponDO2.getCouponId());
        }
        if (testId == 1007) {
            couponIds.add(couponDO.getCouponId());
            couponIds.add(couponDO1.getCouponId());
            couponIds.add(couponDO2.getCouponId());
        }
        if (testId >= 1008) {
            couponIds.add(couponDO.getCouponId());
        }
        order.setCouponIds(couponIds);
        // 调用接口
        ApplyCouponResult result = couponTransService.applyCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertCoupon(couponDO);
        }
        if (testId == 1002) {
            assertCoupon(couponDO1);
        }
        if (testId == 1003) {
            assertCoupon(couponDO2);
        }
        if (testId == 1004) {
            assertCoupon(couponDO);
            assertCoupon(couponDO1);
        }
        if (testId == 1005) {
            assertCoupon(couponDO);
            assertCoupon(couponDO2);
        }
        if (testId == 1006) {
            assertCoupon(couponDO1);
            assertCoupon(couponDO2);
        }
        if (testId == 1007) {
            assertCoupon(couponDO);
            assertCoupon(couponDO1);
            assertCoupon(couponDO2);
        }
        if (testId >= 1008) {
            assertCoupon(couponDO);
        }
        //redis验证
        String store = redisTemplate.opsForValue().get(key);
        String store1 = redisTemplate.opsForValue().get(key1);
        String store2 = redisTemplate.opsForValue().get(key2);
        assertTrue(StringUtils.isNotBlank(store));
        if (testId >= 1002) {
            assertTrue(StringUtils.isNotBlank(store1));
        }
        if (testId >= 1003) {
            assertTrue(StringUtils.isNotBlank(store2));
        }
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByUserId(couponDO.getUserId());
    }

    /**
     * 1001 券已过期
     * 1002 券已失效
     * 1003 券不是领取或锁定状态
     */
    @AutoTest(file = "promotion/couponTransServiceApplyCouponTestFailTwo.csv")
    @DisplayName("使用优惠券失败--失败用例")
    public void couponTransServiceApplyCouponTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ApplyCouponOrder order,
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
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("platMerchNo" + System.currentTimeMillis());
        List<String> couponIds = new ArrayList<String>();
        couponIds.add(couponDO.getCouponId());
        order.setCouponIds(couponIds);
        // 调用接口
        ApplyCouponResult result = couponTransService.applyCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(couponDO.getStatus(), promotionTestBase.findCouponByCouponId(couponDO.getCouponId()).get(0).getStatus());
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByUserId(couponDO.getUserId());
    }

    /**
     * 验证Coupon表数据
     *
     * @param couponDO
     */
    public void assertCoupon(CouponDO couponDO) {
        CouponDO cDO = promotionTestBase.findCouponByCouponId(couponDO.getCouponId()).get(0);
        assertEquals("APPLIED", cDO.getStatus());
        couponDO.setStatus(cDO.getStatus());
        couponDO.setAppliedTime(cDO.getAppliedTime());
        couponDO.setDiscountAmount(cDO.getDiscountAmount());
        couponDO.setRawUpdateTime(cDO.getRawUpdateTime());
        assertEquals(couponDO, cDO);
    }
}
