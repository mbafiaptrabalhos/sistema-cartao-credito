package br.com.fiap.microservice.compras;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MicroserviceComprasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceComprasApplication.class, args);
    }

}
