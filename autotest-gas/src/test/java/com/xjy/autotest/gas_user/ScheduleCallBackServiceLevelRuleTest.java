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
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.AddUserLevelRuleOrder;
import com.xyb.gas.user.api.order.UserGradeOrder;
import dal.model.gas_merchant.GasMerchantDO;
import dal.model.gas_user.UserLevelTaskDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/11/28
 */
public class ScheduleCallBackServiceLevelRuleTest extends SpringBootTestBase {
    @Reference(group = "com.xyb.gas.user.biz.schedule.UserLevelRuleScheduleService", version = "1.0")
    ScheduleCallBackService updateRule;

    @Reference(version = DUBBO_VERSION_1)
    UserIntegralHierarchyService userIntegralHierarchyService;

    @Autowired
    Gas_userTestBase gasUserTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    PromotionTestBase promotionTestBase;

    @AutoTest(file = "gas_user/scheduleCallBackServiceLevelRuleTestSuccess.csv")
    @DisplayName("创建更新等级任务--成功用例")
    public void scheduleCallBackServiceLevelRuleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GasMerchantDO gasMerchantDO,
            GasMerchantDO gasMerchantDO1,
            GasMerchantDO gasMerchantDO2,
            AddUserLevelRuleOrder updateOrder,
            AddUserLevelRuleOrder updateOrder1,
            AddUserLevelRuleOrder updateOrder2
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO2.getPartnerId());
        gasUserTestBase.cleanUserLevelRuleByPartnerId(updateOrder.getPartnerId());
        gasUserTestBase.cleanUserLevelRuleByPartnerId(updateOrder1.getPartnerId());
        gasUserTestBase.cleanUserLevelRuleByPartnerId(updateOrder2.getPartnerId());
        gasUserTestBase.cleanUserLevelTaskByPartnerId(updateOrder.getPartnerId());
        gasUserTestBase.cleanUserLevelTaskByPartnerId(updateOrder1.getPartnerId());
        gasUserTestBase.cleanUserLevelTaskByPartnerId(updateOrder2.getPartnerId());
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2018-11-27");
        Date rawUpdateTime = DateUtils.parseDate("2018-11-27");
        UserGradeOrder commonOrder = new UserGradeOrder();
        commonOrder.setMin(1);
        commonOrder.setMax(100);
        commonOrder.setUserGradeCode(UserGrade.GRADE_COMMON.code());
        UserGradeOrder silverOrder = new UserGradeOrder();
        silverOrder.setMin(101);
        silverOrder.setMax(500);
        silverOrder.setUserGradeCode(UserGrade.GRADE_SILVER.code());
        UserGradeOrder goldOrder = new UserGradeOrder();
        goldOrder.setMin(501);
        goldOrder.setMax(1000);
        goldOrder.setUserGradeCode(UserGrade.GRADE_GOLD.code());
        UserGradeOrder diamondsOrder = new UserGradeOrder();
        diamondsOrder.setMin(1001);
        diamondsOrder.setUserGradeCode(UserGrade.GRADE_DIAMONDS.code());
        List<UserGradeOrder> levelRule = new ArrayList<UserGradeOrder>();
        levelRule.add(commonOrder);
        levelRule.add(silverOrder);
        levelRule.add(goldOrder);
        levelRule.add(diamondsOrder);
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO1);
        //规则
        updateOrder.setLevelRule(levelRule);
        updateOrder.setGid(GID.newGID());
        SimpleResult result = userIntegralHierarchyService.addPartnerUserLevelRule(updateOrder);
        assertEquals(status, result.getStatus());
        updateOrder1.setLevelRule(levelRule);
        updateOrder1.setGid(GID.newGID());
        SimpleResult result1 = userIntegralHierarchyService.addPartnerUserLevelRule(updateOrder1);
        assertEquals(status, result1.getStatus());
        //干扰数据
        gasMerchantTestBase.insertGasMerchant(gasMerchantDO2);
        updateOrder2.setLevelRule(levelRule);
        updateOrder2.setGid(GID.newGID());
        SimpleResult result2 = userIntegralHierarchyService.addPartnerUserLevelRule(updateOrder2);
        assertEquals(status, result2.getStatus());
        // 测试过程
        // 调用接口
        updateRule.justDoIT();
        // 结果验证
        sleep(3);
        // 数据验证
        List<UserLevelTaskDO> tasks = gasUserTestBase.findUserLevelTaskByPartnerId(gasMerchantDO.getPartnerId());
        if (testId == 1004) {//实时更新不需要创建任务
            assertEquals(0, tasks.size());
        } else {
            assertEquals(1, tasks.size());
            for (UserLevelTaskDO task : tasks) {
                assertEquals(updateOrder.getPartnerId(), task.getPartnerId());
                assertEquals(updateOrder.getLevelUpdateType().code(), task.getLevelUpdateType());
                assertEquals(updateOrder.getUseTimeUnit().code(), task.getUseTimeUnit());
//            assertEquals(userLevelRuleDO.getUseTimeUnit(), task.getResetTime());
                assertEquals("PROCESSING", task.getExecutionStatus());
                assertEquals("新增更新任务", task.getMemo());
                assertEquals(0, task.getSubscript().intValue());
            }
        }
        List<UserLevelTaskDO> tasks1 = gasUserTestBase.findUserLevelTaskByPartnerId(gasMerchantDO1.getPartnerId());
        if (testId == 1002) {
            assertEquals(0, tasks1.size());
        } else {
            assertEquals(1, tasks1.size());
            for (UserLevelTaskDO task : tasks1) {
                assertEquals(updateOrder1.getPartnerId(), task.getPartnerId());
                assertEquals(updateOrder1.getLevelUpdateType().code(), task.getLevelUpdateType());
                assertEquals(updateOrder1.getUseTimeUnit().code(), task.getUseTimeUnit());
//            assertEquals(userLevelRuleDO1.getUseTimeUnit(), task.getResetTime());
                assertEquals("PROCESSING", task.getExecutionStatus());
                assertEquals("新增更新任务", task.getMemo());
                assertEquals(0, task.getSubscript().intValue());
            }
        }
        List<UserLevelTaskDO> tasks2 = gasUserTestBase.findUserLevelTaskByPartnerId(gasMerchantDO2.getPartnerId());
        if (testId == 1004) {
            assertEquals(1, tasks2.size());
            for (UserLevelTaskDO task : tasks2) {
                assertEquals(updateOrder2.getPartnerId(), task.getPartnerId());
                assertEquals(updateOrder2.getLevelUpdateType().code(), task.getLevelUpdateType());
                assertEquals(updateOrder2.getUseTimeUnit().code(), task.getUseTimeUnit());
//                assertEquals(userLevelRuleDO2.getUseTimeUnit(), task.getResetTime());
                assertEquals("PROCESSING", task.getExecutionStatus());
                assertEquals("新增更新任务", task.getMemo());
                assertEquals(0, task.getSubscript().intValue());
            }
        } else {
            assertEquals(0, tasks2.size());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO2.getPartnerId());
        gasUserTestBase.cleanUserLevelRuleByPartnerId(updateOrder.getPartnerId());
        gasUserTestBase.cleanUserLevelRuleByPartnerId(updateOrder1.getPartnerId());
        gasUserTestBase.cleanUserLevelRuleByPartnerId(updateOrder2.getPartnerId());
        gasUserTestBase.cleanUserLevelTaskByPartnerId(updateOrder.getPartnerId());
        gasUserTestBase.cleanUserLevelTaskByPartnerId(updateOrder1.getPartnerId());
        gasUserTestBase.cleanUserLevelTaskByPartnerId(updateOrder2.getPartnerId());
    }
}
