package com.atom.basUser.controller.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("user-provider")
@RequestMapping("/user")
public interface UserClient {


    /***
     * 发送手机号注册注册验证码
     *
     * @param phone
     * @param business
     * @return
     */
    @PostMapping("/sendRegisterPhoneVerCode")
    public Map<String,Object> sendRegisterPhoneVerCode(@RequestParam("userPhone") String phone, @RequestParam("business") String business);


    /***
     * 手机号注册用户
     *
     * @param userPhone
     * @param verCode
     * @param password
     * @param confPassword
     * @param business
     * @return
     */
    @PostMapping("registerPhone")
    public Map<String,Object> registerPhone(@RequestParam("userPhone") String userPhone,
                                            @RequestParam("verCode") String verCode,
                                            @RequestParam("password") String password,
                                            @RequestParam("confPassword") String confPassword,
                                            @RequestParam("business") String business);






}