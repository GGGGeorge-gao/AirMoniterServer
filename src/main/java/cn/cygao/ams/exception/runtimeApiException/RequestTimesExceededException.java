package cn.cygao.ams.exception.runtimeApiException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.RuntimeApiException;

/**
 * 访问次数限制异常类
 *
 * @author STEA_YY
 **/
public class RequestTimesExceededException extends RuntimeApiException {
    public RequestTimesExceededException() {
        super(ApiExceptionCodes.REQUEST_TIMES_EXCEEDED.getDesc(), ApiExceptionCodes.REQUEST_TIMES_EXCEEDED.getValue());
    }

    public RequestTimesExceededException(String message) {
        super(message, ApiExceptionCodes.REQUEST_TIMES_EXCEEDED.getValue());
    }
}