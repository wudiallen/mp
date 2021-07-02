package com.dong;

import com.dong.entity.Student;
import com.dong.entity.Teacher;
import com.dong.mapper.StudentMapper;
import com.dong.service.StudentService;
import com.dong.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songchao
 * @date 2021/6/30 22:50
 */
@SpringBootTest
public class test {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Test
    void  test(){
        Student student = new Student();
        student.setSid("9feed4dde278bd7970e3419b7471a21d");
        student.setSname("hani");
        studentService.updateById(student);
    }

    @Test
    void  query(){
        Map<String,Object> map = new HashMap();
        map.put("flag",0 );
        List<Teacher> teachers = teacherService.listByMap(map);
        teachers.forEach(System.out::println);
    }

    @Test
    void send() throws MessagingException {

    }
}
