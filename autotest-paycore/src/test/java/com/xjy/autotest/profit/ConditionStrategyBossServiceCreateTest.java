package com.xjy.autotest.profit;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ProfitTestBase;
import com.xyb.adk.common.lang.beans.Copier;
import dal.model.profit.ConditionStrategyDO;
import dal.model.profit.CronTaskDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.profit.api.service.boss.condition.strategy.ConditionStrategyBossService;
import com.xyb.profit.api.order.boss.condition.strategy.ConditionStrategySaveOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @author ychaoyang
 * Created on 2018/06/22.
 */
public class ConditionStrategyBossServiceCreateTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "profit_provider_group")
    public ConditionStrategyBossService conditionStrategyBossService;

    @Autowired
    public ProfitTestBase profitTestBase;

    /**
     * 1001 新增事务性分润条件策略
     * 1002 新增周期性分润条件策略
     * 1003 更新条件策略
     */
    @AutoTest(file = "profit/conditionStrategyBossServiceCreateTestSuccess.csv")
    @DisplayName("新增条件策略--成功用例")
    public void conditionStrategyBossServiceCreateTestSuccess(
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
        if (testId == 1003) {
            conditionStrategyDO.setRawAddTime(new Date());
            profitTestBase.insertConditionStrategy(conditionStrategyDO);
        }
        // 测试过程
//        order.setRawAddTime(new Date());
        // 调用接口
        StandardResultInfo result = conditionStrategyBossService.create(order);
        // 结果验证
        print(result);
        assertEquals(standardResultInfo.getStatus(), result.getStatus());
        assertEquals(standardResultInfo.getCode(), result.getCode());
        // 数据验证
        ConditionStrategyDO conditionStrategyDO1 = new ConditionStrategyDO();
        Copier.copy(order, conditionStrategyDO1);
        if (testId == 1001) {
            conditionStrategyDO1.setState("DEACTIVATE");
            profitTestBase.assertConditionStrategy(conditionStrategyDO1, profitTestBase.findConditionStrategyByRuleId
                    (order.getRuleId()).get(0));
        }
        if (testId == 1002) {
            conditionStrategyDO1.setState("DEACTIVATE");
            conditionStrategyDO = profitTestBase.findConditionStrategyByRuleId(order.getRuleId()).get(0);
            CronTaskDO cronTaskDO = profitTestBase.findCronTaskByRuleId(order.getRuleId()).get(0);
            profitTestBase.assertConditionStrategy(conditionStrategyDO1, conditionStrategyDO);
            assertEquals(order.getRuleId(), cronTaskDO.getRuleId());
            assertEquals(conditionStrategyDO.getId(), cronTaskDO.getConditionStrategyId());
            assertEquals("DEACTIVATE", cronTaskDO.getState());
            assertEquals("INIT", cronTaskDO.getExecuteState());
        }
        if (testId == 1003) {
            profitTestBase.assertConditionStrategy(conditionStrategyDO1, profitTestBase.findConditionStrategyById
                    (conditionStrategyDO.getId()).get(0));
        }
        // 清除数据
        profitTestBase.cleanConditionStrategyByRuleId(order.getRuleId());
        profitTestBase.cleanConditionStrategyById(conditionStrategyDO.getId());
    }
}
