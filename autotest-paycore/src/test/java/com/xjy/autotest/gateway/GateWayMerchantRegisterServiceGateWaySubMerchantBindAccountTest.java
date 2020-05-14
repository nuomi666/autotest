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

import com.xyb.gateway.api.base.GatewayResult;
import com.xyb.gateway.api.service.GateWayMerchantRegisterService;
import com.xyb.gateway.api.order.GateWaySubMerchantBindAccountOrder;


/**
 * @author ychaoyang
 * Created on 2018/10/31.
 */
@DisplayName("子商户绑卡")
public class GateWayMerchantRegisterServiceGateWaySubMerchantBindAccountTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    GateWayMerchantRegisterService gateWayMerchantRegisterService;

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;

    /**
     * 1001 子商户1绑定本行卡
     * 1002 子商户2绑定本行卡
     * 1003 绑定本行卡
     * 1004 解绑本行卡
     * 1005 子商户1绑定本行卡2
     * 1006 子商户1绑定本行卡3
     * 1007 子商户1绑定本行卡4
     * 1008 子商户1绑定本行卡5
     */
    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantBindAccountTestSuccess.csv")
    @DisplayName("--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantBindAccountTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantBindAccountOrder order,
            PayConfigOrder payConfigOrder
    ) {
        if(testId != 1002){
           return;
        }
        // 清除数据
        // 准备数据
        payConfigOrder.setGid(GID.newGID());
        RouteResult routeResult = routeApiService.findPayConfigInfo(payConfigOrder);
        print(routeResult);
        // 测试过程
        order.setChannelPartnerId(routeResult.getInfo().getChannelPartnerId());
        order.setSettleChannelId(routeResult.getInfo().getSettleChannelId());
        order.setParams(routeResult.getInfo().getParams());
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());

        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantBindAccount(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        //assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 绑定本行错误卡
     * 1002 绑定他行错误卡
     * 1003 解绑未绑定的他行卡
     * 1004 子商户1绑定本行卡超过5张
     */
    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantBindAccountTestFailTwo.csv")
    @DisplayName("--失败用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantBindAccountTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantBindAccountOrder order,
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
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantBindAccount(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        //assertEquals(code, result.getCode());
        if (testId == 1001) {
            assertTrue(result.getMessage().contains("BE036"));
        }
        if (testId == 1002) {
            assertTrue(result.getMessage().contains("BE036"));
        }
        // 数据验证
        // 清除数据
    }
}

