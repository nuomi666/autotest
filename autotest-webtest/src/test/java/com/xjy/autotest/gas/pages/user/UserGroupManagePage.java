package com.xjy.autotest.gas.pages.user;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/18.
 */
public class UserGroupManagePage {

    /**
     * 创建分组
     *
     * @param groupName
     * @param memo
     * @return
     */
    public UserGroupManagePage createUserGroup(String groupName, String memo) {
        $(byLinkText("创建分组")).click();
        //分组名
        $("#name").setValue(groupName);
        //分组说明
        $("#memo").setValue(memo);
        //保存
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    /**
     * 修改分组
     *
     * @param groupName
     * @param groupNamexx
     * @param memo
     * @return
     */
    public UserGroupManagePage updUserGroup(String groupName, String groupNamexx, String memo) {
        $(byLinkText("会员管理")).click();
        $(byText("会员分组")).click();
        $(byLinkText("编辑"), getGroupTr(groupName) - 1).click();
        //分组名
        $("#name").setValue(groupNamexx);
        //分组说明
        $("#memo").setValue(memo);
        //保存
        $("button[type=\"submit\"]").click();
        sleep(2000);
        return this;
    }

    /**
     * 删除分组
     *
     * @param groupName
     * @return
     */
    public UserGroupManagePage delUserGroup(String groupName) {
        $(byLinkText("会员管理")).click();
        $(byText("会员分组")).click();
        $(byLinkText("删除"), getGroupTr(groupName) - 1).click();
        //确定
        $("button.ant-btn.ant-btn-primary.ant-btn-sm").click();
        sleep(1000);
        return this;
    }

    /**
     * 添加成员
     * 手动添加时，手机号列表不能为空，文件名为空
     * 批量导入时，导入的文件名不能为空，手机号列表为空
     *
     * @param groupName
     * @param fileName
     * @param type
     * @param mobiles
     * @return
     */
    public UserGroupManagePage addUser(String groupName, String type, String fileName, List<String> mobiles,
                                       List<String> moveMobiles) {
        $(byLinkText("会员管理")).click();
        $(byText("会员分组")).click();
        $(byLinkText("管理"), getGroupTr(groupName) - 1).click();
        //添加成员
        $(byValue(type)).parent().click();
        if ("manual".equals(type)) {//手动添加
            int i = 0;
            for (String mobile : mobiles) {
                $(".ant-btn.ant-btn-dashed").click();
                $(".ant-input", i).setValue(mobile);
                i++;
            }
        }
        if ("batch".equals(type)) {//批量导入
//            $(".ant-btn.ant-btn-dashed").click();
            $("input[type=\"file\"]").uploadFromClasspath("autotest/gas/" + fileName);
        }
        //保存
        $("button[type=\"submit\"]").click();
        sleep(2000);
        //移除成员
        if (moveMobiles.size() > 0) {
            for (String mobile : moveMobiles) {
                $(byLinkText("移除分组"), getUserTr(mobile) - 1).click();
                $("button.ant-btn.ant-btn-primary.ant-btn-sm").click();
            }
        }
        return this;
    }

    public UserGroupManagePage updateUserGroup(String groupName, String newName, String memo, String type,
                                               List<String> addMobiles, List<String> moveMobiles) {
        //编辑指定分组
        $(By.linkText("编辑"), getGroupTr(groupName) - 1).click();
        //分组名
        $("#name").setValue(newName);
        //分组说明
        $("#memo").setValue(memo);
        //添加成员
        $("input[value=\"" + type + "\"]").parent().click();
        if ("manual".equals(type)) {//手动添加
            int i = 0;
            for (String mobile : addMobiles) {
                $(".ant-btn.ant-btn-dashed").click();
                $(byId("phoneNo-" + String.valueOf(i))).setValue(mobile);
                i++;
            }
        }
        if ("batch".equals(type)) {//批量导入
            $(".ant-btn.ant-btn-dashed").click();
        }
        //移除成员
        if (moveMobiles.size() > 0) {
        }
        //保存
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 验证分组信息是否正确
     *
     * @param groupName
     * @param num
     * @param memo
     */
    public void checkGroupData(String groupName, int num, String memo) {
        //重新进入会员分组管理页面，刷新
        $(byLinkText("会员管理")).click();
        $(byText("会员分组")).click();
        int tr = getGroupTr(groupName);
        getDataCell(tr, 1).shouldHave(text(groupName));
        getDataCell(tr, 2).shouldHave(text(String.valueOf(num)));
        getDataCell(tr, 3).shouldHave(text(memo));
    }

    /**
     * 根据分组名获取所在行号
     *
     * @param groupName
     * @return
     */
    public int getGroupTr(String groupName) {
        for (int a = 1; a < 10; a++) {
            if (groupName.equals($("tbody.ant-table-tbody", 1).$("tr:nth-child(" + a + ") > td:nth-child(" + 1 + ")").text())) {
                return a;
            }
        }
        return 0;
    }

    /**
     * 根据手机号获取成员所在行号
     *
     * @param mobile
     * @return
     */
    public int getUserTr(String mobile) {
        for (int a = 1; a < 10; a++) {
            if (mobile.equals($("tbody.ant-table-tbody > tr:nth-child(" + a + ") > td:nth-child(" + 2 + ")").text())) {
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
        return $("tbody.ant-table-tbody", 1).$("tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }

}
