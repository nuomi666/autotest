package com.xjy.autotest.promotion;

import com.alibaba.fastjson.JSON;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.promotion.api.coupon.enums.CouponType;
import com.xyb.promotion.api.coupon.params.CouponContextInfo;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.coupon.params.ComputeCouponResult;
import com.xyb.promotion.api.coupon.CouponManageService;

import java.lang.String;

import com.xyb.promotion.api.coupon.params.ComputeCouponOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * 计算券优惠金额逻辑：按传入券顺序计算优惠金额
 * 注意事项：
 * 券1：满100元减5元；
 * 券2：9.2折;
 * 场景1：订单金额100元，传入券1+券2，此时会先用券1减去5元，
 * 再计算券2的折扣,优惠金额为5+(100-5)*(1-0.92)=12.6元
 * 场景2：订单金额100元，传入券2+券1，此时会先用券2计算折扣，
 * 此时券1会因条件不满足而计算不到，优惠金额为100*（1-0.92）=8元
 * 场景3：订单金额110元，传入券2+券1，此时会先用券2计算折扣，
 * 再计算券1的满减，优惠金额为110*(1-0.92)+5=13.8元
 *
 * @author huairen
 * Created on 2019/01/31.
 */
@DisplayName("计算券优惠金额")
public class CouponManageServiceComputeCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;


    /**
     * 1001 一张满减券
     * 1002 一张立减券
     * 1003 一张折扣券
     * 1004 二张满减券
     * 1005 二张立减券
     * 1006 二张折扣券
     * 1007 一张满减券+一张立减券
     * 1008 一张折扣券+一张满减券
     * 1009 一张折扣券+一张立减券
     * 1010 一张折扣券+一张满减券+一张立减券
     * 1011 一张折扣券+一张满减券（折扣后满减不够）
     * 1012 一张满减券+一张折扣券
     * 1013 一张立减券+一张折扣券
     * 1014 一张满减券+一张立减券+一张折扣券
     * 1015 一张满减券+一张立减券+一张折扣券，不叠加
     */
    @AutoTest(file = "promotion/couponManageServiceComputeCouponTestSuccess.csv")
    @DisplayName("计算券优惠金额--成功用例")
    public void couponManageServiceComputeCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ComputeCouponOrder order,
            String couponId,
            String couponId1,
            String couponId2,
            //coupon表
            CouponDO couponDO,
            CouponDO couponDO1,
            CouponDO couponDO2,
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2

    ) {
        // 清除数据
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());

        // 准备数据
        promotionTestBase.insertCoupon(couponDO);
        promotionTestBase.insertCoupon(couponDO1);
        promotionTestBase.insertCoupon(couponDO2);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        // 测试过程
        List<String> couponIds = new ArrayList<String>();
        couponIds.add(couponId);
        if (testId >= 1007) {
            couponIds.add(couponId1);
        }
        if (testId == 1010 || testId >= 1014) {
            couponIds.add(couponId2);
        }
        order.setCouponIds(couponIds);
        // 调用接口
        ComputeCouponResult result = couponManageService.computeCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        List<CouponContextInfo> couponContextInfos = result.getCouponContextInfos();
        // 满减金额
        String amount = "";
        Money manjianMoney = new Money();
        Money zhijianMoney = new Money();
        if (testId != 1005 && testId != 1006) {
            amount = JSON.parseObject(couponDO1.getAmountData()).getJSONArray("items").getJSONObject(0).getJSONObject("value").getString("amount");
            manjianMoney = new Money(amount);
        }
        if (testId != 1004) {
            zhijianMoney = new Money(couponDO.getAmountData() + "");
        }
        double discount = Double.parseDouble(couponDO2.getAmountData() + "");
        if (testId == 1001) {
            assertEquals(manjianMoney, result.getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(0).getCouponAmount());
        }
        if (testId == 1002) {
            assertEquals(zhijianMoney, result.getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(0).getCouponAmount());

        }
        if (testId == 1003) {
            assertEquals(order.getTransAmount().multiply(1 - discount), result.getCouponAmount());
            assertEquals(order.getTransAmount().multiply(1 - discount), couponContextInfos.get(0).getCouponAmount());
        }
        if (testId == 1004) {
            // 优惠金额等于两张满减金额之和
            assertEquals(manjianMoney, result.getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(0).getCouponAmount());
        }
        if (testId == 1005) {
            // 优惠金额等于两张立减金额之和
            assertEquals(zhijianMoney, result.getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(0).getCouponAmount());
        }
        if (testId == 1006) {
            // 优惠金额等于券1的折扣后的金额计算券2的折扣
            assertEquals(order.getTransAmount()
                            .multiply(1 - discount)
                    , result.getCouponAmount());
            assertEquals(order.getTransAmount()
                            .multiply(1 - discount)
                    , couponContextInfos.get(0).getCouponAmount());
        }
        if (testId == 1007) {
            // 优惠金额等于券1满减+券2立减金额
            assertEquals(manjianMoney
                            .add(zhijianMoney),
                    result.getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(0).getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(1).getCouponAmount());
        }
        if (testId == 1008) {
            // 优惠金额等于券1折扣+券2满减金额
            assertEquals(manjianMoney
                            .add(order.getTransAmount().multiply(1 - discount)),
                    result.getCouponAmount());
            assertEquals(order.getTransAmount().multiply(1 - discount), couponContextInfos.get(0).getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(1).getCouponAmount());

        }
        if (testId == 1009) {
            // 优惠金额等于券1折扣+券2立减金额
            assertEquals(order.getTransAmount().multiply(1 - discount)
                            .add(zhijianMoney),
                    result.getCouponAmount());
            assertEquals(order.getTransAmount().multiply(1 - discount), couponContextInfos.get(0).getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(1).getCouponAmount());
        }
        if (testId == 1010) {
            // 优惠金额等于券1折扣+券2满减金额+券3立减金额
            assertEquals(manjianMoney
                            .add(zhijianMoney)
                            .add(order.getTransAmount().multiply(1 - discount)),
                    result.getCouponAmount());
            assertEquals(order.getTransAmount().multiply(1 - discount), couponContextInfos.get(0).getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(1).getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(2).getCouponAmount());

        }
        if (testId == 1011) {
            // 优惠金额等于券1折扣金额（券2满减条件不满足）
            assertEquals(order.getTransAmount()
                            .multiply(1 - discount),
                    result.getCouponAmount());
            assertEquals(order.getTransAmount().multiply(1 - discount), couponContextInfos.get(0).getCouponAmount());
            assertEquals(new Money(0), couponContextInfos.get(1).getCouponAmount());
        }
        if (testId == 1012) {
            // 优惠金额等于券1满减金额+券1满减后金额计算的折扣金额
            assertEquals(manjianMoney
                            .add(order.getTransAmount()
                                    .subtract(manjianMoney)
                                    .multiply(1 - discount)),
                    result.getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(0).getCouponAmount());
            assertEquals(order.getTransAmount().subtract(manjianMoney).multiply(1 - discount), couponContextInfos.get(1).getCouponAmount());

        }
        if (testId == 1013) {
            // 优惠金额等于券1立减金额+券1立减后金额计算的折扣金额
            assertEquals(zhijianMoney
                            .add(order.getTransAmount()
                                    .subtract(zhijianMoney)
                                    .multiply(1 - discount)),
                    result.getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(0).getCouponAmount());
            assertEquals(order.getTransAmount().subtract(zhijianMoney).multiply(1 - discount), couponContextInfos.get(1).getCouponAmount());

        }
        if (testId == 1014) {
            // 优惠金额等于券1满减金额+券2立减金额+券1券2计算后金额的折扣金额
            assertEquals(manjianMoney
                            .add(zhijianMoney)
                            .add(order.getTransAmount()
                                    .subtract(manjianMoney)
                                    .subtract(zhijianMoney)
                                    .multiply(1 - discount)),
                    result.getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(0).getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(1).getCouponAmount());
            assertEquals(order.getTransAmount().subtract(manjianMoney).subtract(zhijianMoney).multiply(1 - discount), couponContextInfos.get(2).getCouponAmount());

        }
        if (testId == 1015) {
            // 优惠金额等于分别计算优惠金额
            assertEquals(manjianMoney
                            .add(zhijianMoney)
                            .add(order.getTransAmount().multiply(1 - discount)),
                    result.getCouponAmount());
            assertEquals(manjianMoney, couponContextInfos.get(0).getCouponAmount());
            assertEquals(zhijianMoney, couponContextInfos.get(1).getCouponAmount());
            assertEquals(order.getTransAmount().multiply(1 - discount), couponContextInfos.get(2).getCouponAmount());
        }


        // 数据验证
        // 清除数据
        promotionTestBase.cleanCouponByCouponId(couponDO.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO1.getCouponId());
        promotionTestBase.cleanCouponByCouponId(couponDO2.getCouponId());
    }
}
