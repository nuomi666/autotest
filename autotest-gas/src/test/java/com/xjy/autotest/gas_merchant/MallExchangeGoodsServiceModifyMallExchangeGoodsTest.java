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
import com.xyb.gas.merchant.api.facade.MallExchangeGoodsService;
import com.xyb.gas.merchant.api.order.ModifyMallExchangeGoodsOrder;
import com.xyb.promotion.api.coupon.enums.CouponExpirationType;
import com.xyb.promotion.api.coupon.enums.CouponType;
import dal.model.gas_merchant.GasMallExchangeGoodsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/12/04.
 */
public class MallExchangeGoodsServiceModifyMallExchangeGoodsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MallExchangeGoodsService mallExchangeGoodsService;

    @Reference(version = DUBBO_VERSION_1)
    CouponManageService couponManage;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    Gas_marketpcTestBase marketpcTestBase;

    /**
     * 根据商品ID、商品类型来修改的
     * 1001.只传必填项，修改实物
     * 1002.只传必填项，修改优惠券
     * 1003.传入所有项，修改实物
     * 1004.传入所有项，修改优惠券
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceModifyMallExchangeGoodsTestSuccess.csv")
    @DisplayName("修改积分商城商品--成功用例")
    public void mallExchangeGoodsServiceModifyMallExchangeGoodsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //积分商城信息
            String goodsId,
            String platPartnerId, ExchangeType goodsType,
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            //修改信息
            String stationxx,
            ModifyMallExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(platPartnerId);
        // 准备数据
        Date validStartTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        Date forSaleTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 1, 0, 0, 0);
        Date invalidTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 10, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        //优惠券
        String couponId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTime, validEndTime);
        if (testId == 1001 || testId == 1003) {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, order.getGoodsId(), order.getPlatPartnerId(),
                    order.getPlatPartnerId(), ExchangeType.ENTITY.code(), goodsName,
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                    exchangedCount, null, null);
        } else {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, couponId, order.getPlatPartnerId(),
                    order.getPlatPartnerId(), ExchangeType.COUPON.code(), "测试券",
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, null,
                    exchangedCount, null, null);
        }
        //干扰数据
        gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId, platPartnerId, goodsType.code(),
                goodsName,
                goodsDec, goodsImg, forSaleTime,
                invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                exchangedCount, null, null);
        // 测试过程
        List<String> gainStationsxx = new ArrayList<String>();
        gainStationsxx.add(stationxx);
        if (testId != 1002) {
            order.setGainStations(gainStationsxx);
        }
        if (testId == 1002 || testId == 1004) {
            order.setGoodsId(couponId);
        }
        order.setForSaleTime(forSaleTimexx);
        order.setInvalidTime(invalidTimexx);
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.modifyMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {//不传则不更新
            mallExchangeGoodsAssert(order.getGoodsId(), order.getPlatPartnerId(), order.getGoodsType().code(),
                    order.getGoodsName(),
                    gainStyle, order.getGoodsImg(), goodsDec, JSON.toJSONString(gainStationsxx),
                    order.getOneExchangeTimes(), order.getStoreNum(), order.getExchangePoint(), exchangedCount,
                    freezeStoreNum, order.getForSaleTime(), order.getInvalidTime());
        }
        if (testId == 1002) {//不传则不更新
            mallExchangeGoodsAssert(order.getGoodsId(), order.getPlatPartnerId(), order.getGoodsType().code(),
                    "测试券", gainStyle, goodsImg, goodsDec, null,
                    order.getOneExchangeTimes(), order.getStoreNum(), order.getExchangePoint(), exchangedCount,
                    freezeStoreNum, order.getForSaleTime(), order.getInvalidTime());
        }
        if (testId == 1003) {
            mallExchangeGoodsAssert(order.getGoodsId(), order.getPlatPartnerId(), order.getGoodsType().code(),
                    order.getGoodsName(),
                    gainStyle, order.getGoodsImg(), order.getGoodsDescription(), JSON.toJSONString(gainStationsxx),
                    order.getOneExchangeTimes(), order.getStoreNum(), order.getExchangePoint(), exchangedCount,
                    freezeStoreNum, order.getForSaleTime(), order.getInvalidTime());
        }
        if (testId == 1004) {//优惠券不会更新名称、图片、提取油站
            mallExchangeGoodsAssert(order.getGoodsId(), order.getPlatPartnerId(), order.getGoodsType().code(),
                    "测试券", gainStyle, goodsImg, order.getGoodsDescription(), null,
                    order.getOneExchangeTimes(), order.getStoreNum(), order.getExchangePoint(), exchangedCount,
                    freezeStoreNum, order.getForSaleTime(), order.getInvalidTime());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(platPartnerId);
        marketpcTestBase.cleanCouponByCouponName("测试券");
        promotionTestBase.cleanCouponDefinitionByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001.商户ID为空
     * 1002.商品ID为空
     * 1003.商品类型为空
     * 1004.为实物时，商品名称为空
     * 1005.为实物时，商图片称为空
     * 1006.上架时间为空
     * 1007.下架时间为空
     * 1008.兑换积分为0
     * 1009.每人兑换次数为0
     * 1010.库存数据为0
     * 1011.为实物时，提取油站为空
     * 1012.gid为空
     * 1013.order为空
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceModifyMallExchangeGoodsTestFailOne.csv")
    @DisplayName("修改积分商城商品--参数非法")
    public void mallExchangeGoodsServiceModifyMallExchangeGoodsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数

            //修改信息
            String stationxx,
            ModifyMallExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        Date forSaleTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 1, 0, 0, 0);
        Date invalidTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 10, 0, 0, 0);
        // 测试过程
        List<String> gainStationsxx = new ArrayList<String>();
        gainStationsxx.add(stationxx);
        if (testId != 1011) {
            order.setGainStations(gainStationsxx);
        }
        order.setForSaleTime(forSaleTimexx);
        order.setInvalidTime(invalidTimexx);
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setGoodsId(null);
        }
        if (testId == 1003) {
            order.setGoodsType(null);
        }
        if (testId == 1004) {
            order.setGoodsName(null);
        }
        if (testId == 1005) {
            order.setGoodsImg(null);
        }
        if (testId == 1006) {
            order.setForSaleTime(null);
        }
        if (testId == 1007) {
            order.setInvalidTime(null);
        }
        if (testId == 1008) {
            order.setExchangePoint(0);
        }
        if (testId == 1009) {
            order.setOneExchangeTimes(0);
        }
        if (testId == 1010) {
            order.setStoreNum(0);
        }
        if (testId == 1012) {
            order.setGid(null);
        }
        if (testId == 1013) {
            order = null;
        }
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.modifyMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商品不存在
     * 1002.商品为优惠券,下架时间在有效期外
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceModifyMallExchangeGoodsTestFailTwo.csv")
    @DisplayName("修改积分商城商品--失败用例")
    public void mallExchangeGoodsServiceModifyMallExchangeGoodsTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //积分商城信息
            String goodsId,
            String platPartnerId, ExchangeType goodsType,
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            //修改信息
            String stationxx,
            ModifyMallExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(platPartnerId);
        // 准备数据
        Date validStartTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        Date forSaleTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 1, 0, 0, 0);
        Date invalidTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 10, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        //优惠券
        String couponId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTime, validEndTime);
        gasMerchantTestBase.insertGasMallExchangeGoods(0L, couponId, order.getPlatPartnerId(),
                order.getPlatPartnerId(), ExchangeType.COUPON.code(), "测试券",
                goodsDec, goodsImg, forSaleTime,
                invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, null,
                exchangedCount, null, null);
        //干扰数据
        gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId, platPartnerId, goodsType.code(),
                goodsName,
                goodsDec, goodsImg, forSaleTime,
                invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                exchangedCount, null, null);
        // 测试过程
        if (testId == 1002 || testId == 1003) {
            order.setGoodsId(couponId);
        }
        order.setForSaleTime(forSaleTimexx);
        order.setInvalidTime(invalidTimexx);
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.modifyMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        mallExchangeGoodsAssert(couponId, order.getPlatPartnerId(), order.getGoodsType().code(),
                "测试券", gainStyle, goodsImg, goodsDec, null,
                oneExchangeTimes, storeNum, exchangePoint, exchangedCount,
                freezeStoreNum, forSaleTime, invalidTime);
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(platPartnerId);
        marketpcTestBase.cleanCouponByCouponName("测试券");
        promotionTestBase.cleanCouponDefinitionByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 积分商城表
     */
    private void mallExchangeGoodsAssert(
            String goodsId,
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
            int exchangedCount,
            int freezeStoreNum,
            Date forSaleTime,
            Date invalidTime
    ) {
        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS =
                gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(goodsId);
        assertTrue(mallExchangeGoodsDOS.size() == 1);
        for (GasMallExchangeGoodsDO mallExchangeGoodsDO : mallExchangeGoodsDOS) {
            assertEquals(exchangePoint, mallExchangeGoodsDO.getExchangePoint().intValue());
            assertEquals(exchangedCount, mallExchangeGoodsDO.getExchangedCount().intValue());
            assertEquals(freezeStoreNum, mallExchangeGoodsDO.getFreezeStoreNum().intValue());
            assertEquals(oneExchangeTimes, mallExchangeGoodsDO.getOneExchangeTimes().intValue());
            assertEquals(storeNum, mallExchangeGoodsDO.getStoreNum().intValue());
            assertEquals(gainStyle, mallExchangeGoodsDO.getGainStyle());
            assertEquals(goodsName, mallExchangeGoodsDO.getGoodsName());
            assertEquals(stationsJson, mallExchangeGoodsDO.getGainStation());
            assertEquals(goodsId, mallExchangeGoodsDO.getGoodsId());
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
}
