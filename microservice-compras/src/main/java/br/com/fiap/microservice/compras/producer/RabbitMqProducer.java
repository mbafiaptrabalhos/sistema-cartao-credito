package br.com.fiap.microservice.compras.producer;

import br.com.fiap.microservice.compras.model.Msg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProducer {

    private final RabbitTemplate template;

    public RabbitMqProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(Msg compra) {
        System.out.println("Salvando");
        template.convertAndSend(compra);
    }
}
