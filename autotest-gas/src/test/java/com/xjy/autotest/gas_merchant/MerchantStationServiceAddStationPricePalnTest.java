package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.order.AddStationGoodsPricePlanOrder;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2020/01/08.
 */
public class MerchantStationServiceAddStationPricePalnTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceAddStationPricePalnTestSuccess.csv")
    @DisplayName("油站新增油价计划--成功用例")
    public void merchantStationServiceAddStationPricePalnTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String goodsName,
            String goodsCode,
            Money price,
            Money listedPrice,
            AddStationGoodsPricePlanOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByStationId(order.getStationId());
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 0);
        // 测试过程
        Set<GoodsPriceOrder> goodsPriceOrders = new HashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsPrice(price);
        priceOrder.setListedPrice(listedPrice);
        priceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrders.add(priceOrder);
        order.setEffectTime(effectTime);
        order.setGoodsPriceOrders(goodsPriceOrders);
        // 调用接口
        SimpleResult result = merchantStationService.addStationPricePaln(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationGoodsPricePlanDO> prices =
                merchantTestBase.findGasStationGoodsPricePlanByStationId(order.getStationId());
        priceAssert(prices.get(0), order.getPlatPartnerId(),
                order.getStationId(), order.getPriceName(),
                JSON.toJSONString(order.getGoodsPriceOrders()), order.getOperatorId(),
                order.getOperatorName(), order.getEffectTime());
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceAddStationPricePalnTestFailOne.csv")
    @DisplayName("油站新增油价计划--参数非法")
    public void merchantStationServiceAddStationPricePalnTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String goodsName,
            String goodsCode,
            Money price,
            Money listedPrice,
            AddStationGoodsPricePlanOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByStationId(order.getStationId());
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 0);
        // 测试过程
        Set<GoodsPriceOrder> goodsPriceOrders = new HashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsPrice(price);
        priceOrder.setListedPrice(listedPrice);
        priceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrders.add(priceOrder);
        order.setEffectTime(effectTime);
        order.setGoodsPriceOrders(goodsPriceOrders);
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setStationId(null);
        }
        if (testId == 1003) {
            order.setPriceName(null);
        }
        if (testId == 1004) {
            order.setEffectTime(null);
        }
        if (testId == 1005) {
            order.setGoodsPriceOrders(null);
        }
        if (testId == 1006) {
            order.setGid(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantStationService.addStationPricePaln(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.已经存在相同时间的油价
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceAddStationPricePalnTestFailTwo.csv")
    @DisplayName("油站新增油价计划--失败用例")
    public void merchantStationServiceAddStationPricePalnTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String goodsName,
            String goodsCode,
            Money price,
            Money listedPrice,
            AddStationGoodsPricePlanOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByStationId(order.getStationId());
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 0);
        Set<GoodsPriceOrder> goodsPriceOrders = new HashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsPrice(price);
        priceOrder.setListedPrice(listedPrice);
        priceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrders.add(priceOrder);
        merchantTestBase.insertGasStationGoodsPricePlan(0l, OID.newID(), null, "测试油价11", order.getPlatPartnerId(),
                order.getPlatPartnerId(), order.getStationId(), effectTime, "Y", null, null, null, null,
                JSON.toJSONString(goodsPriceOrders));
        // 测试过程
        order.setEffectTime(effectTime);
        order.setGoodsPriceOrders(goodsPriceOrders);
        // 调用接口
        SimpleResult result = merchantStationService.addStationPricePaln(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationGoodsPricePlanDO> prices =
                merchantTestBase.findGasStationGoodsPricePlanByStationId(order.getStationId());
        priceAssert(prices.get(0), order.getPlatPartnerId(),
                order.getStationId(), "测试油价11",
                JSON.toJSONString(goodsPriceOrders), null,
                null, order.getEffectTime());
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByStationId(order.getStationId());
    }

    /**
     * 油站油价信息
     */
    private void priceAssert(GasStationGoodsPricePlanDO price,
                             String partnerId,
                             String stationId,
                             String name,
                             String goodsInfo,
                             String operatorId,
                             String operatorName,
                             Date effectTime
    ) {
        assertEquals(partnerId, price.getPlatPartnerId());
        assertEquals(partnerId, price.getPartnerId());
        assertEquals(stationId, price.getStationId());
//        assertEquals(partnerId, price.getPlanId());自动生成的
        assertEquals(null, price.getMerchantPlanId());
        assertEquals(name, price.getPriceName());
        assertEquals(goodsInfo, price.getGoodsInfo());
        assertEquals(effectTime, price.getEffectTime());
        assertEquals("Y", price.getDeleteFlag());
        assertEquals(operatorId, price.getOperatorId());
        assertEquals(operatorName, price.getOperatorName());
        assertEquals(price.getRawAddTime(), price.getRawUpdateTime());
    }
}
