package com.ldn.sales.common.exception;

public class MyException extends RuntimeException {
    private Integer errorCode;

    public MyException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
