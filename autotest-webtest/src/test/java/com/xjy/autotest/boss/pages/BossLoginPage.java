package com.xjy.autotest.boss.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 18/9/3.
 */
public class BossLoginPage {

    /**
     * 登录
     */
    public BossHomePage login(String name, String password) {
        //用户名
        $(By.name("username")).setValue(name);
        //密码
        $(By.name("password")).setValue(password);
        //登录
        $("button[type=\"submit\"]").click();
        //返回到主页
        return new BossHomePage();
    }
}
