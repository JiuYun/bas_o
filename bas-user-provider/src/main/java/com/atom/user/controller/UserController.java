package com.atom.user.controller;


import com.atom.bas.common.CusAccessObjectUtil;
import com.atom.bas.common.Result;
import com.atom.bas.common.ResultUtil;
import com.atom.user.dto.BindWeChat;
import com.atom.user.dto.PhoneExist;
import com.atom.user.dto.PhoneRegister;
import com.atom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;


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
    public Result sendPhoneLoginSMSCode(@RequestBody @Validated(PhoneRegister.SendPhoneLoginCode.class) PhoneRegister register,HttpServletRequest request){
        String userIpAddress = CusAccessObjectUtil.getIpAddress(request);
        return ResultUtil.success(userService.sendPhoneLoginSmsCode(register.getPhone(),userIpAddress));
    }

    /***
     * 手机号短信验证码登录
     *
     * @return
     */
    @RequestMapping("/phoneSMSCodeLogin")
    public Result phoneSMSCodeLogin(@RequestBody @Validated(PhoneRegister.PhoneVerCodeLogin.class) PhoneRegister register, HttpServletRequest request){
        String userIpAddress = CusAccessObjectUtil.getIpAddress(request);
        return ResultUtil.success(userService.phoneLogin(register, userIpAddress));
    }

    /***
     * 微信号登录
     *
     * @return
     */
    @RequestMapping("/weChatLogin")
    public Result weChatLogin(@RequestBody @Validated @NotNull(message = "参数异常") String code, HttpServletRequest request){
        String userIpAddress = CusAccessObjectUtil.getIpAddress(request);
        return ResultUtil.success(userService.weChatLogin(code,userIpAddress));
    }


    /***
     * 绑定微信号
     *
     * @return
     */
    @RequestMapping("/bindWeChat")
    public Result bindWeChat(@RequestBody @Validated BindWeChat weChat){
        return ResultUtil.success(userService.bindWeChat(weChat));
    }


    /***
     * 根据手机号验证用户是否存在
     *
     * @return
     */
    @RequestMapping("/phoneExist")
    public Result phoneExist(@RequestBody @Validated PhoneExist phoneExist){
        return ResultUtil.success(userService.phoneExist(phoneExist));
    }





}
