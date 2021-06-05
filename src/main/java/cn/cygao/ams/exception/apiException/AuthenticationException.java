package cn.cygao.ams.exception.apiException;

import cn.cygao.ams.exception.ApiException;

/**
 * 鉴权相关的异常类
 *
 * @author STEA_YY
 **/
public class AuthenticationException extends ApiException {

    public AuthenticationException() {
    }

    public AuthenticationException(String message, Integer code) {
        super(message, code);
    }
}