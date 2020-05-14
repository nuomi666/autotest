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
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
import com.xyb.gas.merchant.api.info.GoodsPriceInfo;
import com.xyb.gas.merchant.api.info.StationGoodsPricePlanInfo;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.QueryGoodsPlanDetailOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2019/12/17.
 */
public class MerchantGoodsServiceQueryStationPlanDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantGoodsService merchantGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001.查询油站创建的油价计划
     * 1002.查询商家创建的油价计划
     * 1003.查询已删除的油价计划
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceQueryStationPlanDetailTestSuccess.csv")
    @DisplayName("查询油站的商品价格计划详情--成功用例")
    public void merchantGoodsServiceQueryStationPlanDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String stationId, String stationId1,
            String stationCode, String stationName,
            String goodsCode, String goodsCode1,
            String goodsName, String goodsName1,
            String stationPlanId, String merchantPlanId,
            String operatorId, String operatorName,
            QueryGoodsPlanDetailOrder order
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
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
//        Date effectTimexx = new Date(1576050193499L);
        //商品信息
        String goodsInfo = buildInfo(goodsCode, goodsName, GoodsType.OIL, new Money(5, 1), new Money(5, 8),
                goodsCode1, goodsName1, GoodsType.OIL, new Money(7, 2), new Money(7, 7));
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, stationName, stationCode,
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
        //商家油价计划
        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, merchantPlanId, "商家油价计划0", platPartnerId,
                platPartnerId, effectTime, "Y", operatorId, operatorName, rawAddTime, null, goodsInfo);
        //油站油价计划
        if (testId == 1001) {//油站自己创建的油价计划
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, null, "商家油价计划xx",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", operatorId, operatorName, rawAddTime,
                    effectTime, goodsInfo);
        } else if (testId == 1003) {//已删除
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, merchantPlanId, "商家油价计划0",
                    platPartnerId, platPartnerId, stationId, effectTime, OID.newID(), operatorId, operatorName,
                    rawAddTime,
                    effectTime, goodsInfo);
        } else {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, merchantPlanId, "商家油价计划0",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", operatorId, operatorName, rawAddTime,
                    effectTime, goodsInfo);
        }
        // 测试过程
        order.setPlanId(stationPlanId);
        // 调用接口
        BizResult<StationGoodsPricePlanInfo> result = merchantGoodsService.queryStationPlanDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        StationGoodsPricePlanInfo info = result.getInfo();
        if (testId == 1003) {
            assertEquals(null, info);
//                goodsPriceInfoAssert(info.getStationInfos().get(0), stationId, stationCode, stationName);
        } else if (testId == 1001) {
            goodsPriceInfoAssert(info, platPartnerId, null,
                    stationPlanId, "商家油价计划xx", stationId,
                    stationCode, stationName, operatorName, effectTime, rawAddTime);
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
        } else {
            goodsPriceInfoAssert(info, platPartnerId, merchantPlanId,
                    stationPlanId, "商家油价计划xx", stationId,
                    stationCode, stationName, operatorName, effectTime, rawAddTime);
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
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceQueryStationPlanDetailTestFailOne.csv")
    @DisplayName("查询油站的商品价格计划详情--参数非法")
    public void merchantGoodsServiceQueryStationPlanDetailTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryGoodsPlanDetailOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlanId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<StationGoodsPricePlanInfo> result = merchantGoodsService.queryStationPlanDetail(order);
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
        assertEquals(platPartnerId, planInfo.getPartnerId());
        assertEquals(platPartnerId, planInfo.getPlatPartnerId());
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
