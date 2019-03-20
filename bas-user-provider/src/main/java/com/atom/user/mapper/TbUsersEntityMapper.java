package com.atom.user.mapper;

import com.atom.user.entity.TbUsersEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface TbUsersEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUsersEntity record);

    int insertSelective(TbUsersEntity record);

    TbUsersEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUsersEntity record);

    int updateByPrimaryKey(TbUsersEntity record);

    /***
     * 根据手机号获取用户
     *
     * @param phone
     * @return
     */
    TbUsersEntity selectByPhone(@Param("phone") String phone);




}