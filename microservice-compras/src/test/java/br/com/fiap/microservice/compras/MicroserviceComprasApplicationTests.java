package br.com.fiap.microservice.compras;

import br.com.fiap.microservice.compras.dto.CompraDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class MicroserviceComprasApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sendMessage() throws Exception {
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setDescricao("teste");
        compraDTO.setRmAluno("0001");
        compraDTO.setValorCompra(BigDecimal.valueOf(39.90));

        String json = new ObjectMapper().writeValueAsString(compraDTO);


        mockMvc.perform(MockMvcRequestBuilders.post("/compras")
                .content(json)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rmAluno", Matchers.is("0001")))
                .andExpect(jsonPath("$.valorCompra", Matchers.is(39.9)))
                .andExpect(jsonPath("$.descricao", Matchers.is("teste")));

    }

}
