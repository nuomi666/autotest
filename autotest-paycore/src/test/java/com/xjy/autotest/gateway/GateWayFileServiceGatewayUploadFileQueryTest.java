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
import com.xyb.gateway.api.result.GateWayUploadFileQueryResult;
import com.xyb.gateway.api.service.GateWayFileService;
import com.xyb.gateway.api.order.GateWayUploadFileQueryOrder;



/**
 * @author ychaoyang
 * Created on 2018/11/12.
 */
public class GateWayFileServiceGatewayUploadFileQueryTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GateWayFileService gateWayFileService;

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;


    /**
	 * 1001
	 */
	@AutoTest(file = "gateway/gateWayFileServiceGatewayUploadFileQueryTestSuccess.csv")
	@DisplayName("--成功用例")
	public void gateWayFileServiceGatewayUploadFileQueryTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GateWayUploadFileQueryOrder order,
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
        //order.setFileName("10010700000000010030012018111201");
        order.setFileName("10010700000000010020012018111201");
        order.setFileName("1001070000000000022018111401");
        order.setFileName("1001070000000000022018111402");
        order.setFileName("1001070000000000022018111403");
        order.setFileName("10010700000000010030012018111401");
        order.setFileName("10010700000000010020012018111401");
        order.setFileName("10010700000000010010012018111401");
        order.setFileName("10010700000000010030012018111901");
        //order.setFileName("1001070000000000022018112001");
        order.setFileName("10010700000000010030012018112001");
        order.setFileName("1001070000000000022018112201");
        order.setFileName("10010700000000010030012018112101");
        order.setFileName("1001070000000000022018112301");
        // 调用接口
		GateWayUploadFileQueryResult result = gateWayFileService.gatewayUploadFileQuery(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
