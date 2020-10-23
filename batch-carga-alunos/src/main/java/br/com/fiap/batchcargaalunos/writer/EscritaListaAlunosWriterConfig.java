package br.com.fiap.batchcargaalunos.writer;

import br.com.fiap.batchcargaalunos.dominio.Aluno;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EscritaListaAlunosWriterConfig {

    @Bean
    public ItemWriter<Aluno> escritaListaAlunosWriter() {
        return items -> items.forEach(System.out::println);
    }
}
