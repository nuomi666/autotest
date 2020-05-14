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
import com.xyb.gas.merchant.api.enums.ExchangeStatus;
import com.xyb.gas.merchant.api.enums.ExchangeType;
import com.xyb.gas.merchant.api.facade.MallExchangeService;
import com.xyb.gas.merchant.api.order.FinishExchangeGoodsOrder;
import com.xyb.promotion.api.coupon.enums.CouponExpirationType;
import com.xyb.promotion.api.coupon.enums.CouponType;
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
public class MallExchangeServiceFinishExchangeTest extends SpringBootTestBase {

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
     * 1001
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceFinishExchangeTestSuccess.csv")
    @DisplayName("商品完成兑换--成功用例")
    public void mallExchangeServiceFinishExchangeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //积分商城信息
            String platPartnerId, String goodsId,
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            Integer exchangCount, String userId,
            ExchangeType exchangeType,
            FinishExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        gasMerchantTestBase.cleanGasMallExchangeRecordByOrderNo(order.getExchangeOrderNo());
        // 准备数据
        Date validStartTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        //优惠券
        String couponId = addCoupon(platPartnerId, "测试券", station, validStartTime, validEndTime);
        if (testId == 1001) {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId,
                    platPartnerId, exchangeType.code(), goodsName,
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                    exchangedCount, null, null);
            gasMerchantTestBase.insertGasMallExchangeRecord(0L, platPartnerId, platPartnerId,
                    userId, goodsId, exchangeType.code(),
                    order.getExchangeOrderNo(), exchangCount, ExchangeStatus.PROCESS.code(), null, null);
        } else {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, couponId, platPartnerId,
                    platPartnerId, exchangeType.code(), "测试券",
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, null,
                    exchangedCount, null, null);
            gasMerchantTestBase.insertGasMallExchangeRecord(0L, platPartnerId, platPartnerId,
                    userId, couponId, exchangeType.code(),
                    order.getExchangeOrderNo(), exchangCount, ExchangeStatus.PROCESS.code(), null, null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = mallExchangeService.finishExchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //兑换记录
        List<GasMallExchangeRecordDO> mallExchangeRecordsDOS =
                gasMerchantTestBase.findGasMallExchangeRecordByOrderNo(order.getExchangeOrderNo());
        //商品
        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS =
                gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(goodsId);
        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS1 =
                gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(couponId);
        if (testId == 1001) {
            mallExchangeGoodsAssert(mallExchangeGoodsDOS.get(0), goodsId, platPartnerId,
                    ExchangeType.ENTITY.code(),
                    goodsName, gainStyle, goodsImg, goodsDec, gainStation, oneExchangeTimes,
                    storeNum, exchangePoint, exchangedCount + exchangCount,
                    freezeStoreNum - exchangCount, forSaleTime, invalidTime);
        } else if (testId == 1003) {
            mallExchangeGoodsAssert(mallExchangeGoodsDOS1.get(0), couponId, platPartnerId,
                    ExchangeType.COUPON.code(),
                    "测试券", gainStyle, goodsImg, goodsDec, null, oneExchangeTimes,
                    storeNum + exchangCount, exchangePoint, exchangedCount,
                    freezeStoreNum - exchangCount, forSaleTime, invalidTime);
        } else {
            mallExchangeGoodsAssert(mallExchangeGoodsDOS1.get(0), couponId, platPartnerId,
                    ExchangeType.COUPON.code(),
                    "测试券", gainStyle, goodsImg, goodsDec, null, oneExchangeTimes,
                    storeNum, exchangePoint, exchangedCount + exchangCount,
                    freezeStoreNum - exchangCount, forSaleTime, invalidTime);
        }
        if (testId == 1003) {
            mallExchangeRecordAssert(mallExchangeRecordsDOS.get(0), couponId, platPartnerId,
                    userId, exchangeType.code(), ExchangeStatus.FAIL.code(),
                    exchangCount);
        } else if (testId == 1001) {
            mallExchangeRecordAssert(mallExchangeRecordsDOS.get(0), goodsId, platPartnerId,
                    userId, exchangeType.code(), ExchangeStatus.SUCCESS.code(),
                    exchangCount);
        } else {
            mallExchangeRecordAssert(mallExchangeRecordsDOS.get(0), couponId, platPartnerId,
                    userId, exchangeType.code(), ExchangeStatus.SUCCESS.code(),
                    exchangCount);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(couponId);
        gasMerchantTestBase.cleanGasMallExchangeRecordByOrderNo(order.getExchangeOrderNo());
        marketpcTestBase.cleanCouponByCouponName("商城测试券");
        promotionTestBase.cleanCouponDefinitionByName("商城测试券");
    }


    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceFinishExchangeTestFailOne.csv")
    @DisplayName("商品完成兑换--参数非法")
    public void mallExchangeServiceFinishExchangeTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            FinishExchangeGoodsOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setExchangeOrderNo(null);
        }
        if (testId == 1002) {
            order.setStatus(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = mallExchangeService.finishExchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商品不存在
     * 1002.兑换记录不存在
     * 1003.记录状态不正确
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceFinishExchangeTestFailTwo.csv")
    @DisplayName("商品完成兑换--失败用例")
    public void mallExchangeServiceFinishExchangeTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //积分商城信息
            String platPartnerId, String goodsId,
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            Integer exchangCount, String userId,
            ExchangeType exchangeType,
            FinishExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        gasMerchantTestBase.cleanGasMallExchangeRecordByOrderNo(order.getExchangeOrderNo());
        // 准备数据
        Date validStartTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        //优惠券
        String couponId = addCoupon(platPartnerId, "测试券", station, validStartTime, validEndTime);
        if (testId == 1001) {
            gasMerchantTestBase.insertGasMallExchangeRecord(0L, platPartnerId, platPartnerId,
                    userId, goodsId, exchangeType.code(),
                    order.getExchangeOrderNo(), exchangCount, ExchangeStatus.PROCESS.code(), null, null);
        }
        if (testId == 1002) {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId,
                    platPartnerId, exchangeType.code(), goodsName,
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                    exchangedCount, null, null);
        }
        if (testId == 1003) {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId,
                    platPartnerId, exchangeType.code(), goodsName,
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                    exchangedCount, null, null);
            gasMerchantTestBase.insertGasMallExchangeRecord(0L, platPartnerId, platPartnerId,
                    userId, goodsId, exchangeType.code(),
                    order.getExchangeOrderNo(), exchangCount, ExchangeStatus.SUCCESS.code(), null, null);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = mallExchangeService.finishExchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //商品
        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS =
                gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(goodsId);
        if (testId == 1002 || testId == 1003) {
            mallExchangeGoodsAssert(mallExchangeGoodsDOS.get(0), goodsId, platPartnerId,
                    exchangeType.code(),
                    goodsName, gainStyle, goodsImg, goodsDec, gainStation, oneExchangeTimes,
                    storeNum, exchangePoint, exchangedCount,
                    freezeStoreNum, forSaleTime, invalidTime);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(couponId);
        gasMerchantTestBase.cleanGasMallExchangeRecordByOrderNo(order.getExchangeOrderNo());
        marketpcTestBase.cleanCouponByCouponName("商城测试券");
        promotionTestBase.cleanCouponDefinitionByName("商城测试券");
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
