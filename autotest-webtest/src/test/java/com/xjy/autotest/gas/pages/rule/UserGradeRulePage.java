package com.xjy.autotest.gas.pages.rule;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/18.
 */
public class UserGradeRulePage {

    public UserGradeRulePage addUserLevelRule(String updateType, String cumulativeOfDays, String useTimeUnit,
                                              String day, String commonScore, String silverScore,
                                              String goldScore, String memo) {
        $("input[value=\"" + updateType + "\"]").parent().parent().click();
        if ("CYCLE".equals(updateType)) {
            $(".ant-select-selection__rendered").click();
            $$(byText(useTimeUnit)).last().click();
            if ("每周".equals(useTimeUnit)) {
                $(".ant-select-selection__rendered", 1).click();
                $$(byText(day)).last().click();
            }
            if ("每月".equals(useTimeUnit)) {
                $(byText("号")).parent().$("input").setValue(day);
            }
            if ("每年".equals(useTimeUnit)) {
                $(".ant-calendar-picker").click();
                $(".ant-calendar-input ").setValue(day);
            }
        }
        $("#cumulativeOfDays").setValue(cumulativeOfDays);
        //等级积分设置
        $(byText("普通会员")).parent().$("input", 1).setValue(commonScore);
        $(byText("白银会员")).parent().$("input", 1).setValue(silverScore);
        $(byText("黄金会员")).parent().$("input", 1).setValue(goldScore);
        //规则说明
        $("textarea.ant-input").setValue(memo);
        //保存
        $("button[type=\"submit\"]").click();
        sleep(2000);
        //重新积分设置页面，刷新刚刚保存的积分规则
        $(byLinkText("会员规则设置")).click();
        return this;
    }

    public UserGradeRulePage addPointsResetRule(String resetType, String useTimeUnit,
                                                String day, String memo) {
        //打开开关
        $(".ant-switch").click();
        if ("CYCLE".equals(resetType)) {
            $("input[value=\"" + resetType + "\"]", 1).parent().parent().click();
            $(".ant-select-selection__rendered", 1).click();
            $$(byText(useTimeUnit)).last().click();
            if ("每周".equals(useTimeUnit)) {
//                $(".ant-select-selection__rendered", 3).click();
                getText("积分清零").$(".ant-select-selection__rendered", 1).click();
                $$(byText(day)).last().click();
            }
            if ("每月".equals(useTimeUnit)) {
                $(byText("号")).parent().$("input").setValue(day);
            }
            if ("每年".equals(useTimeUnit)) {
                $(".ant-calendar-picker").click();
                $(".ant-calendar-input ").setValue(day);
            }
        }
        if ("FIXED_POINT_ZERO".equals(resetType)) {
            $("input[value=\"" + resetType + "\"]").parent().parent().click();
            $(".ant-calendar-picker").click();
            $(".ant-calendar-input ").setValue(day);
        }
        //规则说明
        $("textarea.ant-input", 1).setValue(memo);
        //保存
        $("button[type=\"submit\"]", 1).click();
        sleep(2000);
        //重新积分设置页面，刷新刚刚保存的积分规则
        $(byLinkText("会员规则设置")).click();
        $(byText("积分规则")).click();
        return this;
    }

    /**
     * 根据特殊字段获取元素
     *
     * @param code
     */
    public SelenideElement getText(String code) {
        return $(byText(code)).parent().parent().parent();
    }
}
