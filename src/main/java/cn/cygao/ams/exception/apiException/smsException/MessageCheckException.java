package cn.cygao.ams.exception.apiException.smsException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.SmsException;

/**
 * 短信验证码验证失败异常类
 *
 * @author STEA_YY
 **/
public class MessageCheckException extends SmsException {

    public MessageCheckException() {
        super(ApiExceptionCodes.MESSAGE_CHECK_FAIL.getDesc(), ApiExceptionCodes.MESSAGE_CHECK_FAIL.getValue());
    }

    public MessageCheckException(String message) {
        super(message, ApiExceptionCodes.MESSAGE_CHECK_FAIL.getValue());
    }
}
