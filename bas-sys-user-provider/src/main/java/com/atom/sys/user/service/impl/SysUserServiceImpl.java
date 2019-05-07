package com.atom.sys.user.service.impl;

import com.atom.sys.user.entity.SysUser;
import com.atom.sys.user.mapper.SysUserMapper;
import com.atom.sys.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }











}
