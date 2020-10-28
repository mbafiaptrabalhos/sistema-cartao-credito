package br.com.fiap.batchcargaalunos.writer;

import br.com.fiap.batchcargaalunos.dominio.Aluno;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Configuration
public class EscritaListaAlunosWriterConfig {

//    @Bean
//    public ItemWriter<Aluno> escritaListaAlunosWriter() {
//        //return items -> items.forEach(System.out::println);
//        return items -> items.forEach();
//    }
    @Bean
    public MongoItemWriter<Aluno> escritaListaAlunosWriter(MongoTemplate mongoTemplate) {
       return new MongoItemWriterBuilder<Aluno>().template(mongoTemplate).collection("aluno").build();
    }

}
