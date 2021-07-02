package com.dong.controller;


import com.dong.entity.ResponseVo;
import com.dong.entity.Student;
import com.dong.entity.Teacher;
import com.dong.service.TeacherService;
import com.dong.service.impl.MsmServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songchao
 * @since 2021-06-30
 */
@Controller
@Api(tags = "教师相关功能")
@RequestMapping("/teacher")
public class TeacherController  {

    @Autowired
    private MsmServiceImpl msmService;
    @Autowired
    private TeacherService teacherService;


    //跳转至注册
    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }

    //注册
    @PostMapping("/register")
    @ResponseBody
    @ApiOperation("教师注册")
    @ApiImplicitParam(name = "teacher",value = "注册的教师信息")
    public ResponseVo<String> register(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        return new ResponseVo<>("注册完成，请进入邮箱完成激活",200,save+"将会在五分钟内发送短信至邮箱");
    }

    @GetMapping("/sendEmail")
    @ResponseBody
    @ApiOperation("发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email",value = "邮箱信息"),
            @ApiImplicitParam(name = "id",value = "注册的教师id")
    })
    public ResponseVo<String> sentEmail(String email, Integer id) throws MessagingException, InterruptedException {
        Boolean send = msmService.send(email, id);
        return new ResponseVo<>("激活",200,null);


    }

    @GetMapping("/active/{tid}")
    @ResponseBody
    @ApiOperation("激活的教师id")
    public ResponseVo<Boolean> jihuo(@PathVariable("tid") Integer tid) throws MessagingException {
        Teacher tea = teacherService.getById(tid);
        tea.setFlag(1);
        boolean b = teacherService.updateById(tea);
        return new ResponseVo<>("激活",200,b);
    }

}
