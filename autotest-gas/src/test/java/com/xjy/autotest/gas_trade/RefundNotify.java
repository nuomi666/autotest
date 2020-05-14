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
//import com.xjy.common.util.Money;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.notify.TransNotifyService;
//import com.xyb.adk.common.lang.order.TransNotifyOrder;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.trade.api.service.TradeRefundService;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_trade.GasTradeRefundDO;
//import dal.model.gas_user.UserCardInfoDO;
//import dal.model.gas_user.UserDO;
//import dal.model.user.AccountDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//import java.util.Map;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/12/21
// */
//public class RefundNotify extends SpringBootTestBase {
//    @Reference(version = "1.0")
//    TradeRefundService tradeRefundService;
//
//    @Reference(group = "gas_trade_refund_advance", version = "1.0")
//    TransNotifyService refund;
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
//     * 交易流水号为充值表里的biz_no
//     */
//    @AutoTest(file = "gas_trade/refundNotifyTestSuccessxx.csv")
//    @DisplayName("退款通知任务重试--成功用例")
//    public void refundNotifyTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TransNotifyOrder notifyOrder,
//            GasTradePaymentDO gasTradePaymentDO,
//            GasTradeRefundDO gasTradeRefundDO,
//            UserCardInfoDO userCardInfoDO,
//            UserDO gasUserDO,
//            dal.model.user.UserDO userDO,
//            AccountDO accountDO
//    ) {
//        // 清除数据
//        gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradePaymentDO.getBizNo());
//        gasTradeTestBase.cleanGasTradeRefundByBizNo(gasTradeRefundDO.getBizNo());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//        // 准备数据
//        gasTradeTestBase.insertGasTradePayment(gasTradePaymentDO);
//        gasTradeTestBase.insertGasTradeRefund(gasTradeRefundDO);
//        gasUserTestBase.insertUser(gasUserDO);
//        gasUserTestBase.insertUserCardInfo(userCardInfoDO);
//        userTestBase.insertUser(userDO);
//        userTestBase.insertAccount(accountDO);
//        // 测试过程
//        Map<String, Object> context = Maps.newHashMap();
//        notifyOrder.setBizNo(OID.newID());
//        notifyOrder.setGid(GID.newGID());
//        //调接口
//        SimpleResult notifyResult=refund.notify(notifyOrder);
//        // 结果验证
//        print(notifyResult);
//        assertEquals(status,notifyResult.getStatus());
//        // 数据验证
//        GasTradeRefundDO refundInfoxx = gasTradeTestBase.findGasTradeRefundByBizNo(gasTradeRefundDO.getBizNo()).get(0);
//        if(testId==1001||testId==1005||testId==1006) {
//            assertEquals("finished", refundInfoxx.getState());
//            assertEquals("success", refundInfoxx.getStatus());
//            assertEquals("comn_00_0000", refundInfoxx.getCode());
//        }else {
//            assertEquals("finished", refundInfoxx.getState());
//            assertEquals("fail", refundInfoxx.getStatus());
//            assertEquals(gasTradeRefundDO.getCode(), refundInfoxx.getCode());
//        }
//        GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByBizNo(gasTradePaymentDO.getBizNo()).get(0);
//        if(testId==1001||testId==1005||testId==1006) {
//            assertEquals("refunded", paymentInfoxx.getState());
//            assertEquals("success", paymentInfoxx.getStatus());
//            assertEquals("comn_00_0000", paymentInfoxx.getCode());
//        }else {
//            assertEquals("finished", paymentInfoxx.getState());
//            assertEquals("success", paymentInfoxx.getStatus());
//            assertEquals("comn_00_0000", paymentInfoxx.getCode());
//        }
//        AccountDO acc=userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);
//        if(testId==1001) {
//            assertEquals(Money.cent(accountDO.getBalance()).add(Money.cent(refundInfoxx.getPayAmount())), Money.cent(acc.getBalance()));
//            assertEquals(Money.cent(accountDO.getHisOutAmount()).subtract(Money.cent(refundInfoxx.getPayAmount())), Money.cent(acc.getHisOutAmount()));
//        }else {
//            assertEquals(Money.cent(accountDO.getBalance()), Money.cent(acc.getBalance()));
//            assertEquals(Money.cent(accountDO.getHisOutAmount()), Money.cent(acc.getHisOutAmount()));
//        }
//        // 清除数据
//        gasTradeTestBase.cleanGasTradePaymentByBizNo(gasTradePaymentDO.getBizNo());
//        gasTradeTestBase.cleanGasTradeRefundByBizNo(gasTradeRefundDO.getBizNo());
//        gasUserTestBase.cleanUserByUserId(gasUserDO.getUserId());
//        gasUserTestBase.cleanUserCardInfoByCardNo(userCardInfoDO.getCardNo());
//        userTestBase.cleanUserByUserId(userDO.getUserId());
//        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
//    }
//}
