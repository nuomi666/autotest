package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.order.userGroup.AddUserGroupOrder;
import dal.model.gas_silverbolt.GasUserGroupDO;
import dal.model.gas_user.UserGroupDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/01.
 */
public class UserGroupManageServiceAddTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceAddTestSuccess.csv")
    @DisplayName("添加会员分组--成功用例")
    public void userGroupManageServiceAddTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddUserGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserGroupByName(order.getName());
        silverboltTestBase.cleanGasUserGroupByName(order.getName());
        // 准备数据
        // 测试过程
        // 调用接口
        SimpleResult result = userGroupManageService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserGroupDO> groups = userTestBase.findUserGroupByName(order.getName());
        userGroupAssert(groups.get(0), order.getPlatPartnerId(),
                null, order.getName(), "FIXED", order.getMemo());
        List<GasUserGroupDO> silverGroups = silverboltTestBase.findGasUserGroupByName(order.getName());
        // 清除数据
        userTestBase.cleanUserGroupByName(order.getName());
        silverboltTestBase.cleanGasUserGroupByName(order.getName());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceAddTestFailOne.csv")
    @DisplayName("添加会员分组--参数非法")
    public void userGroupManageServiceAddTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddUserGroupOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
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
        SimpleResult result = userGroupManageService.add(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
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
//        assertEquals(groupNo, groupInfo.getUserGroupNo());
        assertEquals(name, groupInfo.getName());
        assertEquals(type, groupInfo.getUserGroupType());
        assertEquals(0, groupInfo.getTotalList());
        assertEquals(memo, groupInfo.getMemo());
    }
}
