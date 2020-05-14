package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.gateway.api.result.GatePublicAccountMesResult;
import com.xyb.gateway.api.service.GateWeChatAuthService;
import com.xyb.gateway.api.order.GatePublicAccountMesOrder;



/**
 * @author ychaoyang
 * Created on 2019/01/16.
 */
public class GateWeChatAuthServiceGetPublicAccountsAuthorizerInfoTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    GateWeChatAuthService gateWeChatAuthService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gateway/gateWeChatAuthServiceGetPublicAccountsAuthorizerInfoTestSuccess.csv")
	@DisplayName("公众号信息--成功用例")
	public void gateWeChatAuthServiceGetPublicAccountsAuthorizerInfoTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			GatePublicAccountMesOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setAuthorizerAppid("wxf373d57f99bdb6e8");
		order.setComponentAccessToken("queryauthcode@@@9U4VLiLjDgT3OrwkoyX5mpdWKlMPkEMYjqXapSKUym9g-oqR-ambEyOhetRRc5In0hpHEbfpdkBzoY8jGPbhSw");
		order.setReqId(OID.newID());
		order.setGid(GID.newGID());
		order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
		order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
		// 调用接口
		GatePublicAccountMesResult result = gateWeChatAuthService.getPublicAccountsAuthorizerInfo(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
