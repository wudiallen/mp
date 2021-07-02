package com.dong.controller;

import com.dong.entity.ResponseVo;
import com.dong.exception.StudentException;
import com.dong.exception.TeacherLoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author songchao
 * @date 2021/7/1 14:30
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(StudentException.class)
    @ResponseBody
    public ResponseVo<String> studentException(){
        return new ResponseVo<>("异常",400,"test");
    }

    @ExceptionHandler(TeacherLoginException.class)
    @ResponseBody
    public ResponseVo<String> loginException(){
        return new ResponseVo<>("登录异常",400,"老师登录异常");
    }
}
