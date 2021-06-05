package cn.cygao.ams.mapper;

import cn.cygao.ams.entity.Role;

/**
* @author cygao
* @date 2021/6/3
**/
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}