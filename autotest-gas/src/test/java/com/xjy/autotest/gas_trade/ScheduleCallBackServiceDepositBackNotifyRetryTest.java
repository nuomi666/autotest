//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_silverboltTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import com.xyb.gas.trade.api.enums.TradeType;
//import com.xyb.gas.trade.api.order.TradeDepositBackOrder;
//import com.xyb.gas.trade.api.service.TradeDepositBackService;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import dal.model.gas_silverbolt.GasTradeOrderDO;
//import dal.model.gas_trade.GasTradeDepositBackDO;
//import dal.model.gas_trade.GasTradeNotifyTaskDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/11/6
// */
//public class ScheduleCallBackServiceDepositBackNotifyRetryTest extends SpringBootTestBase {
//    @Reference(group = "gas_trade_deposit_back_notify_retry", version = "1.0")
//    ScheduleCallBackService depositBackNotify;
//
//    @Reference(version = "1.0")
//    TradeDepositBackService tradeDepositBackService;
//
//    @Reference(version = "1.0")
//    TradeDepositService tradeDepositService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    @Autowired
//    Gas_silverboltTestBase silverboltTestBase;
//
//    /**
//     *
//     */
//    @AutoTest(file = "gas_trade/scheduleCallBackServiceDepositBackNotifyRetryTestSuccess.csv")
//    @DisplayName("充退通知任务重试--成功用例")
//    public void scheduleCallBackServiceDepositBackNotifyRetryTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TradeDepositBackOrder order
//            // 结果参数
//    ) {
//        // 清除数据
//        // 准备数据
//        //充值
////        depositOrder.setGid(GID.newGID());
////        depositOrder.setMerchantOrderNo(OID.newID());
////        depositOrder.setReqId(OID.newID());
////        BizResult<TradeDepositInfo> depositResult = tradeDepositService.tradeDeposit(depositOrder);
////        print(depositResult);
////        assertEquals(status, depositResult.getStatus());
////        GasTradeDepositDO depositInfo = gasTradeTestBase.findGasTradeDepositByBizNo(depositResult.getInfo().getBizNo()).get(0);
////        assertEquals("finished", depositInfo.getState());
////        assertEquals("success", depositInfo.getStatus());
////        assertEquals("comn_00_0000", depositInfo.getCode());
//        //充退
//        order.setDepositNo("001in35qcqm4g035ej00");
//        order.setGid(GID.newGID());
//        order.setMerchantOrderNo(OID.newID());
//        order.setReqId(OID.newID());
////        BizResult<TradeDepositBackPayInfo> result = tradeDepositBackService.tradeDepositBack(order);
////        print(result);
////        assertEquals(status, result.getStatus());
//        GasTradeDepositBackDO depositBackInfo = gasTradeTestBase.findGasTradeDepositBackByDepositNo("001in35qcqm4g035ej00").get(0);
//        assertEquals("finished", depositBackInfo.getState());
//        assertEquals("success", depositBackInfo.getStatus());
//        assertEquals("comn_00_0000", depositBackInfo.getCode());
//        List<GasTradeNotifyTaskDO> notifyTaskInfos = gasTradeTestBase.findGasTradeNotifyTaskByBizNo("001in3egmdtgg035ej00");
//        for (GasTradeNotifyTaskDO GasTradeNotifyTaskDO : notifyTaskInfos) {
//            assertEquals("fail", GasTradeNotifyTaskDO.getStatus());
//        }
//        // 测试过程
//        // 调用接口
//        depositBackNotify.justDoIT();
//        List<GasTradeNotifyTaskDO> notifyTaskInfoxxs = gasTradeTestBase.findGasTradeNotifyTaskByBizNo("001in3egmdtgg035ej00");
//        for (GasTradeNotifyTaskDO GasTradeNotifyTaskDOxx : notifyTaskInfoxxs) {
//            assertEquals("success", GasTradeNotifyTaskDOxx.getStatus());
//        }
//        List<GasTradeOrderDO> gasTradeOrderDOSxx = silverboltTestBase.findGasTradeOrderByBizNo("001in3egmdtgg035ej00");
//        assertEquals(1, gasTradeOrderDOSxx.size());
//        for (GasTradeOrderDO gasTradeOrderDOxx : gasTradeOrderDOSxx) {
//            assertEquals(TradeType.DEPOSIT_BACK.code(), gasTradeOrderDOxx.getTradeType());
//        }
////        List<GasTradeOilDO> silverOilInfos = silverboltTestBase.findGasTradeOilByBizNo("001in35jzuhog035ej00");
////        assertEquals(1, silverOilInfos.size());
////        List<GasTradeGoodsDO> silverGoodsInfos = silverboltTestBase.findGasTradeGoodsByBizNo("001in35jzuhog035ej00");
////        assertEquals(1, silverGoodsInfos.size());
//        // 结果验证
//        // 数据验证
//        // 清除数据
//    }
//}
