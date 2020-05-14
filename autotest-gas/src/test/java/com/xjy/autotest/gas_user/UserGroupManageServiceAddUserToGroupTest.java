package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.userGroup.AddUserToGroupOrder;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/01.
 */
public class UserGroupManageServiceAddUserToGroupTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceAddUserToGroupTestSuccess.csv")
    @DisplayName("添加会员到分组--成功用例")
    public void userGroupManageServiceAddUserToGroupTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String groupCode,
            String name,
            String name1,
            String userId,
            String userId1,
            String mobileNo,
            String mobileNo1,
            AddUserToGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupCode());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupCode());
        // 准备数据
        userTestBase.insertUserGroup(0L, order.getUserGroupCode(), platPartnerId, name, "FIXED", 0, null, null, null);
        silverboltTestBase.insertGasUserGroup(0L, order.getUserGroupCode(), platPartnerId, name, "FIXED", null, null,
                null, null, null);
        userTestBase.insertUser(0L, userId, platPartnerId, platPartnerId, mobileNo, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", null, null);
        silverboltTestBase.insertGasUser(0L, userId, platPartnerId, mobileNo, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null, null,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        userTestBase.insertUser(0L, userId1, platPartnerId, platPartnerId, mobileNo1, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name1, groupCode);
        silverboltTestBase.insertGasUser(0L, userId1, platPartnerId, mobileNo1, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name1, groupCode,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        List<String> userIdList = new ArrayList<String>();
        userIdList.add(userId);
        if (testId == 1002) {
            userIdList.add(userId1);
        }
        order.setUserIdList(userIdList);
        // 调用接口
        SimpleResult result = userGroupManageService.addUserToGroup(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        sleep(3);
        UserDO user = userTestBase.findUserByMobile(mobileNo).get(0);
        assertEquals(name, user.getGroupName());
        assertEquals(order.getUserGroupCode(), user.getGroupCode());
        GasUserDO gasUser = silverboltTestBase.findGasUserByMobile(mobileNo).get(0);
        assertEquals(name, gasUser.getGroupName());
        assertEquals(order.getUserGroupCode(), gasUser.getGroupCode());
        if (testId == 1002) {
            UserDO user1 = userTestBase.findUserByMobile(mobileNo1).get(0);
            assertEquals(name, user1.getGroupName());
            assertEquals(order.getUserGroupCode(), user1.getGroupCode());
            GasUserDO gasUser1 = silverboltTestBase.findGasUserByMobile(mobileNo1).get(0);
            assertEquals(name, gasUser1.getGroupName());
            assertEquals(order.getUserGroupCode(), gasUser1.getGroupCode());
        }
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupCode());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupCode());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceAddUserToGroupTestFailOne.csv")
    @DisplayName("添加会员到分组--参数非法")
    public void userGroupManageServiceAddUserToGroupTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String userId,
            AddUserToGroupOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> userIdList = new ArrayList<String>();
        if (testId != 1003) {
            userIdList.add(userId);
        }
        order.setUserIdList(userIdList);
        if (testId == 1001) {
            order.setUserGroupCode(null);
        }
        if (testId == 1002) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userGroupManageService.addUserToGroup(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceAddUserToGroupTestFailTwo.csv")
    @DisplayName("添加会员到分组--失败用例")
    public void userGroupManageServiceAddUserToGroupTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String userId,
            AddUserToGroupOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> userIdList = new ArrayList<String>();
        userIdList.add(userId);
        order.setUserIdList(userIdList);
        // 调用接口
        SimpleResult result = userGroupManageService.addUserToGroup(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
