package com.atom.sys.user.service;

import com.atom.sys.user.entity.SysUser;

public interface SysUserService {


    /***
     * 根据用户名查找用户信息
     *
     * @param userName
     * @return
     */
    SysUser selectByUserName(String userName);


}
