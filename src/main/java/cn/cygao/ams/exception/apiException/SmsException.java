package cn.cygao.ams.exception.apiException;

import cn.cygao.ams.exception.ApiException;

/**
 * 短信业务异常类
 *
 * @author STEA_YY
 **/
public class SmsException extends ApiException {

    public SmsException() {
    }

    public SmsException(String message, Integer code) {
        super(message, code);
    }
}
