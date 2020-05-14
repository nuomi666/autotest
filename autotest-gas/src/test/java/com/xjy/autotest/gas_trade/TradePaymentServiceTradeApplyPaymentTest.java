//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.*;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeGoodsOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentApplyOrder;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_merchant.GasMerchantStationDO;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import dal.model.gas_trade.GasTradeGoodsDO;
//import dal.model.gas_trade.GasTradeOilDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/30.
// */
//public class TradePaymentServiceTradeApplyPaymentTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    TradePaymentService tradePaymentService;
//
//	@Autowired
//	Gas_tradeTestBase gasTradeTestBase;
//
//	@Autowired
//	PayTestBase payTestBase;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/tradePaymentServiceTradeApplyPaymentTestSuccess.csv")
//	@DisplayName("交易付款申请--成功用例")
//	public void tradePaymentServiceTradeApplyPaymentTestSuccess(
//			// 基本参数
//			int testId,
//			// 业务参数
//			TradePaymentApplyOrder order,
//			TradeOilOrder tradeOilOrder,
//			TradeGoodsOrder tradeGoodsOrder,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		// 准备数据
//		//商户信息
//		GasMerchantDO merchantInfo = gasMerchantTestBase.findGasMerchantByPartnerId(order.getPartnerId()).get(0);
//		//操作员信息
//		GasMerchantUserDO operatorInfo = gasMerchantTestBase.findGasMerchantUserByUserId(order.getOperateId()).get(0);
//		//油站信息
//		GasMerchantStationDO stationInfo = gasMerchantTestBase.findGasMerchantStationByStationId(order.getStationId()).get(0);
//
//		// 测试过程
//		String reqId = OID.newID();
//		String gid = GID.newGID();
//		order.setReqId(reqId);
//		tradeOilOrder.setCode("#95");
//		if (testId == 1003) {
//			tradeOilOrder.setAmount(new Money(151, 11));
//		}
//		List<TradeGoodsOrder> goodsOrders = new ArrayList<TradeGoodsOrder>();
//		goodsOrders.add(tradeGoodsOrder);
//		if (testId != 1004) {
//			order.setTradeOilOrder(tradeOilOrder);
//		}
//		if (testId != 1003) {
//			order.setGoodsOrders(goodsOrders);
//		}
//		order.setGid(gid);
//		// 调用接口
//		BizResult<TradePaymentInfo> result = tradePaymentService.tradeApplyPayment(order);
//		// 结果验证
//		assertResult(testId, Status.PROCESSING, code, result);
//		// 数据验证
//		GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByBizNo(result.getInfo().getBizNo()).get(0);
//		assertEquals("PAYMENT", paymentInfo.getTradeType());
//		assertEquals(order.getOrderType().code(), paymentInfo.getOrderType());
//		//  assertEquals("PAYMENT", paymentInfo.getBizNo());
//		assertEquals(order.getReqId(), paymentInfo.getReqId());
//		assertEquals(order.getGid(), paymentInfo.getGid());
//		assertEquals(order.getPartnerId(), paymentInfo.getPartnerId());
//		assertEquals(merchantInfo.getPartnerName(), paymentInfo.getPartnerName());
//		assertEquals(order.getStationId(), paymentInfo.getStationId());
//		assertEquals(stationInfo.getStationCode(), paymentInfo.getStationCode());
//		assertEquals(stationInfo.getStationName(), paymentInfo.getStationName());
//		assertEquals(order.getOperateId(), paymentInfo.getOperateId());
//		assertEquals(operatorInfo.getUserName(), paymentInfo.getOperateName());
//		assertEquals(order.getTerminalType().code(), paymentInfo.getTerminalType());
//		assertEquals(order.getTerminalCode(), paymentInfo.getTerminalCode());
//		assertEquals(null, paymentInfo.getUserId());
//		// assertEquals(null, paymentInfo.getRealName());
//		assertEquals(null, paymentInfo.getNickName());
//		assertEquals(null, paymentInfo.getMemberType());
//		assertEquals(null, paymentInfo.getMobile());
//		assertEquals(null, paymentInfo.getCardNo());
//		assertEquals(null, paymentInfo.getCardType());
//		assertEquals(null, paymentInfo.getCardBizType());
////        assertEquals("PAYMENT", paymentInfo.getCarNumber());
////        assertEquals("PAYMENT", paymentInfo.getRequestNo());
////        assertEquals("PAYMENT", paymentInfo.getPayNo());
//		assertEquals(null, paymentInfo.getTradePayType());
//		assertEquals(null, paymentInfo.getPayModel());
//		if (testId == 1001 || testId == 1002) {
//			assertEquals(tradeOilOrder.getAmount().add(tradeGoodsOrder.getAmount()), Money.cent(paymentInfo.getAmount()));
//		} else {
//			assertEquals(tradeOilOrder.getAmount(), Money.cent(paymentInfo.getAmount()));
//		}
//		assertEquals(new Money(0, 0), Money.cent(paymentInfo.getPayAmount()));
//		assertEquals(new Money(0, 0), Money.cent(paymentInfo.getFavourAmount()));
//		assertEquals(new Money(0, 0), Money.cent(paymentInfo.getBalance()));
////        assertEquals("PAYMENT", paymentInfo.getMemo());
//		assertEquals("processing", paymentInfo.getStatus());
//		assertEquals("confirm_wait", paymentInfo.getState());
//		assertEquals("G03_04_0001", paymentInfo.getCode());
//		assertEquals("待确认", paymentInfo.getDescription());
//		assertEquals("等待付款确认", paymentInfo.getRunMemo());
////        assertEquals("PAYMENT", paymentInfo.getExpireTime());
////        assertEquals("PAYMENT", paymentInfo.getExtensionContext());
////        assertEquals("PAYMENT", paymentInfo.getFinishTime());
//		//油品信息
//		if (testId != 1004) {
//			List<GasTradeOilDO> oilInfos = gasTradeTestBase.findGasTradeOilByTradeNo(paymentInfo.getBizNo());
//			for (GasTradeOilDO oilInfo : oilInfos) {
//				assertEquals(paymentInfo.getBizNo(), oilInfo.getTradeNo());
//				assertEquals(tradeOilOrder.getCode(), oilInfo.getCode());
////            assertEquals(oilName, oilInfo.getOilName());
////            assertEquals(tradeOilOrder.getAmount(), oilInfo.getPrice());
////            assertEquals("PAYMENT", oilInfo.getLiter());
//				assertEquals(tradeOilOrder.getOilGun(), oilInfo.getOilGun());
//				assertEquals(tradeOilOrder.getAmount(), Money.cent(oilInfo.getAmount()));
//			}
//		}
//		//商品信息
//		if (testId != 1003) {
//			List<GasTradeGoodsDO> goodsInfos = gasTradeTestBase.findGasTradeGoodsByTradeNo(paymentInfo.getBizNo());
//			for (GasTradeGoodsDO goodsInfo : goodsInfos) {
//				assertEquals(paymentInfo.getBizNo(), goodsInfo.getTradeNo());
////            assertEquals("PAYMENT", goodsInfo.getGoodsType());
//				assertEquals(tradeGoodsOrder.getCode(), goodsInfo.getCode());
////            assertEquals(goodsName, goodsInfo.getGoodsName());
////            assertEquals("PAYMENT", goodsInfo.getPrice());
////            assertEquals("PAYMENT", goodsInfo.getPiece());
//				assertEquals(tradeGoodsOrder.getAmount(), Money.cent(goodsInfo.getAmount()));
//			}
//		}
//		// 清除数据
//		gasTradeTestBase.cleanGasTradePaymentByBizNo(result.getInfo().getBizNo());
//		gasTradeTestBase.cleanGasTradeGoodsByTradeNo(result.getInfo().getBizNo());
//		gasTradeTestBase.cleanGasTradeOilByTradeNo(result.getInfo().getBizNo());
//	}
//}
