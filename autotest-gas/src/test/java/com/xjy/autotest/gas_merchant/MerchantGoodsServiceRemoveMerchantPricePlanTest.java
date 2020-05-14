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
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
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
 * Created on 2018/10/11.
 */
public class MerchantGoodsServiceRemoveMerchantPricePlanTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantGoodsService merchantGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001.删除还未下发的油价计划
     * 1002.删除已经下发了的油价计划
     * 1003.删除已经下发了多个油站的油价计划
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceRemoveMerchantPricePlanTestSuccess.csv")
    @DisplayName("商户删除商品价格计划--成功用例")
    public void merchantGoodsServiceRemoveMerchantPricePlanTestSuccess(
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
            CommonBaseOrder order
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
        gasMerchantTestBase.insertGasMerchantGoodsPricePlan(0L, order.getId(), "原油价计划", platPartnerId,
                platPartnerId, effectTime, "Y", null, null, null, null, stationgoodsInfo1);
        if (testId >= 1002) {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId, order.getId(), "原油价计划",
                    platPartnerId, platPartnerId, stationId, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo);
        }
        if (testId == 1003) {
            gasMerchantTestBase.insertGasStationGoodsPricePlan(0L, stationPlanId1, order.getId(), "原油价计划",
                    platPartnerId, platPartnerId, stationId1, effectTime, "Y", null, null, null, null,
                    stationgoodsInfo1);
        }
        // 测试过程
        // 调用接口
        SimpleResult result = merchantGoodsService.removeMerchantPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantGoodsPricePlanDO> merchantGoodsPricePlanS =
                gasMerchantTestBase.findGasMerchantGoodsPricePlanByPlatPartnerId(platPartnerId);
        assertEquals(1, merchantGoodsPricePlanS.size());
        merchantPriceAssert(merchantGoodsPricePlanS.get(0), platPartnerId,
                "原油价计划", null, null, "N", effectTime);
        goodsPriceAssert(JSONArray.parseArray(merchantGoodsPricePlanS.get(0).getGoodsInfo()),
                2, goodsCode, goodsCode1, goodsName, goodsName1,
                GoodsType.OIL.code(), GoodsType.OIL.code(), new Money(6, 1), new Money(7, 5));
        if (testId >= 1002) {
            List<GasStationGoodsPricePlanDO> stationPrics =
                    gasMerchantTestBase.findGasStationGoodsPricePlanByStationId(stationId);
            assertEquals(1, stationPrics.size());
            stationPriceAssert(stationPrics.get(0), platPartnerId, stationId,
                    order.getId(), "原油价计划",
                    null, null, effectTime);
            assertNotEquals("Y", stationPrics.get(0).getDeleteFlag());
            goodsPriceAssert(JSONArray.parseArray(stationPrics.get(0).getGoodsInfo()),
                    1, goodsCode, null, goodsName, null,
                    GoodsType.OIL.code(), null, new Money(6, 1), null);
        }
        if (testId == 1003) {
            List<GasStationGoodsPricePlanDO> stationPrics =
                    gasMerchantTestBase.findGasStationGoodsPricePlanByStationId(stationId1);
            assertEquals(1, stationPrics.size());
            stationPriceAssert(stationPrics.get(0), platPartnerId, stationId1,
                    order.getId(), "原油价计划",
                    null, null, effectTime);
            assertNotEquals("Y", stationPrics.get(0).getDeleteFlag());
            goodsPriceAssert(JSONArray.parseArray(stationPrics.get(0).getGoodsInfo()),
                    2, goodsCode, goodsCode1, goodsName, goodsName1,
                    GoodsType.OIL.code(), GoodsType.OIL.code(), new Money(6, 1), new Money(7, 5));
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
    @AutoTest(file = "gas_merchant/merchantGoodsServiceRemoveMerchantPricePlanTestFailOne.csv")
    @DisplayName("商户删除商品价格计划--参数非法")
    public void merchantGoodsServiceRemoveMerchantPricePlanTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantGoodsService.removeMerchantPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.删除的计划不存在
     */
    @AutoTest(file = "gas_merchant/merchantGoodsServiceRemoveMerchantPricePlanTestFailTwo.csv")
    @DisplayName("商户删除商品价格计划--失败用例")
    public void merchantGoodsServiceRemoveMerchantPricePlanTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonBaseOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(order.getId());
        // 准备数据

        // 测试过程
        // 调用接口
        SimpleResult result = merchantGoodsService.removeMerchantPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsPricePlanByPlanId(order.getId());
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
            String deleteFlag,
            Date effectTime
    ) {
//        assertEquals(exchangePoint, priceInfo.getPlanId());
        assertEquals(platPartnerId, priceInfo.getPartnerId());
        assertEquals(priceName, priceInfo.getPriceName());
        assertEquals(platPartnerId, priceInfo.getPlatPartnerId());
        assertEquals(effectTime.toString(), priceInfo.getEffectTime().toString());
        assertEquals(deleteFlag, priceInfo.getDeleteFlag());
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
//        assertEquals(deleteFlag, priceInfo.getDeleteFlag());
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
