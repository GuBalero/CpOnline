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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cponline.models.Professor;

@RestController
public class ProfessorController {

        Logger log = LoggerFactory.getLogger(ProfessorController.class);
        List<Professor> professor = new ArrayList<>();

    


        @GetMapping("/api/professor")
        public List<Professor> index() {
            return professor;

        }
        
        @PostMapping("/api/professor")

        public ResponseEntity<Professor> create (@RequestBody Professor professor) {
            log.info("Cadastrando o Professor" + professor);
            professor.add(professor);
            return ResponseEntity.status(HttpStatus.CREATED).body(professor);
        }

        @GetMapping("/api/professor/{id}")

        public ResponseEntity<Professor> show(@PathVariable int id){
            log.info("buscar o Professor" + id);    
            var busca = professor.stream().filter(d -> d.getId().equals(id).findFirst());
            
            if (busca.isEmpty())

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            return ResponseEntity.ok(busca.get());
        }

        @DeleteMapping("/api/professor/{id}")

        public ResponseEntity<Professor> destroy(@PathVariable int id) {
            log.info("buscar o Professor" + id);
            var busca = professor.stream().filter(d -> d.getId().equals(id).findFirst());
            
            if (busca.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

                professor.remove(busca,get());
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        
        @PutMapping("/api/professor/{id}")

        public ResponseEntity<Professor> update(@PathVariable int id, @RequestBody Professor professor){
            log.info("Atualizando Professor" + id);
            var busca = professor.stream().filter(d -> d.getId().equals(id).findFirst());
            
            if (busca.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

                professor.remove(busca,get());
                professor.setId(id);
                professor.add(professor);
            
            return ResponseEntity.status(HttpStatus.OK).body(professor);
        }
    }

