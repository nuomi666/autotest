package com.xjy.autotest.gas.pages.station;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.By;

import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/12.
 */
public class MerchantPricePlanManagePage {

    /**
     * 新增商家油价
     *
     * @param priceName
     * @param effectTime
     * @param stations
     * @param oils
     * @return
     */
    public MerchantPricePlanManagePage addMerchantPricePlan(
            String priceName,
            Date effectTime,
            List<String> stations,
            List<String> oils
    ) {
        //点击"新增"
        $(byLinkText("下发油价计划")).click();
        //输入油价名称
        $(byId("priceName")).setValue(priceName);
        //生效时间
        $("#effectTime").click();
        $(".ant-calendar-input").setValue(DateUtils.formatDate(effectTime, "yyyy-MM-dd HH:mm:ss"));
        $(".ant-calendar-ok-btn").click();
        //选择油站
        for (String stationName : stations) {
            $(byText(stationName)).click();
        }
        $(".anticon.anticon-right").parent().click();
        //设置油价
        for (int i = 0; i < oils.size(); i++) {
            $(byId("machinePrice-" + String.valueOf(i))).setValue(String.valueOf(i + 1));
        }
        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 更新商家油价
     *
     * @param priceName
     * @param effectTime
     * @param delStation
     * @param addStation
     * @param oils
     * @return
     */
    public MerchantPricePlanManagePage updMerchantPricePlan(
            String priceName,
            String priceNamexx,
            Date effectTime,
            String delStation,
            String addStation,
            List<String> oils
    ) {
        //通过油价名称查询出要修改的油价
        $(".ant-input").setValue(priceName);
        $(".ant-input-suffix").click();
        $(By.linkText("编辑")).click();
        //输入油价名称
        if (StringUtils.isNotBlank(priceNamexx)) {
            $(byId("priceName")).setValue(priceNamexx);
        }
        //生效时间
        $("#effectTime").click();
        $(".ant-calendar-input").setValue(DateUtils.formatDate(effectTime, "yyyy-MM-dd HH:mm:ss"));
        $(".ant-calendar-ok-btn").click();
        //修改下发油站
        //分配油站
        if (StringUtils.isNotBlank(addStation)) {
            $(byTitle(addStation)).click();
            //右移
            $(".anticon.anticon-right").parent().click();
        }
        //删除油站
        if (StringUtils.isNotBlank(delStation)) {
            $(byTitle(delStation)).click();
            //左移
            $(".anticon.anticon-left", 1).parent().click();
        }
        //修改油价
        for (int i = 0; i < oils.size(); i++) {
            $(byId("machinePrice-" + String.valueOf(i))).setValue(String.valueOf(i + 0.5));
        }
        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 验证商家油价页面数据是否正确
     *
     * @param priceName
     * @param effectTime
     * @param operatorName
     */
    public void checkData(String priceName, Date effectTime, String operatorName, Date addTime) {
        //重新进入油价计划页面，刷新刚刚新增的油价
        $(byLinkText("油价管理-总部")).click();
        int tr = getPriceTr(priceName);
        getDataCell(tr, 1).shouldHave(text(priceName));
        getDataCell(tr, 2).shouldHave(text(DateUtils.formatDate(effectTime, "yyyy-MM-dd HH:mm:ss")));
        getDataCell(tr, 5).shouldHave(text(operatorName));
        getDataCell(tr, 6).shouldHave(text(DateUtils.formatDate(addTime, "yyyy-MM-dd HH:mm:ss")));
    }


    /**
     * 根据油价名称所在行号
     *
     * @param priceName
     * @return
     */
    public int getPriceTr(String priceName) {
        for (int a = 1; a < 10; a++) {
            if (priceName.equals($("tbody.ant-table-tbody > tr:nth-child(" + a + ") > td:nth-child(" + 1 + ")").text())) {
                return a;
            }
        }
        return 0;
    }

    /**
     * 根据行号列号获取油站数据表格元素
     *
     * @param tr 行号
     * @param td 列号
     * @return
     */
    public SelenideElement getDataCell(int tr, int td) {
        return $("tbody.ant-table-tbody > tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }

    /**
     * 根据油品编码获取油价输入框id的角标
     *
     * @param size
     * @param oilName
     * @return
     */
    public int getOilNameTr(int size, String oilName) {
        for (int a = 0; a < size; a++) {
            if (oilName.equals($(".ant-col.ant-col-4.text-right").text())) {
                return a;
            }
        }
        return -1;
    }
}
