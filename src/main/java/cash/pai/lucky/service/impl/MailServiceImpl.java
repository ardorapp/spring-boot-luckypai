package cash.pai.lucky.service.impl;

import cash.pai.lucky.admin.util.VerifyCodeImageUtil;
import cash.pai.lucky.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.MessageFormat;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    @Autowired(required = false)
    private JavaMailSender mailSender;
    /**
     * 配置文件中我的qq邮箱
     */
    @Value("${spring.mail.from}")
    private String from;

    //TODO 先写死host ，等有域名再改过来
    private final String host = "http:127.0.0.1/";


    /**
     * 发送HTML邮件
     *
     * @param to 收件者
     */
    @Override
    public void sendActiveMail(String to, String checkCode, String username) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setSubject("尊敬的用户" + username + ",您好，请在十分钟内点击邮件中的链接，以激活您的账号。超市验证码会失效，需要重新获取。");
            helper.setTo(to);
            String content = "<a href=\"http://127.0.0.1:8080/user/asset/checkCode?checkCode="+checkCode+"\">激活请点击:"+checkCode+"</a>";
            helper.setText(content, true);
            mailSender.send(message);
            log.info("邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！", e);
        }
    }
}
