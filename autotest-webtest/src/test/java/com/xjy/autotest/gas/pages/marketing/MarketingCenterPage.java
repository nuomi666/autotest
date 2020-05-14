package com.xjy.autotest.gas.pages.marketing;

import com.xjy.autotest.gas.pages.GasHomePage;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 2020-2-19.
 */
public class MarketingCenterPage extends GasHomePage {

    /**
     * 优惠券
     */
    public CouponManagePage coupon() {
        $(byLinkText("优惠券")).click();
        return new CouponManagePage();
    }

    /**
     * 活动方案管理
     */
    public ActivityPlanManagePage activityPlan() {
        $(byLinkText("活动方案管理")).click();
        return new ActivityPlanManagePage();
    }

    /**
     * 活动管理
     */
    public ActivityManagePage activity() {
        $(byLinkText("活动管理")).click();
        return new ActivityManagePage();
    }

    /**
     * 抽奖管理
     */
    public AwardManagePage award() {
        $(byLinkText("抽奖管理")).click();
        return new AwardManagePage();
    }

    /**
     * 积分商城
     */
    public PointsManagePage points() {
        $(byLinkText("积分商城")).click();
        return new PointsManagePage();
    }

    /**
     * 精准投放
     */
    public PutInPage putIn() {
        $(byLinkText("精准投放")).click();
        return new PutInPage();
    }

}
