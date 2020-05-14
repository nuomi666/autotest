package com.xjy.autotest.cashier;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.cashier.api.order.route.RouteOrder;
import com.xyb.cashier.api.result.route.RouteResult;
import com.xyb.cashier.api.service.RouteApiService;
import org.junit.jupiter.api.DisplayName;


/**
 * @author huairen
 * Created on 2019/04/22.
 */
public class RouteApiServiceRouteSelectionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;

    /**
     * 1001
     */
    @AutoTest(file = "cashier/routeApiServiceRouteSelectionTestSuccess.csv")
    @DisplayName("--成功用例")
    public void routeApiServiceRouteSelectionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RouteOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        //order.setMerchantMode("NORMAL");
        order.setPlatPartnerId("20180615001234567890");
        // 调用接口
        for (int i = 0; i < 100; i++) {
            RouteResult result = routeApiService.routeSelection(order);
            // 结果验证
            print(result);
            assertEquals(status, result.getStatus());
            assertEquals(code, result.getCode());
        }
        // 数据验证
        // 清除数据
    }
}
