package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.gateway.api.result.GateWeChatAuthResult;
import com.xyb.gateway.api.service.GateWeChatAuthService;
import com.xyb.gateway.api.order.GateWeChatAuthoOrder;



/**
 * @author ychaoyang
 * Created on 2019/01/16.
 */
public class GateWeChatAuthServiceGainPreAuthCodeTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GateWeChatAuthService gateWeChatAuthService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gateway/gateWeChatAuthServiceGainPreAuthCodeTestSuccess.csv")
	@DisplayName("获取授权连接--成功用例")
	public void gateWeChatAuthServiceGainPreAuthCodeTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GateWeChatAuthoOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setReqId(OID.newID());
		order.setGid(GID.newGID());
		order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
		order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
		// 调用接口
		GateWeChatAuthResult result = gateWeChatAuthService.gainPreAuthCode(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
