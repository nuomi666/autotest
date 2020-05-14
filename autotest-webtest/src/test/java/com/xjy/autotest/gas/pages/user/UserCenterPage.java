package com.xjy.autotest.gas.pages.user;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/18.
 */
public class UserCenterPage {

    /**
     * 会员概况
     *
     * @return
     */
    public UserInfoPage userInfo() {
        $(byLinkText("会员数据概况")).click();
        return new UserInfoPage();
    }

    /**
     * 会员管理
     *
     * @return
     */
    public UserManagePage userManage() {
        $(byLinkText("会员管理")).click();
        return new UserManagePage();
    }

    /**
     * 会员消费概况
     *
     * @return
     */
    public UserTradeManagePage userTradeManagePage() {
        $(byLinkText("会员消费概况")).click();
        return new UserTradeManagePage();
    }

    /**
     * 会员分组管理
     *
     * @return
     */
    public UserGroupManagePage userGroupManage() {
        $(byLinkText("会员管理")).click();
        $(byText("会员分组")).click();
        return new UserGroupManagePage();
    }
}
