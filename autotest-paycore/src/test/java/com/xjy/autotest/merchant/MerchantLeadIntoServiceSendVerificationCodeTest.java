package com.xjy.autotest.merchant;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.merchant.api.service.MerchantLeadIntoService;
import com.xyb.merchant.api.order.SendCodeOrder;



/**
 * @author miantiao
 * Created on 2019/07/06.
 */
public class MerchantLeadIntoServiceSendVerificationCodeTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantLeadIntoService merchantLeadIntoService;

	/**
	 * 1001
	 */
	@AutoTest(file = "merchant/merchantLeadIntoServiceSendVerificationCodeTestSuccess.csv")
	@DisplayName("--成功用例")
	public void merchantLeadIntoServiceSendVerificationCodeTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			SendCodeOrder sendCodeOrder
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		SimpleResult result = merchantLeadIntoService.sendVerificationCode(sendCodeOrder);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
