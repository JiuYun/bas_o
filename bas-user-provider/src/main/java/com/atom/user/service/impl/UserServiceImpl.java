package com.atom.user.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atom.bas.common.exception.MsgException;
import com.atom.bas.pojo.SMSEntity;
import com.atom.user.constants.Constant;
import com.atom.user.dto.PhoneRegister;
import com.atom.user.emuns.SMSCode;
import com.atom.user.entity.TbUsersEntity;
import com.atom.user.mapper.TbUsersEntityMapper;
import com.atom.user.service.RedisService;
import com.atom.user.service.SMSService;
import com.atom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private SMSService smsService;


    public List<TbUsersEntity> userList() {
        return null;
    }

    public boolean sendPhoneRegisterSMSCode(String phone, String userIpAddress) {
        return smsService.sendSMSVerCode(phone,userIpAddress,SMSCode.PHONE_REGISTER);
    }

    public Object phoneRegister(PhoneRegister register, String userIpAddress) {
        // 校验验证码
        String code         = (String) redisService.get(String.format(SMSCode.PHONE_REGISTER.getValue(),register.getPhone()));
        if(StringUtils.isEmpty(code)){
            throw new MsgException("验证码不存在或已失效");
        }
        if(!code.equalsIgnoreCase(register.getSMSVerCode())){
            throw new MsgException("验证码错误");
        }

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
        String codeForRedis = String.format(SMSCode.PHONE_LOGIN.getValue(),register.getPhone());
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
        return smsService.sendSMSVerCode(phone,userIpAddress,SMSCode.PHONE_LOGIN);
    }





























}
