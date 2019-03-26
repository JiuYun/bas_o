package com.atom.user.service;


import com.atom.user.dto.WeChatUserInfo;

public interface WeChatService {


    /***
     * 微信登录获取微信用户信息
     *
     * @param code
     * @return
     */
    public WeChatUserInfo weChatUserInfo(String code);


    /***
     * 小程序登录获取登录信息
     *
     * @param code
     * @return
     */
    public WeChatUserInfo weChatUserInfoForMinApp(String code);










}
