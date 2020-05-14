package com.xjy.autotest.promotion;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.params.CouponInfo;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.coupon.params.QueryCouponResult;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.QueryValidCouponOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/01/23.
 */
public class CouponManageServiceQueryValidCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 三张优惠券
     * 1002 一张满减券
     * 1003 一张直减券
     * 1004 一张折扣券
     * 1005 用户没有优惠券
     * 1006 一张满减券
     * 1007 用户有效期内没有优惠券,有效期过了
     * 1008 用户有效期内没有优惠券,有效期未到
     */
    @AutoTest(file = "promotion/couponManageServiceQueryValidCouponTestSuccess.csv")
    @DisplayName("查询用户有效券--成功用例")
    public void couponManageServiceQueryValidCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryValidCouponOrder order,
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
        if (testId != 1005) {
            promotionTestBase.insertCouponDefinition(couponDefinitionDO);
            promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
            promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
            promotionTestBase.insertCoupon(couponDO);
            promotionTestBase.insertCoupon(couponDO1);
            couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
            promotionTestBase.insertCoupon(couponDO2);
        }
        // 测试过程
        // 测试过程
        // 调用接口
        QueryCouponResult result = couponManageService.queryValidCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        if (testId == 1001 || testId == 1006) {
            assertEquals(3, result.getCoupons().size());
        }
        if (testId >= 1002 && testId <= 1004) {
            assertEquals(1, result.getCoupons().size());
        }
        CouponInfo couponInfo = null;
        if (testId <= 1004) {
            couponInfo = result.getCoupons().get(0);
            if (testId == 1002) {
                assertEquals(couponDO.getCouponId(), couponInfo.getCouponId());
            }
            if (testId == 1003) {
                assertEquals(couponDO1.getCouponId(), couponInfo.getCouponId());
            }
            if (testId == 1004) {
                assertEquals(couponDO2.getCouponId(), couponInfo.getCouponId());
            }
        }
        if (testId == 1005 || testId == 1007 || testId == 1008) {
            assertEquals(0, result.getCoupons().size());
        }
        // 数据验证
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByUserId(couponDO.getUserId());
    }

    /**
     * 1001 userId传空
     * 1002 gid传空
     */
    @AutoTest(file = "promotion/couponManageServiceQueryValidCouponTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void couponManageServiceQueryValidCouponTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryValidCouponOrder order,
            //coupon表
            CouponDO couponDO,
            CouponDO couponDO1,
            CouponDO couponDO2,
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 测试过程
        // 调用接口
        QueryCouponResult result = couponManageService.queryValidCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

}
