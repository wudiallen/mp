package com.dong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dong.entity.Student;
import com.dong.exception.StudentException;
import com.dong.mapper.StudentMapper;
import com.dong.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songchao
 * @since 2021-06-30
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Integer addOne(Student student) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sname",student.getSname());
        Student s = studentMapper.selectOne(queryWrapper);
        if (!Objects.isNull(s)){
            throw new StudentException("学生名已存在");
        }
        int insert = studentMapper.insert(student);
        return insert;
    }
}
