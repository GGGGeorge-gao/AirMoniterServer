package cn.cygao.ams.controller;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.ApiException;
import cn.cygao.ams.exception.RuntimeApiException;
import cn.cygao.ams.exception.apiException.AuthenticationException;
import cn.cygao.ams.exception.apiException.ForbiddenException;
import cn.cygao.ams.exception.runtimeApiException.RequestTimesExceededException;
import cn.cygao.ams.vo.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 *
 * @author STEA_YY
 **/
@RestControllerAdvice
@Slf4j
public class ExceptionController {
    @Resource
    private HttpServletResponse response;

    /**
     * 捕捉控制器未找到异常
     *
     * @param e 控制器未找到异常类
     * @return 返回错误码和HTTP404
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseBean<Object> handleNoHandlerFoundException(NoHandlerFoundException e) {
        //跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        //跨域 Header
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Expose-Headers", "*");
        return new ResponseBean<>(404, e.getMessage(), null);
    }

    /**
     * 捕捉用户鉴权相关异常
     *
     * @param e 鉴权失败异常类
     * @return 返回错误码和HTTP401
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseBean<Object> handleAuthenticationException(AuthenticationException e) {
        return new ResponseBean<>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 捕捉禁止访问异常
     *
     * @param e 禁止访问异常类
     * @return 返回错误码和HTTP403
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    public ResponseBean<Object> handleForbiddenException(ForbiddenException e) {
        return new ResponseBean<>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 捕捉访问次数超限异常
     *
     * @param e 访问次数超限异常类
     * @return 返回错误码和HTTP403
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(RequestTimesExceededException.class)
    public ResponseBean<Object> handleRequestTimesExceededException(RequestTimesExceededException e) {
        return new ResponseBean<>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 捕获其他API异常
     *
     * @param e Api异常类
     * @return 返回错误码和HTTP500
     */
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<Object> handleApiException(ApiException e) {
        return new ResponseBean<>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 捕获其他Runtime API异常
     *
     * @param e Runtime Api异常类
     * @return 返回错误码和HTTP500
     */
    @ExceptionHandler(RuntimeApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<Object> handleRuntimeApiException(RuntimeApiException e) {
        return new ResponseBean<>(e.getCode(), e.getMessage(), null);
    }

    /**
     * 捕捉参数校验异常
     *
     * @param e 参数校验异常类
     * @return 返回错误码和HTTP500
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseBean<>(ApiExceptionCodes.ARGUMENTS_VALID_FAIL.getValue(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), null);
    }

    /**
     * 捕捉其他所有异常
     *
     * @param e 异常类
     * @return 返回500错误码和HTTP500
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBean<Object> globalException(Exception e) {
        log.error(e.getMessage());
        return new ResponseBean<>(500, e.getMessage(), null);
    }
}