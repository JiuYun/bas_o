package com.atom.user.service.impl;

import com.atom.bas.common.exception.MsgException;
import com.atom.bas.pojo.SMSEntity;
import com.atom.user.constants.Constant;
import com.atom.user.emuns.SMSCode;
import com.atom.user.service.RedisService;
import com.atom.user.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service("SMSServiceImpl")
public class SMSServiceImpl implements SMSService {

    @Autowired
    private RedisService redisService;

    private static final String PHONE = "phone";
    private static final String EMAIL = "email";


    @Override
    public boolean sendSMSVerCode(String target, String senderIP, SMSCode templateCode) {
        return sendVerCode(target,senderIP,templateCode,PHONE);
    }

    @Override
    public boolean sendEmailVerCode(String target, String senderIP, SMSCode templateCode) {
        return sendVerCode(target,senderIP,templateCode,EMAIL);
    }

    private boolean sendVerCode(String target, String senderIP, SMSCode templateCode,String method){
        // 每个IP每天能发送验证码的次数得有限制
        Integer ipSendCount = (Integer) redisService.get(String.format(Constant.ipSendCodeCountForRedis,senderIP));
        if(ipSendCount != null && ipSendCount.intValue() > 10){
            throw new MsgException("今日短信发送量已达上限");
        }

        // 每个手机号控制发送频率
        String  codeForRedis    = String.format(templateCode.getValue(),target);
        long    survivalTime    = redisService.expire(codeForRedis);
        if (survivalTime > templateCode.getSurvivalTime() - templateCode.getWaitTime()) {
            throw new MsgException(String.format("请于%s秒后再试",survivalTime - (templateCode.getSurvivalTime() -
                    templateCode.getWaitTime())));
        }

        String code         = (Math.random() + "").substring(3,9);      // 6位数字验证码

        // 短信参数
        Map<String,Object> params = new HashMap<>();
        params.put("code",code);

        SMSEntity entity = new SMSEntity();
        entity.setTitle(String.format("%s:%s",templateCode.getBusinessName(),target));
        entity.setTarget(target);
        entity.setParams(params);
        entity.setSendTime(new Date());
        entity.setMethod(method);
        entity.setSenderIP(senderIP);

        redisService.incr(String.format(Constant.ipSendCodeCountForRedis,senderIP));
        redisService.set(codeForRedis,code,templateCode.getSurvivalTime());

        System.out.println(String.format("发送消息:%s-%s-%s",entity.getMethod(),templateCode.getBusinessName(),code));


        // TODO 调用消息服务器发送消息



        return true;
    }






}
