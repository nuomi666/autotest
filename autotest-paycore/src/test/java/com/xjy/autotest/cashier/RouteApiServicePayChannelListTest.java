package com.xjy.autotest.cashier;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.AutoTestBase;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.cashier.api.order.route.PayChannelOrder;
import com.xyb.cashier.api.result.paychannel.PayChannelResult;
import com.xyb.cashier.api.result.route.RoutePayChannelResult;
import com.xyb.cashier.api.service.RouteApiService;
import org.junit.jupiter.api.DisplayName;

/**
 * @author 面条
 * @mail miantiao@xinyebang.com
 * 修订记录：
 * 2018/6/11 14:29 创建
 * <p>
 * 服务应用场景：该服务是在用户在电商平台完成额度申请审核通过后，接着在电商平台成功下单需要支付时，跳到易极付收银台，点击所显示“白条支付”按钮，会调该服务完成贷款申请，
 * 贷款申请成功后完成交易订单支付。
 * <p>
 * 开发实现逻辑：订单幂等性校验=>校验用户是否存在=>校验消金公司保证金是否足额=>校验用户授信余额是否充足=>过风控审核=>减少信用额度=>持久化订单并返回=>异步同步数据至数据中心（不影响成功）
 * 计息公式xxxx；
 * <p>
 * 用例整体设计：（非用例项设计）该用例执行需开发的基础数据xxxx.sql；该用例的xxx数据采用sql/动态插入数据准备；
 * <p>
 * 涉及系统（表名）：系统英文名{表名（作用）}
 * <p>
 * 特别注意：
 */
public class RouteApiServicePayChannelListTest extends SpringBootTestBase {
    @Reference(version = "1.0.0")
    RouteApiService routeApiService;

    @AutoTest(file = "cashier/RouteApiServicePayChannelListTestSuccess.csv")
    @DisplayName("成功用例")
    public void RouteApiServicePayChannelListTestSuccess(
            int testId,
            Status status,
            String code,
            PayChannelOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        RoutePayChannelResult result = routeApiService.payChannelList(order);
        // 结果验证
        assertResult(testId, status, code, result);
        print(result);
        // 数据验证
    }
}
