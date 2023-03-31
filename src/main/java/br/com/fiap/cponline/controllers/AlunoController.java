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

import br.com.fiap.cponline.exceptions.RestNotFoundException;
import br.com.fiap.cponline.models.Aluno;
import br.com.fiap.cponline.repository.AlunoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluno/")
public class AlunoController {

    Logger log = LoggerFactory.getLogger(AlunoController.class);

    @Autowired
    AlunoRepository repository;

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody @Valid Aluno aluno) {
        log.info("Cadastrando o Aluno" + aluno);

        int idCadastrado = repository.save(aluno).getId();

        aluno.setId(idCadastrado);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> show(@PathVariable int id) {
        log.info("buscar o Aluno" + id);

        var aluno = repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Aluno não encontrado"));

        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Aluno> destroy(@PathVariable int id) {
        log.info("buscar o Aluno" + id);

        var aluno = repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Aluno não encontrado"));

        repository.delete(aluno);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Aluno> update(@PathVariable int id, @RequestBody Aluno aluno) {
        log.info("Atualizando Aluno" + id);

        repository.findById(id).orElseThrow(() -> new RestNotFoundException("Aluno não encontrado"));

        aluno.setId(id);
        repository.save(aluno);

        return ResponseEntity.ok(aluno);
    }
}
