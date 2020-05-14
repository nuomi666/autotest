package com.xjy.autotest.gas.pages.marketing;

import com.xjy.autotest.utils.StringUtils;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 2020-2-24.
 */
public class ActivityManagePage extends MarketingCenterPage {

    /**
     * 新增活动
     *
     * @param groupName
     * @param over
     * @param priority
     * @param planNames
     * @return
     */
    public ActivityManagePage addActivity(
            String groupName,
            String over,
            String priority,
            List<String> planNames
    ) {
        $(byText("新增")).click();
        //活动名称
        $("#groupName").setValue(groupName);
        //优惠券叠加
        if ("叠加".equals(over)) {
            $(".ant-radio-input").parent().click();
        }
        if ("不叠加".equals(over)) {
            $(".ant-radio-input", 1).parent().click();
        }
        //优先级
        $("input[id=\"priority\"]").setValue(priority);
        //选择执行方案
        for (String planName : planNames) {
            $("li[title=\"" + planName + "\"] > label > span").click();
        }
        $("button[type=\"button\"]").click();

        //保存
        $("button[type=\"submit\"]").click();
        return this;
    }



    /**
     * 检查活动
     *
     * @param groupName
     * @param over
     * @param priority
     * @param planNames
     */
    public void checkActivity(
            String groupName,
            String over,
            String priority,
            List<String> planNames
    ) {
        //通过活动名称搜索
        $(".ant-input").setValue(groupName);
        $(".ant-input-suffix").click();
        if (StringUtils.isNotBlank(priority)) {
            getDataCell(1, 1).shouldHave(text(priority));
        }
        if (StringUtils.isNotBlank(groupName)) {
            getDataCell(1, 2).shouldHave(text(groupName));
        }
        if (!planNames.isEmpty()) {
            for (String planName : planNames) {
                getDataCell(1, 3).shouldHave(text(planName));
            }
        }
        if (StringUtils.isNotBlank(over)) {
            getDataCell(1, 4).shouldHave(text(over));
        }

    }
}
