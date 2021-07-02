package com.dong.exception;

/**
 * @author songchao
 * @date 2021/7/1 14:20
 */
public class TeacherLoginException extends RuntimeException {
    public TeacherLoginException(String message){
        super(message);
    }
}
