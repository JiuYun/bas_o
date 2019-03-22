package com.atom.user.emuns;

public enum SMSCode {
    PHONE_REGISTER("手机号注册","user:phone:register:%s","SMS_154950416"),
    PHONE_LOGIN("手机号登录","user:phone:login.code:%s","SMS_154950416"),



    ;

    SMSCode(String businessName,String value,String templateCode){
        this.businessName   = businessName;
        this.value          = value;
        this.templateCode   = templateCode;
    }

    private String  businessName;                // 业务名称
    private String  value;                       // 业务标识
    private String  templateCode;                // 模板代码
    private long    waitTime        = 60;        // 验证码间歇时间
    private long    survivalTime    = 160;       // 有效期秒


    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public long getSurvivalTime() {
        return survivalTime;
    }

    public void setSurvivalTime(long survivalTime) {
        this.survivalTime = survivalTime;
    }
}
