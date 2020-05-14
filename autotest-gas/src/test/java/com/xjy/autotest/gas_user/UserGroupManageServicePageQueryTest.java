package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.userGroup.PageQueryUserGroupOrder;
import com.xyb.gas.user.api.result.info.UserGroupInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/02.
 */
public class UserGroupManageServicePageQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServicePageQueryTestSuccess.csv")
    @DisplayName("分页查询会员分组--成功用例")
    public void userGroupManageServicePageQueryTestSuccess(
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
            String groupNo3,
            String name,
            String name1,
            String name2,
            String name3,
            String memo,
            String memo1,
            String memo2,
            String memo3,
            String userId,
            String mobileNo,
            PageQueryUserGroupOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId);
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId1);
        userTestBase.cleanUserByUserId(userId);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId1);
        silverboltTestBase.cleanGasUserByUserId(userId);
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2020-02-28");
        Date rawAddTime1 = DateUtils.parseDate("2020-03-01");
        Date rawAddTime2 = DateUtils.parseDate("2020-03-27");
        userTestBase.insertUserGroup(0L, groupNo, platPartnerId, name, "FIXED", 0, memo, rawAddTime, rawAddTime);
        silverboltTestBase.insertGasUserGroup(0L, groupNo, platPartnerId, name, "FIXED", memo, rawAddTime,
                rawAddTime, rawAddTime, rawAddTime);
        userTestBase.insertUserGroup(0L, groupNo1, platPartnerId, name1, "FIXED", 0, memo1, rawAddTime1, rawAddTime1);
        silverboltTestBase.insertGasUserGroup(0L, groupNo1, platPartnerId, name1, "FIXED", memo1, rawAddTime1,
                rawAddTime1, rawAddTime1, rawAddTime1);
        userTestBase.insertUserGroup(0L, groupNo2, platPartnerId, name2, "FIXED", 0, memo2, rawAddTime2, rawAddTime2);
        silverboltTestBase.insertGasUserGroup(0L, groupNo2, platPartnerId, name2, "FIXED", memo2, rawAddTime2,
                rawAddTime2, rawAddTime2, rawAddTime2);
        //干扰数据
        userTestBase.insertUserGroup(0L, groupNo3, platPartnerId1, name3, "FIXED", 0, memo3, rawAddTime2, rawAddTime2);
        silverboltTestBase.insertGasUserGroup(0L, groupNo3, platPartnerId1, name3, "FIXED", memo3, rawAddTime2,
                rawAddTime2, rawAddTime2, rawAddTime2);
        //组员
        userTestBase.insertUser(0L, userId, platPartnerId, platPartnerId, mobileNo, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name, groupNo);
        silverboltTestBase.insertGasUser(0L, userId, platPartnerId, mobileNo, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name, groupNo,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        // 调用接口
        PagedResult<UserGroupInfo> result = userGroupManageService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserGroupInfo> infos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(3, infos.size());
            assertEquals(platPartnerId, infos.get(0).getPlatPartnerId());
            assertEquals(groupNo2, infos.get(0).getUserGroupNo());
            assertEquals(name2, infos.get(0).getName());
            assertEquals(0, infos.get(0).getTotalList());
            assertEquals(memo2, infos.get(0).getMemo());
            assertEquals(rawAddTime2, infos.get(0).getRawUpdateTime());
            assertEquals(null, infos.get(0).getMobile());
            assertEquals(platPartnerId, infos.get(1).getPlatPartnerId());
            assertEquals(groupNo1, infos.get(1).getUserGroupNo());
            assertEquals(name1, infos.get(1).getName());
            assertEquals(0, infos.get(1).getTotalList());
            assertEquals(memo1, infos.get(1).getMemo());
            assertEquals(rawAddTime1, infos.get(1).getRawUpdateTime());
            assertEquals(null, infos.get(1).getMobile());
            assertEquals(platPartnerId, infos.get(2).getPlatPartnerId());
            assertEquals(groupNo, infos.get(2).getUserGroupNo());
            assertEquals(name, infos.get(2).getName());
            assertEquals(1, infos.get(2).getTotalList());
            assertEquals(memo, infos.get(2).getMemo());
            assertEquals(rawAddTime, infos.get(2).getRawUpdateTime());
            assertEquals(null, infos.get(2).getMobile());
        }
        if (testId == 1002 || testId == 1003) {
            assertEquals(1, infos.size());
            assertEquals(platPartnerId, infos.get(0).getPlatPartnerId());
            assertEquals(groupNo, infos.get(0).getUserGroupNo());
            assertEquals(name, infos.get(0).getName());
            assertEquals(1, infos.get(0).getTotalList());
            assertEquals(memo, infos.get(0).getMemo());
            assertEquals(rawAddTime, infos.get(0).getRawUpdateTime());
            assertEquals(null, infos.get(0).getMobile());
        }
        // 清除数据
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId);
        userTestBase.cleanUserGroupByPlatPartnerId(platPartnerId1);
        userTestBase.cleanUserByUserId(userId);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasUserGroupByPlatPartnerId(platPartnerId1);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServicePageQueryTestFailOne.csv")
    @DisplayName("分页查询会员分组--参数非法")
    public void userGroupManageServicePageQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryUserGroupOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<UserGroupInfo> result = userGroupManageService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
