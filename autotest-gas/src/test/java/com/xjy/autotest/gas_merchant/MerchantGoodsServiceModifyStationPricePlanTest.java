//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.merchant.api.enums.GoodsType;
//import com.xyb.gas.merchant.api.facade.MerchantGoodsService;
//import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
//import com.xyb.gas.merchant.api.order.ModifyStationGoodsPricePlanOrder;
//import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/11.
// */
//public class MerchantGoodsServiceModifyStationPricePlanTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    MerchantGoodsService merchantGoodsService;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/merchantGoodsServiceModifyStationPricePlanTestSuccess.csv")
//	@DisplayName("--成功用例")
//	public void merchantGoodsServiceModifyStationPricePlanTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			ModifyStationGoodsPricePlanOrder order,
//			GoodsPriceOrder goodsPriceOrder,
//			GoodsPriceOrder goodsPriceOrder1,
//			GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO,
//			GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO1
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO1.getPlanId());
//		// 准备数据
//		Set<GoodsPriceOrder> goodsPriceOrdersxx = Sets.newHashSet();
//		GoodsPriceOrder goodsPriceOrderxx = new GoodsPriceOrder();
//		GoodsPriceOrder goodsPriceOrderxx1 = new GoodsPriceOrder();
//		goodsPriceOrderxx.setGoodsName("95号汽油");
//		goodsPriceOrderxx.setGoodsCode("#95");
//		goodsPriceOrderxx.setGoodsType(GoodsType.OIL);
//		goodsPriceOrderxx.setGoodsPrice(new Money(15, 20));
//		goodsPriceOrdersxx.add(goodsPriceOrderxx);
//		String goodsInfos = JSON.toJSONString(goodsPriceOrdersxx);
//		goodsPriceOrderxx1.setGoodsName("87号汽油");
//		goodsPriceOrderxx1.setGoodsCode("#87");
//		goodsPriceOrderxx1.setGoodsType(GoodsType.OIL);
//		goodsPriceOrderxx1.setGoodsPrice(new Money(17, 10));
//		goodsPriceOrdersxx.add(goodsPriceOrderxx1);
//		String goodsInfosxx = JSON.toJSONString(goodsPriceOrdersxx);
//		System.out.println(goodsInfos);
//		System.out.println(goodsInfosxx);
//		if (testId != 1001&&testId!=1002) {
//			gasStationGoodsPricePlanDO.setGoodsInfo(goodsInfos);
//		} else {
//			gasStationGoodsPricePlanDO.setGoodsInfo(goodsInfosxx);
//		}
//		gasStationGoodsPricePlanDO1.setGoodsInfo(goodsInfos);
//		gasMerchantTestBase.insertGasStationGoodsPricePlan(gasStationGoodsPricePlanDO);
//		gasMerchantTestBase.insertGasStationGoodsPricePlan(gasStationGoodsPricePlanDO1);
//		// 测试过程
//		Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
//		goodsPriceOrders.add(goodsPriceOrder);
//		if (testId != 1001) {
//			goodsPriceOrders.add(goodsPriceOrder1);
//		}
//		order.setGoodsPriceOrders(goodsPriceOrders);
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = merchantGoodsService.modifyStationPricePlan(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasStationGoodsPricePlanDO> stationGoodsPricePlanS = gasMerchantTestBase.findGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO.getPlanId());
//		assertEquals(1, stationGoodsPricePlanS.size());
//		for (GasStationGoodsPricePlanDO stationGoodsPricePlan : stationGoodsPricePlanS) {
//			assertEquals("Y", stationGoodsPricePlan.getDeleteFlag());
//			assertEquals(gasStationGoodsPricePlanDO.getPartnerId(), stationGoodsPricePlan.getPartnerId());
//			assertEquals(gasStationGoodsPricePlanDO.getPriceName(), stationGoodsPricePlan.getPriceName());
//			assertEquals(gasStationGoodsPricePlanDO.getEffectTime(), stationGoodsPricePlan.getEffectTime());
//			assertEquals(gasStationGoodsPricePlanDO.getStationId(), stationGoodsPricePlan.getStationId());
//			assertEquals(gasStationGoodsPricePlanDO.getRawAddTime(), stationGoodsPricePlan.getRawAddTime());
////			assertNotEquals(gasStationGoodsPricePlanDO.getRawUpdateTime(), stationGoodsPricePlan.getRawUpdateTime());
//			JSONArray jsonArray = JSONArray.parseArray(stationGoodsPricePlan.getGoodsInfo());
//			if (testId == 1001) {
//				assertTrue(jsonArray.size() == 1);
//				for (int i = 0; i < jsonArray.size(); i++) {
//					JSONObject goodsJson = jsonArray.getJSONObject(i);
//					JSONObject priceJson = JSON.parseObject(goodsJson.get("goodsPrice").toString());
//					assertEquals(goodsPriceOrder.getGoodsName(), goodsJson.get("goodsName").toString());
//					assertEquals(goodsPriceOrder.getGoodsType().code(), goodsJson.get("goodsType").toString());
//					assertEquals(goodsPriceOrder.getGoodsCode(), goodsJson.get("goodsCode").toString());
//					assertEquals(goodsPriceOrder.getGoodsPrice().toString(), priceJson.get("amount").toString());
//				}
//			} else {
//				assertTrue(jsonArray.size() == 2);
//				List<String> goodsCode = new ArrayList<>();
//				for (int i = 0; i < jsonArray.size(); i++) {
//					JSONObject goodsJson = jsonArray.getJSONObject(i);
//					JSONObject priceJson = JSON.parseObject(goodsJson.get("goodsPrice").toString());
//					goodsCode.add(goodsJson.get("goodsCode").toString());
//					if (goodsPriceOrder.getGoodsCode().equals(goodsJson.get("goodsCode").toString())) {
//						assertEquals(goodsPriceOrder.getGoodsName(), goodsJson.get("goodsName").toString());
//						assertEquals(goodsPriceOrder.getGoodsType().code(), goodsJson.get("goodsType").toString());
//						assertEquals(goodsPriceOrder.getGoodsPrice().toString(), priceJson.get("amount").toString());
//					}
//					if (goodsPriceOrder1.getGoodsCode().equals(goodsJson.get("goodsCode").toString())) {
//						assertEquals(goodsPriceOrder1.getGoodsName(), goodsJson.get("goodsName").toString());
//						assertEquals(goodsPriceOrder1.getGoodsType().code(), goodsJson.get("goodsType").toString());
//						assertEquals(goodsPriceOrder1.getGoodsPrice().toString(), priceJson.get("amount").toString());
//					}
//				}
//				assertTrue(goodsCode.contains(goodsPriceOrder.getGoodsCode()));
//				assertTrue(goodsCode.contains(goodsPriceOrder1.getGoodsCode()));
//			}
//		}
//		//干扰数据
//		List<GasStationGoodsPricePlanDO> stationGoodsPricePlanS1 = gasMerchantTestBase.findGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO1.getPlanId());
//		assertEquals(1, stationGoodsPricePlanS1.size());
//		for (GasStationGoodsPricePlanDO stationGoodsPricePlan : stationGoodsPricePlanS1) {
//			assertEquals("Y", stationGoodsPricePlan.getDeleteFlag());
//			assertEquals(gasStationGoodsPricePlanDO1.getPartnerId(), stationGoodsPricePlan.getPartnerId());
//			assertEquals(gasStationGoodsPricePlanDO1.getPriceName(), stationGoodsPricePlan.getPriceName());
//			assertEquals(gasStationGoodsPricePlanDO1.getEffectTime(), stationGoodsPricePlan.getEffectTime());
//			assertEquals(gasStationGoodsPricePlanDO1.getStationId(), stationGoodsPricePlan.getStationId());
//			assertEquals(gasStationGoodsPricePlanDO1.getRawAddTime(), stationGoodsPricePlan.getRawAddTime());
//			assertEquals(gasStationGoodsPricePlanDO1.getRawUpdateTime(), stationGoodsPricePlan.getRawUpdateTime());
//			JSONArray jsonArray = JSONArray.parseArray(stationGoodsPricePlan.getGoodsInfo());
//			assertTrue(jsonArray.size() == 1);
//			for (int i = 0; i < jsonArray.size(); i++) {
//				JSONObject goodsJson = jsonArray.getJSONObject(i);
//				JSONObject priceJson = JSON.parseObject(goodsJson.get("goodsPrice").toString());
//				assertEquals(goodsPriceOrderxx.getGoodsName(), goodsJson.get("goodsName").toString());
//				assertEquals(goodsPriceOrderxx.getGoodsType().code(), goodsJson.get("goodsType").toString());
//				assertEquals(goodsPriceOrderxx.getGoodsCode(), goodsJson.get("goodsCode").toString());
//				assertEquals(goodsPriceOrderxx.getGoodsPrice().toString(), priceJson.get("amount").toString());
//			}
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO.getPlanId());
//		gasMerchantTestBase.cleanGasStationGoodsPricePlanByPlanId(gasStationGoodsPricePlanDO1.getPlanId());
//	}
//}
