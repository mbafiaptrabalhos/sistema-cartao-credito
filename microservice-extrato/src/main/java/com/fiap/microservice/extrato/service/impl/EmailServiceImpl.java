package com.fiap.microservice.extrato.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fiap.microservice.extrato.service.EmailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Value(value = "${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private Session javaMailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {

            Message message = new MimeMessage(javaMailSender);
            message.setFrom(new InternetAddress(fromEmail));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
