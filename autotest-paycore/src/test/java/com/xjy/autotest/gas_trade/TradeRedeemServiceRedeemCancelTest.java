package com.xjy.autotest.gas_trade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.trade.api.order.TradeRedeemCancelOrder;
import com.xyb.gas.trade.api.service.TradeRedeemService;
import org.junit.jupiter.api.DisplayName;



/**
 * @author nuomi@xyb.com
 * Created on 2018/09/26.
 */
public class TradeRedeemServiceRedeemCancelTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    TradeRedeemService tradeRedeemService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gas_trade/tradeRedeemServiceRedeemCancelTestSuccess.csv")
	@DisplayName("交易商品兑换核销--成功用例")
	public void tradeRedeemServiceRedeemCancelTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			TradeRedeemCancelOrder arg0
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		// 调用接口
		BizResult result = tradeRedeemService.redeemCancel(arg0);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}
