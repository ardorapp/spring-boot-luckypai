package cash.pai.lucky.service.impl;

import cash.pai.lucky.BaseTest;
import cash.pai.lucky.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class MailServiceImplTest extends BaseTest {

    @Autowired
    MailService mailService;

    @Test
    public void sendHtmlMail() {
    }
}