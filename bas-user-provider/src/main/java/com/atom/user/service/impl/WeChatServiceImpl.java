package com.atom.user.service.impl;


import cn.hutool.http.HttpUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import com.atom.bas.common.exception.MsgException;
import com.atom.user.dto.WeChatAccessToken;
import com.atom.user.dto.WeChatUserInfo;
import com.atom.user.service.WeChatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class WeChatServiceImpl implements WeChatService {


    @Value("${weChat.appId}")
    private String appId;

    @Value("${weChat.appSecret}")
    private String appSecret;

    @Value("${weChat.minAppId}")
    private String minAppId;

    @Value("${weChat.minAppSecret}")
    private String minAppSecret;

    /***
     * 根据code获取用户微信凭证信息
     *
     * @param code
     * @return
     */
    private WeChatAccessToken accessTokenForCode(String code){
        String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        String result         = HttpUtil.get(String.format(accessTokenUrl,appId,appSecret,code));
        return JSONObject.parseObject(result,WeChatAccessToken.class);
    }


    /***
     * 根据openId获取用户信息
     *
     * @param code
     * @return
     */
    @Override
    public WeChatUserInfo weChatUserInfo(String code){
        WeChatAccessToken token = accessTokenForCode(code);
        if(StringUtils.isEmpty(token.getOpenid())){
            throw new MsgException("登录信息不存在");
        }

        String userInfoUrl  = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";
        String result       = HttpUtil.get(String.format(userInfoUrl,token.getAccessToken(),token.getOpenid()));
        return JSONObject.parseObject(result,WeChatUserInfo.class);
    }


    /***
     * 根据code 获取用户信息
     *
     * @param code          小程序登录code
     * @return
     */
    @Override
    public WeChatUserInfo weChatUserInfoForMinApp(String code){
        String userInfoUrl  = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
        String result       = HttpUtil.get(String.format(userInfoUrl,minAppId,minAppSecret,code));

        //{"session_key":"6XFboJyNxl88+Y4MohkuhQ==","openid":"oFVTX5aHMAR9N8gof7bTIrq3S3rg","unionid":"o6WCF0sa_K3uXSB4yKzg20LmlgTk"}

        JSONObject res      = JSONObject.parseObject(result);
        if(!res.containsKey("unionid")){
            throw new MsgException("获取微信信息失败");
        }
        WeChatUserInfo userInfo = JSONObject.parseObject(result,WeChatUserInfo.class);
        userInfo.setSex("1");
        return userInfo;
    }

















}
