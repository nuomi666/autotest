package com.xjy.autotest.promotion;

import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.params.CouponInfo;
import dal.model.promotion.CouponDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.coupon.params.QueryCouponsPageResult;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.QueryCouponsPageOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/01/31.
 */
public class CouponManageServiceQueryCouponsPageTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 根据userId查询券
     * 1002 根据status查询券
     * 1003 根据partnerId查询券
     * 1004 根据platPartnerId查询券
     * 1005 根据userId分页查询券查询第一页
     * 1006 根据userId分页查询券查询第二页
     * 1007 根据userId分页查询券查询最后页
     * 1008 根据userId查询券1张券
     * 1009 根据userId查询券0张券
     * 1010 根据userId查询有效券
     * 1011 根据userId查询已使用券
     * 1012 根据userId查询过期券
     */
    @AutoTest(file = "promotion/couponManageServiceQueryCouponsPageTestSuccess.csv")
    @DisplayName("分页查询券--成功用例")
    public void couponManageServiceQueryCouponsPageTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCouponsPageOrder order,
            Page page,
            //coupon表
            CouponDO couponDO,
            CouponDO couponDO1,
            CouponDO couponDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponByUserId(couponDO.getUserId());
        promotionTestBase.cleanCouponByUserId(order.getUserId());
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
        promotionTestBase.cleanCouponByPartnerId(couponDO.getPartnerId());
        // 准备数据
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        order.setPage(page);
        // 调用接口
        QueryCouponsPageResult result = couponManageService.queryCouponsPage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId <= 1004) {
            assertEquals(2, result.getPageResult().getTotal());
            assertEquals(2, result.getPageResult().getRecords().size());
        }
        if (testId >= 1005 && testId <= 1007) {
            assertEquals(3, result.getPageResult().getTotal());
            assertEquals(1, result.getPageResult().getRecords().size());
        }
        if (testId == 1008) {
            assertEquals(1, result.getPageResult().getTotal());
            assertEquals(1, result.getPageResult().getRecords().size());
            CouponInfo couponInfo = result.getPageResult().getRecords().get(0);
            assertEquals(couponDO.getCouponId(), couponInfo.getCouponId());
            assertEquals(couponDO.getDefinitionId(), couponInfo.getDefinitionId());
            assertEquals(couponDO.getCouponType(), couponInfo.getCouponType() + "");
            assertEquals(couponDO.getStatus(), couponInfo.getStatus() + "");
            assertEquals(couponDO.getPlatPartnerId(), couponInfo.getPlatPartnerId());
            assertEquals(couponDO.getPartnerId(), couponInfo.getPartnerId());
            assertEquals(couponDO.getName(), couponInfo.getName());
            assertEquals(null, couponInfo.getDefinitionJson());
            assertEquals(couponDO.getTakenTime(), couponInfo.getTakenTime());
            assertEquals(couponDO.getAppliedTime(), couponInfo.getAppliedTime());
            assertEquals(couponDO.getValidStartTime(), couponInfo.getValidStartTime());
            assertEquals(couponDO.getValidEndTime(), couponInfo.getValidEndTime());
            assertEquals(couponDO.getInstructionId(), couponInfo.getInstructionId());
        }
        if (testId == 1009) {
            assertEquals(0, result.getPageResult().getTotal());
            assertEquals(0, result.getPageResult().getRecords().size());
        }
        if (testId == 1010) {
            assertEquals(1, result.getPageResult().getTotal());
            assertEquals(1, result.getPageResult().getRecords().size());
        }
        if ( testId == 1011 || testId == 1012) {
            assertEquals(2, result.getPageResult().getTotal());
            assertEquals(2, result.getPageResult().getRecords().size());
        }
        // 清除数据
    }
}
