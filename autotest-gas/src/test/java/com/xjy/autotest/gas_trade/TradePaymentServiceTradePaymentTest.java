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
//import com.xyb.gas.facade.silverbot.api.collect.enums.*;
//import com.xyb.gas.marketpc.api.common.enums.PromotionWay;
//import com.xyb.gas.merchant.api.enums.GoodsGroupType;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeGoodsOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentOrder;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import com.xyb.pay.api.settlement.info.PaymentInfo;
//import com.xyb.pay.api.settlement.order.payment.balance.BalancePaymentConfirmOrder;
//import com.xyb.pay.api.settlement.service.BalancePaymentService;
//import dal.model.gas_merchant.*;
//import dal.model.gas_silverbolt.GasAccountChangeDO;
//import dal.model.gas_silverbolt.GasPointsChangeDO;
//import dal.model.gas_silverbolt.GasTradeFavourDO;
//import dal.model.gas_silverbolt.GasTradeOrderDO;
//import dal.model.gas_trade.GasTradeGoodsDO;
//import dal.model.gas_trade.GasTradeOilDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.pay.PaymentInstructionDO;
//import dal.model.promotion.CouponDO;
//import dal.model.promotion.PointsDO;
//import dal.model.user.AccountDO;
//import dal.model.user.UserDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
///**
// * @author nuomi@xinyebang.com
// * Created on 2018/08/22.
// */
//public class TradePaymentServiceTradePaymentTest extends SpringBootTestBase {
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
//    Gas_userTestBase gasUserBase;
//
//    @Reference(version = "1.0.0")
//    BalancePaymentService balancePaymentService;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    @Autowired
//    Gas_userTestBase gasUserTestBase;
//
//    @Autowired
//    PromotionTestBase promotionTestBase;
//
//    @Autowired
//    Gas_silverboltTestBase silverboltTestBase;
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_trade/tradePaymentServiceTradePaymentTestSuccess.csv")
//    @DisplayName("付款--成功用例")
//    public void tradePaymentServiceTradePaymentTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TradePaymentOrder order,
//            TradeOilOrder tradeOilOrder,
//            TradeGoodsOrder tradeGoodsOrder
//            // 结果参数
//    ) {
//        // 清除数据
//        // 准备数据
//        Date takenTime = DateUtils.parseDate("2018-10-01");
//        Date startTime = DateUtils.parseDate("2018-10-01");
//        Date endTime = DateUtils.parseDate("2018-12-31");
//        //卡信息
//        UserCardInfoDO cardInfo = gasUserTestBase.findUserCardInfoByCardNo(order.getCardNo()).get(0);
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
//        accountDO.setBalance(14500L);
//        accountDO.setFreezeBalance(200L);
//        accountDO.setHisInAmount(14500L);
//        accountDO.setHisOutAmount(0L);
//        if (testId == 1001) {
//            userTestBase.updateAccountByAccountNo(cardInfo.getAccountNo(), accountDO);
//        }
//        //账户信息
//        AccountDO accountInfo = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
//        //商户信息
//        GasMerchantDO merchantInfo = gasMerchantTestBase.findGasMerchantByPartnerId(order.getPartnerId()).get(0);
//        //油站信息
//        GasMerchantStationDO stationInfo = gasMerchantTestBase.findGasMerchantStationByStationId(order.getStationId()).get(0);
//        //操作员信息
//        GasMerchantUserStationDO merchantUserInfo = gasMerchantTestBase.findGasMerchantUserStationByStationId(stationInfo.getStationId()).get(0);
//        GasMerchantUserDO operatorInfo = gasMerchantTestBase.findGasMerchantUserByUserId(merchantUserInfo.getUserId()).get(0);
//        //一键加油操作员、设备信息
//        GasMerchantDeviceFunctionDO deviceFunction = new GasMerchantDeviceFunctionDO();
//        GasMerchantUserDO operatorInfoxx = new GasMerchantUserDO();
//        if (testId == 1005 || testId == 1006) {
//            deviceFunction = gasMerchantTestBase.findGasMerchantDeviceFunctionByStationId(order.getStationId()).get(0);
//            operatorInfoxx = gasMerchantTestBase.findGasMerchantUserByUserId(deviceFunction.getUserId()).get(0);
//        }
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
//        promotionTestBase.cleanPointsByUserId(order.getUserId());
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
//        PointsDO points = promotionTestBase.findPointsByUserId(userInfo.getUserId()).get(0);
//        //券
//        promotionTestBase.cleanCouponByUserId(order.getUserId());
////        promotionTestBase.cleanCouponByUserId(userInfo.getUserId());
////        CouponDO couponDO = new CouponDO();
////        couponDO.setCouponId(OID.newID());
////        couponDO.setInnerName(OID.newID());
////        couponDO.setName("满100减5元");
////        couponDO.setPlatPartnerId("S0301806081400000015");
////        couponDO.setPartnerId("S0301808271500000065");
////        couponDO.setInstructionId(OID.newID());
////        couponDO.setDefinitionId("001imamfune0s107pr00");
////        couponDO.setUserId(userInfo.getUserId());
////        couponDO.setCouponType(CouponType.OVER.toString());
////        couponDO.setStatus(CouponStatus.TAKEN.toString());
////        couponDO.setTakenTime(takenTime);
////        couponDO.setValidStartTime(startTime);
////        couponDO.setValidEndTime(endTime);
////        couponDO.setRawAddTime(DateUtils.getSqlDate());
////        couponDO.setRawUpdateTime(DateUtils.getSqlDate());
////        promotionTestBase.insertCoupon(couponDO);
////        CouponDO coupon = promotionTestBase.findCouponByUserId(userInfo.getUserId()).get(0);
//        //分析系统
//        silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
////		silverboltTestBase.cleanGasTradeFavourByBizNo();
////		silverboltTestBase.cleanGasTradeOrderByBizNo();
//        silverboltTestBase.cleanGasUserByUserId(userInfo.getUserId());
//        //商户账户
//        AccountDO merchantAccount = userTestBase.findAccountByUserId("S0301808271500000065").stream().filter(
//                (acc) -> ("GAS_DUMMY_DEFAULT".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
//        //营销账户
//        AccountDO marketAccount = userTestBase.findAccountByUserId("S0301808271500000065").stream().filter(
//                (acc) -> ("gas_merchant_market_account_tag".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
//        // 测试过程
//        String reqId = OID.newID();
//        String gid = GID.newGID();
//        List<String> favourIds = new ArrayList<>();
//        order.setReqId(reqId);
//        tradeOilOrder.setCode("#95");
//        //tradeOilOrder.setAmount(new Money(100, 00));
//        if (testId == 1003) {
//            tradeOilOrder.setAmount(new Money(151, 11));
//        }
//        List<TradeGoodsOrder> goodsOrders = new ArrayList<TradeGoodsOrder>();
//        goodsOrders.add(tradeGoodsOrder);
//        if (testId != 1004 && testId != 1005 && testId != 1006) {
//            order.setTradeOilOrder(tradeOilOrder);
//        }
//        if (testId != 1003 && testId != 1008 && testId != 1009 && testId != 1010) {
//            order.setGoodsOrders(goodsOrders);
//        }
//        if (testId != 1001) {//会员非余额支付
//            order.setCardNo(null);
//        }
//        if (testId == 1004) {//非会员
//            order.setUserId(null);
//            order.setCardNo(null);
//        }
//        // favourIds.add(coupon.getCouponId());
////        if (testId == 1002) {
////            order.setFavourIds(favourIds);
////        }
//        order.setGid(gid);
//        // 调用接口
//        BizResult<TradePaymentInfo> result = tradePaymentService.tradePayment(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
//        GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByReqId(reqId).get(0);
//        /**支付表里的req_id对应的是交易表里的request_no
//         * status = Status.PROCESSING, description = "提交支付处理中":pay_process;
//         * status = Status.SUCCESS, description = "提交支付成功":pay_success;
//         * status = Status.FAIL, description = "提交支付失败":pay_fail;其他情况返回pay_error
//         */
//        // gasUserBase.findUserCardInfoByCardNo(order.getCardNo()).get(0);
//        if (testId == 1001) {//余额支付走收银台手动确认付款成功
//            PaymentInstructionDO paymentInstruction = payTestBase.findPaymentInstructionByReqId(paymentInfo.getRequestNo()).get(0);
//            UserDO user = userTestBase.findUserByUserId(gasUserBase.findUserCardInfoByCardNo(order.getCardNo()).get(0).getUserId()).get(0);
//            BalancePaymentConfirmOrder confirmOrder = new BalancePaymentConfirmOrder();
//            confirmOrder.setBizNo(paymentInstruction.getBizNo());
//            confirmOrder.setPassword("111111");
//            confirmOrder.setGid(GID.newGID());
//            confirmOrder.setMerchantOrderNo(OID.newID());
//            confirmOrder.setPartnerId(order.getPartnerId());
//            confirmOrder.setPlatMerchantOrderNo(OID.newID());
//            confirmOrder.setPlatPartnerId(order.getPartnerId());
//            confirmOrder.setReqId(paymentInfo.getRequestNo());
//            BizResult<PaymentInfo> paymentResult = balancePaymentService.confirm(confirmOrder);
//            System.out.println(paymentResult);
//            assertEquals(paymentResult.getStatus(), Status.SUCCESS);
//        }
//        sleep(5);
//        // 数据验证
//        AccountDO accountInfoxx = userTestBase.findAccountByAccountNo(cardInfo.getAccountNo()).get(0);
////        GasStationGoodsPricePlanDO plan = gasMerchantTestBase.findGasStationGoodsPricePlanByPlanId("001ifo89bt3cg025eh00").get(0);
////        JSONArray goodsInfoS = JSONArray.parseArray(plan.getGoodsInfo());
////        for (int i = 0; i < goodsInfoS.size(); i++) {
////            JSONObject goodsInfo = goodsInfoS.getJSONObject(i);
////            if ("OIL".equals(goodsInfo.get("goodsType").toString())) {
////                oilName = goodsInfo.get("goodsName").toString();
////            }
////            if ("OTHER".equals(goodsInfo.get("goodsType").toString())) {
////                goodsName = goodsInfo.get("goodsName").toString();
////            }
////        }
//        //付款信息
//        GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByBizNo(result.getInfo().getBizNo()).get(0);
//        assertEquals("PAYMENT", paymentInfo.getTradeType());
//        assertEquals(order.getOrderType().code(), paymentInfo.getOrderType());
//        //  assertEquals("PAYMENT", paymentInfo.getBizNo());
//        assertEquals(order.getReqId(), paymentInfo.getReqId());
//        assertEquals(order.getGid(), paymentInfo.getGid());
//        assertEquals(order.getPartnerId(), paymentInfo.getPartnerId());
//        assertEquals(merchantInfo.getPartnerName(), paymentInfo.getPartnerName());
//        assertEquals(order.getStationId(), paymentInfo.getStationId());
//        assertEquals(stationInfo.getStationCode(), paymentInfo.getStationCode());
//        assertEquals(stationInfo.getStationName(), paymentInfo.getStationName());
//        if (testId == 1005 || testId == 1006) {//一键加油
//            assertEquals(operatorInfoxx.getUserId(), paymentInfo.getOperateId());
//            assertEquals(operatorInfoxx.getUserName(), paymentInfo.getOperateName());
//            assertEquals(deviceFunction.getDeviceCode(), paymentInfo.getTerminalCode());
//        } else {
//            assertEquals(order.getOperateId(), paymentInfo.getOperateId());
//            assertEquals(operatorInfo.getUserName(), paymentInfo.getOperateName());
//            assertEquals(order.getTerminalCode(), paymentInfo.getTerminalCode());
//        }
//        if (testId == 1004) {
//            assertEquals("00000000000000000000", paymentInfo.getUserId());
//            // assertEquals(null, paymentInfo.getRealName());
//            assertEquals(null, paymentInfo.getNickName());
//            assertEquals(null, paymentInfo.getMemberType());
//            assertEquals(null, paymentInfo.getMobile());
//        } else {
//            assertEquals(cardInfo.getUserId(), paymentInfo.getUserId());
//            // assertEquals(userInfo.getRealName(), paymentInfo.getRealName());
//            assertEquals(gasUserInfo.getNickName(), paymentInfo.getNickName());
//            assertEquals(gasUserInfo.getMemberType(), paymentInfo.getMemberType());
//            assertEquals(gasUserInfo.getMobile(), paymentInfo.getMobile());
//        }
//        if (testId == 1001) {
//            assertEquals(order.getCardNo(), paymentInfo.getCardNo());
//            assertEquals(cardInfo.getCardType(), paymentInfo.getCardType());
//            assertEquals(cardInfo.getTag(), paymentInfo.getCardBizType());
//        } else {
//            assertEquals(null, paymentInfo.getCardNo());
//            assertEquals(null, paymentInfo.getCardType());
//            assertEquals(null, paymentInfo.getCardBizType());
//        }
////        assertEquals("PAYMENT", paymentInfo.getCarNumber());
////        assertEquals("PAYMENT", paymentInfo.getRequestNo());
////        assertEquals("PAYMENT", paymentInfo.getPayNo());
//        assertEquals(order.getTradePayType().code(), paymentInfo.getTradePayType());
//        assertEquals(order.getPayModel().code(), paymentInfo.getPayModel());
//        if (testId == 1001 || testId == 1002 || testId == 1007) {
//            assertEquals(tradeOilOrder.getAmount().add(tradeGoodsOrder.getAmount()), Money.cent(paymentInfo.getAmount()));
////            assertEquals(tradeOilOrder.getAmount().add(tradeGoodsOrder.getAmount()), Money.cent(paymentInfo.getPayAmount()));
//        } else {
//            assertEquals(tradeOilOrder.getAmount(), Money.cent(paymentInfo.getAmount()));
////            assertEquals(tradeOilOrder.getAmount(), Money.cent(paymentInfo.getPayAmount()));
//        }
//        if (testId == 1001 || testId >= 1004 && testId <= 1006) {//1001为油品价格不满足优惠，4-6为商品
//            assertEquals(new Money(0, 0), Money.cent(paymentInfo.getFavourAmount()));
//        } else if (testId == 1002 || testId == 1007) {//直降15，满减5
//            assertEquals(new Money(20, 0), Money.cent(paymentInfo.getFavourAmount()));
//        } else if (testId == 1003) {//直降15，满减5，折扣18.13
//            assertEquals(new Money(38, 13), Money.cent(paymentInfo.getFavourAmount()));
//        } else {//直降10，满减5
//            assertEquals(new Money(15, 0), Money.cent(paymentInfo.getFavourAmount()));
//        }
//        assertEquals(Money.cent(paymentInfo.getPayAmount()), Money.cent(paymentInfo.getAmount()).subtract(Money.cent(paymentInfo.getFavourAmount())));
//        //账户信息
//        if (testId == 1001) {
//            assertEquals(Money.cent(accountInfo.getBalance()).subtract(Money.cent(paymentInfo.getPayAmount())), Money.cent(accountInfoxx.getBalance()));
//            assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
//            assertEquals(Money.cent(accountInfo.getHisInAmount()), Money.cent(accountInfoxx.getHisInAmount()));
//            assertEquals(Money.cent(accountInfo.getHisOutAmount()).add(Money.cent(paymentInfo.getAmount())), Money.cent(accountInfoxx.getHisOutAmount()));
//        } else {
//            assertEquals(Money.cent(accountInfo.getBalance()), Money.cent(accountInfoxx.getBalance()));
//            assertEquals(Money.cent(accountInfo.getFreezeBalance()), Money.cent(accountInfoxx.getFreezeBalance()));
//            assertEquals(Money.cent(accountInfo.getHisInAmount()), Money.cent(accountInfoxx.getHisInAmount()));
//            assertEquals(Money.cent(accountInfo.getHisOutAmount()), Money.cent(accountInfoxx.getHisOutAmount()));
//        }
//        if (testId != 1001) {
//            assertEquals(new Money(0, 0), Money.cent(paymentInfoxx.getBalance()));
//        } else {
//            assertEquals(Money.cent(accountInfoxx.getBalance()).subtract(Money.cent(accountInfoxx.getFreezeBalance())), Money.cent(paymentInfoxx.getBalance()));
//        }
////        assertEquals("PAYMENT", paymentInfo.getMemo());
//        assertEquals("success", paymentInfoxx.getStatus());
//        assertEquals("finished", paymentInfoxx.getState());
//        assertEquals("comn_00_0000", paymentInfoxx.getCode());
//        assertEquals("付款成功", paymentInfoxx.getDescription());
//        assertEquals("付款流程结束", paymentInfoxx.getRunMemo());
////        assertEquals("PAYMENT", paymentInfo.getExpireTime());
////        assertEquals("PAYMENT", paymentInfo.getExtensionContext());
////        assertEquals("PAYMENT", paymentInfo.getFinishTime());
//
//        //油品信息
//        List<GasTradeOilDO> oilInfos = gasTradeTestBase.findGasTradeOilByTradeNo(paymentInfo.getBizNo());
//        if (testId <= 1003 || testId >= 1007 && testId <= 1010) {
//            assertEquals(1, oilInfos.size());
//            for (GasTradeOilDO oilInfo : oilInfos) {
//                assertEquals(paymentInfo.getBizNo(), oilInfo.getTradeNo());
//                assertEquals(tradeOilOrder.getCode(), oilInfo.getCode());
//                assertEquals(oilName, oilInfo.getOilName());
////                assertEquals(GoodsGroupType.GASOLINE.code(), oilInfo.getOilt);
//                assertEquals(price, Money.cent(oilInfo.getPrice()).toString());
//                assertEquals(BaseUtil.div(tradeOilOrder.getAmount().toString(), price, 2), oilInfo.getLiter().toString());
//                assertEquals(tradeOilOrder.getOilGun(), oilInfo.getOilGun());
//                assertEquals(tradeOilOrder.getAmount(), Money.cent(oilInfo.getAmount()));
//            }
//        }
//        //商品信息
//        List<GasTradeGoodsDO> goodsInfos = gasTradeTestBase.findGasTradeGoodsByTradeNo(paymentInfo.getBizNo());
//        if (testId <= 1002 || testId >= 1004 && testId <= 1007) {
//            assertEquals(1, goodsInfos.size());
//            for (GasTradeGoodsDO goodsInfo : goodsInfos) {
//                assertEquals(paymentInfo.getBizNo(), goodsInfo.getTradeNo());
////            assertEquals("PAYMENT", goodsInfo.getGoodsType());
//                assertEquals(tradeGoodsOrder.getCode(), goodsInfo.getCode());
////            assertEquals(goodsName, goodsInfo.getGoodsName());
//                assertEquals(tradeGoodsOrder.getAmount(), Money.cent(goodsInfo.getPrice()));
//                assertEquals(1, goodsInfo.getPiece());
//                assertEquals(tradeGoodsOrder.getAmount(), Money.cent(goodsInfo.getAmount()));
//            }
//        }
//        //积分
//        PointsDO pointsxx = promotionTestBase.findPointsByUserId(userInfo.getUserId()).get(0);
//        if (testId == 1001 || testId == 1004) {
//            assertEquals(points.getPoints().intValue(), pointsxx.getPoints().intValue());
//            assertEquals(points.getHistoryAddPoints().intValue(), pointsxx.getHistoryAddPoints().intValue());
//            assertEquals(points.getHistorySubtractPoints().intValue(), pointsxx.getHistorySubtractPoints().intValue());
//        } else {
//            assertEquals(points.getPoints().intValue() + 10, pointsxx.getPoints().intValue());
//            assertEquals(points.getHistoryAddPoints().intValue() + 10, pointsxx.getHistoryAddPoints().intValue());
//            assertEquals(points.getHistorySubtractPoints().intValue(), pointsxx.getHistorySubtractPoints().intValue());
//        }
//        //券
//        List<CouponDO> coupons = promotionTestBase.findCouponByUserId(userInfo.getUserId());
//        if (testId == 1002 || testId == 1003 || testId == 1007) {
//            assertEquals(1, coupons.size());
//            for (CouponDO coupon : coupons) {
//                assertEquals("001imj6lhzd8s107pr00", coupon.getDefinitionId());
//                assertEquals(order.getPartnerId(), coupon.getPartnerId());
//            }
//        } else {
//            assertEquals(0, coupons.size());
//        }
//        //分析系统
//        //账户变动表
//        List<GasAccountChangeDO> accountChanges = silverboltTestBase.findGasAccountChangeByUserId(userInfo.getUserId());
//        if (testId == 1001) {//余额支付时，才有账户变动记录
//            assertEquals(1, accountChanges.size());
//            for (GasAccountChangeDO accountChange : accountChanges) {
//                assertEquals(paymentInfoxx.getPartnerId(), accountChange.getPartnerId());
//                assertEquals(paymentInfoxx.getStationId(), accountChange.getStationId());
//                assertEquals(paymentInfoxx.getStationName(), accountChange.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), accountChange.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), accountChange.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), accountChange.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), accountChange.getTerminalCode());
//                assertEquals(paymentInfoxx.getRealName(), accountChange.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), accountChange.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), accountChange.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), accountChange.getMobile());
//                assertEquals(AccountChangeMode.OUT.code(), accountChange.getChangeMode());
//                assertEquals(AccountChangeType.BALANCE_TRADE.code(), accountChange.getChangeType());
//                assertEquals(paymentInfoxx.getPayAmount(), accountChange.getAmount());
//                assertEquals(paymentInfoxx.getPartnerName(), accountChange.getPartnerName());
//                assertEquals(paymentInfoxx.getStationCode(), accountChange.getStationCode());
////			assertEquals(paymentInfo.getAmount(), accountChange.getMemo());
////			assertEquals(paymentInfo.getAmount(), accountChange.getChangeTime());
//            }
//        } else {
//            assertEquals(0, accountChanges.size());
//            for (GasAccountChangeDO accountChange : accountChanges) {
//                assertEquals(paymentInfoxx.getPartnerId(), accountChange.getPartnerId());
//                assertEquals(paymentInfoxx.getPartnerName(), accountChange.getPartnerName());
//                assertEquals(paymentInfoxx.getStationId(), accountChange.getStationId());
//                assertEquals(paymentInfoxx.getStationCode(), accountChange.getStationCode());
//                assertEquals(paymentInfoxx.getStationName(), accountChange.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), accountChange.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), accountChange.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), accountChange.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), accountChange.getTerminalCode());
//                assertEquals(paymentInfoxx.getRealName(), accountChange.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), accountChange.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), accountChange.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), accountChange.getMobile());
//                assertEquals(AccountChangeType.DEPOSIT.code(), accountChange.getChangeType());
//                assertEquals(AccountChangeMode.IN.code(), accountChange.getChangeMode());
//                assertEquals(paymentInfoxx.getAmount(), accountChange.getAmount());
////			assertEquals(paymentInfo.getAmount(), accountChange.getMemo());
////			assertEquals(paymentInfo.getAmount(), accountChange.getChangeTime());
//            }
//        }
//        //积分变动
//        List<GasPointsChangeDO> pointsChanges = silverboltTestBase.findGasPointsChangeByUserId(userInfo.getUserId());
//        if (testId == 1001 || testId == 1004) {
//            assertEquals(0, pointsChanges.size());
//        } else {
//            assertTrue(pointsChanges.size() > 0);
//            for (GasPointsChangeDO pointsChange : pointsChanges) {
//                assertEquals(paymentInfoxx.getPartnerId(), pointsChange.getPartnerId());
//                assertEquals(null, pointsChange.getPartnerName());
//                assertEquals(paymentInfoxx.getStationId(), pointsChange.getStationId());
//                assertEquals(null, pointsChange.getStationCode());
//                assertEquals(paymentInfoxx.getStationName(), pointsChange.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), pointsChange.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), pointsChange.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), pointsChange.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), pointsChange.getTerminalCode());
//                assertEquals(paymentInfoxx.getRealName(), pointsChange.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), pointsChange.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), pointsChange.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), pointsChange.getMobile());
//                assertEquals(PointChangeType.PRESENT.code(), pointsChange.getChangeType());
//                assertEquals(AccountChangeMode.IN.code(), pointsChange.getChangeMode());
//                assertEquals(10L, pointsChange.getPoints());
////			assertEquals(paymentInfo.getAmount(), accountChange.getMemo());
////			assertEquals(paymentInfo.getAmount(), accountChange.getChangeTime());
//            }
//        }
//        //优惠:营销的数据就直接写死了，后面再改。付款对应的活动ID:001imjlz1nl4g045ek00
//        List<GasTradeFavourDO> favours = silverboltTestBase.findGasTradeFavourByBizNo(result.getInfo().getBizNo());
//        if (testId == 1001 || testId >= 1004 && testId <= 1006) {
//            assertEquals(0, favours.size());
//        } else if (testId == 1003) {//直降15.12，满减5，折扣18.13
//            assertEquals(3, favours.size());
//            for (GasTradeFavourDO favour : favours) {
//                assertEquals(paymentInfoxx.getBizNo(), favour.getBizNo());
//                assertEquals(TradeType.PAYMENT.code(), favour.getTradeType());
//                assertEquals(paymentInfoxx.getPartnerId(), favour.getPartnerId());
//                assertEquals(paymentInfoxx.getPartnerName(), favour.getPartnerName());
//                assertEquals(paymentInfoxx.getStationId(), favour.getStationId());
//                assertEquals(paymentInfoxx.getStationCode(), favour.getStationCode());
//                assertEquals(paymentInfoxx.getStationName(), favour.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), favour.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), favour.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), favour.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), favour.getTerminalCode());
//                assertEquals(paymentInfoxx.getRealName(), favour.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), favour.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), favour.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), favour.getMobile());
//                assertEquals(null, favour.getCardNo());
//                assertEquals(order.getTradePayType().code(), favour.getTradePayType());
//                assertEquals(order.getPayModel().code(), favour.getPayModel());
//                assertEquals("001imjlz1nl4g045ek00", favour.getFavourId());
//                assertEquals("消费活动", favour.getFavourName());
//                assertEquals(FavourType.CAMPAIGN_FAVOUR.code(), favour.getFavourType());
//                if (PromotionWay.fullReduce.code().equals(favour.getFavourRule())) {
//                    //assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                    assertEquals(new Money(5, 0), Money.cent(favour.getFavourAmount()));
//                }
//                if (PromotionWay.priceReduce.code().equals(favour.getFavourRule())) {
//                    // assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                    assertEquals(new Money(15, 12), Money.cent(favour.getFavourAmount()));
//                }
//                if (PromotionWay.rebate.code().equals(favour.getFavourRule())) {
//                    // assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                    assertEquals(new Money(18, 13), Money.cent(favour.getFavourAmount()));
//                }
//                assertEquals(paymentInfoxx.getStatus(), favour.getStatus());
//                assertEquals(paymentInfoxx.getState(), favour.getState());
//                assertEquals(paymentInfoxx.getRawAddTime(), favour.getCreateTime());
//                assertEquals(paymentInfoxx.getFinishTime(), favour.getFinishTime());
////			assertEquals(paymentInfo.getAmount(), accountChange.getMemo());
////			assertEquals(paymentInfo.getAmount(), accountChange.getChangeTime());
//            }
//        } else if (testId == 1002 || testId == 1007) {
//            assertEquals(2, favours.size());
//            for (GasTradeFavourDO favour : favours) {
//                assertEquals(paymentInfoxx.getBizNo(), favour.getBizNo());
//                assertEquals(TradeType.PAYMENT.code(), favour.getTradeType());
//                assertEquals(paymentInfoxx.getPartnerId(), favour.getPartnerId());
//                assertEquals(paymentInfoxx.getPartnerName(), favour.getPartnerName());
//                assertEquals(paymentInfoxx.getStationId(), favour.getStationId());
//                assertEquals(paymentInfoxx.getStationCode(), favour.getStationCode());
//                assertEquals(paymentInfoxx.getStationName(), favour.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), favour.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), favour.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), favour.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), favour.getTerminalCode());
//                assertEquals(paymentInfoxx.getRealName(), favour.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), favour.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), favour.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), favour.getMobile());
//                assertEquals(null, favour.getCardNo());
//                assertEquals(order.getTradePayType().code(), favour.getTradePayType());
//                assertEquals(order.getPayModel().code(), favour.getPayModel());
//                assertEquals("001imjlz1nl4g045ek00", favour.getFavourId());
//                assertEquals("消费活动", favour.getFavourName());
//                assertEquals(FavourType.CAMPAIGN_FAVOUR.code(), favour.getFavourType());
//                assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                if (PromotionWay.fullReduce.code().equals(favour.getFavourRule())) {
//                    //assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                    assertEquals(new Money(5, 0), Money.cent(favour.getFavourAmount()));
//                }
//                if (PromotionWay.priceReduce.code().equals(favour.getFavourRule())) {
//                    // assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                    assertEquals(new Money(15, 0), Money.cent(favour.getFavourAmount()));
//                }
//                assertEquals(paymentInfoxx.getStatus(), favour.getStatus());
//                assertEquals(paymentInfoxx.getState(), favour.getState());
//                assertEquals(paymentInfoxx.getRawAddTime(), favour.getCreateTime());
//                assertEquals(paymentInfoxx.getFinishTime(), favour.getFinishTime());
////			assertEquals(paymentInfo.getAmount(), accountChange.getMemo());
////			assertEquals(paymentInfo.getAmount(), accountChange.getChangeTime());
//            }
//        } else {//直降15，满减5
//            assertEquals(2, favours.size());
//            for (GasTradeFavourDO favour : favours) {
//                assertEquals(paymentInfoxx.getBizNo(), favour.getBizNo());
//                assertEquals(TradeType.PAYMENT.code(), favour.getTradeType());
//                assertEquals(paymentInfoxx.getPartnerId(), favour.getPartnerId());
//                assertEquals(paymentInfoxx.getPartnerName(), favour.getPartnerName());
//                assertEquals(paymentInfoxx.getStationId(), favour.getStationId());
//                assertEquals(paymentInfoxx.getStationCode(), favour.getStationCode());
//                assertEquals(paymentInfoxx.getStationName(), favour.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), favour.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), favour.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), favour.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), favour.getTerminalCode());
//                assertEquals(paymentInfoxx.getRealName(), favour.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), favour.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), favour.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), favour.getMobile());
//                assertEquals(null, favour.getCardNo());
//                assertEquals(order.getTradePayType().code(), favour.getTradePayType());
//                assertEquals(order.getPayModel().code(), favour.getPayModel());
//                assertEquals("001imjlz1nl4g045ek00", favour.getFavourId());
//                assertEquals("消费活动", favour.getFavourName());
//                assertEquals(FavourType.CAMPAIGN_FAVOUR.code(), favour.getFavourType());
//                if (PromotionWay.fullReduce.code().equals(favour.getFavourRule())) {
//                    //assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                    assertEquals(new Money(5, 0), Money.cent(favour.getFavourAmount()));
//                }
//                if (PromotionWay.priceReduce.code().equals(favour.getFavourRule())) {
//                    // assertEquals(FavourCategory.GAS.code(), favour.getFavourCategory());
//                    assertEquals(new Money(10, 0), Money.cent(favour.getFavourAmount()));
//                }
//                assertEquals(paymentInfoxx.getStatus(), favour.getStatus());
//                assertEquals(paymentInfoxx.getState(), favour.getState());
//                assertEquals(paymentInfoxx.getRawAddTime(), favour.getCreateTime());
//                assertEquals(paymentInfoxx.getFinishTime(), favour.getFinishTime());
////			assertEquals(paymentInfo.getAmount(), accountChange.getMemo());
////			assertEquals(paymentInfo.getAmount(), accountChange.getChangeTime());
//            }
//        }
//        //交易订单
//        List<GasTradeOrderDO> tradeOrders = silverboltTestBase.findGasTradeOrderByBizNo(result.getInfo().getBizNo());
//        assertTrue(tradeOrders.size() > 0);
//        for (GasTradeOrderDO tradeOrder : tradeOrders) {
//            assertEquals(paymentInfoxx.getTradeType(), tradeOrder.getTradeType());
//            assertEquals(order.getOrderType().code(), tradeOrder.getOrderType());
//            assertEquals(paymentInfoxx.getReqId(), tradeOrder.getReqId());
//            assertEquals(paymentInfoxx.getGid(), tradeOrder.getGid());
//            assertEquals(null, tradeOrder.getTradeNo());//冲退、退款的原流水号
//            assertEquals(paymentInfoxx.getPartnerId(), tradeOrder.getPartnerId());
//            assertEquals(paymentInfoxx.getPartnerName(), tradeOrder.getPartnerName());
//            assertEquals(paymentInfoxx.getStationId(), tradeOrder.getStationId());
//            assertEquals(paymentInfoxx.getStationCode(), tradeOrder.getStationCode());
//            assertEquals(paymentInfoxx.getStationName(), tradeOrder.getStationName());
//            assertEquals(paymentInfoxx.getOperateId(), tradeOrder.getOperateId());
//            assertEquals(paymentInfoxx.getOperateName(), tradeOrder.getOperateName());
//            assertEquals(paymentInfoxx.getTerminalType(), tradeOrder.getTerminalType());
//            assertEquals(paymentInfoxx.getTerminalCode(), tradeOrder.getTerminalCode());
//            assertEquals(paymentInfoxx.getRealName(), tradeOrder.getRealName());
//            assertEquals(paymentInfoxx.getNickName(), tradeOrder.getNickName());
//            assertEquals(paymentInfoxx.getMemberType(), tradeOrder.getMemberType());
//            assertEquals(paymentInfoxx.getMobile(), tradeOrder.getMobile());
//            assertEquals(paymentInfoxx.getCardNo(), tradeOrder.getCardNo());
//            assertEquals(paymentInfoxx.getCardBizType(), tradeOrder.getCardBizType());
//            assertEquals(paymentInfoxx.getCardType(), tradeOrder.getCardType());
//            assertEquals(paymentInfoxx.getCarNumber(), tradeOrder.getCarNumber());
//            assertEquals(paymentInfoxx.getBalance(), tradeOrder.getBalance());
//            if (testId <= 1003 || testId >= 1007 && testId <= 1010) {
//                assertEquals(GoodsGroupType.GASOLINE.code(), tradeOrder.getOilType());
//                assertEquals(oilInfos.get(0).getCode(), tradeOrder.getOilCode());
//                assertEquals(oilInfos.get(0).getOilName(), tradeOrder.getOilName());
//                assertEquals(oilInfos.get(0).getAmount(), tradeOrder.getOilAmount());
//                if (testId == 1001) {//1001为油品价格不满足优惠
//                    assertEquals(new Money(0, 0), Money.cent(tradeOrder.getOilFavourAmount()));
//                } else if (testId == 1002 || testId == 1007) {//直降15，满减5
//                    assertEquals(new Money(20, 0), Money.cent(tradeOrder.getOilFavourAmount()));
//                } else if (testId == 1003) {//直降15.12，满减5，折扣18.13
//                    assertEquals(new Money(38, 25), Money.cent(tradeOrder.getOilFavourAmount()));
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
//            assertEquals(paymentInfoxx.getPayNo(), tradeOrder.getPayNo());
//            assertEquals(order.getTradePayType().code(), tradeOrder.getTradePayType());
//            assertEquals(order.getPayModel().code(), tradeOrder.getPayModel());
//            assertEquals(paymentInfoxx.getAmount(), tradeOrder.getAmount());
//            assertEquals(paymentInfoxx.getPayAmount(), tradeOrder.getPayAmount());
//            assertEquals(paymentInfoxx.getFavourAmount(), tradeOrder.getFavourAmount());
//            assertEquals(paymentInfoxx.getStatus(), tradeOrder.getStatus());
//            assertEquals(paymentInfoxx.getState(), tradeOrder.getState());
////			assertEquals(paymentInfo.getAmount(), tradeOrder.getMemo());
////			assertEquals(paymentInfo.getAmount(), tradeOrder.getChangeTime());
//        }
//        //油品信息
//        List<dal.model.gas_silverbolt.GasTradeOilDO> silverOilInfos = silverboltTestBase.findGasTradeOilByBizNo(paymentInfo.getBizNo());
//        if (testId <= 1003 || testId >= 1007 && testId <= 1010) {
//            assertEquals(1, silverOilInfos.size());
//            for (dal.model.gas_silverbolt.GasTradeOilDO oilInfo : silverOilInfos) {
//                assertEquals(paymentInfoxx.getTradeType(), oilInfo.getTradeType());
//                assertEquals(null, oilInfo.getTradeNo());
//                assertEquals(paymentInfoxx.getPartnerId(), oilInfo.getPartnerId());
//                assertEquals(paymentInfoxx.getPartnerName(), oilInfo.getPartnerName());
//                assertEquals(paymentInfoxx.getStationId(), oilInfo.getStationId());
//                assertEquals(paymentInfoxx.getStationCode(), oilInfo.getStationCode());
//                assertEquals(paymentInfoxx.getStationName(), oilInfo.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), oilInfo.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), oilInfo.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), oilInfo.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), oilInfo.getTerminalCode());
//                assertEquals(paymentInfoxx.getUserId(), oilInfo.getUserId());
//                assertEquals(paymentInfoxx.getRealName(), oilInfo.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), oilInfo.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), oilInfo.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), oilInfo.getMobile());
//                if (testId == 1001) {
//                    assertEquals(order.getCardNo(), oilInfo.getCardNo());
//                } else {
//                    assertEquals(null, oilInfo.getCardNo());
//                }
//                assertEquals(paymentInfoxx.getCarNumber(), oilInfo.getCarNumber());
//                assertEquals(GoodsGroupType.GASOLINE.code(), oilInfo.getOilType());
//                assertEquals(oilInfos.get(0).getCode(), oilInfo.getOilCode());
//                assertEquals(oilInfos.get(0).getOilName(), oilInfo.getOilName());
//                assertEquals(oilInfos.get(0).getPrice(), oilInfo.getOilPrice());
//                assertEquals(oilInfos.get(0).getLiter(), oilInfo.getOilLiter());
//                assertEquals(oilInfos.get(0).getOilGun(), oilInfo.getOilGun());
//                assertEquals(oilInfos.get(0).getAmount(), oilInfo.getOilAmount());
////                assertEquals(oilInfos.get(0).getOilFavourAmount(), oilInfo.getOilFavourAmount());
//                if (testId == 1001) {//1001为油品价格不满足优惠
//                    assertEquals(new Money(0, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                } else if (testId == 1002 || testId == 1007) {//直降15，满减5
//                    assertEquals(new Money(20, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                } else if (testId == 1003) {//直降15.12，满减5，折扣18.13
//                    assertEquals(new Money(38, 25), Money.cent(oilInfo.getOilFavourAmount()));
//                } else {//直降10，满减5
//                    assertEquals(new Money(15, 0), Money.cent(oilInfo.getOilFavourAmount()));
//                }
//                assertEquals(paymentInfoxx.getTradePayType(), oilInfo.getTradePayType());
//                assertEquals(paymentInfoxx.getPayModel(), oilInfo.getPayModel());
//                assertEquals(paymentInfoxx.getStatus(), oilInfo.getStatus());
//                assertEquals(paymentInfoxx.getState(), oilInfo.getState());
//            }
//        } else {
//            assertEquals(0, silverOilInfos.size());
//        }
//        //商品信息
//        List<dal.model.gas_silverbolt.GasTradeGoodsDO> silverGoodsInfos = silverboltTestBase.findGasTradeGoodsByBizNo(paymentInfo.getBizNo());
//        if (testId <= 1002 || testId >= 1004 && testId <= 1007) {
//            assertEquals(1, silverGoodsInfos.size());
//            for (dal.model.gas_silverbolt.GasTradeGoodsDO goodsInfo : silverGoodsInfos) {
//                assertEquals(paymentInfoxx.getTradeType(), goodsInfo.getTradeType());
//                assertEquals(null, goodsInfo.getTradeNo());
//                assertEquals(paymentInfoxx.getPartnerId(), goodsInfo.getPartnerId());
//                assertEquals(paymentInfoxx.getPartnerName(), goodsInfo.getPartnerName());
//                assertEquals(paymentInfoxx.getStationId(), goodsInfo.getStationId());
//                assertEquals(paymentInfoxx.getStationCode(), goodsInfo.getStationCode());
//                assertEquals(paymentInfoxx.getStationName(), goodsInfo.getStationName());
//                assertEquals(paymentInfoxx.getOperateId(), goodsInfo.getOperateId());
//                assertEquals(paymentInfoxx.getOperateName(), goodsInfo.getOperateName());
//                assertEquals(paymentInfoxx.getTerminalType(), goodsInfo.getTerminalType());
//                assertEquals(paymentInfoxx.getTerminalCode(), goodsInfo.getTerminalCode());
//                assertEquals(paymentInfoxx.getUserId(), goodsInfo.getUserId());
//                assertEquals(paymentInfoxx.getRealName(), goodsInfo.getRealName());
//                assertEquals(paymentInfoxx.getNickName(), goodsInfo.getNickName());
//                assertEquals(paymentInfoxx.getMemberType(), goodsInfo.getMemberType());
//                assertEquals(paymentInfoxx.getMobile(), goodsInfo.getMobile());
//                if (testId == 1001) {
//                    assertEquals(order.getCardNo(), goodsInfo.getCardNo());
//                } else {
//                    assertEquals(null, goodsInfo.getCardNo());
//                }
//                assertEquals(goodsInfos.get(0).getGoodsType(), goodsInfo.getGoodsType());
//                assertEquals(goodsInfos.get(0).getCode(), goodsInfo.getGoodsCode());
//                assertEquals(goodsInfos.get(0).getGoodsName(), goodsInfo.getGoodsName());
//                assertEquals(goodsInfos.get(0).getPrice(), goodsInfo.getGoodsPrice());
//                assertEquals(goodsInfos.get(0).getPiece(), goodsInfo.getGoodsPiece());
//                assertEquals(goodsInfos.get(0).getAmount(), goodsInfo.getGoodsAmount());
//                assertEquals(new Money(0, 0), Money.cent(goodsInfo.getGoodsFavourAmount()));
//                assertEquals(paymentInfoxx.getTradePayType(), goodsInfo.getTradePayType());
//                assertEquals(paymentInfoxx.getPayModel(), goodsInfo.getPayModel());
//                assertEquals(paymentInfoxx.getStatus(), goodsInfo.getStatus());
//                assertEquals(paymentInfoxx.getState(), goodsInfo.getState());
//            }
//        } else {
//            assertEquals(0, silverGoodsInfos.size());
//        }
//        // 清除数据
//        gasTradeTestBase.cleanGasTradePaymentByBizNo(result.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeGoodsByTradeNo(result.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeOilByTradeNo(result.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeNotifyTaskByBizNo(result.getInfo().getBizNo());
//        gasTradeTestBase.cleanGasTradeFavourByBizNo(result.getInfo().getBizNo());
//        // promotionTestBase.cleanCouponByUserId(userInfo.getUserId());
//        promotionTestBase.cleanPointsByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasAccountChangeByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasPointsChangeByUserId(userInfo.getUserId());
//        silverboltTestBase.cleanGasTradeFavourByBizNo(result.getInfo().getBizNo());
//        silverboltTestBase.cleanGasTradeOrderByBizNo(result.getInfo().getBizNo());
//        silverboltTestBase.cleanGasTradeGoodsByBizNo(result.getInfo().getBizNo());
//        silverboltTestBase.cleanGasTradeOilByBizNo(result.getInfo().getBizNo());
//    }
//}
