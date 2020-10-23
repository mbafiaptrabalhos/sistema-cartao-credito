package br.com.fiap.batchcargaalunos.step;

import br.com.fiap.batchcargaalunos.dominio.Aluno;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListaAlunosJobStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    Step arquivoListaAlunoStep(ItemReader<Aluno> leituraListaAlunosReader, ItemWriter<Aluno> leituraAlunosWriter) {
        return stepBuilderFactory
                .get("arquivoListaAlunoStep")
                .<Aluno, Aluno>chunk(1)
                .reader(leituraListaAlunosReader)
                .writer(leituraAlunosWriter)
                .build();
    }
}
