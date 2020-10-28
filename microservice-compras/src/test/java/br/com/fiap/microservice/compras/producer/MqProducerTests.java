package br.com.fiap.microservice.compras.producer;

import br.com.fiap.microservice.compras.model.Compra;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MqProducerTests {

    @Test
    public void testProducer() throws JsonProcessingException {
        RabbitTemplate rabbitTemplate = mock(RabbitTemplate.class);
        MqProducer mqProducer = new MqProducer(rabbitTemplate);

        Compra compra = new Compra();
        compra.setData(LocalDateTime.now().toString());
        compra.setDescricao("teste");
        compra.setRmAluno("0001");
        compra.setValorCompra(BigDecimal.valueOf(39.90));

        mqProducer.sendMessage(compra);
        verify(rabbitTemplate).convertAndSend(new ObjectMapper().writeValueAsString(compra));
    }

}
