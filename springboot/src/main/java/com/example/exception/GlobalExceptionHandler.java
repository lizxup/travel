package com.example.exception;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.example.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//检测哪里的异常
@ControllerAdvice("com.example.controller")
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();

    //引入异常


    @ExceptionHandler(Exception.class)
    @ResponseBody//返回json串
    public Result error(Exception e){
        log.error("异常信息：", e);
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody//返回json串
    public Result error(CustomException e){
        log.error("异常信息：", e);
        return Result.error(e.getCode(),e.getMsg());
    }

}
