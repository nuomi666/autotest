package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.cashier.api.order.route.PayConfigOrder;
import com.xyb.cashier.api.result.route.RouteResult;
import com.xyb.cashier.api.service.RouteApiService;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.gateway.api.result.GateWaySubMerchantRegisterResult;
import com.xyb.gateway.api.service.GateWayMerchantRegisterService;
import com.xyb.gateway.api.order.GateWaySubMerchantRegisterQueryOrder;


/**
 * @author ychaoyang
 * Created on 2018/10/31.
 */
@DisplayName("子商户进件查询")
public class GateWayMerchantRegisterServiceGateWaySubMerchantRegisterQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    GateWayMerchantRegisterService gateWayMerchantRegisterService;

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;

    /**
     * 1001
     */
    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantRegisterQueryTestSuccess.csv")
    @DisplayName("--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantRegisterQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterQueryOrder order,
            PayConfigOrder payConfigOrder
    ) {
        // 清除数据
        // 准备数据
        payConfigOrder.setGid(GID.newGID());
        RouteResult routeResult = routeApiService.findPayConfigInfo(payConfigOrder);
        print(routeResult);
        // 测试过程
        order.setChannelPartnerId(routeResult.getInfo().getChannelPartnerId());
        order.setSettleChannelId(routeResult.getInfo().getSettleChannelId());
        order.setParams(routeResult.getInfo().getParams());
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        order.setSubMerchantId("sc1541137979308");
        // 调用接口
        GateWaySubMerchantRegisterResult result = gateWayMerchantRegisterService.gateWaySubMerchantRegisterQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        assertEquals("3210700000160000031", result.getChannelSubMerchantAccount());
        assertEquals("100019000041733", result.getChannelSubMerchantId());
        // 数据验证
        // 清除数据
    }
}
