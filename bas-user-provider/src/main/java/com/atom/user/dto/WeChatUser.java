package com.atom.user.dto;


import javax.validation.constraints.NotEmpty;

/***
 *
 * 绑定微信，微信登陆模型
 * @author LiJ
 */
public class WeChatUser {


    @NotEmpty(message = "请输入有效code")
    private String code;



}
