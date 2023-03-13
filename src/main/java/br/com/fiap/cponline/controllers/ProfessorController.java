package br.com.fiap.cponline.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {
    
    @PostMapping("/api/professor")
    @ResponseBody
    public String cadastrar() {
        return "teste controller";
    }

}
