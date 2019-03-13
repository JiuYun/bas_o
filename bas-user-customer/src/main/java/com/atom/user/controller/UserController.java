package com.atom.user.controller;

import com.atom.user.controller.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;


    @RequestMapping(value="/userInfos",method=RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForObject("http://user-provider/userInfos", String.class);
    }


    /***
     * 发送手机号注册验证码
     *
     * @param userPhone                     用户手机号
     * @param business                      业务标识
     * @return
     */
    @GetMapping("/sendRegisterPhoneVerCode")
    public Map<String,Object> sendRegisterPhoneVerCode(String userPhone, String business){
        return userClient.sendRegisterPhoneVerCode(userPhone,business);
    }


    /***
     * 手机号注册
     *
     * @param userPhone                     用户手机号
     * @param verCode                       验证码
     * @param password                      账户登录密码
     * @param confPassword                  确认密码
     * @param business                      业务标识
     * @return
     */
    @PostMapping("registerPhone")
    public Map<String,Object> registerPhone(String userPhone,String verCode,String password,String confPassword,String business){
        return userClient.registerPhone(userPhone,verCode,password,confPassword,business);
    }














}
