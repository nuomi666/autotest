package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserIntegralHierarchyService;
import com.xyb.gas.user.api.enums.UseTimeUnit;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.AddUserLevelRuleOrder;
import com.xyb.gas.user.api.order.UserGradeOrder;
import dal.model.gas_user.UserLevelRuleDO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/22.
 */
public class UserIntegralHierarchyServiceAddPartnerUserLevelRuleTest extends SpringBootTestBase {

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
     * *每天：传入一个数字 0 ;
     * * 每月：1-31 表示1号到31号
     * * 每周：1-7 表示周日到周六
     * * 每年：MM-DD 1-1
     * 1001
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserLevelRuleTestSuccess.csv")
    @DisplayName("保存会员等级规则--成功用例")
    public void userIntegralHierarchyServiceAddPartnerUserLevelRuleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddUserLevelRuleOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserLevelRuleByPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        // 测试过程
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
        order.setLevelRule(levelRule);
        // 调用接口
        SimpleResult result = userIntegralHierarchyService.addPartnerUserLevelRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        String corn = null;
        if (order.getUseTimeUnit().equals(UseTimeUnit.DAILY)) {
            corn = "0 0 0 " + "* * ?";
        }
        if (order.getUseTimeUnit().equals(UseTimeUnit.WEEKLY)) {
            corn = "0 0 0 " + "? " + "* " + StringUtils.join(order.getDays(), ",");
        }
        if (order.getUseTimeUnit().equals(UseTimeUnit.MONTHLY)) {
            corn = "0 0 0 " + order.getDays() + " * " + "?";
        }
        if (order.getUseTimeUnit().equals(UseTimeUnit.YEARLY)) {
            String[] split = order.getDays().split("-");
            corn = "0 0 0 " + split[1] + " " + split[0] + " ? *";
        }
        List<UserLevelRuleDO> levelRules = userTestBase.findUserLevelRuleByPlatPartnerId(order.getPlatPartnerId());
        if (testId == 1001) {
            resetRuleAssert(levelRules.get(0), order.getPlatPartnerId(),
                    JSON.toJSONString(order.getLevelRule()), order.getLevelUpdateType().code(),
                    order.getUseTimeUnit().code(), null, JSON.toJSONString(order.getDays()),
                    order.getCumulativeOfDays());
        } else {
            resetRuleAssert(levelRules.get(0), order.getPlatPartnerId(),
                    JSON.toJSONString(order.getLevelRule()), order.getLevelUpdateType().code(),
                    order.getUseTimeUnit().code(), corn, JSON.toJSONString(order.getDays()),
                    order.getCumulativeOfDays());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserLevelRuleByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserLevelRuleTestFailOne.csv")
    @DisplayName("保存会员等级规则--参数非法")
    public void userIntegralHierarchyServiceAddPartnerUserLevelRuleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddUserLevelRuleOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
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
        order.setLevelRule(levelRule);
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setLevelUpdateType(null);
        }
        if (testId == 1003) {
            order.setUseTimeUnit(null);
        }
        if (testId == 1004) {
            order.setDays(null);
        }
        if (testId == 1008) {
            order.setLevelRule(null);
        }
        if (testId == 1009) {
            order.setGid(null);
        }
        if (testId == 1010) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userIntegralHierarchyService.addPartnerUserLevelRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserLevelRuleTestFailTwo.csv")
    @DisplayName("保存会员等级规则--失败用例")
    public void userIntegralHierarchyServiceAddPartnerUserLevelRuleTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddUserLevelRuleOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserLevelRuleByPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        userTestBase.insertUserLevelTask(0L, order.getPlatPartnerId(), order.getPlatPartnerId(), "CYCLE",
                "DAILY", null, "PROCESSING", "会员升级",
                0, null, null);
        // 测试过程
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
        order.setLevelRule(levelRule);
        // 调用接口
        SimpleResult result = userIntegralHierarchyService.addPartnerUserLevelRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserLevelRuleByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
    }

    /**
     * 积分等级规则
     */
    private void resetRuleAssert(
            UserLevelRuleDO rule,
            String partnerId,
            String levelRule,
            String type,
            String useTimeUnit,
            String corn,
            String days,
            int cumulativeOfDays
    ) {
        assertEquals(partnerId, rule.getPlatPartnerId());
//        assertEquals(partnerId, rule.getPartnerId());
        assertEquals(levelRule, rule.getLevelRule());
        assertEquals(type, rule.getLevelUpdateType());
        assertEquals(useTimeUnit, rule.getUseTimeUnit());
        assertEquals(corn, rule.getCorn());
        assertEquals(days, rule.getDays());
        assertEquals(cumulativeOfDays, rule.getCumulativeOfDays());
        assertEquals("SUCCESS", rule.getStatus());
//        assertEquals(birthday, ruleInfo.getRawAddTime());
//        assertEquals(birthday, ruleInfo.getRawUpdateTime());
    }
}
