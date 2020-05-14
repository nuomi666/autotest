package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.order.userGroup.QueryUserGroupOrder;
import com.xyb.gas.user.api.result.info.UserGroupInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/04/02.
 */
public class UserGroupManageServiceQueryDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceQueryDetailTestSuccess.csv")
    @DisplayName("查询会员分组详情--成功用例")
    public void userGroupManageServiceQueryDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String groupNo,
            String name,
            String memo,
            QueryUserGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 准备数据
        userTestBase.insertUserGroup(0L, groupNo, platPartnerId, name, "FIXED", 0, memo, null, null);
        silverboltTestBase.insertGasUserGroup(0L, groupNo, platPartnerId, name, "FIXED", memo, null,
                null, null, null);
        // 测试过程
        if (testId == 1002) {
            order.setUserGroupNo(groupNo);
        }
        // 调用接口
        BizResult<UserGroupInfo> result = userGroupManageService.queryDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        UserGroupInfo groupInfo = result.getInfo();
        if (testId == 1002) {
            assertEquals(platPartnerId, groupInfo.getPlatPartnerId());
            assertEquals(groupNo, groupInfo.getUserGroupNo());
            assertEquals(name, groupInfo.getName());
            assertEquals(0, groupInfo.getTotalList());
            assertEquals(memo, groupInfo.getMemo());
            assertEquals(null, groupInfo.getMobile());
        } else {
            assertEquals(null, groupInfo);
        }
        // 清除数据
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceQueryDetailTestFailOne.csv")
    @DisplayName("查询会员分组详情--参数非法")
    public void userGroupManageServiceQueryDetailTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserGroupOrder order
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
        BizResult<UserGroupInfo> result = userGroupManageService.queryDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
