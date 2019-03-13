package com.atom.user.service;

import com.atom.user.entity.TbUsersEntity;

import java.util.List;

/***
 * 用户相关服务接口
 */
public interface UserService {


    List<TbUsersEntity> userList();
}
