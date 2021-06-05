package cn.cygao.ams.controller;

import cn.cygao.ams.annotation.RequestLimit;
import cn.cygao.ams.dto.LoginUserDto;
import cn.cygao.ams.exception.apiException.daoException.InsertException;
import cn.cygao.ams.exception.apiException.daoException.SelectException;
import cn.cygao.ams.service.AuthService;
import cn.cygao.ams.util.ThreadLocalUtil;
import cn.cygao.ams.vo.LoginInfoVo;
import cn.cygao.ams.vo.ResponseBean;
import cn.cygao.ams.annotation.OperationLog;
import cn.cygao.ams.annotation.RequiresLogin;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cygao
 * @date 2021/6/5
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {
    protected static final String MODULE_NAME = "鉴权模块";
    @Resource
    private AuthService authService;

    /**
     * 通过账号密码登录
     *
     * @param loginUserDto 包含账号密码的实体，从请求Json中获取
     */
    @OperationLog(module = MODULE_NAME, method = "用户登录", ignoreParameters = true)
    @RequestLimit(amount = 5, time = 180)
    @PostMapping("/login")
    public ResponseBean<LoginInfoVo> login(@RequestBody @Validated LoginUserDto loginUserDto) throws Exception {
        LoginInfoVo loginInfoVo = authService.login(loginUserDto);
        return new ResponseBean<>(200, "登录成功", loginInfoVo);
    }

    /**
     * 通过账号密码注册
     *
     * @param loginUserDto 用户登录传输类
     */
    @OperationLog(module = MODULE_NAME, method = "用户注册", ignoreParameters = true)
    @RequestLimit(amount = 5, time = 180)
    @PostMapping("/register")
    public ResponseBean<LoginInfoVo> register(@RequestBody @Validated LoginUserDto loginUserDto) throws SelectException, InsertException {
        LoginInfoVo loginInfoVo = authService.register(loginUserDto);
        return new ResponseBean<>(200, "注册成功", loginInfoVo);
    }

    @RequiresLogin
    @GetMapping("/test")
    public ResponseBean<Object> test() {
        int userId = ThreadLocalUtil.getCurrentUser();
        return new ResponseBean<>(userId);
    }
}
























