package com.xjy.autotest.gas.pages;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

/**
 * 加好油商户登录页
 *
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class GasLoginPage {

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    public GasHomePage login(String userName, String password) {
        //输入用户名
        $("#account").setValue(userName);
        //密码
        $(byName("password")).setValue(password);
        //登录
        $(".btn-cont.fx-align").click();
        return new GasHomePage();
    }
}
