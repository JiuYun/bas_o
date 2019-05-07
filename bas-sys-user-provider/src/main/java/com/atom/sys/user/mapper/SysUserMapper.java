package com.atom.sys.user.mapper;

import com.atom.sys.user.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);


    /**
     * 根据用户查找用户信息
     *
     * @param userName
     * @return
     */
    SysUser selectByUserName(@Param("userName") String userName);





}