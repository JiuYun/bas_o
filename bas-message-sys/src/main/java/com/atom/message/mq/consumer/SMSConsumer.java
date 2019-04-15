package com.atom.message.mq.consumer;

import com.alibaba.fastjson.JSONObject;
import com.atom.message.constants.MqTopicConstants;
import com.atom.message.mq.message.SMSContent;
import com.atom.message.mq.topic.SMSTopic;
import com.atom.message.service.AliYunSMSService;
import io.github.rhwayfun.springboot.rocketmq.starter.common.AbstractRocketMqConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Component
public class SMSConsumer extends AbstractRocketMqConsumer<SMSTopic,SMSContent> {

    @Autowired
    private AliYunSMSService aliYunSMSService;

    @Override
    public Map<String, Set<String>> subscribeTopicTags() {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> tags = new HashSet<>();
        tags.add("*");
        map.put(MqTopicConstants.SEND_SMS_MESSAGE, tags);
        return map;
    }

    // 分组
    @Override
    public String getConsumerGroup() {
        return "ViewAdvertisingConsumer";
    }

    // 消费信息
    @Override
    public boolean consumeMsg(SMSContent content, MessageExt messageExt) {
        System.out.println("收到短信消息：" + JSONObject.toJSONString(content));



//        aliYunSMSService.send();
        return true;
    }




}
