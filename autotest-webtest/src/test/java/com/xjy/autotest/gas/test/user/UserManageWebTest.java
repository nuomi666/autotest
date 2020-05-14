package com.xjy.autotest.gas.test.user;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.user.UserManagePage;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/30.
 */
public class UserManageWebTest extends WebTestBase {

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_userTestBase gasUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @AutoTest(file = "gas/userManageWebTestSuccess.csv")
    @DisplayName("会员分组--成功用例")
    public void userManageWebTestSuccess(
            int testId,
            String username,
            String password,
            String platPartnerId,
            String userId,
            String userId1,
            String userId2,
            String nickName,
            String nickName1,
            String groupCode,
            String groupCodexx,
            String groupName,
            String groupNamexx,
            String mobile,
            String mobile1,
            String mobile2) {
        //清除数据
        gasUserTestBase.cleanUserByUserId(userId);
        gasUserTestBase.cleanUserByUserId(userId1);
        gasUserTestBase.cleanUserByUserId(userId2);
        gasUserTestBase.cleanUserGroupByUserGroupNo(groupCode);
        gasUserTestBase.cleanUserGroupByUserGroupNo(groupCodexx);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByUserId(userId2);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(groupCode);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(groupCodexx);
        //准备数据
        gasUserInitDataBase.initGasUserOnly(platPartnerId, userId, null, nickName, mobile, "AUTONOMY_GENERALIZE",
                null, null, null, null, null, null);
        gasUserInitDataBase.initGasUserOnly(platPartnerId, userId1, null, nickName1, mobile1, "AUTONOMY_GENERALIZE",
                null, null, null, null, null, null);
        gasUserInitDataBase.initGasUserOnly(platPartnerId, userId2, null, null, mobile2, "AUTONOMY_GENERALIZE",
                null, null, null, null, null, null);
        UserDO userDO1 = gasUserTestBase.findUserByUserId(userId).get(0);
        GasUserDO userDO2 = silverboltTestBase.findGasUserByUserId(userId).get(0);
        //分组
        gasUserTestBase.insertUserGroup(0L, groupCode, platPartnerId, groupName, "FIXED", 0,
                null, null, null);
        silverboltTestBase.insertGasUserGroup(0L, groupCode, platPartnerId, groupName, "FIXED",
                null, null, null, null, null);
        gasUserTestBase.insertUserGroup(0L, groupCodexx, platPartnerId, groupNamexx, "FIXED", 0,
                null, null, null);
        silverboltTestBase.insertGasUserGroup(0L, groupCodexx, platPartnerId, groupNamexx, "FIXED",
                null, null, null, null, null);
        //设置分组
        userDO1.setGroupName(groupName);
        userDO1.setGroupCode(groupCode);
        userDO2.setGroupName(groupName);
        userDO2.setGroupCode(groupCode);
        if (testId == 1002) {
            gasUserTestBase.updateUserByUserId(userId, userDO1);
            silverboltTestBase.updateGasUserByUserId(userId, userDO2);
        }
        List<String> mobiles = new ArrayList<>();
        mobiles.add(mobile);
        mobiles.add(mobile1);
        //打开加好油中台页面
        open(testUrlGas);
        //新增分组
        UserManagePage userGroupManagePage = new GasLoginPage()
                .login(username, password)
                .userCenter()
                .userManage()
                .addGroupMember(mobiles, groupNamexx);
        //数据验证
        userGroupManagePage.checkUserData(mobile, nickName, "其他", "", "普通会员",
                0, 0, groupNamexx, "自主注册", "");
        //数据库数据验证
        List<UserDO> gasUsers = gasUserTestBase.findUserByUserId(userId);
        assertEquals(groupCodexx, gasUsers.get(0).getGroupCode());
        assertEquals(groupNamexx, gasUsers.get(0).getGroupName());
        List<UserDO> gasUsers1 = gasUserTestBase.findUserByUserId(userId1);
        assertEquals(groupCodexx, gasUsers1.get(0).getGroupCode());
        assertEquals(groupNamexx, gasUsers1.get(0).getGroupName());
//        List<GasUserDO> silverUsers=silverboltTestBase.findGasUserByUserId(userId);
//        assertEquals(groupCodexx, silverUsers.get(0).getGroupCode());
//        assertEquals(groupNamexx,  silverUsers.get(0).getGroupName());
//        List<GasUserDO> silverUsers1=silverboltTestBase.findGasUserByUserId(userId1);
//        assertEquals(groupCodexx, silverUsers1.get(0).getGroupCode());
//        assertEquals(groupNamexx,  silverUsers1.get(0).getGroupName());
        //添加成员(注：为了方便校验，批量导入的手机号跟mobiles的手机号一样)
        //清楚数据
        gasUserTestBase.cleanUserByUserId(userId);
        gasUserTestBase.cleanUserByUserId(userId1);
        gasUserTestBase.cleanUserByUserId(userId2);
        gasUserTestBase.cleanUserGroupByUserGroupNo(groupCode);
        gasUserTestBase.cleanUserGroupByUserGroupNo(groupCodexx);
        xybUserTestBase.cleanUserByMobile(mobile);
        xybUserTestBase.cleanUserByMobile(mobile1);
        xybUserTestBase.cleanUserByMobile(mobile2);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(userId2);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByUserId(userId2);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(groupCode);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(groupCodexx);
    }
}
