package com.xjy.autotest.gas.test.rule;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.rule.UserGradeRulePage;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_user.UserIntegralResetRuleDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/19.
 */
public class AddPointsResetRuleWebTest extends WebTestBase {

    @Autowired
    Gas_userTestBase userTestBase;

    @AutoTest(file = "gas/addPointsResetRuleWebTestSuccess.csv")
    @DisplayName("积分清零规则--成功用例")
    public void addPointsResetRuleWebTestSuccess(
            int testId,
            String userName,
            String password,
            String platPartnerId,
            String resetType,
            String useTimeUnit,
            String day,
            String memo
    ) {
        //清除数据
        userTestBase.cleanUserIntegralResetRuleByPlatPartnerId(platPartnerId);
        //打开浏览器测试页面
        open(testUrlGas);
        //新增规则
        UserGradeRulePage userGradeRulePage = new GasLoginPage()
                .login(userName, password)
                .ruleCenterPage()
                .pointsRule()
                .addPointsResetRule(resetType, useTimeUnit, day, memo);
        //页面数据验证
//        userGradeRulePage.checkData(stationCode, stationName, phoneNo, stationAddress, stationStatus);
        //数据库数据验证
        List<UserIntegralResetRuleDO> resetRules = userTestBase.findUserIntegralResetRuleByPlatPartnerId(platPartnerId);
        assertEquals(platPartnerId, resetRules.get(0).getPlatPartnerId());
        assertEquals(resetType, resetRules.get(0).getIntegralResetType());
//        if (testId == 1001) {
//            assertEquals(null, resetRules.get(0).getUseTimeUnit());
//        }
        //删除数据
        userTestBase.cleanUserIntegralResetRuleByPlatPartnerId(platPartnerId);
    }
}
