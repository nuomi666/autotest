//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_silverboltTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import com.xyb.gas.trade.api.info.TradePaymentInfo;
//import com.xyb.gas.trade.api.order.TradeGoodsOrder;
//import com.xyb.gas.trade.api.order.TradeOilOrder;
//import com.xyb.gas.trade.api.order.TradePaymentOrder;
//import com.xyb.gas.trade.api.service.TradePaymentService;
//import dal.model.gas_silverbolt.GasTradeGoodsDO;
//import dal.model.gas_silverbolt.GasTradeOilDO;
//import dal.model.gas_silverbolt.GasTradeOrderDO;
//import dal.model.gas_trade.GasTradeNotifyTaskDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/9/7
// */
//public class ScheduleCallBackServicePaymentNotifyTest extends SpringBootTestBase {
//    @Reference(group = "gas_trade_payment_notify_retry", version = "1.0")
//    ScheduleCallBackService paymentNotify;
//
//    @Reference(version = "1.0")
//    TradePaymentService tradePaymentService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    @Autowired
//    Gas_silverboltTestBase silverboltTestBase;
//
//    /**
//     * 修改mq配置后走一笔付款，然后改回来再调重推的定时任务
//     */
//    @AutoTest(file = "gas_trade/scheduleCallBackServicePaymentNotifyTestSuccess.csv")
//    @DisplayName("付款通知任务重试--成功用例")
//    public void scheduleCallBackServicePaymentNotifyTestSuccess(
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
//        order.setReqId(OID.newID());
//        tradeOilOrder.setCode("#95");
//        List<TradeGoodsOrder> goodsOrders = new ArrayList<TradeGoodsOrder>();
//        goodsOrders.add(tradeGoodsOrder);
//        if (testId != 1004) {
//            order.setTradeOilOrder(tradeOilOrder);
//        }
//        if (testId != 1003) {
//            order.setGoodsOrders(goodsOrders);
//        }
//        if (testId == 1004) {
//            order.setCardNo(null);
//        }
//        order.setGid(GID.newGID());
//        BizResult<TradePaymentInfo> result = tradePaymentService.tradePayment(order);
//        print(result);
//        assertEquals(status, result.getStatus());
////        GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByBizNo(result.getInfo().getBizNo()).get(0);
////        assertEquals("finished", paymentInfo.getState());
////        assertEquals("success", paymentInfo.getStatus());
////        assertEquals("comn_00_0000", paymentInfo.getCode());
//        List<GasTradeNotifyTaskDO> notifyTaskInfos = gasTradeTestBase.findGasTradeNotifyTaskByBizNo("001in35jzuhog035ej00");
//        for (GasTradeNotifyTaskDO GasTradeNotifyTaskDO : notifyTaskInfos) {
//            assertEquals("fail", GasTradeNotifyTaskDO.getStatus());
//        }
//        List<GasTradeOrderDO> gasTradeOrderDOS = silverboltTestBase.findGasTradeOrderByBizNo("001in35jzuhog035ej00");
//        assertEquals(0, gasTradeOrderDOS.size());
//        // 测试过程
//        // 调用接口
//        paymentNotify.justDoIT();
//        List<GasTradeNotifyTaskDO> notifyTaskInfoxxs = gasTradeTestBase.findGasTradeNotifyTaskByBizNo("");
//        for (GasTradeNotifyTaskDO GasTradeNotifyTaskDOxx : notifyTaskInfoxxs) {
//            assertEquals("success", GasTradeNotifyTaskDOxx.getStatus());
//        }
//        List<GasTradeOrderDO> gasTradeOrderDOSxx = silverboltTestBase.findGasTradeOrderByBizNo("001in35jzuhog035ej00");
//        assertEquals(1, gasTradeOrderDOSxx.size());
//        for (GasTradeOrderDO gasTradeOrderDOxx : gasTradeOrderDOSxx) {
//            assertEquals("PAYMENT", gasTradeOrderDOxx.getTradeType());
//        }
//        List<GasTradeOilDO> silverOilInfos = silverboltTestBase.findGasTradeOilByBizNo("001in35jzuhog035ej00");
//        assertEquals(1, silverOilInfos.size());
//        List<GasTradeGoodsDO> silverGoodsInfos = silverboltTestBase.findGasTradeGoodsByBizNo("001in35jzuhog035ej00");
//        assertEquals(1, silverGoodsInfos.size());
//        // 结果验证
//        // 数据验证
//        // 清除数据
//    }
//}
