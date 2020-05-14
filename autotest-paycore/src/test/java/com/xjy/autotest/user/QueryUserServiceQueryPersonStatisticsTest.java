package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.user.api.info.user.QueryPersonStatisticsResult;
import com.xyb.user.api.service.user.QueryUserService;
import com.xyb.user.api.order.user.QueryPersonStatisticsOrder;



/**
 * @author huairen
 * Created on 2019/03/19.
 */
public class QueryUserServiceQueryPersonStatisticsTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    QueryUserService queryUserService;

	/**
	 * 1001
	 */
	@AutoTest(file = "user/queryUserServiceQueryPersonStatisticsTestSuccess.csv")
	@DisplayName("--成功用例")
	public void queryUserServiceQueryPersonStatisticsTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			QueryPersonStatisticsOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		QueryPersonStatisticsResult result = queryUserService.queryPersonStatistics(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
