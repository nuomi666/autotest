package com.xjy.autotest.gas.test.user;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.user.UserGroupManagePage;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserGroupDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/18.
 */
public class UserGroupManageWebTest extends WebTestBase {

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_userTestBase gasUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @AutoTest(file = "gas/UserGroupManageTestSuccess.csv")
    @DisplayName("会员分组--成功用例")
    public void UserGroupManageTestSuccess(
            int testId,
            String username,
            String password,
            String platPartnerId,
            String userId,
            String userId1,
            String nickName,
            String nickName1,
            String groupName,
            String groupNamexx,
            String mobile,
            String mobile1,
            String mobile2,
            String memo,
            String memoxx,
            String type,
            String fileName) {
        //清除数据
        gasUserTestBase.cleanUserByMobile(mobile);
        gasUserTestBase.cleanUserByMobile(mobile1);
        gasUserTestBase.cleanUserByMobile(mobile2);
        gasUserTestBase.cleanUserGroupByName(groupName);
        gasUserTestBase.cleanUserGroupByName(groupNamexx);
        silverboltTestBase.cleanGasUserByMobile(mobile);
        silverboltTestBase.cleanGasUserByMobile(mobile1);
        silverboltTestBase.cleanGasUserByMobile(mobile2);
        silverboltTestBase.cleanGasUserGroupByName(groupName);
        silverboltTestBase.cleanGasUserGroupByName(groupNamexx);
        //准备数据
        gasUserInitDataBase.initGasUserOnly(platPartnerId, userId, null, nickName, mobile, "AUTONOMY_GENERALIZE",
                null, null, null, null, null, null);
        gasUserInitDataBase.initGasUserOnly(platPartnerId, userId1, null, nickName1, mobile1, "AUTONOMY_GENERALIZE",
                null, null, null, null, null, null);
        List<String> mobiles = new ArrayList<>();
        List<String> moveMobiles = new ArrayList<>();
        mobiles.add(mobile);
        mobiles.add(mobile1);
        if (testId == 1002) {
            moveMobiles.add(mobile2);
        }
        //打开加好油中台页面
        open(testUrlGas);
        //新增分组
        UserGroupManagePage userGroupManagePage = new GasLoginPage()
                .login(username, password)
                .userCenter()
                .userGroupManage()
                .createUserGroup(groupName, memo);
        //数据验证
        userGroupManagePage.checkGroupData(groupName, 0, memo);
        //数据库数据验证
        List<UserGroupDO> gasUserGroups = gasUserTestBase.findUserGroupByName(groupName);
        assertEquals(1, gasUserGroups.size());
        assertEquals(platPartnerId, gasUserGroups.get(0).getPlatPartnerId());
        assertEquals(groupName, gasUserGroups.get(0).getName());
        assertEquals(0, gasUserGroups.get(0).getTotalList());
        assertEquals("FIXED", gasUserGroups.get(0).getUserGroupType());
        //添加成员(注：为了方便校验，批量导入的手机号跟mobiles的手机号一样)
        userGroupManagePage.addUser(groupName, type, fileName, mobiles, moveMobiles);
        userGroupManagePage.checkGroupData(groupName, mobiles.size(), memo);
        //成员校验
        for (String phone : mobiles) {
            List<UserDO> gasUsers = gasUserTestBase.findUserByMobile(phone);
//            List<GasUserDO> silverUsers = silverboltTestBase.findGasUserByMobile(phone);需要久睡才能保证数据同步完成
            assertEquals(groupName, gasUsers.get(0).getGroupName());
            assertEquals(gasUserGroups.get(0).getUserGroupNo(), gasUsers.get(0).getGroupCode());
//            assertEquals(groupName, silverUsers.get(0).getGroupName());
//            assertEquals(gasUserGroups.get(0).getUserGroupNo(), silverUsers.get(0).getGroupCode());
        }
        //编辑
        userGroupManagePage.updUserGroup(groupName, groupNamexx, memoxx);
        userGroupManagePage.checkGroupData(groupNamexx, mobiles.size(), memoxx);
        List<UserGroupDO> gasUserGroups2 =
                gasUserTestBase.findUserGroupByUserGroupNo(gasUserGroups.get(0).getUserGroupNo());
        assertEquals(groupNamexx, gasUserGroups2.get(0).getName());
        assertEquals(memoxx, gasUserGroups2.get(0).getMemo());
        //删除
        userGroupManagePage.delUserGroup(groupNamexx);
        List<UserGroupDO> gasUserGroups3 =
                gasUserTestBase.findUserGroupByUserGroupNo(gasUserGroups.get(0).getUserGroupNo());
        assertEquals(0, gasUserGroups3.size());
        for (String phone : mobiles) {
            List<UserDO> gasUsers = gasUserTestBase.findUserByMobile(phone);
//            List<GasUserDO> silverUsers = silverboltTestBase.findGasUserByMobile(phone);
            assertEquals(null, gasUsers.get(0).getGroupName());
//            assertEquals(null, silverUsers.get(0).getGroupName());
        }
        //清楚数据
        gasUserTestBase.cleanUserByUserId(userId);
        gasUserTestBase.cleanUserByUserId(userId1);
        gasUserTestBase.cleanUserByMobile(mobile2);
        gasUserTestBase.cleanUserGroupByUserGroupNo(gasUserGroups.get(0).getUserGroupNo());
        xybUserTestBase.cleanUserByMobile(mobile);
        xybUserTestBase.cleanUserByMobile(mobile1);
        xybUserTestBase.cleanUserByMobile(mobile2);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByMobile(mobile2);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(gasUserGroups.get(0).getUserGroupNo());
    }
}
