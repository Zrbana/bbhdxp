package com.gyy.exception;

/**
 * 自定义异常类
 */
public class SysException extends Exception {

    //用来存储异常信息的字符串
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
