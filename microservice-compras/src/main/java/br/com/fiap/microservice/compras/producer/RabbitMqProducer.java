package br.com.fiap.microservice.compras.producer;

import br.com.fiap.microservice.compras.dto.CompraDTO;
import br.com.fiap.microservice.compras.model.Compra;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProducer {

    private final RabbitTemplate template;

    public RabbitMqProducer(RabbitTemplate template) {
        this.template = template;
    }

    public Compra sendMessage(CompraDTO compraDTO) throws JsonProcessingException {
        Compra compra = new Compra(compraDTO);
        template.convertAndSend(new ObjectMapper().writeValueAsString(compra));
        return compra;
    }
}
