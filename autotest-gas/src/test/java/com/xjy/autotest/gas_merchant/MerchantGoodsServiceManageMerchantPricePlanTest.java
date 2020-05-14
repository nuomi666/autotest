package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.ManageMerchantGoodsPricePlanOrder;
import dal.model.gas_merchant.GasMerchantGoodsPricePlanDO;
import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi@xyb.com
 * Created on 2018/10/10.
 */
public class MerchantGoodsServiceManageMerchantPricePlanTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantGoodsService merchantGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001.新增单个油站的油价计划
     * 1002.新增多个油站的油价计划，其中有油站只分配了商家的部分油号
     * 1003.修改油价计划，原计划里新增油站
     * 1004..修改油价计划，原计划里修改油站，其中有油站只分配了商家的部分油号
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceManageMerchantPricePlanTestSuccess.csv")
    @DisplayName("商家管理商品价格计划--成功用例")
    public void merchantGoodsServiceManageMerchantPricePlanTestSuccess(
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
            ManageMerchantGoodsPricePlanOrder order
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
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, 0, 30);
        Date effectTimexx = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 30);
//        Date effectTimexx = new Date(1576050193499L);
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
        String stationgoodsInfo = JSON.toJSONString(goodsPriceOrdersxx);
        goodsPriceOrdersxx.add(priceOrder1xx);
        String stationgoodsInfo1 = JSON.toJSONString(goodsPriceOrdersxx);
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, stationName, stationCode,
                null, EnableStatus.ABLE.code(), null, null, null, null, null);
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId1, stationName1, stationCode1,
                null, EnableStatus.ABLE.code(), null, null, null, null, null);
        //商品
        gasMerchantInitDataBase.initGasMerchantGoods(platPartnerId, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName, goodsCode,
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(), goodsName1, goodsCode1, null, null, null, null);
        //油站分配油品
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null, null);
        //油站油价计划
        if (testId >= 1003) {
            gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, order.getPlanId(), "原油价计划", platPartnerId,
                    platPartnerId, effectTime, "Y", null, null, null, null, stationgoodsInfo1);
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, order.getPlanId(), "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo);
        }
        if (testId == 1004) {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, order.getPlanId(), "原油价计划",
                    platPartnerId, platPartnerId, stationId1, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo1);
        }
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        if (testId != 1003) {
            stationIds.add(stationId);
        }
        if (testId != 1001) {
            stationIds.add(stationId1);
        }
        Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsType(GoodsType.OIL);
        priceOrder.setGoodsPrice(new Money(6, 6));
        priceOrder.setListedPrice(null);
        GoodsPriceOrder priceOrder1 = new GoodsPriceOrder();
        priceOrder1.setGoodsCode(goodsCode1);
        priceOrder1.setGoodsName(goodsName1);
        priceOrder1.setGoodsType(GoodsType.OIL);
        priceOrder1.setGoodsPrice(new Money(7, 2));
        priceOrder1.setListedPrice(new Money(6, 8));
        goodsPriceOrders.add(priceOrder);
        String stationgoodsInfoxx = JSON.toJSONString(goodsPriceOrdersxx);
        if (testId != 1004) {
            goodsPriceOrders.add(priceOrder1);
        }
        String stationgoodsInfo1xx = JSON.toJSONString(goodsPriceOrdersxx);
        order.setStationIds(stationIds);
        order.setGoodsPriceOrders(goodsPriceOrders);
        order.setEffectTime(effectTimexx);
        // 调用接口
        SimpleResult result = merchantGoodsService.manageMerchantPricePlan(order);
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantGoodsPricePlanDO> merchantGoodsPricePlanS =
                gasMerchantTestBase.findGasMerchantGoodsPricePlanByPlatPartnerId(platPartnerId);
        assertEquals(1, merchantGoodsPricePlanS.size());
        merchantPriceAssert(merchantGoodsPricePlanS.get(0), platPartnerId,
                order.getPriceName(),
                order.getOperatorId(), order.getOperatorName(), effectTimexx);
        if (testId == 1004) {
            goodsPriceAssert(JSONArray.parseArray(merchantGoodsPricePlanS.get(0).getGoodsInfo()),
                    1, goodsCode, null, goodsName, null,
                    GoodsType.OIL.code(), null, new Money(6, 6), null);
        } else {
            goodsPriceAssert(JSONArray.parseArray(merchantGoodsPricePlanS.get(0).getGoodsInfo()),
                    2, goodsCode, goodsCode1, goodsName, goodsName1,
                    GoodsType.OIL.code(), GoodsType.OIL.code(), new Money(6, 6), new Money(7, 2));
        }
        List<GasStationGoodsPricePlanDO> stationPrics =
                gasMerchantTestBase.findGasStationGoodsPricePlanByStationId(stationId);
        if (testId == 1003) {
            assertEquals(1, stationPrics.size());
            stationPriceAssert(stationPrics.get(0), platPartnerId, stationId,
                    merchantGoodsPricePlanS.get(0).getPlanId(), "原油价计划",
                    null, null, effectTime);
            assertNotEquals("Y", stationPrics.get(0).getDeleteFlag());
            goodsPriceAssert(JSONArray.parseArray(stationPrics.get(0).getGoodsInfo()),
                    1, goodsCode, null, goodsName, null,
                    GoodsType.OIL.code(), null, new Money(6, 1), null);
        } else if (testId == 1004) {
            assertEquals(2, stationPrics.size());
            for (GasStationGoodsPricePlanDO stationPric : stationPrics) {
                if (stationPlanId.equals(stationPric.getPlanId())) {
                    stationPriceAssert(stationPric, platPartnerId, stationId,
                            merchantGoodsPricePlanS.get(0).getPlanId(), "原油价计划",
                            null, null, effectTime);
                    assertNotEquals("Y", stationPric.getDeleteFlag());
                    goodsPriceAssert(JSONArray.parseArray(stationPric.getGoodsInfo()),
                            1, goodsCode, null, goodsName, null,
                            GoodsType.OIL.code(), null, new Money(6, 1), null);
                } else {
                    stationPriceAssert(stationPric, platPartnerId, stationId,
                            merchantGoodsPricePlanS.get(0).getPlanId(), order.getPriceName(),
                            order.getOperatorId(), order.getOperatorName(), effectTimexx);
                    assertEquals("Y", stationPric.getDeleteFlag());
                    goodsPriceAssert(JSONArray.parseArray(stationPric.getGoodsInfo()),
                            1, goodsCode, null, goodsName, null,
                            GoodsType.OIL.code(), null, new Money(6, 6), null);
                }
            }
        } else {
            assertEquals(1, stationPrics.size());
            stationPriceAssert(stationPrics.get(0), platPartnerId, stationId,
                    merchantGoodsPricePlanS.get(0).getPlanId(), order.getPriceName(),
                    order.getOperatorId(), order.getOperatorName(), effectTimexx);
            assertEquals("Y", stationPrics.get(0).getDeleteFlag());
            goodsPriceAssert(JSONArray.parseArray(stationPrics.get(0).getGoodsInfo()),
                    1, goodsCode, null, goodsName, null,
                    GoodsType.OIL.code(), null, new Money(6, 6), null);
        }
        List<GasStationGoodsPricePlanDO> stationPrics1 =
                gasMerchantTestBase.findGasStationGoodsPricePlanByStationId(stationId1);
        if (testId == 1002 || testId == 1003) {
            assertEquals(1, stationPrics1.size());
            stationPriceAssert(stationPrics1.get(0), platPartnerId, stationId1,
                    merchantGoodsPricePlanS.get(0).getPlanId(), order.getPriceName(),
                    order.getOperatorId(), order.getOperatorName(), effectTimexx);
            assertEquals("Y", stationPrics1.get(0).getDeleteFlag());
            goodsPriceAssert(JSONArray.parseArray(stationPrics1.get(0).getGoodsInfo()),
                    2, goodsCode, goodsCode1, goodsName, goodsName1,
                    GoodsType.OIL.code(), GoodsType.OIL.code(), new Money(6, 6), new Money(7, 2));
        }
        if (testId == 1004) {
            assertEquals(2, stationPrics1.size());
            for (GasStationGoodsPricePlanDO stationPric : stationPrics1) {
                if (stationPlanId1.equals(stationPric.getPlanId())) {
                    stationPriceAssert(stationPric, platPartnerId, stationId1,
                            merchantGoodsPricePlanS.get(0).getPlanId(), "原油价计划",
                            null, null, effectTime);
                    assertNotEquals("Y", stationPric.getDeleteFlag());
                    goodsPriceAssert(JSONArray.parseArray(stationPric.getGoodsInfo()),
                            2, goodsCode, goodsCode1, goodsName, goodsName1,
                            GoodsType.OIL.code(), GoodsType.OIL.code(), new Money(6, 1), new Money(7, 5));
                } else {
                    stationPriceAssert(stationPric, platPartnerId, stationId1,
                            merchantGoodsPricePlanS.get(0).getPlanId(), order.getPriceName(),
                            order.getOperatorId(), order.getOperatorName(), effectTimexx);
                    assertEquals("Y", stationPric.getDeleteFlag());
                    goodsPriceAssert(JSONArray.parseArray(stationPric.getGoodsInfo()),
                            1, goodsCode, null, goodsName, null,
                            GoodsType.OIL.code(), null, new Money(6, 6), null);
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
    @AutoTest(file = "gas_merchant/merchantGoodsServiceManageMerchantPricePlanTestFailOne.csv")
    @DisplayName("商家管理商品价格计划--参数非法")
    public void merchantGoodsServiceManageMerchantPricePlanTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageMerchantGoodsPricePlanOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(OID.newID());
        Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsCode("#92");
        priceOrder.setGoodsName("92号汽油");
        priceOrder.setGoodsType(GoodsType.OIL);
        priceOrder.setGoodsPrice(new Money(6, 6));
        priceOrder.setListedPrice(null);
        goodsPriceOrders.add(priceOrder);
        order.setStationIds(stationIds);
        order.setGoodsPriceOrders(goodsPriceOrders);
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setPriceName(null);
        }
        if (testId == 1003) {
            order.setEffectTime(null);
        }
        if (testId == 1004) {
            order.setStationIds(null);
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
        SimpleResult result = merchantGoodsService.manageMerchantPricePlan(order);
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.新增时，油站信息不存在
     * 1002.新增时，已经有相同的生效时间的油价计划
     * 1003.修改时，油价计划不存在
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceManageMerchantPricePlanTestFailTwo.csv")
    @DisplayName("商家管理商品价格计划--失败用例")
    public void merchantGoodsServiceManageMerchantPricePlanTestFailTwo(
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
            ManageMerchantGoodsPricePlanOrder order
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
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, 0, 30);
        Date effectTimexx = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 30);
//        Date effectTimexx = new Date(1576050193499L);
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
        String stationgoodsInfo = JSON.toJSONString(goodsPriceOrdersxx);
        goodsPriceOrdersxx.add(priceOrder1xx);
        String stationgoodsInfo1 = JSON.toJSONString(goodsPriceOrdersxx);
        //油站
        if (testId != 1001) {
            gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, stationName, stationCode,
                    null, EnableStatus.ABLE.code(), null, null, null, null, null);
        }
        //商品
        gasMerchantInitDataBase.initGasMerchantGoods(platPartnerId, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName, goodsCode,
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(), goodsName1, goodsCode1, null, null, null, null);
        //油站分配油品
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null, null);
        //油站油价计划
        if (testId == 1002) {
            gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, stationPlanId, "原油价计划", platPartnerId,
                    platPartnerId, effectTime, "Y", null, null, null, null, stationgoodsInfo1);
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, stationPlanId, "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo);
        }
        // 测试过程
        Set<String> stationIds = Sets.newHashSet();
        stationIds.add(stationId);
        Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsType(GoodsType.OIL);
        priceOrder.setGoodsPrice(new Money(6, 6));
        priceOrder.setListedPrice(null);
        GoodsPriceOrder priceOrder1 = new GoodsPriceOrder();
        priceOrder1.setGoodsCode(goodsCode1);
        priceOrder1.setGoodsName(goodsName1);
        priceOrder1.setGoodsType(GoodsType.OIL);
        priceOrder1.setGoodsPrice(new Money(7, 2));
        priceOrder1.setListedPrice(new Money(6, 8));
        goodsPriceOrders.add(priceOrder);
        goodsPriceOrders.add(priceOrder1);
        order.setStationIds(stationIds);
        order.setGoodsPriceOrders(goodsPriceOrders);
        if (testId == 1002) {
            order.setEffectTime(effectTime);
        } else {
            order.setEffectTime(effectTimexx);
        }
        // 调用接口
        SimpleResult result = merchantGoodsService.manageMerchantPricePlan(order);
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantGoodsPricePlanDO> merchantGoodsPricePlanS =
                gasMerchantTestBase.findGasMerchantGoodsPricePlanByPlatPartnerId(platPartnerId);
        if (testId == 1002) {
            assertEquals(1, merchantGoodsPricePlanS.size());
            merchantPriceAssert(merchantGoodsPricePlanS.get(0), platPartnerId,
                    "原油价计划", null, null, effectTime);
        } else {
            assertEquals(0, merchantGoodsPricePlanS.size());
        }
        List<GasStationGoodsPricePlanDO> stationPrics =
                gasMerchantTestBase.findGasStationGoodsPricePlanByStationId(stationId);
        if (testId == 1002) {
            assertEquals(1, stationPrics.size());
            stationPriceAssert(stationPrics.get(0), platPartnerId, stationId,
                    merchantGoodsPricePlanS.get(0).getPlanId(), "原油价计划",
                    null, null, effectTime);
            assertEquals("Y", stationPrics.get(0).getDeleteFlag());
            goodsPriceAssert(JSONArray.parseArray(stationPrics.get(0).getGoodsInfo()),
                    1, goodsCode, null, goodsName, null,
                    GoodsType.OIL.code(), null, new Money(6, 1), null);
        } else {
            assertEquals(0, stationPrics.size());
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
     * 商家油价计划
     */
    private void merchantPriceAssert(
            GasMerchantGoodsPricePlanDO priceInfo,
            String platPartnerId,
            String priceName,
            String operatorId,
            String operatorName,
            Date effectTime
    ) {
//        assertEquals(exchangePoint, priceInfo.getPlanId());
        assertEquals(platPartnerId, priceInfo.getPartnerId());
        assertEquals(priceName, priceInfo.getPriceName());
        assertEquals(platPartnerId, priceInfo.getPlatPartnerId());
        assertEquals(effectTime.toString(), priceInfo.getEffectTime().toString());
        assertEquals("Y", priceInfo.getDeleteFlag());
        assertEquals(operatorId, priceInfo.getOperatorId());
        assertEquals(operatorName, priceInfo.getOperatorName());
//        assertEquals(exchangePoint, priceInfo.getRawAddTime());
//        assertEquals(exchangePoint, priceInfo.getRawUpdateTime());
    }

    /**
     * 油站油价计划
     */
    private void stationPriceAssert(
            GasStationGoodsPricePlanDO priceInfo,
            String platPartnerId,
            String stationId,
            String merchantPlanId,
            String priceName,
            String operatorId,
            String operatorName,
            Date effectTime
    ) {
        assertEquals(merchantPlanId, priceInfo.getMerchantPlanId());
//        assertEquals(merchantPlanId, priceInfo.getPlanId());
        assertEquals(platPartnerId, priceInfo.getPlatPartnerId());
        assertEquals(platPartnerId, priceInfo.getPartnerId());
        assertEquals(priceName, priceInfo.getPriceName());
        assertEquals(stationId, priceInfo.getStationId());
        assertEquals(effectTime.toString(), priceInfo.getEffectTime().toString());
//        assertEquals("Y", priceInfo.getDeleteFlag());
        assertEquals(operatorId, priceInfo.getOperatorId());
        assertEquals(operatorName, priceInfo.getOperatorName());
//        assertEquals(exchangePoint, priceInfo.getRawAddTime());
//        assertEquals(exchangePoint, priceInfo.getRawUpdateTime());
    }

    /**
     * 油品价格
     */
    private void goodsPriceAssert(
            JSONArray jsonArray,
            int count,
            String goodsCode,
            String goodsCode1,
            String goodsName,
            String goodsName1,
            String goodsType,
            String goodsType1,
            Money goodsPrice,
            Money goodsPrice1
    ) {
        assertEquals(count, jsonArray.size());
        List<String> goodsCodes = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject goodsJson = jsonArray.getJSONObject(i);
            JSONObject priceJson = JSON.parseObject(goodsJson.get("goodsPrice").toString());
            goodsCodes.add(goodsJson.get("goodsCode").toString());
            if (goodsCode != null && goodsCode.equals(goodsJson.get("goodsCode").toString())) {
                assertEquals(goodsName, goodsJson.get("goodsName").toString());
                assertEquals(goodsType, goodsJson.get("goodsType").toString());
                assertEquals(goodsPrice.toString(), priceJson.get("amount").toString());
            }
            if (goodsCode1 != null && goodsCode1.equals(goodsJson.get("goodsCode").toString())) {
                assertEquals(goodsName1, goodsJson.get("goodsName").toString());
                assertEquals(goodsType1, goodsJson.get("goodsType").toString());
                assertEquals(goodsPrice1.toString(), priceJson.get("amount").toString());
            }
        }
        if (StringUtils.isNotBlank(goodsCode)) {
            assertTrue(goodsCodes.contains(goodsCode));
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            assertTrue(goodsCodes.contains(goodsCode1));
        }
    }

}
