package br.com.fiao.microservice.autorizadora.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class ConfigRabbit {
    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection(){

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory("toad.rmq.cloudamqp.com");
            connectionFactory.setUsername("ybsgdiwi");
            connectionFactory.setPassword("A7JEf0nsSC_3BbZb9ccgc14dMp0Iwxhc");
            connectionFactory.setVirtualHost("ybsgdiwi");
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}
