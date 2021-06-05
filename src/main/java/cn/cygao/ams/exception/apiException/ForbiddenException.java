package cn.cygao.ams.exception.apiException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.ApiException;

/**
 * 鉴权错误异常类，对应HTTP403
 *
 * @author STEA_YY
 **/
public class ForbiddenException extends ApiException {
    public ForbiddenException() {
        super(ApiExceptionCodes.ACCESS_FORBIDDEN.getDesc(), ApiExceptionCodes.ACCESS_FORBIDDEN.getValue());
    }

    public ForbiddenException(String message) {
        super(message, ApiExceptionCodes.ACCESS_FORBIDDEN.getValue());
    }
}
