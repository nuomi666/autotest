//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.google.common.collect.Maps;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.UserTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.notify.TransNotifyService;
//import com.xyb.adk.common.lang.order.TransNotifyOrder;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.gas.trade.api.enums.OrderType;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentOrder;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/12/21
// */
//public class TradeNotify extends SpringBootTestBase {
//
//    @Reference(group = "gas_trade_payment_advance", version = "1.0")
//    TransNotifyService payment;
//
//    @Reference(version = "1.0")
//    TradePaymentService tradePaymentService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    @Autowired
//    UserTestBase userTestBase;
//
//    @Autowired
//    Gas_userTestBase gasUserTestBase;
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_trade/tradeNotifyTestSuccess.csv")
//    @DisplayName("模拟通知回调--成功用例")
//    public void tradeNotifyTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TransNotifyOrder notifyOrder,
//            GasTradePaymentDO gasTradePaymentDO,
//            UserCardInfoDO userCardInfoDO,
//            UserDO gasUserDO,
//            dal.model.user.UserDO userDO,
//            AccountDO accountDO,
//            TradeOilOrder tradeOilOrder,
//            TradePaymentOrder order
//    ) {
//        // 清除数据
//        gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradePaymentDO.getBizNo());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//        // 准备数据
//        if(testId>1002) {
//            gasTradeTestBase.insertGasTradePayment(gasTradePaymentDO);
//        }
//        gasUserTestBase.insertUser(gasUserDO);
//        gasUserTestBase.insertUserCardInfo(userCardInfoDO);
//        userTestBase.insertUser(userDO);
//        userTestBase.insertAccount(accountDO);
//        String reqId="";
//        if(testId<=1002) {
//            order.setTradeOilOrder(tradeOilOrder);
//            order.setGid(GID.newGID());
//            order.setMerchantOrderNo(OID.newID());
//            order.setReqId(OID.newID());
//            BizResult<TradePaymentInfo> result = tradePaymentService.tradePayment(order);
//            print(result);
//            reqId=gasTradeTestBase.findGasTradePaymentByBizNo(result.getInfo().getBizNo()).get(0).getRequestNo();
//        }
//        // 测试过程
//        Map<String, Object> context = Maps.newHashMap();
//        notifyOrder.setBizNo(OID.newID());
//        notifyOrder.setGid(GID.newGID());
//        if(testId<=1002){
//            notifyOrder.setReqId(reqId);
//        }
//        // 调用接口
//        SimpleResult notifyResult=payment.notify(notifyOrder);
//        // 结果验证
//        print(notifyResult);
//        assertEquals(status,notifyResult.getStatus());
//        // 数据验证
//        GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByRequestNo(notifyOrder.getReqId()).get(0);
//        if(testId==1001||testId==1005||testId==1006) {
//            assertEquals("finished", paymentInfoxx.getState());
//            assertEquals("success", paymentInfoxx.getStatus());
//            assertEquals("comn_00_0000", paymentInfoxx.getCode());
//        }else if(testId==1002){
//            assertEquals("finished", paymentInfoxx.getState());
//            assertEquals(notifyOrder.getStatus().code(), paymentInfoxx.getStatus());
//            assertEquals(notifyOrder.getCode(), paymentInfoxx.getCode());
//        }else{
//            assertEquals(gasTradePaymentDO.getState(), paymentInfoxx.getState());
//            assertEquals(gasTradePaymentDO.getStatus(), paymentInfoxx.getStatus());
//            assertEquals(gasTradePaymentDO.getCode(), paymentInfoxx.getCode());
//        }
//        AccountDO acc=userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
//        if(testId==1001) {
//            assertEquals(Money.cent(accountDO.getBalance()).subtract(Money.cent(paymentInfoxx.getPayAmount())), Money.cent(acc.getBalance()));
//            assertEquals(Money.cent(accountDO.getHisOutAmount()).add(Money.cent(paymentInfoxx.getPayAmount())), Money.cent(acc.getHisOutAmount()));
//        }else {
//            assertEquals(Money.cent(accountDO.getBalance()), Money.cent(acc.getBalance()));
//            assertEquals(Money.cent(accountDO.getHisOutAmount()), Money.cent(acc.getHisOutAmount()));
//        }
//        // 清除数据
//        gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradePaymentDO.getBizNo());
//        gasTradeTestBase.cleanGasTradePaymentByRequestNo(notifyOrder.getReqId());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//    }
//}
