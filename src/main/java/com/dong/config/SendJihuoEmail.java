package com.dong.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dong.entity.Teacher;
import com.dong.service.TeacherService;
import com.dong.service.impl.MsmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author songchao
 * @date 2021/7/1 14:51
 */
@Component
@EnableAsync
@EnableScheduling
public class SendJihuoEmail {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private MsmServiceImpl msmService;

    //每隔五分钟执行定时任务  给未激活的教师发送邮件
    @Scheduled(fixedDelay = 1000*60*5)
    @Async
    public Boolean sendEmail() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("flag",0 );
        List<Teacher> teachers = teacherService.list(queryWrapper);
        for (Teacher teacher:teachers) {
            Boolean send = msmService.send(teacher.getTemail(), teacher.getTid());
        }
        return true;
    }
}
