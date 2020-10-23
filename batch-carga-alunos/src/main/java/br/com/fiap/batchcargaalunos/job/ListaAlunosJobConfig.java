package br.com.fiap.batchcargaalunos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ListaAlunosJobConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivoListaAlunoJob(Step leituraArquivoListaAlunoStep) {
        return jobBuilderFactory
                .get("arquivoListaAlunoJob")
                .start(leituraArquivoListaAlunoStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
