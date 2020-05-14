package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserIntegralHierarchyService;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.QueryUserRuleOrder;
import com.xyb.gas.user.api.order.UserGradeOrder;
import com.xyb.gas.user.api.result.UserGradeInfo;
import com.xyb.gas.user.api.result.info.UserIntegralResetRuleInfo;
import com.xyb.gas.user.api.result.info.UserLevelRuleInfo;
import com.xyb.gas.user.api.result.info.UserRuleInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/22.
 */
public class UserIntegralHierarchyServiceQueryRuleDetailsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserIntegralHierarchyService userIntegralHierarchyService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceQueryRuleDetailsTestSuccess.csv")
    @DisplayName("会员规则详情--成功用例")
    public void userIntegralHierarchyServiceQueryRuleDetailsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String levelTimeUnit,
            String resetTimeUnit,
            String levelUpdateType,
            String integralResetType,
            String day,
            String days,
            String levelCorn,
            String resetCorn,
            Integer cumulativeOfDays,
            String levelStatus,
            String resetSwitch,
            QueryUserRuleOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserLevelRuleByPartnerId(order.getPlatPartnerId());
        // 准备数据
        List<String> resetDays = new ArrayList<String>();
        resetDays.add(day);
        UserGradeOrder userGradeOrder = new UserGradeOrder();
        userGradeOrder.setUserGradeCode(UserGrade.GRADE_COMMON.code());
        userGradeOrder.setMin(1);
        userGradeOrder.setMax(100);
        UserGradeOrder userGradeOrder1 = new UserGradeOrder();
        userGradeOrder1.setUserGradeCode(UserGrade.GRADE_SILVER.code());
        userGradeOrder1.setMin(101);
        userGradeOrder1.setMax(500);
        UserGradeOrder userGradeOrder2 = new UserGradeOrder();
        userGradeOrder2.setUserGradeCode(UserGrade.GRADE_GOLD.code());
        userGradeOrder2.setMin(501);
        userGradeOrder2.setMax(1000);
        UserGradeOrder userGradeOrder3 = new UserGradeOrder();
        userGradeOrder3.setUserGradeCode(UserGrade.GRADE_DIAMONDS.code());
        userGradeOrder3.setMin(1001);
        List<UserGradeOrder> levelRule = new ArrayList<UserGradeOrder>();
        levelRule.add(userGradeOrder);
        levelRule.add(userGradeOrder1);
        levelRule.add(userGradeOrder2);
        levelRule.add(userGradeOrder3);
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        if (testId != 1001) {
            userTestBase.insertUserLevelRule(0L, order.getPlatPartnerId(), order.getPlatPartnerId(), levelTimeUnit,
                    levelUpdateType, days, JSON.toJSONString(levelRule), levelCorn,
                    cumulativeOfDays, null, null, levelStatus);
        }
        if (testId != 1002) {
            userTestBase.insertUserIntegralResetRule(0L, order.getPlatPartnerId(), order.getPlatPartnerId(),
                    resetSwitch, integralResetType,
                    resetTimeUnit, resetCorn, JSON.toJSONString(days), null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<UserRuleInfo> result = userIntegralHierarchyService.queryRuleDetails(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(null, result.getInfo().getUserLevelRuleInfo());
        } else {
            resetRuleAssert(result.getInfo().getUserLevelRuleInfo(),
                    levelUpdateType, levelTimeUnit, days, cumulativeOfDays);
            List<UserGradeInfo> levelRulexxs = result.getInfo().getUserLevelRuleInfo().getLevelRule();
            assertEquals(4, levelRulexxs.size());
            for (UserGradeInfo levelRulexx : levelRulexxs) {
                if (UserGrade.GRADE_COMMON.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_COMMON.code(),
                            1, 100);
                }
                if (UserGrade.GRADE_SILVER.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_SILVER.code(),
                            101, 500);
                }
                if (UserGrade.GRADE_GOLD.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_GOLD.code(),
                            501, 1000);
                }
                if (UserGrade.GRADE_DIAMONDS.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_DIAMONDS.code(),
                            1001, null);
                }
            }
        }
        if (testId == 1002) {
            assertEquals(null, result.getInfo().getUserIntegralResetRuleInfo());
        } else {
            resetRuleAssert(result.getInfo().getUserIntegralResetRuleInfo(),
                    order.getPlatPartnerId(), Boolean.valueOf(resetSwitch),
                    integralResetType, resetTimeUnit, days);
            List<UserGradeInfo> levelRulexxs = result.getInfo().getUserLevelRuleInfo().getLevelRule();
            assertEquals(4, levelRulexxs.size());
            for (UserGradeInfo levelRulexx : levelRulexxs) {
                if (UserGrade.GRADE_COMMON.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_COMMON.code(),
                            1, 100);
                }
                if (UserGrade.GRADE_SILVER.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_SILVER.code(),
                            101, 500);
                }
                if (UserGrade.GRADE_GOLD.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_GOLD.code(),
                            501, 1000);
                }
                if (UserGrade.GRADE_DIAMONDS.code().equals(levelRulexx.getUserGradeCode())) {
                    gradeInfoAssert(levelRulexx, UserGrade.GRADE_DIAMONDS.code(),
                            1001, null);
                }
            }
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserLevelRuleByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceQueryRuleDetailsTestFailOne.csv")
    @DisplayName("会员规则详情--参数非法")
    public void userIntegralHierarchyServiceQueryRuleDetailsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserRuleOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<UserRuleInfo> result = userIntegralHierarchyService.queryRuleDetails(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 积分等级规则
     */
    private void resetRuleAssert(
            UserLevelRuleInfo rule,
            String type,
            String useTimeUnit,
            String days,
            int cumulativeOfDays
    ) {
        assertEquals(type, rule.getLevelUpdateType().code());
        assertEquals(useTimeUnit, rule.getUseTimeUnit().code());
        assertEquals(days, rule.getDays());
        assertEquals(cumulativeOfDays, rule.getCumulativeOfDays());
//        assertEquals(birthday, ruleInfo.getRawAddTime());
//        assertEquals(birthday, ruleInfo.getRawUpdateTime());
    }

    /**
     * 等级规则
     */
    private void gradeInfoAssert(
            UserGradeInfo gradeInfo,
            String userGradeCode,
            Integer min,
            Integer max
    ) {
        assertEquals(userGradeCode, gradeInfo.getUserGradeCode());
        assertEquals(min, gradeInfo.getMin());
        assertEquals(max, gradeInfo.getMax());
    }

    /**
     * 清零规则
     */
    private void resetRuleAssert(
            UserIntegralResetRuleInfo ruleInfo,
            String partnerId,
            boolean resetSwitch,
            String type,
            String useTimeUnit,
            String days
    ) {
        assertEquals(partnerId, ruleInfo.getPlatPartnerId());
//        assertEquals(partnerId, ruleInfo.getPartnerId());
        assertEquals(resetSwitch, ruleInfo.isResetSwitch());
        assertEquals(type, ruleInfo.getIntegralResetType().code());
        assertEquals(useTimeUnit, ruleInfo.getUseTimeUnit().code());
        assertEquals(days, JSON.toJSONString(ruleInfo.getDays()));
//        assertEquals(days, ruleInfo.getRawAddTime());
    }
}
