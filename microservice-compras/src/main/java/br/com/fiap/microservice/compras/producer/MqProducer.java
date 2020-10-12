package br.com.fiap.microservice.compras.producer;

import br.com.fiap.microservice.compras.dto.CompraDTO;
import br.com.fiap.microservice.compras.model.Compra;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MqProducer {

    private final RabbitTemplate template;

    public MqProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(Compra compra) throws JsonProcessingException {
        template.convertAndSend(new ObjectMapper().writeValueAsString(compra));
    }
}
