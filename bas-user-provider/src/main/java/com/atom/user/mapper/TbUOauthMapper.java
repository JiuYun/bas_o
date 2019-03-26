package com.atom.user.mapper;

import com.atom.user.entity.TbUOauth;
import org.apache.ibatis.annotations.Param;

public interface TbUOauthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUOauth record);

    int insertSelective(TbUOauth record);

    TbUOauth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUOauth record);

    int updateByPrimaryKey(TbUOauth record);

    /***
     * 根据第三方唯一ID和三方类型获取关联记录
     *
     * @param unionId               唯一ID
     * @param threeType             第三方类型
     * @return
     */
    TbUOauth selectByUnionIdAndOauthType(@Param("unionId") String unionId, @Param("threeType") int threeType);


    /***
     * 根据第三方唯一ID和三方类型获取关联记录
     *
     * @param oatuhId               唯一ID
     * @param threeType             第三方类型
     * @return
     */
    TbUOauth selectByOatuhIdAndOauthType(@Param("oatuhId") String oatuhId, @Param("threeType") int threeType);

    /***
     * 根据用户ID和第三方类型获取关联记录
     *
     * @param userId
     * @param threeType
     * @return
     */
    TbUOauth selectByUserIdAndAuthType(@Param("userId") Long userId, @Param("threeType") int threeType);



}