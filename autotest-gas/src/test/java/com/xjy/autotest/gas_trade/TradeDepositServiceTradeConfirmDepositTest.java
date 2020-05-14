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
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.trade.api.enums.TradeType;
//import com.xyb.gas.trade.api.info.TradeDepositInfo;
//import com.xyb.gas.trade.api.order.TradeDepositApplyOrder;
//import com.xyb.gas.trade.api.order.TradeDepositConfirmOrder;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_merchant.GasMerchantStationDO;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import dal.model.gas_trade.GasTradeDepositDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/12.
// */
//public class TradeDepositServiceTradeConfirmDepositTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
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
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_trade/tradeDepositServiceTradeConfirmDepositTestSuccess.csv")
//	@DisplayName("充值确认服务--成功用例")
//	public void tradeDepositServiceTradeConfirmDepositTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			TradeDepositApplyOrder applyOrder,
//			TradeDepositConfirmOrder order
//	) {
//		// 清除数据
//		// 准备数据
//		//卡信息
//		UserCardInfoDO cardInfo = gasUserTestBase.findUserCardInfoByCardNo(applyOrder.getCardNo()).get(0);
//		//加好油用户信息
//		UserDO gasUserInfo = gasUserTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		//清结算用户信息
//		dal.model.user.UserDO userInfo = userTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//		//账户信息
//		AccountDO accountInfo = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//		//商户信息
//		GasMerchantDO merchantInfo = gasMerchantTestBase.findGasMerchantByPartnerId(order.getPartnerId()).get(0);
//		//操作员信息
//		GasMerchantUserDO operatorInfo = gasMerchantTestBase.findGasMerchantUserByUserId(applyOrder.getOperateId()).get(0);
//		//油站信息
//		GasMerchantStationDO stationInfo = gasMerchantTestBase.findGasMerchantStationByStationId(applyOrder.getStationId()).get(0);
//		applyOrder.setMerchantOrderNo(OID.newID());
//		applyOrder.setReqId(OID.newID());
//		applyOrder.setGid(GID.newGID());
//		BizResult<TradeDepositInfo> applyResult = tradeDepositService.tradeApplyDeposit(applyOrder);
//		print(applyResult);
//		assertEquals(Status.PROCESSING, applyResult.getStatus());
//		// 测试过程
//		order.setDepositNo(applyResult.getInfo().getBizNo());
//		order.setReqId(applyOrder.getReqId());
//		order.setMerchantOrderNo(applyOrder.getMerchantOrderNo());
//		order.setGid(applyOrder.getGid());
//		// 调用接口
//		BizResult<TradeDepositInfo> result = tradeDepositService.tradeConfirmDeposit(order);
//		// 结果验证
//		sleep(3);
//		print(result);
//		assertEquals(status, result.getStatus());
//		// 数据验证
//		GasTradeDepositDO depositInfo = gasTradeTestBase.findGasTradeDepositByReqId(applyOrder.getReqId()).get(0);
//		TradeDepositInfo depositInfos = result.getInfo();
//		assertEquals(TradeType.DEPOSIT.code(),depositInfo.getTradeType());
//		//assertEquals(order.getPayAmount(),depositInfo.getBizNo());
//		assertEquals(applyOrder.getReqId(),depositInfo.getReqId());
//		assertEquals(applyOrder.getGid(),depositInfo.getGid());
//		assertEquals(applyOrder.getPartnerId(),depositInfo.getPartnerId());
//		assertEquals(merchantInfo.getPartnerName(),depositInfo.getPartnerName());
//		assertEquals(stationInfo.getStationCode(),depositInfo.getStationCode());
//		assertEquals(applyOrder.getStationId(),depositInfo.getStationId());
//		assertEquals(stationInfo.getStationName(),depositInfo.getStationName());
//		assertEquals(applyOrder.getOperateId(),depositInfo.getOperateId());
//		assertEquals(operatorInfo.getUserName(),depositInfo.getOperateName());
//		assertEquals(order.getTradePayType().code(), depositInfo.getTradePayType());
//		assertEquals(applyOrder.getTerminalCode(),depositInfo.getTerminalCode());
//		assertEquals(cardInfo.getUserId(),depositInfo.getUserId());
//		//assertEquals(userInfo.getRealName(),depositInfo.getRealName());
//		assertEquals(gasUserInfo.getMobile(),depositInfo.getMobile());
//		assertEquals(gasUserInfo.getNickName(),depositInfo.getNickName());
//		assertEquals(gasUserInfo.getMemberType(),depositInfo.getMemberType());
//		assertEquals(applyOrder.getCardNo(), depositInfo.getCardNo());
//		assertEquals(cardInfo.getCardType(),depositInfo.getCardType());
//		assertEquals(cardInfo.getTag(),depositInfo.getCardBizType());
//		assertEquals(Money.cent(accountInfo.getBalance()).add(applyOrder.getPayAmount()), Money.cent(depositInfo.getBalance()));
//		//assertEquals(order.getPayAmount(),depositInfo.getRequestNo());
//		//assertEquals(order.getAmount(),depositInfo.getPayNo());
//		assertEquals(order.getPayModel().code(), depositInfo.getPayModel());
//		//assertEquals(order.getPayAmount(),depositInfo.getAmount());
//		assertEquals(applyOrder.getPayAmount(), Money.cent(depositInfo.getPayAmount()));
//		//assertEquals(order.getPayAmount(),depositInfo.getFavourAmount());
//		//assertEquals("充值",depositInfo.getMemo());
//		assertEquals("success",depositInfo.getStatus());
//		assertEquals("finished",depositInfo.getState());
//		assertEquals("comn_00_0000",depositInfo.getCode());
//		assertEquals("充值成功", depositInfo.getDescription());
//		assertEquals("充值流程结束", depositInfo.getRunMemo());
////		assertEquals(order.getPayAmount(),depositInfo.getFinishTime());
////		assertEquals(order.getPayAmount(),depositInfo.getRawAddTime());
////		assertEquals(order.getPayAmount(),depositInfo.getRawUpdateTime());
//		// 清除数据
//		gasTradeTestBase.cleanGasTradeDepositByReqId(order.getReqId());
//		gasTradeTestBase.cleanGasTradeNotifyTaskByBizNo(applyResult.getInfo().getBizNo());
//	}
//}
