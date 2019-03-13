package com.atom.user.mapper;

import com.atom.user.entity.TbUsersEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUsersEntityMapper{
    int deleteByPrimaryKey(Long id);

    int insert(TbUsersEntity record);

    int insertSelective(TbUsersEntity record);

    TbUsersEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUsersEntity record);

    int updateByPrimaryKey(TbUsersEntity record);

    List<TbUsersEntity> selectAll(@Param("userName") String userName);
}

