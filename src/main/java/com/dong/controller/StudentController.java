package com.dong.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.entity.ResponseVo;
import com.dong.entity.Student;
import com.dong.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author songchao
 * @since 2021-06-30
 */
@Controller
@Api(tags = "学生相关功能")
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //添加
    @PostMapping("/student")
    @ResponseBody
    @ApiOperation("添加学生")
    @ApiImplicitParam(name = "student" ,value = "添加的学生")
    public  ResponseVo<String> add(@RequestBody  Student student){
        Integer integer = studentService.addOne(student);
        return new ResponseVo<>(integer==1?"添加成功":"添加失败",200,null);
    }

    //删除
    @DeleteMapping("/student/{sid}")
    @ResponseBody
    @ApiOperation("删除学生")
    public ResponseVo<String> delete(@PathVariable("sid") String sid){
        boolean b = studentService.removeById(sid);
        return new ResponseVo<>(b==true?"删除成功":"删除失败",200,null);
    }
    //改
    @PostMapping("/student/update")
    @ResponseBody
    @ApiOperation("修改学生")
    public  ResponseVo<String> update(Student student){
        boolean b = studentService.saveOrUpdate(student);
       // boolean b = studentService.updateById(student);
        return new ResponseVo<>(b==true?"修改成功":"修改失败",200,null);
    }
    //查全部
    @GetMapping("/student")
    @ResponseBody
    @ApiOperation("分页查找全部")
    @ApiImplicitParam(name = "pageNum" ,value ="页数",required = true)
    public ResponseVo<List<Student>> getAll(Integer pageNum){
        Page<Student> page = new Page<>(pageNum,5);
        List<Student> studentList = studentService.page(page).getRecords();
        return new ResponseVo<>("查找全部成功",200,studentList);
    }
    //查一个
    @GetMapping("/student/{sid}")
    @ResponseBody
    @ApiOperation("查找一个学生")
    public ResponseVo<Student> getOne(@PathVariable("sid") String sid){
        Student student = studentService.getById(sid);
        return new ResponseVo<>("查找一个成功",200,student);
    }
}
