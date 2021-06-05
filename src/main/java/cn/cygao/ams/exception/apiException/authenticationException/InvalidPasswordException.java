package cn.cygao.ams.exception.apiException.authenticationException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.AuthenticationException;

/**
 * 密码错误异常类
 *
 * @author STEA_YY
 **/
public class InvalidPasswordException extends AuthenticationException {

    public InvalidPasswordException(String message) {
        super(message, ApiExceptionCodes.INVALID_USER_PASSWORD.getValue());
    }

    public InvalidPasswordException() {
        super(ApiExceptionCodes.INVALID_USER_PASSWORD.getDesc(), ApiExceptionCodes.INVALID_USER_PASSWORD.getValue());
    }
}
