package com.xjy.autotest.openapinew;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.xjy.autotest.info.ClearMerchantOrderInfo;
import com.xjy.autotest.info.NotifyMessage;
import com.xjy.common.util.MapUtils;
import com.xyb.adk.common.kryo.Kryos;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.util.money.Money;
// import com.xyb.boot.rocketmq.message.NotifyMessage;
import com.xyb.pay.api.common.enums.TransTagEnum;
import com.xyb.pay.api.common.enums.TransTypeEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RocketMqTest {
    static {
        System.setProperty("xyb.appCode", "T11");
        System.setProperty("xyb.appName", "autotest");
        System.setProperty("server.port", "9005");
        System.setProperty("spring.profiles.active", "local");
    }

    public static void main(String[] args) throws Exception {
        // produce();

        consume();
    }

    /**
     * 生产者
     *
     * @throws Exception
     */
    public static void produce() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("mqSendScheduleService");
        producer.setNamesrvAddr("192.168.2.233:9876");
        producer.start();

        ClearMerchantOrderInfo clearMerchantOrderInfo = new ClearMerchantOrderInfo();
        clearMerchantOrderInfo.setPartnerId("20180615001234567890");
        clearMerchantOrderInfo.setPlatPartnerId("20180615001234567800");
        clearMerchantOrderInfo.setMerchantOrderNo("merchantOrderNo1553064391940");
        clearMerchantOrderInfo.setMerchantTradeNo("1j1usk0s08s051hge8er");
        clearMerchantOrderInfo.setMerchantOrderAmount(new Money(2));
        clearMerchantOrderInfo.setMerchantAmount(new Money(2));
        clearMerchantOrderInfo.setMerchantChannelFee(Float.parseFloat("30"));
        clearMerchantOrderInfo.setMerchantFee(Float.parseFloat("50"));
        clearMerchantOrderInfo.setChannelId("cdzxyh");
        clearMerchantOrderInfo.setTransTag(TransTagEnum.ONLINE);
        clearMerchantOrderInfo.setTransType(TransTypeEnum.PAYMENT);
        clearMerchantOrderInfo.setMerchantTradeTime(new Date());

        NotifyMessage notifyMessage = new NotifyMessage();
        notifyMessage.setGid(GID.newGID());
        notifyMessage.setTopic("clearMerchantDataTopic1");
        notifyMessage.setFromSystem("xyb-pay");
        notifyMessage.setToSystem("xyb-clear");
        notifyMessage.setEvent("clearMerchantDataEvent");
        notifyMessage.setData(MapUtils.beanToMap(clearMerchantOrderInfo));
        notifyMessage.setId(OID.newID());

        byte[] data = Kryos.serialize(notifyMessage);
        Message message = new Message();
        message.setTopic(notifyMessage.getTopic());
        message.setTags(notifyMessage.getTag());
        message.setBody(data);
        message.setKeys(notifyMessage.getId());
        producer.sendOneway(message);
        System.out.println("生产成功=======");

        producer.shutdown();
    }

    /**
     * 消费者
     *
     * @throws Exception
     */
    public static void consume() throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("autotest");

        consumer.setNamesrvAddr("192.168.2.233:9876");

        consumer.subscribe("clearMerchantDataTopic1", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                for (MessageExt messageExt : msgs) {
                    String topic = messageExt.getTopic();
                    String tag = messageExt.getTags();
                    String msg = new String(messageExt.getBody());
                    System.out.println("*********************************");
                    System.out.println("消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + msg + ", tag:" + tag + ", topic:" + topic);
                    System.out.println("*********************************");
                    NotifyMessage notifyMessage = (NotifyMessage)Kryos.deserialize(messageExt.getBody(), NotifyMessage.class);
                    System.out.println(notifyMessage.toString());

                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
