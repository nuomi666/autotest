//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeGoodsOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentOrder;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import dal.model.gas_trade.GasTradePaymentDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/9/6
// */
//public class ScheduleCallBackServicePaymentSuspendTest extends SpringBootTestBase {
//
//    @Reference(group = "gas_trade_payment_suspend", version = "1.0")
//    ScheduleCallBackService paymentSuspend;
//
//    @Reference(version = "1.0")
//    TradePaymentService tradePaymentService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_trade/scheduleCallBackServicePaymentSuspendTestSuccess.csv")
//    @DisplayName("付款挂起定时重试--成功用例")
//    public void scheduleCallBackServicePaymentSuspendTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TradePaymentOrder order,
//            TradeOilOrder tradeOilOrder,
//            TradeGoodsOrder tradeGoodsOrder,
//            // 结果参数
//            String description,
//            String message
//    ) {
//        // 清除数据
//        // 准备数据
//        String reqId = OID.newID();
//        String gid = GID.newGID();
//        order.setReqId(reqId);
//        tradeOilOrder.setCode("#95");
//        tradeGoodsOrder.setAmount(new Money(120, 0));
//        List<TradeGoodsOrder> goodsOrders = new ArrayList<TradeGoodsOrder>();
//        goodsOrders.add(tradeGoodsOrder);
//        if (testId != 1001) {
//            order.setTradeOilOrder(tradeOilOrder);
//        }
//        if (testId != 1003) {
//            order.setGoodsOrders(goodsOrders);
//        }
//        if (testId == 1001) {
//            order.setCardNo(null);
//        }
//        order.setGid(gid);
//        BizResult<TradePaymentInfo> result = tradePaymentService.tradePayment(order);
//        GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByReqId(reqId).get(0);
////        assertEquals("processing", paymentInfo.getState());
////        assertEquals("pay_suspend", paymentInfo.getStatus());
////        assertEquals("G03_02_0001", paymentInfo.getCode());
//        // 测试过程
//        // 调用接口
//        paymentSuspend.justDoIT();
//        GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByReqId(reqId).get(0);
//        assertEquals("finished", paymentInfoxx.getState());
//        assertEquals("pay_advance", paymentInfoxx.getStatus());
//        assertEquals("comn_07_0000", paymentInfoxx.getCode());
//        // 结果验证
//        // 数据验证
//        // 清除数据
//    }
//}
