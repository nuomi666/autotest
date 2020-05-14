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
//import com.xyb.gas.facade.silverbot.api.collect.enums.AccountChangeMode;
//import com.xyb.gas.facade.silverbot.api.collect.enums.AccountChangeType;
//import com.xyb.gas.facade.silverbot.api.collect.enums.PointChangeType;
//import com.xyb.gas.trade.api.enums.TerminalType;
//import com.xyb.gas.trade.api.enums.TradePayModel;
//import com.xyb.gas.trade.api.enums.TradePayType;
//import com.xyb.gas.trade.api.enums.TradeType;
//import com.xyb.gas.trade.api.info.TradeDepositInfo;
//import com.xyb.gas.trade.api.order.TradeDepositOrder;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_merchant.GasMerchantStationDO;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import dal.model.gas_silverbolt.GasAccountChangeDO;
//import dal.model.gas_silverbolt.GasPointsChangeDO;
//import dal.model.gas_silverbolt.GasTradeOrderDO;
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
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/22.
// */
//public class TradeDepositServiceTradeDepositTest extends SpringBootTestBase{
//
//	@Reference(version = "1.0")
//    TradeDepositService tradeDepositService;
//
//	@Autowired
//	UserTestBase userTestBase;
//
//	@Autowired
//	Gas_userTestBase gasUserTestBase;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	@Autowired
//	Gas_tradeTestBase gasTradeTestBase;
//
//	@Autowired
//	PromotionTestBase promotionTestBase;
//
//	@Autowired
//	Gas_silverboltTestBase silverboltTestBase;
//	/**
//	 *ALI渠道的有公众号和条码两种支付方式；WEIXIN的有公众号和扫码、条码三种支付方式；
//	 * UNION有Pos机刷卡和走线下两种方式；CASH只有线下支付方式。线下通过ACCOUNT方式记录。
//	 * 充值没有REMAINING支付方式
//	 */
//	@AutoTest(file = "gas_trade/tradeDepositServiceTradeDepositTestSuccess.csv")
//	@DisplayName("充值--成功用例")
//	public void tradeDepositServiceTradeDepositTestSuccess(
//			// 基本参数
//			int testId,
//			Status status,
//			// 业务参数
//			TradeDepositOrder order,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		silverboltTestBase.cleanGasAccountChangeByUserId(order.getUserIp());
//		// 准备数据
//		//卡信息
//		UserCardInfoDO cardInfo=gasUserTestBase.findUserCardInfoByCardNo(order.getCardNo()).get(0);
//		//加好油用户信息
//		UserDO gasUserInfo=gasUserTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		//清结算用户信息
//		dal.model.user.UserDO userInfo=userTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		//账户信息
//		AccountDO accountInfo=userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//		//商户信息
//		GasMerchantDO merchantInfo=gasMerchantTestBase.findGasMerchantByPartnerId(order.getPartnerId()).get(0);
//		//操作员信息
//		GasMerchantUserDO operatorInfo=new GasMerchantUserDO();
//		if (testId != 1005 && testId != 1006) {
//			operatorInfo = gasMerchantTestBase.findGasMerchantUserByUserId(order.getOperateId()).get(0);
//		}
//		//油站信息
//		GasMerchantStationDO stationInfo=new GasMerchantStationDO();
//		if (testId != 1005 && testId != 1006) {
//			stationInfo = gasMerchantTestBase.findGasMerchantStationByStationId(order.getStationId()).get(0);
//		}
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
//		//分析系统
//		silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
////		silverboltTestBase.cleanGasTradeFavourByBizNo();
////		silverboltTestBase.cleanGasTradeOrderByBizNo();
//		silverboltTestBase.cleanGasUserByUserId(userInfo.getUserId());
//		// 测试过程
//		order.setReqId(OID.newID());
//		order.setGid(GID.newGID());
//		order.setReqId(OID.newID());
//		order.setMerchantOrderNo(OID.newID());
//		// 调用接口
//		BizResult<TradeDepositInfo> result = tradeDepositService.tradeDeposit(order);
//		// 结果验证
//		sleep(3);
//		print(result);
//		assertEquals(status, result.getStatus());
//		// 数据验证
//		GasTradeDepositDO depositInfo = gasTradeTestBase.findGasTradeDepositByReqId(order.getReqId()).get(0);
//		TradeDepositInfo depositInfos=result.getInfo();
//		assertEquals(TradeType.DEPOSIT.code(),depositInfo.getTradeType());
//		//assertEquals(order.getPayAmount(),depositInfo.getBizNo());
//		assertEquals(order.getReqId(),depositInfo.getReqId());
//		assertEquals(order.getGid(),depositInfo.getGid());
//		assertEquals(order.getPartnerId(),depositInfo.getPartnerId());
//		assertEquals(merchantInfo.getPartnerName(),depositInfo.getPartnerName());
//		assertEquals(stationInfo.getStationCode(),depositInfo.getStationCode());
//		assertEquals(order.getStationId(),depositInfo.getStationId());
//		assertEquals(stationInfo.getStationName(),depositInfo.getStationName());
//		assertEquals(order.getOperateId(),depositInfo.getOperateId());
//		assertEquals(operatorInfo.getUserName(),depositInfo.getOperateName());
//		assertEquals(order.getTradePayType().code(), depositInfo.getTradePayType());
//		assertEquals(order.getTerminalCode(),depositInfo.getTerminalCode());
//		assertEquals(cardInfo.getUserId(),depositInfo.getUserId());
//		//assertEquals(userInfo.getRealName(),depositInfo.getRealName());
//		assertEquals(gasUserInfo.getMobile(),depositInfo.getMobile());
//		assertEquals(gasUserInfo.getNickName(),depositInfo.getNickName());
//		assertEquals(gasUserInfo.getMemberType(),depositInfo.getMemberType());
//		assertEquals(order.getCardNo(), depositInfo.getCardNo());
//		assertEquals(cardInfo.getCardType(),depositInfo.getCardType());
//		assertEquals(cardInfo.getTag(),depositInfo.getCardBizType());
//		assertEquals(Money.cent(accountInfo.getBalance()).subtract(Money.cent(accountInfo.getFreezeBalance())).add(order.getPayAmount()), Money.cent(depositInfo.getBalance()));
//		//assertEquals(order.getPayAmount(),depositInfo.getRequestNo());
//		//assertEquals(order.getAmount(),depositInfo.getPayNo());
//		assertEquals(order.getPayModel().code(), depositInfo.getPayModel());
//		assertEquals(order.getPayAmount(), Money.cent(depositInfo.getPayAmount()));
//		//配置的规则是金额大于等于110送金额10，大于等于102送券id:001imj6lhzd8s107pr00，大于等于100送积分10
//		if (testId <= 1002) {
//			assertEquals(new Money(10, 0), Money.cent(depositInfo.getFavourAmount()));
//		} else {
//			assertEquals(new Money(0, 0), Money.cent(depositInfo.getFavourAmount()));
//		}
//		assertEquals(Money.cent(depositInfo.getFavourAmount()).add(order.getPayAmount()), Money.cent(depositInfo.getAmount()));
//		//assertEquals("充值",depositInfo.getMemo());
//		assertEquals("success",depositInfo.getStatus());
//		assertEquals("finished",depositInfo.getState());
//		assertEquals("comn_00_0000",depositInfo.getCode());
//		assertEquals("充值成功", depositInfo.getDescription());
//		assertEquals("充值流程结束", depositInfo.getRunMemo());
////		assertEquals(order.getPayAmount(),depositInfo.getFinishTime());
////		assertEquals(order.getPayAmount(),depositInfo.getRawAddTime());
////		assertEquals(order.getPayAmount(),depositInfo.getRawUpdateTime());
//		//积分
//		PointsDO pointsxx = promotionTestBase.findPointsByUserId(userInfo.getUserId()).get(0);
//		assertEquals(points.getPoints().intValue() + 10, pointsxx.getPoints().intValue());
//		assertEquals(points.getHistoryAddPoints().intValue() + 10, pointsxx.getHistoryAddPoints().intValue());
//		assertEquals(points.getHistorySubtractPoints().intValue(), pointsxx.getHistorySubtractPoints().intValue());
//		//券
//		List<CouponDO> coupons = promotionTestBase.findCouponByUserId(userInfo.getUserId());
//		if (testId <= 1003) {
//			assertEquals(1, coupons.size());
//			for (CouponDO coupon : coupons) {
//				assertEquals("001imj6lhzd8s107pr00", coupon.getDefinitionId());
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
//				assertEquals(depositInfo.getPartnerId(), accountChange.getPartnerId());
//				assertEquals(depositInfo.getStationId(), accountChange.getStationId());
//				assertEquals(depositInfo.getStationName(), accountChange.getStationName());
//				assertEquals(depositInfo.getOperateId(), accountChange.getOperateId());
//				assertEquals(depositInfo.getOperateName(), accountChange.getOperateName());
//				assertEquals(depositInfo.getTerminalType(), accountChange.getTerminalType());
//				assertEquals(depositInfo.getTerminalCode(), accountChange.getTerminalCode());
//				assertEquals(depositInfo.getRealName(), accountChange.getRealName());
//				assertEquals(depositInfo.getNickName(), accountChange.getNickName());
//				assertEquals(depositInfo.getMemberType(), accountChange.getMemberType());
//				assertEquals(depositInfo.getMobile(), accountChange.getMobile());
//				assertEquals(AccountChangeMode.IN.code(), accountChange.getChangeMode());
//				if (AccountChangeType.DEPOSIT.code().equals(accountChange.getChangeType())) {
//					assertEquals(depositInfo.getPayAmount(), accountChange.getAmount());
//					assertEquals(depositInfo.getPartnerName(), accountChange.getPartnerName());
//					assertEquals(depositInfo.getStationCode(), accountChange.getStationCode());
//				} else {
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
//				assertEquals(depositInfo.getPartnerId(), accountChange.getPartnerId());
//				assertEquals(depositInfo.getPartnerName(), accountChange.getPartnerName());
//				assertEquals(depositInfo.getStationId(), accountChange.getStationId());
//				assertEquals(depositInfo.getStationCode(), accountChange.getStationCode());
//				assertEquals(depositInfo.getStationName(), accountChange.getStationName());
//				assertEquals(depositInfo.getOperateId(), accountChange.getOperateId());
//				assertEquals(depositInfo.getOperateName(), accountChange.getOperateName());
//				assertEquals(depositInfo.getTerminalType(), accountChange.getTerminalType());
//				assertEquals(depositInfo.getTerminalCode(), accountChange.getTerminalCode());
//				assertEquals(depositInfo.getRealName(), accountChange.getRealName());
//				assertEquals(depositInfo.getNickName(), accountChange.getNickName());
//				assertEquals(depositInfo.getMemberType(), accountChange.getMemberType());
//				assertEquals(depositInfo.getMobile(), accountChange.getMobile());
//				assertEquals(AccountChangeType.DEPOSIT.code(), accountChange.getChangeType());
//				assertEquals(AccountChangeMode.IN.code(), accountChange.getChangeMode());
//				assertEquals(depositInfo.getAmount(), accountChange.getAmount());
////			assertEquals(depositInfo.getAmount(), accountChange.getMemo());
////			assertEquals(depositInfo.getAmount(), accountChange.getChangeTime());
//			}
//		}
//		//积分变动
//		List<GasPointsChangeDO> pointsChanges = silverboltTestBase.findGasPointsChangeByUserId(userInfo.getUserId());
//		assertTrue(pointsChanges.size() > 0);
//		for (GasPointsChangeDO pointsChange : pointsChanges) {
//			assertEquals(depositInfo.getPartnerId(), pointsChange.getPartnerId());
//			assertEquals(null, pointsChange.getPartnerName());
//			assertEquals(depositInfo.getStationId(), pointsChange.getStationId());
//			assertEquals(null, pointsChange.getStationCode());
//			assertEquals(depositInfo.getStationName(), pointsChange.getStationName());
//			assertEquals(depositInfo.getOperateId(), pointsChange.getOperateId());
//			assertEquals(depositInfo.getOperateName(), pointsChange.getOperateName());
//			assertEquals(depositInfo.getTerminalType(), pointsChange.getTerminalType());
//			assertEquals(depositInfo.getTerminalCode(), pointsChange.getTerminalCode());
//			assertEquals(depositInfo.getRealName(), pointsChange.getRealName());
//			assertEquals(depositInfo.getNickName(), pointsChange.getNickName());
//			assertEquals(depositInfo.getMemberType(), pointsChange.getMemberType());
//			assertEquals(depositInfo.getMobile(), pointsChange.getMobile());
//			assertEquals(PointChangeType.PRESENT.code(), pointsChange.getChangeType());
//			assertEquals(AccountChangeMode.IN.code(), pointsChange.getChangeMode());
//			assertEquals(10L, pointsChange.getPoints());
////			assertEquals(depositInfo.getAmount(), accountChange.getMemo());
////			assertEquals(depositInfo.getAmount(), accountChange.getChangeTime());
//		}
//		//优惠:营销的数据就直接写死了，后面再改。充值对应的活动ID:001imjlz1ygsg045ek00 付款对应的优惠ID：001imjlz1nl4g045ek00
////		List<GasTradeFavourDO> favours = silverboltTestBase.findGasTradeFavourByBizNo(result.getInfo().getBizNo());
////		if (testId <= 1002) {
////			assertTrue(favours.size() > 0);
////			for (GasTradeFavourDO favour : favours) {
////				assertEquals(depositInfo.getPartnerId(), favour.getPartnerId());
////				assertEquals(depositInfo.getPartnerName(), favour.getPartnerName());
////				assertEquals(depositInfo.getStationId(), favour.getStationId());
////				assertEquals(depositInfo.getStationCode(), favour.getStationCode());
////				assertEquals(depositInfo.getStationName(), favour.getStationName());
////				assertEquals(depositInfo.getOperateId(), favour.getOperateId());
////				assertEquals(depositInfo.getOperateName(), favour.getOperateName());
////				assertEquals(depositInfo.getTerminalType(), favour.getTerminalType());
////				assertEquals(depositInfo.getTerminalCode(), favour.getTerminalCode());
////				assertEquals(depositInfo.getRealName(), favour.getRealName());
////				assertEquals(depositInfo.getNickName(), favour.getNickName());
////				assertEquals(depositInfo.getMemberType(), favour.getMemberType());
////				assertEquals(depositInfo.getMobile(), favour.getMobile());
////				assertEquals(order.getCardNo(), favour.getCardNo());
////				assertEquals(order.getTradePayType().code(), favour.getTradePayType());
////				assertEquals(order.getPayModel().code(), favour.getPayModel());
////				assertEquals("001imjlz1ygsg045ek00", favour.getFavourId());
////				assertEquals("充值活动", favour.getFavourName());
////				assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
////				assertEquals(FavourType.CAMPAIGN_FAVOUR.code(), favour.getFavourType());
////				assertEquals(10L, favour.getFavourRule());
////				assertEquals(depositInfo.getFavourAmount(), favour.getFavourAmount());
////				assertEquals(depositInfo.getStatus(), favour.getStatus());
////				assertEquals(depositInfo.getState(), favour.getState());
////				assertEquals(depositInfo.getRawAddTime(), favour.getCreateTime());
////				assertEquals(depositInfo.getFinishTime(), favour.getFinishTime());
//////			assertEquals(depositInfo.getAmount(), accountChange.getMemo());
//////			assertEquals(depositInfo.getAmount(), accountChange.getChangeTime());
////			}
////		} else {
////			assertEquals(null, favours);
////		}
//		//交易订单
//		List<GasTradeOrderDO> tradeOrders = silverboltTestBase.findGasTradeOrderByBizNo(result.getInfo().getBizNo());
//		assertTrue(tradeOrders.size() > 0);
//		for (GasTradeOrderDO tradeOrder : tradeOrders) {
//			assertEquals(depositInfo.getTradeType(), tradeOrder.getTradeType());
//			assertEquals(null, tradeOrder.getOrderType());
//			assertEquals(depositInfo.getReqId(), tradeOrder.getReqId());
//			assertEquals(depositInfo.getGid(), tradeOrder.getGid());
//			assertEquals(null, tradeOrder.getTradeNo());//冲退、退款的原流水号
//			assertEquals(depositInfo.getPartnerId(), tradeOrder.getPartnerId());
//			assertEquals(depositInfo.getPartnerName(), tradeOrder.getPartnerName());
//			assertEquals(depositInfo.getStationId(), tradeOrder.getStationId());
//			assertEquals(depositInfo.getStationCode(), tradeOrder.getStationCode());
//			assertEquals(depositInfo.getStationName(), tradeOrder.getStationName());
//			assertEquals(depositInfo.getOperateId(), tradeOrder.getOperateId());
//			assertEquals(depositInfo.getOperateName(), tradeOrder.getOperateName());
//			assertEquals(depositInfo.getTerminalType(), tradeOrder.getTerminalType());
//			assertEquals(depositInfo.getTerminalCode(), tradeOrder.getTerminalCode());
//			assertEquals(depositInfo.getRealName(), tradeOrder.getRealName());
//			assertEquals(depositInfo.getNickName(), tradeOrder.getNickName());
//			assertEquals(depositInfo.getMemberType(), tradeOrder.getMemberType());
//			assertEquals(depositInfo.getMobile(), tradeOrder.getMobile());
//			assertEquals(order.getCardNo(), tradeOrder.getCardNo());
//			assertEquals(cardInfo.getTag(), tradeOrder.getCardBizType());
//			assertEquals(cardInfo.getCardType(), tradeOrder.getCardType());
//			assertEquals(null, tradeOrder.getCarNumber());
//			assertEquals(depositInfo.getBalance(), tradeOrder.getBalance());
//			assertEquals(null, tradeOrder.getOilType());
//			assertEquals(null, tradeOrder.getOilCode());
//			assertEquals(null, tradeOrder.getOilName());
//			assertEquals(0L, tradeOrder.getOilAmount());
//			assertEquals(0L, tradeOrder.getOilFavourAmount());
//			assertEquals(0L, tradeOrder.getGoodsAmount());
//			assertEquals(0L, tradeOrder.getGoodsFavourAmount());
//			assertEquals(depositInfo.getPayNo(), tradeOrder.getPayNo());
//			assertEquals(order.getTradePayType().code(), tradeOrder.getTradePayType());
//			assertEquals(order.getPayModel().code(), tradeOrder.getPayModel());
//			assertEquals(depositInfo.getAmount(), tradeOrder.getAmount());
//			assertEquals(depositInfo.getPayAmount(), tradeOrder.getPayAmount());
//			assertEquals(depositInfo.getFavourAmount(), tradeOrder.getFavourAmount());
//			assertEquals(depositInfo.getStatus(), tradeOrder.getStatus());
//			assertEquals(depositInfo.getState(), tradeOrder.getState());
////			assertEquals(depositInfo.getAmount(), tradeOrder.getMemo());
////			assertEquals(depositInfo.getAmount(), tradeOrder.getChangeTime());
//		}
//		//用户信息
////		List<GasUserDO> users = silverboltTestBase.findGasUserByUserId(userInfo.getUserId());
////		assertTrue(users.size() > 0);
////		for (GasUserDO user : users) {
////			assertEquals(depositInfo.getTradeType(), tradeOrder.getTradeType());
////			assertEquals(null, tradeOrder.getOrderType());
////			assertEquals(depositInfo.getReqId(), tradeOrder.getReqId());
////			assertEquals(depositInfo.getGid(), tradeOrder.getGid());
////			assertEquals(null, tradeOrder.getTradeNo());//冲退、退款的原流水号
////			assertEquals(depositInfo.getPartnerId(), tradeOrder.getPartnerId());
////			assertEquals(depositInfo.getPartnerName(), tradeOrder.getPartnerName());
////			assertEquals(depositInfo.getStationId(), tradeOrder.getStationId());
////			assertEquals(depositInfo.getStationCode(), tradeOrder.getStationCode());
////			assertEquals(depositInfo.getStationName(), tradeOrder.getStationName());
////			assertEquals(depositInfo.getOperateId(), tradeOrder.getOperateId());
////			assertEquals(depositInfo.getOperateName(), tradeOrder.getOperateName());
////			assertEquals(depositInfo.getTerminalType(), tradeOrder.getTerminalType());
////			assertEquals(depositInfo.getTerminalCode(), tradeOrder.getTerminalCode());
////			assertEquals(depositInfo.getRealName(), tradeOrder.getRealName());
////			assertEquals(depositInfo.getNickName(), tradeOrder.getNickName());
////			assertEquals(depositInfo.getMemberType(), tradeOrder.getMemberType());
////			assertEquals(depositInfo.getMobile(), tradeOrder.getMobile());
////			assertEquals(order.getCardNo(), tradeOrder.getCardNo());
////			assertEquals(cardInfo.getTag(), tradeOrder.getCardBizType());
////			assertEquals(cardInfo.getCardType(), tradeOrder.getCardType());
////			assertEquals(null, tradeOrder.getCarNumber());
////			assertEquals(null, tradeOrder.getBalance());
////			assertEquals(null, tradeOrder.getOilType());
////			assertEquals(null, tradeOrder.getOilCode());
////			assertEquals(null, tradeOrder.getOilName());
////			assertEquals(null, tradeOrder.getOilAmount());
////			assertEquals(null, tradeOrder.getOilFavourAmount());
////			assertEquals(depositInfo.getPayNo(), tradeOrder.getPayNo());
////			assertEquals(order.getTradePayType().code(), tradeOrder.getTradePayType());
////			assertEquals(order.getPayModel().code(), tradeOrder.getPayModel());
////			assertEquals(depositInfo.getAmount(), tradeOrder.getAmount());
////			assertEquals(depositInfo.getPayAmount(), tradeOrder.getPayAmount());
////			assertEquals(depositInfo.getFavourAmount(), tradeOrder.getFavourAmount());
////			assertEquals(depositInfo.getStatus(), tradeOrder.getStatus());
////			assertEquals(depositInfo.getState(), tradeOrder.getState());
//////			assertEquals(depositInfo.getAmount(), tradeOrder.getMemo());
//////			assertEquals(depositInfo.getAmount(), tradeOrder.getChangeTime());
////		}
//		// 清除数据
//		gasTradeTestBase.cleanGasTradeDepositByReqId(order.getReqId());
//		gasTradeTestBase.cleanGasTradeNotifyTaskByBizNo(result.getInfo().getBizNo());
//		promotionTestBase.cleanCouponByUserId(userInfo.getUserId());
//		promotionTestBase.cleanPointsByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
//		silverboltTestBase.cleanGasTradeFavourByBizNo(result.getInfo().getBizNo());
//		silverboltTestBase.cleanGasTradeOrderByBizNo(result.getInfo().getBizNo());
//		silverboltTestBase.cleanGasUserByUserId(userInfo.getUserId());
//	}
//
//	/**
//	 *
//	 */
//	@AutoTest(file = "gas_trade/tradeDepositServiceTradeDepositTestFailOne.csv")
//	@DisplayName("充值--参数非法")
//	public void tradeDepositServiceTradeDepositTestFailOne(
//			// 基本参数
//			int testId,
//			// 业务参数
//			TradeDepositOrder order,
//			// 结果参数
//			String code,
//			String description,
//			String message
//	) {
//		// 清除数据
//		// 准备数据
//		String reqId = OID.newID();
//		String gid = GID.newGID();
//		// 测试过程
//		order.setReqId(reqId);
//		order.setGid(gid);
//		if (testId == 1001) {
//			order.setGid(null);
//		}
//		if (testId == 1002) {
//			order.setReqId(null);
//		}
//		if (testId == 1003) {
//			order.setMerchantOrderNo(null);
//		}
//		if (testId == 1004) {
//			order.setPartnerId(null);
//		}
//		if (testId == 1005) {
//			order.setCardNo(null);
//		}
//		if (testId == 1006) {
//			order.setTradePayType(null);
//		}
//		if (testId == 1007) {
//			order.setPayModel(null);
//		}
//		if (testId == 1008) {
//			order.setTerminalType(null);
//		}
//		if (testId == 1009) {
//			order.setStationId(null);
//		}
//		if (testId == 1010) {
//			order.setPayModel(TradePayModel.KEY);
//			order.setAuthCode(null);
//		}
//		if (testId == 1011) {
//			order.setPayModel(TradePayModel.PUBLIC);
//			order.setTradePayType(TradePayType.WECHAT);
//			order.setWeChatOpenId(null);
//		}
//		if (testId == 1012) {
//			order.setPayModel(TradePayModel.PUBLIC);
//			order.setTradePayType(TradePayType.WECHAT);
//			order.setUserIp(null);
//		}
//		if (testId == 1013) {
//			order.setPayModel(TradePayModel.PUBLIC);
//			order.setTradePayType(TradePayType.ALI);
//			order.setALiUserId(null);
//		}
//		if (testId == 1014) {
//			order.setPayModel(TradePayModel.PUBLIC);
//			order.setTradePayType(TradePayType.ALI);
//			order.setUserIp(null);
//		}
//		if (testId == 1015) {
//			order.setTerminalType(TerminalType.BOSS);
//			order.setOperateId(null);
//		}
//		if (testId == 1016) {
//			order.setTerminalType(TerminalType.POS);
//			order.setTerminalCode(null);
//		}
//		if (testId == 1017) {
//			order.setTerminalType(TerminalType.POS);
//			order.setOperateId(null);
//		}
//		// 调用接口
//		BizResult<TradeDepositInfo> result = tradeDepositService.tradeDeposit(order);
//		// 结果验证
//		assertResult(testId, Status.FAIL, code, result);
//		// 数据验证
//		assertEquals(null, result.getInfo());
//		// 清除数据
//	}
//}
