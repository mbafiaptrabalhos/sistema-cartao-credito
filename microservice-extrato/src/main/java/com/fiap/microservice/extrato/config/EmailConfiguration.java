package com.fiap.microservice.extrato.config;

import javax.mail.Session;
import javax.mail.PasswordAuthentication;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {

    @Value(value = "${spring.mail.host}")
    private String host;

    @Value(value = "${spring.mail.port}")
    private String port;

    @Value(value = "${spring.mail.username}")
    private String username;

    @Value(value = "${spring.mail.password}")
    private String password;

    @Bean
    public Session getJavaMailSender() {
        Session session;

        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Hotmail */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(username, password);
                    }
                });

        /** Ativa Debug para sessão */
        session.setDebug(true);
        return session;
    }
}
