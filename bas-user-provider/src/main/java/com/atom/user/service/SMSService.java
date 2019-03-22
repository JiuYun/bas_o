package com.atom.user.service;

import com.atom.user.emuns.SMSCode;

public interface SMSService {



    /***
     * 发送短信验证码
     *
     * @param target                    目标收件地址
     * @param senderIP                  发送人IP地址
     * @param templateCode              使用业务
     * @return
     */
    public boolean sendSMSVerCode(String target, String senderIP, SMSCode templateCode);

    /****
     * 发送邮件验证码
     *
     * @param target                    目标收件地址
     * @param senderIP                  发送IP
     * @param templateCode              使用业务
     * @return
     */
    public boolean sendEmailVerCode(String target, String senderIP, SMSCode templateCode);









}
