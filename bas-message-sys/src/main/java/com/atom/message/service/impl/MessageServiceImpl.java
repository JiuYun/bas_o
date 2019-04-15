package com.atom.message.service.impl;

import com.atom.bas.common.exception.MsgException;
import com.atom.bas.service.RedisService;
import com.atom.message.dto.SMSEntity;
import com.atom.message.emuns.MessageType;
import com.atom.message.service.AliYunSMSService;
import com.atom.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService {

    @Resource
    private RedisService redisService;

    @Autowired
    private AliYunSMSService aliYunSMSService;



    @Override
    public Object sendMessage(SMSEntity entity) {
        if(entity.getMethod().equalsIgnoreCase(MessageType.EMAIL.getName())){
            publishEmailMessage(entity);
        }else if(entity.getMethod().equalsIgnoreCase(MessageType.PHONE.getName())){
            publishPhoneMessage(entity);
        }else if(entity.getMethod().equalsIgnoreCase(MessageType.JIGUANG.getName())){
            publishJiGuangMessage(entity);
        }else if(entity.getMethod().equalsIgnoreCase(MessageType.UMENG.getName())){
            publishUmengMessage(entity);
        }else{
            throw new MsgException("暂不支持消息类型");
        }
        return null;
    }


    /***
     * 发送邮件消息内容
     *
     * @param entity
     */
    public void publishEmailMessage(SMSEntity entity){

    }

    /***
     * 发送短信消息内容
     *
     * @param entity
     */
    public void publishPhoneMessage(SMSEntity entity){
        // 多个收信人
        if(getOccur(entity.getTarget(),",") > 999){
            throw new MsgException("收信人最多1000个");
        }

        // TODO 本地生成发送记录，供查询使用
        aliYunSMSService.send(entity);
    }

    /***
     * 发送极光推送消息
     *
     * @param entity
     */
    public void publishJiGuangMessage(SMSEntity entity){

    }

    /***
     * 发送友盟推送消息
     *
     * @param entity
     */
    public void publishUmengMessage(SMSEntity entity){

    }



    public static int getOccur(String src,String find){
        int o = 0;
        int index=-1;
        while((index=src.indexOf(find,index))>-1){
            ++index;
            ++o;
        }
        return o;
    }



















}
