package ru.kpfu.itis.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendMail {

    public void send(String emailRecipient) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
        MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail(emailRecipient,
                "shopappmail.semestr@gmail.com",
                "shop-app",
                "Testing only \n\n Hello Spring Email Sender");
    }

}
