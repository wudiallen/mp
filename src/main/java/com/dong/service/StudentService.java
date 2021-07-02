package com.dong.service;

import com.dong.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songchao
 * @since 2021-06-30
 */
public interface StudentService extends IService<Student> {
    /**
     *aa
     * @param student
     * @return
     */
    Integer addOne(Student student);
}
