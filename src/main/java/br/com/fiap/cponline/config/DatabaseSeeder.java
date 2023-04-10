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
            
    new Questao(1,new String("Qual o valor da Soma de 2 + 2"),new String("2"),new String("4"),
    new String("5"),new String("6"),new String("7"),new String("2"),
    
    new Questao(2,new String("Qual o valor da Soma de 2 + 5"),new String("2"),new String("4"),
    new String("5"),new String("6"),new String("7"),new String("7"),
   
    new Questao(3,new String("Qual o valor da Soma de 3 + 3"),new String("2"),new String("4"),
    new String("5"),new String("6"),new String("7"),new String("6")
    ));

    
    }

}
