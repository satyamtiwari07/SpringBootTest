package com.example.realTemp.consumer;


import com.example.realTemp.config.MessageConfig;
import com.example.realTemp.entity.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Component

public class User {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) throws UnsupportedEncodingException, MessagingException {
        System.out.println("Message recieved from queue : " + orderStatus);


        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        String emailTo = orderStatus.getVehical().getDrivers().getEmail();

        sender.setHost("127.0.0.1");
        sender.setPort(1025);

        System.out.println("Sending email");
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(new InternetAddress("Satyam@local.com", "Satyam"));
        helper.setSubject("Registered Successfully!");
        helper.setTo(emailTo);
        helper.setText("Thank you for Registering!");

        sender.send(message);


//        String emailTo = orderStatus.getVehical().getVehicals().getEmail();
//        System.out.println("Sending email");
//        System.out.println(emailTo);
//        System.out.println("Inside sending email class");
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom("satyam.tiwari@cloverbaytechnologies.com");
//        msg.setTo(emailTo);
//        javaMailSender.send(msg);

        System.out.println("Done bro");
    }


}
