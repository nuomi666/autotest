package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.merchant.card.MerchantCardService;
import com.xyb.user.api.order.merchant.card.CiticMerchantUnBindBankCardOrder;



/**
 * @author ychaoyang
 * Created on 2018/11/21.
 */
@Disabled
public class MerchantCardServiceCiticMerchantUnBindBankCardTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantCardService merchantCardService;

	/**
	 * 1001 解绑银行卡
	 */
	@Disabled
	@AutoTest(file = "user/merchantCardServiceCiticMerchantUnBindBankCardTestSuccess.csv")
	@DisplayName("解绑银行卡--成功用例")
	public void merchantCardServiceCiticMerchantUnBindBankCardTestSuccess(
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
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
		// 调用接口
		BizResult result = merchantCardService.citicMerchantUnBindBankCard(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
