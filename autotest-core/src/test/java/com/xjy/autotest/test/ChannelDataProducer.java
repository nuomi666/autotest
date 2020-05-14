package com.xjy.autotest.test;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xingzhe
 * @Email: xingzhe@xinyebang.com
 * @Date: 2018/7/5 0005/14:49
 * @Desc:
 **/
@Slf4j
@Service
public class ChannelDataProducer {

//    @Autowired
//    private MessageProducer messageProducer;


    /**
     * 推送mq渠道订单信息
     *
     * @return
     */
//    public StandardResultInfo sendChannelOrder() throws InterruptedException, RemotingException, TopicDisableException, MQClientException, MQBrokerException {
//        NotifyMessage notifyMessage = new NotifyMessage();
//        notifyMessage.setTopic("clearChannelDataTopic");
//        notifyMessage.setGid(GID.newGID());
//        notifyMessage.setEvent("clearChannelDataEvent");
//        notifyMessage.setId(notifyMessage.getGid());
//        messageProducer.send(notifyMessage);
//        return null;
//    }

}
