package com.atom.basUser.service;

import com.atom.basUser.entity.TbUsersEntity;

import java.util.List;

/***
 * 用户相关服务接口
 */
public interface UserService {


    List<TbUsersEntity> userList();
}
