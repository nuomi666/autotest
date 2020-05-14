package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.FollowWeChatManageService;
import com.xyb.gas.user.api.order.FollowWeChatOrder;
import dal.model.gas_user.UserFollowWeChatInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/14.
 */
public class FollowWeChatManageServiceAcceptTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    FollowWeChatManageService followWeChatManageService;

    @Autowired
    Gas_userTestBase userTestBase;

    /**
     * 1001.关注
     * 1002.取关
     */
    @AutoTest(file = "gas_user/followWeChatManageServiceAcceptTestSuccess.csv")
    @DisplayName("接收微信发出的微信公众号关注事件--成功用例")
    public void followWeChatManageServiceAcceptTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            FollowWeChatOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserFollowWeChatInfoByOpenId(order.getOpenId());
        // 准备数据
        Date followTime = DateUtils.parseDate2("2020-01-14 15:16:17");
        Date rawAddTIme = DateUtils.parseDate2("2019-12-25 15:16:17");
        if (testId == 1002) {
            userTestBase.insertUserFollowWeChatInfo(0L, order.getOpenId(), partnerId, partnerId, "true", rawAddTIme,
                    rawAddTIme, rawAddTIme, rawAddTIme);
        }
        // 测试过程
        order.setFollowTime(followTime);
        // 调用接口
        SimpleResult result = followWeChatManageService.accept(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserFollowWeChatInfoDO> followInfos = userTestBase.findUserFollowWeChatInfoByOpenId(order.getOpenId());
        assertEquals(1, followInfos.size());
        if (testId == 1001) {
            followAssert(followInfos.get(0),
                    partnerId, order.getOpenId(), "true", followTime,
                    followTime, DateUtils.getSqlDate(), DateUtils.getSqlDate());
        }
        if (testId == 1002) {
            followAssert(followInfos.get(0),
                    partnerId, order.getOpenId(), "false", rawAddTIme,
                    followTime, rawAddTIme, DateUtils.getSqlDate());
        }
        // 清除数据
        userTestBase.cleanUserFollowWeChatInfoByOpenId(order.getOpenId());
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/followWeChatManageServiceAcceptTestFailOne.csv")
    @DisplayName("接收微信发出的微信公众号关注事件--参数非法")
    public void followWeChatManageServiceAcceptTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            FollowWeChatOrder order
    ) {
        // 清除数据
        // 准备数据
        Date followTime = DateUtils.parseDate2("2020-01-14 15:16:17");
        // 测试过程
        order.setFollowTime(followTime);
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setOpenId(null);
        }
        if (testId == 1003) {
            order.setFollowTime(null);
        }
        if (testId == 1004) {
            order.setType(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1006) {
            order = null;
        }
        // 调用接口
        SimpleResult result = followWeChatManageService.accept(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 关注信息
     */
    private void followAssert(
            UserFollowWeChatInfoDO followInfo,
            String partnerId,
            String openId,
            String follow,
            Date firstFollowTime,
            Date lastFollowTime,
            Date addTime,
            Date updateTime
    ) {
        assertEquals(partnerId, followInfo.getPlatPartnerId());
        assertEquals(openId, followInfo.getOpenId());
        assertEquals(follow, followInfo.getFollow());
        assertEquals(firstFollowTime, followInfo.getFirstFollowTime());
        assertEquals(lastFollowTime, followInfo.getLastFollowTime());
//        assertEquals(addTime, followInfo.getRawAddTime());
//        assertEquals(updateTime, followInfo.getRawUpdateTime());有延迟就校验不过
    }
}
