package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.userGroup.PageQueryFixedUserOrder;
import com.xyb.gas.user.api.result.info.UserGroupListInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/02.
 */
public class UserGroupManageServicePageQueryFixedUserTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServicePageQueryFixedUserTestSuccess.csv")
    @DisplayName("分页查询固定分组内的会员名单--成功用例")
    public void userGroupManageServicePageQueryFixedUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String groupNo,
            String name,
            String name1,
            String userId,
            String userId1,
            String userId2,
            String userId3,
            String mobileNo,
            String mobileNo1,
            String mobileNo2,
            String mobileNo3,
            PageQueryFixedUserOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserByUserId(userId2);
        userTestBase.cleanUserByUserId(userId3);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByUserId(userId2);
        silverboltTestBase.cleanGasUserByUserId(userId3);
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
        userTestBase.insertUser(0L, userId1, platPartnerId, platPartnerId, mobileNo1, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name, order.getUserGroupNo());
        silverboltTestBase.insertGasUser(0L, userId1, platPartnerId, mobileNo1, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name, order.getUserGroupNo(),
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        userTestBase.insertUser(0L, userId2, platPartnerId, platPartnerId, mobileNo2, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name, order.getUserGroupNo());
        silverboltTestBase.insertGasUser(0L, userId2, platPartnerId, mobileNo2, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name, order.getUserGroupNo(),
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        //干扰数据
        userTestBase.insertUser(0L, userId3, platPartnerId, platPartnerId, mobileNo3, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name1, groupNo);
        silverboltTestBase.insertGasUser(0L, userId3, platPartnerId, mobileNo3, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name1, groupNo,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        // 调用接口
        PagedResult<UserGroupListInfo> result = userGroupManageService.pageQueryFixedUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(3, result.getInfoList().size());
            List<String> userIds = new ArrayList<>();
            List<String> mobiles = new ArrayList<>();
            for (UserGroupListInfo userInfo : result.getInfoList()) {
                assertEquals(order.getUserGroupNo(), userInfo.getUserGroupNo());
                assertEquals(null, userInfo.getRealName());
                userIds.add(userInfo.getUserId());
                mobiles.add(userInfo.getSymbolNo());
            }
            assertTrue(userIds.contains(userId));
            assertTrue(userIds.contains(userId1));
            assertTrue(userIds.contains(userId2));
            assertTrue(mobiles.contains(mobileNo));
            assertTrue(mobiles.contains(mobileNo1));
            assertTrue(mobiles.contains(mobileNo2));
        }
        if (testId == 1002 || testId == 1003) {
            assertEquals(1, result.getInfoList().size());
            for (UserGroupListInfo userInfo : result.getInfoList()) {
                assertEquals(order.getUserGroupNo(), userInfo.getUserGroupNo());
                assertEquals(mobileNo2, userInfo.getSymbolNo());
                assertEquals(userId2, userInfo.getUserId());
                assertEquals(null, userInfo.getRealName());
            }
        }
        // 清除数据
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserByUserId(userId2);
        userTestBase.cleanUserByUserId(userId3);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByUserId(userId2);
        silverboltTestBase.cleanGasUserByUserId(userId3);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServicePageQueryFixedUserTestFailOne.csv")
    @DisplayName("分页查询固定分组内的会员名单--参数非法")
    public void userGroupManageServicePageQueryFixedUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryFixedUserOrder order
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
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        PagedResult<UserGroupListInfo> result = userGroupManageService.pageQueryFixedUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}
