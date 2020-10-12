package br.com.fiap.microservice.compras.controller;

import br.com.fiap.microservice.compras.dto.CompraDTO;
import br.com.fiap.microservice.compras.model.Compra;
import br.com.fiap.microservice.compras.producer.RabbitMqProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    private final RabbitMqProducer producer;

    public ComprasController(RabbitMqProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<Compra> sendToMq(@RequestBody CompraDTO compraDTO) {
        Compra compra = null;
        try {
            compra = producer.sendMessage(compraDTO);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<Compra>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Compra>(compra, HttpStatus.OK);
    }
}
