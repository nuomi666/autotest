package com.xjy.autotest.gas.pages.station;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.StringUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class StationOwnerManagerPage {
    /**
     * @param realname    站长姓名
     * @param stationuser 账号
     * @param stationpwd  密码
     * @param phone       手机号码
     * @param stationName 油站名称
     * @param roleName    角色名称
     */

    public StationOwnerManagerPage addStationOwner(
            String realname,
            String stationuser,
            String stationpwd,
            String phone,
            String stationName,
            String roleName
    ) {
        //点击"新增"
        $(byLinkText("新增")).click();
        //输入站长姓名、账号、密码信息
        $(byId("userName")).setValue(realname);
        $(byId("account")).setValue(stationuser);
        $(byId("password")).setValue(stationpwd);
        $(byId("mobileNo")).setValue(phone);

        //点击油站下拉框按钮，显示油站信息
        $(byId("stationId")).click();
        //选择油站
        $(byText(stationName)).click();
        //选择用户角色下拉按钮，显示角色信息
        $(byId("roleNo")).click();
        //选择用户角色
        $(byText(roleName)).click();

        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        return this;
    }

    public StationOwnerManagerPage editMerchantUser(
            String account,
            String realname,
            String stationpwd,
            String phone,
            String stationName,
            String roleName
    ) {
        //重新进入员工管理页面，刷新刚刚新增的员工信息
        $(byLinkText("员工管理")).click();
        //通过账号搜索
        int Lno = getStationuserTr(account);
        $(byLinkText("编辑"), Lno - 1).click();
        //输入站长姓名、账号、密码信息
        if (StringUtils.isNotBlank(realname)) {
            $(byId("userName")).setValue(realname);
        }
        if (StringUtils.isNotBlank(stationpwd)) {
            $(byId("password")).setValue(stationpwd);
        }
        if (StringUtils.isNotBlank(phone)) {
            $(byId("mobileNo")).setValue(phone);
        }

        //点击油站下拉框按钮，显示油站信息
        $(byId("stationId")).click();
        //选择油站
        $(byText(stationName)).click();
        //选择用户角色下拉按钮，显示角色信息
        $(byId("roleNo")).click();
        //选择用户角色
        $(byText(roleName)).click();

        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        return this;
    }

    //根据站长账号获取元素行号
    public int getStationuserTr(String stationuser) {
        for (int i = 1; i < 10; i++) {
            if (stationuser.equals($("tbody.ant-table-tbody > tr:nth-child(" + i + ") > td:nth-child(" + 1 + ")").text())) {
                return i;
            }
        }
        return 0;
    }

    public void checkData(String stationuser, String realname, String phone, String stationName) {
        int Lno = getStationuserTr(stationuser);
        getDataCell(Lno, 1).shouldHave(text(stationuser));
        getDataCell(Lno, 2).shouldHave(text(realname));
        getDataCell(Lno, 3).shouldHave(text(phone));
        getDataCell(Lno, 4).shouldHave(text(stationName));
    }

    /**
     * 根据行号、列表获取元素
     *
     * @param Lno 行号
     * @param Cno 列号
     */
    public SelenideElement getDataCell(int Lno, int Cno) {
        return $("tbody.ant-table-tbody > tr:nth-child(" + Lno + ") > td:nth-child(" + Cno + ")");
    }
}
