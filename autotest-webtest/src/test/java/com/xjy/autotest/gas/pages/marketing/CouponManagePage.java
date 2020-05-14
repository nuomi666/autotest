package com.xjy.autotest.gas.pages.marketing;

import com.xjy.autotest.utils.DateUtils;
import org.openqa.selenium.By;

import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * @author ychaoyang
 * Created on 2020-2-19.
 */
public class CouponManagePage extends MarketingCenterPage {

    /**
     * 新增优惠券
     *
     * @param name
     * @param couponType
     * @param amountData
     * @param couponBizType
     * @param goodsCodes
     * @param expirationType
     * @param thresholdAmount
     * @param useTimeUnit
     * @param weeks
     * @param days
     * @param memo
     * @return
     */
    public CouponManagePage addCoupon(
            String name,
            String couponType,
            String amountData,
            String couponBizType,
            List<String> goodsCodes,
            String expirationType,
            Date startTime,
            Date endTime,
            String effectDay,
            String valueTime,
            String thresholdAmount,
            String useTimeUnit,
            String startHours,
            String endHours,
            List<String> weeks,
            List<String> days,
            String memo
    ) {
        $(byLinkText("新增")).click();
        //优惠券名称
        $("#name").setValue(name);
        //优惠券类型
        $("input[value=\"" + couponType + "\"]").parent().parent().click();
        //折扣/优惠金额
        $("#amountData").setValue(amountData);
        //适用品类
        $("input[value=\"" + couponBizType + "\"]").parent().parent().click();
        for (String goodsCode : goodsCodes) {
            $("input[value=\"" + goodsCode + "\"]").parent().click();
        }
        //生效时间
        $("input[value=\"" + expirationType + "\"]").parent().parent().click();
        if ("SECTION".equals(expirationType)) {
            $("span.ant-calendar-picker").click();
            $(".ant-calendar-input ", 0).setValue(DateUtils.formatDate(startTime, "yyyy-MM-dd HH:mm:ss"));
            $(".ant-calendar-input ", 1).setValue(DateUtils.formatDate(endTime, "yyyy-MM-dd HH:mm:ss"));
            $(".ant-calendar-ok-btn").click();
        }
        if ("INTERVAL".equals(expirationType)) {
            $(byText("领取")).parent().$("input").setValue(effectDay);
            $(byText("有效期")).parent().$("input").setValue(valueTime);
        }
        //最低使用金额
        $("#thresholdAmount").setValue(thresholdAmount);
        //可用时段
//        $(byText(useTimeUnit)).click();
        $("input[value=\"" + useTimeUnit + "\"]").parent().parent().click();
        if ("DAILY".equals(useTimeUnit)) {
            //选择时间
            $("span.ant-time-picker", 0).click();
            $(".ant-time-picker-panel-input").setValue(startHours);
            $("span.ant-time-picker", 1).click();
            $(".ant-time-picker-panel-input").setValue(endHours);
        }
        if ("WEEKLY".equals(useTimeUnit)) {
            //选择星期几:weeks1~7代表星期日~星期六
            for (String week : weeks) {
                $("input[value=\"" + week + "\"]").parent().click();
            }
            //选择时间
            $("span.ant-time-picker", 0).click();
            $(".ant-time-picker-panel-input").setValue(startHours);
            $("span.ant-time-picker", 1).click();
            $(".ant-time-picker-panel-input").setValue(endHours);
        }
        if ("MONTHLY".equals(useTimeUnit)) {
            //选择几号:days1~31代表每月1号~31号
            for (String day : days) {
                $("input[value=\"" + day + "\"]").parent().click();
            }
            //选择时间
            $("span.ant-time-picker", 0).click();
            $(".ant-time-picker-panel-input").setValue(startHours);
            $("span.ant-time-picker", 1).click();
            $(".ant-time-picker-panel-input").setValue(endHours);
        }
        //选择油站
        $("div.ant-transfer-list-header > label > span > input").parent().click();
        $("button[type=\"button\"]").click();
        //备注
        $("#memo").setValue(memo);
        //保存
        $("button[type=\"submit\"]").click();
        sleep(2000);
        return this;
    }

    /**
     * 编辑优惠券
     *
     * @param name
     * @param memo
     * @return
     */
    public CouponManagePage updateCoupon(
            String name,
            String memo
    ) {
        //搜索出要修改的优惠券
        $(".ant-input").setValue(name);
        $(".anticon.anticon-search.ant-input-search-icon").click();
        $(By.linkText("编辑")).click();
        //优惠券名称
        $("#name").setValue(name);
        //备注
        $("#memo").setValue(memo);
        //保存
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    /**
     * 删除优惠券
     *
     * @param name
     * @return
     */
    public CouponManagePage deleteCoupon(String name) {
        //搜索出要删除的优惠券
        $(".ant-input").setValue(name);
        $(".anticon.anticon-search.ant-input-search-icon").click();
        //若存在则进行删除
        $(By.linkText("删除")).click();
        //确定删除
        $("span[value=\"" + "确定" + "\"]").parent().click();
        return this;
    }

    /**
     * 验证优惠券信息是否正确
     *
     * @param name
     * @param couponType
     */
    public void checkData(String name, String couponType) {

        $(byLinkText("优惠券")).click();
        //搜索出新增的优惠券
        $(".ant-input").setValue(name);
        $(".anticon.anticon-search.ant-input-search-icon").click();
        getDataCell(1, 1).shouldHave(text(name));
        if (couponType.equals("DISCOUNT")) {
            getDataCell(1, 2).shouldHave(text("折扣券"));
        }
        if (couponType.equals("OVER")) {
            getDataCell(1, 2).shouldHave(text("满减券"));
        }
    }
}
