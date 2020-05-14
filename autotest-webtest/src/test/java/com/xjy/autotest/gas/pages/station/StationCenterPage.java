package com.xjy.autotest.gas.pages.station;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * 油站中心页面
 *
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class StationCenterPage {

    /**
     * 油站管理
     *
     * @return
     */
    public StationManagePage stationManage() {
        $(byLinkText("油站管理")).click();
        return new StationManagePage();
    }

    /**
     * 站长管理
     *
     * @return
     */
    public StationOwnerManagerPage stationManager() {
        $(byLinkText("员工管理")).click();
        return new StationOwnerManagerPage();
    }

    /**
     * 电子发票
     *
     * @return
     */
    public MerchantInvoicePage invoiceManager() {
        $(byLinkText("电子发票")).click();
        return new MerchantInvoicePage();
    }

    /**
     * 商家油价管理
     *
     * @return
     */
    public MerchantPricePlanManagePage oilPriceManager() {
        $(byLinkText("油价管理-总部")).click();
        return new MerchantPricePlanManagePage();
    }

    /**
     * 油站油价管理
     *
     * @return
     */
    public StationPricePlanManagePage stationPricePlanManage() {
        $(byLinkText("油价管理-总部")).click();
        $(byText("油站油价列表")).click();
        return new StationPricePlanManagePage();
    }
}
