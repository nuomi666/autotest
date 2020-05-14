package com.xjy.autotest.gas.pages.user;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.StringUtils;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/18.
 */
public class UserManagePage {

    public UserManagePage addGroupMember(List<String> mobiles, String groupName) {
        //重新进入会员分组管理页面，刷新
        $(byLinkText("会员管理")).click();
        //选择手机号
        for (String mobile : mobiles) {
            $(".ant-checkbox-input", getUserTr(mobile)).parent().click();
        }
        //添加分组
        $(byText("添加至分组")).parent().click();
        $(".ant-select-selection__rendered").click();
        $$(byText(groupName)).last().click();
        $(".ant-btn.ant-btn-primary", 1).click();
        return this;
    }

    /**
     * 验证会员信息是否正确
     */
    public void checkUserData(String mobile, String nickName, String sex, String carNum, String grade,
                              int balance, int points, String groupName, String registFrom, String recommend) {
        //重新进入会员分组管理页面，刷新
        $(byLinkText("会员管理")).click();
        int tr = getUserTr(mobile);
        if (StringUtils.isNotBlank(nickName)) {
            getDataCell(tr, 2).shouldHave(text(nickName));
        }
        getDataCell(tr, 3).shouldHave(text(mobile));
        getDataCell(tr, 4).shouldHave(text(sex));
        if (StringUtils.isNotBlank(carNum)) {
            getDataCell(tr, 5).shouldHave(text(carNum));
        }
        getDataCell(tr, 6).shouldHave(text(grade));
        getDataCell(tr, 7).shouldHave(text(String.valueOf(balance)));
        getDataCell(tr, 8).shouldHave(text(String.valueOf(points)));
        getDataCell(tr, 9).shouldHave(text(groupName));
        getDataCell(tr, 11).shouldHave(text(registFrom));
        getDataCell(tr, 12).shouldHave(text(recommend));
    }

    /**
     * 根据手机号获取所在行号
     *
     * @param mobile
     * @return
     */
    public int getUserTr(String mobile) {
        for (int a = 1; a < 10; a++) {
            if (mobile.equals($("tbody.ant-table-tbody > tr:nth-child(" + a + ") > td:nth-child(" + 3 + ")").text())) {
                return a;
            }
        }
        return 0;
    }

    /**
     * 根据行号列号获取分组表格元素
     *
     * @param tr 行号
     * @param td 列号
     * @return
     */
    public SelenideElement getDataCell(int tr, int td) {
        return $("tbody.ant-table-tbody > tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }
}
