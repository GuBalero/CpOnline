package br.com.fiap.cponline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cponline.models.Professor;

@RestController
public class ProfessorController {

    Logger log = LoggerFactory.getLogger(ProfessorController.class);
    List<Professor> professores = new ArrayList<>();

    @PostMapping("/api/professor")
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        log.info("Cadastrando o Professor" + professor);
        
        professor.setId(professores.size() + 1);
        professores.add(professor);

        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    @GetMapping("/api/professor/{id}")
    public ResponseEntity<Professor> show(@PathVariable int id) {
        log.info("buscar o Professor" + id);
        var busca = professores.stream().filter(p -> p.getId() == id).findFirst();

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(busca.get());
    }

    @DeleteMapping("/api/professor/{id}")
    public ResponseEntity<Professor> destroy(@PathVariable int id) {
        log.info("buscar o Professor" + id);
        var busca = professores.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (busca == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        professores.remove(busca);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/professor/{id}")
    public ResponseEntity<Professor> update(@PathVariable int id, @RequestBody Professor professor) {
        log.info("Atualizando Professor" + id);
        var busca = professores.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (busca == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        professores.remove(busca);
        professor.setId(id);
        professores.add(professor);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(professor);
    }
}