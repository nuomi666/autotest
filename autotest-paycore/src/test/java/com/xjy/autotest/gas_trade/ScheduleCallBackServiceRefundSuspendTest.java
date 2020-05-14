package com.xjy.autotest.gas_trade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_tradeTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.gas.trade.api.order.TradeRefundOrder;
import com.xyb.gas.trade.api.service.TradeRefundService;
import dal.model.gas_trade.GasTradePaymentDO;
import dal.model.gas_trade.GasTradeRefundDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/9/7
 */
public class ScheduleCallBackServiceRefundSuspendTest extends SpringBootTestBase {
    @Reference(version = "1.0")
    TradeRefundService tradeRefundService;

    @Reference(group = "gas_trade_refund_suspend", version = "1.0")
    ScheduleCallBackService refundSuspend;

//    @Autowired
//    Gas_tradeTestBase gasTradeTestBase;

    /**
     * 交易流水号为充值表里的biz_no
     */
    @AutoTest(file = "gas_trade/scheduleCallBackServiceRefundSuspendTestSuccess.csv")
    @DisplayName("退款挂起定时重试--成功用例")
    public void scheduleCallBackServiceRefundSuspendTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            TradeRefundOrder order,
            // 结果参数
            String code,
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        String gid = GID.newGID();
        String reqId = OID.newID();
        order.setGid(gid);
        order.setReqId(reqId);
        order.setTradeNo("001iggnzksf8g035ej00");
//        BizResult<TradeRefundInfo> result = tradeRefundService.tradeRefund(order);
//        GasTradeRefundDO refundInfo = gasTradeTestBase.findGasTradeRefundByReqId(reqId).get(0);
//        assertEquals("pay_suspend", refundInfo.getState());
//        assertEquals("processing", refundInfo.getStatus());
//        assertEquals("G04_04_0001", refundInfo.getCode());
//        GasTradePaymentDO paymentInfo = gasTradeTestBase.findGasTradePaymentByReqId(reqId).get(0);
//        assertEquals("refunding", paymentInfo.getState());
//        assertEquals("success", paymentInfo.getStatus());
//        assertEquals("comn_00_0000", paymentInfo.getCode());
        // 测试过程
        // 调用接口
        refundSuspend.justDoIT();
        // 结果验证
        // 数据验证
//        GasTradeRefundDO refundInfoxx = gasTradeTestBase.findGasTradeRefundByReqId(reqId).get(0);
//        assertEquals("finished", refundInfoxx.getState());
//        assertEquals("success", refundInfoxx.getStatus());
//        assertEquals("comn_00_0000", refundInfoxx.getCode());
//        GasTradePaymentDO paymentInfoxx = gasTradeTestBase.findGasTradePaymentByReqId(reqId).get(0);
//        assertEquals("refunded", paymentInfoxx.getState());
//        assertEquals("success", paymentInfoxx.getStatus());
//        assertEquals("comn_00_0000", paymentInfoxx.getCode());
        // 清除数据
    }
}
