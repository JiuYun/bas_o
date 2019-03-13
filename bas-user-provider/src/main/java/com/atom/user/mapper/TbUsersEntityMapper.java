package com.atom.user.mapper;

import com.atom.user.entity.TbUsersEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUsersEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUsersEntity record);

    int insertSelective(TbUsersEntity record);

    TbUsersEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUsersEntity record);

    int updateByPrimaryKey(TbUsersEntity record);
}