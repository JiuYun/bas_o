package com.atom.user.service;

import com.atom.user.dto.BindWeChat;
import com.atom.user.dto.PhoneExist;
import com.atom.user.dto.PhoneRegister;
import com.atom.user.entity.TbUsersEntity;

import java.util.List;

/***
 * 用户相关服务接口
 */
public interface UserService {


    /****
     * 获取所有用户列表
     *
     * @return
     */
    List<TbUsersEntity> userList();


    /***
     * 发送注册短信验证码
     *
     * @param phone                     手机号
     * @param userIpAddress             用户地址
     * @return
     */
    boolean sendPhoneRegisterSMSCode(String phone, String userIpAddress);

    /***
     * 注册用户
     *
     * @param register                  注册信息
     * @param userIpAddress             用户地址
     * @return
     */
    Object phoneRegister(PhoneRegister register, String userIpAddress);

    /***
     * 手机号登录
     *
     * @param register                  登录信息
     * @param userIpAddress             用户地址
     * @return
     */
    Object phoneLogin(PhoneRegister register, String userIpAddress);


    /***
     * 发送手机号登录短信验证码
     *
     * @param phone                     登录手机号
     * @param userIpAddress
     * @return
     */
    Object sendPhoneLoginSmsCode(String phone, String userIpAddress);

    /***
     * 微信登录
     *
     * @param code                      code
     * @param userIpAddress             用户IP
     * @return
     */
    Object weChatLogin(String code, String userIpAddress);

    /***
     * 绑定用户微信
     *
     * @param weChat
     * @return
     */
    boolean bindWeChat(BindWeChat weChat);

    /***
     * 判断手机号是否存在
     *
     * @param phoneExist
     * @return
     */
    boolean phoneExist(PhoneExist phoneExist);
}
