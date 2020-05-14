package com.xjy.autotest.gas_trade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.gas.trade.api.order.TradeRefundOrder;
import org.junit.jupiter.api.DisplayName;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/9/5
 */
public class TradeRefundNotifyTest extends SpringBootTestBase {
    @Reference(group = "gas_trade_refund_notify_retry", version = "1.0")
    ScheduleCallBackService refundNotify;

    /**
     * 1001
     */
    @AutoTest(file = "gas_trade/tradeRefundNotifyTestSuccess.csv")
    @DisplayName("退款通知任务重试--成功用例")
    public void tradeRefundNotifyTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            TradeRefundOrder order,
            // 结果参数
            String description,
            String message
    ) {
        // 清除数据
        // 准备数据
        String reqId = OID.newID();
        String gid = GID.newGID();
        // 测试过程
        // 调用接口
        refundNotify.justDoIT();
        refundNotify.justDoIT();
        // 结果验证
        // 数据验证
        // 清除数据
    }
}
