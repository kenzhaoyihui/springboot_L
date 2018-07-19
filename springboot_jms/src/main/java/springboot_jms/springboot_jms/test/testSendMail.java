package springboot_jms.springboot_jms.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.standard.expression.MessageExpression;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testSendMail {

    @Autowired
    private JavaMailSenderImpl mailSender;

    /**
     * Send the simple text mail
     */
    @Test
    public void sendTextMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(new String[] {"2993614148@qq.com"});
        simpleMailMessage.setFrom("yzhao@redhat.com");
        simpleMailMessage.setSubject("Test send mail");
        simpleMailMessage.setText("Hello !");

        mailSender.send(simpleMailMessage);
        System.out.println("Email is sended!");
    }


    /**
     * Send the HTML mail
     */
    @Test
    public void sendHtmlMail() {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>Springboot Html test</h1><p>Hello yzhao, this is the spring boot test mail</p></body>");
        sb.append("</html>");
        try {
            mimeMessageHelper.setTo("2993614148@qq.com");
            mimeMessageHelper.setFrom("yzhao@redhat.com");
            mimeMessageHelper.setSubject("Springboot Html mail");
            mimeMessageHelper.setText(sb.toString(), true);

            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            e.printStackTrace();
        }

        System.out.println("Mail is sended");



    }


    /**
     * Send the contained the pictures mail
     */
    @Test
    public void sendAttachedImageMail() throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //multipart model
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo("2993614148@qq.com");
        mimeMessageHelper.setFrom("yzhao@redhat.com");
        mimeMessageHelper.setCc("yzhao@redhat.com");
        mimeMessageHelper.setSubject("SpringBoot Image Mail Test");

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body><h1>Springboot testing Image Mail</h1><p>Hello! this is the spring boot Image Mail</p>");

        // cid为固定写法，imageId指定一个标识
        sb.append("<img src=\"cid: imageId\"/></body>");
        sb.append("</html>");

        // 启用html
        mimeMessageHelper.setText(sb.toString(), true);

        // 设置imageId
        FileSystemResource img = new FileSystemResource(new File("/home/yzhao_sherry/Pictures/apidoc.png"));
        mimeMessageHelper.addInline("imageId", img);

        mailSender.send(mimeMessage);
        System.out.println("Image Mail is sended");

    }


    /**
     * Send the contained attachment mail
     *
     */
    @Test
    public void sendAttachmentMail() throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        mimeMessageHelper.setTo("2993614148@qq.com");
        mimeMessageHelper.setFrom("yzhao@redhat.com");
        mimeMessageHelper.setCc("yzhao@redhat.com");
        mimeMessageHelper.setSubject("Spring boot Attachment Testing");

        StringBuilder sb = new StringBuilder();

        sb.append("<html><head></head>");
        sb.append("<body><h1>Spring boot Attachment Testing mail</h1> <p>Hello, Test the spring boot Attachment Mail</p></body>");
        sb.append("</html>");

        mimeMessageHelper.setText(sb.toString(), true);

        //Attachments
        FileSystemResource file = new FileSystemResource(new File("/home/yzhao_sherry/1.txt"));
        mimeMessageHelper.addAttachment("springboot.txt", file);

        mailSender.send(mimeMessage);
        System.out.println("Attachment Mail is sended");


    }
}
