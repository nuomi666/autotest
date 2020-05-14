//package com.xjy.autotest.gas_user;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.rocketmq.client.exception.MQClientException;
//import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
//import com.google.common.collect.Maps;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.UserService;
//import com.xyb.gas.user.api.enums.UserGrade;
//import com.xyb.gas.user.api.order.RegisterOrder;
//import com.xyb.gas.user.api.order.UserLevelIntegralOrder;
//import com.xyb.gas.user.api.result.RegisterUserResult;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_user.UserDO;
//import dal.model.gas_user.UserLevelTaskDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.Map;
//
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/11/30
// */
//public class ScheduleCallBackServiceLevelAutoTest extends SpringBootTestBase {
//    @Reference(version = "1.0")
//    UserService userService;
//
//    @Autowired
//    Gas_userTestBase gasUserTestBase;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    @Autowired
//    PromotionTestBase promotionTestBase;
//    @AutoTest(file = "gas_user/scheduleCallBackServiceLevelAutoTestSuccess.csv")
//    @DisplayName("等级更新(自动触发)--成功用例")
//    public void scheduleCallBackServiceLevelAutoTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            GasMerchantDO gasMerchantDO,
//            GasMerchantDO gasMerchantDO1,
//            UserDO userDO,
//            UserDO userDO1,
//            UserDO userDO2,
//            UserLevelTaskDO userLevelTaskDO,
//            UserLevelTaskDO userLevelTaskDO1
//    ) {
//        // 清除数据
//
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
//        gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO1.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO2.getUserId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
//        // 准备数据
//        Date rawTime = DateUtils.parseDate("2018-10-27");
//        gasMerchantTestBase.insertGasMerchant(gasMerchantDO);
//        gasMerchantTestBase.insertGasMerchant(gasMerchantDO1);
//        gasUserTestBase.insertUser(userDO);
//        gasUserTestBase.insertUser(userDO1);
//        gasUserTestBase.insertUser(userDO2);
////        gasUserTestBase.insertUserLevelTask(userLevelTaskDO);
////        gasUserTestBase.insertUserLevelTask(userLevelTaskDO1);
//        // 测试过程
//        RegisterOrder order=new RegisterOrder();
//        order.setPartnerId("S0301811271400000001");
//        order.setMobile("18745874125");
//        order.setGid(GID.newGID());
//        RegisterUserResult result = userService.register(order);
//        print(result);
//        assertEquals(status,result.getStatus());
//        // 数据验证
//        String userId=result.getUserId();
//        UserDO user = gasUserTestBase.findUserByUserId(userId).get(0);
//        assertEquals(UserGrade.GRADE_GOLD.code(), user.getGrade());
//        // 清除数据
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMerchantByPartnerId(gasMerchantDO1.getPartnerId());
//        gasUserTestBase.cleanUserByUserId(userDO.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO1.getUserId());
//        gasUserTestBase.cleanUserByUserId(userDO2.getUserId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
////        gasUserTestBase.cleanUserLevelTaskByPartnerId(userLevelTaskDO.getPartnerId());
//    }
//}
