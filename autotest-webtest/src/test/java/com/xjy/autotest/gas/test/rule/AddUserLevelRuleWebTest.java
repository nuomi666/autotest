package com.xjy.autotest.gas.test.rule;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.rule.UserGradeRulePage;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_user.UserLevelRuleDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/19.
 */
public class AddUserLevelRuleWebTest extends WebTestBase {

    @Autowired
    Gas_userTestBase userTestBase;

    @AutoTest(file = "gas/addUserLevelRuleWebTestSuccess.csv")
    @DisplayName("新增等级规则--成功用例")
    public void addUserLevelRuleWebTestSuccess(
            int testId,
            String userName,
            String password,
            String platPartnerId,
            String updateType,
            int cumulativeOfDays,
            String useTimeUnit,
            String day,
            String commonScore,
            String silverScore,
            String goldScore,
            String memo
    ) {
        //清除数据
        userTestBase.cleanUserLevelRuleByPlatPartnerId(platPartnerId);
        //打开浏览器测试页面
        open(testUrlGas);
        //新增规则
        UserGradeRulePage userGradeRulePage = new GasLoginPage()
                .login(userName, password)
                .ruleCenterPage()
                .userGradeRule()
                .addUserLevelRule(updateType, String.valueOf(cumulativeOfDays), useTimeUnit, day,
                        commonScore, silverScore, goldScore, memo);
        //页面数据验证
//        userGradeRulePage.checkData(stationCode, stationName, phoneNo, stationAddress, stationStatus);
        //数据库数据验证
        List<UserLevelRuleDO> levelRules = userTestBase.findUserLevelRuleByPlatPartnerId(platPartnerId);
        assertEquals(platPartnerId, levelRules.get(0).getPlatPartnerId());
        assertEquals(updateType, levelRules.get(0).getLevelUpdateType());
        assertEquals(cumulativeOfDays, levelRules.get(0).getCumulativeOfDays().intValue());
        //删除数据
        userTestBase.cleanUserLevelRuleByPlatPartnerId(platPartnerId);
    }
}
