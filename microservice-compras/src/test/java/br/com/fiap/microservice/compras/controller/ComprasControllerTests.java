package br.com.fiap.microservice.compras.controller;

import br.com.fiap.microservice.compras.dto.CompraDTO;
import br.com.fiap.microservice.compras.model.Compra;
import br.com.fiap.microservice.compras.producer.MqProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ComprasControllerTests {

    @Test
    public void testCompraController() throws JsonProcessingException {

        MqProducer mqProducer = mock(MqProducer.class);
        ComprasController comprasController = new ComprasController(mqProducer);

        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setDescricao("teste");
        compraDTO.setRmAluno("0001");
        compraDTO.setValorCompra(BigDecimal.valueOf(39.90));

        ResponseEntity<Compra> compraResponseEntity = comprasController.sendToMq(compraDTO);
        verify(mqProducer).sendMessage(any(Compra.class));
        assertTrue(compraResponseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void testCompraControllerError() throws JsonProcessingException {

        MqProducer mqProducer = mock(MqProducer.class);
        ComprasController comprasController = new ComprasController(mqProducer);

        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setDescricao("teste");
        compraDTO.setRmAluno("0001");
        compraDTO.setValorCompra(BigDecimal.valueOf(39.90));

        doThrow(JsonProcessingException.class).when(mqProducer).sendMessage(any());
        ResponseEntity<Compra> compraResponseEntity = comprasController.sendToMq(compraDTO);
        verify(mqProducer).sendMessage(any(Compra.class));
        assertTrue(compraResponseEntity.getStatusCode() == HttpStatus.BAD_REQUEST);
    }
}
