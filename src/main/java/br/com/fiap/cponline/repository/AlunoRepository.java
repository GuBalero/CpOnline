package br.com.fiap.cponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cponline.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
