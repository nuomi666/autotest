//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
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
//import com.xyb.gas.merchant.api.enums.GoodsGroupType;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.info.TradeRefundPayInfo;
//import com.xyb.gas.trade.api.order.TradeGoodsOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentOrder;
//import com.xyb.gas.trade.api.order.TradeRefundOrder;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import com.xyb.gas.trade.api.service.TradeRefundService;
//import com.xyb.pay.api.settlement.info.PaymentInfo;
//import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentConfirmOrder;
//import com.xyb.pay.api.settlement.service.BalancePaymentService;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_merchant.GasMerchantStationDO;
//import dal.model.gas_merchant.GasMerchantUserDO;
//import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
//import dal.model.gas_silverbolt.GasAccountChangeDO;
//import dal.model.gas_silverbolt.GasPointsChangeDO;
//import dal.model.gas_silverbolt.GasTradeOrderDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_trade.GasTradeRefundDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.pay.PaymentInstructionDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.AccountDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/22.
// */
//public class TradeRefundServiceTradeRefundTest extends SpringBootTestBase {
//
//    @Reference(version = "1.0")
//    TradeRefundService tradeRefundService;
//
//    @Reference(version = "1.0")
//    TradePaymentService tradePaymentService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    @Autowired
//    PayTestBase payTestBase;
//
//    @Autowired
//    UserTestBase userTestBase;
//
//    @Autowired
//    Gas_userTestBase gasUserTestBase;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    @Reference(version = "1.0.0")
//    BalancePaymentService balancePaymentService;
//
//    @Autowired
//    PromotionTestBase promotionTestBase;
//
//    @Autowired
//    Gas_silverboltTestBase silverboltTestBase;
//
//    /**
//     * 交易流水号为充值表里的biz_no
//     */
//    @AutoTest(file = "gas_trade/tradeRefundServiceTradeRefundTestSuccess.csv")
//    @DisplayName("交易退款--成功用例")
//    public void tradeRefundServiceTradeRefundTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            Status refundStatus,
//            // 业务参数
//            TradePaymentOrder payOrder,
//            TradeOilOrder tradeOilOrder,
//            TradeGoodsOrder tradeGoodsOrder,
//            TradeRefundOrder order,
//            // 结果参数
//            String code,
//            String description,
//            String message
//    ) {
//        // 清除数据
//        // 准备数据
//        //卡信息
//        UserCardInfoDO cardInfo = gasUserTestBase.findUserCardInfoByCardNo(payOrder.getCardNo()).get(0);
//        //加好油用户信息
//        dal.model.gas_user.UserDO gasUserInfo = gasUserTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//        //清结算用户信息
//        dal.model.user.UserDO userInfo = userTestBase.findUserByUserId(cardInfo.getUserId()).get(0);
//        AccountDO accountDO = new AccountDO();
//        accountDO.setAccountNo(cardInfo.getAccountNo());
//        accountDO.setUserId(cardInfo.getUserId());
//        accountDO.setStatus("ACTIVE");
//        accountDO.setAccountType("NORMAL");
//        accountDO.setPayModel("111");
//        accountDO.setTag("GAS_DUMMY_DEFAULT");
//        accountDO.setMemo("加好油测试账户1");
//        accountDO.setRawAddTime(DateUtils.getSqlDate());
//        accountDO.setRawUpdateTime(DateUtils.getSqlDate());
//        accountDO.setBalance(9000L);
//        accountDO.setFreezeBalance(0L);
//        accountDO.setHisInAmount(9000L);
//        accountDO.setHisOutAmount(0L);
//        if (testId == 1001) {
//            userTestBase.updateAccountByAccountNo(cardInfo.getAccountNo(), accountDO);
//        }
//        //商户信息
//        GasMerchantDO merchantInfo = gasMerchantTestBase.findGasMerchantByPartnerId(payOrder.getPartnerId()).get(0);
//        //油站信息
//        GasMerchantStationDO stationInfo = gasMerchantTestBase.findGasMerchantStationByStationId(order.getStationId()).get(0);
//        //操作员信息
//        GasMerchantUserDO operatorInfo = gasMerchantTestBase.findGasMerchantUserByUserId(order.getOperateId()).get(0);
//        //商品计划信息
//        List<GasStationGoodsPricePlanDO> stationGoodsPricePlanS = gasMerchantTestBase.findGasStationGoodsPricePlanByPlanId("001ifo89bt3cg025eh00");
//        JSONArray jsonArray = JSONArray.parseArray(stationGoodsPricePlanS.get(0).getGoodsInfo());
//        String price = "";
//        String oilName = "";
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JSONObject goodsJson = jsonArray.getJSONObject(i);
//            JSONObject priceJson = JSON.parseObject(goodsJson.get("goodsPrice").toString());
//            if (tradeOilOrder.getCode().equals(goodsJson.get("goodsCode").toString())) {
//                price = priceJson.get("amount").toString();
//                oilName = goodsJson.get("goodsName").toString();
//            }
//        }
//        //积分
//        promotionTestBase.cleanPointsByUserId(payOrder.getUserId());
//        PointsDO pointsDO = new PointsDO();
//        pointsDO.setPartnerId(order.getPartnerId());
//        pointsDO.setPlatPartnerId("S0301806081400000015");
//        pointsDO.setUserId(userInfo.getUserId());
//        pointsDO.setPoints(100L);
//        pointsDO.setHistoryAddPoints(100L);
//        pointsDO.setHistorySubtractPoints(0L);
//        pointsDO.setPointId(OID.newID());
//        pointsDO.setRawAddTime(DateUtils.getSqlDate());
//        pointsDO.setRawUpdateTime(DateUtils.getSqlDate());
//        promotionTestBase.insertPoints(pointsDO);
//        PointsDO points = promotionTestBase.findPointsByUserId(payOrder.getUserId()).get(0);
//        //券
//        promotionTestBase.cleanCouponByUserId(payOrder.getUserId());
//        silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
////        if (testId == 1003) {
////            tradeOilOrder.setAmount(new Money(151, 11));
////        }
//        List<TradeGoodsOrder> goodsOrders = new ArrayList<TradeGoodsOrder>();
//        goodsOrders.add(tradeGoodsOrder);
//        if (testId != 1004 && testId != 1005 && testId != 1006) {
//            payOrder.setTradeOilOrder(tradeOilOrder);
//        }
//        if (testId != 1003 && testId != 1008 && testId != 1009 && testId != 1010) {
//            payOrder.setGoodsOrders(goodsOrders);
//        }
//        if (testId != 1001) {
//            payOrder.setCardNo(null);
//        }
//        if (testId == 1004) {
//            payOrder.setUserId(null);
//        }
//        payOrder.setReqId(OID.newID());
//        payOrder.setGid(GID.newGID());
//        // 调用接口
//        BizResult<TradePaymentInfo> PaymentResult = tradePaymentService.tradePayment(payOrder);
//        // 结果验证
//        print(PaymentResult);
//        assertEquals(status, PaymentResult.getStatus());
//        GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByBizNo(PaymentResult.getInfo().getBizNo()).get(0);
//        if (testId == 1001) {//余额支付走收银台手动确认付款成功
//            PaymentInstructionDO paymentInstruction = payTestBase.findPaymentInstructionByReqId(paymentInfo.getRequestNo()).get(0);
//            UserDO user = userTestBase.findUserByUserId(gasUserTestBase.findUserCardInfoByCardNo(payOrder.getCardNo()).get(0).getUserId()).get(0);
//            BalancePaymentConfirmOrder confirmOrder = new BalancePaymentConfirmOrder();
//            confirmOrder.setBizNo(paymentInstruction.getBizNo());
//            confirmOrder.setPassword("111111");
//            confirmOrder.setGid(GID.newGID());
//            confirmOrder.setMerchantOrderNo(OID.newID());
//            confirmOrder.setPartnerId(payOrder.getPartnerId());
//            confirmOrder.setPlatMerchantOrderNo(OID.newID());
//            confirmOrder.setPlatPartnerId(payOrder.getPartnerId());
//            confirmOrder.setReqId(paymentInfo.getRequestNo());
//            BizResult<PaymentInfo> confirmResult = balancePaymentService.confirm(confirmOrder);
//            System.out.println(confirmResult);
//            assertEquals(confirmResult.getStatus(), Status.SUCCESS);
//        }
//        sleep(3);
//        GasTradePaymentDO paymentInfo1 = gasTradeTestBase.findGasTradePaymentByBizNo(PaymentResult.getInfo().getBizNo()).get(0);
//        assertEquals("success", paymentInfo1.getStatus());
//        assertEquals("finished", paymentInfo1.getState());
//        assertEquals("comn_00_0000", paymentInfo1.getCode());
//        assertEquals("付款成功", paymentInfo1.getDescription());
//        assertEquals("付款流程结束", paymentInfo1.getRunMemo());
//        if (testId == 1001 || testId >= 1004 && testId <= 1006) {//1001为油品价格不满足优惠，4-6为商品
//            assertEquals(new Money(0, 0), Money.cent(paymentInfo1.getFavourAmount()));
//        } else if (testId == 1002 || testId == 1007) {//直降15，满减5
//            assertEquals(new Money(20, 0), Money.cent(paymentInfo1.getFavourAmount()));
//        } else if (testId == 1003) {//直降10，满减5,打折12
//            assertEquals(new Money(27, 0), Money.cent(paymentInfo1.getFavourAmount()));
//        } else {//直降10，满减5
//            assertEquals(new Money(15, 0), Money.cent(paymentInfo1.getFavourAmount()));
//        }
//        AccountDO accountInfo = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//        //商户账户
//        AccountDO merchantAccount = userTestBase.findAccountByUserId("S0301808271500000065").stream().filter(
//                (acc) -> ("GAS_DUMMY_DEFAULT".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
//        //营销账户
//        AccountDO marketAccount = userTestBase.findAccountByUserId("S0301808271500000065").stream().filter(
//                (acc) -> ("gas_merchant_market_account_tag".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
//        //分析系统
////        silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
////        silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
////        silverboltTestBase.cleanGasTradeFavourByBizNo(PaymentResult.getInfo().getBizNo());
////        silverboltTestBase.cleanGasTradeOrderByBizNo(PaymentResult.getInfo().getBizNo());
////        silverboltTestBase.cleanGasTradeOilByBizNo(PaymentResult.getInfo().getBizNo());
////        silverboltTestBase.cleanGasTradeGoodsByBizNo(PaymentResult.getInfo().getBizNo());
//        // 测试过程
//        order.setGid(GID.newGID());
//        order.setReqId(OID.newID());
//        order.setMerchantOrderNo(OID.newID());
//        order.setTradeNo(PaymentResult.getInfo().getBizNo());
//        // 调用接口
//        BizResult<TradeRefundPayInfo> result = tradeRefundService.tradeRefund(order);
//        sleep(3);
//        // 结果验证
//        print(result);
//        assertEquals(refundStatus, result.getStatus());
//        // 数据验证
//        AccountDO accountInfoxx = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//        GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByBizNo(order.getTradeNo()).get(0);
//        assertEquals("success", paymentInfoxx.getStatus());
//        assertEquals("refunded", paymentInfoxx.getState());
//        assertEquals("comn_00_0000", paymentInfoxx.getCode());
//        assertEquals("已退款", paymentInfoxx.getDescription());
//        assertEquals("付款订单已退款完成", paymentInfoxx.getRunMemo());
//        GasTradeRefundDO refundInfo = gasTradeTestBase.findGasTradeRefundByTradeNo(order.getTradeNo()).get(0);
//        assertEquals("success", refundInfo.getStatus());
//        assertEquals("finished", refundInfo.getState());
//        assertEquals("comn_00_0000", refundInfo.getCode());
//        assertEquals("退款成功", refundInfo.getDescription());
//        assertEquals("退款流程结束", refundInfo.getRunMemo());
//        assertEquals("REFUND", refundInfo.getTradeType());
//        //  assertEquals("PAYMENT", paymentInfo.getBizNo());
//        assertEquals(order.getReqId(), refundInfo.getReqId());
//        assertEquals(order.getGid(), refundInfo.getGid());
//        assertEquals(order.getPartnerId(), refundInfo.getPartnerId());
//        assertEquals(merchantInfo.getPartnerName(), refundInfo.getPartnerName());
//        assertEquals(order.getStationId(), refundInfo.getStationId());
//        assertEquals(stationInfo.getStationCode(), refundInfo.getStationCode());
//        assertEquals(stationInfo.getStationName(), refundInfo.getStationName());
//        assertEquals(order.getOperateId(), refundInfo.getOperateId());
//        assertEquals(operatorInfo.getUserName(), refundInfo.getOperateName());
//        assertEquals(order.getTerminalType().code(), refundInfo.getTerminalType());
//        assertEquals(order.getTerminalCode(), refundInfo.getTerminalCode());
//        if (testId == 1004) {
//            assertEquals("00000000000000000000", refundInfo.getUserId());
//            // assertEquals(null, refundInfo.getRealName());
//            assertEquals(null, refundInfo.getNickName());
//            assertEquals(null, refundInfo.getMemberType());
//            assertEquals(null, refundInfo.getMobile());
//        } else {
//            assertEquals(cardInfo.getUserId(), refundInfo.getUserId());
//            assertEquals(userInfo.getRealName(), refundInfo.getRealName());
//            assertEquals(gasUserInfo.getNickName(), refundInfo.getNickName());
//            assertEquals(gasUserInfo.getMemberType(), refundInfo.getMemberType());
//            assertEquals(gasUserInfo.getMobile(), refundInfo.getMobile());
//        }
//        if (testId == 1001) {
//            assertEquals(payOrder.getCardNo(), refundInfo.getCardNo());
//            assertEquals(cardInfo.getCardType(), refundInfo.getCardType());
//            assertEquals(cardInfo.getTag(), refundInfo.getCardBizType());
//        } else {
//            assertEquals(null, refundInfo.getCardNo());
//            assertEquals(null, refundInfo.getCardType());
//            assertEquals(null, refundInfo.getCardBizType());
//        }
////        assertEquals("PAYMENT", paymentInfo.getCarNumber());
////        assertEquals("PAYMENT", paymentInfo.getRequestNo());
////        assertEquals("PAYMENT", paymentInfo.getPayNo());
//        if (testId == 1001 || testId == 1002 || testId == 1007) {
//            assertEquals(tradeOilOrder.getAmount().add(tradeGoodsOrder.getAmount()), Money.cent(refundInfo.getAmount()));
//            assertEquals(tradeOilOrder.getAmount().add(tradeGoodsOrder.getAmount()).subtract(Money.cent(paymentInfoxx.getFavourAmount())), Money.cent(refundInfo.getPayAmount()));
//        } else {
//            assertEquals(tradeOilOrder.getAmount(), Money.cent(refundInfo.getAmount()));
//            assertEquals(tradeOilOrder.getAmount().subtract(Money.cent(paymentInfoxx.getFavourAmount())), Money.cent(refundInfo.getPayAmount()));
//        }
//        //账户信息
//        if (testId == 1001) {
//            assertEquals(Money.cent(accountInfo.getBalance()).add(Money.cent(refundInfo.getAmount())), Money.cent(accountInfoxx.getBalance()));
//            assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
//            assertEquals(Money.cent(accountInfo.getHisInAmount()).add(Money.cent(refundInfo.getAmount())), Money.cent(accountInfoxx.getHisInAmount()));
//            assertEquals(Money.cent(accountInfo.getHisOutAmount()), Money.cent(accountInfoxx.getHisOutAmount()));
//        } else {
//            assertEquals(Money.cent(accountInfo.getBalance()), Money.cent(accountInfoxx.getBalance()));
//            assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
//            assertEquals(Money.cent(accountInfo.getHisInAmount()), Money.cent(accountInfoxx.getHisInAmount()));
//            assertEquals(Money.cent(accountInfo.getHisOutAmount()), Money.cent(accountInfoxx.getHisOutAmount()));
//        }
//        if (testId != 1001) {
//            assertEquals(new Money(0, 0), Money.cent(refundInfo.getBalance()));
//        } else {
//            assertEquals(Money.cent(accountInfoxx.getBalance()), Money.cent(refundInfo.getBalance()));
//        }
//        //分析系统
//        //账户变动表
//        List<GasAccountChangeDO> accountChanges = silverboltTestBase.findGasAccountChangeByUserId(userInfo.getUserId());
//        if (testId == 1001) {//余额支付时，才有账户变动记录
//            assertEquals(2, accountChanges.size());
//            for (GasAccountChangeDO accountChange : accountChanges) {
////                if (AccountChangeType.BALANCE_TRADE.code().equals(accountChange.getChangeType())) {
////                    assertEquals(AccountChangeMode.OUT.code(), accountChange.getChangeMode());
////                }
//                if (AccountChangeType.TRADE_REFUND.code().equals(accountChange.getChangeType())) {
//                    assertEquals(AccountChangeMode.IN.code(), accountChange.getChangeMode());
//                    assertEquals(refundInfo.getPartnerId(), accountChange.getPartnerId());
//                    assertEquals(refundInfo.getStationId(), accountChange.getStationId());
//                    assertEquals(refundInfo.getStationName(), accountChange.getStationName());
//                    assertEquals(refundInfo.getOperateId(), accountChange.getOperateId());
//                    assertEquals(refundInfo.getOperateName(), accountChange.getOperateName());
//                    assertEquals(refundInfo.getTerminalType(), accountChange.getTerminalType());
//                    assertEquals(refundInfo.getTerminalCode(), accountChange.getTerminalCode());
//                    assertEquals(refundInfo.getRealName(), accountChange.getRealName());
//                    assertEquals(refundInfo.getNickName(), accountChange.getNickName());
//                    assertEquals(refundInfo.getMemberType(), accountChange.getMemberType());
//                    assertEquals(refundInfo.getMobile(), accountChange.getMobile());
//                    assertEquals(refundInfo.getPayAmount(), accountChange.getAmount());
//                    assertEquals(refundInfo.getPartnerName(), accountChange.getPartnerName());
//                    assertEquals(refundInfo.getStationCode(), accountChange.getStationCode());
//                }
////			assertEquals(paymentInfo.getAmount(), accountChange.getMemo());
////			assertEquals(paymentInfo.getAmount(), accountChange.getChangeTime());
//            }
//        } else {
//            assertEquals(0, accountChanges.size());
//        }
//        //积分变动
//        List<GasPointsChangeDO> pointsChanges = silverboltTestBase.findGasPointsChangeByUserId(userInfo.getUserId()).stream().filter(
//                (changes) -> (PointChangeType.PRESENT_REVOKE.code().equals(changes.getChangeType()))).collect(Collectors.toList());
//        if (testId == 1001 || testId == 1004) {
//            assertEquals(0, pointsChanges.size());
//        } else {
//            assertTrue(pointsChanges.size() > 0);
//            for (GasPointsChangeDO pointsChange : pointsChanges) {
////                if (PointChangeType.PRESENT.code().equals(pointsChange.getChangeType())) {
////                    assertEquals(AccountChangeMode.IN.code(), pointsChange.getChangeMode());
////                }
//                if (PointChangeType.PRESENT_REVOKE.code().equals(pointsChange.getChangeType())) {
//                    assertEquals(AccountChangeMode.OUT.code(), pointsChange.getChangeMode());
//                    assertEquals(refundInfo.getPartnerId(), pointsChange.getPartnerId());
//                    assertEquals(null, pointsChange.getPartnerName());
//                    assertEquals(refundInfo.getStationId(), pointsChange.getStationId());
//                    assertEquals(null, pointsChange.getStationCode());
//                    assertEquals(refundInfo.getStationName(), pointsChange.getStationName());
//                    assertEquals(refundInfo.getOperateId(), pointsChange.getOperateId());
//                    assertEquals(refundInfo.getOperateName(), pointsChange.getOperateName());
//                    assertEquals(refundInfo.getTerminalType(), pointsChange.getTerminalType());
//                    assertEquals(refundInfo.getTerminalCode(), pointsChange.getTerminalCode());
//                    assertEquals(refundInfo.getRealName(), pointsChange.getRealName());
//                    assertEquals(refundInfo.getNickName(), pointsChange.getNickName());
//                    assertEquals(refundInfo.getMemberType(), pointsChange.getMemberType());
//                    assertEquals(refundInfo.getMobile(), pointsChange.getMobile());
//                    assertEquals(10L, pointsChange.getPoints());
//                }
////			assertEquals(refundInfo.getAmount(), accountChange.getMemo());
////			assertEquals(refundInfo.getAmount(), accountChange.getChangeTime());
//            }
//        }
//        //交易订单
//        List<GasTradeOrderDO> tradeOrders = silverboltTestBase.findGasTradeOrderByBizNo(result.getInfo().getBizNo());
//        assertTrue(tradeOrders.size() > 0);
//        for (GasTradeOrderDO tradeOrder : tradeOrders) {
//            assertEquals(refundInfo.getTradeType(), tradeOrder.getTradeType());
//            assertEquals(payOrder.getOrderType().code(), tradeOrder.getOrderType());
//            assertEquals(refundInfo.getReqId(), tradeOrder.getReqId());
//            assertEquals(refundInfo.getGid(), tradeOrder.getGid());
//            assertEquals(PaymentResult.getInfo().getBizNo(), tradeOrder.getTradeNo());//冲退、退款的原流水号
//            assertEquals(refundInfo.getPartnerId(), tradeOrder.getPartnerId());
//            assertEquals(refundInfo.getPartnerName(), tradeOrder.getPartnerName());
//            assertEquals(refundInfo.getStationId(), tradeOrder.getStationId());
//            assertEquals(refundInfo.getStationCode(), tradeOrder.getStationCode());
//            assertEquals(refundInfo.getStationName(), tradeOrder.getStationName());
//            assertEquals(refundInfo.getOperateId(), tradeOrder.getOperateId());
//            assertEquals(refundInfo.getOperateName(), tradeOrder.getOperateName());
//            assertEquals(refundInfo.getTerminalType(), tradeOrder.getTerminalType());
//            assertEquals(refundInfo.getTerminalCode(), tradeOrder.getTerminalCode());
//            assertEquals(refundInfo.getRealName(), tradeOrder.getRealName());
//            assertEquals(refundInfo.getNickName(), tradeOrder.getNickName());
//            assertEquals(refundInfo.getMemberType(), tradeOrder.getMemberType());
//            assertEquals(refundInfo.getMobile(), tradeOrder.getMobile());
//            assertEquals(refundInfo.getCardNo(), tradeOrder.getCardNo());
//            assertEquals(refundInfo.getCardBizType(), tradeOrder.getCardBizType());
//            assertEquals(refundInfo.getCardType(), tradeOrder.getCardType());
//            assertEquals(refundInfo.getCarNumber(), tradeOrder.getCarNumber());
//            assertEquals(refundInfo.getBalance(), tradeOrder.getBalance());
//            if (testId <= 1003 || testId >= 1007 && testId <= 1010) {
//                assertEquals(GoodsGroupType.GASOLINE.code(), tradeOrder.getOilType());
//                assertEquals(tradeOilOrder.getCode(), tradeOrder.getOilCode());
//                assertEquals(oilName, tradeOrder.getOilName());
//                assertEquals(tradeOilOrder.getAmount(), Money.cent(tradeOrder.getOilAmount()));
//                if (testId == 1001) {//1001为油品价格不满足优惠
//                    assertEquals(new Money(0, 0), Money.cent(tradeOrder.getOilFavourAmount()));
//                } else if (testId == 1002 || testId == 1007) {//直降15，满减5
//                    assertEquals(new Money(20, 0), Money.cent(tradeOrder.getOilFavourAmount()));
//                } else if (testId == 1003) {//直降10，满减5，折扣12
//                    assertEquals(new Money(27, 00), Money.cent(tradeOrder.getOilFavourAmount()));
//                } else {//直降10，满减5
//                    assertEquals(new Money(15, 0), Money.cent(tradeOrder.getOilFavourAmount()));
//                }
//            } else {
//                assertEquals(null, tradeOrder.getOilType());
//                assertEquals(null, tradeOrder.getOilCode());
//                assertEquals(null, tradeOrder.getOilName());
//                assertEquals(0L, tradeOrder.getOilAmount());
//                assertEquals(0L, tradeOrder.getOilFavourAmount());
//            }
//            if (testId <= 1002 || testId >= 1004 && testId <= 1007) {
//                assertEquals(tradeGoodsOrder.getAmount(), Money.cent(tradeOrder.getGoodsAmount()));
//                assertEquals(0L, tradeOrder.getGoodsFavourAmount());
//            } else {
//                assertEquals(0L, tradeOrder.getGoodsAmount());
//                assertEquals(0L, tradeOrder.getGoodsFavourAmount());
//            }
//            assertEquals(refundInfo.getPayNo(), tradeOrder.getPayNo());
//            assertEquals(refundInfo.getTradePayType(), tradeOrder.getTradePayType());
//            assertEquals(payOrder.getPayModel().code(), tradeOrder.getPayModel());
//            assertEquals(refundInfo.getAmount(), tradeOrder.getAmount());
//            assertEquals(refundInfo.getPayAmount(), tradeOrder.getPayAmount());
//            assertEquals(tradeOrder.getOilFavourAmount(), tradeOrder.getFavourAmount());
//            assertEquals(refundInfo.getStatus(), tradeOrder.getStatus());
//            assertEquals(refundInfo.getState(), tradeOrder.getState());
////			assertEquals(paymentInfo.getAmount(), tradeOrder.getMemo());
////			assertEquals(paymentInfo.getAmount(), tradeOrder.getChangeTime());
//        }
//        //油品信息
//        List<dal.model.gas_silverbolt.GasTradeOilDO> silverOilInfos = silverboltTestBase.findGasTradeOilByBizNo(result.getInfo().getBizNo());
//        if (testId <= 1003 || testId >= 1007 && testId <= 1010) {
//            assertEquals(1, silverOilInfos.size());
//            for (dal.model.gas_silverbolt.GasTradeOilDO oilInfo : silverOilInfos) {
//                assertEquals(refundInfo.getTradeType(), oilInfo.getTradeType());
//                assertEquals(refundInfo.getTradeNo(), oilInfo.getTradeNo());
//                assertEquals(refundInfo.getPartnerId(), oilInfo.getPartnerId());
//                assertEquals(refundInfo.getPartnerName(), oilInfo.getPartnerName());
//                assertEquals(refundInfo.getStationId(), oilInfo.getStationId());
//                assertEquals(refundInfo.getStationCode(), oilInfo.getStationCode());
//                assertEquals(refundInfo.getStationName(), oilInfo.getStationName());
//                assertEquals(refundInfo.getOperateId(), oilInfo.getOperateId());
//                assertEquals(refundInfo.getOperateName(), oilInfo.getOperateName());
//                assertEquals(refundInfo.getTerminalType(), oilInfo.getTerminalType());
//                assertEquals(refundInfo.getTerminalCode(), oilInfo.getTerminalCode());
//                assertEquals(refundInfo.getUserId(), oilInfo.getUserId());
//                assertEquals(refundInfo.getRealName(), oilInfo.getRealName());
//                assertEquals(refundInfo.getNickName(), oilInfo.getNickName());
//                assertEquals(refundInfo.getMemberType(), oilInfo.getMemberType());
//                assertEquals(refundInfo.getMobile(), oilInfo.getMobile());
//                if (testId == 1001) {
//                    assertEquals(payOrder.getCardNo(), oilInfo.getCardNo());
//                } else {
//                    assertEquals(null, oilInfo.getCardNo());
//                }
//                assertEquals(GoodsGroupType.GASOLINE.code(), oilInfo.getOilType());
//                assertEquals(tradeOilOrder.getCode(), oilInfo.getOilCode());
//                assertEquals(oilName, oilInfo.getOilName());
//                assertEquals(price, Money.cent(oilInfo.getOilPrice()).toString());
////                assertEquals(BaseUtil.div(tradeOilOrder.getAmount().toString(), price, 2), oilInfo.getOilLiter());
//                assertEquals(tradeOilOrder.getOilGun(), oilInfo.getOilGun());
//                assertEquals(tradeOilOrder.getAmount(), Money.cent(oilInfo.getOilAmount()));
////                assertEquals(new Money(0, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                if (testId == 1001) {//1001为油品价格不满足优惠
//                    assertEquals(new Money(0, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                } else if (testId == 1002 || testId == 1007) {//直降15，满减5
//                    assertEquals(new Money(20, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                } else if (testId == 1003) {//直降10，满减5，折扣12
//                    assertEquals(new Money(27, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                } else {//直降10，满减5
//                    assertEquals(new Money(15, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                }
//                assertEquals(refundInfo.getTradePayType(), oilInfo.getTradePayType());
//                assertEquals(paymentInfoxx.getPayModel(), oilInfo.getPayModel());
//                assertEquals(refundInfo.getStatus(), oilInfo.getStatus());
//                assertEquals(refundInfo.getState(), oilInfo.getState());
//            }
//        } else {
//            assertEquals(0, silverOilInfos.size());
//        }
//        //商品信息
//        List<dal.model.gas_silverbolt.GasTradeGoodsDO> silverGoodsInfos = silverboltTestBase.findGasTradeGoodsByBizNo(result.getInfo().getBizNo());
//        if (testId <= 1002 || testId >= 1004 && testId <= 1007) {
//            assertEquals(1, silverGoodsInfos.size());
//            for (dal.model.gas_silverbolt.GasTradeGoodsDO goodsInfo : silverGoodsInfos) {
//                assertEquals(refundInfo.getTradeType(), goodsInfo.getTradeType());
//                assertEquals(refundInfo.getTradeNo(), goodsInfo.getTradeNo());
//                assertEquals(refundInfo.getPartnerId(), goodsInfo.getPartnerId());
//                assertEquals(refundInfo.getPartnerName(), goodsInfo.getPartnerName());
//                assertEquals(refundInfo.getStationId(), goodsInfo.getStationId());
//                assertEquals(refundInfo.getStationCode(), goodsInfo.getStationCode());
//                assertEquals(refundInfo.getStationName(), goodsInfo.getStationName());
//                assertEquals(refundInfo.getOperateId(), goodsInfo.getOperateId());
//                assertEquals(refundInfo.getOperateName(), goodsInfo.getOperateName());
//                assertEquals(refundInfo.getTerminalType(), goodsInfo.getTerminalType());
//                assertEquals(refundInfo.getTerminalCode(), goodsInfo.getTerminalCode());
//                assertEquals(refundInfo.getUserId(), goodsInfo.getUserId());
//                assertEquals(refundInfo.getRealName(), goodsInfo.getRealName());
//                assertEquals(refundInfo.getNickName(), goodsInfo.getNickName());
//                assertEquals(refundInfo.getMemberType(), goodsInfo.getMemberType());
//                assertEquals(refundInfo.getMobile(), goodsInfo.getMobile());
//                if (testId == 1001) {
//                    assertEquals(payOrder.getCardNo(), goodsInfo.getCardNo());
//                } else {
//                    assertEquals(null, goodsInfo.getCardNo());
//                }
//                assertEquals("default", goodsInfo.getGoodsType());
//                assertEquals(tradeGoodsOrder.getCode(), goodsInfo.getGoodsCode());
//                assertEquals("默认商品", goodsInfo.getGoodsName());
//                assertEquals(tradeGoodsOrder.getAmount(), Money.cent(goodsInfo.getGoodsPrice()));
//                assertEquals(1, goodsInfo.getGoodsPiece());
//                assertEquals(tradeGoodsOrder.getAmount(), Money.cent(goodsInfo.getGoodsAmount()));
//                assertEquals(new Money(0, 0), Money.cent(goodsInfo.getGoodsFavourAmount()));
//                assertEquals(refundInfo.getTradePayType(), goodsInfo.getTradePayType());
//                assertEquals(paymentInfoxx.getPayModel(), goodsInfo.getPayModel());
//                assertEquals(refundInfo.getStatus(), goodsInfo.getStatus());
//                assertEquals(refundInfo.getState(), goodsInfo.getState());
//            }
//        } else {
//            assertEquals(0, silverGoodsInfos.size());
//        }
//        // 清除数据
//        gasTradeTestBase.cleanGasTradePaymentByBizNo(PaymentResult.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeRefundByTradeNo(PaymentResult.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeGoodsByTradeNo(PaymentResult.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeOilByTradeNo(PaymentResult.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeNotifyTaskByBizNo(PaymentResult.getInfo().getBizNo());
//        promotionTestBase.cleanPointsByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasTradeFavourByBizNo(result.getInfo().getBizNo());
//        silverboltTestBase.cleanGasTradeOrderByBizNo(result.getInfo().getBizNo());
//        silverboltTestBase.cleanGasTradeGoodsByBizNo(result.getInfo().getBizNo());
//        silverboltTestBase.cleanGasTradeOilByBizNo(result.getInfo().getBizNo());
//    }
//}
