package com.atom.message.mq.topic;

import com.atom.message.constants.MqTopicConstants;
import io.github.rhwayfun.springboot.rocketmq.starter.constants.RocketMqTopic;

public class SMSTopic implements RocketMqTopic {

    @Override
    public String getTopic() {
        return MqTopicConstants.SEND_SMS_MESSAGE;
    }

}
