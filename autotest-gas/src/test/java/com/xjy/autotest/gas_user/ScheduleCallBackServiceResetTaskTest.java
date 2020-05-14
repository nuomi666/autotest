package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import dal.model.gas_user.UserIntegralResetTaskDO;
import dal.model.promotion.PointsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/11/27
 */
public class ScheduleCallBackServiceResetTaskTest extends SpringBootTestBase {
    @Reference(group = "com.xyb.gas.user.biz.schedule.UserIntegralResetTaskScheduleService", version = "1.0")
    ScheduleCallBackService resetTask;

    @Autowired
    Gas_userTestBase gasUserTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @AutoTest(file = "gas_user/scheduleCallBackServiceResetTaskTestSuccess.csv")
    @DisplayName("积分清零--成功用例")
    public void scheduleCallBackServiceResetTaskTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String userId,
            String userId1,
            String userId2,
            String resetTimeUnit,
            String integralResetType,
            String days,
            String resetCorn,
            String resetSwitch
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasUserTestBase.cleanUserIntegralResetRuleByPlatPartnerId(partnerId);
        gasUserTestBase.cleanUserIntegralResetTaskByPlatPartnerId(partnerId);
//        gasUserTestBase.cleanUserIntegralResetTaskByPartnerId(userIntegralResetTaskDO1.getPartnerId());
//        promotionTestBase.cleanPointsByUserId(userId);
//        promotionTestBase.cleanPointsByUserId(userId1);
//        promotionTestBase.cleanPointsByUserId(userId2);
//        promotionTestBase.cleanPointsLogByUserId(userId);
//        promotionTestBase.cleanPointsLogByUserId(userId1);
//        promotionTestBase.cleanPointsLogByUserId(userId2);
        // 准备数据
        //商家
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        //规则
        gasUserTestBase.insertUserIntegralResetRule(0L, partnerId, partnerId,
                resetSwitch, integralResetType,
                resetTimeUnit, resetCorn, JSON.toJSONString(days), null, null);
        Date rawAddTime = DateUtils.parseDate("2019-10-27");
        Date rawUpdateTime = DateUtils.parseDate("2019-10-27");
        Date rawAddTime1 = DateUtils.parseDate("2019-11-27");
        Date rawUpdateTime1 = DateUtils.parseDate("2019-11-27");
        Date rawAddTime2 = DateUtils.parseDate("2019-12-27");
        Date rawUpdateTime2 = DateUtils.parseDate("2019-12-27");
        gasUserInitDataBase.initUserAll(partnerId, userId, null, null,
                null, "13325814711", null, "AUTONOMY_GENERALIZE", null,
                null, null, null, rawAddTime, rawUpdateTime);
        gasUserInitDataBase.initUserAll(partnerId, userId1, null, null,
                null, "13325814722", null, "AUTONOMY_GENERALIZE", null,
                null, null, null, rawAddTime1, rawUpdateTime1);
        gasUserInitDataBase.initUserAll(partnerId, userId2, null, null,
                null, "13325814733", null, "AUTONOMY_GENERALIZE", null,
                null, null, null, rawAddTime2, rawUpdateTime2);
        //积分
        String pointsId = OID.newID();
        String pointsId1 = OID.newID();
        String pointsId2 = OID.newID();
        Date pointRawAddTime = DateUtils.parseDate("2019-10-30");
        Date pointRawAddTime1 = DateUtils.parseDate("2019-11-20");
        Date pointRawAddTime2 = DateUtils.parseDate("2019-11-30");
        Date pointRawAddTime3 = DateUtils.parseDate("2019-12-07");
        Date pointRawAddTime4 = DateUtils.parseDate("2019-12-10");
        Date pointRawAddTime5 = DateUtils.parseDate("2019-12-31");
        Date pointRawAddTime6 = DateUtils.parseDate("2020-01-30");
        promotionTestBase.insertPoints(0, pointsId, partnerId, partnerId, userId, 30,
                0, 30, null, pointRawAddTime, pointRawAddTime1);
        promotionTestBase.insertPointsLog(0, pointsId, GID.newGID(), OID.newID(), partnerId, OID.newID(),
                partnerId, OID.newID(), userId, 10, OID.newID(),
                "ADD", pointRawAddTime, pointRawAddTime);
        promotionTestBase.insertPointsLog(0, pointsId, GID.newGID(), OID.newID(), partnerId, OID.newID(),
                partnerId, OID.newID(), userId, 20, OID.newID(),
                "ADD", pointRawAddTime1, pointRawAddTime1);

        promotionTestBase.insertPoints(0, pointsId1, partnerId, partnerId, userId1, 20,
                10, 30, null, pointRawAddTime2, pointRawAddTime4);
        promotionTestBase.insertPointsLog(0, pointsId1, GID.newGID(), OID.newID(), partnerId, OID.newID(),
                partnerId, OID.newID(), userId1, 10, OID.newID(),
                "ADD", pointRawAddTime2, pointRawAddTime2);
        promotionTestBase.insertPointsLog(0, pointsId1, GID.newGID(), OID.newID(), partnerId, OID.newID(),
                partnerId, OID.newID(), userId1, 10, OID.newID(),
                "SUBTRACT", pointRawAddTime3, pointRawAddTime3);
        promotionTestBase.insertPointsLog(0, pointsId1, GID.newGID(), OID.newID(), partnerId, OID.newID(),
                partnerId, OID.newID(), userId1, 20, OID.newID(),
                "ADD", pointRawAddTime4, pointRawAddTime4);

        promotionTestBase.insertPoints(0, pointsId2, partnerId, partnerId, userId2, 30,
                10, 40, pointRawAddTime, pointRawAddTime, pointRawAddTime6);
        promotionTestBase.insertPointsLog(0, pointsId2, GID.newGID(), OID.newID(), partnerId, OID.newID(),
                partnerId, OID.newID(), userId2, 10, OID.newID(),
                "ADD_REVERSED", pointRawAddTime5, pointRawAddTime5);
        promotionTestBase.insertPointsLog(0, pointsId2, GID.newGID(), OID.newID(), partnerId, OID.newID(),
                partnerId, OID.newID(), userId2, 20, OID.newID(),
                "ADD", pointRawAddTime6, pointRawAddTime6);
        // 测试过程
        // 第一次
        resetTask.justDoIT();
        // 数据验证
        sleep(3);
        //任务
        UserIntegralResetTaskDO task =
                gasUserTestBase.findUserIntegralResetTaskByPlatPartnerId(partnerId).get(0);
        assertEquals("PROCESSING", task.getExecutionStatus());
        assertEquals(1, task.getSubscript().intValue());
//        UserIntegralResetTaskDO task1 =
//                gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO1.getPartnerId()).get(0);
//        assertEquals("PROCESSING", task1.getExecutionStatus());
//        assertEquals(1, task1.getSubscript().intValue());
        // 第二次
        resetTask.justDoIT();
        // 数据验证
        sleep(3);
        UserIntegralResetTaskDO taskxx =
                gasUserTestBase.findUserIntegralResetTaskByPlatPartnerId(partnerId).get(0);
        assertEquals("SUCCESS", taskxx.getExecutionStatus());
        assertEquals(2, taskxx.getSubscript().intValue());
//        UserIntegralResetTaskDO task1xx =
//                gasUserTestBase.findUserIntegralResetTaskByPartnerId(gasMerchantDO1.getPartnerId()).get(0);
        //积分
        List<PointsDO> points = promotionTestBase.findPointsByUserId(userId);
        List<PointsDO> points1 = promotionTestBase.findPointsByUserId(userId1);
        List<PointsDO> points2 = promotionTestBase.findPointsByUserId(userId2);
        assertEquals(0L, points.get(0).getPoints());
        assertEquals(0L, points1.get(0).getPoints());
        assertEquals(10L, points2.get(0).getPoints());
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(partnerId);
        gasUserTestBase.cleanUserByUserId(userId);
        gasUserTestBase.cleanUserByUserId(userId1);
        gasUserTestBase.cleanUserByUserId(userId2);
        gasUserTestBase.cleanUserIntegralResetRuleByPlatPartnerId(partnerId);
        gasUserTestBase.cleanUserIntegralResetTaskByPlatPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanUserByUserId(userId2);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(userId2);
        promotionTestBase.cleanPointsByUserId(userId);
        promotionTestBase.cleanPointsByUserId(userId1);
        promotionTestBase.cleanPointsByUserId(userId2);
        promotionTestBase.cleanPointsLogByUserId(userId);
        promotionTestBase.cleanPointsLogByUserId(userId1);
        promotionTestBase.cleanPointsLogByUserId(userId2);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByUserId(userId2);
    }
}
