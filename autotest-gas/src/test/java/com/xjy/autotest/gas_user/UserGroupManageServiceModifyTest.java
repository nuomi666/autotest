package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.order.userGroup.UpdUserGroupOrder;
import dal.model.gas_silverbolt.GasUserGroupDO;
import dal.model.gas_user.UserGroupDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/01.
 */
public class UserGroupManageServiceModifyTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceModifyTestSuccess.csv")
    @DisplayName("修改会员分组--成功用例")
    public void userGroupManageServiceModifyTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String name,
            String memo,
            UpdUserGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 准备数据
        userTestBase.insertUserGroup(0L, order.getUserGroupNo(), platPartnerId, name, "FIXED", 0, memo, null, null);
        silverboltTestBase.insertGasUserGroup(0L, order.getUserGroupNo(), platPartnerId, name, "FIXED", memo, null,
                null, null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = userGroupManageService.modify(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserGroupDO> groups = userTestBase.findUserGroupByUserGroupNo(order.getUserGroupNo());
        userGroupAssert(groups.get(0), platPartnerId,
                order.getUserGroupNo(), order.getName(), "FIXED", order.getMemo());
        List<GasUserGroupDO> silverGroups = silverboltTestBase.findGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 清除数据
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceModifyTestFailOne.csv")
    @DisplayName("修改会员分组--参数非法")
    public void userGroupManageServiceModifyTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdUserGroupOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserGroupNo(null);
        }
        if (testId == 1002) {
            order.setName(null);
        }
        if (testId == 1003) {
            order.setUserGroupType(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = userGroupManageService.modify(order);
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
    @AutoTest(file = "gas_user/userGroupManageServiceModifyTestFailTwo.csv")
    @DisplayName("修改会员分组--失败用例")
    public void userGroupManageServiceModifyTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdUserGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = userGroupManageService.modify(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }

    /**
     * 用户分组信息
     */
    private void userGroupAssert(
            UserGroupDO groupInfo,
            String partnerId,
            String groupNo,
            String name,
            String type,
            String memo
    ) {
        assertEquals(partnerId, groupInfo.getPlatPartnerId());
        assertEquals(groupNo, groupInfo.getUserGroupNo());
        assertEquals(name, groupInfo.getName());
        assertEquals(type, groupInfo.getUserGroupType());
        assertEquals(0, groupInfo.getTotalList());
        assertEquals(memo, groupInfo.getMemo());
    }
}
