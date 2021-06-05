package cn.cygao.ams.exception.apiException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.ApiException;

/**
 * 授权异常类
 *
 * @author STEA_YY
 **/
public class AuthorizationException extends ApiException {
    public AuthorizationException() {
        super(ApiExceptionCodes.AUTHORIZATION_FAIL.getDesc(), ApiExceptionCodes.AUTHORIZATION_FAIL.getValue());
    }

    public AuthorizationException(String message) {
        super(message, ApiExceptionCodes.AUTHORIZATION_FAIL.getValue());
    }
}
