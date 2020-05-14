package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ExchangeType;
import com.xyb.gas.merchant.api.facade.MallExchangeService;
import com.xyb.gas.merchant.api.order.CheckExchangeGoodsOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author nuomi@xyb.com
 * Created on 2018/10/08.
 */
public class MallExchangeServiceCheckExchangeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MallExchangeService mallExchangeService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    Gas_marketpcTestBase marketpcTestBase;

    /**
     * 实物才有核销,优惠券直接返回成功
     * 1001
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceCheckExchangeTestSuccess.csv")
    @DisplayName("核销商品--成功用例")
    public void mallExchangeServiceCheckExchangeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String goodsId,
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            CheckExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        // 准备数据
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId,
                platPartnerId, ExchangeType.ENTITY.code(), goodsName,
                goodsDec, goodsImg, forSaleTime,
                invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                exchangedCount, null, null);
        // 测试过程
        order.setGoodsId(goodsId);
        order.setStationId(station);
        // 调用接口
        SimpleResult result = mallExchangeService.checkExchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceCheckExchangeTestFailOne.csv")
    @DisplayName("核销商品--参数非法")
    public void mallExchangeServiceCheckExchangeTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CheckExchangeGoodsOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setGoodsId(null);
        }
        if (testId == 1002) {
            order.setUserId(null);
        }
        if (testId == 1003) {
            order.setExchangeType(null);
        }
        if (testId == 1004) {
            order.setStationId(null);
        }
        if (testId == 1005) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1006) {
            order.setGid(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        SimpleResult result = mallExchangeService.checkExchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.未配置提取油站
     * 1002.商品不存在
     * 1003.不能在该油站核销
     */
    @AutoTest(file = "gas_merchant/mallExchangeServiceCheckExchangeTestFailTwo.csv")
    @DisplayName("核销商品--失败用例")
    public void mallExchangeServiceCheckExchangeTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String goodsId,
            String goodsName, String goodsDec,
            String goodsImg, Integer exchangePoint,
            Integer storeNum, Integer freezeStoreNum,
            Integer oneExchangeTimes, String gainStyle,
            String station, Integer exchangedCount,
            CheckExchangeGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
        // 准备数据
        Date forSaleTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 0, 0, 1, 0);
        Date invalidTime = gasMerchantInitDataBase.afterDay(DateUtils.getSqlDate(), 0, 15, 0, 0, 0);
        List<String> gainStations = new ArrayList<String>();
        gainStations.add(station);
        String gainStation = JSON.toJSONString(gainStations);
        if (testId == 1001) {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId,
                    platPartnerId, ExchangeType.ENTITY.code(), goodsName,
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, null,
                    exchangedCount, null, null);
        } else if (testId == 1003) {
            gasMerchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId,
                    platPartnerId, ExchangeType.ENTITY.code(), goodsName,
                    goodsDec, goodsImg, forSaleTime,
                    invalidTime, exchangePoint, storeNum, freezeStoreNum, oneExchangeTimes, gainStyle, gainStation,
                    exchangedCount, null, null);
        }
        // 测试过程
        order.setGoodsId(goodsId);
        // 调用接口
        SimpleResult result = mallExchangeService.checkExchange(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
    }
}
