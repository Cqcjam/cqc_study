//package com.cqc.learning.spring.springboot.email;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.lang.Nullable;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.mail.Authenticator;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.util.Properties;
//
///**
// * @author caoqingcong
// * @projectName cqc_study
// * @packageName com.cqc.learning.spring.springboot.email
// * @date 2020/5/25-22:16
// */
//@Component
//public class EmailTemplate implements InitializingBean {
//
//        Logger logger = LoggerFactory.getLogger(EmailTemplate.class);
//        //邮箱名称
//        String email;
//        @Autowired
//        Environment environment;
//        //邮箱密码
//        @Nullable
//        String password;
//        //smtp地址
//        String smtp;
//        //会话
//        Session session;
//        @Resource
//        private JavaMailSender mailSender;
//
//        /**
//         * 发送带附件内容
//         * @param to
//         * @param subject
//         * @param content
//         * @param filePath
//         */
//        public void sendAttachmentsMail(String to, String subject, String content, String filePath){
//            MimeMessage message = mailSender.createMimeMessage();
//            try {
//                MimeMessageHelper helper = new MimeMessageHelper(message, true);
//                helper.setFrom("it_purchase@service.cqc.com");
//                helper.setTo(to);
//                helper.setSubject(subject);
//                helper.setText(content, true);
//                FileSystemResource file = new FileSystemResource(new File(filePath));
//                String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
//                helper.addAttachment(fileName, file);
//                mailSender.send(message);
//                logger.info("带附件的邮件已经发送。");
//            } catch (MessagingException e) {
//                logger.error("发送带附件的邮件时发生异常！", e);
//            }
//        }
//
//        @Override
//        public void afterPropertiesSet() throws Exception {
//            // 读取环境数值
//            this.smtp = environment.getProperty("spring.mail.host");
//            this.email = environment.getProperty("spring.mail.username");
//            this.password = environment.getProperty("spring.mail.password");
//
//            // 初始化props
//            Properties props = new Properties();
//            Authenticator authenticator = null;
//            if (email != null && password != null) {
//                authenticator = new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(email, password);
//                    }
//                };
//            }
//            props.put("mail.smtp.auth", authenticator == null ? "false" : "true");
//            props.put("mail.smtp.host", smtp);
//            // 创建session
//            session = Session.getInstance(props, authenticator);
//        }
//
//}
