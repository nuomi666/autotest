package com.xjy.autotest.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.user.UserInfo;
import com.xyb.user.api.info.user.UserQueryResult;
import com.xyb.user.api.order.user.QueryCardByUserOrder;
import com.xyb.user.api.service.user.QueryUserService;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author huairen
 * Created on 2019/10/23.
 */
public class QueryUserServiceQueryPartnerByParentUserIdTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    QueryUserService queryUserService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001 查询父级用户对应签约商信息
     */
    @AutoTest(file = "user/queryUserServiceQueryPartnerByParentUserIdTestSuccess.csv")
    @DisplayName("查询父级用户对应签约商信息--成功用例")
    public void queryUserServiceQueryPartnerByParentUserIdTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCardByUserOrder queryCardByUserOrder,
            UserDO userDO,
            UserDO userDO1,
            UserDO userDO2
    ) {
        // 清除数据
        userTestBase.cleanUserByUserId(userDO.getUserId());
        userTestBase.cleanUserByUserId(userDO1.getUserId());
        userTestBase.cleanUserByUserId(userDO2.getUserId());
        // 准备数据
        userTestBase.insertUser(userDO);
        userTestBase.insertUser(userDO1);
        userTestBase.insertUser(userDO2);
        // 测试过程
        // 调用接口
        UserQueryResult result = queryUserService.queryPartnerByParentUserId(queryCardByUserOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        List<UserInfo> list = result.getInfos();
        if (testId == 1001) {
            assertEquals(3, list.size());
            assertEquals(userDO2.getUserId(), list.get(0).getUserId());
            assertEquals(userDO2.getRealName(), list.get(0).getRealName());
            assertEquals(userDO1.getUserId(), list.get(1).getUserId());
            assertEquals(userDO1.getRealName(), list.get(1).getRealName());
            assertEquals(userDO.getUserId(), list.get(2).getUserId());
            assertEquals(userDO.getRealName(), list.get(2).getRealName());
        }
        // 清除数据
    }
}
