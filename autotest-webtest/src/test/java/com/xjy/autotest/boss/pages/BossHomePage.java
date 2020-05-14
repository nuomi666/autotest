package com.xjy.autotest.boss.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author ychaoyang
 * Created on 18/9/3.
 */
public class BossHomePage {
    /**
     * 首页
     */
    public BossHomePage home() {
        refresh();
        return this;
    }

    /**
     * 商户接入管理
     */
    public BossHomePage merchManage() {
        $(By.partialLinkText("商户接入管理")).click();
        return this;
    }

    /**
     * 会员管理
     */
    public BossHomePage userManage() {
        $(By.partialLinkText("会员管理")).click();
        return this;
    }

    /**
     * 会员信息
     */
    public UserManage userInfo() {
        $(By.partialLinkText("会员信息")).click();
        return new UserManage();
    }




}
