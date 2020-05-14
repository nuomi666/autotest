//package com.xjy.autotest.gas_user;
//
//import com.alibaba.rocketmq.client.exception.MQClientException;
//import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
//import com.alibaba.rocketmq.common.message.Message;
//import com.google.common.collect.Maps;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.coverage.NotifyMessage;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.Gas_userTestBase;
//import com.xjy.autotest.testbase.PromotionTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.kryo.Kryos;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.user.api.enums.UserGrade;
//import com.xyb.gas.user.api.order.UserLevelIntegralOrder;
//import dal.model.gas_merchant.GasMerchantDO;
//import dal.model.gas_user.UserDO;
//import dal.model.gas_user.UserLevelTaskDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.Map;
//
///**
// * @author nuomi@xinyebang.com
// * @date 2018/11/29
// */
//public class ScheduleCallBackServiceLevelAutoTaskTest extends SpringBootTestBase {
//
//    @Autowired
//    Gas_userTestBase gasUserTestBase;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    @Autowired
//    PromotionTestBase promotionTestBase;
//
//    @AutoTest(file = "gas_user/scheduleCallBackServiceLevelAutoTaskTestSuccess.csv")
//    @DisplayName("等级更新(自动触发)--成功用例")
//    public void scheduleCallBackServiceLevelAutoTaskTestSuccess(
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
//        gasUserTestBase.insertUser(userDO);
//        gasUserTestBase.insertUser(userDO1);
//        gasUserTestBase.insertUser(userDO2);
////        gasUserTestBase.insertUserLevelTask(userLevelTaskDO);
////        gasUserTestBase.insertUserLevelTask(userLevelTaskDO1);
//        // 测试过程
//
//        //构建消息发送者
//        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("Providers_test");
//        defaultMQProducer.setNamesrvAddr("192.168.2.233:9876");
//        defaultMQProducer.setRetryAnotherBrokerWhenNotStoreOK(true);
//        defaultMQProducer.setInstanceName(GID.newGID());
//        try {
//            defaultMQProducer.start();
//        } catch (MQClientException e) {
//            logger.error("发送消息异常", e);
//            return;
//        }
//        //发送消息
//        NotifyMessage message = new NotifyMessage();
//        message.setEvent("user_level_change");
//        message.setGid(GID.newGID());
//        message.setId(OID.newID());
//        message.setTopic("userIntegralChange");
//        message.setFromSystem(NotifyMessage.ALL);
//        message.setToSystem("gas_user");
//        Map<String, Object> params = Maps.newHashMap();
//        UserLevelIntegralOrder order = new UserLevelIntegralOrder();
//        order.setPartnerId("S0301811261400000001");
//        order.setUserId("S0301811271500000018");
////        params.put(DATA, order);
//        message.setData(params);
//        try {
//            defaultMQProducer.send(toMessage(message));
//        } catch (Exception e) {
//            logger.error("发送消息异常", e);
//            return;
//        }
//        // 数据验证
//        UserDO user = gasUserTestBase.findUserByUserId("S0301811271500000018").get(0);
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
//
//
//    public Message toMessage(NotifyMessage notifyMessage){
//        byte[] data = Kryos.serialize(notifyMessage);
//        Message message = new Message();
//        message.setTopic(notifyMessage.getTopic());
//        message.setTags(notifyMessage.getTag());
//        message.setBody(data);
//        message.setKeys(OID.newID());
//        return message;
//    }
//}
