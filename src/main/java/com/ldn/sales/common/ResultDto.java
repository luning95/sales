package com.ldn.sales.common;

public class ResultDto {

    private boolean bool;
    private Integer retCode;
    private String message;
    private Object object;

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ResultDto() {
    }

    public ResultDto(boolean bool, Integer retCode, String message, String object) {
        this.bool = bool;
        this.retCode = retCode;
        this.message = message;
        this.object = object;
    }
}
