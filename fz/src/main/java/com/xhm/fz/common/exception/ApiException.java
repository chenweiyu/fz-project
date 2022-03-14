package com.xhm.fz.common.exception;

import com.xhm.fz.common.api.IErrorCode;

/**
 * 自定义API异常
 * Created by xhm on 2020/2/27.
 */
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
