package com.atom.user.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @NotNull(message = "手机号不能为空",groups = {Save.class,PhonePasswordLogin.class,PhoneVerCodeLogin.class,SendPhoneLoginCode.class})
    @Pattern(regexp = "^(((13[0-9])|(14[5-7])|(15[0-9])|(17[0-9])|(18[0-9]))+\\d{8})$",message = "请输入正确手机号",
            groups = {Save.class,PhonePasswordLogin.class,PhoneVerCodeLogin.class,SendPhoneLoginCode.class})
    private String phone;

    @NotNull(message = "短信验证码不能为空",groups = {Save.class,PhoneVerCodeLogin.class})
    private String smsVerCode;          // 短信验证码


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

    public String getSmsVerCode() {
        return smsVerCode;
    }

    public void setSmsVerCode(String smsVerCode) {
        this.smsVerCode = smsVerCode;
    }

    public interface Save{}
    public interface SendPhoneLoginCode{}
    public interface PhoneVerCodeLogin{}
    public interface PhonePasswordLogin{}





}
