package com.dong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author songchao
 * @date 2021/6/30 21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseVo<T> {
    private String message;
    private Integer status;
    private T data;


}
