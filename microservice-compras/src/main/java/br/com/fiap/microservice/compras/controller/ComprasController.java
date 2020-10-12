package br.com.fiap.microservice.compras.controller;

import br.com.fiap.microservice.compras.dto.CompraDTO;
import br.com.fiap.microservice.compras.model.Compra;
import br.com.fiap.microservice.compras.producer.MqProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    private final MqProducer producer;

    public ComprasController(MqProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    @Operation(description = "Cadastro de nova compra e envio ao RabbitMq")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "ok"),
                    @ApiResponse(responseCode = "400", description = "objeto.invalido"),
            }
    )
    public ResponseEntity<Compra> sendToMq(@RequestBody CompraDTO compraDTO) {
        Compra compra = new Compra(compraDTO);
        try {
            producer.sendMessage(compra);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<Compra>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Compra>(compra, HttpStatus.OK);
    }
}
