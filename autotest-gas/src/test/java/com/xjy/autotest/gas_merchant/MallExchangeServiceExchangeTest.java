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
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.marketpc.api.common.TimeSlot;
import com.xyb.gas.marketpc.api.common.enums.CouponBizType;
import com.xyb.gas.marketpc.api.common.enums.UseTimeUnit;
import com.xyb.gas.marketpc.api.manage.CouponManageService;
import com.xyb.gas.marketpc.api.manage.order.AddCouponDefinitionOrder;
import com.xyb.gas.merchant.api.enums.CouponStatus;
import com.xyb.gas.merchant.api.enums.ExchangeStatus;
import com.xyb.gas.merchant.api.enums.ExchangeType;
import com.xyb.gas.merchant.api.enums.GoodsStatus;
import com.xyb.gas.merchant.api.facade.MallExchangeService;
import com.xyb.gas.merchant.api.info.MallExchangeGoodsInfo;
import com.xyb.gas.merchant.api.order.ExchangeGoodsOrder;
import com.xyb.promotion.api.coupon.enums.CouponExpirationType;
import com.xyb.promotion.api.coupon.enums.CouponType;
import dal.model.gas_marketpc.CouponDO;
import dal.model.gas_merchant.GasMallExchangeGoodsDO;
import dal.model.gas_merchant.GasMallExchangeRecordDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi@xyb.com
 * Created on 2018/10/08.
 */
public class MallExchangeServiceExchangeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MallExchangeService mallExchangeService;

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
     * 1001.兑换实物
     * 1002.兑换优惠券
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceExchangeTestSuccess.csv")
    @DisplayName("商品兑换--成功用例")
    public void mallExchangeServiceExchangeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //积分商城信息
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            ExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(order.getGoodsId());
        gasMerchantTestBase.cleanGasMallExchangeRecordByGoodsId(order.getGoodsId());
        // 准备数据
        Date validStartTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        //优惠券
        String couponId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTime, validEndTime);
        if (testId == 1001) {
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
        // 测试过程
        if (testId == 1002) {
            order.setGoodsId(couponId);
        }
        // 调用接口
        BizResult<MallExchangeGoodsInfo> result = mallExchangeService.exchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //兑换记录
        List<GasMallExchangeRecordDO> mallExchangeRecordsDOS =
                gasMerchantTestBase.findGasMallExchangeRecordByGoodsId(order.getGoodsId());
        mallExchangeRecordAssert(mallExchangeRecordsDOS.get(0), order.getGoodsId(), order.getPlatPartnerId(),
                order.getUserId(), order.getExchangeType().code(), ExchangeStatus.PROCESS.code(),
                order.getExchangeCount());
        //商品
        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS =
                gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(order.getGoodsId());
        if (testId == 1001) {
            mallExchangeGoodsAssert(mallExchangeGoodsDOS.get(0), order.getGoodsId(), order.getPlatPartnerId(),
                    order.getExchangeType().code(),
                    goodsName, gainStyle, goodsImg, goodsDec, gainStation, oneExchangeTimes,
                    storeNum - order.getExchangeCount(), exchangePoint, exchangedCount,
                    freezeStoreNum + order.getExchangeCount(), forSaleTime, invalidTime);
            goodsInfoAssert(result.getInfo(), order.getGoodsId(), order.getPlatPartnerId(),
                    order.getExchangeType().code(), goodsName, gainStyle,
                    goodsImg, goodsDec, oneExchangeTimes,
                    storeNum - order.getExchangeCount(), exchangePoint, exchangedCount, 1,
                    mallExchangeRecordsDOS.get(0).getOrderNo(), null, null,
                    null, GoodsStatus.SALE, forSaleTime, invalidTime);
        } else {
            mallExchangeGoodsAssert(mallExchangeGoodsDOS.get(0), order.getGoodsId(), order.getPlatPartnerId(),
                    order.getExchangeType().code(),
                    "测试券", gainStyle, goodsImg, goodsDec, null, oneExchangeTimes,
                    storeNum - order.getExchangeCount(), exchangePoint, exchangedCount,
                    freezeStoreNum + order.getExchangeCount(), forSaleTime, invalidTime);
            goodsInfoAssert(result.getInfo(), order.getGoodsId(), order.getPlatPartnerId(),
                    order.getExchangeType().code(), "测试券", gainStyle,
                    goodsImg, goodsDec, oneExchangeTimes,
                    storeNum - order.getExchangeCount(), exchangePoint, exchangedCount, 1,
                    mallExchangeRecordsDOS.get(0).getOrderNo(), "5.00",
                    com.xyb.gas.merchant.api.enums.CouponBizType.GAS_COUPON,
                    com.xyb.gas.merchant.api.enums.CouponType.INSTANT, GoodsStatus.SALE, forSaleTime, invalidTime);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(order.getGoodsId());
        gasMerchantTestBase.cleanGasMallExchangeRecordByGoodsId(order.getGoodsId());
        marketpcTestBase.cleanCouponByCouponName("商城测试券");
        promotionTestBase.cleanCouponDefinitionByName("商城测试券");
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceExchangeTestFailOne.csv")
    @DisplayName("商品兑换--参数非法")
    public void mallExchangeServiceExchangeTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ExchangeGoodsOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setGoodsId(null);
        }
        if (testId == 1003) {
            order.setExchangeType(null);
        }
        if (testId == 1004) {
            order.setUserId(null);
        }
        if (testId == 1005) {
            order.setExchangeCount(0);
        }
        if (testId == 1006) {
            order.setGid(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        BizResult<MallExchangeGoodsInfo> result = mallExchangeService.exchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.已售空
     * 1002.库存不足
     * 1003.超过兑换次数
     * 1004.兑换优惠券时，优惠券已删除
     * 1005.优惠券已过期
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceExchangeTestFailTwo.csv")
    @DisplayName("商品兑换--失败用例")
    public void mallExchangeServiceExchangeTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //积分商城信息
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            ExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(order.getGoodsId());
        gasMerchantTestBase.cleanGasMallExchangeRecordByGoodsId(order.getGoodsId());
        // 准备数据
        Date validStartTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, -10, -10, 0, 0);
        Date validStartTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, -10, 0, 20);
        Date validEndTimexx = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        //优惠券
        String couponId = null;
        if (testId == 1005) {//过期券
            couponId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTime, validEndTime);
        } else {
            couponId = addCoupon(order.getPlatPartnerId(), "测试券", station, validStartTimexx, validEndTimexx);
        }
        if (testId <= 1003) {
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
        if (testId == 1003) {
            gasMerchantTestBase.insertGasMallExchangeRecord(0L, order.getPlatPartnerId(), order.getPlatPartnerId(),
                    order.getUserId(),
                    order.getGoodsId(), ExchangeType.ENTITY.code(),
                    OID.newID(), order.getExchangeCount(), ExchangeStatus.SUCCESS.code(), null, null);
        }
        // 测试过程
        if (testId == 1004) {
            CouponDO CouponDO = marketpcTestBase.findCouponByCouponName("测试券").get(0);
            CouponDO.setStatus(CouponStatus.DISABLE.getCode());
            marketpcTestBase.updateCouponByCouponName("测试券", CouponDO);
        }
        if (testId >= 1004) {
            order.setGoodsId(couponId);
        }
        // 调用接口
        BizResult<MallExchangeGoodsInfo> result = mallExchangeService.exchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //兑换记录
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(order.getGoodsId());
        gasMerchantTestBase.cleanGasMallExchangeRecordByGoodsId(order.getGoodsId());
        marketpcTestBase.cleanCouponByCouponName("商城测试券");
        promotionTestBase.cleanCouponDefinitionByName("商城测试券");
    }

    /**
     * 兑换信息校验
     */
    private void goodsInfoAssert(
            MallExchangeGoodsInfo info,
            String goodsId,
            String platPartnerId,
            String goodsType,
            String goodsName,
            String gainStyle,
            String goodsImg,
            String goodsDescription,
            int oneExchangeTimes,
            int storeNum,
            int exchangePoint,
            Integer exchangedCount,
            Integer exchangedTimes,
            String exchangeOrderNo,
            String mountData,
            com.xyb.gas.merchant.api.enums.CouponBizType couponBizType,
            com.xyb.gas.merchant.api.enums.CouponType couponType,
            GoodsStatus status,
            Date forSaleTime,
            Date invalidTime
    ) {
        assertEquals(exchangeOrderNo, info.getExchangeOrderNo());
        assertEquals(goodsId, info.getGoodsId());
        assertEquals(platPartnerId, info.getPartnerId());
        assertEquals(platPartnerId, info.getPlatPartnerId());
        assertEquals(storeNum, info.getStoreNum());
        assertEquals(gainStyle, info.getGainStyle().code());
        assertEquals(goodsName, info.getGoodsName());
        assertEquals(goodsImg, info.getGoodsImg());
        assertEquals(goodsDescription, info.getGoodsDescription());
        assertEquals(goodsType, info.getGoodsType().code());
        assertEquals(exchangePoint, info.getExchangePoint());
        assertEquals(exchangedCount, info.getExchangedCount());
        assertEquals(oneExchangeTimes, info.getOneExchangeTimes());
        assertEquals(exchangedTimes, info.getExchangedTimes());//每人已兑换次数
        assertEquals(couponBizType, info.getCouponBizType());
        assertEquals(couponType, info.getCouponType());
        assertEquals(mountData, info.getAmountData() == null ? null : info.getAmountData().toString());
//        assertEquals(serverTime, info.getServerTime());
        assertEquals(status, info.getStatus());
        assertEquals(DateUtils.formatDate(forSaleTime), DateUtils.formatDate(info.getForSaleTime()));
        assertEquals(DateUtils.formatDate(invalidTime), DateUtils.formatDate(info.getInvalidTime()));
    }

    /**
     * 积分商城表
     */
    private void mallExchangeGoodsAssert(
            GasMallExchangeGoodsDO mallExchangeGoodsDO,
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

    /**
     * 兑换记录表
     */
    private void mallExchangeRecordAssert(
            GasMallExchangeRecordDO recordInfo,
            String goodsId,
            String platPartnerId,
            String userId,
            String goodsType,
            String exchangeStatus,
            int exchangedCount
    ) {
        assertEquals(platPartnerId, recordInfo.getPlatPartnerId());
        assertEquals(platPartnerId, recordInfo.getPartnerId());
        assertEquals(userId, recordInfo.getUserId());
        assertEquals(goodsId, recordInfo.getGoodsId());
        assertEquals(goodsType, recordInfo.getGoodsType());
//        assertEquals(orderNo, recordInfo.getOrderNo());
        assertEquals(exchangedCount, recordInfo.getExchangeCount());
        assertEquals(exchangeStatus, recordInfo.getExchangeStatus());
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
        promotionTestBase.cleanCouponDefinitionByName(couponName);
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
//        Map<Object, Object> param = Maps.newHashMap();
//        param.put("couponId", couponId);
//        param.put("amountData", order.getAmountData());
        return couponId;
    }
}
