package cn.cygao.ams.mapper;

import cn.cygao.ams.entity.User;
import org.apache.ibatis.annotations.Param;

/**
* @author cygao
* @date 2021/6/3
**/
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(@Param("username")String username);

    int updatePasswordById(@Param("updatedPassword")String updatedPassword,@Param("id")Integer id);



}