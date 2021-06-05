package cn.cygao.ams.exception.apiException.authenticationException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.AuthenticationException;

/**
 * 未找到token字段的异常类
 *
 * @author STEA_YY
 **/
public class TokenNotFoundException extends AuthenticationException {
    public TokenNotFoundException() {
        super(ApiExceptionCodes.TOKEN_NOT_FOUND.getDesc(), ApiExceptionCodes.TOKEN_NOT_FOUND.getValue());
    }

    public TokenNotFoundException(String message) {
        super(message, ApiExceptionCodes.TOKEN_NOT_FOUND.getValue());
    }
}
