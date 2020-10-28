package com.fiap.microservice.extrato;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.microservice.extrato.dto.ExtratoDTO;
import com.fiap.microservice.extrato.model.Aluno;
import com.fiap.microservice.extrato.service.AlunoService;
import com.fiap.microservice.extrato.service.EmailService;
import com.fiap.microservice.extrato.service.ExtratoService;

import ch.qos.logback.core.status.Status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExtratoApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExtratoService extratoService;
    
	@Test
	void case1() throws Exception {
		
		String id = "1111";
		String email = "mbafiap@hotmail.com";
		String rmAluno = "1111";
		String descricao = "teste";
		String data = "";
		BigDecimal valorCompra = BigDecimal.valueOf(100);

		ExtratoDTO extrato = new ExtratoDTO(id, email, rmAluno, descricao, data, valorCompra);

		mockMvc.perform(get("/extrato/1111/mbafiap@hotmail.com")
				.contentType("application/json")
				.content(""))
				.andExpect(status().isOk());
		
	}

}
