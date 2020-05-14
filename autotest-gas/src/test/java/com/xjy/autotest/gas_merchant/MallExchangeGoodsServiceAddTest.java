package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.marketpc.api.common.TimeSlot;
import com.xyb.gas.marketpc.api.common.enums.CouponBizType;
import com.xyb.gas.marketpc.api.common.enums.UseTimeUnit;
import com.xyb.gas.marketpc.api.manage.CouponManageService;
import com.xyb.gas.marketpc.api.manage.order.AddCouponDefinitionOrder;
import com.xyb.gas.merchant.api.enums.ExchangeType;
import com.xyb.gas.merchant.api.enums.GainStyle;
import com.xyb.gas.merchant.api.facade.MallExchangeGoodsService;
import com.xyb.gas.merchant.api.order.AddMallExchangeGoodsOrder;
import com.xyb.promotion.api.coupon.enums.CouponExpirationType;
import com.xyb.promotion.api.coupon.enums.CouponType;
import dal.model.gas_merchant.GasMallExchangeGoodsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/29.
 */
public class MallExchangeGoodsServiceAddTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    CouponManageService couponManage;

    @Reference(version = DUBBO_VERSION_1)
    MallExchangeGoodsService mallExchangeGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    Gas_marketpcTestBase marketpcTestBase;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 商城商品分为实物和优惠券，当商品为实物时，提取方式为自提，商品为券时，则是自动发放。
     * 当添加的商品为优惠券时，积分商城商品表里的物品ID为填写的物品ID，为实物时，积分商城商品表里的物品ID自动生成。
     * 当设置积分商品中包含有时间区间类型的优惠券作为商品时，上下架时间必须在有效期内
     * 1001.添加实物商品，提取油站为1个，不传商品ID
     * 1002.添加实物商品，提取油站多个，传入商品ID
     * 1003.添加优惠券商品上架时间在优惠券生效时间之前，不传油站ID，传入商品名称
     * 1004.添加优惠券，上下架时间在优惠券生效期间内，传入油站ID
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceAddTestSuccess.csv")
    @DisplayName("新增积分商城商品--成功用例")
    public void mallExchangeGoodsServiceAddTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddMallExchangeGoodsOrder order,
            String station,
            String station1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        Date validStartTime = afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date invalidTime = afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 10);
        Date invalidTime1 = afterDay(DateUtils.getSqlDate(), 0, 20, 0, 0, 20);
        String goodsId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTime, validEndTime);
        // 测试过程
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        if (testId == 1002) {
            gainStations.add(station1);
        }
        if (testId >= 1002) {
            order.setGoodsId(goodsId);
        }
        order.setForSaleTime(DateUtils.getSqlDate());
        if (testId == 1003) {
            order.setInvalidTime(invalidTime);
        } else {
            order.setInvalidTime(invalidTime1);
        }
        if (testId != 1003) {
            order.setGainStations(gainStations);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.addMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId <= 1002) {
            mallExchangeGoodsAssert(order.getPlatPartnerId(), ExchangeType.ENTITY.code(), order.getGoodsName(),
                    GainStyle.SELF.code(), order.getGoodsImg(), order.getGoodsDescription(),
                    JSON.toJSONString(order.getGainStations()),
                    order.getOneExchangeTimes(), order.getStoreNum(), order.getExchangePoint(), order.getForSaleTime(),
                    invalidTime1);
        }
        if (testId == 1003) {
            mallExchangeGoodsAssert(order.getPlatPartnerId(), ExchangeType.COUPON.code(), order.getGoodsName(),
                    GainStyle.AUTO.code(), order.getGoodsImg(), order.getGoodsDescription(), null,
                    order.getOneExchangeTimes(), order.getStoreNum(), order.getExchangePoint(), order.getForSaleTime(),
                    invalidTime);
        }
        if (testId == 1004) {
            mallExchangeGoodsAssert(order.getPlatPartnerId(), ExchangeType.COUPON.code(), order.getGoodsName(),
                    GainStyle.AUTO.code(), order.getGoodsImg(), order.getGoodsDescription(), null,
                    order.getOneExchangeTimes(), order.getStoreNum(), order.getExchangePoint(), order.getForSaleTime(),
                    invalidTime1);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        marketpcTestBase.cleanCouponByCouponName("测试券");
        promotionTestBase.cleanCouponDefinitionByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001.商户ID为空
     * 1002.商品类型为空
     * 1003.商品名称为空
     * 1004.提取方式为空
     * 1005.下架时间为空
     * 1006.上架时间为空
     * 1007.兑换积分为0
     * 1008.每人限兑次数为0
     * 1009.库存为0
     * 1010.商品为优惠券时，商品ID为空
     * 1011.商品为实物时，图片为空
     * 1012.商品为实物时，提取油站为空
     * 1013.gid为空
     * 1014.order为空
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceAddTestFailOne.csv")
    @DisplayName("新增积分商城商品--参数非法")
    public void mallExchangeGoodsServiceAddTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddMallExchangeGoodsOrder order,
            String station
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        Date validStartTime = afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        String goodsId = null;
        if (testId != 1014) {
            goodsId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTime, validEndTime);
        }
        // 测试过程
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        order.setGoodsId(goodsId);
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGoodsType(null);
        }
        if (testId == 1003) {
            order.setGoodsName(null);
        }
        if (testId == 1004) {
            order.setGainStyle(null);
        }
        if (testId == 1005) {
            order.setInvalidTime(null);
        }
        if (testId == 1006) {
            order.setForSaleTime(null);
        }
        if (testId == 1007) {
            order.setExchangePoint(0);
        }
        if (testId == 1008) {
            order.setOneExchangeTimes(0);
        }
        if (testId == 1009) {
            order.setStoreNum(0);
        }
        if (testId == 1010) {
            order.setGoodsId(null);
        }
        if (testId == 1011) {
            order.setGoodsImg(null);
        }
        if (testId == 1012) {
            order.setGainStations(null);
        }
        if (testId == 1013) {
            order.setGid(null);
        }
        if (testId == 1014) {
            order = null;
        }
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.addMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        marketpcTestBase.cleanCouponByCouponName("测试券");
        if (testId != 1014) {
            promotionTestBase.cleanCouponDefinitionByPlatPartnerId(order.getPlatPartnerId());
        }
    }

    /**
     * 1001.商品已经存在（只有优惠券才会存在这种情况，实物ID是自动生成的）
     * 1002.添加优惠券商品时，下架时间晚于优惠券过期时间
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceAddTestFailTwo.csv")
    @DisplayName("新增积分商城商品--失败用例")
    public void mallExchangeGoodsServiceAddTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddMallExchangeGoodsOrder order,
            String station
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        Date validStartTime = afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date invalidTime = afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 10);
        Date invalidTime1 = afterDay(DateUtils.getSqlDate(), 2, 0, 0, 0, 20);
        String goodsId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTime, validEndTime);
        // 测试过程
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        if (testId == 1001) {
            gasMerchantInitDataBase.initMallExchangeGoodsSimple(order.getPlatPartnerId(), goodsId, order.getGoodsName(),
                    ExchangeType.COUPON.code(), "sss", GainStyle.AUTO.code(), JSON.toJSONString(gainStations));
        }
        order.setGoodsId(goodsId);
        order.setForSaleTime(DateUtils.getSqlDate());
        if (testId == 1002) {
            order.setInvalidTime(invalidTime1);
        } else {
            order.setInvalidTime(invalidTime);
        }
        order.setGainStations(gainStations);
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.addMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS =
                gasMerchantTestBase.findGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        assertEquals(0, mallExchangeGoodsDOS.size());
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        marketpcTestBase.cleanCouponByCouponName("测试券");
        promotionTestBase.cleanCouponDefinitionByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 积分商城表
     */
    private void mallExchangeGoodsAssert(
            String platPartnerId,
            String goodsType,
            String goodsName,
            String gainStyle,
            String goodsImg,
            String goodsDescription,
            String stationsJson,
            int oneExchangeTimes,
            int storeNum,
            int exchangePoint,
            Date forSaleTime,
            Date invalidTime
    ) {
        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS =
                gasMerchantTestBase.findGasMallExchangeGoodsByPlatPartnerId(platPartnerId);
        assertTrue(mallExchangeGoodsDOS.size() > 0);
        for (GasMallExchangeGoodsDO mallExchangeGoodsDO : mallExchangeGoodsDOS) {
            assertEquals(exchangePoint, mallExchangeGoodsDO.getExchangePoint().intValue());
            assertEquals(0, mallExchangeGoodsDO.getExchangedCount().intValue());
            assertEquals(0, mallExchangeGoodsDO.getFreezeStoreNum().intValue());
            assertEquals(oneExchangeTimes, mallExchangeGoodsDO.getOneExchangeTimes().intValue());
            assertEquals(storeNum, mallExchangeGoodsDO.getStoreNum().intValue());
            assertEquals(gainStyle, mallExchangeGoodsDO.getGainStyle());
            assertEquals(goodsName, mallExchangeGoodsDO.getGoodsName());
            assertEquals(stationsJson, mallExchangeGoodsDO.getGainStation());
//            assertEquals(order.getGoodsId(), mallExchangeGoodsDO.getGoodsId());
            assertEquals(goodsImg, mallExchangeGoodsDO.getGoodsImg());
            assertEquals(goodsDescription, mallExchangeGoodsDO.getGoodsDescription());
            assertEquals(goodsType, mallExchangeGoodsDO.getGoodsType());
            assertEquals(DateUtils.formatDate(forSaleTime), DateUtils.formatDate(mallExchangeGoodsDO.getForSaleTime()));
            assertEquals(DateUtils.formatDate(invalidTime), DateUtils.formatDate(mallExchangeGoodsDO.getInvalidTime()));
            assertEquals(platPartnerId, mallExchangeGoodsDO.getPartnerId());
        }
    }

    /**
     * 创建优惠券
     *
     * @param couponName
     * @param validStartTime
     * @param validEndTime
     * @return
     */
    private String addCoupon(
            String platPartnerId,
            String couponName,
            String station,
            Date validStartTime,
            Date validEndTime
    ) {
        marketpcTestBase.cleanCouponByCouponName(couponName);
        promotionTestBase.cleanCouponDefinitionByPlatPartnerId(platPartnerId);
        List<TimeSlot> timeSlots = Lists.newArrayList();
        TimeSlot slot = new TimeSlot();
        slot.setStartTime("00:00");
        slot.setEndTime("23:59");
        timeSlots.add(slot);
        Set<String> goodsCodes = Sets.newHashSet();
        goodsCodes.add("92#");
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(station);
        AddCouponDefinitionOrder order = new AddCouponDefinitionOrder();
        order.setPlatPartnerId(platPartnerId);
        order.setPartnerId(platPartnerId);
        order.setCouponType(CouponType.INSTANT);
        order.setName(couponName);
        order.setInnerName(couponName);
        order.setOverlay(true);
        order.setCreateTime(DateUtils.getSqlDate());
        order.setExpirationType(CouponExpirationType.SECTION);
        order.setValidStartTime(validStartTime);
        order.setValidEndTime(validEndTime);
        order.setCouponBizType(CouponBizType.GAS_COUPON);
        order.setUseTimeUnit(UseTimeUnit.DAILY);
        order.setThresholdAmount(new Money(50, 0));
        order.setGoodsCodes(goodsCodes);
        order.setStationIds(stationIds);
        order.setTimeSlots(timeSlots);
        order.setAmountData(new Money(5, 0));
        order.setGid(GID.newGID());
        SimpleResult coupon = couponManage.add(order);
        print(coupon);
        String couponId = marketpcTestBase.findCouponByCouponName(couponName).get(0).getDefinitionId();
        return couponId;
    }

    /**
     * 获取段时间后的时间点
     *
     * @param month
     * @param day
     * @param hour
     * @param min
     * @param second
     * @return
     */
    private static Date afterDay(Date date, int month, int day, int hour, int min, int second) {
        try {
//            Date nowDate = new Date();
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            cd.add(Calendar.DATE, day);
            cd.add(Calendar.MONTH, month);
            cd.add(Calendar.HOUR, hour);
            cd.add(Calendar.MILLISECOND, min);
            cd.add(Calendar.SECOND, second);
            return cd.getTime();
        } catch (Exception e) {
            return null;
        }
    }
}
