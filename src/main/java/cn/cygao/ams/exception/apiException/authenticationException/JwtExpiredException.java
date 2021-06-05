package cn.cygao.ams.exception.apiException.authenticationException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.AuthenticationException;

/**
 * token过期异常类
 *
 * @author STEA_YY
 **/
public class JwtExpiredException extends AuthenticationException {
    public JwtExpiredException() {
        super(ApiExceptionCodes.TOKEN_EXPIRED.getDesc(), ApiExceptionCodes.TOKEN_EXPIRED.getValue());
    }

    public JwtExpiredException(String message) {
        super(message, ApiExceptionCodes.TOKEN_EXPIRED.getValue());
    }
}
