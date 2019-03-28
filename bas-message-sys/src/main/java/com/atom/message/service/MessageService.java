package com.atom.message.service;


import com.atom.message.dto.SMSEntity;

public interface MessageService {

    /****
     * 发送消息
     *
     *
     * @param entity
     * @return
     */
    Object sendMessage(SMSEntity entity);







}
