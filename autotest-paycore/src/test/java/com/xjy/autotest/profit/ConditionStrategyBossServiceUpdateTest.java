package com.xjy.autotest.profit;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xyb.adk.common.lang.beans.Copier;
import dal.model.profit.ConditionStrategyDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.profit.api.service.boss.condition.strategy.ConditionStrategyBossService;
import com.xyb.profit.api.order.boss.condition.strategy.ConditionStrategySaveOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/06/22.
 */
public class ConditionStrategyBossServiceUpdateTest extends SpringBootTestBase {

	@Reference(version = DUBBO_VERSION, group = "profit_provider_group")
	ConditionStrategyBossService conditionStrategyBossService;

	@Autowired
	public ProfitTestBase profitTestBase;

	/**
	 * 1001 更新条件策略
	 */
	@AutoTest(file = "profit/conditionStrategyBossServiceUpdateTestSuccess.csv")
	@DisplayName("更新条件策略--成功用例")
	public void conditionStrategyBossServiceUpdateTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			StandardResultInfo standardResultInfo,
			ConditionStrategySaveOrder order,
			ConditionStrategyDO conditionStrategyDO
	) {
		// 清除数据
		profitTestBase.cleanConditionStrategyByRuleId(order.getRuleId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
		// 准备数据
		conditionStrategyDO.setRawAddTime(new Date());
		profitTestBase.insertConditionStrategy(conditionStrategyDO);
		// 测试过程
//		order.setRawAddTime(new Date());
//		order.setRawUpdateTime(new Date());
		// 调用接口
		StandardResultInfo result = conditionStrategyBossService.update(order);
		// 结果验证
		assertEquals(standardResultInfo.getStatus(), result.getStatus());
		assertEquals(standardResultInfo.getCode(), result.getCode());
		// 数据验证
		ConditionStrategyDO conditionStrategyDO1 = new ConditionStrategyDO();
		Copier.copy(order, conditionStrategyDO1);
		profitTestBase.assertConditionStrategy(conditionStrategyDO1, profitTestBase.findConditionStrategyById(order
				.getId()).get(0));
		// 清除数据
	}
}
