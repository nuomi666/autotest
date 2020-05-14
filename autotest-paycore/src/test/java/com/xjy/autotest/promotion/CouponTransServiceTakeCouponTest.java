package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.RedisUtil;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.CouponTransService;
import com.xyb.promotion.api.coupon.params.TakeCouponOrder;
import com.xyb.promotion.api.coupon.params.TakeCouponResult;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDefinitionDO;
import dal.model.promotion.InstructionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ychaoyang
 * Created on 2018/10/24.
 */
@DisplayName("领取优惠券")
public class CouponTransServiceTakeCouponTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponTransService couponTransService;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 1001 领取1张满减券
     * 1002 领取1张直减券
     * 1003 领取1张折扣券
     * 1004 领取2张满减券
     * 1005 领取2张直减券
     * 1006 领取2张折扣券
     * 1007 领取1张满减券、1张直减券、1张折扣券
     */
    @AutoTest(file = "promotion/couponTransServiceTakeCouponTestSuccess.csv")
    @DisplayName("领取优惠券--成功用例")
    public void couponTransServiceTakeCouponTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            TakeCouponOrder order,
            // 准备数据
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        String key = "xyb-promotion:couponDefinitionId_" + couponDefinitionDO.getDefinitionId();
        String key1 = "xyb-promotion:couponDefinitionId_" + couponDefinitionDO1.getDefinitionId();
        String key2 = "xyb-promotion:couponDefinitionId_" + couponDefinitionDO2.getDefinitionId();
        if (testId == 1001) {
            redisTemplate.delete(key);
            redisTemplate.delete(key1);
            redisTemplate.delete(key2);
        }
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getInnerName());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getInnerName());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getInnerName());
        promotionTestBase.cleanCouponByUserId(order.getUserId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponByDefinitionId(couponDefinitionDO2.getDefinitionId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("platMerchNo" + System.currentTimeMillis());
        Map<String, Integer> takeItems = new HashMap<>();
        if (testId == 1001) {
            takeItems.put(couponDefinitionDO.getDefinitionId(), 1);
        }
        if (testId == 1002) {
            takeItems.put(couponDefinitionDO1.getDefinitionId(), 1);
        }
        if (testId == 1003) {
            takeItems.put(couponDefinitionDO2.getDefinitionId(), 1);
        }
        if (testId == 1004) {
            takeItems.put(couponDefinitionDO.getDefinitionId(), 2);
        }
        if (testId == 1005) {
            takeItems.put(couponDefinitionDO1.getDefinitionId(), 2);
        }
        if (testId == 1006) {
            takeItems.put(couponDefinitionDO2.getDefinitionId(), 2);
        }
        if (testId == 1007) {
            takeItems.put(couponDefinitionDO.getDefinitionId(), 1);
            takeItems.put(couponDefinitionDO1.getDefinitionId(), 1);
            takeItems.put(couponDefinitionDO2.getDefinitionId(), 1);
        }
        order.setTakeItems(takeItems);
        // 调用接口
        TakeCouponResult result = couponTransService.takeCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertCoupon(order, couponDefinitionDO);
        }
        if (testId == 1002) {
            assertCoupon(order, couponDefinitionDO1);
        }
        if (testId == 1003) {
            assertCoupon(order, couponDefinitionDO2);
        }
        if (testId == 1004) {
            assertCoupons(order, couponDefinitionDO);
        }
        if (testId == 1005) {
            assertCoupons(order, couponDefinitionDO1);
        }
        if (testId == 1006) {
            assertCoupons(order, couponDefinitionDO2);
        }
        if (testId == 1007) {
            assertCoupon(order, couponDefinitionDO);
            assertCoupon(order, couponDefinitionDO1);
            assertCoupon(order, couponDefinitionDO2);
        }
        //instruction表
        InstructionDO instructionDO = promotionTestBase.findInstructionByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
        assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        assertEquals(order.getGid(), instructionDO.getGid());
        assertEquals(order.getReqId(), instructionDO.getReqId());
        assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        assertEquals("SUCCESS", instructionDO.getStatus());

        assertEquals(couponDefinitionDO, promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId()).get(0));
        assertEquals(couponDefinitionDO1, promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId()).get(0));
        assertEquals(couponDefinitionDO2, promotionTestBase.findCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId()).get(0));

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
        if (testId == 1007) {
            assertTrue(store.contains(couponDefinitionDO.getInnerName()));
            assertTrue(store1.contains(couponDefinitionDO1.getInnerName()));
            assertTrue(store2.contains(couponDefinitionDO2.getInnerName()));
        }
        if (testId >= 1006) {
            redisTemplate.delete(key);
            redisTemplate.delete(key1);
            redisTemplate.delete(key2);
        }
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponByUserId(order.getUserId());
        promotionTestBase.cleanInstructionByMerchantOrderNo(order.getMerchantOrderNo());
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerId传空
     * 1004 merchantOrderNo传空
     * 1005 platPartnerId传空
     * 1006 platMerchantOrderNo传空
     * 1007 userId传空
     * 1008 takeItems传空
     */
    @AutoTest(file = "promotion/couponTransServiceTakeCouponTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void couponTransServiceTakeCouponTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            TakeCouponOrder order
            // 准备数据
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        TakeCouponResult result = couponTransService.takeCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据

    }

    /**
     * 1001 优惠券不存在
     * 1002 优惠券已过期
     * 1003 优惠券未到领取时间//已去掉
     * 1004 优惠券超过每人领取限制//已去掉
     * 1005 优惠券超过总数领取限制//已去掉
     */
    @AutoTest(file = "promotion/couponTransServiceTakeCouponTestFailTwo.csv")
    @DisplayName("领取优惠券--失败用例")
    public void couponTransServiceTakeCouponTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            TakeCouponOrder order,
            // 准备数据
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        //1003 去掉未到生效时间不能领取券的限制
        //1005 去掉优惠券金额领取总数限制
        if (testId >= 1003) {
            return;
        }
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getInnerName());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getInnerName());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getInnerName());
        promotionTestBase.cleanCouponByUserId(order.getUserId());
        // 准备数据
        if (testId == 1002) {
            //过期时间设为月初
            String definitionJson = couponDefinitionDO.getDefinitionJson();
            couponDefinitionDO.setDefinitionJson(definitionJson.replace("1641001599001", DateUtils.getStartDateOfMonth(new Date()).getTime() + ""));
        }
        if (testId == 1003) {
            //开始时间设为月末
            String definitionJson = couponDefinitionDO.getDefinitionJson();
            couponDefinitionDO.setDefinitionJson(definitionJson.replace("1540459383888", DateUtils.getEndDateOfMonth(new Date()).getTime() + ""));
        }
        if (testId != 1001) {
            promotionTestBase.insertCouponDefinition(couponDefinitionDO);
            //promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
            //promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        }
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("platMerchNo" + System.currentTimeMillis());
        Map<String, Integer> takeItems = new HashMap<>();
        takeItems.put(couponDefinitionDO.getDefinitionId(), 1);
        //takeItems.put(couponDefinitionDO1.getDefinitionId(), 1);
        //takeItems.put(couponDefinitionDO2.getDefinitionId(), 1);
        order.setTakeItems(takeItems);
        if (testId == 1004 || testId == 1005) {
            couponTransService.takeCoupon(order);
            order.setReqId(OID.newID());
            order.setGid(GID.newGID());
            order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
            order.setPlatMerchantOrderNo("platMerchNo" + System.currentTimeMillis());
        }
        // 调用接口
        TakeCouponResult result = couponTransService.takeCoupon(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());

    }


    /**
     * 验证Coupon表数据
     *
     * @param order
     * @param couponDefinitionDO
     */
    public void assertCoupon(TakeCouponOrder order, CouponDefinitionDO couponDefinitionDO) {
        CouponDO couponDO = promotionTestBase.findCouponByDefinitionId(couponDefinitionDO.getDefinitionId()).get(0);
        assertEquals(couponDefinitionDO.getInnerName(), couponDO.getInnerName());
        assertEquals(couponDefinitionDO.getName(), couponDO.getName());
        assertEquals(order.getPlatPartnerId(), couponDO.getPlatPartnerId());
        assertEquals(order.getPartnerId(), couponDO.getPartnerId());
        assertEquals(order.getUserId(), couponDO.getUserId());
        assertEquals("TAKEN", couponDO.getStatus());
        assertEquals(couponDefinitionDO.getCouponType(), couponDO.getCouponType());
        assertEquals(couponDefinitionDO.getProduct(), couponDO.getProduct());
        assertEquals(couponDefinitionDO.getMaxDiscountAmount(), couponDO.getMaxDiscountAmount());
        JSONObject jsonObject = JSONObject.parseObject(couponDefinitionDO.getDefinitionJson());
        assertEquals(DateUtils.changeDays(new Date(Long.valueOf(jsonObject.getJSONObject("restriction").getJSONObject("expiration").getString("validEndTime"))), 0 - couponDefinitionDO.getExpireNotifyDays())
                , couponDO.getExpireNotifyTime());
    }

    /**
     * 验证Coupon表数据
     *
     * @param order
     * @param couponDefinitionDO
     */
    public void assertCoupons(TakeCouponOrder order, CouponDefinitionDO couponDefinitionDO) {
        List<CouponDO> list = promotionTestBase.findCouponByDefinitionId(couponDefinitionDO.getDefinitionId());
        assertEquals(2, list.size());
        for (CouponDO couponDO : list) {
            assertEquals(couponDefinitionDO.getInnerName(), couponDO.getInnerName());
            assertEquals(couponDefinitionDO.getName(), couponDO.getName());
            assertEquals(order.getPlatPartnerId(), couponDO.getPlatPartnerId());
            assertEquals(order.getPartnerId(), couponDO.getPartnerId());
            assertEquals(order.getUserId(), couponDO.getUserId());
            assertEquals(couponDefinitionDO.getCouponType(), couponDO.getCouponType());
        }
    }


}
