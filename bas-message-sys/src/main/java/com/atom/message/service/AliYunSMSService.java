package com.atom.message.service;


import com.atom.message.dto.SMSEntity;

/***
 * 阿里云短信消息接入实现
 *
 */
public interface AliYunSMSService {

    /***
     * 发送短信
     *
     * @param entity
     * @return
     */
    public boolean send(SMSEntity entity);













}
