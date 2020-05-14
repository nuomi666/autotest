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
import com.xyb.gateway.api.order.GateWaySubMerchantRegisterOrder;


/**
 * @author ychaoyang
 * Created on 2018/10/30.
 */
@DisplayName("子商户注册")
public class GateWayMerchantRegisterServiceGateWaySubMerchantRegisterTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    GateWayMerchantRegisterService gateWayMerchantRegisterService;

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;

    /**
     * 1001 子商户注册成功
     * 1002 子商户重复注册
     * 1003 子商户更新资料
     */
    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantRegisterTestSuccess.csv")
    @DisplayName("子商户注册--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantRegisterTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterOrder order,
            PayConfigOrder payConfigOrder,
            GateWaySubMerchantRegisterResult gateWaySubMerchantRegisterResult
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
        if (testId == 1001) {
            order.setSubMerchantId("sm" + System.currentTimeMillis());
        }
        order.setSubMerchantName("重庆测试商户全称");
        order.setSubMerchantAbbr("怀仁简称");
        print(order);
        // 调用接口
        GateWaySubMerchantRegisterResult result = gateWayMerchantRegisterService.gateWaySubMerchantRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 subMerchantId传空
     * 1002 subMerchantName传空
     * 1003 subMerchantAbbr传空
     * 1004 subMerchantAddress传空
     * 1005 subMerchantContact传空
     * 1006 subMerchantContactPhone传空
     * 1007 subMerchantEmail传空
     * 1008 subMerchantFeeType传空
     * 1009 subMerchantRegisterType传空
     */
    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantRegisterTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantRegisterTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterOrder order,
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
        order.setSubMerchantId("sm" + System.currentTimeMillis());
        // 调用接口
        GateWaySubMerchantRegisterResult result = gateWayMerchantRegisterService.gateWaySubMerchantRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        if (testId != 1001) {
            assertEquals(code, result.getCode());
        }
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 子商户不存在，更新信息
     * 1002 商户不存在
     */
    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantRegisterTestFailTwo.csv")
    @DisplayName("注册失败--失败用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantRegisterTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterOrder order,
            PayConfigOrder payConfigOrder
    ) {
        //if (testId != 1002) {
        //    return;
        //}
        // 清除数据
        // 准备数据
        payConfigOrder.setGid(GID.newGID());
        RouteResult routeResult = routeApiService.findPayConfigInfo(payConfigOrder);
        print(routeResult);
        // 测试过程
        if (testId != 1002) {
            order.setChannelPartnerId(routeResult.getInfo().getChannelPartnerId());
            order.setParams(routeResult.getInfo().getParams());
        }
        if (testId == 1002) {
            Map<String, Object> params = routeResult.getInfo().getParams();
            params.put("channelPartnerId", order.getChannelPartnerId());
            order.setParams(params);
        }
        order.setSettleChannelId(routeResult.getInfo().getSettleChannelId());
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setSubMerchantId("sm" + System.currentTimeMillis());
        print(order);
        // 调用接口
        GateWaySubMerchantRegisterResult result = gateWayMerchantRegisterService.gateWaySubMerchantRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
