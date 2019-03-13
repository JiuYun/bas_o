package com.atom.basUser.controller;


import com.atom.basUser.entity.TbUsersEntity;
import com.atom.basUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/****
 * 用户资料Controller
 * 1.手机号注册
 * TODO 2.微信号注册
 * TODO 3.QQ注册
 * TODO 4.邮箱注册
 * TODO 5.用户名称注册
 *
 * 如果采用其2、3、4、5方式进行注册的话，第二部分注册的时候就需要完善用户手机号资料信息,表示绑定手机号
 *
 *
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /***
     * 发送手机号注册验证码
     *
     * @param userPhone            用户手机号
     * @param business             业务标识
     * @return
     */
    @PostMapping("/sendRegisterPhoneVerCode")
    public Map<String,Object> sendRegisterPhoneVerCode(String userPhone, String business, HttpServletRequest request){
//        userService.sendRegisterPhoneVerCode(userPhone,business);

        return new HashMap<String, Object>(){{
            put("msg","发送验证码成功");
            put("code",1);
        }};
    }


    /***
     * 手机号注册
     *
     * @param userPhone             用户手机号
     * @param verCode               验证码
     * @param password              密码
     * @param confPassword          确认密码
     * @return
     */
    @PostMapping("registerPhone")
    public Map<String,Object> registerPhone(String userPhone,String verCode,String password,String confPassword,String business){
        return new HashMap<String, Object>(){{
            put("msg","注册成功");
            put("code",1);
            put("data",new HashMap<String,Object>(){{
                put("userInfo",new HashMap<String,Object>(){{
                    put("userName","18328593409");
                    put("email","127780956@qq.com");
                    put("phone","18328593409");
                }});
            }});
        }};
    }

    /***
     * 查询用户列表
     *
     * @return
     */
    @RequestMapping("/userList")
    public List<TbUsersEntity> userList(){
        return userService.userList();
    }
































































    @RequestMapping("/userProfile")
    public Map<String,Object> userProfile(Integer userId){
        return new HashMap<String, Object>(){{
            put("userName","1277809056@qq.com");
            put("realName","小太爷");
            put("sex",1);
        }};
    }

























}
