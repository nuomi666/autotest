package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.UserGradeOrder;
import dal.model.gas_user.UserDO;
import dal.model.gas_user.UserLevelTaskDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/11/28
 */
public class ScheduleCallBackServiceLevelTaskTest extends SpringBootTestBase {
    @Reference(group = "com.xyb.gas.user.biz.schedule.UserLevelTaskScheduleService", version = "1.0")
    ScheduleCallBackService updateTask;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    PromotionTestBase promotionTestBase;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @AutoTest(file = "gas_user/scheduleCallBackServiceLevelTaskTestSuccess.csv")
    @DisplayName("等级更新--成功用例")
    public void scheduleCallBackServiceLevelTaskTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String userId,
            String userId1,
            String userId2,
            String levelTimeUnit,
            String levelUpdateType,
            String day,
            String days,
            String levelCorn,
            Integer cumulativeOfDays,
            String levelStatus
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        userTestBase.cleanUserLevelRuleByPlatPartnerId(partnerId);
        userTestBase.cleanUserLevelTaskByPlatPartnerId(partnerId);
        // 准备数据
        //商家
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wxa2557eabb23b47e8",
                "测试商家", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", null, "ABLE");
        //更新规则
        List<String> resetDays = new ArrayList<String>();
        resetDays.add(day);
        UserGradeOrder userGradeOrder = new UserGradeOrder();
        userGradeOrder.setUserGradeCode(UserGrade.GRADE_COMMON.code());
        userGradeOrder.setMin(1);
        userGradeOrder.setMax(100);
        UserGradeOrder userGradeOrder1 = new UserGradeOrder();
        userGradeOrder1.setUserGradeCode(UserGrade.GRADE_SILVER.code());
        userGradeOrder1.setMin(101);
        userGradeOrder1.setMax(500);
        UserGradeOrder userGradeOrder2 = new UserGradeOrder();
        userGradeOrder2.setUserGradeCode(UserGrade.GRADE_GOLD.code());
        userGradeOrder2.setMin(501);
        userGradeOrder2.setMax(1000);
        UserGradeOrder userGradeOrder3 = new UserGradeOrder();
        userGradeOrder3.setUserGradeCode(UserGrade.GRADE_DIAMONDS.code());
        userGradeOrder3.setMin(1001);
        List<UserGradeOrder> levelRule = new ArrayList<UserGradeOrder>();
        levelRule.add(userGradeOrder);
        levelRule.add(userGradeOrder1);
        levelRule.add(userGradeOrder2);
        levelRule.add(userGradeOrder3);
        userTestBase.insertUserLevelRule(0L, partnerId, partnerId, levelTimeUnit,
                levelUpdateType, days, JSON.toJSONString(levelRule), levelCorn,
                cumulativeOfDays, null, null, levelStatus);
        //会员
        Date rawTime = DateUtils.parseDate("2018-10-27");
        Date rawAddTime = DateUtils.parseDate("2018-10-27");
        Date rawUpdateTime = DateUtils.parseDate("2018-10-27");
        Date rawAddTime1 = DateUtils.parseDate("2018-10-27");
        Date rawUpdateTime1 = DateUtils.parseDate("2018-10-27");
        Date rawAddTime2 = DateUtils.parseDate("2018-10-27");
        Date rawUpdateTime2 = DateUtils.parseDate("2018-10-27");
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
//        gasUserTestBase.insertUserLevelTask(userLevelTaskDO);
//        gasUserTestBase.insertUserLevelTask(userLevelTaskDO1);
        // 测试过程
        // 第一次
        updateTask.justDoIT();
        // 数据验证
        //任务
        UserLevelTaskDO task = userTestBase.findUserLevelTaskByPartnerId(partnerId).get(0);
        assertEquals("PROCESSING", task.getExecutionStatus());
        assertEquals(1, task.getSubscript().intValue());
//        UserLevelTaskDO task1 = userTestBase.findUserLevelTaskByPartnerId(partnerId).get(0);
//        assertEquals("PROCESSING", task1.getExecutionStatus());
//        assertEquals(1, task1.getSubscript().intValue());
        //等级
        List<UserDO> userInfos = userTestBase.findUserByUserId(userId);
        List<UserDO> userInfos1 = userTestBase.findUserByUserId(userId1);
        List<UserDO> userInfos2 = userTestBase.findUserByUserId(userId2);
        assertEquals(UserGrade.GRADE_SILVER.code(), userInfos.get(0).getGrade());
        assertEquals(UserGrade.GRADE_SILVER.code(), userInfos1.get(0).getGrade());
        assertEquals(UserGrade.GRADE_SILVER.code(), userInfos2.get(0).getGrade());
        // 第二次
        updateTask.justDoIT();
        // 数据验证
        UserLevelTaskDO taskxx = userTestBase.findUserLevelTaskByPartnerId(partnerId).get(0);
        assertEquals("SUCCESS", taskxx.getExecutionStatus());
        assertEquals(2, taskxx.getSubscript().intValue());
        //等级
        List<UserDO> userInfosxx = userTestBase.findUserByUserId(userId);
        List<UserDO> userInfos1xx = userTestBase.findUserByUserId(userId1);
        List<UserDO> userInfos2xx = userTestBase.findUserByUserId(userId2);
        assertEquals(UserGrade.GRADE_SILVER.code(), userInfosxx.get(0).getGrade());
        assertEquals(UserGrade.GRADE_SILVER.code(), userInfos1xx.get(0).getGrade());
        assertEquals(UserGrade.GRADE_SILVER.code(), userInfos2xx.get(0).getGrade());
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserByUserId(userId2);
        userTestBase.cleanUserLevelRuleByPlatPartnerId(partnerId);
        userTestBase.cleanUserLevelTaskByPlatPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanUserByUserId(userId2);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(userId2);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
        silverboltTestBase.cleanGasUserByUserId(userId2);
    }
}
