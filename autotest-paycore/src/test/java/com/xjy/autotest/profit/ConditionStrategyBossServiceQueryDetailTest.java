package com.xjy.autotest.profit;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xjy.autotest.utils.KryoUtil;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.profit.api.result.info.ConditionStrategyInfo;
import dal.model.profit.ConditionStrategyDO;
import dal.model.profit.RuleDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.profit.api.result.boss.condition.strategy.ConditionStrategyQueryResult;
import com.xyb.profit.api.service.boss.condition.strategy.ConditionStrategyBossService;
import com.xyb.profit.api.order.boss.condition.strategy.ConditionStrategyQueryOrder;
import org.mvel2.MVEL;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/06/22.
 */
public class ConditionStrategyBossServiceQueryDetailTest extends SpringBootTestBase {

	@Reference(version = DUBBO_VERSION, group = "profit_provider_group")
	ConditionStrategyBossService conditionStrategyBossService;

	@Autowired
	public ProfitTestBase profitTestBase;

	/**
	 * 1001 查询条件策略详情
	 */
	@AutoTest(file = "profit/conditionStrategyBossServiceQueryDetailTestSuccess.csv")
	@DisplayName("查询条件策略详情--成功用例")
	public void conditionStrategyBossServiceQueryDetailTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			ConditionStrategyQueryOrder order,
			ConditionStrategyQueryResult conditionStrategyQueryResult,
			ConditionStrategyInfo conditionStrategyInfo,
			RuleDO ruleDO,
			ConditionStrategyDO conditionStrategyDO,
			ConditionStrategyDO conditionStrategyDO1
	) {
		// 清除数据
		profitTestBase.cleanRuleById(ruleDO.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
		// 准备数据
		profitTestBase.insertRule(ruleDO);
		profitTestBase.insertConditionStrategy(conditionStrategyDO);
		profitTestBase.insertConditionStrategy(conditionStrategyDO1);
		// 测试过程
		// 调用接口
		ConditionStrategyQueryResult result = conditionStrategyBossService.queryDetail(order);
		// 结果验证
		List infos = new ArrayList();
		infos.add(conditionStrategyInfo);
		conditionStrategyQueryResult.setInfos(infos);
		assertResultInfo(testId, conditionStrategyQueryResult, result);
		// 数据验证
		// 清除数据
		profitTestBase.cleanRuleById(ruleDO.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
	}
}
