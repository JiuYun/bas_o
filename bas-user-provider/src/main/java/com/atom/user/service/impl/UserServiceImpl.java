package com.atom.user.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atom.bas.common.exception.MsgException;
import com.atom.user.dto.PhoneRegister;
import com.atom.user.entity.TbUsersEntity;
import com.atom.user.mapper.TbUsersEntityMapper;
import com.atom.user.service.RedisService;
import com.atom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Date;
import java.util.List;

/***
 * 用户相关服务实现
 */
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private TbUsersEntityMapper usersEntityMapper;

    @Autowired
    private RedisService redisService;


    public List<TbUsersEntity> userList() {
        return null;
    }


    public String sendPhoneRegisterSMSCode(String phone, String userIpAddress) {
        String code         = (Math.random() + "").substring(3,9);      // 6位数字验证码
        String codeForRedis = String.format("user:phone:register.code:%s",phone);
        redisService.set(codeForRedis,code,10000l);         // 调用专门的发送验证码组件
        System.out.println(String.format("短信验证码:[%s->%s]",phone,code));
        return null;
    }


    public Object phoneRegister(PhoneRegister register, String userIpAddress) {
        TbUsersEntity user = new TbUsersEntity();
        user.setCrtTime(new Date());
        user.setDeleted(0);
        user.setPhone(register.getPhone());
        user.setStatus(1);
        user.setUserName(register.getUserName());
        user.setPassword(register.getPassword());
        return usersEntityMapper.insert(user);
    }


    public Object phoneLogin(PhoneRegister register, String userIpAddress) {
        // 1.在当前缓存中获取手机号对应的验证码信息
        String codeForRedis = String.format("user:phone:login.code:%s",register.getPhone());
        String code         = (String) redisService.get(codeForRedis);
        if(StringUtils.isEmpty(code)){
            throw new MsgException("验证码不存在或已失效");
        }
        if(!code.equalsIgnoreCase(register.getSMSVerCode())){
            throw new MsgException("验证码错误");
        }
        TbUsersEntity user = usersEntityMapper.selectByPhone(register.getPhone());
        return user;
    }


    @Override
    public Object sendPhoneLoginSmsCode(String phone, String userIpAddress) {
        // 先判断当前ip发送数量


        // 判断当前手机发送数量


        // 判断发送时间 手机? ip?


        return null;
    }



}
