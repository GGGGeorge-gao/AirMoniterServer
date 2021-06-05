package cn.cygao.ams.exception.apiException.daoException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.DaoException;

/**
 * 数据库插入失败的异常类
 *
 * @author STEA_YY
 **/
public class InsertException extends DaoException {
    public InsertException(String message) {
        super(message, ApiExceptionCodes.INSERT_ERROR.getValue());
    }

    public InsertException() {
        super(ApiExceptionCodes.INSERT_ERROR.getDesc(), ApiExceptionCodes.INSERT_ERROR.getValue());
    }

    public InsertException(String message, Integer code) {
        super(message, code);
    }
}
