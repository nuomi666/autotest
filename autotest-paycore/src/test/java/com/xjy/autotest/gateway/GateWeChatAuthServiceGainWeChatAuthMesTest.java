package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.gateway.api.result.GateWeChatAuthMesResult;
import com.xyb.gateway.api.service.GateWeChatAuthService;
import com.xyb.gateway.api.order.GateWeChatAuthoMesOrder;



/**
 * @author ychaoyang
 * Created on 2019/01/16.
 */
public class GateWeChatAuthServiceGainWeChatAuthMesTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GateWeChatAuthService gateWeChatAuthService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gateway/gateWeChatAuthServiceGainWeChatAuthMesTestSuccess.csv")
	@DisplayName("获取授权信息--成功用例")
	public void gateWeChatAuthServiceGainWeChatAuthMesTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GateWeChatAuthoMesOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setAuthorizationCode("queryauthcode@@@9U4VLiLjDgT3OrwkoyX5mpdWKlMPkEMYjqXapSKUym9g-oqR-ambEyOhetRRc5In0hpHEbfpdkBzoY8jGPbhSw");
		order.setReqId(OID.newID());
		order.setGid(GID.newGID());
		order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
		order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
		// 调用接口
		GateWeChatAuthMesResult result = gateWeChatAuthService.gainWeChatAuthMes(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
