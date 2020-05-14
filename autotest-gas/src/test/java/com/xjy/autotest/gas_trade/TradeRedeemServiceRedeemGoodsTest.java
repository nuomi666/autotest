//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.trade.api.info.TradeRedeemInfo;
//import com.xyb.gas.trade.api.order.TradeRedeemCancelOrder;
//import com.xyb.gas.trade.api.order.TradeRedeemGoodsOrder;
//import com.xyb.gas.trade.api.service.TradeRedeemService;
//import dal.model.gas_merchant.*;
//import dal.model.gas_trade.GasTradePointsRedeemDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/09/26.
// */
//public class TradeRedeemServiceRedeemGoodsTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    TradeRedeemService tradeRedeemService;
//
//	@Autowired
//	Gas_tradeTestBase gasTradeTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/tradeRedeemServiceRedeemGoodsTestSuccess.csv")
//	@DisplayName("交易商品积分兑换--成功用例")
//	public void tradeRedeemServiceRedeemGoodsTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			TradeRedeemGoodsOrder order,
//			GasMallExchangeGoodsDO gasMallExchangeGoodsDO,
//			GasMallExchangeGoodsDO gasMallExchangeGoodsDO1
//	) {
//		// 清除数据
//		//gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId("S0301808271500000065");
//		//gasTradeTestBase.cleanGasTradePointsRedeemByPartnerId("S0301808271500000065");
//		// 准备数据
//		gasMallExchangeGoodsDO.setGainStation("[\"001if9yazl84g025eh00\",\"001if9yaxy78g025eh00\"]");
//		gasMallExchangeGoodsDO1.setGainStation("[\"001if9yazl84g025eh00\"]");
////		gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO);
////		gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO1);
//		// 测试过程
//		//order.setUserId("S0301809051400000115");
//		order.setReqId(OID.newID());
//		order.setMerchantOrderNo(OID.newID());
//		order.setGid(GID.newGID());
//		// 调用接口
//		BizResult<TradeRedeemInfo> result = tradeRedeemService.redeemGoods(order);
//		// 结果验证
//        print(result);
//		//assertEquals(status, result.getStatus());
//		//实物核销
//		TradeRedeemCancelOrder cancelOrder = new TradeRedeemCancelOrder();
//		cancelOrder.setBizNo(result.getInfo().getBizNo());
//		cancelOrder.setOperateId("001if9yav9ikg025eh00");
//		cancelOrder.setStationId("001if9yazl84g025eh00");
//		cancelOrder.setTerminalCode("d01254");
//		cancelOrder.setReqId(OID.newID());
//		cancelOrder.setMerchantOrderNo(OID.newID());
//		cancelOrder.setGid(GID.newGID());
//		cancelOrder.setPartnerId(order.getPartnerId());
//		if (testId == 1001 || testId == 1004) {
//			BizResult<TradeRedeemInfo> cancelResult = tradeRedeemService.redeemCancel(cancelOrder);
//			print(cancelResult);
//		}
//		cancelOrder.setStationId("001if9yazl84g025eh00");
//		if (testId == 1001 || testId == 1004) {
//			BizResult<TradeRedeemInfo> cancelResult1 = tradeRedeemService.redeemCancel(cancelOrder);
//			print(cancelResult1);
//		}
////        assertEquals(code, result.getCode());
//		// 数据验证
//		GasMerchantUserDO merchantUser = gasMerchantTestBase.findGasMerchantUserByUserId(cancelOrder.getOperateId()).get(0);
//		GasMerchantStationDO station = gasMerchantTestBase.findGasMerchantStationByStationId(cancelOrder.getStationId()).get(0);
//		GasMerchantDO merchant = gasMerchantTestBase.findGasMerchantByPartnerId(order.getPartnerId()).get(0);
//		GasMerchantDeviceDO device = gasMerchantTestBase.findGasMerchantDeviceByDeviceCode(cancelOrder.getTerminalCode()).get(0);
//		UserDO user = userTestBase.findUserByUserId(order.getUserId()).get(0);
//		dal.model.gas_user.UserDO gasUser = gasUserBase.findUserByUserId(order.getUserId()).get(0);
//		//积分商城商品
//		GasMallExchangeGoodsDO mallExchangeGoods = gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(order.getGoodsId()).get(0);
//		//商品兑换记录
//		List<GasMallExchangeRecordDO> mallExchangeRecords = gasMerchantTestBase.findGasMallExchangeRecordByUserId(order.getUserId());
//		//积分兑换记录
//		GasTradePointsRedeemDO pointsRedeem = gasTradeTestBase.findGasTradePointsRedeemByBizNo(result.getInfo().getBizNo()).get(0);
//		assertEquals(order.getPartnerId(), pointsRedeem.getPartnerId());
//		assertEquals(merchant.getPartnerName(), pointsRedeem.getPartnerName());
//		assertEquals(order.getUserId(), pointsRedeem.getUserId());
//		assertEquals(user.getRealName(), pointsRedeem.getRealName());
//		assertEquals(gasUser.getNickName(), pointsRedeem.getNickName());
//		assertEquals(gasUser.getMemberType(), pointsRedeem.getMemberType());
//		assertEquals(gasUser.getMobile(), pointsRedeem.getMobile());
//		assertEquals(order.getGoodsId(), pointsRedeem.getGoodsId());
//		assertEquals(order.getGoodsType().code(), pointsRedeem.getGoodsType());
//		assertEquals(mallExchangeGoods.getGoodsName(), pointsRedeem.getGoodsName());
//		assertEquals(1, pointsRedeem.getGoodsNum());
//		assertEquals(mallExchangeGoods.getGainStyle(), pointsRedeem.getGainStyle());
//		assertEquals(mallExchangeGoods.getExchangePoint(), Integer.valueOf(pointsRedeem.getPoints()));
//		if (testId == 1001 || testId == 1004) {//实物兑换
//			assertEquals(station.getStationAddress(), pointsRedeem.getGainAdr());
//			assertEquals(cancelOrder.getStationId(), pointsRedeem.getStationId());
//			assertEquals(station.getStationCode(), pointsRedeem.getStationCode());
//			assertEquals(station.getStationName(), pointsRedeem.getStationName());
//			assertEquals(cancelOrder.getOperateId(), pointsRedeem.getOperateId());
//			assertEquals(merchantUser.getUserName(), pointsRedeem.getOperateName());
//			assertEquals(device.getDeviceType(), pointsRedeem.getTerminalType());
//			assertEquals(cancelOrder.getTerminalCode(), pointsRedeem.getTerminalCode());
//		} else {
//			assertEquals(null, pointsRedeem.getGainAdr());
//			assertEquals(null, pointsRedeem.getStationId());
//			assertEquals(null, pointsRedeem.getStationCode());
//			assertEquals(null, pointsRedeem.getStationName());
//			assertEquals(null, pointsRedeem.getOperateId());
//			assertEquals(null, pointsRedeem.getOperateName());
//			assertEquals(null, pointsRedeem.getTerminalType());
//			assertEquals(null, pointsRedeem.getTerminalCode());
//		}
//		assertEquals("success", pointsRedeem.getStatus());
//		assertEquals("finished", pointsRedeem.getState());
//		assertEquals("comn_00_0000", pointsRedeem.getCode());
//		// 清除数据
//		//gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId("S0301808271500000065");
//		//gasTradeTestBase.cleanGasTradePointsRedeemByBizNo(result.getInfo().getBizNo());
//	}
//}
