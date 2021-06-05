package cn.cygao.ams.service;

import cn.cygao.ams.config.JwtConfig;
import cn.cygao.ams.constants.RedisConstants;
import cn.cygao.ams.dto.JwtPayloadDto;
import cn.cygao.ams.dto.LoginUserDto;
import cn.cygao.ams.entity.User;
import cn.cygao.ams.exception.apiException.authenticationException.AccountNotFoundException;
import cn.cygao.ams.exception.apiException.authenticationException.InvalidPasswordException;
import cn.cygao.ams.exception.apiException.authenticationException.PermissionDeniedException;
import cn.cygao.ams.exception.apiException.daoException.InsertException;
import cn.cygao.ams.exception.apiException.daoException.SelectException;
import cn.cygao.ams.exception.apiException.smsException.MessageCheckException;
import cn.cygao.ams.util.EncryptUtil;
import cn.cygao.ams.util.JwtUtil;
import cn.cygao.ams.vo.LoginInfoVo;
import cn.cygao.ams.vo.PersonalUserInfoVo;
import cn.cygao.ams.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 授权鉴权服务类
 *
 * @author STEA_YY
 **/
@Service
public class AuthService {
    @Resource
    private UserService userService;
    @Resource
    private RedisService redisService;
    @Resource
    private JwtConfig jwtConfig;

    /**
     * 传入手机号+密码完成登录校验并获取令牌
     *
     * @param loginUserDto 登录信息实体类
     * @return token令牌和用户部分信息
     * @throws Exception 向上抛出异常
     */
    public LoginInfoVo login(LoginUserDto loginUserDto) throws Exception {

        UserVo userVo = userService.getExistUserByUsername(loginUserDto.getUsername());

        if (EncryptUtil.getSha256(loginUserDto.getPassword()).equals(userVo.getPassword())) {
            return executeLoginByUserId(userVo.getId());
        } else {
            throw new InvalidPasswordException("用户名或密码错误！");
        }
    }

    public LoginInfoVo register(LoginUserDto loginUserDto) throws SelectException, InsertException {
        if (userService.existsByUsername(loginUserDto.getUsername())) {
            throw new InsertException("用户名已存在");
        }
        User user = User.builder()
                .username(loginUserDto.getUsername())
                .password(EncryptUtil.getSha256(loginUserDto.getPassword()))
                .createdTime(new Date())
                .roleId(1)
                .build();

        user = userService.saveUser(user);
        System.out.println(user.getId());
        return executeLoginByUserId(user.getId());
    }

    /**
     * 处理用户修改密码的请求
     */
    public LoginInfoVo changePassword(String oldPassword, String newPassword, int userId) throws MessageCheckException, AccountNotFoundException, SelectException, PermissionDeniedException {
        if (!EncryptUtil.getSha256(oldPassword).equals(userService.getExistUserById(userId).getPassword())) {
            throw new PermissionDeniedException("原密码错误");
        }

        String encodedPassword = EncryptUtil.getSha256(newPassword);
        userService.updatePassword(userId, encodedPassword);

        return executeLoginByUserId(userId);
    }

    /**
     * 处理用户登出请求，移除token
     *
     * @param userId 用户id
     */
    public void logout(Integer userId) {
        redisService.del(userId.toString());
    }

    /**
     * 签署token令牌
     *
     * @param userVo 用户私有信息封装
     * @return token令牌
     */
    private String signToken(UserVo userVo) {
        JwtPayloadDto jwtPayloadDto = JwtUtil.packagePayload(userVo);

        String token = JwtUtil.sign(jwtPayloadDto, jwtConfig.getSecret(), jwtConfig.getExpireTime());
        redisService.set(RedisConstants.REFRESH_TOKEN_PREFIX + userVo.getId(), token, jwtConfig.getRefreshTokenExpireTime());
        return token;
    }

    /**
     * 处理登录过程
     *
     * @param userId 用户id
     * @return token和部分用户信息
     * @throws SelectException 用户未找到异常
     */
    private LoginInfoVo executeLoginByUserId(int userId) throws SelectException {
        UserVo userVo = userService.getExistUserById(userId);
        String token = signToken(userVo);

        PersonalUserInfoVo personalUserInfo = PersonalUserInfoVo.builder().userId(userVo.getId()).username(userVo.getUsername()).createdTime(userVo.getCreatedTime()).role(userVo.getRole()).build();

        return new LoginInfoVo(token, personalUserInfo);
    }

}
