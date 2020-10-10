package br.com.fiap.microservice.compras.controller;

import br.com.fiap.microservice.compras.model.Msg;
import br.com.fiap.microservice.compras.producer.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Msg> sendToMq(@RequestBody Msg compra) {
        producer.sendMessage(compra);
        return new ResponseEntity<Msg>(HttpStatus.OK);
    }
}
