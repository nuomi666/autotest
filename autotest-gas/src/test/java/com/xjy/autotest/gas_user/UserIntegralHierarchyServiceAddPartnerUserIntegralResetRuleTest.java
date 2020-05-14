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
import com.xyb.gas.user.api.enums.IntegralResetType;
import com.xyb.gas.user.api.enums.UseTimeUnit;
import com.xyb.gas.user.api.order.AddUserIntegralResetOrder;
import dal.model.gas_user.UserIntegralResetRuleDO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/19.
 */
public class UserIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTest extends SpringBootTestBase {

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
     * 1001.定点清零
     * 1002.每天清零
     * 1003.每周日清零
     * 1004.每月1号清零
     * 1005.每年12月31号清零
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestSuccess.csv")
    @DisplayName("保存会员积分清零规则--成功用例")
    public void userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String day,
            AddUserIntegralResetOrder order

    ) {
        // 清除数据
        userTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        // 测试过程
        List<String> days = new ArrayList<String>();
        days.add(day);
        order.setDays(days);
        // 调用接口
        SimpleResult result = userIntegralHierarchyService.addPartnerUserIntegralResetRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //corn表达式
        String corn = null;
        String[] strings = order.getDays().get(0).split("-");
        if (order.getIntegralResetType().equals(IntegralResetType.CYCLE)) {
            corn = "0 " + "0 0 " + strings[2] + " " + strings[1] + " ? " + strings[0];
        }
        if (order.getUseTimeUnit().equals(UseTimeUnit.DAILY)) {
            corn = "0 0 0 " + "* * ?";
        }
        if (order.getUseTimeUnit().equals(UseTimeUnit.WEEKLY)) {
            corn = "0 0 0 " + "? " + "* " + StringUtils.join(days, ",");
        }
        if (order.getUseTimeUnit().equals(UseTimeUnit.MONTHLY)) {
            corn = "0 0 0 " + days.get(0) + " * " + "?";
        }
        if (order.getUseTimeUnit().equals(UseTimeUnit.YEARLY)) {
            String[] split = days.get(0).split("-");
            corn = "0 0 0 " + split[1] + " " + split[0] + " ? *";
        }
        List<UserIntegralResetRuleDO> rules =
                userTestBase.findUserIntegralResetRuleByPartnerId(order.getPlatPartnerId());
        resetRuleAssert(rules.get(0), order.getPlatPartnerId(),
                "true", order.getIntegralResetType().code(),
                order.getUseTimeUnit().code(), corn, JSON.toJSONString(days));
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestFailOne.csv")
    @DisplayName("保存会员积分清零规则--参数非法")
    public void userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String day,
            AddUserIntegralResetOrder order

    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> days = new ArrayList<>();
        days.add(day);
        if (testId == 1008) {
            days.add("2");
        }
        order.setDays(days);
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setIntegralResetType(null);
        }
        if (testId == 1003) {
            order.setUseTimeUnit(null);
        }
        if (testId == 1004) {
            order.setDays(null);
        }
        if (testId == 1009) {
            order.setGid(null);
        }
        if (testId == 1010) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userIntegralHierarchyService.addPartnerUserIntegralResetRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商家有清零任务正在执行
     */
    @AutoTest(file = "gas_user/userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestFailTwo.csv")
    @DisplayName("保存会员积分清零规则--失败用例")
    public void userIntegralHierarchyServiceAddPartnerUserIntegralResetRuleTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String day,
            AddUserIntegralResetOrder order

    ) {
        // 清除数据
        userTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserIntegralResetTaskByPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        userTestBase.insertUserIntegralResetTask(0L, order.getPlatPartnerId(), order.getPlatPartnerId(),
                order.getIntegralResetType().code(), order.getUseTimeUnit().code(), null,
                "PROCESSING", "会员清零", 2, null, null);
        // 测试过程
        List<String> days = new ArrayList<String>();
        days.add(day);
        order.setDays(days);
        // 调用接口
        SimpleResult result = userIntegralHierarchyService.addPartnerUserIntegralResetRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //corn表达式
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantByPlatPartnerId(order.getPlatPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserIntegralResetRuleByPartnerId(order.getPlatPartnerId());
        userTestBase.cleanUserIntegralResetTaskByPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
    }

    /**
     * 清零规则
     */
    private void resetRuleAssert(
            UserIntegralResetRuleDO ruleInfo,
            String partnerId,
            String resetSwitch,
            String type,
            String useTimeUnit,
            String corn,
            String days
    ) {
        assertEquals(partnerId, ruleInfo.getPlatPartnerId());
//        assertEquals(partnerId, ruleInfo.getPartnerId());
        assertEquals(resetSwitch, ruleInfo.getResetSwitch());
        assertEquals(type, ruleInfo.getIntegralResetType());
        assertEquals(useTimeUnit, ruleInfo.getUseTimeUnit());
        assertEquals(corn, ruleInfo.getCorn());
        assertEquals(days, ruleInfo.getDays());
//        assertEquals(birthday, ruleInfo.getRawAddTime());
//        assertEquals(birthday, ruleInfo.getRawUpdateTime());
    }
}
