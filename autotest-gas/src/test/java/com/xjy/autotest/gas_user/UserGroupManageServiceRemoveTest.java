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
import com.xyb.gas.user.api.order.userGroup.RemoveUserGroupOrder;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_silverbolt.GasUserGroupDO;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserGroupDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/02.
 */
public class UserGroupManageServiceRemoveTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceRemoveTestSuccess.csv")
    @DisplayName("删除会员分组--成功用例")
    public void userGroupManageServiceRemoveTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String name,
            String userId,
            String mobileNo,
            RemoveUserGroupOrder order
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
        userTestBase.insertUser(0L, userId, platPartnerId, platPartnerId, mobileNo, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name, order.getUserGroupNo());
        silverboltTestBase.insertGasUser(0L, userId, platPartnerId, mobileNo, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name, order.getUserGroupNo(),
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userGroupManageService.remove(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        sleep(3);
        List<UserGroupDO> userGroups = userTestBase.findUserGroupByUserGroupNo(order.getUserGroupNo());
        assertEquals(0, userGroups.size());
        List<GasUserGroupDO> gasUserGroups = silverboltTestBase.findGasUserGroupByUserGroupNo(order.getUserGroupNo());
        assertEquals(0, gasUserGroups.size());
        UserDO user = userTestBase.findUserByMobile(mobileNo).get(0);
        assertEquals(null, user.getGroupName());
        assertEquals(null, user.getGroupCode());
        GasUserDO gasUser = silverboltTestBase.findGasUserByMobile(mobileNo).get(0);
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
    @AutoTest(file = "gas_user/userGroupManageServiceRemoveTestFailOne.csv")
    @DisplayName("删除会员分组--参数非法")
    public void userGroupManageServiceRemoveTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RemoveUserGroupOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserGroupNo(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userGroupManageService.remove(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
