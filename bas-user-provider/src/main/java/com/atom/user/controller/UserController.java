package com.atom.user.controller;


import com.atom.bas.common.CusAccessObjectUtil;
import com.atom.bas.common.Result;
import com.atom.bas.common.ResultUtil;
import com.atom.user.dto.PhoneRegister;
import com.atom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
    @PostMapping("/sendRegisterSMSCode/{phone}")
    public Result sendPhoneRegisterSMSCode(@PathVariable(name = "phone") String phone, HttpServletRequest request){
        String userIpAddress = CusAccessObjectUtil.getIpAddress(request);
        return ResultUtil.success(userService.sendPhoneRegisterSMSCode(phone,userIpAddress));
    }

    /***
     * 用户手机号注册
     *
     * @return
     */
    @RequestMapping("/phoneRegister")
    public Result phoneRegister(@RequestBody @Validated(PhoneRegister.Save.class) PhoneRegister register, HttpServletRequest request){
        String userIpAddress = CusAccessObjectUtil.getIpAddress(request);
        return ResultUtil.success(userService.phoneRegister(register,userIpAddress));
    }

    /***
     * 用户手机密码登录
     *
     * @return
     */
    @RequestMapping("/phoneLogin")
    public Result phoneLogin(@RequestBody @Validated(PhoneRegister.PhoneVerCodeLogin.class) PhoneRegister register,HttpServletRequest request){
        String userIpAddress = CusAccessObjectUtil.getIpAddress(request);
        return ResultUtil.success(userService.phoneLogin(register,userIpAddress));
    }

    /***
     * 发送手机号登录验证码
     *
     * @return
     */
    @RequestMapping("/sendPhoneLoginSMSCode")
    public Result sendPhoneLoginSMSCode(@RequestBody @Validated() PhoneRegister register,HttpServletRequest request){
        String userIpAddress = CusAccessObjectUtil.getIpAddress(request);
        return ResultUtil.success(userService.sendPhoneLoginSmsCode(register.getPhone(),userIpAddress));
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
