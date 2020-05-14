package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.gateway.api.result.GateBaiduMapCoordinateResult;
import com.xyb.gateway.api.service.GateBaiduMapAPIService;
import com.xyb.gateway.api.order.GateWayBaiduMapQueryCoordinateOrder;



/**
 * @author ychaoyang
 * Created on 2019/01/16.
 */
public class GateBaiduMapAPIServiceCoordinateByLocationTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GateBaiduMapAPIService gateBaiduMapAPIService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gateway/gateBaiduMapAPIServiceCoordinateByLocationTestSuccess.csv")
	@DisplayName("通过坐标查询地址--成功用例")
	public void gateBaiduMapAPIServiceCoordinateByLocationTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GateWayBaiduMapQueryCoordinateOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
//		order.setLat(38.76623);
//		order.setLng(116.43213);
		order.setLat(29.6273501783);
		order.setLng(106.4990514);
		order.setReqId(OID.newID());
		order.setGid(GID.newGID());
		order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
		order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
		// 调用接口
		GateBaiduMapCoordinateResult result = gateBaiduMapAPIService.coordinateByLocation(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
