package com.example.exception;

import com.example.common.enums.ResultCodeEnum;

//继承了RuntimeException 就是一个异常类了（自定义的异常类）
public class CustomException extends RuntimeException{

    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public CustomException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code;
        this.msg = resultCodeEnum.msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
