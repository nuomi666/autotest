package com.xjy.autotest.gas.pages.report;

import com.xjy.autotest.gas.pages.GasHomePage;
import com.xjy.autotest.gas.pages.marketing.CouponManagePage;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 2020-03-03.
 */
public class ReportCenterPage extends GasHomePage {

    /**
     * 班结报表
     */
    public ClassReportPage classReport() {
        $(byLinkText("班结报表")).click();
        return new ClassReportPage();
    }

    /**
     * 日结报表
     */
    public ReportCenterPage dayReport() {
        $(byLinkText("日结报表")).click();
        return new ReportCenterPage();
    }

}
