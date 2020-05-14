package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.PagedResult;
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
import com.xyb.gas.merchant.api.enums.GainStyle;
import com.xyb.gas.merchant.api.enums.GoodsStatus;
import com.xyb.gas.merchant.api.facade.MallExchangeGoodsService;
import com.xyb.gas.merchant.api.info.MallExchangeGoodsInfo;
import com.xyb.gas.merchant.api.order.PageQueryMallExchangeGoodsOrder;
import com.xyb.promotion.api.coupon.enums.CouponExpirationType;
import com.xyb.promotion.api.coupon.enums.CouponType;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


/**
 * @author nuomi
 * Created on 2019/12/05.
 */
public class MallExchangeGoodsServicePageQueryMallExchangeGoodsTest extends SpringBootTestBase {

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
     * H5用的查询接口：只查询正在销售的商品,userId不为空
     * 1001.只传必填项查询，按新增时间倒序排
     * 1002.传入商品名称查询
     * 1003.传入商品类型查询，按更新时间升序
     * 1004.传入商品类型查询，按库存降序
     * 1005.传入商品类型查询，按所需积分升序
     * 1006.传入商品类型查询，按已兑数量降序
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServicePageQueryMallExchangeGoodsTestSuccess.csv")
    @DisplayName("分页查询H5积分商城商品--成功用例")
    public void mallExchangeGoodsServicePageQueryMallExchangeGoodsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //积分商城信息
            String platPartnerId, String goodsDec,
            String goodsId, String goodsId1,
            String goodsName, String goodsName1,
            String goodsImg, String goodsImg1,
            String goodsImg2, String goodsImg3,
            Integer exchangePoint, Integer exchangePoint1,
            Integer exchangePoint2, Integer exchangePoint3,
            Integer storeNum, Integer storeNum1,
            Integer storeNum2, Integer storeNum3,
            Integer freezeStoreNum, Integer freezeStoreNum1,
            Integer freezeStoreNum2, Integer freezeStoreNum3,
            Integer oneExchangeTimes, Integer oneExchangeTimes1,
            Integer oneExchangeTimes2, Integer oneExchangeTimes3,
            Integer exchangedCount, Integer exchangedCount1,
            Integer exchangedCount2, Integer exchangedCount3,
            String station,
            //兑换记录
            String orderNo, Integer count,
            PageQueryMallExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMallExchangeRecordByOrderNo(orderNo);
        // 准备数据
        Date validStartTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 20);
        Date validEndTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 1, 0, 0, 0, 20);
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, -1, 0, 0);
        Date forSaleTime1 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, -1, 0);
        Date forSaleTime2 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, -1, 0, 0, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, -1, 0);
        Date invalidTime1 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 10, 0, 0, 0);
        Date invalidTime2 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        Date invalidTime3 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 20, 0, 0, 0);
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 0, 50);
        Date rawAddTime1 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date rawAddTime2 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 1, 0, 0);
        Date rawUpdateTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 3, 0, 0, 0);
        Date rawUpdateTime1 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 2, 0, 0, 0);
        Date rawUpdateTime2 = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 1, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        //优惠券
        Map<Object, Object> param = addCoupon(order.getPlatPartnerId(), "商城测试券", station, validStartTime, validEndTime);
        Map<Object, Object> param1 = addCoupon(order.getPlatPartnerId(), "商城测试券2", station, validStartTime,
                validEndTime);
        String couponId = param.get("couponId").toString();
        String couponId1 = param1.get("couponId").toString();
        //商品1
        gasMerchantTestBase.insertGasMallExchangeGoods(0L, couponId, order.getPlatPartnerId(),
                order.getPlatPartnerId(), ExchangeType.COUPON.code(),
                "商城测试券", goodsDec, goodsImg, forSaleTime,
                invalidTime1, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, GainStyle.AUTO.code(), null,
                exchangedCount, rawAddTime, rawUpdateTime);
        //商品2
        gasMerchantTestBase.insertGasMallExchangeGoods(0L, couponId1, order.getPlatPartnerId(),
                order.getPlatPartnerId(), ExchangeType.COUPON.code(),
                "商城测试券2", goodsDec, goodsImg1, forSaleTime1,
                invalidTime2, exchangePoint1, storeNum1, freezeStoreNum1, oneExchangeTimes1, GainStyle.AUTO.code(),
                null,
                exchangedCount1, rawAddTime1, rawUpdateTime1);
        //商品3
        gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, order.getPlatPartnerId(),
                order.getPlatPartnerId(), ExchangeType.ENTITY.code(),
                goodsName, goodsDec, goodsImg2, forSaleTime2,
                invalidTime3, exchangePoint2, storeNum2, freezeStoreNum2, oneExchangeTimes2, GainStyle.SELF.code(),
                gainStation,
                exchangedCount2, rawAddTime2, rawUpdateTime2);
        //干扰数据
        if (testId == 1001) {//非该商家的
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId1, platPartnerId,
                    platPartnerId, ExchangeType.ENTITY.code(),
                    goodsName1, goodsDec, goodsImg3, forSaleTime,
                    invalidTime2, exchangePoint3, storeNum3, freezeStoreNum3, oneExchangeTimes3, GainStyle.SELF.code(),
                    gainStation,
                    exchangedCount3, DateUtils.getSqlDate(), DateUtils.getSqlDate());
        } else if (testId == 1002) {//已下架
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId1, order.getPlatPartnerId(),
                    order.getPlatPartnerId(), ExchangeType.ENTITY.code(),
                    goodsName1, goodsDec, goodsImg3, forSaleTime,
                    invalidTime, exchangePoint3, storeNum3, freezeStoreNum3, oneExchangeTimes3, GainStyle.SELF.code(),
                    gainStation,
                    exchangedCount3, DateUtils.getSqlDate(), DateUtils.getSqlDate());
        } else {//未开售
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId1, order.getPlatPartnerId(),
                    order.getPlatPartnerId(), ExchangeType.ENTITY.code(),
                    goodsName1, goodsDec, goodsImg3, invalidTime1,
                    invalidTime2, exchangePoint3, storeNum3, freezeStoreNum3, oneExchangeTimes3, GainStyle.SELF.code(),
                    gainStation,
                    exchangedCount3, DateUtils.getSqlDate(), DateUtils.getSqlDate());
        }
        //兑换记录
        gasMerchantTestBase.insertGasMallExchangeRecord(0L, order.getPlatPartnerId(), order.getPlatPartnerId(),
                order.getUserId(),
                goodsId, ExchangeType.ENTITY.code(),
                orderNo, count, ExchangeStatus.SUCCESS.code(), rawUpdateTime2, rawUpdateTime2);
        // 测试过程
        // 调用接口
        PagedResult<MallExchangeGoodsInfo> result = mallExchangeGoodsService.pageQueryMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<MallExchangeGoodsInfo> goodsInfos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(3, goodsInfos.size());
            goodsInfoAssert(goodsInfos.get(0), goodsId, order.getPlatPartnerId(),
                    ExchangeType.ENTITY.code(),
                    goodsName, GainStyle.SELF.code(), goodsImg2, goodsDec, oneExchangeTimes2, storeNum2, exchangePoint2,
                    exchangedCount2, 1, orderNo, null, null, null,
                    GoodsStatus.SALE, forSaleTime2, invalidTime3);
            goodsInfoAssert(goodsInfos.get(1), couponId, order.getPlatPartnerId(),
                    ExchangeType.COUPON.code(),
                    "商城测试券", GainStyle.AUTO.code(), goodsImg, goodsDec, oneExchangeTimes, storeNum, exchangePoint,
                    exchangedCount, 0, null, "5.00",
                    com.xyb.gas.merchant.api.enums.CouponBizType.GAS_COUPON,
                    com.xyb.gas.merchant.api.enums.CouponType.INSTANT,
                    GoodsStatus.SOLD, forSaleTime, invalidTime1);
            goodsInfoAssert(goodsInfos.get(2), couponId1, order.getPlatPartnerId(),
                    ExchangeType.COUPON.code(),
                    "商城测试券2", GainStyle.AUTO.code(), goodsImg1, goodsDec, oneExchangeTimes1, storeNum1, exchangePoint1,
                    exchangedCount1, 0, null, "5.00",
                    com.xyb.gas.merchant.api.enums.CouponBizType.GAS_COUPON,
                    com.xyb.gas.merchant.api.enums.CouponType.INSTANT,
                    GoodsStatus.SALE, forSaleTime1, invalidTime2);
        } else if (testId == 1002) {
            assertEquals(1, goodsInfos.size());
            goodsInfoAssert(goodsInfos.get(0), goodsId, order.getPlatPartnerId(),
                    ExchangeType.ENTITY.code(),
                    goodsName, GainStyle.SELF.code(), goodsImg2, goodsDec, oneExchangeTimes2, storeNum2, exchangePoint2,
                    exchangedCount2, 1, orderNo, null, null, null,
                    GoodsStatus.SALE, forSaleTime2, invalidTime3);
        } else if (testId == 1003 || testId == 1006) {
            assertEquals(2, goodsInfos.size());
            goodsInfoAssert(goodsInfos.get(0), couponId1, order.getPlatPartnerId(),
                    ExchangeType.COUPON.code(),
                    "商城测试券2", GainStyle.AUTO.code(), goodsImg1, goodsDec, oneExchangeTimes1, storeNum1, exchangePoint1,
                    exchangedCount1, 0, null, "5.00",
                    com.xyb.gas.merchant.api.enums.CouponBizType.GAS_COUPON,
                    com.xyb.gas.merchant.api.enums.CouponType.INSTANT,
                    GoodsStatus.SALE, forSaleTime1, invalidTime2);
            goodsInfoAssert(goodsInfos.get(1), couponId, order.getPlatPartnerId(),
                    ExchangeType.COUPON.code(),
                    "商城测试券", GainStyle.AUTO.code(), goodsImg, goodsDec, oneExchangeTimes, storeNum, exchangePoint,
                    exchangedCount, 0, null, "5.00",
                    com.xyb.gas.merchant.api.enums.CouponBizType.GAS_COUPON,
                    com.xyb.gas.merchant.api.enums.CouponType.INSTANT,
                    GoodsStatus.SALE, forSaleTime, invalidTime1);
        } else if (testId == 1004 || testId == 1005) {
            assertEquals(2, goodsInfos.size());
            goodsInfoAssert(goodsInfos.get(1), couponId1, order.getPlatPartnerId(),
                    ExchangeType.COUPON.code(),
                    "商城测试券2", GainStyle.AUTO.code(), goodsImg1, goodsDec, oneExchangeTimes1, storeNum1, exchangePoint1,
                    exchangedCount1, 0, null, "5.00",
                    com.xyb.gas.merchant.api.enums.CouponBizType.GAS_COUPON,
                    com.xyb.gas.merchant.api.enums.CouponType.INSTANT,
                    GoodsStatus.SALE, forSaleTime1, invalidTime2);
            goodsInfoAssert(goodsInfos.get(0), couponId, order.getPlatPartnerId(),
                    ExchangeType.COUPON.code(),
                    "商城测试券", GainStyle.AUTO.code(), goodsImg, goodsDec, oneExchangeTimes, storeNum, exchangePoint,
                    exchangedCount, 0, null, "5.00",
                    com.xyb.gas.merchant.api.enums.CouponBizType.GAS_COUPON,
                    com.xyb.gas.merchant.api.enums.CouponType.INSTANT,
                    GoodsStatus.SALE, forSaleTime, invalidTime1);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasMallExchangeRecordByOrderNo(orderNo);
        marketpcTestBase.cleanCouponByCouponName("商城测试券");
        marketpcTestBase.cleanCouponByCouponName("商城测试券2");
        promotionTestBase.cleanCouponDefinitionByName("商城测试券");
        promotionTestBase.cleanCouponDefinitionByName("商城测试券2");
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServicePageQueryMallExchangeGoodsTestFailOne.csv")
    @DisplayName("分页查询H5积分商城商品--参数非法")
    public void mallExchangeGoodsServicePageQueryMallExchangeGoodsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryMallExchangeGoodsOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<MallExchangeGoodsInfo> result = mallExchangeGoodsService.pageQueryMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据

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
        assertEquals(null, info.getExchangeOrderNo());//开发没返回
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
     * 创建优惠券
     *
     * @param couponName
     * @param validStartTime
     * @param validEndTime
     * @return
     */
    private Map<Object, Object> addCoupon(
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
        Map<Object, Object> param = Maps.newHashMap();
        param.put("couponId", couponId);
        param.put("amountData", order.getAmountData());
        return param;
    }
}
