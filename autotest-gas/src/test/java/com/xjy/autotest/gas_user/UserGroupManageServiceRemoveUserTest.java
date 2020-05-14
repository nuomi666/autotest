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
import com.xyb.gas.user.api.order.userGroup.RemoveUserFromGroupOrder;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/04/01.
 */
public class UserGroupManageServiceRemoveUserTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceRemoveUserTestSuccess.csv")
    @DisplayName("移除会员名单--成功用例")
    public void userGroupManageServiceRemoveUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String name,
            String userId,
            RemoveUserFromGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 准备数据
        userTestBase.insertUserGroup(0L, order.getUserGroupNo(), platPartnerId, name, "FIXED", 0, null, null, null);
        silverboltTestBase.insertGasUserGroup(0L, order.getUserGroupNo(), platPartnerId, name, "FIXED", null, null,
                null, null, null);
        userTestBase.insertUser(0L, userId, platPartnerId, platPartnerId, order.getMobileNo(), null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name, order.getUserGroupNo());
        silverboltTestBase.insertGasUser(0L, userId, platPartnerId, order.getMobileNo(), null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name, order.getUserGroupNo(),
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userGroupManageService.removeUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        sleep(3);
        UserDO user = userTestBase.findUserByUserId(userId).get(0);
        assertEquals(null, user.getGroupName());
        assertEquals(null, user.getGroupCode());
        GasUserDO gasUser = silverboltTestBase.findGasUserByUserId(userId).get(0);
        assertEquals(null, gasUser.getGroupName());
        assertEquals(null, gasUser.getGroupCode());
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceRemoveUserTestFailOne.csv")
    @DisplayName("移除会员名单--参数非法")
    public void userGroupManageServiceRemoveUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RemoveUserFromGroupOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserGroupNo(null);
        }
        if (testId == 1002) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1003) {
            order.setMobileNo(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userGroupManageService.removeUser(order);
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
    @AutoTest(file = "gas_user/userGroupManageServiceRemoveUserTestFailTwo.csv")
    @DisplayName("移除会员名单--失败用例")
    public void userGroupManageServiceRemoveUserTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String userId,
            RemoveUserFromGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 准备数据
        userTestBase.insertUser(0L, userId, platPartnerId, platPartnerId, order.getMobileNo(), null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", null, null);
        silverboltTestBase.insertGasUser(0L, userId, platPartnerId, order.getMobileNo(), null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null, null,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userGroupManageService.removeUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }
}
