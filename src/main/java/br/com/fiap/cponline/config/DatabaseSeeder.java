package br.com.fiap.cponline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.List;

import br.com.fiap.cponline.models.Questao;
import br.com.fiap.cponline.repository.QuestaoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    QuestaoRepository questaoRepository;

    @Override
    public void run(String... args) throws Exception {
        questaoRepository.saveAll(List.of(

                new Questao("Qual o valor da Soma de 2 + 2", "2", "4", "6", "8", "10", "4"),

                new Questao("Qual o valor da Soma de 4 + 4", "2", "4", "6", "8", "10", "8"),

                new Questao("Qual o valor da Soma de 3 + 3", "2", "4", "6", "8", "10", "6")));
    }

}
