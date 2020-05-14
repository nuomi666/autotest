package com.xjy.autotest.gas.pages.rule;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/18.
 */
public class RuleCenterPage {

    /**
     * 会员等级规则设置
     *
     * @return
     */
    public UserGradeRulePage userGradeRule() {
        $(byLinkText("会员规则设置")).click();
        return new UserGradeRulePage();
    }

    /**
     * 积分规则设置
     *
     * @return
     */
    public UserGradeRulePage pointsRule() {
        $(byLinkText("会员规则设置")).click();
        $(byText("积分规则")).click();
        return new UserGradeRulePage();
    }

    /**
     * 会员充值设置
     *
     * @return
     */
    public DepositRulePage depositRule() {
        $(byLinkText("会员充值设置")).click();
        return new DepositRulePage();
    }
}
