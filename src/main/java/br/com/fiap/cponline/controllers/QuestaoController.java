package br.com.fiap.cponline.controllers;

import java.util.List;

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

import br.com.fiap.cponline.exceptions.RestNotFoundException;
import br.com.fiap.cponline.models.Questao;
import br.com.fiap.cponline.repository.QuestaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/questao/")

public class QuestaoController {
    Logger log = LoggerFactory.getLogger(QuestaoController.class);

    @Autowired
    QuestaoRepository repository;

    @GetMapping
    public List<Questao> index() {
        return repository.findAll();

    }

    @PostMapping
    public ResponseEntity<Questao> create(@RequestBody @Valid Questao questao) {
        log.info("Cadastrar Questão" + questao);

        int idCadastrado = repository.save(questao).getId();

        questao.setId(idCadastrado);

        return ResponseEntity.status(HttpStatus.CREATED).body(questao);
    }

    @GetMapping("{id}")
    public ResponseEntity<Questao> show(@PathVariable int id) {
        log.info("buscar questão" + id);

        var questao = repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Prova não encontrado"));

        return ResponseEntity.ok(questao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Questao> destroy(@PathVariable int id) {
        log.info("Apagar questão" + id);

        var questao = repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Questão não encontrado"));

        repository.delete(questao);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Questao> update(@PathVariable int id, @RequestBody @Valid Questao questao) {
        log.info("Atualizar questão" + id);

        repository.findById(id).orElseThrow(() -> new RestNotFoundException("Questão não encontrado"));

        questao.setId(id);
        repository.save(questao);

        return ResponseEntity.ok(questao);
    }

}
