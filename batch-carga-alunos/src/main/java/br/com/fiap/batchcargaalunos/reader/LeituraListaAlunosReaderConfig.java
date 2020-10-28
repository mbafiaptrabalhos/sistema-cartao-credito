package br.com.fiap.batchcargaalunos.reader;

import br.com.fiap.batchcargaalunos.dominio.Aluno;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraListaAlunosReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Aluno> leituraListaAlunosReader(
            @Value("#{jobParameters['listaAlunos']}") Resource listaAlunos
    ) {
        return new FlatFileItemReaderBuilder<Aluno>()
                .name("leituraListaAlunosReader")
                .resource(listaAlunos)
                .delimited().delimiter(";")
                .names(new String[] {"nome", "ra"})
                .targetType(Aluno.class)
                .build();
    }
}
