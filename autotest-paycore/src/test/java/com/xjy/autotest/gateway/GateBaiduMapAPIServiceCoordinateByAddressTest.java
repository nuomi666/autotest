package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.gateway.api.result.GateBaiduMapAddressResult;
import com.xyb.gateway.api.service.GateBaiduMapAPIService;
import com.xyb.gateway.api.order.GateWayBaiduMapQueryAddresOrder;



/**
 * @author ychaoyang
 * Created on 2019/01/16.
 */
public class GateBaiduMapAPIServiceCoordinateByAddressTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GateBaiduMapAPIService gateBaiduMapAPIService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gateway/gateBaiduMapAPIServiceCoordinateByAddressTestSuccess.csv")
	@DisplayName("通过地址返回坐标--成功用例")
	public void gateBaiduMapAPIServiceCoordinateByAddressTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GateWayBaiduMapQueryAddresOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setAddress("环江县思恩镇大安路");
		order.setGid(GID.newGID());
		order.setReqId(OID.newID());
		order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
		order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
		// 调用接口
		GateBaiduMapAddressResult result = gateBaiduMapAPIService.coordinateByAddress(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
