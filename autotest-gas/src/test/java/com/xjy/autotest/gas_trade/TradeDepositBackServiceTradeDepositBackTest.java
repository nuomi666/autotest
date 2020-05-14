//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Sets;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.*;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.facade.silverbot.api.collect.enums.AccountChangeMode;
//import com.xyb.gas.facade.silverbot.api.collect.enums.AccountChangeType;
//import com.xyb.gas.facade.silverbot.api.collect.enums.PointChangeType;
//import com.xyb.gas.merchant.api.enums.*;
//import com.xyb.gas.merchant.api.facade.*;
//import com.xyb.gas.merchant.api.order.*;
//import com.xyb.gas.trade.api.enums.OrderType;
//import com.xyb.gas.trade.api.enums.TerminalType;
//import com.xyb.gas.trade.api.enums.TradePayModel;
//import com.xyb.gas.trade.api.info.TradeDepositBackPayInfo;
//import com.xyb.gas.trade.api.info.TradeDepositInfo;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeDepositBackOrder;
//import com.xyb.gas.trade.api.order.TradeDepositOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentOrder;
//import com.xyb.gas.trade.api.service.TradeDepositBackService;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.order.RegisterOrder;
//import com.xyb.promotion.api.coupon.enums.CouponStatus;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_merchant.GasMerchantStationDO;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import dal.model.gas_silverbolt.GasAccountChangeDO;
//import dal.model.gas_silverbolt.GasPointsChangeDO;
//import dal.model.gas_silverbolt.GasTradeOrderDO;
//import dal.model.gas_trade.GasTradeDepositBackDO;
//import dal.model.gas_trade.GasTradeDepositDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.promotion.CouponDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/22.
// */
//public class TradeDepositBackServiceTradeDepositBackTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    TradeDepositBackService tradeDepositBackService;
//
//	@Reference(version = "1.0")
//	TradeDepositService tradeDepositService;
//
//	@Reference(version = "1.0")
//	TradePaymentService tradePaymentService;
//
//
//	@Reference(version = "1.0")
//	UserService userService;
//
//	@Reference(version = "1.0")
//	MerchantService merchantService;
//
//	@Reference(version = "1.0")
//	MerchantUserService merchantUserService;
//
//	@Reference(version = "1.0")
//	DeviceResourceService deviceResourceService;
//
//	@Reference(version = "1.0")
//	MerchantStationService merchantStationService;
//
//	@Reference(version = "1.0")
//	UserLoginService userLoginService;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	@Autowired
//	Gas_tradeTestBase  gasTradeTestBase;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	PromotionTestBase promotionTestBase;
//
//	@Autowired
//	Gas_silverboltTestBase silverboltTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/tradeDepositBackServiceTradeDepositBackTestSuccess.csv")
//	@DisplayName("冲退--成功用例")
//	public void tradeDepositBackServiceTradeDepositBackTestSuccess(
//			// 基本参数
//			int testId,
//			Status tradeStatus,
//			Status refundStatus,
//			// 业务参数
//			//TradeDepositBackOrder order,
//			//加好油会员
//			//RegisterOrder gasOrder,
//			//xyb会员
//			//RegisterUserAndAccountOrder xybOrder,
//			//商户信息
//			//RegisterMerchantOrder merchantOrder,
//			//商户用户信息
//			//CreateMerchantUserOrder merchantUserOrder,
//			//终端信息
//			//AddDeviceResourceOrder deviceOrder,
//			//商户对应油站信息
//			//ManageMerchantStationOrder stationOrder,
//			TradeDepositOrder depositOrder,
//			TradeDepositBackOrder order,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		//gasUserTestBase.cleanUserByPartnerId("nuomi123456");
//		// 准备数据
//		//卡信息
//		UserCardInfoDO cardInfo = gasUserTestBase.findUserCardInfoByCardNo(depositOrder.getCardNo()).get(0);
//		//加好油用户信息
//		UserDO gasUserInfo = gasUserTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		//清结算用户信息
//		dal.model.user.UserDO userInfo = userTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		//账户信息
//		AccountDO accountInfo = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//		//商户信息
//		GasMerchantDO merchantInfo = gasMerchantTestBase.findGasMerchantByPartnerId(order.getPartnerId()).get(0);
//		//操作员信息
//		GasMerchantUserDO operatorInfo = new GasMerchantUserDO();
//		if (testId != 1005 && testId != 1006) {
//			operatorInfo = gasMerchantTestBase.findGasMerchantUserByUserId(order.getOperateId()).get(0);
//		}
//		//油站信息
//		GasMerchantStationDO stationInfo = new GasMerchantStationDO();
//		if (testId != 1005 && testId != 1006) {
//			stationInfo = gasMerchantTestBase.findGasMerchantStationByStationId(order.getStationId()).get(0);
//		}
//		//营销账户
//		AccountDO marketAccount = userTestBase.findAccountByUserId("S0301808271500000065").stream().filter(
//				(acc) -> ("gas_merchant_market_account_tag".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
//		//积分
//		promotionTestBase.cleanPointsByUserId(userInfo.getUserId());
//		PointsDO pointsDO = new PointsDO();
//		pointsDO.setPartnerId(order.getPartnerId());
//		pointsDO.setPlatPartnerId("S0301806081400000015");
//		pointsDO.setUserId(userInfo.getUserId());
//		pointsDO.setPoints(100L);
//		pointsDO.setHistoryAddPoints(100L);
//		pointsDO.setHistorySubtractPoints(0L);
//		pointsDO.setPointId(OID.newID());
//		pointsDO.setRawAddTime(DateUtils.getSqlDate());
//		pointsDO.setRawUpdateTime(DateUtils.getSqlDate());
//		promotionTestBase.insertPoints(pointsDO);
//		PointsDO points = promotionTestBase.findPointsByUserId(userInfo.getUserId()).get(0);
//		//券
//		promotionTestBase.cleanCouponByUserId(userInfo.getUserId());
//		//充值
//		depositOrder.setGid(GID.newGID());
//		depositOrder.setMerchantOrderNo(OID.newID());
//		depositOrder.setReqId(OID.newID());
//		BizResult<TradeDepositInfo> depositResult = tradeDepositService.tradeDeposit(depositOrder);
//		sleep(5);
//		print(depositResult);
//		assertEquals(tradeStatus, depositResult.getStatus());
//		GasTradeDepositDO depositInfo = gasTradeTestBase.findGasTradeDepositByBizNo(depositResult.getInfo().getBizNo()).get(0);
//
//		AccountDO marketAccountxx = userTestBase.findAccountByUserId("S0301808271500000065").stream().filter(
//				(acc) -> ("gas_merchant_market_account_tag".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
////		assertEquals("finished", depositInfo.getState());
////		assertEquals("success", depositInfo.getStatus());
////		assertEquals("comn_00_0000", depositInfo.getCode());
////		if (testId <= 1002) {
////			assertEquals(new Money(10, 0), Money.cent(depositInfo.getFavourAmount()));
////			assertEquals(Money.cent(marketAccount.getBalance()).subtract(Money.cent(depositInfo.getFavourAmount())), Money.cent(marketAccountxx.getBalance()));
////		} else {
////			assertEquals(new Money(0, 0), Money.cent(depositInfo.getFavourAmount()));
////		}
//		AccountDO accountInfo1 = userTestBase.findAccountByUserId(userInfo.getUserId()).get(0);
//		//优惠券、积分
//		PointsDO points1 = promotionTestBase.findPointsByUserId(userInfo.getUserId()).get(0);
////		assertEquals(points.getPoints().intValue() + 10, points1.getPoints().intValue());
////		assertEquals(points.getHistoryAddPoints().intValue() + 10, points1.getHistoryAddPoints().intValue());
////		assertEquals(points.getHistorySubtractPoints().intValue(), points1.getHistorySubtractPoints().intValue());
//		List<CouponDO> coupons = promotionTestBase.findCouponByUserId(userInfo.getUserId());
////		if (testId <= 1002) {
////			assertEquals(1, coupons.size());
////			for (CouponDO coupon : coupons) {
////				assertEquals("001imj6lhzd8s107pr00", coupon.getDefinitionId());
////				assertEquals(CouponStatus.TAKEN.toString(), coupon.getStatus());
////				assertEquals(order.getPartnerId(), coupon.getPartnerId());
////			}
////		} else {
////			assertEquals(0, coupons.size());
////		}
//		//付款用券
//		if (testId == 1002) {
//			TradeOilOrder tradeOilOrder = new TradeOilOrder();
//			tradeOilOrder.setAmount(new Money(150, 00));
//			tradeOilOrder.setCode("#95");
//			tradeOilOrder.setOilGun("sasa3232");
//			List<String> favourIds = Lists.newArrayList();
//			String couponsId = coupons.get(0).getCouponId();
//			favourIds.add(couponsId);
//			TradePaymentOrder payOrder = new TradePaymentOrder();
//			payOrder.setPartnerId(merchantInfo.getPartnerId());
//			payOrder.setUserId(userInfo.getUserId());
//			payOrder.setCardNo(depositOrder.getCardNo());
//			payOrder.setPayModel(TradePayModel.BALANCE);
//			payOrder.setTradePayType(com.xyb.gas.trade.api.enums.TradePayType.REMAINING);
//			payOrder.setOrderType(OrderType.OIL);
//			payOrder.setStationId("001if9yazl84g025eh00");
//			payOrder.setTerminalType(TerminalType.POS);
//			payOrder.setTerminalCode("d01254");
//			payOrder.setOperateId("001if9yav9ikg025eh00");
//			payOrder.setTradeOilOrder(tradeOilOrder);
//			payOrder.setFavourIds(favourIds);
//			payOrder.setGid(GID.newGID());
//			payOrder.setMerchantOrderNo(OID.newID());
//			payOrder.setReqId(OID.newID());
//			BizResult<TradePaymentInfo> payResult = tradePaymentService.tradePayment(payOrder);
//			sleep(3);
//			print(payResult);
//			assertEquals(Status.PROCESSING, payResult.getStatus());
//			CouponDO coupons2 = promotionTestBase.findCouponByUserId(userInfo.getUserId()).get(0);
//			assertEquals(CouponStatus.LOCKED.toString(), coupons2.getStatus());
//		}
//		//分析系统
//		silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
////		silverboltTestBase.cleanGasTradeFavourByBizNo();
////		silverboltTestBase.cleanGasTradeOrderByBizNo();
//		silverboltTestBase.cleanGasUserByUserId(userInfo.getUserId());
//		// 测试过程
//		order.setDepositNo(depositResult.getInfo().getBizNo());
//		order.setGid(GID.newGID());
//		order.setMerchantOrderNo(OID.newID());
//		order.setReqId(OID.newID());
//		// 调用接口
//		BizResult<TradeDepositBackPayInfo> result = tradeDepositBackService.tradeDepositBack(order);
//		sleep(3);
//		// 结果验证
//		print(result);
//		assertEquals(refundStatus, result.getStatus());
//		// 数据验证
//		//充值
//		GasTradeDepositDO depositInfoxx = gasTradeTestBase.findGasTradeDepositByBizNo(depositResult.getInfo().getBizNo()).get(0);
//		assertEquals("refunded", depositInfoxx.getState());
//		assertEquals("success", depositInfoxx.getStatus());
//		assertEquals("comn_00_0000", depositInfoxx.getCode());
//		//充退
//		GasTradeDepositBackDO depositBackInfo = gasTradeTestBase.findGasTradeDepositBackByDepositNo(depositResult.getInfo().getBizNo()).get(0);
//		assertEquals("finished", depositBackInfo.getState());
//		assertEquals("success", depositBackInfo.getStatus());
//		assertEquals("comn_00_0000", depositBackInfo.getCode());
//		//资金校验
//		AccountDO accountInfoxx = userTestBase.findAccountByUserId(gasUserTestBase.findUserCardInfoByCardNo(depositOrder.getCardNo()).get(0).getUserId()).get(0);
//		assertEquals(Money.cent(accountInfo.getBalance()), Money.cent(accountInfoxx.getBalance()));
//		assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
////			assertEquals(Money.cent(accountInfo.getHisInAmount()).add(depositOrder.getPayAmount()), Money.cent(accountInfoxx.getHisInAmount()));
////			assertEquals(Money.cent(accountInfo.getHisOutAmount()).add(depositOrder.getPayAmount()), Money.cent(accountInfoxx.getHisOutAmount()));
//
//		AccountDO accountoo = userTestBase.findAccountByUserId("S0301808271500000065").stream().filter(
//				(acc) -> ("gas_merchant_market_account_tag".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
//		assertEquals(marketAccount.getBalance(), accountoo.getBalance());
//		//优惠券、积分
//		PointsDO pointsxx = promotionTestBase.findPointsByUserId(userInfo.getUserId()).get(0);
//		assertEquals(points.getPoints().intValue(), pointsxx.getPoints().intValue());
////		assertEquals(points.getHistoryAddPoints().intValue() + 10, pointsxx.getHistoryAddPoints().intValue());
////		assertEquals(points.getHistorySubtractPoints().intValue() + 10, pointsxx.getHistorySubtractPoints().intValue());
//		List<CouponDO> couponsxx = promotionTestBase.findCouponByUserId(userInfo.getUserId());
//		if (testId == 1001) {
//			assertEquals(1, couponsxx.size());
//			for (CouponDO coupon : couponsxx) {
//				assertEquals("001imj6lhzd8s107pr00", coupon.getDefinitionId());
//				assertEquals(CouponStatus.RETURNED.toString(), coupon.getStatus());
//				assertEquals(order.getPartnerId(), coupon.getPartnerId());
//			}
//		} else if (testId == 1002) {
//			assertEquals(1, couponsxx.size());
//			for (CouponDO coupon : couponsxx) {
//				assertEquals("001imj6lhzd8s107pr00", coupon.getDefinitionId());
//				assertEquals(CouponStatus.LOCKED.toString(), coupon.getStatus());
//				assertEquals(order.getPartnerId(), coupon.getPartnerId());
//			}
//		} else {
//			assertEquals(0, coupons.size());
//		}
//		//分析系统
//		//账户变动表
//		List<GasAccountChangeDO> accountChanges = silverboltTestBase.findGasAccountChangeByUserId(userInfo.getUserId());
//		if (testId <= 1002) {//有赠送信息的
//			assertEquals(2, accountChanges.size());
//			for (GasAccountChangeDO accountChange : accountChanges) {
//				assertEquals(depositBackInfo.getPartnerId(), accountChange.getPartnerId());
//				assertEquals(depositBackInfo.getStationId(), accountChange.getStationId());
//				assertEquals(depositBackInfo.getStationName(), accountChange.getStationName());
//				assertEquals(depositBackInfo.getOperateId(), accountChange.getOperateId());
//				assertEquals(depositBackInfo.getOperateName(), accountChange.getOperateName());
//				assertEquals(depositBackInfo.getTerminalType(), accountChange.getTerminalType());
//				assertEquals(depositBackInfo.getTerminalCode(), accountChange.getTerminalCode());
//				assertEquals(depositBackInfo.getRealName(), accountChange.getRealName());
//				assertEquals(depositBackInfo.getNickName(), accountChange.getNickName());
//				assertEquals(depositBackInfo.getMemberType(), accountChange.getMemberType());
//				assertEquals(depositBackInfo.getMobile(), accountChange.getMobile());
//				if (AccountChangeType.DEPOSIT_REFUND.code().equals(accountChange.getChangeType())) {
//					assertEquals(AccountChangeMode.OUT.code(), accountChange.getChangeMode());
//					assertEquals(depositBackInfo.getPayAmount(), accountChange.getAmount());
//					assertEquals(depositBackInfo.getPartnerName(), accountChange.getPartnerName());
//					assertEquals(depositBackInfo.getStationCode(), accountChange.getStationCode());
//				}
//				if (AccountChangeType.PRESENT_REFUND.code().equals(accountChange.getChangeType())) {
//					assertEquals(AccountChangeMode.OUT.code(), accountChange.getChangeMode());
//					assertEquals(depositInfo.getFavourAmount(), accountChange.getAmount());
//					assertEquals(null, accountChange.getPartnerName());
//					assertEquals(null, accountChange.getStationCode());
//				}
////			assertEquals(depositInfo.getAmount(), accountChange.getMemo());
////			assertEquals(depositInfo.getAmount(), accountChange.getChangeTime());
//			}
//		} else {
//			assertEquals(1, accountChanges.size());
//			for (GasAccountChangeDO accountChange : accountChanges) {
//				assertEquals(depositBackInfo.getPartnerId(), accountChange.getPartnerId());
//				assertEquals(depositBackInfo.getPartnerName(), accountChange.getPartnerName());
//				assertEquals(depositBackInfo.getStationId(), accountChange.getStationId());
//				assertEquals(depositBackInfo.getStationCode(), accountChange.getStationCode());
//				assertEquals(depositBackInfo.getStationName(), accountChange.getStationName());
//				assertEquals(depositBackInfo.getOperateId(), accountChange.getOperateId());
//				assertEquals(depositBackInfo.getOperateName(), accountChange.getOperateName());
//				assertEquals(depositBackInfo.getTerminalType(), accountChange.getTerminalType());
//				assertEquals(depositBackInfo.getTerminalCode(), accountChange.getTerminalCode());
//				assertEquals(depositBackInfo.getRealName(), accountChange.getRealName());
//				assertEquals(depositBackInfo.getNickName(), accountChange.getNickName());
//				assertEquals(depositBackInfo.getMemberType(), accountChange.getMemberType());
//				assertEquals(depositBackInfo.getMobile(), accountChange.getMobile());
//				assertEquals(depositBackInfo.getPayAmount(), accountChange.getAmount());
//				assertEquals(depositBackInfo.getPartnerName(), accountChange.getPartnerName());
//				assertEquals(depositBackInfo.getStationCode(), accountChange.getStationCode());
//				if (AccountChangeType.DEPOSIT_REFUND.code().equals(accountChange.getChangeType())) {
//					assertEquals(AccountChangeMode.OUT.code(), accountChange.getChangeMode());
//				}
////			assertEquals(depositInfo.getAmount(), accountChange.getMemo());
////			assertEquals(depositInfo.getAmount(), accountChange.getChangeTime());
//			}
//		}
//		//积分变动
//		List<GasPointsChangeDO> pointsChanges = silverboltTestBase.findGasPointsChangeByUserId(userInfo.getUserId());
//		assertEquals(1, pointsChanges.size());
//		for (GasPointsChangeDO pointsChange : pointsChanges) {
//			assertEquals(depositBackInfo.getPartnerId(), pointsChange.getPartnerId());
//			assertEquals(null, pointsChange.getPartnerName());
//			assertEquals(depositBackInfo.getStationId(), pointsChange.getStationId());
//			assertEquals(null, pointsChange.getStationCode());
//			assertEquals(depositBackInfo.getStationName(), pointsChange.getStationName());
//			assertEquals(depositBackInfo.getOperateId(), pointsChange.getOperateId());
//			assertEquals(depositBackInfo.getOperateName(), pointsChange.getOperateName());
//			assertEquals(depositBackInfo.getTerminalType(), pointsChange.getTerminalType());
//			assertEquals(depositBackInfo.getTerminalCode(), pointsChange.getTerminalCode());
//			assertEquals(depositBackInfo.getRealName(), pointsChange.getRealName());
//			assertEquals(depositBackInfo.getNickName(), pointsChange.getNickName());
//			assertEquals(depositBackInfo.getMemberType(), pointsChange.getMemberType());
//			assertEquals(depositBackInfo.getMobile(), pointsChange.getMobile());
//			assertEquals(PointChangeType.PRESENT_REVOKE.code(), pointsChange.getChangeType());
//			assertEquals(AccountChangeMode.OUT.code(), pointsChange.getChangeMode());
//			assertEquals(10L, pointsChange.getPoints());
////			assertEquals(depositInfo.getAmount(), accountChange.getMemo());
////			assertEquals(depositInfo.getAmount(), accountChange.getChangeTime());
//		}
//		//交易订单
//		List<GasTradeOrderDO> tradeOrders = silverboltTestBase.findGasTradeOrderByBizNo(result.getInfo().getBizNo());
//		assertEquals(1, tradeOrders.size());
//		for (GasTradeOrderDO tradeOrder : tradeOrders) {
//			assertEquals(depositBackInfo.getTradeType(), tradeOrder.getTradeType());
//			assertEquals(null, tradeOrder.getOrderType());
//			assertEquals(depositBackInfo.getReqId(), tradeOrder.getReqId());
//			assertEquals(depositBackInfo.getGid(), tradeOrder.getGid());
//			assertEquals(depositResult.getInfo().getBizNo(), tradeOrder.getTradeNo());//冲退、退款的原流水号
//			assertEquals(depositBackInfo.getPartnerId(), tradeOrder.getPartnerId());
//			assertEquals(depositBackInfo.getPartnerName(), tradeOrder.getPartnerName());
//			assertEquals(depositBackInfo.getStationId(), tradeOrder.getStationId());
//			assertEquals(depositBackInfo.getStationCode(), tradeOrder.getStationCode());
//			assertEquals(depositBackInfo.getStationName(), tradeOrder.getStationName());
//			assertEquals(depositBackInfo.getOperateId(), tradeOrder.getOperateId());
//			assertEquals(depositBackInfo.getOperateName(), tradeOrder.getOperateName());
//			assertEquals(depositBackInfo.getTerminalType(), tradeOrder.getTerminalType());
//			assertEquals(depositBackInfo.getTerminalCode(), tradeOrder.getTerminalCode());
//			assertEquals(depositBackInfo.getRealName(), tradeOrder.getRealName());
//			assertEquals(depositBackInfo.getNickName(), tradeOrder.getNickName());
//			assertEquals(depositBackInfo.getMemberType(), tradeOrder.getMemberType());
//			assertEquals(depositBackInfo.getMobile(), tradeOrder.getMobile());
//			assertEquals(depositOrder.getCardNo(), tradeOrder.getCardNo());
//			assertEquals(cardInfo.getTag(), tradeOrder.getCardBizType());
//			assertEquals(cardInfo.getCardType(), tradeOrder.getCardType());
//			assertEquals(null, tradeOrder.getCarNumber());
//			assertEquals(depositBackInfo.getBalance(), tradeOrder.getBalance());
//			assertEquals(null, tradeOrder.getOilType());
//			assertEquals(null, tradeOrder.getOilCode());
//			assertEquals(null, tradeOrder.getOilName());
//			assertEquals(0L, tradeOrder.getOilAmount());
//			assertEquals(0L, tradeOrder.getOilFavourAmount());
//			assertEquals(0L, tradeOrder.getGoodsAmount());
//			assertEquals(0L, tradeOrder.getGoodsFavourAmount());
//			assertEquals(depositBackInfo.getPayNo(), tradeOrder.getPayNo());
//			assertEquals(depositOrder.getTradePayType().code(), tradeOrder.getTradePayType());
//			assertEquals(depositOrder.getPayModel().code(), tradeOrder.getPayModel());
//			assertEquals(depositBackInfo.getAmount(), tradeOrder.getAmount());
//			assertEquals(depositBackInfo.getPayAmount(), tradeOrder.getPayAmount());
//			assertEquals(0L, tradeOrder.getFavourAmount());
//			assertEquals(depositBackInfo.getStatus(), tradeOrder.getStatus());
//			assertEquals(depositBackInfo.getState(), tradeOrder.getState());
////			assertEquals(depositInfo.getAmount(), tradeOrder.getMemo());
////			assertEquals(depositInfo.getAmount(), tradeOrder.getChangeTime());
//		}
//		// 清除数据
////		gasUserTestBase.cleanUserByPartnerId(partnerId);
////		gasMerchantTestBase.cleanGasMerchantByPartnerId(partnerId);
////		gasMerchantTestBase.cleanGasDevicePrintByStationId("oil0254555");
////		gasMerchantTestBase.cleanGasDeviceResourceById(device.getId());
//		gasTradeTestBase.cleanGasTradeDepositByReqId(depositOrder.getReqId());
//		gasTradeTestBase.cleanGasTradePaymentByCardNo(depositOrder.getCardNo());
//		gasTradeTestBase.cleanGasTradeDepositBackByDepositNo(depositResult.getInfo().getBizNo());
//		gasTradeTestBase.cleanGasTradeNotifyTaskByBizNo(depositResult.getInfo().getBizNo());
//		gasTradeTestBase.cleanGasTradeNotifyTaskByBizNo(result.getInfo().getBizNo());
//		promotionTestBase.cleanCouponByUserId(userInfo.getUserId());
//		promotionTestBase.cleanPointsByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasTradeFavourByBizNo(result.getInfo().getBizNo());
//		silverboltTestBase.cleanGasTradeFavourByBizNo(depositResult.getInfo().getBizNo());
//		silverboltTestBase.cleanGasTradeOrderByBizNo(result.getInfo().getBizNo());
//		silverboltTestBase.cleanGasTradeOrderByBizNo(depositResult.getInfo().getBizNo());
//		silverboltTestBase.cleanGasUserByUserId(userInfo.getUserId());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/tradeDepositBackServiceTradeDepositBackTestSuccess2.csv")
//	@DisplayName("--成功用例")
//	public void tradeDepositBackServiceTradeDepositBackTestSuccess2(
//			// 基本参数
//			int testId,
//			// 业务参数
//			TradeDepositBackOrder order,
//			//充值订单
//			GasTradeDepositDO depositDO,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		gasTradeTestBase.cleanGasTradeDepositByBizNo(depositDO.getBizNo());
//		gasTradeTestBase.cleanGasTradeDepositBackByBizNo("001ifdzrrpcwg035ej00");
//		// 准备数据
////		TradeDepositOrder depositOrder=new TradeDepositOrder();
////		BizResult<TradeDepositInfo> depositResult =tradeDepositService.tradeDeposit(depositOrder);
////		assertResult(testId, Status.SUCCESS,code,depositResult);
////		String depositNo=depositResult.getInfo().getBizNo();
//		// 测试过程
//		//TradeDepositBackOrder order=new TradeDepositBackOrder();
//		order.setReqId(OID.newID());
//		order.setDepositNo("001igxatdci0g035ej00");
////		order.setTerminalType(TerminalType.POS);
////		order.setTerminalCode("d01254");
//		//order.setOperateId("001iexgfhdj4g025eh00");
////		order.setStationId("001iexde9rhog025eh00");
//		// 调用接口
//		BizResult<TradeDepositBackPayInfo> result = tradeDepositBackService.tradeDepositBack(order);
//		assertResult(testId, Status.SUCCESS, code, result);
//		// 结果验证
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/tradeDepositBackServiceTradeDepositBackTestPre.csv")
//	@DisplayName("冲退--成功用例")
//	public void tradeDepositBackServiceTradeDepositBackTestPre(
//			// 基本参数
//			int testId,
//			Status tradeStatus,
//			Status refundStatus,
//			// 业务参数
//			//TradeDepositBackOrder order,
//			//加好油会员
//			//RegisterOrder gasOrder,
//			//xyb会员
//			//RegisterUserAndAccountOrder xybOrder,
//			//商户信息
//			//RegisterMerchantOrder merchantOrder,
//			//商户用户信息
//			//CreateMerchantUserOrder merchantUserOrder,
//			//终端信息
//			//AddDeviceResourceOrder deviceOrder,
//			//商户对应油站信息
//			//ManageMerchantStationOrder stationOrder,
//			TradeDepositOrder depositOrder,
//			TradeDepositBackOrder order,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		//gasUserTestBase.cleanUserByPartnerId("nuomi123456");
//		// 准备数据
//		String gid = "ovxhygsdf0125478541254785425478965d";
//		//创建终端资源
//		AddDeviceResourceOrder deviceOrder = new AddDeviceResourceOrder();
//		deviceOrder.setDeviceType(DeviceType.POS);
//		deviceOrder.setResourceType(ResourceType.FUNCTION);
//		deviceOrder.setName("ast");
//		deviceOrder.setCode("d01254");
//		deviceOrder.setGid(gid);
////		SimpleResult deviceResult=deviceResourceService.add(deviceOrder);
////		assertResult(testId, Status.SUCCESS,code,deviceResult);
////		GasDeviceResourceDO device=gasMerchantTestBase.findGasDeviceResourceByName("ast").get(0);
//		//创建商户
//		RegisterMerchantOrder merchantOrder = new RegisterMerchantOrder();
//		merchantOrder.setPartnerName("糯米商");
//		merchantOrder.setMobileNo("15215046789");
//		merchantOrder.setStatus(EnableStatus.ABLE);
//		//merchantOrder.setOilStatus(EnableStatus.ABLE);
//		merchantOrder.setSourceType(SourceType.WeChat);
//		merchantOrder.setSourceKey("nuomi");
//		merchantOrder.setGid(gid);
////		RegisterMerchantResult merchantResult=merchantService.register(merchantOrder);
////		assertResult(testId, Status.SUCCESS,code,merchantResult);
////		String partnerId=merchantResult.getInfo().getPartnerId();
//		//创建角色
//		CreateRoleOrder roleOrder = new CreateRoleOrder();
//		Set<Long> resourceIds = Sets.newHashSet();
//		resourceIds.add(5L);
//		//roleOrder.setPartnerId("S0301808271900000152");
//		roleOrder.setRoleName("糯米");
//		roleOrder.setGid(gid);
//		//如果需要登录，传入资源id
//		roleOrder.setResourceIds(resourceIds);
////		SimpleResult roleResult=merchantUserService.createRole(roleOrder);
////		assertResult(testId, Status.SUCCESS,code,roleResult);
////		Long role= gasMerchantTestBase.findGasMerchantRoleByPartnerId(partnerId).get(0).getId();
//		//配置终端
//		RelationMerchantDeviceOrder relationOrder = new RelationMerchantDeviceOrder();
//		Set<String> deviceCodes = Sets.newHashSet();
//		deviceCodes.add("d01254");
//		relationOrder.setPartnerId("S0301808271900000152");
//		relationOrder.setDeviceCodes(deviceCodes);
//		relationOrder.setDeviceType(DeviceType.POS);
//		relationOrder.setGid(gid);
////		SimpleResult relationResult=merchantService.relationDevice(relationOrder);
////		assertResult(testId, Status.SUCCESS,code,relationResult);
//		//创建商户用户
//		CreateMerchantUserOrder merchantUserOrder = new CreateMerchantUserOrder();
//		//merchantUserOrder.setUserType(UserType.BOSS);
//		merchantUserOrder.setUserName("nuomi@xyb.com");
//		merchantUserOrder.setPartnerId("S0301808271900000152");
//		merchantUserOrder.setMobileNo("15215046789");
//		merchantUserOrder.setPassword("123456");
//		//merchantUserOrder.setRoleCode("");
//		merchantUserOrder.setGid(gid);
////		SimpleResult merchantUserResult=merchantUserService.createUser(merchantUserOrder);
////		assertResult(testId, Status.SUCCESS,code,merchantUserResult);
////		String userId=gasMerchantTestBase.findGasMerchantUserByPartnerId("S0301808271900000152").get(0).getUserId();
//		//创建油站
//		ManageMerchantStationOrder stationOrder = new ManageMerchantStationOrder();
//		stationOrder.setPartnerId("S0301808271900000152");
//		stationOrder.setStationName("高家镇加油站");
//		stationOrder.setStationCode("jhy058745");
//		stationOrder.setStatus(EnableStatus.ABLE);
//		stationOrder.setPhoneNo("13315046789");
//		stationOrder.setProvinceId(500000L);
//		stationOrder.setDistrictId(500230L);
//		stationOrder.setCityId(310200L);
//		stationOrder.setStationAddress("重庆市丰都县高家镇加油站");
//		//stationOrder.setUserId(userId);
//		stationOrder.setGid(gid);
////		SimpleResult stationResult=merchantStationService.manage(stationOrder);
////		assertResult(testId, Status.SUCCESS,code,stationResult);
//		//jhy用户注册
//		RegisterOrder gasOrder = new RegisterOrder();
//		gasOrder.setMobile("15215046789");
//		gasOrder.setPartnerId("S0301808241500000146");
//		gasOrder.setOpenId("nuomi");
//		gasOrder.setGid(gid);
////		SimpleResult gasResult=userService.register(gasOrder);
////		assertResult(testId, Status.SUCCESS,code,gasResult);
//		//登录pos机
//		UserLoginPosOrder loginOrder = new UserLoginPosOrder();
//		loginOrder.setAccount("15215046789");
//		loginOrder.setPassword("123456");
//		loginOrder.setDeviceCode("d01254");
//		loginOrder.setGid(gid);
////		UserLoginResult loginResult=userLoginService.login(loginOrder);
////		assertResult(testId, Status.SUCCESS,code,loginResult);
//	}
//}
