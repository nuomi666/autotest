package com.xjy.autotest.cashier;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.cashier.api.result.route.PayChannelResult;
import com.xyb.cashier.api.service.RouteApiService;
import com.xyb.cashier.api.order.route.PayChannelOrder;


/**
 * @author huairen
 * Created on 2019/04/22.
 */
public class RouteApiServicePayChannelTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;

    /**
     * 1001
     */
    @AutoTest(file = "cashier/routeApiServicePayChannelTestSuccess.csv")
    @DisplayName("--成功用例")
    public void routeApiServicePayChannelTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PayChannelOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        for (int i = 0; i < 100; i++) {
            PayChannelResult result = routeApiService.payChannel(order);
            // 结果验证
            print(result);
            assertEquals(status, result.getStatus());
            assertEquals(code, result.getCode());
        }
        // 数据验证
        // 清除数据
    }
}
