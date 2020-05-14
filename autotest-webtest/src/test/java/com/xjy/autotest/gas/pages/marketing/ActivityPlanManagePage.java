package com.xjy.autotest.gas.pages.marketing;

import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.Keys;

import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 2020-2-21.
 */
public class ActivityPlanManagePage extends MarketingCenterPage {

    /**
     * 新增活动方案
     *
     * @param name
     * @param money
     * @param stationName
     * @param lifeCycle
     * @param beginTime
     * @param finishTime
     * @return
     */
    public ActivityPlanManagePage addActivityPlan(
            String name,
            String modelName,
            String money,
            String stationName,
            String lifeCycle,
            String startHours,
            String endHours,
            Date beginTime,
            Date finishTime
    ) {
        $(byLinkText("新增方案")).click();
        //方案名称
        $("#name").setValue(name);
        $(byText("请选择方案模板")).click();
        $(byText(modelName)).click();
        $("input[placeholder=\"请输入\"]").setValue(money);
        //选择禁用油站
        $("li[title=\"" + stationName + "\"] > label > span").click();
        $("button[type=\"button\"]").click();
        //选择有效期
        $("input[value=\"" + lifeCycle + "\"]").parent().click();
        //选择日期
        if ("CYCLE".equals(lifeCycle)) {
            //选择时间
            $("#dailyTimeSlotStartTime").setValue(startHours);
            $("#dailyTimeSlotEndTime").setValue(endHours);
        }
        if ("TIME_SLOT".equals(lifeCycle)) {
            $("#range-time-picker").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-date").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-start-date.ant-calendar-selected-date" +
                    ".ant-calendar-selected-day").click();
            while (StringUtils.isNotBlank($("input[placeholder=\"开始日期\"", 1).val())) {
                $("input[placeholder=\"开始日期\"", 1).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"开始日期\"", 1).val(DateUtils.formatDate(beginTime, "yyyy-MM-dd HH:mm:ss"));
            while (StringUtils.isNotBlank($("input[placeholder=\"结束日期\"", 1).val())) {
                $("input[placeholder=\"结束日期\"", 1).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"结束日期\"", 1).val(DateUtils.formatDate(finishTime, "yyyy-MM-dd HH:mm:ss"));
            $(".ant-calendar-ok-btn").click();
        }
        //保存
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 检查活动方案
     *
     * @param name
     * @param modelName
     */
    public void checkActivityPlan(
            String name,
            String modelName
    ) {
        if (StringUtils.isNotBlank(name)) {
            getDataCell(1, 1).shouldHave(text(name));
        }
        if (StringUtils.isNotBlank(modelName)) {
            getDataCell(1, 2).shouldHave(text(modelName));
        }

    }

}
