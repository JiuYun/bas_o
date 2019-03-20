package com.atom.user.dto;


import javax.validation.constraints.NotNull;

/****
 *
 * 手机号注册对象模型
 *
 */
public class PhoneRegister {

    @NotNull(message = "用户名不能为空",groups = {Save.class})
    private String userName;            // 用户名
    @NotNull(message = "密码不能为空",groups = {Save.class,PhonePasswordLogin.class})
    private String password;
    @NotNull(message = "确认密码不能为空",groups = {Save.class})
    private String confPassword;
    @NotNull(message = "手机号不能为空",groups = {Save.class,PhonePasswordLogin.class,PhoneVerCodeLogin.class})
    private String phone;
    @NotNull(message = "短信验证码不能为空",groups = {Save.class,PhoneVerCodeLogin.class})
    private String SMSVerCode;          // 短信验证码


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSMSVerCode() {
        return SMSVerCode;
    }

    public void setSMSVerCode(String SMSVerCode) {
        this.SMSVerCode = SMSVerCode;
    }

    public interface Save{}
    public interface PhoneVerCodeLogin{}
    public interface PhonePasswordLogin{}





}
