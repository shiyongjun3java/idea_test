package com.atguigu.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads1() {
        //发送简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("邮件标题");//标题
        simpleMailMessage.setFrom("952919065@qq.com");//发件人
        simpleMailMessage.setText("你个老呆逼");
        simpleMailMessage.setTo("709569649@qq.com");
        mailSender.send(simpleMailMessage);
    }

    @Test
    public void contextLoads2() throws Exception{
        //发送复杂邮件
        //创建复杂邮件对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setSubject("邮件标题");//标题
        mimeMessageHelper.setFrom("952919065@qq.com");//发件人
        mimeMessageHelper.setText("<h3 style='color:red'>邮件内容helloworld</h3>",true);
        mimeMessageHelper.setTo("shiyongjun3java@163.com");
        //上传附件
        mimeMessageHelper.addAttachment("SpringBoot课件.pdf",new File("硬盘\\用户\\sunny\\文稿\\源码、资料、课件\\源码、资料、课件\\SpringBoot课件.pdf"));
        mailSender.send(mimeMessage);
    }

}
