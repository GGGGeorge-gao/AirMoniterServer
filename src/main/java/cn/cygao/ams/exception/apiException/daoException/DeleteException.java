package cn.cygao.ams.exception.apiException.daoException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.DaoException;

/**
 * 数据库删除失败的异常类
 *
 * @author STEA_YY
 **/
public class DeleteException extends DaoException {
    public DeleteException(String message) {
        super(message, ApiExceptionCodes.DELETE_ERROR.getValue());
    }

    public DeleteException() {
        super(ApiExceptionCodes.DELETE_ERROR.getDesc(), ApiExceptionCodes.DELETE_ERROR.getValue());
    }
}
