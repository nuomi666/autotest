package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.user.api.result.merchant.entry.QueryMerchantEntryListResult;
import com.xyb.user.api.service.merchant.entry.MerchantEntryService;
import com.xyb.user.api.order.merchant.entry.QueryMerchantEntryListOrder;



/**
 * @author ychaoyang
 * Created on 2018/11/19.
 */
@Disabled
public class MerchantEntryServiceFindMerchantEntryListTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    MerchantEntryService merchantEntryService;

	/**
	 * 1001
	 */
	@AutoTest(file = "user/merchantEntryServiceFindMerchantEntryListTestSuccess.csv")
	@DisplayName("--成功用例")
	public void merchantEntryServiceFindMerchantEntryListTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			QueryMerchantEntryListOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
        order.setGid(GID.newGID());
		// 调用接口
		QueryMerchantEntryListResult result = merchantEntryService.findMerchantEntryList(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
