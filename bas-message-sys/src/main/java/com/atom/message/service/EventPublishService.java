package com.atom.message.service;


        import com.atom.message.mq.message.SMSContent;

/**
 *
 * 发布消息通知
 *
 */
public interface EventPublishService {

    /***
     * 发送短信通知
     *
     * @param content
     * @return
     */
    boolean publishSendSMSMessage(SMSContent content);










}
