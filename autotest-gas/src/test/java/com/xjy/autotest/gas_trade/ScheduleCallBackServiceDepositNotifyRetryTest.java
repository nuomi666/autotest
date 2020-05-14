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
//import com.xyb.gas.trade.api.info.TradeDepositInfo;
//import com.xyb.gas.trade.api.order.TradeDepositOrder;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import dal.model.gas_silverbolt.GasTradeOrderDO;
//import dal.model.gas_trade.GasTradeDepositDO;
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
//public class ScheduleCallBackServiceDepositNotifyRetryTest extends SpringBootTestBase {
//    @Reference(group = "gas_trade_deposit_notify_retry", version = "1.0")
//    ScheduleCallBackService notifyRetry;
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
//     * 修改mq配置后充值一笔，然后改回来再调重推的定时任务
//     */
//    @AutoTest(file = "gas_trade/scheduleCallBackServiceDepositNotifyRetryTestSuccess.csv")
//    @DisplayName("充值通知任务重试--成功用例")
//    public void scheduleCallBackServiceDepositNotifyRetryTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            // 业务参数
//            TradeDepositOrder order
//            // 结果参数
//    ) {
//        // 清除数据
//        // 准备数据
//        order.setReqId(OID.newID());
//        order.setGid(GID.newGID());
//        BizResult<TradeDepositInfo> result = tradeDepositService.tradeDeposit(order);
//        print(result);
//        assertEquals(status, result.getStatus());
//        GasTradeDepositDO depositInfo = gasTradeTestBase.findGasTradeDepositByBizNo(result.getInfo().getBizNo()).get(0);
//        assertEquals("finished", depositInfo.getState());
//        assertEquals("success", depositInfo.getStatus());
//        assertEquals("comn_00_0000", depositInfo.getCode());
//        List<GasTradeNotifyTaskDO> GasTradeNotifyTaskDOs = gasTradeTestBase.findGasTradeNotifyTaskByBizNo("001in2u9jrv0g035ej00");
//        for (GasTradeNotifyTaskDO GasTradeNotifyTaskDO : GasTradeNotifyTaskDOs) {
//            assertEquals("fail", GasTradeNotifyTaskDO.getStatus());
//        }
//        List<GasTradeOrderDO> gasTradeOrderDOS = silverboltTestBase.findGasTradeOrderByBizNo("001in2u9jrv0g035ej00");
//        assertEquals(0, gasTradeOrderDOS.size());
////        assertEquals(1, GasTradeNotifyTaskDO.getRetryCount());
//        // 测试过程
//        // 调用接口
//        notifyRetry.justDoIT();
//        sleep(5);
//        // 结果验证
//        // 数据验证
//        List<GasTradeNotifyTaskDO> GasTradeNotifyTaskDOxxs = gasTradeTestBase.findGasTradeNotifyTaskByBizNo("001in2u9jrv0g035ej00");
//        for (GasTradeNotifyTaskDO GasTradeNotifyTaskDOxx : GasTradeNotifyTaskDOxxs) {
//            assertEquals("success", GasTradeNotifyTaskDOxx.getStatus());
//        }
//        List<GasTradeOrderDO> gasTradeOrderDOSxx = silverboltTestBase.findGasTradeOrderByBizNo("001in2u9jrv0g035ej00");
//        assertEquals(1, gasTradeOrderDOSxx.size());
//        for (GasTradeOrderDO gasTradeOrderDOxx : gasTradeOrderDOSxx) {
//            assertEquals("DEPOSIT", gasTradeOrderDOxx.getTradeType());
//        }
//        // 清除数据
////        gasTradeTestBase.cleanGasTradeDepositByBizNo(result.getInfo().getBizNo());
////        gasTradeTestBase.cleanGasTradeNotifyTaskByBizNo(result.getInfo().getBizNo());
//    }
//}
