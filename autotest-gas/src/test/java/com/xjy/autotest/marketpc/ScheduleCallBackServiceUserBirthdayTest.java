//package com.xjy.autotest.marketpc;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_marketpcTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.commonservice.scheduler.api.service.ScheduleCallBackService;
//import dal.model.gas_user.UserDO;
//import dal.model.promotion.PointsDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/10/29
// */
//public class ScheduleCallBackServiceUserBirthdayTest extends SpringBootTestBase {
//    @Reference(group = "com.xyb.gas.marketpc.biz.schedule.UserBirthdayScheduleService", version = "1.0")
//    ScheduleCallBackService userBirthday;
//
//    @Autowired
//    Gas_userTestBase gasUserBase;
//
//    @Autowired
//    PromotionTestBase promotionTestBase;
//
//    @Autowired
//    Gas_marketpcTestBase gasMarketpcTestBase;
//
//    /**
//     * 生日(MM-dd,如：09-10)
//     */
//    @AutoTest(file = "marketpc/scheduleCallBackServiceUserBirthdayTestSuccess.csv")
//    @DisplayName("生日发券--成功用例")
//    public void scheduleCallBackServiceUserBirthdayTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            //会员信息
//            UserDO userDO,
//            UserDO userDO1
//    ) {
//        // 清除数据
//        gasUserBase.cleanUserByUserId(userDO.getUserId());
//        gasUserBase.cleanUserByUserId(userDO1.getUserId());
//        promotionTestBase.cleanPointsByUserId(userDO.getUserId());
//        promotionTestBase.cleanPointsByUserId(userDO1.getUserId());
//        promotionTestBase.cleanCouponByUserId(userDO.getUserId());
//        promotionTestBase.cleanCouponByUserId(userDO1.getUserId());
//        gasMarketpcTestBase.cleanUserBirthdayTaskByUserId(userDO.getUserId());
//        gasMarketpcTestBase.cleanUserBirthdayTaskByUserId(userDO1.getUserId());
//        // 准备数据
//        Date birthday = DateUtils.getSqlDate();
//        String shortBirthday = birthday.toString().substring(5, 10);
//        userDO.setBirthday(birthday);
//        userDO.setShortBirthday(shortBirthday);
//        gasUserBase.insertUser(userDO);
//        if (testId == 1001 || testId == 1003) {
//            userDO1.setBirthday(birthday);
//            userDO1.setShortBirthday(shortBirthday);
//        }
//        gasUserBase.insertUser(userDO1);
//        //
//        PointsDO pointsDO = new PointsDO();
//        pointsDO.setPartnerId(userDO.getPartnerId());
//        pointsDO.setPlatPartnerId("S0301806081400000015");
//        pointsDO.setUserId(userDO.getUserId());
//        pointsDO.setPoints(10L);
//        pointsDO.setHistoryAddPoints(10L);
//        pointsDO.setHistorySubtractPoints(0L);
//        pointsDO.setPointId(OID.newID());
//        pointsDO.setRawAddTime(DateUtils.getSqlDate());
//        pointsDO.setRawUpdateTime(DateUtils.getSqlDate());
//        promotionTestBase.insertPoints(pointsDO);
//        PointsDO points = promotionTestBase.findPointsByUserId(userDO.getUserId()).get(0);
//        PointsDO pointsDO1 = new PointsDO();
//        pointsDO1.setPartnerId(userDO1.getPartnerId());
//        pointsDO1.setPlatPartnerId("S0301806081400000015");
//        pointsDO1.setUserId(userDO1.getUserId());
//        pointsDO1.setPoints(20L);
//        pointsDO1.setHistoryAddPoints(20L);
//        pointsDO1.setHistorySubtractPoints(0L);
//        pointsDO1.setPointId(OID.newID());
//        pointsDO1.setRawAddTime(DateUtils.getSqlDate());
//        pointsDO1.setRawUpdateTime(DateUtils.getSqlDate());
//        promotionTestBase.insertPoints(pointsDO1);
//        PointsDO points1 = promotionTestBase.findPointsByUserId(userDO1.getUserId()).get(0);
//        // 测试过程
//        // 调用接口
//        userBirthday.justDoIT();
//        // 结果验证
//        // 数据验证
//        PointsDO points1xx = promotionTestBase.findPointsByUserId(userDO1.getUserId()).get(0);
//        assertEquals(userDO1.getUserId(), points1xx.getUserId());
//        // 清除数据
//        gasUserBase.cleanUserByUserId(userDO.getUserId());
//        gasUserBase.cleanUserByUserId(userDO1.getUserId());
//        gasUserBase.cleanUserByUserId(userDO.getUserId());
//        gasUserBase.cleanUserByUserId(userDO1.getUserId());
//        promotionTestBase.cleanPointsByUserId(userDO.getUserId());
//        promotionTestBase.cleanPointsByUserId(userDO1.getUserId());
//        promotionTestBase.cleanCouponByUserId(userDO.getUserId());
//        promotionTestBase.cleanCouponByUserId(userDO1.getUserId());
//        gasMarketpcTestBase.cleanUserBirthdayTaskByUserId(userDO.getUserId());
//        gasMarketpcTestBase.cleanUserBirthdayTaskByUserId(userDO1.getUserId());
//    }
//}
