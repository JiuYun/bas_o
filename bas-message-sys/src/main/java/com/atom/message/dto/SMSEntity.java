package com.atom.message.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Map;


/***
 * 消息实体
 *
 */
public class SMSEntity {

    @NotEmpty(message = "请输入业务标题")
    private String              title;                   // 业务标题（登录验证码:183285933409）
    private String              templateCode;            // 信息模板
    @NotEmpty(message = "请输入收信地址")
    private String              target;                  // 地址 (18328593409 | 1277809056@qq.com)
    private Map<String,Object>  params;                  // 参数
    private Date                sendTime;                // 发送时间发送时间
    @NotEmpty(message = "请输入发送方式")
    private String              method;                  // 发送方式（phone | email）
    private String              senderIP;                // 发送人


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSenderIP() {
        return senderIP;
    }

    public void setSenderIP(String senderIP) {
        this.senderIP = senderIP;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }
}
