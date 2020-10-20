package br.com.fiao.microservice.autorizadora.autorizadora;

import java.math.BigDecimal;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.fiao.microservice.autorizadora.config.ConfigRabbit;
import br.com.fiao.microservice.autorizadora.entity.Compra;
import br.com.fiao.microservice.autorizadora.service.IEautorizadoraService;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = IEautorizadoraService.class)
public class AutorizadoraApplication implements CommandLineRunner {

	@Autowired
	public IEautorizadoraService service;

	public static void main(String[] args) {
		SpringApplication.run(AutorizadoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RabbitTemplate template = new RabbitTemplate(ConfigRabbit.getConnection());

		while (true) {
			try {
				/* rabbitMQ [INICIO] */
				byte[] body = template.receive("compras").getBody();

				JsonObject jsonObject = new JsonParser().parse(new String(body)).getAsJsonObject();

				Compra compra = new Compra();
				compra.setRmAluno(jsonObject.get("rmAluno").toString().replaceAll("\"", ""));
				compra.setDescricao(jsonObject.get("descricao").toString().replaceAll("\"", ""));
				compra.setValorCompra(new BigDecimal(jsonObject.get("valorCompra").toString()));
				compra.setData(jsonObject.get("data").toString().replaceAll("\"", ""));
				/* rabbitMQ [FIM] */
				
				/* mongoDB */
				service.save(compra);
			} catch (NullPointerException ex) {
				System.out.println("Não tem mais registros.");
				break;
			}
		}

	}
}
