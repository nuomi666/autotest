package com.xjy.autotest.gas.pages;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.gas.pages.marketing.MarketingCenterPage;
import com.xjy.autotest.gas.pages.order.OrderCenterPage;
import com.xjy.autotest.gas.pages.report.ReportCenterPage;
import com.xjy.autotest.gas.pages.rule.RuleCenterPage;
import com.xjy.autotest.gas.pages.station.StationCenterPage;
import com.xjy.autotest.gas.pages.user.UserCenterPage;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * 加好油商户首页
 *
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class GasHomePage {

    /**
     * 营业分析
     *
     * @return
     */
    public GasHomePage businessAnalysis() {
        $(byText("营业分析")).click();
        return this;
    }


    /**
     * 油站中心
     *
     * @return
     */
    public StationCenterPage stationCenter() {
        $(byText("油站中心")).click();
        return new StationCenterPage();
    }

    /**
     * 订单中心
     *
     * @return
     */
    public OrderCenterPage orderCenter() {
        $(byText("订单中心")).click();
        return new OrderCenterPage();
    }

    /**
     * 会员中心
     *
     * @return
     */
    public UserCenterPage userCenter() {
        $(byText("会员中心")).click();
        return new UserCenterPage();
    }

    /**
     * 营销中心
     *
     * @return
     */
    public MarketingCenterPage marketingCenter() {
        $(byText("营销中心")).click();
        return new MarketingCenterPage();
    }

    /**
     * 统计报表
     *
     * @return
     */
    public ReportCenterPage reportCenter() {
        $(byText("统计报表")).click();
        return new ReportCenterPage();
    }

    /**
     * 会员设置
     *
     * @return
     */
    public RuleCenterPage ruleCenterPage() {
        $(byText("会员设置")).click();
        return new RuleCenterPage();
    }

    /**
     * 根据行号、列号获取表格数据
     *
     * @param tr 行号
     * @param td 列号
     * @return
     */
    public SelenideElement getDataCell(int tr, int td) {
        return $("tbody.ant-table-tbody > tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }

    /**
     * 删除记录
     *
     * @param i 0第一条记录
     */
    public void delete(int i) {
        $(byLinkText("删除"), i).click();
        $(".ant-btn.ant-btn-primary.ant-btn-sm").click();
    }

}
