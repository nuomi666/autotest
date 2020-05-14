package com.xjy.autotest.promotion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.coupon.params.QueryCouponDefinitionResult;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.QueryCouponDefinitionOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/01/29.
 */
public class CouponManageServiceQueryCouponDefinitionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 根据Id查询立减券定义
     * 1002 根据Id查询满减券定义
     * 1003 根据Id查询折扣券定义
     * 1004 根据名称查询立减券定义
     * 1004 根据id+名称查询满减券定义
     */
    @AutoTest(file = "promotion/couponManageServiceQueryCouponDefinitionTestSuccess.csv")
    @DisplayName("查询券定义--成功用例")
    public void couponManageServiceQueryCouponDefinitionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCouponDefinitionOrder order,
            // 准备数据
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        // 测试过程
        // 调用接口
        QueryCouponDefinitionResult result = couponManageService.queryCouponDefinition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        CouponDefinitionDO coupondDO = null;
        if (testId == 1001) {
            coupondDO = couponDefinitionDO;
        }
        if (testId == 1002) {
            coupondDO = couponDefinitionDO1;
        }
        if (testId == 1003) {
            coupondDO = couponDefinitionDO2;
        }
        if (testId == 1004) {
            coupondDO = couponDefinitionDO;
        }
        if (testId == 1005) {
            coupondDO = couponDefinitionDO1;
        }
        assertEquals(coupondDO.getDefinitionId(), result.getInfo().getDefinitionId());
        assertEquals(coupondDO.getDefinitionStatus(), result.getInfo().getDefinitionStatus() + "");
        assertEquals(coupondDO.getPlatPartnerId(), result.getInfo().getPlatPartnerId());
        assertEquals(coupondDO.getPartnerId(), result.getInfo().getPartnerId());
        assertEquals(coupondDO.getCouponType(), result.getInfo().getCouponType() + "");
        assertEquals(coupondDO.getName(), result.getInfo().getName());
        assertEquals(coupondDO.getInnerName(), result.getInfo().getInnerName());
        assertEquals(coupondDO.getQuantity(), result.getInfo().getQuantity());
        assertEquals(coupondDO.getOverlay(), result.getInfo().getOverlay());
        assertEquals(coupondDO.getTakeCount().longValue(), result.getInfo().getTakeCount());
        assertEquals(coupondDO.getApplyCount().longValue(), result.getInfo().getApplyCount());
        assertEquals(coupondDO.getMemo(), result.getInfo().getMemo());
        JSONObject jsonObject = JSON.parseObject(coupondDO.getDefinitionJson());
        assertEquals(jsonObject.getJSONObject("restriction").getJSONObject("expiration").getInteger("applyInterval"),
                result.getInfo().getApplyInterval());
        assertEquals(jsonObject.getJSONObject("restriction").getJSONObject("expiration").getInteger("expiredInterval"),
                result.getInfo().getExpiredInterval());
        assertEquals(jsonObject.getJSONObject("restriction").getJSONObject("expiration").getString("intervalUnit"),
                result.getInfo().getIntervalUnit() + "");
        assertEquals(jsonObject.getJSONObject("restriction").getInteger("restrictQuantityPerUser"),
                result.getInfo().getRestrictQuantityPerUser());
        if (testId == 1001) {
            assertEquals(new Money(jsonObject.getJSONObject("amount").getString("amountData")),
                    new Money(result.getInfo().getAmountData() + ""));
        }
        if (testId == 1002) {
            assertEquals(jsonObject.getJSONObject("amount").getJSONObject("amountData"),
                    JSON.parseObject(result.getInfo().getAmountData() + ""));
        }
        if (testId == 1003) {
            assertEquals(jsonObject.getJSONObject("amount").getString("amountData"),
                    result.getInfo().getAmountData() + "");
        }
        // 清除数据
    }

    /**
     * 1001 根据id查询券定义不存在
     * 1002 根据名称查询券定义不存在
     * 1003 根据id+名称查询券定义不存在
     */
    @AutoTest(file = "promotion/couponManageServiceQueryCouponDefinitionTestFailTwo.csv")
    @DisplayName("查询券定义不存在--失败用例")
    public void couponManageServiceQueryCouponDefinitionTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCouponDefinitionOrder order,
            // 准备数据
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        // 测试过程
        // 调用接口
        QueryCouponDefinitionResult result = couponManageService.queryCouponDefinition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
