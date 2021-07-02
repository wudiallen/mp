package com.dong.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@EnableAsync
public class MsmServiceImpl  {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;
    @Async
    public Boolean send(String email, Integer id)  {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            Thread.sleep(1000*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(email)){
            return false;
        }
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper= null;
        try {
            helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(username);
            helper.setTo(email);
            helper.setSubject("激活账号");
            helper.setText("<a href='http://192.168.211.156:8080/emall/jihuo/"+id+"'>激活 </a>",true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        mailSender.send(mimeMessage);
        logger.info("邮件发送成功");
        return true;
    }
}