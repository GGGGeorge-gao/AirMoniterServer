package cn.cygao.ams.exception.apiException;

import cn.cygao.ams.exception.ApiException;

/**
 * 数据库操作异常类
 *
 * @author STEA_YY
 **/
public class DaoException extends ApiException {
    public DaoException() {
    }

    public DaoException(String message, Integer code) {
        super(message, code);
    }
}
