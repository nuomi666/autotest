package com.xjy.autotest.clear;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.*;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.notify.TransNotifyService;
import com.xyb.adk.common.lang.order.TransNotifyOrder;



/**
 * @author huairen
 * Created on 2019/01/22.
 */
public class TransNotifyServiceNotifyTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "settlementOrderLogNotifyGroupName")
    TransNotifyService transNotifyService;

	/**
	 * 1001
	 */
	@AutoTest(file = "clear/transNotifyServiceNotifyTestSuccess.csv")
	@DisplayName("提现异步通知--成功用例")
	public void transNotifyServiceNotifyTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			TransNotifyOrder order
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// order.setStatus(Status.FAIL);
		// 调用接口
		SimpleResult result = transNotifyService.notify(order);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
