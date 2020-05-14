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
import com.xyb.gas.merchant.api.info.MerchantGoodsPricePlanInfo;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.PageQueryMerchantPricePlanOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/12/13.
 */
public class MerchantGoodsServicePageQueryMerchantPlanTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantGoodsService merchantGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 油站信息只返回了正在生效的油价计划的油站信息，其他情况下的油站信息没返回（开发也不知道当初为啥这样设计）
     * 1001.只根据商家查询
     * 1002.根据油价名称查询
     * 1003.加入时间查询
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServicePageQueryMerchantPlanTestSuccess.csv")
    @DisplayName("分页查询商家的商品价格计划--成功用例")
    public void merchantGoodsServicePageQueryMerchantPlanTestSuccess(
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
            PageQueryMerchantPricePlanOrder order
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
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, 4, 0, 0);
        Date rawAddTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -2, 4, 0, 0);
        Date rawAddTime2 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -1, 4, 0, 0);
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
        //商家油价计划
        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId, "商家油价计划0", platPartnerId,
                platPartnerId, effectTime, "Y", operatorId, operatorName, rawAddTime, null, goodsInfo);

        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId1, "商家油价计划1", platPartnerId,
                platPartnerId, effectTime1, "Y", operatorId1, operatorName1, rawAddTime1, null, goodsInfo1);

        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId2, "商家油价计划2", platPartnerId,
                platPartnerId, effectTime2, "Y", operatorId2, operatorName2, rawAddTime2, null, goodsInfo2);
        //油站油价计划
        gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, merchantPlanId, "商家油价计划0",
                platPartnerId, platPartnerId, stationId, effectTime, OID.newID(), null, null, null, effectTime2,
                goodsInfo);
        gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, merchantPlanId1, "商家油价计划1",
                platPartnerId, platPartnerId, stationId1, effectTime1, OID.newID(), null, null, null, effectTime2,
                goodsInfo1);

        gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId2, merchantPlanId2, "商家油价计划2",
                platPartnerId, platPartnerId, stationId, effectTime2, "Y", null, null, null, null,
                goodsInfo2);
        gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId3, merchantPlanId2, "商家油价计划2",
                platPartnerId, platPartnerId, stationId1, effectTime2, "Y", null, null, null, null,
                goodsInfo2);
        // 测试过程
        if (testId == 1002) {
            order.setPriceName("商家油价计划0");
        }
        if (testId == 1003) {
            order.setStartTime(rawAddTime1);
        }
        // 调用接口
        PagedResult<MerchantGoodsPricePlanInfo> result = merchantGoodsService.pageQueryMerchantPlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<MerchantGoodsPricePlanInfo> infos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(3, infos.size());
            for (MerchantGoodsPricePlanInfo info : infos) {
                if (merchantPlanId.equals(info.getPlanId())) {
                    goodsPriceInfoAssert(info, platPartnerId, merchantPlanId, "商家油价计划0", operatorName, effectTime,
                            rawAddTime);
                    assertEquals(0, info.getStationInfos().size());
//                    stationInfoAssert(info.getStationInfos().get(0), stationId, stationCode, stationName);
                    assertEquals(2, info.getGoodsPriceInfos().size());
                    for (GoodsPriceInfo goodsPrice : info.getGoodsPriceInfos()) {
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
                if (merchantPlanId1.equals(info.getPlanId())) {
                    goodsPriceInfoAssert(info, platPartnerId, merchantPlanId1, "商家油价计划1", operatorName1, effectTime1,
                            rawAddTime1);
                    assertEquals(0, info.getStationInfos().size());
//                    stationInfoAssert(info.getStationInfos().get(0), stationId1, stationCode1, stationName1);
                    assertEquals(2, info.getGoodsPriceInfos().size());
                    for (GoodsPriceInfo goodsPrice : info.getGoodsPriceInfos()) {
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
                if (merchantPlanId2.equals(info.getPlanId())) {
                    goodsPriceInfoAssert(info, platPartnerId, merchantPlanId2, "商家油价计划2", operatorName2, effectTime2,
                            rawAddTime2);
                    assertEquals(2, info.getStationInfos().size());
                    for (MerchantGoodsPricePlanInfo.StationInfo stationInfo : info.getStationInfos()) {
                        if (stationId.equals(stationInfo.getStationId())) {
                            stationInfoAssert(stationInfo, stationId, stationCode, stationName);
                        }
                        if (stationId1.equals(stationInfo.getStationId())) {
                            stationInfoAssert(stationInfo, stationId1, stationCode1, stationName1);
                        }
                    }
                    assertEquals(2, info.getGoodsPriceInfos().size());
                    for (GoodsPriceInfo goodsPrice : info.getGoodsPriceInfos()) {
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
        if (testId == 1002) {
            assertEquals(1, infos.size());
            for (MerchantGoodsPricePlanInfo info : infos) {
                goodsPriceInfoAssert(info, platPartnerId, merchantPlanId, "商家油价计划0", operatorName, effectTime,
                        rawAddTime);
                assertEquals(0, info.getStationInfos().size());
//                stationInfoAssert(info.getStationInfos().get(0), stationId, stationCode, stationName);
                assertEquals(2, info.getGoodsPriceInfos().size());
                for (GoodsPriceInfo goodsPrice : info.getGoodsPriceInfos()) {
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
        }

        if (testId == 1003) {
            assertEquals(2, infos.size());
            for (MerchantGoodsPricePlanInfo info : infos) {
                if (merchantPlanId1.equals(info.getPlanId())) {
                    goodsPriceInfoAssert(info, platPartnerId, merchantPlanId1, "商家油价计划1", operatorName1, effectTime1,
                            rawAddTime1);
                    assertEquals(0, info.getStationInfos().size());
//                    stationInfoAssert(info.getStationInfos().get(0), stationId1, stationCode1, stationName1);
                    assertEquals(2, info.getGoodsPriceInfos().size());
                    for (GoodsPriceInfo goodsPrice : info.getGoodsPriceInfos()) {
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
                if (merchantPlanId2.equals(info.getPlanId())) {
                    goodsPriceInfoAssert(info, platPartnerId, merchantPlanId2, "商家油价计划2", operatorName2, effectTime2,
                            rawAddTime2);
                    assertEquals(2, info.getStationInfos().size());
                    for (MerchantGoodsPricePlanInfo.StationInfo stationInfo : info.getStationInfos()) {
                        if (stationId.equals(stationInfo.getStationId())) {
                            stationInfoAssert(stationInfo, stationId, stationCode, stationName);
                        }
                        if (stationId1.equals(stationInfo.getStationId())) {
                            stationInfoAssert(stationInfo, stationId1, stationCode1, stationName1);
                        }
                    }
                    assertEquals(2, info.getGoodsPriceInfos().size());
                    for (GoodsPriceInfo goodsPrice : info.getGoodsPriceInfos()) {
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
    @AutoTest(file = "gas_merchant/merchantGoodsServicePageQueryMerchantPlanTestFailOne.csv")
    @DisplayName("分页查询商家的商品价格计划--参数非法")
    public void merchantGoodsServicePageQueryMerchantPlanTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryMerchantPricePlanOrder order
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
        PagedResult<MerchantGoodsPricePlanInfo> result = merchantGoodsService.pageQueryMerchantPlan(order);
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
    private void goodsPriceInfoAssert(MerchantGoodsPricePlanInfo planInfo,
                                      String platPartnerId,
                                      String planId,
                                      String priceName,
                                      String operatorName,
                                      Date effectTime,
                                      Date rawAddTime
    ) {
        assertEquals(platPartnerId, planInfo.getPartnerId());
        assertEquals(platPartnerId, planInfo.getPlatPartnerId());
        assertEquals(planId, planInfo.getPlanId());
        assertEquals(priceName, planInfo.getPriceName());
        assertEquals(effectTime, planInfo.getEffectTime());
        assertEquals(operatorName, planInfo.getOperatorName());
        assertEquals(rawAddTime, planInfo.getRawAddTime());
    }

    /**
     * 油站信息
     */
    private void stationInfoAssert(MerchantGoodsPricePlanInfo.StationInfo stationInfo,
                                   String stationId,
                                   String stationCode,
                                   String stationName
    ) {
        assertEquals(stationId, stationInfo.getStationId());
        assertEquals(stationCode, stationInfo.getStationCode());
        assertEquals(stationName, stationInfo.getStationName());
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
