package com.xjy.autotest.gas.test.rule;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.rule.DepositRulePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_merchant.MerchantProtocolRuleDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/20.
 */
public class AddDepositRuleWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @AutoTest(file = "gas/addDepositRuleWebTestSuccess.csv")
    @DisplayName("自定义充值金额--成功用例")
    public void addDepositRuleWebTestSuccess(
            int testId,
            String userName,
            String password,
            String platPartnerId,
            String money,
            String money1,
            String money2,
            String protocol,
            String description
    ) {
        //清除数据
        gasMerchantTestBase.cleanMerchantProtocolRuleByPlatPartnerId(platPartnerId);
        //准备数据
        List<String> moneys = new ArrayList<>();
        moneys.add(money);
        moneys.add(money1);
        moneys.add(money2);
        //打开浏览器测试页面
        open(testUrlGas);
        //新增规则
        DepositRulePage depositRulePage = new GasLoginPage()
                .login(userName, password)
                .ruleCenterPage()
                .depositRule()
                .addDepositRule(moneys, protocol, description);
        //页面数据验证
//        depositRulePage.checkData(stationCode, stationName, phoneNo, stationAddress, stationStatus);
        //数据库数据验证
        List<MerchantProtocolRuleDO> merchantProtocolRules =
                gasMerchantTestBase.findMerchantProtocolRuleByPlatPartnerId(platPartnerId);
        assertEquals(platPartnerId, merchantProtocolRules.get(0).getPlatPartnerId());
        assertEquals(protocol, merchantProtocolRules.get(0).getProtocol());
        assertEquals(description, merchantProtocolRules.get(0).getDescription());
//        if (testId == 1001) {
//            assertEquals(null, resetRules.get(0).getUseTimeUnit());
//        }
        //删除数据
        gasMerchantTestBase.cleanMerchantProtocolRuleByPlatPartnerId(platPartnerId);
    }
}
