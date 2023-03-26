package br.com.fiap.cponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cponline.models.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

}
