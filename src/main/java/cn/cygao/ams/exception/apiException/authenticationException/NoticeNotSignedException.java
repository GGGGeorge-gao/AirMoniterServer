package cn.cygao.ams.exception.apiException.authenticationException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.AuthenticationException;

/**
 * 用户未签署服务协议的异常类
 *
 * @author STEA_YY
 **/
public class NoticeNotSignedException extends AuthenticationException {
    public NoticeNotSignedException() {
        super(ApiExceptionCodes.NOTICE_NOT_SIGNED.getDesc(), ApiExceptionCodes.NOTICE_NOT_SIGNED.getValue());
    }

    public NoticeNotSignedException(String message) {
        super(message, ApiExceptionCodes.NOTICE_NOT_SIGNED.getValue());
    }
}
