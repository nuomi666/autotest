package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.gas.user.api.UserIntegralHierarchyService;
import com.xyb.gas.user.api.order.AddUserIntegralResetOrder;
import dal.model.gas_merchant.GasMerchantDO;
import dal.model.gas_user.UserIntegralResetTaskDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/11/27
 */
public class ScheduleCallBackServiceResetRuleTest extends SpringBootTestBase {
    @Reference(group = "com.xyb.gas.user.biz.schedule.UserIntegralResetRuleScheduleService", version = "1.0")
    ScheduleCallBackService resetRule;

    @Reference(version = DUBBO_VERSION_1)
    UserIntegralHierarchyService userIntegralHierarchyService;

    @Autowired
    Gas_userTestBase gasUserTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    PromotionTestBase promotionTestBase;

    @AutoTest(file = "gas_user/scheduleCallBackServiceResetRuleTestSuccess.csv")
    @DisplayName("创建积分清零任务--成功用例")
    public void scheduleCallBackServiceResetRuleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GasMerchantDO gasMerchantDO,
            GasMerchantDO gasMerchantDO1,
            GasMerchantDO gasMerchantDO2,
            AddUserIntegralResetOrder resetOrder,
            AddUserIntegralResetOrder resetOrder1,
            AddUserIntegralResetOrder resetOrder2
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO2.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder1.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder2.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder1.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder2.getPartnerId());
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2018-11-27");
        Date rawUpdateTime = DateUtils.parseDate("2018-11-27");
        List<String> days = new ArrayList<String>();
        List<String> days1 = new ArrayList<String>();
        List<String> days2 = new ArrayList<String>();
        if (testId == 1001) {//每周：1-7 表示周日到周六
            days.add("6");
            days1.add("1");
            days2.add("6");
        }
        if (testId == 1002) {//每月：1-31 表示1号到31号
            days.add("1");
            days1.add("2018-12-1");
            days2.add("6");
        }
        if (testId == 1003) {//每年： MM-DD 01-01
            days.add("12-01");
            days1.add("6");
            days2.add("6");
        }
        if (testId == 1004) {//定时:YYYY-MM-DD  2018-01-01
            days.add("2018-12-01");
            days1.add("12-01");
            days2.add("1");
        }
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO1);
        //规则
        resetOrder.setDays(days);
        resetOrder.setGid(GID.newGID());
        SimpleResult result = userIntegralHierarchyService.addPartnerUserIntegralResetRule(resetOrder);
        assertEquals(status, result.getStatus());
        resetOrder1.setDays(days1);
        resetOrder1.setGid(GID.newGID());
        SimpleResult result1 = userIntegralHierarchyService.addPartnerUserIntegralResetRule(resetOrder1);
        assertEquals(status, result1.getStatus());
        //干扰数据
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO2);
        resetOrder2.setDays(days2);
        resetOrder2.setGid(GID.newGID());
        SimpleResult result2 = userIntegralHierarchyService.addPartnerUserIntegralResetRule(resetOrder2);
        assertEquals(status, result2.getStatus());
        // 测试过程
        // 调用接口
        resetRule.justDoIT();
        // 结果验证
        sleep(3);
        // 数据验证
        List<UserIntegralResetTaskDO> tasks =
                gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO.getPartnerId());
        assertEquals(1, tasks.size());
        for (UserIntegralResetTaskDO task : tasks) {
            assertEquals(resetOrder.getPartnerId(), task.getPartnerId());
            assertEquals(resetOrder.getIntegralResetType().code(), task.getIntegralResetType());
            if (testId == 1004) {
                assertEquals(null, task.getUseTimeUnit());
            } else {
                assertEquals(resetOrder.getUseTimeUnit().code(), task.getUseTimeUnit());
            }
//            assertEquals(resetOrder.getUseTimeUnit(), task.getResetTime());
            assertEquals("PROCESSING", task.getExecutionStatus());
            assertEquals("新建立清零任务", task.getMemo());
            assertEquals(0, task.getSubscript().intValue());
        }
        List<UserIntegralResetTaskDO> tasks1 =
                gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO1.getPartnerId());
        assertEquals(1, tasks1.size());
        for (UserIntegralResetTaskDO task : tasks1) {
            assertEquals(resetOrder1.getPartnerId(), task.getPartnerId());
            assertEquals(resetOrder1.getIntegralResetType().code(), task.getIntegralResetType());
            if (testId == 1002) {
                assertEquals(null, task.getUseTimeUnit());
            } else {
                assertEquals(resetOrder1.getUseTimeUnit().code(), task.getUseTimeUnit());
            }
//            assertEquals(resetOrder1.getUseTimeUnit(), task.getResetTime());
            assertEquals("PROCESSING", task.getExecutionStatus());
            assertEquals("新建立清零任务", task.getMemo());
            assertEquals(0, task.getSubscript().intValue());
        }
        List<UserIntegralResetTaskDO> tasks2 = gasUserTestBase.findUserIntegralResetTaskByPartnerId(
                "S0301811281400000001");
        if (testId == 1004) {
            assertEquals(1, tasks2.size());
            for (UserIntegralResetTaskDO task : tasks2) {
                assertEquals(resetOrder2.getPartnerId(), task.getPartnerId());
                assertEquals(resetOrder2.getIntegralResetType().code(), task.getIntegralResetType());
                assertEquals(resetOrder2.getUseTimeUnit().code(), task.getUseTimeUnit());
//                assertEquals(userIntegralResetRuleDO2.getUseTimeUnit(), task.getResetTime());
                assertEquals("PROCESSING", task.getExecutionStatus());
                assertEquals("新建立清零任务", task.getMemo());
                assertEquals(0, task.getSubscript().intValue());
            }
        } else {
            assertEquals(0, tasks2.size());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO2.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder1.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder2.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder1.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder2.getPartnerId());
    }

    @AutoTest(file = "gas_user/scheduleCallBackServiceResetRuleTestFailTwo.csv")
    @DisplayName("创建积分清零任务--失败用例")
    public void scheduleCallBackServiceResetRuleTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GasMerchantDO gasMerchantDO,
            GasMerchantDO gasMerchantDO1,
            GasMerchantDO gasMerchantDO2,
            AddUserIntegralResetOrder resetOrder,
            AddUserIntegralResetOrder resetOrder1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO2.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder1.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder1.getPartnerId());
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2018-11-28");
        Date rawUpdateTime = DateUtils.parseDate("2018-11-28");
        Date resetTime = DateUtils.parseDate2("2018-11-29 00:00:00");
        List<String> days = new ArrayList<String>();
        List<String> days1 = new ArrayList<String>();
        List<String> days2 = new ArrayList<String>();
        if (testId == 1001) {//每周：1-7 表示周日到周六
            days.add("5");
            days1.add("29");
            days2.add("5");
        }
        if (testId == 1002) {//每月：1-31 表示1号到31号
            days.add("29");
            days1.add("2018-11-29");
            days2.add("5");
        }
        if (testId == 1003) {//每年： MM-DD 01-01
            days.add("11-29");
            days1.add("5");
            days2.add("29");
        }
        if (testId == 1004) {//定时:YYYY-MM-DD  2018-01-01
            days.add("2018-11-29");
            days1.add("11-29");
            days2.add("29");
        }
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO1);
        //规则
        resetOrder.setDays(days);
        resetOrder.setGid(GID.newGID());
        SimpleResult result = userIntegralHierarchyService.addPartnerUserIntegralResetRule(resetOrder);
        assertEquals(status, result.getStatus());
        resetOrder1.setDays(days1);
        resetOrder1.setGid(GID.newGID());
        SimpleResult result1 = userIntegralHierarchyService.addPartnerUserIntegralResetRule(resetOrder1);
        assertEquals(status, result1.getStatus());
        //任务
        UserIntegralResetTaskDO userIntegralResetTaskDO = new UserIntegralResetTaskDO();
        userIntegralResetTaskDO.setPartnerId(resetOrder.getPartnerId());
        userIntegralResetTaskDO.setIntegralResetType(resetOrder.getIntegralResetType().code());
        userIntegralResetTaskDO.setUseTimeUnit(resetOrder.getUseTimeUnit().code());
        userIntegralResetTaskDO.setResetTime(resetTime);
        userIntegralResetTaskDO.setExecutionStatus("SUCCESS");
        userIntegralResetTaskDO.setMemo("清零成功");
        userIntegralResetTaskDO.setSubscript(1);
        userIntegralResetTaskDO.setRawAddTime(rawAddTime);
        userIntegralResetTaskDO.setRawUpdateTime(rawUpdateTime);
        if (testId == 1001) {
            gasUserTestBase.insertUserIntegralResetTask(userIntegralResetTaskDO);
        }
        // 测试过程
        // 调用接口
        resetRule.justDoIT();
        // 结果验证
        sleep(3);
        // 数据验证
        List<UserIntegralResetTaskDO> tasks =
                gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO.getPartnerId());
        assertEquals(1, tasks.size());
        for (UserIntegralResetTaskDO task : tasks) {
            assertEquals(resetOrder.getPartnerId(), task.getPartnerId());
            assertEquals(resetOrder.getIntegralResetType().code(), task.getIntegralResetType());
            if (testId == 1004) {
                assertEquals(null, task.getUseTimeUnit());
            } else {
                assertEquals(resetOrder.getUseTimeUnit().code(), task.getUseTimeUnit());
            }
//            assertEquals(resetOrder.getUseTimeUnit(), task.getResetTime());
            if (testId == 1001) {
                assertEquals("SUCCESS", task.getExecutionStatus());
                assertEquals("清零成功", task.getMemo());
                assertEquals(1, task.getSubscript().intValue());
            } else {
                assertEquals("PROCESSING", task.getExecutionStatus());
                assertEquals("新建立清零任务", task.getMemo());
                assertEquals(0, task.getSubscript().intValue());
            }
        }
        List<UserIntegralResetTaskDO> tasks1 =
                gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO1.getPartnerId());
        assertEquals(1, tasks1.size());
        for (UserIntegralResetTaskDO task : tasks1) {
            assertEquals(resetOrder1.getPartnerId(), task.getPartnerId());
            assertEquals(resetOrder1.getIntegralResetType().code(), task.getIntegralResetType());
            if (testId == 1002) {
                assertEquals(null, task.getUseTimeUnit());
            } else {
                assertEquals(resetOrder1.getUseTimeUnit().code(), task.getUseTimeUnit());
            }
//            assertEquals(resetOrder1.getUseTimeUnit(), task.getResetTime());
            assertEquals("PROCESSING", task.getExecutionStatus());
            assertEquals("新建立清零任务", task.getMemo());
            assertEquals(0, task.getSubscript().intValue());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO2.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetRuleByPartnerId(resetOrder1.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder.getPartnerId());
        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(resetOrder1.getPartnerId());
    }
}
