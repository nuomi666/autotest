package com.xjy.autotest.promotion;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.promotion.api.coupon.enums.CouponType;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.base.PromotionResult;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.ModifyCouponDefinitionOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * @author huairen
 * Created on 2019/01/28.
 */
public class CouponManageServiceModifyCouponDefinitionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 1001 立减券修改部分信息
     * 1002 立减券修改成满减券
     * 1003 立减券修改成折扣券
     * 1004 满减券修改信息
     * 1005 满减券修改名称
     * 1006 满减券修改内部名称
     * 1007 满减券修改有效期
     * 1008 满减券修改product
     * 1009 满减券修改最大折扣金额
     */
    @AutoTest(file = "promotion/couponManageServiceModifyCouponDefinitionTestSuccess.csv")
    @DisplayName("修改券--成功用例")
    public void couponManageServiceModifyCouponDefinitionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyCouponDefinitionOrder order,
            // 准备券
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        String key = "xyb-promotion:couponDefinitionId_" + couponDefinitionDO.getDefinitionId();
        redisTemplate.opsForValue().set(key, JSONObject.toJSONString(couponDefinitionDO));
        // 测试过程
        if (CouponType.INSTANT.equals(order.getCouponType())) {
            order.setAmountData(new Money(order.getAmountData().toString()));
        }
        if (CouponType.OVER.equals(order.getCouponType())) {
            CouponType.OverCouponAmountData overCouponAmountData = new CouponType.OverCouponAmountData();
            overCouponAmountData.add(new Money(10), new Money(1000000), new Money(order.getAmountData().toString()));
            order.setAmountData(overCouponAmountData);
        }
        if (CouponType.DISCOUNT.equals(order.getCouponType())) {
            order.setAmountData(Double.parseDouble(order.getAmountData().toString()));
        }
        print(order);
        // 调用接口
        PromotionResult result = couponManageService.modifyCouponDefinition(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证

        CouponDefinitionDO couponDefiDO = promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId()).get(0);
        if (testId <= 1004) {
            assertEquals(order.getDefinitionId(), couponDefiDO.getDefinitionId());
            assertEquals(order.getCouponType() + "", couponDefiDO.getCouponType());
            assertEquals(order.getName(), couponDefiDO.getName());
            assertEquals(order.getInnerName(), couponDefiDO.getInnerName());
            assertEquals(order.getQuantity(), couponDefiDO.getQuantity());
            assertEquals(order.getOverlay(), couponDefiDO.getOverlay());
            assertEquals(order.getProduct(), couponDefiDO.getProduct());
            assertEquals(order.getMaxDiscountAmount().getCent(), couponDefiDO.getMaxDiscountAmount());
            assertEquals(order.getExpireNotifyDays(), couponDefiDO.getExpireNotifyDays());
            assertEquals(order.getPartnerId(), couponDefiDO.getPartnerId());
            assertEquals(order.getPlatPartnerId(), couponDefiDO.getPlatPartnerId());
            assertEquals(order.getMemo(), couponDefiDO.getMemo());
        }
        JSONObject jsonObject = JSONObject.parseObject(couponDefiDO.getDefinitionJson());
        if (testId == 1001 || testId == 1004) {
            if (testId == 1001) {
                assertEquals(order.getAmountData() + "", jsonObject.getJSONObject("amount").getString("amountData"));
            }
            if (testId == 1004) {
                assertEquals(new Money(1000000).getCent() + "", jsonObject.getJSONObject("amount").getJSONObject("amountData").getJSONArray("items").getJSONObject(0).getJSONObject("max").getString("cent"));
                assertEquals(new Money(10).getCent() + "", jsonObject.getJSONObject("amount").getJSONObject("amountData").getJSONArray("items").getJSONObject(0).getJSONObject("min").getString("cent"));
                assertEquals(((CouponType.OverCouponAmountData) order.getAmountData()).getItems().get(0).getValue().getCent() + "", jsonObject.getJSONObject("amount").getJSONObject("amountData").getJSONArray("items").getJSONObject(0).getJSONObject("value").getString("cent"));
            }
            assertEquals(order.getCouponType() + "", jsonObject.getString("couponType"));
            assertEquals(order.getDefinitionId() + "", jsonObject.getString("definitionId"));
            assertEquals("CREATED", jsonObject.getString("definitionStatus"));
            assertEquals(order.getInnerName(), jsonObject.getString("innerName"));
            assertEquals(order.getMaxDiscountAmount().getCent() + "", jsonObject.getString("maxDiscountAmount"));
            assertEquals(order.getMemo(), jsonObject.getString("memo"));
            assertEquals(order.getName(), jsonObject.getString("name"));
            assertEquals(order.getOverlay(), Boolean.valueOf(jsonObject.getString("overlay")));
            assertEquals(order.getPlatPartnerId(), jsonObject.getString("platPartnerId"));
            assertEquals(order.getPartnerId(), jsonObject.getString("partnerId"));
            assertEquals(order.getProduct(), jsonObject.getString("product"));
            assertEquals(order.getApplyInterval() + "", jsonObject.getJSONObject("restriction").getJSONObject("expiration").getString("applyInterval"));
            assertEquals(order.getExpirationType() + "", jsonObject.getJSONObject("restriction").getJSONObject("expiration").getString("expirationType"));
            assertEquals(order.getExpiredInterval() + "", jsonObject.getJSONObject("restriction").getJSONObject("expiration").getString("expiredInterval"));
            assertEquals(order.getIntervalUnit() + "", jsonObject.getJSONObject("restriction").getJSONObject("expiration").getString("intervalUnit"));
            assertEquals(order.getRestrictQuantityPerUser() + "", jsonObject.getJSONObject("restriction").getString("restrictQuantityPerUser"));
        }
        JSONObject json = JSONObject.parseObject(couponDefinitionDO.getDefinitionJson());
        if (testId >= 1005) {
            couponDefinitionDO.setModifyTime(couponDefiDO.getModifyTime());
            json.put("modifyTime", couponDefiDO.getRawUpdateTime().getTime());
            json.put("createTime", couponDefiDO.getRawAddTime().getTime());
            couponDefinitionDO.setDefinitionJson(couponDefiDO.getDefinitionJson());
        }
        if (testId == 1005) {
            assertEquals(order.getName(), couponDefiDO.getName());
            couponDefinitionDO.setName(couponDefiDO.getName());
            json.put("name", order.getName());
            assertEquals(json, jsonObject);
            promotionTestBase.assertCouponDefinition(couponDefinitionDO, couponDefiDO);
        }
        if (testId == 1006) {
            assertEquals(order.getInnerName(), couponDefiDO.getInnerName());
            couponDefinitionDO.setInnerName(couponDefiDO.getInnerName());
            json.put("innerName", order.getInnerName());
            assertEquals(json, jsonObject);
            promotionTestBase.assertCouponDefinition(couponDefinitionDO, couponDefiDO);
        }
        if (testId == 1007) {
            JSONObject js = json.getJSONObject("restriction").getJSONObject("expiration");
            js.put("validStartTime", order.getValidStartTime().getTime());
            js.put("validEndTime", order.getValidEndTime().getTime());
            JSONObject js1 = json.getJSONObject("restriction");
            js1.put("expiration", js);
            json.put("restriction", js1);
            assertEquals(json, jsonObject);
            promotionTestBase.assertCouponDefinition(couponDefinitionDO, couponDefiDO);
        }
        if (testId == 1008) {
            assertEquals(order.getProduct(), couponDefiDO.getProduct());
            couponDefinitionDO.setProduct(couponDefiDO.getProduct());
            json.put("product", order.getProduct());
            assertEquals(json, jsonObject);
            promotionTestBase.assertCouponDefinition(couponDefinitionDO, couponDefiDO);
        }
        if (testId == 1009) {
            assertEquals(order.getMaxDiscountAmount().getCent(), couponDefiDO.getMaxDiscountAmount());
            couponDefinitionDO.setMaxDiscountAmount(couponDefiDO.getMaxDiscountAmount());
            // json.put("maxDiscountAmount", order.getMaxDiscountAmount().getCent());
            // assertEquals(json, jsonObject);
            promotionTestBase.assertCouponDefinition(couponDefinitionDO, couponDefiDO);
        }
        CouponDefinitionDO couponDeDO = promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId()).get(0);
        assertEquals(couponDefinitionDO1, couponDeDO);
        //redis验证
        String store = redisTemplate.opsForValue().get(key);
        assertTrue(StringUtils.isBlank(store));
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
    }
}
