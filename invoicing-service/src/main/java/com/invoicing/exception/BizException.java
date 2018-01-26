package com.invoicing.exception;

import com.invoicing.enums.ErrorCodeEnum;

/**
 * service业务处理异常
 * 
 * @author yong.cao
 * @time 2017年6月11日下午6:41:56
 */

public class BizException extends Exception {
    private static final long serialVersionUID = 5067417386461048288L;
    private String            errorCode;

    public BizException() {
        super();
    }

    public BizException(String errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;

    }

    public BizException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;

    }

    public BizException(ErrorCodeEnum error) {
        super(error.getMsg());
        this.errorCode = error.getCode();
    }

    public BizException(ErrorCodeEnum error, Throwable cause) {
        super(error.getMsg(), cause);
        this.errorCode = error.getCode();
    }

    public BizException(ErrorCodeEnum error, String msg, Throwable cause) {
        super(error.getMsg(), cause);
        this.errorCode = error.getCode();
    }

    public String getErrorCode() {
        return errorCode;
    }

}
