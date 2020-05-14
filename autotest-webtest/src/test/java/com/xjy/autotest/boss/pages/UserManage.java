package com.xjy.autotest.boss.pages;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.StringUtils;
import dal.model.user.AccountDO;
import dal.model.user.UserDO;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author ychaoyang
 * Created on 18/9/3.
 */
public class UserManage {

    /**
     * 注册会员
     */
    public UserManage addUser(UserDO user, AccountDO account) {
        switchTo().activeElement();
        switchTo().frame($("iframe[src=\"/user\"]"));
        $(".fa.fa-plus").click();
        switchTo().frame($("iframe[src=\"/user/user_add\"]"));
        $(By.id("userType")).selectOptionByValue(user.getUserType());
        $(By.id("realName")).setValue(user.getRealName());
        $("input[placeholder=\"父级商户\"]").setValue("怀仁");
        sleep(500);
        $(By.id("parentUserId")).selectOptionByValue(user.getParentUserId());
        $("input[placeholder=\"平台商户\"]").setValue("怀仁");
        sleep(500);
        $(By.id("platPartnerId")).selectOptionByValue(user.getPlatPartnerId());
        $(By.id("userStatus")).selectOptionByValue(user.getUserStatus());
        $(By.id("userName")).setValue(user.getUserName());
        $(By.id("registerFrom")).selectOptionByValue(user.getRegisterFrom());
        $(By.id("mobile")).setValue(user.getMobile());
        $(By.id("memo")).setValue(user.getMemo());
        //if (!"PARTNER".equals(user.getUserType())) {
        //    $(By.id("merchantUserId")).setValue(user.getMerchantUserId());
        //    //$("#partnerId").selectOptionByValue(user.getPartnerId());
        //    $("div.combo-arrow").click();
        //    $("li[data-value=\"" + user.getPartnerId() + "\"]").click();
        //}
        $(By.id("certifyStatus")).selectOptionByValue(user.getCertifyStatus());
        $(By.id("certType")).selectOptionByValue(user.getCertType());
        $(By.id("certNo")).setValue(user.getCertNo());
        $(By.id("country")).setValue(user.getCountry());
        $(By.id("province")).setValue(user.getProvince());
        $(By.id("city")).setValue(user.getCity());
        $(By.id("district")).setValue(user.getDistrict());
        $(By.id("address")).setValue(user.getAddress());
        $(By.id("phone")).setValue(user.getPhone());
        $(By.id("zipCode")).setValue(user.getZipCode());
        //$(By.id("accountType")).selectOptionByValue(account.getAccountType());
        //$(By.id("tag")).setValue(account.getTag());
        $(By.id("ensure")).click();
        sleep(2000);
        return this;
    }

    public UserManage queryUser(String value) {
        switchTo().defaultContent();
        switchTo().frame(1);
        $(By.id("userType")).selectOptionByValue(value);
        sleep(1000);
        return this;
    }


    /**
     * 查询会员
     */
    public UserManage query(String userId, String merchantUserId, String userName, String realName, String mobile) {
        switchTo().defaultContent();
        switchTo().frame(1);
        if (StringUtils.isNotBlank(userId)) {
            $("#userId").setValue(userId);
        }
        if (StringUtils.isNotBlank(merchantUserId)) {
            $("#merchantUserId").setValue(merchantUserId);
        }
        if (StringUtils.isNotBlank(userName)) {
            $("#userName").setValue(userName);
        }
        if (StringUtils.isNotBlank(realName)) {
            $("#realName").setValue(realName);
        }
        if (StringUtils.isNotBlank(mobile)) {
            $("#mobile").setValue(mobile);
        }
        $("i.fa.fa-search").click();
        return this;
    }

    /**
     * table表格
     */
    public SelenideElement getCell(int tr, int td) {
        switchTo().defaultContent();
        switchTo().frame(1);
        return $("#UserTable > tbody > tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }

}
