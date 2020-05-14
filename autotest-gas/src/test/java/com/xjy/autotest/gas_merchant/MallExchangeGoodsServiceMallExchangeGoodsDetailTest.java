package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ExchangeStatus;
import com.xyb.gas.merchant.api.enums.ExchangeType;
import com.xyb.gas.merchant.api.facade.MallExchangeGoodsService;
import com.xyb.gas.merchant.api.info.ExchangeGoodsDetailInfo;
import com.xyb.gas.merchant.api.order.MallExchangeGoodsDetailOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/04.
 */
public class MallExchangeGoodsServiceMallExchangeGoodsDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MallExchangeGoodsService mallExchangeGoodsService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001.不传userid查询
     * 1002.传入userid查询，一个用户有多条兑换成功的记录
     * 1003.传入userid查询，一个用户有一条兑换成功和一条兑换失败的记录
     * 1004.传入userid查询，一个用户有一条兑换成功和一条兑换中的记录
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceMallExchangeGoodsDetailTestSuccess.csv")
    @DisplayName("查询积分商城商品详情--成功用例")
    public void mallExchangeGoodsServiceMallExchangeGoodsDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            // 油站
            String stationId, String stationId1,
            String stationName, String stationName1,
            //商品
            String goodsId, String goodsId1, ExchangeType goodsType,
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            Integer exchangedCount,
            //兑换记录
            String userId, String userId1,
            int count, int count1,
            String orderNo, String orderNo1, String orderNo2, String orderNo3,
            ExchangeStatus exchangeStatus, ExchangeStatus exchangeStatus1,
            MallExchangeGoodsDetailOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId1);
        merchantTestBase.cleanGasMallExchangeRecordByGoodsId(goodsId);
        merchantTestBase.cleanGasMallExchangeRecordByGoodsId(goodsId1);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
        // 准备数据
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(stationId);
        gainStations.add(stationId1);
        List<String> gainStationNames = new ArrayList<String>();
        gainStationNames.add(stationName);
        gainStationNames.add(stationName1);
        String stationsJson = JSON.toJSONString(gainStations);
        String stationsNameJson = JSON.toJSONString(gainStationNames);
        //油站
        gasMerchantInitDataBase.initStationsWithOneMerchant(order.getPlatPartnerId(), order.getPlatPartnerId(),
                order.getPlatPartnerId(), order.getPlatPartnerId(),
                stationId, stationId1, stationName, stationName1, "e001", "e002",
                "ABLE", "ABLE");
        //商品信息
        if (testId == 1001) {
            merchantTestBase.insertGasMallExchangeGoods(0L, goodsId, order.getPlatPartnerId(), order.getPlatPartnerId(),
                    goodsType.code(),
                    goodsName, goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, null,
                    exchangedCount, null, null);
        } else {
            merchantTestBase.insertGasMallExchangeGoods(0L, goodsId, order.getPlatPartnerId(), order.getPlatPartnerId(),
                    goodsType.code(),
                    goodsName, goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, stationsJson,
                    exchangedCount, null, null);
        }
        //干扰数据
        merchantTestBase.insertGasMallExchangeGoods(0L, goodsId1, order.getPlatPartnerId(), order.getPlatPartnerId(),
                ExchangeType.COUPON.code(),
                "优惠券111", goodsDec, goodsImg, forSaleTime,
                invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, "AUTO", null,
                exchangedCount, null, null);
        //兑换记录
        merchantTestBase.insertGasMallExchangeRecord(0L, order.getPlatPartnerId(), order.getPlatPartnerId(), userId,
                goodsId, goodsType.code(),
                orderNo, count, exchangeStatus.code(), null, null);
        merchantTestBase.insertGasMallExchangeRecord(0L, order.getPlatPartnerId(), order.getPlatPartnerId(), userId1,
                goodsId, goodsType.code(),
                orderNo1, count, exchangeStatus.code(), null, null);
        if (testId >= 1002) {
            merchantTestBase.insertGasMallExchangeRecord(0L, order.getPlatPartnerId(), order.getPlatPartnerId(),
                    userId, goodsId, goodsType.code(),
                    orderNo2, count1, exchangeStatus1.code(), null, null);
        }
        //干扰数据
        merchantTestBase.insertGasMallExchangeRecord(0L, order.getPlatPartnerId(), order.getPlatPartnerId(), userId,
                goodsId1, ExchangeType.COUPON.code(),
                orderNo3, count, exchangeStatus.code(), null, null);
        // 测试过程
        if (testId >= 1002) {
            order.setUserId(userId);
        }
        // 调用接口
        BizResult<ExchangeGoodsDetailInfo> result =
                mallExchangeGoodsService.mallExchangeGoodsDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        exchangeGoodsDetailInfoAssert(result.getInfo(), goodsId, order.getPlatPartnerId(), goodsType.code(),
                goodsName, gainStyle, goodsImg, goodsDec, oneExchangeTimes, storeNum, exchangePoint,
                freezeStoreNum, forSaleTime, invalidTime);
        if (testId == 1001) {
            assertEquals(null, result.getInfo().getGainStations());
            assertEquals(null, result.getInfo().getGainStationNames());
        } else {
            assertTrue(result.getInfo().getGainStations().contains(stationId));
            assertTrue(result.getInfo().getGainStations().contains(stationId1));
            assertTrue(result.getInfo().getGainStationNames().contains(stationName));
            assertTrue(result.getInfo().getGainStationNames().contains(stationName1));
        }
        if (testId == 1001) {
            assertEquals(null, result.getInfo().getExchangedTimes());
        } else if (testId == 1003) {
            assertEquals(1, result.getInfo().getExchangedTimes().intValue());
        } else {
            assertEquals(2, result.getInfo().getExchangedTimes().intValue());
        }

        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId1);
        merchantTestBase.cleanGasMallExchangeRecordByGoodsId(goodsId);
        merchantTestBase.cleanGasMallExchangeRecordByGoodsId(goodsId1);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceMallExchangeGoodsDetailTestFailOne.csv")
    @DisplayName("查询积分商城商品详情--参数非法")
    public void mallExchangeGoodsServiceMallExchangeGoodsDetailTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            MallExchangeGoodsDetailOrder order
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
            order.setGoodsType(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizResult<ExchangeGoodsDetailInfo> result =
                mallExchangeGoodsService.mallExchangeGoodsDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.兑换商品不存在
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceMallExchangeGoodsDetailTestFailTwo.csv")
    @DisplayName("查询积分商城商品详情--失败用例")
    public void mallExchangeGoodsServiceMallExchangeGoodsDetailTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            MallExchangeGoodsDetailOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(order.getGoodsId());
        merchantTestBase.cleanGasMallExchangeRecordByGoodsId(order.getGoodsId());
        // 准备数据
        // 测试过程

        // 调用接口
        BizResult<ExchangeGoodsDetailInfo> result =
                mallExchangeGoodsService.mallExchangeGoodsDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(order.getGoodsId());
        merchantTestBase.cleanGasMallExchangeRecordByGoodsId(order.getGoodsId());
    }

    /**
     * 兑换信息校验
     */
    private void exchangeGoodsDetailInfoAssert(
            ExchangeGoodsDetailInfo info,
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
            int freezeStoreNum,
            Date forSaleTime,
            Date invalidTime
    ) {
        assertEquals(exchangePoint, info.getExchangePoint());
        assertEquals(freezeStoreNum, info.getFreezeStoreNum());
        assertEquals(oneExchangeTimes, info.getOneExchangeTimes());
        assertEquals(storeNum, info.getStoreNum());
        assertEquals(gainStyle, info.getGainStyle());
        assertEquals(goodsName, info.getGoodsName());
        assertEquals(goodsId, info.getGoodsId());
        assertEquals(goodsImg, info.getGoodsImg());
        assertEquals(goodsDescription, info.getGoodsDescription());
        assertEquals(goodsType, info.getGoodsType().code());
        assertEquals(DateUtils.formatDate(forSaleTime), DateUtils.formatDate(info.getForSaleTime()));
        assertEquals(DateUtils.formatDate(invalidTime), DateUtils.formatDate(info.getInvalidTime()));
        assertEquals(platPartnerId, info.getPartnerId());
    }
}
