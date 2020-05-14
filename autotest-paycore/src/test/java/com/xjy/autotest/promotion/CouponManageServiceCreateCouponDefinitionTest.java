package com.xjy.autotest.promotion;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.RedisUtil;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.promotion.api.coupon.enums.CouponDefinitionStatus;
import com.xyb.promotion.api.coupon.enums.CouponType;
import com.xyb.promotion.api.coupon.params.CreateCouponDefinitionOrder;
import com.xyb.promotion.api.coupon.params.CreateCouponDefinitionResult;
import dal.model.promotion.CouponDefinitionDO;
import dal.model.promotion.CouponDefinitionViewDO;
import dal.model.promotion.IdempotenceViewDO;
import dal.model.promotion.InstructionDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.promotion.api.coupon.params.CreateCouponDefinitionResult;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.CreateCouponDefinitionOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * @author lvdou
 * 服务名：创建优惠券
 * Created on 2018/07/18.
 */
@DisplayName("创建优惠券")
public class CouponManageServiceCreateCouponDefinitionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 1001 必填参数，优惠券类型为立减券，不叠加，固定金额，时间区间有效
     * 1002 全填参数，优惠券类型为满减券，不叠加，可变金额，固定间隔
     * 1003 全填参数，优惠券类型为折扣券，不叠加，随机金额，时间区间有效
     * 1004 全填参数，优惠券类型为立减券，叠加，可变金额，固定间隔
     * 1005 全填参数，优惠券类型为满减券，叠加，随机金额，时间区间有效
     * 1006 全填参数，优惠券类型为折扣券，叠加，固定金额，固定间隔
     * 1007 全填参数，优惠券类型为立减券，不叠加，随机金额，时间区间有效
     * 1008 全填参数，优惠券类型为满减券，不叠加，固定金额，时间区间有效
     * 1009 全填参数，优惠券类型为折扣券，不叠加，可变金额，时间区间有效
     * 1010 全填参数，优惠券类型为折扣券，不叠加，可变金额，时间区间有效,到期通知天数3天
     */
    @AutoTest(file = "promotion/couponManageServiceCreateCouponDefinitionTestSuccess.csv")
    @DisplayName("创建优惠券--成功用例")
    public void couponManageServiceCreateCouponDefinitionTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            CreateCouponDefinitionOrder createCouponDefinitionOrder,
            // 结果参数
            String code,
            String description
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByPartnerId(createCouponDefinitionOrder.getPartnerId());
        promotionTestBase.cleanInstructionByGid(createCouponDefinitionOrder.getPartnerId());
        // 准备数据
        // 测试过程
        createCouponDefinitionOrder.setValidStartTime(DateUtils.changeMinute(new Date(), 1));
        createCouponDefinitionOrder.setValidEndTime(DateUtils.getEndDateOfMonth(new Date()));
        if (CouponType.INSTANT.equals(createCouponDefinitionOrder.getCouponType())) {
            createCouponDefinitionOrder.setAmountData(new Money(createCouponDefinitionOrder.getAmountData().toString()));
        }
        if (CouponType.OVER.equals(createCouponDefinitionOrder.getCouponType())) {
            CouponType.OverCouponAmountData overCouponAmountData = new CouponType.OverCouponAmountData();
            overCouponAmountData.add(new Money(10), new Money(1000000), new Money(createCouponDefinitionOrder.getAmountData().toString()));
            createCouponDefinitionOrder.setAmountData(overCouponAmountData);
        }
        if (CouponType.DISCOUNT.equals(createCouponDefinitionOrder.getCouponType())) {
            createCouponDefinitionOrder.setAmountData(Double.parseDouble(createCouponDefinitionOrder.getAmountData().toString()));
        }
        if (testId == 1001) {
            createCouponDefinitionOrder.setQuantity(1L);
            //createCouponDefinitionOrder.setRandomMaxAmount(null);
            //createCouponDefinitionOrder.setAmountData(null);
            createCouponDefinitionOrder.setBizRule(null);
        }
        // 调用接口
        CreateCouponDefinitionResult result = couponManageService.createCouponDefinition(createCouponDefinitionOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        //assertEquals(description, result.getDescription());
        // 数据验证
        assertNotNull(result.getDefinitionId());

        // 数据库校验

        // 校验coupon_definition表数据
        CouponDefinitionDO DO = promotionTestBase.findCouponDefinitionByPartnerId(createCouponDefinitionOrder.getPartnerId()).get(0);
        assertNotNull(DO.getCreateTime());
        assertEquals(createCouponDefinitionOrder.getCouponType().name(), DO.getCouponType());
        assertNotNull(DO.getDefinitionId());
        assertNotNull(DO.getDefinitionJson());
        assertEquals(CouponDefinitionStatus.CREATED.toString(), DO.getDefinitionStatus());
        assertNotNull(DO.getId());
        assertEquals(createCouponDefinitionOrder.getInnerName(), DO.getInnerName());
        //assertNotNull(DO.getInstructionId());
        assertEquals(createCouponDefinitionOrder.getMemo(), DO.getMemo());
        //assertNotNull(DO.getModifyTime());
        assertEquals(createCouponDefinitionOrder.getOverlay(), DO.getOverlay());
        assertEquals(createCouponDefinitionOrder.getPartnerId(), DO.getPartnerId());
        assertEquals(createCouponDefinitionOrder.getPlatPartnerId(), DO.getPlatPartnerId());
        assertEquals(createCouponDefinitionOrder.getName(), DO.getName());
        assertEquals(createCouponDefinitionOrder.getProduct(), DO.getProduct());
        assertEquals(createCouponDefinitionOrder.getExpireNotifyDays(), DO.getExpireNotifyDays());
        assertEquals(createCouponDefinitionOrder.getMaxDiscountAmount().getCent(), DO.getMaxDiscountAmount());
        assertNotNull(DO.getQuantity());
        assertNotNull(DO.getRawAddTime());
        assertNotNull(DO.getRawUpdateTime());
        assertEquals(result.getDefinitionId(), DO.getDefinitionId());
        //redis验证
        String key = "xyb-promotion:couponDefinitionId_" + DO.getDefinitionId();
        String store = redisTemplate.opsForValue().get(key);
        assertTrue(StringUtils.isBlank(store));

        // 清除数据
        promotionTestBase.cleanCouponDefinitionByPartnerId(createCouponDefinitionOrder.getPartnerId());
        //promotionTestBase.cleanInstructionByGid(createCouponDefinitionOrder.getGid());
    }

    /**
     * 1001 order为空
     * 1002 couponType为空
     * 1003 name为空
     * 1004 innerName为空
     * 1005 overlay为空
     * 1006 createTime为空
     * 1007 expirationType为空
     */
    @AutoTest(file = "promotion/couponManageServiceCreateCouponDefinitionTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void couponManageServiceCreateCouponDefinitionTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            CreateCouponDefinitionOrder createCouponDefinitionOrder,
            // 结果参数
            String code,
            String description
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            createCouponDefinitionOrder = null;
        }
        // 调用接口
        CreateCouponDefinitionResult result = couponManageService.createCouponDefinition(createCouponDefinitionOrder);
        // 结果检查
        assertResult(testId, Status.FAIL, code, result);
        assertTrue(result.getMessage().contains(description));
        // 参数校验
        assertNull(result.getDefinitionId());
        // 清除数据
    }

    /**
     * 1001 重复创建订单
     * 1002 过期时间不合法
     */
    @AutoTest(file = "promotion/couponManageServiceCreateCouponDefinitionTestFailTwo.csv")
    @DisplayName("创建优惠券--失败用例")
    public void couponManageServiceCreateCouponDefinitionTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            CreateCouponDefinitionResult crResult,
            CreateCouponDefinitionOrder createCouponDefinitionOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (CouponType.INSTANT.equals(createCouponDefinitionOrder.getCouponType())) {
            createCouponDefinitionOrder.setAmountData(new Money(createCouponDefinitionOrder.getAmountData().toString()));
        }
        if (CouponType.OVER.equals(createCouponDefinitionOrder.getCouponType())) {
            CouponType.OverCouponAmountData overCouponAmountData = new CouponType.OverCouponAmountData();
            overCouponAmountData.add(new Money(10), new Money(1000000), new Money(createCouponDefinitionOrder.getAmountData().toString()));
            createCouponDefinitionOrder.setAmountData(overCouponAmountData);
        }
        if (CouponType.DISCOUNT.equals(createCouponDefinitionOrder.getCouponType())) {
            createCouponDefinitionOrder.setAmountData(Double.parseDouble(createCouponDefinitionOrder.getAmountData().toString()));
        }
        if (testId == 1001) {
            // 重复调用接口
            couponManageService.createCouponDefinition(createCouponDefinitionOrder);
        }
        // 调用接口
        CreateCouponDefinitionResult result = couponManageService.createCouponDefinition(createCouponDefinitionOrder);
        // 结果检查
        print(result);
        assertEquals(crResult.getStatus(), result.getStatus());
        assertEquals(crResult.getCode(), result.getCode());
        // 清除数据
    }


}
