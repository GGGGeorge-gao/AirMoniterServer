package cn.cygao.ams.exception.apiException.authenticationException;

import cn.cygao.ams.constants.ApiExceptionCodes;
import cn.cygao.ams.exception.apiException.AuthenticationException;

/**
 * 未签署合同异常类
 *
 * @author STEA_YY
 **/
public class ContractNotSignedException extends AuthenticationException {
    public ContractNotSignedException(String message) {
        super(message, ApiExceptionCodes.CONTRACT_NOT_SIGNED.getValue());
    }

    public ContractNotSignedException() {
        super(ApiExceptionCodes.CONTRACT_NOT_SIGNED.getDesc(), ApiExceptionCodes.CONTRACT_NOT_SIGNED.getValue());
    }
}
