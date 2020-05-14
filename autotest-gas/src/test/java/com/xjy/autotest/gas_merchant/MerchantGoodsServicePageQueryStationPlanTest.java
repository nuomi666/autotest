package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
import com.xyb.gas.merchant.api.info.GoodsPriceInfo;
import com.xyb.gas.merchant.api.info.StationGoodsPricePlanInfo;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.PageQueryStationPricePlanOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/12/16.
 */
public class MerchantGoodsServicePageQueryStationPlanTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantGoodsService merchantGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 油站不传时，查询的是商家已分配给油站的油价计划。effectTimeFlag为true查询正在执行的，false查询所有
     * 1001.只传平台商ID查询，查询所有油价计划
     * 1002.只传平台商ID查询，查询正在执行的油价计划
     * 1003.传入油价名称查询，查询已分配给油站的所有油价计划
     * 1004.传入油价名称查询，查询已分配给油站的正在执行的油价计划
     * 1005.传入油站ID查询，查询油站的所有油价计划
     * 1006.传入油站ID查询，查询油站正在执行的油价计划
     * 1007.传入油价名称和油站ID查询，查询油站正在执行的油价计划
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServicePageQueryStationPlanTestSuccess.csv")
    @DisplayName("分页查询油站的商品价格计划--成功用例")
    public void merchantGoodsServicePageQueryStationPlanTestSuccess(
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
            String stationPlanId2, String stationPlanId3,
            String merchantPlanId, String merchantPlanId1,
            String merchantPlanId2,
            String operatorId, String operatorId1,
            String operatorId2, String operatorName,
            String operatorName1, String operatorName2,
            PageQueryStationPricePlanOrder order
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
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, 0, 0, 0);
        Date effectTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -2, 0, 0, 0);
        Date effectTime2 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -1, 0, 0, 0);
        Date effectTime3 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        Date rawAddTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -2, -4, 0, 0);
        Date rawAddTime2 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -1, -4, 0, 0);
//        Date effectTimexx = new Date(1576050193499L);
        //商品信息
        String goodsInfo = buildInfo(goodsCode, goodsName, GoodsType.OIL, new Money(5, 1), new Money(5, 8),
                goodsCode1, goodsName1, GoodsType.OIL, new Money(7, 2), new Money(7, 7));
        String goodsInfo1 = buildInfo(goodsCode, goodsName, GoodsType.OIL, new Money(5, 5), new Money(5, 8),
                goodsCode1, goodsName1, GoodsType.OIL, new Money(7, 3), new Money(7, 7));
        String goodsInfo2 = buildInfo(goodsCode, goodsName, GoodsType.OIL, new Money(5, 8), new Money(5, 8),
                goodsCode1, goodsName1, GoodsType.OIL, new Money(7, 6), new Money(7, 7));
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
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName, goodsCode,
                GoodsType.OIL.code(), null, null, null, null);
        gasMerchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId1, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null, null);
        //商家油价计划
        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId, "商家油价计划0", platPartnerId,
                platPartnerId, effectTime, "Y", operatorId, operatorName, rawAddTime, null, goodsInfo);
        if (testId == 1004 || testId == 1007) {//干扰数据
            gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId1, "商家油价计划1", platPartnerId,
                    platPartnerId, effectTime3, "Y", operatorId1, operatorName1, rawAddTime1, null, goodsInfo1);
        } else {
            gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId1, "商家油价计划1", platPartnerId,
                    platPartnerId, effectTime1, "Y", operatorId1, operatorName1, rawAddTime1, null, goodsInfo1);
        }

        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId2, "商家油价计划2", platPartnerId,
                platPartnerId, effectTime2, "Y", operatorId2, operatorName2, rawAddTime2, null, goodsInfo2);
        //油站油价计划
        if (testId == 1001 || testId == 1003 || testId == 1005) {//油站自己创建的油价计划
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, null, "商家油价计划xx",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", operatorId, operatorName, rawAddTime,
                    effectTime,
                    goodsInfo);
        } else {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, merchantPlanId, "商家油价计划0",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", operatorId, operatorName, rawAddTime,
                    effectTime,
                    goodsInfo);
        }
        if (testId == 1004 || testId == 1007) {//干扰数据
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, merchantPlanId1, "商家油价计划1",
                    platPartnerId, platPartnerId, stationId1, effectTime3, "Y", operatorId1, operatorName1,
                    rawAddTime1, effectTime3,
                    goodsInfo1);
        } else {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, merchantPlanId1, "商家油价计划1",
                    platPartnerId, platPartnerId, stationId1, effectTime1, "Y", operatorId1, operatorName1,
                    rawAddTime1, effectTime1,
                    goodsInfo1);
        }
        if (testId == 1001 || testId == 1005) {//已删除，干扰数据
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId2, merchantPlanId2, "商家油价计划2",
                    platPartnerId, platPartnerId, stationId, effectTime2, OID.newID(), operatorId2, operatorName2,
                    rawAddTime2, effectTime2, goodsInfo2);
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId3, merchantPlanId2, "商家油价计划2",
                    platPartnerId, platPartnerId, stationId1, effectTime2, OID.newID(), operatorId2, operatorName2,
                    rawAddTime2, effectTime2, goodsInfo2);
        } else {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId2, merchantPlanId2, "商家油价计划2",
                    platPartnerId, platPartnerId, stationId, effectTime2, "Y", operatorId2, operatorName2,
                    rawAddTime2, effectTime2,
                    goodsInfo2);
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId3, merchantPlanId2, "商家油价计划2",
                    platPartnerId, platPartnerId, stationId1, effectTime2, "Y", operatorId2, operatorName2,
                    rawAddTime2, effectTime2,
                    goodsInfo2);
        }
        // 测试过程
        if (testId == 1002 || testId == 1004 || testId == 1006 || testId == 1007) {
            order.setEffectTimeFlag(true);
        }
        if (testId == 1003 || testId == 1004 || testId == 1007) {
            order.setPriceName("商家油价计划2");
        }
        if (testId == 1005 || testId == 1006 || testId == 1007) {
            order.setStationId(stationId);
        }
        // 调用接口
        PagedResult<StationGoodsPricePlanInfo> result = merchantGoodsService.pageQueryStationPlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<StationGoodsPricePlanInfo> infos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(2, infos.size());
            for (StationGoodsPricePlanInfo price : infos) {
                if (stationId.equals(price.getStationId())) {
                    goodsPriceInfoAssert(price, platPartnerId, null,
                            stationPlanId, "商家油价计划xx", stationId,
                            stationCode, stationName, operatorName, effectTime, rawAddTime);
                    assertEquals(2, price.getGoodsPriceInfos().size());
                    for (GoodsPriceInfo goodsPrice : price.getGoodsPriceInfos()) {
                        if (goodsCode.equals(goodsPrice.getGoodsCode())) {
                            goodsInfoAssert(goodsPrice, goodsCode, goodsName, GoodsGroupType.GASOLINE.code(),
                                    GoodsType.OIL.code(),
                                    new Money(5, 1), new Money(5, 8));
                        }
                        if (goodsCode1.equals(goodsPrice.getGoodsCode())) {
                            goodsInfoAssert(goodsPrice, goodsCode1, goodsName1, GoodsGroupType.GASOLINE.code(),
                                    GoodsType.OIL.code(),
                                    new Money(7, 2), new Money(7, 7));
                        }
                    }
                }
                if (stationId1.equals(price.getStationId())) {
                    goodsPriceInfoAssert(price, platPartnerId, merchantPlanId1,
                            stationPlanId1, "商家油价计划1", stationId1,
                            stationCode1, stationName1, operatorName1, effectTime1, rawAddTime1);
                    assertEquals(2, price.getGoodsPriceInfos().size());
                    for (GoodsPriceInfo goodsPrice : price.getGoodsPriceInfos()) {
                        if (goodsCode.equals(goodsPrice.getGoodsCode())) {
                            goodsInfoAssert(goodsPrice, goodsCode, goodsName, GoodsGroupType.GASOLINE.code(),
                                    GoodsType.OIL.code(),
                                    new Money(5, 5), new Money(5, 8));
                        }
                        if (goodsCode1.equals(goodsPrice.getGoodsCode())) {
                            goodsInfoAssert(goodsPrice, goodsCode1, goodsName1, GoodsGroupType.GASOLINE.code(),
                                    GoodsType.OIL.code(),
                                    new Money(7, 3), new Money(7, 7));
                        }
                    }
                }
            }
        }
        if (testId == 1002 || testId == 1003) {
            assertEquals(2, infos.size());
            for (StationGoodsPricePlanInfo price : infos) {
                if (stationId.equals(price.getStationId())) {
                    goodsPriceInfoAssert(price, platPartnerId, merchantPlanId2,
                            stationPlanId2, "商家油价计划2", stationId,
                            stationCode, stationName, operatorName2, effectTime2, rawAddTime2);
                }
                if (stationId1.equals(price.getStationId())) {
                    goodsPriceInfoAssert(price, platPartnerId, merchantPlanId2,
                            stationPlanId3, "商家油价计划2", stationId1,
                            stationCode1, stationName1, operatorName2, effectTime2, rawAddTime2);
                }
                assertEquals(2, price.getGoodsPriceInfos().size());
                for (GoodsPriceInfo goodsPrice : price.getGoodsPriceInfos()) {
                    if (goodsCode.equals(goodsPrice.getGoodsCode())) {
                        goodsInfoAssert(goodsPrice, goodsCode, goodsName, GoodsGroupType.GASOLINE.code(),
                                GoodsType.OIL.code(),
                                new Money(5, 8), new Money(5, 8));
                    }
                    if (goodsCode1.equals(goodsPrice.getGoodsCode())) {
                        goodsInfoAssert(goodsPrice, goodsCode1, goodsName1, GoodsGroupType.GASOLINE.code(),
                                GoodsType.OIL.code(),
                                new Money(7, 6), new Money(7, 7));
                    }
                }
            }
        }
        if (testId == 1004 || testId == 1006) {
            assertEquals(1, infos.size());
            goodsPriceInfoAssert(infos.get(0), platPartnerId, merchantPlanId,
                    stationPlanId, "商家油价计划2", stationId1,
                    stationCode, stationName, operatorName2, effectTime, rawAddTime);
            assertEquals(2, infos.get(0).getGoodsPriceInfos().size());
            for (GoodsPriceInfo goodsPrice : infos.get(0).getGoodsPriceInfos()) {
                if (goodsCode.equals(goodsPrice.getGoodsCode())) {
                    goodsInfoAssert(goodsPrice, goodsCode, goodsName, GoodsGroupType.GASOLINE.code(),
                            GoodsType.OIL.code(),
                            new Money(5, 8), new Money(5, 8));
                }
                if (goodsCode1.equals(goodsPrice.getGoodsCode())) {
                    goodsInfoAssert(goodsPrice, goodsCode1, goodsName1, GoodsGroupType.GASOLINE.code(),
                            GoodsType.OIL.code(),
                            new Money(7, 6), new Money(7, 7));
                }
            }
            if (testId == 1005) {
                assertEquals(2, infos.size());
                for (StationGoodsPricePlanInfo price : infos) {
                    if (stationPlanId.equals(price.getPlanId())) {
                        goodsPriceInfoAssert(price, platPartnerId, null,
                                stationPlanId, "商家油价计划xx", stationId,
                                stationCode, stationName, operatorName, effectTime, rawAddTime);
                        assertEquals(2, price.getGoodsPriceInfos().size());
                        for (GoodsPriceInfo goodsPrice : price.getGoodsPriceInfos()) {
                            if (goodsCode.equals(goodsPrice.getGoodsCode())) {
                                goodsInfoAssert(goodsPrice, goodsCode, goodsName, GoodsGroupType.GASOLINE.code(),
                                        GoodsType.OIL.code(),
                                        new Money(5, 1), new Money(5, 8));
                            }
                            if (goodsCode1.equals(goodsPrice.getGoodsCode())) {
                                goodsInfoAssert(goodsPrice, goodsCode1, goodsName1, GoodsGroupType.GASOLINE.code(),
                                        GoodsType.OIL.code(),
                                        new Money(7, 2), new Money(7, 7));
                            }
                        }
                    }
                    if (stationPlanId2.equals(price.getPlanId())) {
                        goodsPriceInfoAssert(price, platPartnerId, merchantPlanId2,
                                stationPlanId2, "商家油价计划2", stationId,
                                stationCode, stationName, operatorName2, effectTime2, rawAddTime2);
                        assertEquals(2, price.getGoodsPriceInfos().size());
                        for (GoodsPriceInfo goodsPrice : price.getGoodsPriceInfos()) {
                            if (goodsCode.equals(goodsPrice.getGoodsCode())) {
                                goodsInfoAssert(goodsPrice, goodsCode, goodsName, GoodsGroupType.GASOLINE.code(),
                                        GoodsType.OIL.code(),
                                        new Money(5, 8), new Money(5, 8));
                            }
                            if (goodsCode1.equals(goodsPrice.getGoodsCode())) {
                                goodsInfoAssert(goodsPrice, goodsCode1, goodsName1, GoodsGroupType.GASOLINE.code(),
                                        GoodsType.OIL.code(),
                                        new Money(7, 6), new Money(7, 7));
                            }
                        }
                    }
                }
            }
            if (testId == 1007) {
                assertEquals(0, infos.size());
//                goodsPriceInfoAssert(info.getStationInfos().get(0), stationId, stationCode, stationName);
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
    @AutoTest(file = "gas_merchant/merchantGoodsServicePageQueryStationPlanTestFailOne.csv")
    @DisplayName("分页查询油站的商品价格计划--参数非法")
    public void merchantGoodsServicePageQueryStationPlanTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryStationPricePlanOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<StationGoodsPricePlanInfo> result = merchantGoodsService.pageQueryStationPlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 油价信息
     */
    private void goodsPriceInfoAssert(StationGoodsPricePlanInfo planInfo,
                                      String platPartnerId,
                                      String merchantPlanId,
                                      String planId,
                                      String priceName,
                                      String stationId,
                                      String stationCode,
                                      String stationName,
                                      String operatorName,
                                      Date effectTime,
                                      Date rawAddTime
    ) {
//        assertEquals(platPartnerId, planInfo.getPartnerId());
//        assertEquals(platPartnerId, planInfo.getPlatPartnerId());
        assertEquals(merchantPlanId, planInfo.getMerchantPlanId());
        assertEquals(planId, planInfo.getPlanId());
        assertEquals(priceName, planInfo.getPriceName());
        assertEquals(effectTime, planInfo.getEffectTime());
        assertEquals(stationId, planInfo.getStationId());
        assertEquals(stationCode, planInfo.getStationCode());
        assertEquals(stationName, planInfo.getStationName());
        assertEquals(operatorName, planInfo.getOperatorName());
        assertEquals(rawAddTime, planInfo.getRawAddTime());
    }

    /**
     * 商品信息
     */
    private void goodsInfoAssert(GoodsPriceInfo goodsPriceInfos,
                                 String goodsCode,
                                 String goodsName,
                                 String goodsGroupType,
                                 String goodsType,
                                 Money goodsPrice,
                                 Money listedPrice
    ) {
        assertEquals(null, goodsPriceInfos.getGoodsGroupType());//开发没返回
        assertEquals(goodsType, goodsPriceInfos.getGoodsType().code());
        assertEquals(goodsCode, goodsPriceInfos.getGoodsCode());
        assertEquals(goodsName, goodsPriceInfos.getGoodsName());
        assertEquals(goodsPrice, goodsPriceInfos.getGoodsPrice());
        assertEquals(listedPrice, goodsPriceInfos.getListedPrice());
    }

    /**
     * 油价信息
     */
    private String buildInfo(String goodsCode, String goodsName,
                             GoodsType goodsType,
                             Money price, Money listPrice,
                             String goodsCode1, String goodsName1,
                             GoodsType goodsType1,
                             Money price1, Money listPrice1
    ) {
        Set<GoodsPriceOrder> goodsPriceOrdersxx = Sets.newHashSet();
        GoodsPriceOrder priceOrderxx = new GoodsPriceOrder();
        priceOrderxx.setGoodsCode(goodsCode);
        priceOrderxx.setGoodsName(goodsName);
        priceOrderxx.setGoodsType(goodsType);
        priceOrderxx.setGoodsPrice(price);
        priceOrderxx.setListedPrice(listPrice);
        GoodsPriceOrder priceOrder1xx = new GoodsPriceOrder();
        priceOrder1xx.setGoodsCode(goodsCode1);
        priceOrder1xx.setGoodsName(goodsName1);
        priceOrder1xx.setGoodsType(goodsType1);
        priceOrder1xx.setGoodsPrice(price1);
        priceOrder1xx.setListedPrice(listPrice1);
        if (StringUtils.isNotBlank(goodsCode)) {
            goodsPriceOrdersxx.add(priceOrderxx);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            goodsPriceOrdersxx.add(priceOrder1xx);
        }
        String stationgoodsInfo = JSON.toJSONString(goodsPriceOrdersxx);
        return stationgoodsInfo;
    }
}
