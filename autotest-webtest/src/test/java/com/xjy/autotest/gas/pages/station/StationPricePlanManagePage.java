package com.xjy.autotest.gas.pages.station;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.By;

import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/12.
 */
public class StationPricePlanManagePage {

    public StationPricePlanManagePage editStationPricePlan(
            String stationName,
            String priceName,
            Date effectTime,
            List<String> oils
    ) {
        //检索油站
        $(".ant-select.ant-select-enabled.ant-select-allow-clear").click();
        $$(byText(stationName)).last().click();
//        $("button.ant-btn.ant-btn-primary").click();
        //点击"查询"按钮(用第二个button)
        $("button[type=\"button\"]", 1).click();
        //编辑
        $(By.linkText("编辑")).click();
        //输入油价名称
        if (StringUtils.isNotBlank(priceName)) {
            $(byId("priceName")).setValue(priceName);
        }
        //生效时间
        $("#effectTime").click();
        $(".ant-calendar-input").setValue(DateUtils.formatDate(effectTime, "yyyy-MM-dd HH:mm:ss"));
        $(".ant-calendar-ok-btn").click();
        //设置油价
        for (int i = 0; i < oils.size(); i++) {
            $(byId("machinePrice-" + String.valueOf(i))).setValue(String.valueOf(i + 0.2));
        }
        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 验证油站油价页面数据是否正确
     *
     * @param stationName
     * @param priceName
     * @param effectTime
     * @param operatorName
     */
    public void checkData(String stationName, String priceName, Date effectTime, String operatorName, Date addTime) {
        //重新进入油站油价计划页面
        $(byText("油站油价列表")).click();
        int tr = getPriceTr(stationName);
        getDataCell(tr, 1).shouldHave(text(stationName));
        getDataCell(tr, 2).shouldHave(text(priceName));
        getDataCell(tr, 3).shouldHave(text(DateUtils.formatDate(effectTime, "yyyy-MM-dd HH:mm:ss")));
        getDataCell(tr, 5).shouldHave(text(operatorName));
        getDataCell(tr, 6).shouldHave(text(DateUtils.formatDate(addTime, "yyyy-MM-dd HH:mm:ss")));
    }


    /**
     * 根据油站名称所在行号
     *
     * @param stationName
     * @return
     */
    public int getPriceTr(String stationName) {
        for (int a = 1; a < 10; a++) {
            if (stationName.equals($("tbody.ant-table-tbody > tr:nth-child(" + a + ") > td:nth-child(" + 1 + ")").text())) {
                return a;
            }
        }
        return 0;
    }

    /**
     * 根据行号列号获取油价数据表格元素
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
