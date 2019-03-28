package com.atom.message.service.impl;

import com.atom.message.constants.MqTopicConstants;
import com.atom.message.mq.message.SMSContent;
import com.atom.message.service.EventPublishService;
import io.github.rhwayfun.springboot.rocketmq.starter.common.DefaultRocketMqProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventPublishServiceImpl implements EventPublishService {

    @Autowired
    private DefaultRocketMqProducer producer;

    @Override
    public boolean publishSendSMSMessage(SMSContent content) {
        Message msg = new Message(MqTopicConstants.SEND_SMS_MESSAGE, content.toString().getBytes());
        return producer.sendMsg(msg);
    }



}
