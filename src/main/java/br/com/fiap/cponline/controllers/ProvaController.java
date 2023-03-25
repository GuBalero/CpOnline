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

import br.com.fiap.cponline.models.Prova;
import br.com.fiap.cponline.repository.ProvaRepository;

@RestController
@RequestMapping("/api/Prova/")

public class ProvaController {

    Logger log = LoggerFactory.getLogger(ProvaController.class);

    @Autowired
    ProvaRepository repository;

    @PostMapping
    public ResponseEntity<Prova> create(@RequestBody Prova prova) {
        log.info("Cadastrando a Prova" + prova);

        int idCadastrado = repository.save(prova).getId();

        prova.setId(idCadastrado);

        return ResponseEntity.status(HttpStatus.CREATED).body(prova);
    }

    @GetMapping("{id}")
    public ResponseEntity<Prova> show(@PathVariable int id) {
        log.info("buscar a Prova" + id);

        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(busca.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Prova> destroy(@PathVariable int id) {
        log.info("buscar a Prova" + id);

        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(busca.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Prova> update(@PathVariable int id, @RequestBody Prova prova) {
        log.info("Atualizando Prova" + id);
        var busca = repository.findById(id);

        if (busca.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        prova.setId(id);
        repository.save(prova);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(prova);
    }

}