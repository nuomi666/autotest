package com.xjy.autotest.profit;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.profit.api.base.ProfitBaseSwitchOrder;
import com.xyb.profit.api.service.boss.condition.strategy.ConditionStrategyBossService;
import dal.model.profit.ConditionStrategyDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @author ychaoyang
 * Created on 2018/06/22.
 */
public class ConditionStrategyBossServiceDeleteTest extends SpringBootTestBase {

	@Reference(version = DUBBO_VERSION, group = "profit_provider_group")
	public ConditionStrategyBossService conditionStrategyBossService;

	@Autowired
	public ProfitTestBase profitTestBase;

	/**
	 * 1001 删除条件策略
	 */
	@AutoTest(file = "profit/conditionStrategyBossServiceDeleteTestSuccess.csv")
	@DisplayName("删除条件策略--成功用例")
	public void conditionStrategyBossServiceDeleteTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			StandardResultInfo standardResultInfo,
			ProfitBaseSwitchOrder order,
			ConditionStrategyDO conditionStrategyDO
	) {
		// 清除数据
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
		// 准备数据
		conditionStrategyDO.setRawAddTime(new Date());
		profitTestBase.insertConditionStrategy(conditionStrategyDO);
		// 测试过程
		// 调用接口
		StandardResultInfo result = conditionStrategyBossService.delete(order);
		// 结果验证
		assertEquals(standardResultInfo.getStatus(), result.getStatus());
		assertEquals(standardResultInfo.getCode(), result.getCode());
		// 数据验证
		assertEquals(0, profitTestBase.findConditionStrategyById(conditionStrategyDO.getId()).size());
		// 清除数据
	}
}
