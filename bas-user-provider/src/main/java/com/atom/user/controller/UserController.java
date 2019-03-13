package com.atom.user.controller;


import com.atom.bas.common.Result;
import com.atom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/****
 * 用户资料Controller
 * 1.手机号注册
 * 2.微信号注册
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /***
     * 发送手机号注册短信验证码
     *
     * @param phone             目标手机号
     * @return
     */
    @RequestMapping("/sendRegisterSMSCode/{phone}")
    public Result sendPhoneRegisterSMSCode(@PathVariable(name = "phone") String phone){

        return null;
    }

    /***
     * 用户手机号注册
     *
     * @return
     */
    @RequestMapping("/phoneRegister")
    public Result phoneRegister(){

        return null;
    }

    /***
     * 用户手机密码登录
     *
     * @return
     */
    @RequestMapping("/phoneLogin")
    public Result phoneLogin(){

        return null;
    }

    /***
     * 手机号短信验证码登录
     *
     * @return
     */
    @RequestMapping("/phoneSMSCodeLogin")
    public Result phoneSMSCodeLogin(){

        return null;
    }

    /***
     * 微信号登录
     *
     * @return
     */
    @RequestMapping("/weChatLogin")
    public Result weChatLogin(){

        return null;
    }

    /***
     * 绑定微信号
     *
     * @return
     */
    @RequestMapping("/bindWeChat")
    public Result bindWeChat(){
        return null;
    }

    /***
     * 根据手机号验证码用户是否存在
     *
     * @return
     */
    @RequestMapping("/phoneExist")
    public Result phoneExist(){
        return null;
    }





}
