package com.xjy.autotest.test;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: xingzhe
 * @Email: xingzhe@xinyebang.com
 * @Date: 2018/7/5 0005/14:49
 * @Desc:
 **/
//@Service
public class ChannelDataConsumer{
    protected final Logger logger = LoggerFactory.getLogger(ChannelDataConsumer.class);


//    @RocketListener(topic="clearChannelDataTopic",messageFilter=@MessageFilter(fromSystem={"xyb-clear"},event={"clearChannelDataEvent"}))
//    public void onMessage(NotifyMessage messages) throws InvocationTargetException,
//            IllegalAccessException{
//        String messageBody = JSON.toJSONString(messages.getData());
//        logger.debug("收到Mq推送【渠道订单】:{}",messageBody);
//
//    }
}
