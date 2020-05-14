package com.xjy.autotest.gas.pages.marketing;


import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.Keys;

import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author ychaoyang
 * Created on 2020-02-26.
 */
public class PutInPage extends MarketingCenterPage {

    /**
     * 精准投放
     */
    public PutInPage addPutIn(
            String deliveryName,
            String deliveryStartTime,
            String deliveryDescription,
            String conditionType,
            List<String> conditions,
            List<String> grades,
            String startBirth,
            String endBirth,
            String sex,
            double minBalance,
            double maxBalance,
            int minPoints,
            int maxPoints,
            List<String> mobiles,
            Date statisticalStartTime,
            Date statisticalEndTime,
            List<String> stations,
            List<String> goodsCodes,
            Date minConsumTime,
            Date maxConsumTime,
            int minUnConsumDays,
            int maxUnConsumDays,
            double minTotalConsumAmount,
            double maxTotalConsumAmount,
            double minPrice,
            double maxPrice,
            String goodsType,
            double minLiters,
            double maxLiters,
            int minOilCount,
            int maxOilCount,
            double minHinghLiters,
            double maxHinghLiters,
            String basicDiscount,
            String points
    ) {
        $(byLinkText("新增")).click();
        //投放标题
        $("#deliveryName").setValue(deliveryName);
        //投放时间
        $("#deliveryStartTime").click();
        $(".ant-calendar-input").setValue(deliveryStartTime);
        $(".ant-calendar-ok-btn").click();
        //备注
        $("#deliveryDescription").setValue(deliveryDescription);
        $(byText("编辑筛选条件")).click();
        sleep(1000);
        //投放目标
        $(byText(conditionType)).click();
        for (String condition : conditions) {
            $(byText(condition)).parent().$("span").click();
        }
        //确定
        $(".ant-btn.ant-btn-primary", 1).click();
        //统计范围
        if ("统计条件筛选".equals(conditionType)) {
            $("#statisticsTime").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-date").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-start-date.ant-calendar-selected-date" +
                    ".ant-calendar-selected-day").click();
            $("#statisticsTime").click();
            while (StringUtils.isNotBlank($("input[placeholder=\"开始日期\"", 1).val())) {
                $("input[placeholder=\"开始日期\"", 1).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"开始日期\"", 1).val(DateUtils.formatDate(statisticalStartTime, "yyyy-MM-dd"));
            while (StringUtils.isNotBlank($("input[placeholder=\"结束日期\"", 1).val())) {
                $("input[placeholder=\"结束日期\"", 1).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"结束日期\"", 1).val(DateUtils.formatDate(statisticalEndTime, "yyyy-MM-dd"));
            $("#deliveryDescription").click();
        }
        //选择等级
        for (String condition : conditions) {
            if ("会员等级".equals(condition)) {//设置等级
                for (String grade : grades) {
                    $("input[value=\"" + grade + "\"]").parent().click();
                }
            }
            if ("会员生日".equals(condition)) {//设置生日
                $("#minBirthday").click();
                $(".ant-calendar-input ").setValue(startBirth);
                $("#maxBirthday").click();
                $(".ant-calendar-input ").setValue(endBirth);
            }
            if ("会员性别".equals(condition)) {//设置性别
                $(".ant-select-selection__placeholder").click();
                $$(byText(sex)).last().click();
            }
            if ("账户余额".equals(condition)) {//设置余额
                $("#minBalance").setValue(String.valueOf(minBalance));
                $("#maxBalance").setValue(String.valueOf(maxBalance));
            }
            if ("账户积分".equals(condition)) {//设置积分
                $("#minPoints").setValue(String.valueOf(minPoints));
                $("#maxPoints").setValue(String.valueOf(maxPoints));
            }
            if ("手机号码".equals(condition)) {//手机筛选
                for (int i = 1; i < mobiles.size(); i++) {
                    $("button.ant-btn.ant-btn-dashed").click();
                }
                int n = 0;
                for (String mobile : mobiles) {
                    $(byId("phoneNo-" + String.valueOf(n))).setValue(mobile);
                    n++;
                }
            }
            if ("油站偏好".equals(condition)) {
                $("#preferenceStation").click();
                for (String stationName : stations) {
                    $$(byText(stationName)).last().click();
                }
                $("#deliveryDescription").click();
            }
            if ("消费偏好".equals(condition)) {
                for (String code : goodsCodes) {
                    $("input[value=\"" + code + "\"]").parent().click();
                }
            }
            if ("最近消费时间".equals(condition)) {
                $("#minLatelyConsumptionTime").click();
                $(".ant-calendar-input").setValue(DateUtils.formatDate(minConsumTime, "yyyy-MM-dd HH:mm:ss"));
                $(".ant-calendar-ok-btn").click();
                $("#maxLatelyConsumptionTime").click();
                $(".ant-calendar-input").setValue(DateUtils.formatDate(maxConsumTime, "yyyy-MM-dd HH:mm:ss"));
                $(".ant-calendar-ok-btn").click();
            }
            if ("未消费天数".equals(condition)) {
                $("#minUnConsumptionDay").setValue(String.valueOf(minUnConsumDays));
                $("#maxUnConsumptionDay").setValue(String.valueOf(maxUnConsumDays));
            }
            if ("累计消费金额".equals(condition)) {
                $("#minTotalConsumptionAmount").setValue(String.valueOf(minTotalConsumAmount));
                $("#maxTotalConsumptionAmount").setValue(String.valueOf(maxTotalConsumAmount));
            }
            if ("客单价".equals(condition)) {
                $("#minPerCustomerTransaction").setValue(String.valueOf(minPrice));
                $("#maxPerCustomerTransaction").setValue(String.valueOf(maxPrice));
            }
            if ("累计消费油品数量".equals(condition)) {
                $(".ant-select-selection__rendered", 1).click();
                $$(byText(goodsType)).last().click();
                $("#minTotalOilLiter").setValue(String.valueOf(minLiters));
                $("#maxTotalOilLiter").setValue(String.valueOf(maxLiters));
            }
            if ("累计消费油品次数".equals(condition)) {
                $("#minTotalOilCount").setValue(String.valueOf(minOilCount));
                $("#maxTotalOilCount").setValue(String.valueOf(maxOilCount));
            }
            if ("单次最高消费油品数量".equals(condition)) {
                $("#minSingleHighestLiter").setValue(String.valueOf(minHinghLiters));
                $("#maxSingleHighestLiter").setValue(String.valueOf(maxHinghLiters));
            }
        }
        $(byText("编辑优惠")).click();
        //投放优惠
        if (StringUtils.isNotBlank(basicDiscount)) {
            $(byText("常规优惠")).click();
            $(byText(basicDiscount)).parent().$("span").click();
        }
        //确定按钮
        $(".ant-btn.ant-btn-primary", 2).click();
        //积分
        if (StringUtils.isNotBlank(points)) {
            $("#points").setValue(points);
        }
        //保存
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    /**
     * 删除投放信息
     *
     * @param deliveryName
     * @return
     */
    public PutInPage delDelivery(String deliveryName) {
        $(byLinkText("精准投放")).click();
        $(byLinkText("删除"), getDeliveryTr(deliveryName) - 1).click();
        //确定
        $("button.ant-btn.ant-btn-primary.ant-btn-sm").click();
        sleep(1000);
        return this;
    }

    /**
     * 验证投放信息是否正确
     */
    public void checkDeliveryData(String deliveryName, String deliveryTime, String memo,
                                  String status, String operator) {
        //重新进入会员分组管理页面，刷新
        $(byLinkText("精准投放")).click();
        int tr = getDeliveryTr(deliveryName);
        getDataCell(tr, 1).shouldHave(text(deliveryName));
        getDataCell(tr, 2).shouldHave(text(deliveryTime));
        getDataCell(tr, 3).shouldHave(text(memo));
        getDataCell(tr, 4).shouldHave(text(status));
        getDataCell(tr, 5).shouldHave(text(operator));
    }

    /**
     * 根据分组名获取所在行号
     *
     * @param deliveryName
     * @return
     */
    public int getDeliveryTr(String deliveryName) {
        for (int a = 1; a < 10; a++) {
            if (deliveryName.equals($("tbody.ant-table-tbody > tr:nth-child(" + a + ") > td:nth-child(" + 1 + ")").text())) {
                return a;
            }
        }
        return 0;
    }
}
