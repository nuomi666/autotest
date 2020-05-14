//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import com.xyb.gas.trade.api.order.TradeRefundOrder;
//import com.xyb.gas.trade.api.service.TradeRefundService;
//import dal.model.gas_trade.GasTradeNotifyTaskDO;
//import dal.model.gas_trade.GasTradePaymentDO;
//import dal.model.gas_trade.GasTradeRefundDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/11/6
// */
//public class ScheduleCallBackServiceRefundNotifyRetryTest extends SpringBootTestBase {
//    @Reference(version = "1.0")
//    TradeRefundService tradeRefundService;
//
//    @Reference(group = "gas_trade_refund_notify_retry", version = "1.0")
//    ScheduleCallBackService notifyRetry;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    /**
//     * 交易流水号为充值表里的biz_no
//     */
//    @AutoTest(file = "gas_trade/scheduleCallBackServiceRefundNotifyRetryTestSuccess.csv")
//    @DisplayName("退款通知任务重试--成功用例")
//    public void scheduleCallBackServiceRefundNotifyRetryTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            // 业务参数
//            TradeRefundOrder order
//    ) {
//        // 清除数据
//        // 准备数据
//        order.setGid(GID.newGID());
//        order.setReqId(OID.newID());
//        order.setMerchantOrderNo(OID.newID());
//        order.setTradeNo("001in3sp1fvkg035ej00");
////        BizResult<TradeRefundPayInfo> result = tradeRefundService.tradeRefund(order);
////        print(result);
////        assertEquals(status, result.getStatus());
//        GasTradeRefundDO refundInfo = gasTradeTestBase.findGasTradeRefundByTradeNo("001in3sp1fvkg035ej00").get(0);
//        assertEquals("finished", refundInfo.getState());
//        assertEquals("success", refundInfo.getStatus());
//        assertEquals("comn_00_0000", refundInfo.getCode());
////        GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByReqId(reqId).get(0);
////        assertEquals("refunding", paymentInfo.getState());
////        assertEquals("success", paymentInfo.getStatus());
////        assertEquals("comn_00_0000", paymentInfo.getCode());
//        // 测试过程
//        // 调用接口
//        notifyRetry.justDoIT();
//        // 结果验证
//        // 数据验证
//        GasTradeRefundDO refundInfoxx = gasTradeTestBase.findGasTradeRefundByBizNo("001in3sp1fvkg035ej00").get(0);
//        assertEquals("finished", refundInfoxx.getState());
//        assertEquals("success", refundInfoxx.getStatus());
//        assertEquals("comn_00_0000", refundInfoxx.getCode());
//        GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByBizNo("001iggnzksf8g035ej00").get(0);
//        assertEquals("refunded", paymentInfoxx.getState());
//        assertEquals("success", paymentInfoxx.getStatus());
//        assertEquals("comn_00_0000", paymentInfoxx.getCode());
//        List<GasTradeNotifyTaskDO> notifyTaskInfoxxs = gasTradeTestBase.findGasTradeNotifyTaskByBizNo("001in35jzuhog035ej00");
//        for (GasTradeNotifyTaskDO GasTradeNotifyTaskDOxx : notifyTaskInfoxxs) {
//            assertEquals("success", GasTradeNotifyTaskDOxx.getStatus());
//        }
//        // 清除数据
//    }
//}
