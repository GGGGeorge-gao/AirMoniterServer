package cn.cygao.ams.service;

import cn.hutool.core.util.StrUtil;
import cn.cygao.ams.entity.User;
import cn.cygao.ams.exception.apiException.daoException.SelectException;
import cn.cygao.ams.mapper.RoleMapper;
import cn.cygao.ams.mapper.UserMapper;
import cn.cygao.ams.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户服务类
 *
 * @author STEA_YY
 **/
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    /**
     * 根据id查找用户，如果未找到则抛出异常
     *
     * @param id 用户id
     * @return 用户
     * @throws SelectException 查询异常
     */
    public UserVo getExistUserById(int id) throws SelectException {
        User user = userMapper.selectByPrimaryKey(id);

        if (user == null) {
            throw new SelectException("用户不存在！");
        } else {
            UserVo userVo = UserVo.buildVo(user);
            userVo.setRole(roleMapper.selectByPrimaryKey(user.getRoleId()));
            return userVo;
        }
    }

    public UserVo getExistUserByUsername(String username) throws SelectException {
        User user = userMapper.selectByUsername(username);

        if (user == null) {
            throw new SelectException("用户不存在！");
        } else {
            UserVo userVo = UserVo.buildVo(user);
            userVo.setRole(roleMapper.selectByPrimaryKey(user.getRoleId()));
            return userVo;
        }
    }

    /**
     * 保存用户
     *
     * @param user 用户实体类
     */
    @Transactional(rollbackFor = Exception.class)
    public User saveUser(User user) {
        userMapper.insertSelective(user);
        return user;
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     */
    public void deleteUserById(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改密码
     *
     * @param id          用户id
     * @param newPassword 新的密码
     */
    public void updatePassword(Integer id, String newPassword) {
        userMapper.updatePasswordById(newPassword, id);
    }


    public boolean existsById(Integer userId) {
        return userId != null && userMapper.selectByPrimaryKey(userId) != null;
    }

    public boolean existsByUsername(String username) {
        return !StrUtil.isBlank(username) && userMapper.selectByUsername(username) != null;
    }
}
