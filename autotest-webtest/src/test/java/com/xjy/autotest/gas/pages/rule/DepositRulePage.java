package com.xjy.autotest.gas.pages.rule;

import java.util.List;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/18.
 */
public class DepositRulePage {

    public DepositRulePage addDepositRule(List<String> moneys, String protocol, String description) {
        //设置自定义金额
        int i = 0;
        for (String money : moneys) {
            $(byLinkText("添加充值金额")).click();
            $(byText("元"), i).parent().$("input").setValue(money);
            i++;
        }
        //打开/关闭开关
//        $(".ant-switch").click();
        //规则说明
        $("textarea.ant-input").setValue(description);
        //协议
        $("textarea.ant-input", 1).setValue(protocol);
        //保存
        $(".ant-btn.ant-btn-primary").click();
        sleep(2000);
        //重新积分设置页面，刷新刚刚保存的积分规则
        $(byLinkText("会员充值设置")).click();
        return this;
    }
}
