package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
import com.xyb.gas.merchant.api.info.GoodsPriceInfo;
import com.xyb.gas.merchant.api.info.MerchantGoodsInfo;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.QueryMerchantGoodsPriceOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/12/12.
 */
public class MerchantGoodsServiceQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantGoodsService merchantGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 此接口在pos机下单时会用
     * 1001.一个油价计划对应多个油站，查询其中一个
     * 1002.一个油站有多个油价计划，查询生效的一个
     * 1003.查询一个由油站创建的生效油价计划
     * 1004.传入的油品信息里在油价计划里不存在
     * 1005.油价计划里包含油品商品信息，查询商品价格信息
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceQueryTestSuccess.csv")
    @DisplayName("查询商品价格信息--成功用例")
    public void merchantGoodsServiceQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String stationId, String stationId1,
            String stationCode, String stationCode1,
            String stationName, String stationName1,
            String goodsCode, String goodsCode1,
            String goodsName, String goodsName1,
            String stationPlanId, String stationPlanId1,
            String merchantPlanId, String merchantPlanId1,
            QueryMerchantGoodsPriceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode1);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlatPartnerId(platPartnerId);
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -1, 0, 0, 0);
        Date effectTimexx = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -2, 0, 0, 0);
//        Date effectTimexx = new Date(1576050193499L);
        Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsType(GoodsType.OIL);
        priceOrder.setGoodsPrice(new Money(5, 1));
        priceOrder.setListedPrice(null);
        GoodsPriceOrder priceOrder1 = new GoodsPriceOrder();
        priceOrder1.setGoodsCode(goodsCode1);
        priceOrder1.setGoodsName(goodsName1);
        if (testId == 1005) {
            priceOrder1.setGoodsCode("default");
            priceOrder1.setGoodsName("商品");
            priceOrder1.setGoodsType(GoodsType.OTHER);
        } else {
            priceOrder1.setGoodsCode(goodsCode1);
            priceOrder1.setGoodsName(goodsName1);
            priceOrder1.setGoodsType(GoodsType.OIL);
        }
        priceOrder1.setGoodsPrice(new Money(6, 5));
        priceOrder1.setListedPrice(new Money(6, 8));
        goodsPriceOrders.add(priceOrder);
        goodsPriceOrders.add(priceOrder1);
        String stationgoodsInfo = JSON.toJSONString(goodsPriceOrders);
        Set<GoodsPriceOrder> goodsPriceOrdersxx = Sets.newHashSet();
        GoodsPriceOrder priceOrderxx = new GoodsPriceOrder();
        priceOrderxx.setGoodsCode(goodsCode);
        priceOrderxx.setGoodsName(goodsName);
        priceOrderxx.setGoodsType(GoodsType.OIL);
        priceOrderxx.setGoodsPrice(new Money(6, 1));
        priceOrderxx.setListedPrice(null);
        GoodsPriceOrder priceOrder1xx = new GoodsPriceOrder();
        priceOrder1xx.setGoodsCode(goodsCode1);
        priceOrder1xx.setGoodsName(goodsName1);
        priceOrder1xx.setGoodsType(GoodsType.OIL);
        priceOrder1xx.setGoodsPrice(new Money(7, 5));
        priceOrder1xx.setListedPrice(new Money(7, 8));
        goodsPriceOrdersxx.add(priceOrderxx);
        goodsPriceOrdersxx.add(priceOrder1xx);
        String stationgoodsInfoxx = JSON.toJSONString(goodsPriceOrdersxx);
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, stationName, stationCode,
                null, EnableStatus.ABLE.code(), null, null, null, null, null);
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId1, stationName1, stationCode1,
                null, EnableStatus.ABLE.code(), null, null, null, null, null);
        //商品
        gasMerchantInitDataBase.initGasMerchantGoods(platPartnerId, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName, goodsCode,
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(), goodsName1, goodsCode1, null,
                GoodsType.OTHER.code(), "商品", "default");
        //油站分配油品
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName,
                goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        if (testId == 1005) {
            gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, "商品", "default",
                    GoodsType.OTHER.code(), null, null, null, null);
        } else {
            gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName1,
                    goodsCode1,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null, null);
        //油站油价计划
        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId, "原油价计划", platPartnerId,
                platPartnerId, effectTime, "Y", null, null, null, null, stationgoodsInfo);
        if (testId == 1002) {
            gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId1, "原油价计划", platPartnerId,
                    platPartnerId, effectTimexx, "Y", null, null, null, null, stationgoodsInfo);
        }
        if (testId == 1003) {//油站创建的计划
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, null, "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo);
        } else {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, merchantPlanId, "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo);
        }
        //干扰数据
        if (testId == 1002) {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, merchantPlanId1, "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTimexx, "Y", null, null, null, null,
                    stationgoodsInfoxx);
        } else {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, merchantPlanId, "原油价计划",
                    platPartnerId, platPartnerId, stationId1, effectTime, "Y", null, null, null, null,
                    stationgoodsInfoxx);
        }
        // 测试过程
        List<String> goodsCodes = Lists.newArrayList();
        goodsCodes.add(goodsCode);
        if (testId >= 1002) {
            goodsCodes.add(goodsCode1);
        }
        if (testId == 1004) {
            goodsCodes.add("#97");
        }
        if (testId == 1005) {
            goodsCodes.add("default");
        }
        order.setGoodsCodes(goodsCodes);
        order.setStationId(stationId);
        // 调用接口
        BizResult<MerchantGoodsInfo> result = merchantGoodsService.query(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(order.getPartnerId(), result.getInfo().getPartnerId());
        assertEquals(order.getPlatPartnerId(), result.getInfo().getPlatPartnerId());
        assertEquals(order.getStationId(), result.getInfo().getStationId());
        List<GoodsPriceInfo> infos = result.getInfo().getInfos();
        if (testId == 1001) {
            assertEquals(1, infos.size());
            assertEquals(GoodsGroupType.GASOLINE, infos.get(0).getGoodsGroupType());
            assertEquals(GoodsType.OIL, infos.get(0).getGoodsType());
            assertEquals(goodsCode, infos.get(0).getGoodsCode());
            assertEquals(goodsName, infos.get(0).getGoodsName());
            assertEquals(new Money(5, 1), infos.get(0).getGoodsPrice());
            assertEquals(null, infos.get(0).getListedPrice());
        }
        if (testId == 1005) {
            assertEquals(1, infos.size());
            assertEquals(null, infos.get(0).getGoodsGroupType());
            assertEquals(GoodsType.OTHER, infos.get(0).getGoodsType());
            assertEquals("default", infos.get(0).getGoodsCode());
            assertEquals("商品", infos.get(0).getGoodsName());
            assertEquals(new Money(6, 5), infos.get(0).getGoodsPrice());
            assertEquals(new Money(6, 8), infos.get(0).getListedPrice());
        }
        if (testId >= 1002 && testId != 1005) {
            assertEquals(2, infos.size());
            for (GoodsPriceInfo info : infos) {
                assertEquals(GoodsGroupType.GASOLINE, info.getGoodsGroupType());
                assertEquals(GoodsType.OIL, info.getGoodsType());
                if (goodsCode.equals(info.getGoodsCode())) {
                    assertEquals(goodsName, info.getGoodsName());
                    assertEquals(new Money(5, 1), info.getGoodsPrice());
                    assertEquals(null, info.getListedPrice());
                }
                if (goodsCode1.equals(info.getGoodsCode())) {
                    assertEquals(goodsName1, info.getGoodsName());
                    assertEquals(new Money(6, 5), info.getGoodsPrice());
                    assertEquals(new Money(6, 8), info.getListedPrice());
                }
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode1);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceQueryTestFailOne.csv")
    @DisplayName("查询商品价格信息--参数非法")
    public void merchantGoodsServiceQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String goodsCode,
            QueryMerchantGoodsPriceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> goodsCodes = Lists.newArrayList();
        if (testId != 1003) {
            goodsCodes.add(goodsCode);
        }
        order.setGoodsCodes(goodsCodes);
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setStationId(null);
        }
        if (testId == 1004) {
            order.setGoodsType(null);
        }
        if (testId == 1005) {
            order.setGoodsCodes(null);
        }
        if (testId == 1006) {
            order.setGid(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        BizResult<MerchantGoodsInfo> result = merchantGoodsService.query(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.油站的商品价格不存在
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceQueryTestFailTwo.csv")
    @DisplayName("查询商品价格信息--失败用例")
    public void merchantGoodsServiceQueryTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String stationId, String stationId1,
            String stationCode, String stationCode1,
            String stationName, String stationName1,
            String goodsCode, String goodsCode1,
            String goodsName, String goodsName1,
            String stationPlanId, String stationPlanId1,
            String merchantPlanId, String merchantPlanId1,
            QueryMerchantGoodsPriceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsByStationId(order.getStationId());
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode1);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlatPartnerId(platPartnerId);
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -1, 0, 0, 0);
        Date effectTimexx = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -2, 0, 0, 0);
//        Date effectTimexx = new Date(1576050193499L);
        Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsType(GoodsType.OIL);
        priceOrder.setGoodsPrice(new Money(5, 1));
        priceOrder.setListedPrice(null);
        GoodsPriceOrder priceOrder1 = new GoodsPriceOrder();
        priceOrder1.setGoodsCode(goodsCode1);
        priceOrder1.setGoodsName(goodsName1);
        if (testId == 1005) {
            priceOrder1.setGoodsCode("default");
            priceOrder1.setGoodsName("商品");
            priceOrder1.setGoodsType(GoodsType.OTHER);
        } else {
            priceOrder1.setGoodsCode(goodsCode1);
            priceOrder1.setGoodsName(goodsName1);
            priceOrder1.setGoodsType(GoodsType.OIL);
        }
        priceOrder1.setGoodsPrice(new Money(6, 5));
        priceOrder1.setListedPrice(new Money(6, 8));
        goodsPriceOrders.add(priceOrder);
        goodsPriceOrders.add(priceOrder1);
        String stationgoodsInfo = JSON.toJSONString(goodsPriceOrders);
        Set<GoodsPriceOrder> goodsPriceOrdersxx = Sets.newHashSet();
        GoodsPriceOrder priceOrderxx = new GoodsPriceOrder();
        priceOrderxx.setGoodsCode(goodsCode);
        priceOrderxx.setGoodsName(goodsName);
        priceOrderxx.setGoodsType(GoodsType.OIL);
        priceOrderxx.setGoodsPrice(new Money(6, 1));
        priceOrderxx.setListedPrice(null);
        GoodsPriceOrder priceOrder1xx = new GoodsPriceOrder();
        priceOrder1xx.setGoodsCode(goodsCode1);
        priceOrder1xx.setGoodsName(goodsName1);
        priceOrder1xx.setGoodsType(GoodsType.OIL);
        priceOrder1xx.setGoodsPrice(new Money(7, 5));
        priceOrder1xx.setListedPrice(new Money(7, 8));
        goodsPriceOrdersxx.add(priceOrderxx);
        goodsPriceOrdersxx.add(priceOrder1xx);
        String stationgoodsInfoxx = JSON.toJSONString(goodsPriceOrdersxx);
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, stationName, stationCode,
                null, EnableStatus.ABLE.code(), null, null, null, null, null);
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId1, stationName1, stationCode1,
                null, EnableStatus.ABLE.code(), null, null, null, null, null);
        //商品
        gasMerchantInitDataBase.initGasMerchantGoods(platPartnerId, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName, goodsCode,
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(), goodsName1, goodsCode1, null,
                GoodsType.OTHER.code(), "商品", "default");
        //油站分配油品
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName,
                goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        if (testId == 1005) {
            gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, "商品", "default",
                    GoodsType.OTHER.code(), null, null, null, null);
        } else {
            gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName1,
                    goodsCode1,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null, null);
        //油站油价计划
        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId, "原油价计划", platPartnerId,
                platPartnerId, effectTime, "Y", null, null, null, null, stationgoodsInfo);
        if (testId == 1002) {
            gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId1, "原油价计划", platPartnerId,
                    platPartnerId, effectTimexx, "Y", null, null, null, null, stationgoodsInfo);
        }
        if (testId == 1003) {//油站创建的计划
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, null, "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo);
        } else {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, merchantPlanId, "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo);
        }
        // 测试过程
        List<String> goodsCodes = Lists.newArrayList();
        goodsCodes.add(goodsCode);
        order.setGoodsCodes(goodsCodes);
        // 调用接口
        BizResult<MerchantGoodsInfo> result = merchantGoodsService.query(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId1);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode1);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode);
        gasMerchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId1, goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
    }
}
