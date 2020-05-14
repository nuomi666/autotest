//package com.xjy.autotest.gas_trade;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.adk.common.util.money.Money;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import com.xyb.gas.trade.api.order.TradeDepositOrder;
//import com.xyb.gas.trade.api.service.TradeDepositService;
//import dal.model.gas_trade.GasTradeDepositDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/9/5
// */
//public class ScheduleCallBackServiceDepositSuspendTest extends SpringBootTestBase {
//
//    @Reference(group = "gas_trade_deposit_suspend", version = "1.0")
//    ScheduleCallBackService depositSuspend;
//
//    @Reference(version = "1.0")
//    TradeDepositService tradeDepositService;
//
//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_trade/scheduleCallBackServiceDepositSuspendTestSuccess.csv")
//    @DisplayName("充值定时重试--成功用例")
//    public void scheduleCallBackServiceDepositSuspendTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            TradeDepositOrder order,
//            // 结果参数
//            String description,
//            String message
//    ) {
//        // 清除数据
//        // 准备数据
//        String reqId = OID.newID();
//        String gid = GID.newGID();
//        order.setReqId(reqId);
//        order.setGid(gid);
//        order.setPayAmount(Money.yuan(101));
////        BizResult<TradeDepositInfo> result = tradeDepositService.tradeDeposit(order);
////        GasTradeDepositDO depositInfo = gasTradeTestBase.findGasTradeDepositByReqId(reqId).get(0);
////        assertEquals("processing", depositInfo.getState());
////        assertEquals("pay_suspend", depositInfo.getStatus());
////        assertEquals("G03_02_0001", depositInfo.getCode());
//        // 测试过程
//        // 调用接口
//        depositSuspend.justDoIT();
//        GasTradeDepositDO depositInfoxx = gasTradeTestBase.findGasTradeDepositByReqId(reqId).get(0);
//        assertEquals("finished", depositInfoxx.getState());
//        assertEquals("pay_advance", depositInfoxx.getStatus());
//        assertEquals("comn_07_0000", depositInfoxx.getCode());
//        // 结果验证
//        // 数据验证
//        // 清除数据
//    }
//}
