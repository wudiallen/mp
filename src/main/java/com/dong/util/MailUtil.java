package com.dong.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Date;

/**
 * @author songchao
 * @date 2021/6/30 21:02
 */
public class MailUtil {

    public static void send(String mail,String message){
        JavaMailSenderImpl JavaMailSenderImpl =new JavaMailSenderImpl();
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        //设置标题
        mailMessage.setSubject("注册验证码");
        //内容
        mailMessage.setText(message);
        //指定发送时间
        mailMessage.setSentDate(new Date());
        mailMessage.setFrom("dsc0306@163.com");
        mailMessage.setTo(mail);
        JavaMailSenderImpl.send(mailMessage);
    }
}
