//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.*;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeGoodsOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentApplyOrder;
//import com.xyb.gas.trade.api.order.TradePaymentConfirmOrder;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import com.xyb.pay.api.settlement.info.PaymentInfo;
//import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentConfirmOrder;
//import com.xyb.pay.api.settlement.service.BalancePaymentService;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_merchant.GasMerchantStationDO;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import dal.model.gas_trade.GasTradeGoodsDO;
//import dal.model.gas_trade.GasTradeOilDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.pay.PaymentInstructionDO;
//import dal.model.user.AccountDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/09/04.
// */
//public class TradePaymentServiceTradeConfirmPaymentTest extends SpringBootTestBase{
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
//	@Reference(version = "1.0.0")
//	BalancePaymentService balancePaymentService;
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
//	@AutoTest(file = "gas_trade/tradePaymentServiceTradeConfirmPaymentTestSuccess.csv")
//	@DisplayName("交易付款确认--成功用例")
//	public void tradePaymentServiceTradeConfirmPaymentTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			TradePaymentApplyOrder applyOrder,
//			TradeOilOrder tradeOilOrder,
//			TradeGoodsOrder tradeGoodsOrder,
//			TradePaymentConfirmOrder order,
//			String favourId,
//			// 结果参数
//			String description,
//			String message
//	) {
//		// 清除数据
//		// 准备数据
//		//卡信息
//		UserCardInfoDO cardInfo = gasUserTestBase.findUserCardInfoByCardNo(order.getCardNo()).get(0);
//		//加好油用户信息
//		dal.model.gas_user.UserDO gasUserInfo = gasUserTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		//清结算用户信息
//		dal.model.user.UserDO userInfo = userTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		AccountDO accountDO = new AccountDO();
//		accountDO.setAccountNo(cardInfo.getAccountNo());
//		accountDO.setUserId(cardInfo.getUserId());
//		accountDO.setStatus("ACTIVE");
//		accountDO.setAccountType("NORMAL");
//		accountDO.setPayModel("111");
//		accountDO.setTag("GAS_DUMMY_DEFAULT");
//		accountDO.setMemo("加好油测试账户1");
//		accountDO.setRawAddTime(DateUtils.getSqlDate());
//		accountDO.setRawUpdateTime(DateUtils.getSqlDate());
//		accountDO.setBalance(10000L);
//		accountDO.setFreezeBalance(0L);
//		accountDO.setHisInAmount(10000L);
//		accountDO.setHisOutAmount(0L);
//		if (testId == 1001) {
//			userTestBase.updateAccountByAccountNo(cardInfo.getAccountNo(), accountDO);
//		}
//		//账户信息
//		AccountDO accountInfo = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//		//商户信息
//		GasMerchantDO merchantInfo = gasMerchantTestBase.findGasMerchantByPartnerId(applyOrder.getPartnerId()).get(0);
//		//操作员信息
//		GasMerchantUserDO operatorInfo = gasMerchantTestBase.findGasMerchantUserByUserId(applyOrder.getOperateId()).get(0);
//		//油站信息
//		GasMerchantStationDO stationInfo = gasMerchantTestBase.findGasMerchantStationByStationId(applyOrder.getStationId()).get(0);
//		String reqId = OID.newID();
//		String gid = GID.newGID();
//		applyOrder.setReqId(reqId);
//		tradeOilOrder.setCode("#95");
////		if (testId == 1003) {
////			tradeOilOrder.setAmount(new Money(151, 11));
////		}
//		List<TradeGoodsOrder> goodsOrders = new ArrayList<TradeGoodsOrder>();
//		goodsOrders.add(tradeGoodsOrder);
//		if (testId != 1003) {
//			applyOrder.setTradeOilOrder(tradeOilOrder);
//		}
//		applyOrder.setGoodsOrders(goodsOrders);
//		applyOrder.setGid(gid);
//		BizResult<TradePaymentInfo> applyResult = tradePaymentService.tradeApplyPayment(applyOrder);
//		// 测试过程
//		order.setTradeNo(applyResult.getInfo().getBizNo());
//		order.setReqId(reqId);
//		if (testId != 1001) {//会员非余额支付
//			order.setCardNo(null);
//		}
//		if (testId == 1003) {//非会员
//			order.setUserId(null);
//		}
//		order.setGid(gid);
//		// 调用接口
//		BizResult<TradePaymentInfo> result = tradePaymentService.tradeConfirmPayment(order);
//		sleep(3);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
//		GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByReqId(reqId).get(0);
//		if (testId == 1001) {//余额支付走收银台手动确认付款成功
//			PaymentInstructionDO paymentInstruction = payTestBase.findPaymentInstructionByReqId(paymentInfo.getRequestNo()).get(0);
//			UserDO user = userTestBase.findUserByUserId(gasUserBase.findUserCardInfoByCardNo(order.getCardNo()).get(0).getUserId()).get(0);
//			BalancePaymentConfirmOrder confirmOrder = new BalancePaymentConfirmOrder();
//			confirmOrder.setBizNo(paymentInstruction.getBizNo());
//			confirmOrder.setPassword("111111");
//			confirmOrder.setGid(GID.newGID());
//			confirmOrder.setMerchantOrderNo(OID.newID());
//			confirmOrder.setPartnerId(order.getPartnerId());
//			confirmOrder.setPlatMerchantOrderNo(OID.newID());
//			confirmOrder.setPlatPartnerId(order.getPartnerId());
//			confirmOrder.setReqId(paymentInfo.getRequestNo());
//			BizResult<PaymentInfo> paymentResult = balancePaymentService.confirm(confirmOrder);
//			System.out.println(paymentResult);
//			assertEquals(paymentResult.getStatus(), Status.SUCCESS);
//			sleep(3);
//		}
//		// 数据验证
//		AccountDO accountInfoxx = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//		//付款信息
//		GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByBizNo(applyResult.getInfo().getBizNo()).get(0);
//		assertEquals("PAYMENT", paymentInfo.getTradeType());
//		assertEquals(applyOrder.getOrderType().code(), paymentInfo.getOrderType());
//		//  assertEquals("PAYMENT", paymentInfo.getBizNo());
//		assertEquals(order.getReqId(), paymentInfo.getReqId());
//		assertEquals(order.getGid(), paymentInfo.getGid());
//		assertEquals(order.getPartnerId(), paymentInfo.getPartnerId());
//		assertEquals(merchantInfo.getPartnerName(), paymentInfo.getPartnerName());
//		assertEquals(applyOrder.getStationId(), paymentInfo.getStationId());
//		assertEquals(stationInfo.getStationCode(), paymentInfo.getStationCode());
//		assertEquals(stationInfo.getStationName(), paymentInfo.getStationName());
//		assertEquals(applyOrder.getOperateId(), paymentInfo.getOperateId());
//		assertEquals(operatorInfo.getUserName(), paymentInfo.getOperateName());
//		assertEquals(applyOrder.getTerminalType().code(), paymentInfo.getTerminalType());
//		assertEquals(applyOrder.getTerminalCode(), paymentInfo.getTerminalCode());
//		if (testId == 1003) {
//			assertEquals("000000000000000000", paymentInfo.getUserId());
//			// assertEquals(null, paymentInfo.getRealName());
//			assertEquals(null, paymentInfo.getNickName());
//			assertEquals(null, paymentInfo.getMemberType());
//			assertEquals(null, paymentInfo.getMobile());
//		} else {
//			assertEquals(cardInfo.getUserId(), paymentInfo.getUserId());
//			// assertEquals(userInfo.getRealName(), paymentInfo.getRealName());
//			assertEquals(gasUserInfo.getNickName(), paymentInfo.getNickName());
//			assertEquals(gasUserInfo.getMemberType(), paymentInfo.getMemberType());
//			assertEquals(gasUserInfo.getMobile(), paymentInfo.getMobile());
//		}
//		if (testId == 1001) {
//			assertEquals(order.getCardNo(), paymentInfo.getCardNo());
//			assertEquals(cardInfo.getCardType(), paymentInfo.getCardType());
//			assertEquals(cardInfo.getTag(), paymentInfo.getCardBizType());
//		} else {
//			assertEquals(null, paymentInfo.getCardNo());
//			assertEquals(null, paymentInfo.getCardType());
//			assertEquals(null, paymentInfo.getCardBizType());
//		}
////        assertEquals("PAYMENT", paymentInfo.getCarNumber());
////        assertEquals("PAYMENT", paymentInfo.getRequestNo());
////        assertEquals("PAYMENT", paymentInfo.getPayNo());
//		assertEquals(order.getTradePayType().code(), paymentInfo.getTradePayType());
//		assertEquals(order.getPayModel().code(), paymentInfo.getPayModel());
//		if (testId == 1001 || testId == 1002) {
//			assertEquals(tradeOilOrder.getAmount().add(tradeGoodsOrder.getAmount()), Money.cent(paymentInfo.getAmount()));
//			assertEquals(tradeOilOrder.getAmount().add(tradeGoodsOrder.getAmount()), Money.cent(paymentInfo.getPayAmount()));
//		} else {
//			assertEquals(tradeOilOrder.getAmount(), Money.cent(paymentInfo.getAmount()));
//			assertEquals(tradeOilOrder.getAmount(), Money.cent(paymentInfo.getPayAmount()));
//		}
//		assertEquals(new Money(0, 0), Money.cent(paymentInfo.getFavourAmount()));
//		//账户信息
//		if (testId == 1001) {
//			assertEquals(Money.cent(accountInfo.getBalance()).subtract(Money.cent(paymentInfo.getAmount())), Money.cent(accountInfoxx.getBalance()));
//			assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
//			assertEquals(Money.cent(accountInfo.getHisInAmount()), Money.cent(accountInfoxx.getHisInAmount()));
//			assertEquals(Money.cent(accountInfo.getHisOutAmount()).add(Money.cent(paymentInfo.getAmount())), Money.cent(accountInfoxx.getHisOutAmount()));
//		} else {
//			assertEquals(Money.cent(accountInfo.getBalance()), Money.cent(accountInfoxx.getBalance()));
//			assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
//			assertEquals(Money.cent(accountInfo.getHisInAmount()), Money.cent(accountInfoxx.getHisInAmount()));
//			assertEquals(Money.cent(accountInfo.getHisOutAmount()), Money.cent(accountInfoxx.getHisOutAmount()));
//		}
//		if (testId != 1001) {
//			assertEquals(new Money(0, 0), Money.cent(paymentInfoxx.getBalance()));
//		} else {
//			assertEquals(Money.cent(accountInfoxx.getBalance()), Money.cent(paymentInfoxx.getBalance()));
//		}
////        assertEquals("PAYMENT", paymentInfo.getMemo());
//		assertEquals("success", paymentInfoxx.getStatus());
//		assertEquals("finished", paymentInfoxx.getState());
//		assertEquals("comn_00_0000", paymentInfoxx.getCode());
//		assertEquals("付款成功", paymentInfoxx.getDescription());
//		assertEquals("付款流程结束", paymentInfoxx.getRunMemo());
////        assertEquals("PAYMENT", paymentInfo.getExpireTime());
////        assertEquals("PAYMENT", paymentInfo.getExtensionContext());
////        assertEquals("PAYMENT", paymentInfo.getFinishTime());
//		//油品信息
//		if (testId != 1003) {
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
//		List<GasTradeGoodsDO> goodsInfos = gasTradeTestBase.findGasTradeGoodsByTradeNo(paymentInfo.getBizNo());
//		for (GasTradeGoodsDO goodsInfo : goodsInfos) {
//			assertEquals(paymentInfo.getBizNo(), goodsInfo.getTradeNo());
////            assertEquals("PAYMENT", goodsInfo.getGoodsType());
//			assertEquals(tradeGoodsOrder.getCode(), goodsInfo.getCode());
////            assertEquals(goodsName, goodsInfo.getGoodsName());
////            assertEquals("PAYMENT", goodsInfo.getPrice());
////            assertEquals("PAYMENT", goodsInfo.getPiece());
//			assertEquals(tradeGoodsOrder.getAmount(), Money.cent(goodsInfo.getAmount()));
//		}
//		// 清除数据
//		gasTradeTestBase.cleanGasTradePaymentByBizNo(applyResult.getInfo().getBizNo());
//		gasTradeTestBase.cleanGasTradeGoodsByTradeNo(applyResult.getInfo().getBizNo());
//		gasTradeTestBase.cleanGasTradeOilByTradeNo(applyResult.getInfo().getBizNo());
//	}
//}
