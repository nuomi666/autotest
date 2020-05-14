package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizListResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.order.userGroup.QueryUserGroupByTypeOrder;
import com.xyb.gas.user.api.result.info.UserGroupInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/02.
 */
public class UserGroupManageServiceQueryUserGroupByTypeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceQueryUserGroupByTypeTestSuccess.csv")
    @DisplayName("根据类型查询会员分组--成功用例")
    public void userGroupManageServiceQueryUserGroupByTypeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String platPartnerId1,
            String groupNo,
            String groupNo1,
            String groupNo2,
            String name,
            String name1,
            String name2,
            String memo,
            String memo1,
            String memo2,
            QueryUserGroupByTypeOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId);
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId1);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId1);
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2020-02-28");
        Date rawAddTime1 = DateUtils.parseDate("2020-03-01");
        Date rawAddTime2 = DateUtils.parseDate("2020-03-27");
        userTestBase.insertUserGroup(0L, groupNo, platPartnerId, name, "FIXED", 0, memo, rawAddTime, rawAddTime);
        silverboltTestBase.insertGasUserGroup(0L, groupNo, platPartnerId, name, "FIXED", memo, rawAddTime,
                rawAddTime, rawAddTime, rawAddTime);
        userTestBase.insertUserGroup(0L, groupNo1, platPartnerId1, name1, "FIXED", 0, memo1, rawAddTime1, rawAddTime1);
        silverboltTestBase.insertGasUserGroup(0L, groupNo1, platPartnerId1, name1, "FIXED", memo1, rawAddTime1,
                rawAddTime1, rawAddTime1, rawAddTime1);
        userTestBase.insertUserGroup(0L, groupNo2, platPartnerId, name2, "DYNAMIC", 0, memo2, rawAddTime2, rawAddTime2);
        silverboltTestBase.insertGasUserGroup(0L, groupNo2, platPartnerId, name2, "DYNAMIC", memo2, rawAddTime2,
                rawAddTime2, rawAddTime2, rawAddTime2);
        // 测试过程
        // 调用接口
        BizListResult<UserGroupInfo> result = userGroupManageService.queryUserGroupByType(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserGroupInfo> infos = result.getListInfo();
        if (testId == 1001) {
            assertEquals(1, infos.size());
            assertEquals(platPartnerId1, infos.get(0).getPlatPartnerId());
            assertEquals(groupNo1, infos.get(0).getUserGroupNo());
            assertEquals(name1, infos.get(0).getName());
            assertEquals(0, infos.get(0).getTotalList());
            assertEquals(memo1, infos.get(0).getMemo());
            assertEquals(rawAddTime1, infos.get(0).getRawUpdateTime());
            assertEquals(null, infos.get(0).getMobile());
        }
        if (testId == 1002) {
            assertEquals(1, infos.size());
            assertEquals(platPartnerId, infos.get(0).getPlatPartnerId());
            assertEquals(groupNo2, infos.get(0).getUserGroupNo());
            assertEquals(name2, infos.get(0).getName());
            assertEquals(0, infos.get(0).getTotalList());
            assertEquals(memo2, infos.get(0).getMemo());
            assertEquals(rawAddTime2, infos.get(0).getRawUpdateTime());
            assertEquals(null, infos.get(0).getMobile());
        }
        // 清除数据
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId);
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId1);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId1);
    }
}
