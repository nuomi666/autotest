package com.xjy.autotest.boss.test;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.boss.pages.BossHomePage;
import com.xjy.autotest.boss.pages.BossLoginPage;
import com.xjy.autotest.boss.pages.UserManage;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.user.AccountDO;
import dal.model.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 18/9/3.
 */
public class AddUserWebTest extends WebTestBase {

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 添加平台商
     * 1001 添加签约商
     */

    @AutoTest(file = "boss/addUserWebTestSuccess.csv")
    public void addUserWebTestSuccess(int testId,
                                      String userName,
                                      String password,
                                      UserDO user,
                                      AccountDO account
    ) {
        // 清除数据
        List<UserDO> userDOS = userTestBase.findUserByUserName(user.getUserName());
        for (UserDO userDO : userDOS) {
            userTestBase.cleanAccountByUserId(userDO.getUserId());
        }
        userTestBase.cleanUserByMerchantUserId(user.getMerchantUserId());
        userTestBase.cleanUserByUserName(user.getUserName());
        // 测试准备
        //打开BOSS后台地址
        open(testUrlBoss);
        //登录BOSS
        BossHomePage bossHomePage = new BossLoginPage().login(userName, password);
        // 测试过程
        //注册会员
        UserManage userManage = bossHomePage.home()
                .userManage()
                .userInfo()
                .addUser(user, account);
        // 结果验证
        if ("PLATFORM".equals(user.getUserType())) {
            userManage.queryUser(user.getUserType());
            userManage.getCell(1, 4).shouldHave(text("平台商"));
        }
        if ("PARTNER".equals(user.getUserType())) {
            userManage.getCell(1, 4).shouldHave(text("签约商"));
        }
        userManage.getCell(1, 3).shouldHave(text(user.getRealName()));
        userManage.getCell(1, 5).shouldHave(text("正常"));
        userManage.getCell(1, 8).shouldHave(text(user.getRealName()));
        userManage.getCell(1, 9).shouldHave(text(user.getMemo()));
        // 数据验证
        //user表数据
        UserDO userDO = userTestBase.findUserByUserName(user.getUserName()).get(0);
        user.setUserId(userDO.getUserId());
        user.setPartnerId(userDO.getUserId());
        user.setPlatPartnerId(userDO.getPlatPartnerId());
        userTestBase.assertUser(user, userDO);
        //account表数据
        AccountDO accountDO = userTestBase.findAccountByUserId(userDO.getUserId()).get(0);
        account.setUserId(userDO.getUserId());
        account.setAccountNo(accountDO.getAccountNo());
        userTestBase.assertAccount(account, accountDO);
        userManage.getCell(1, 2).shouldHave(text(userDO.getUserId()));
        // 清除数据
        userTestBase.cleanAccountByUserId(userDO.getUserId());
        userTestBase.cleanUserByUserId(userDO.getUserId());
    }
}
