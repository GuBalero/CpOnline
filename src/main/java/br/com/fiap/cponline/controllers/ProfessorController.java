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

import br.com.fiap.cponline.models.Professor;
import br.com.fiap.cponline.repository.ProfessorRepository;

@RestController
@RequestMapping("/api/professor/")
public class ProfessorController {

    Logger log = LoggerFactory.getLogger(ProfessorController.class);

    @Autowired
    ProfessorRepository repository;

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        log.info("Cadastrando o Professor" + professor);
        
        int idCadastrado = repository.save(professor).getId();

        professor.setId(idCadastrado);

        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Professor> show(@PathVariable int id) {
        log.info("buscar o Professor" + id);

        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(busca.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Professor> destroy(@PathVariable int id) {
        log.info("buscar o Professor" + id);

        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(busca.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Professor> update(@PathVariable int id, @RequestBody Professor professor) {
        log.info("Atualizando Professor" + id);
        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        professor.setId(id);
        repository.save(professor);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(professor);
    }
}