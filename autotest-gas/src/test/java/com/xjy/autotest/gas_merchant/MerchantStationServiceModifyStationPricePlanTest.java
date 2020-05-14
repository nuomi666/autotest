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
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.ModifyStationGoodsPricePlanOrder;
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
public class MerchantStationServiceModifyStationPricePlanTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceModifyStationPricePlanTestSuccess.csv")
    @DisplayName("油站修改商品价格计划--成功用例")
    public void merchantStationServiceModifyStationPricePlanTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String stationId,
            String goodsName,
            String goodsNamexx,
            String goodsCode,
            String goodsCodexx,
            Money price,
            Money pricexx,
            Money listedPrice,
            Money listedPricexx,
            ModifyStationGoodsPricePlanOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByPlanId(order.getPlanId());
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 0);
        Date effectTimexx = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 2, 0, 0);
        Set<GoodsPriceOrder> goodsPriceOrders = new HashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsPrice(price);
        priceOrder.setListedPrice(listedPrice);
        priceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrders.add(priceOrder);
        merchantTestBase.insertGasStationGoodsPricePlan(0l, order.getPlanId(), null, "测试油价11", partnerId,
                partnerId, stationId, effectTime, "Y", null, null, null, null,
                JSON.toJSONString(goodsPriceOrders));
        // 测试过程
        Set<GoodsPriceOrder> goodsPriceOrdersxx = new HashSet();
        GoodsPriceOrder priceOrderxx = new GoodsPriceOrder();
        priceOrderxx.setGoodsName(goodsNamexx);
        priceOrderxx.setGoodsCode(goodsCodexx);
        priceOrderxx.setGoodsPrice(pricexx);
        priceOrderxx.setListedPrice(listedPricexx);
        priceOrderxx.setGoodsType(GoodsType.OIL);
        goodsPriceOrdersxx.add(priceOrderxx);
        order.setGoodsPriceOrders(goodsPriceOrdersxx);
        order.setEffectTime(effectTimexx);
        // 调用接口
        SimpleResult result = merchantStationService.modifyStationPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationGoodsPricePlanDO> prices =
                merchantTestBase.findGasStationGoodsPricePlanByPlanId(order.getPlanId());
        priceAssert(prices.get(0), partnerId,
                stationId, order.getPlanId(), order.getPriceName(),
                JSON.toJSONString(order.getGoodsPriceOrders()), order.getOperatorId(),
                order.getOperatorName(), order.getEffectTime());
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByPlanId(order.getPlanId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceModifyStationPricePlanTestFailOne.csv")
    @DisplayName("油站修改商品价格计划--参数非法")
    public void merchantStationServiceModifyStationPricePlanTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String goodsNamexx,
            String goodsCodexx,
            Money pricexx,
            Money listedPricexx,
            ModifyStationGoodsPricePlanOrder order
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 0);
        // 测试过程
        Set<GoodsPriceOrder> goodsPriceOrdersxx = new HashSet();
        GoodsPriceOrder priceOrderxx = new GoodsPriceOrder();
        priceOrderxx.setGoodsName(goodsNamexx);
        priceOrderxx.setGoodsCode(goodsCodexx);
        priceOrderxx.setGoodsPrice(pricexx);
        priceOrderxx.setListedPrice(listedPricexx);
        priceOrderxx.setGoodsType(GoodsType.OIL);
        goodsPriceOrdersxx.add(priceOrderxx);
        order.setGoodsPriceOrders(goodsPriceOrdersxx);
        order.setEffectTime(effectTime);
        if (testId == 1001) {
            order.setPlanId(null);
        }
        if (testId == 1002) {
            order.setPriceName(null);
        }
        if (testId == 1003) {
            order.setEffectTime(null);
        }
        if (testId == 1004) {
            order.setGoodsPriceOrders(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantStationService.modifyStationPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.未查询到计划
     * 1002.计划已过期
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceModifyStationPricePlanTestFailTwo.csv")
    @DisplayName("油站修改商品价格计划--失败用例")
    public void merchantStationServiceModifyStationPricePlanTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String stationId,
            String goodsName,
            String goodsNamexx,
            String goodsCode,
            String goodsCodexx,
            Money price,
            Money pricexx,
            Money listedPrice,
            Money listedPricexx,
            ModifyStationGoodsPricePlanOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByStationId(stationId);
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        Date effectTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, 0, -10);
        Date effectTimexx = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 2, 0, 0);
        Set<GoodsPriceOrder> goodsPriceOrders = new HashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsPrice(price);
        priceOrder.setListedPrice(listedPrice);
        priceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrders.add(priceOrder);
        if (testId != 1001) {
            merchantTestBase.insertGasStationGoodsPricePlan(0l, order.getPlanId(), null, "过期油价", partnerId,
                    partnerId, stationId, effectTime, "Y", null, null, null, null,
                    JSON.toJSONString(goodsPriceOrders));
        }
        merchantTestBase.insertGasStationGoodsPricePlan(0l, OID.newID(), null, "正在执行的油价", partnerId,
                partnerId, stationId, effectTime1, "Y", null, null, null, null,
                JSON.toJSONString(goodsPriceOrders));
        // 测试过程
        Set<GoodsPriceOrder> goodsPriceOrdersxx = new HashSet();
        GoodsPriceOrder priceOrderxx = new GoodsPriceOrder();
        priceOrderxx.setGoodsName(goodsNamexx);
        priceOrderxx.setGoodsCode(goodsCodexx);
        priceOrderxx.setGoodsPrice(pricexx);
        priceOrderxx.setListedPrice(listedPricexx);
        priceOrderxx.setGoodsType(GoodsType.OIL);
        goodsPriceOrdersxx.add(priceOrder);
        order.setGoodsPriceOrders(goodsPriceOrdersxx);
        order.setEffectTime(effectTimexx);
        // 调用接口
        SimpleResult result = merchantStationService.modifyStationPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationGoodsPricePlanDO> prices =
                merchantTestBase.findGasStationGoodsPricePlanByPlanId(order.getPlanId());
        if (testId != 1001) {
            priceAssert(prices.get(0), partnerId,
                    stationId, order.getPlanId(), "过期油价",
                    JSON.toJSONString(goodsPriceOrders), null,
                    null, effectTime);
        }
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByStationId(stationId);
    }

    /**
     * 油站油价信息
     */
    private void priceAssert(GasStationGoodsPricePlanDO price,
                             String partnerId,
                             String stationId,
                             String planId,
                             String name,
                             String goodsInfo,
                             String operatorId,
                             String operatorName,
                             Date effectTime
    ) {
        assertEquals(partnerId, price.getPlatPartnerId());
        assertEquals(partnerId, price.getPartnerId());
        assertEquals(stationId, price.getStationId());
        assertEquals(planId, price.getPlanId());
        assertEquals(null, price.getMerchantPlanId());
        assertEquals(name, price.getPriceName());
        assertEquals(goodsInfo, price.getGoodsInfo());
        assertEquals(effectTime, price.getEffectTime());
        assertEquals("Y", price.getDeleteFlag());
        assertEquals(operatorId, price.getOperatorId());
        assertEquals(operatorName, price.getOperatorName());
//        assertNotEquals(price.getRawAddTime(), price.getRawUpdateTime());
    }
}
