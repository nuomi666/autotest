package com.xjy.autotest.profit;

import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xyb.adk.common.lang.beans.Copier;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.profit.api.result.info.ConditionStrategyInfo;
import dal.model.profit.ConditionStrategyDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.profit.api.result.boss.condition.strategy.ConditionStrategyQueryResult;
import com.xyb.profit.api.service.boss.condition.strategy.ConditionStrategyBossService;
import com.xyb.profit.api.order.boss.condition.strategy.ConditionStrategyQueryOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author ychaoyang
 * Created on 2018/06/22.
 */
public class ConditionStrategyBossServiceQueryListTest extends SpringBootTestBase {

	@Reference(version = DUBBO_VERSION, group = "profit_provider_group")
	ConditionStrategyBossService conditionStrategyBossService;

	@Autowired
	public ProfitTestBase profitTestBase;

	/**
	 * 1001 查询条件策略列表
	 * 1002 查询第一页
	 * 1003 查询中间页
	 * 1004 查询最后页
	 * 1005 查询无数据
	 */
	@AutoTest(file = "profit/conditionStrategyBossServiceQueryListTestSuccess.csv")
	@DisplayName("--成功用例")
	public void conditionStrategyBossServiceQueryListTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			ConditionStrategyQueryResult conditionStrategyQueryResult,
			Page page,
			ConditionStrategyQueryOrder order,
			ConditionStrategyDO conditionStrategyDO,
			ConditionStrategyDO conditionStrategyDO1,
			ConditionStrategyDO conditionStrategyDO2,
			ConditionStrategyInfo conditionStrategyInfo,
			ConditionStrategyInfo conditionStrategyInfo1,
			ConditionStrategyInfo conditionStrategyInfo2
	) {
		// 清除数据
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO2.getId());
		// 准备数据
		if (testId != 1005) {
			profitTestBase.insertConditionStrategy(conditionStrategyDO);
			profitTestBase.insertConditionStrategy(conditionStrategyDO1);
			profitTestBase.insertConditionStrategy(conditionStrategyDO2);
		}
		// 测试过程
		order.setPage(page);
		// 调用接口
		ConditionStrategyQueryResult result = conditionStrategyBossService.queryList(order);
		// 结果验证
		Copier.copy(conditionStrategyDO, conditionStrategyInfo);
		Copier.copy(conditionStrategyDO1, conditionStrategyInfo1);
		Copier.copy(conditionStrategyDO2, conditionStrategyInfo2);
		List infos = new ArrayList();
		if (testId == 1001) {
			infos.add(conditionStrategyInfo);
			infos.add(conditionStrategyInfo1);
			infos.add(conditionStrategyInfo2);
		}
		if (testId == 1002) {
			infos.add(conditionStrategyInfo);
		}
		if (testId == 1003) {
			infos.add(conditionStrategyInfo1);
		}
		if (testId == 1004) {
			infos.add(conditionStrategyInfo2);
		}
		if (testId == 1005) {
		}
		conditionStrategyQueryResult.setInfos(infos);
		assertResultInfo(testId, conditionStrategyQueryResult, result);
		// 数据验证
		// 清除数据
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO1.getId());
		profitTestBase.cleanConditionStrategyById(conditionStrategyDO2.getId());
	}
}
