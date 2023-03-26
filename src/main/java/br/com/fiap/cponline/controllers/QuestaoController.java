package br.com.fiap.cponline.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cponline.models.Questao;
import br.com.fiap.cponline.repository.QuestaoRepository;

@RestController
@RequestMapping("/api/Questao/")

public class QuestaoController {
    Logger log = LoggerFactory.getLogger(QuestaoController.class);

    @Autowired
    QuestaoRepository repository;

    @PostMapping
    public ResponseEntity<Questao> create(@RequestBody Questao questao) {
        log.info("Cadastrar Questão" + questao);

        int idCadastrado = repository.save(questao).getId();

        questao.setId(idCadastrado);

        return ResponseEntity.status(HttpStatus.CREATED).body(questao);
    }

    @GetMapping("{id}")
    public ResponseEntity<Questao> show(@PathVariable int id) {
        log.info("buscar questão" + id);

        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(busca.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Questao> destroy(@PathVariable int id) {
        log.info("buscar questão" + id);

        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(busca.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Questao> update(@PathVariable int id, @RequestBody Questao questao) {
        log.info("Atualizar questão" + id);
        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        questao.setId(id);
        repository.save(questao);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(questao);
    }

}
