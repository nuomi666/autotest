package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.CouponInfo;
import com.xyb.promotion.api.coupon.params.QueryCouponDetailOrder;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/01/31.
 */
public class CouponManageServiceQueryCouponDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 查询已领取满减优惠券详情
     * 1002 查询已领取立减优惠券详情
     * 1003 查询已领取折扣优惠券详情
     */
    @AutoTest(file = "promotion/couponManageServiceQueryCouponDetailTestSuccess.csv")
    @DisplayName("查询优惠券详情--成功用例")
    public void couponManageServiceQueryCouponDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCouponDetailOrder order,
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
        promotionTestBase.cleanCouponDefinitionByInnerName(couponDefinitionDO.getInnerName());
        promotionTestBase.cleanCouponDefinitionByInnerName(couponDefinitionDO1.getInnerName());
        promotionTestBase.cleanCouponDefinitionByInnerName(couponDefinitionDO2.getInnerName());
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
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        BizResult<CouponInfo> result = couponManageService.queryCouponDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponInfo couponInfo = result.getInfo();
        CouponDO coupDO= null;
        if(testId ==1001){
            coupDO = couponDO;
        }
        if(testId ==1002){
            coupDO = couponDO1;
        }
        if(testId ==1003){
            coupDO = couponDO2;
        }
        assertEquals(order.getCouponId(), couponInfo.getCouponId());
        assertEquals(coupDO.getDefinitionId(), couponInfo.getDefinitionId());
        assertEquals(coupDO.getUserId(), couponInfo.getUserId());
        assertEquals(coupDO.getCouponType(), couponInfo.getCouponType() + "");
        assertEquals(coupDO.getStatus(), couponInfo.getStatus() + "");
        assertEquals(coupDO.getPlatPartnerId(), couponInfo.getPlatPartnerId());
        assertEquals(coupDO.getPartnerId(), couponInfo.getPartnerId());
        assertEquals(coupDO.getName(), couponInfo.getName());
        assertEquals(coupDO.getInnerName(), couponInfo.getInnerName());
        String json = null;
        if(testId == 1001){
            json = couponDefinitionDO.getDefinitionJson();
        }
        if(testId == 1002){
            json = couponDefinitionDO1.getDefinitionJson();
        }
        if(testId == 1003){
            json = couponDefinitionDO2.getDefinitionJson();
        }
        assertEquals(json, couponInfo.getDefinitionJson());
        assertEquals(coupDO.getValidStartTime(), couponInfo.getValidStartTime());
        assertEquals(coupDO.getValidEndTime(), couponInfo.getValidEndTime());
        assertEquals(coupDO.getInstructionId(), couponInfo.getInstructionId());
        // 清除数据
    }

    /**
     * 1001 查询券不存在
     */
    @AutoTest(file = "promotion/couponManageServiceQueryCouponDetailTestFailTwo.csv")
    @DisplayName("查询优惠券详情--失败用例")
    public void couponManageServiceQueryCouponDetailTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCouponDetailOrder order,
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
        promotionTestBase.cleanCouponDefinitionByInnerName(couponDefinitionDO.getInnerName());
        promotionTestBase.cleanCouponDefinitionByInnerName(couponDefinitionDO1.getInnerName());
        promotionTestBase.cleanCouponDefinitionByInnerName(couponDefinitionDO2.getInnerName());
        promotionTestBase.cleanCouponByUserId(couponDO.getUserId());
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        couponDO.setDefinitionJson(couponDefinitionDO1.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO);
        couponDO1.setDefinitionJson(couponDefinitionDO.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO1);
        couponDO2.setDefinitionJson(couponDefinitionDO2.getDefinitionJson());
        promotionTestBase.insertCoupon(couponDO2);
        // 测试过程
        BizResult<CouponInfo> result = couponManageService.queryCouponDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
