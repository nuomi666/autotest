package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.merchant.card.MerchantCardService;
import com.xyb.user.api.order.merchant.card.CiticMerchantUnBindBankCardOrder;



/**
 * @author huairen
 * Created on 2019/06/20.
 */
@Disabled

public class MerchantCardServiceAllinPayUnbindBankCardTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantCardService merchantCardService;

	/**
	 * 1001 解绑银行卡
	 */
	@AutoTest(file = "user/merchantCardServiceAllinPayUnbindBankCardTestSuccess.csv")
	@DisplayName("解绑银行卡--成功用例")
	public void merchantCardServiceAllinPayUnbindBankCardTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			CiticMerchantUnBindBankCardOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		order.setPartnerId("20180615001234567895");
		// 调用接口
		BizResult result = merchantCardService.allinPayUnbindBankCard(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
