package com.javatechie.rabbitmq.demo.consumer;

import com.javatechie.rabbitmq.demo.config.MessagingConfig;
import com.javatechie.rabbitmq.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class User {

    @Autowired
    private JavaMailSender javaMailSender;

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);

        String emailTo = orderStatus.getVehical().getEmail();
        System.out.println("Sending email");
        sendEmail(emailTo);
        System.out.println("Done bro");
    }

    void sendEmail(String emailTo){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("satyam.tiwari@cloverbaytechnologies.com");
        msg.setTo(emailTo);

        msg.setSubject("Testing from Spring Boot");
        msg.setText("https://in.event.mi.com/in/xiaomi-fan-festival-2023");
        javaMailSender.send(msg);
    }
}
