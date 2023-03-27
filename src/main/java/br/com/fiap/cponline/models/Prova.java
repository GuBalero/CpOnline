package br.com.fiap.cponline.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String urlAcesso;
    private LocalDate data;
    private boolean ativo;

    public Prova() {

    }

    public Prova(int id, String descricao, String urlAcesso, LocalDate data, boolean ativo) {
        this.id = id;
        this.descricao = descricao;
        this.urlAcesso = urlAcesso;
        this.data = data;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlAcesso() {
        return urlAcesso;
    }

    public void setUrlAcesso(String urlAcesso) {
        this.urlAcesso = urlAcesso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Prova [id=" + id + ", descricao=" + descricao + ", urlAcesso=" + urlAcesso + ", data=" + data
                + ", ativo=" + ativo + "]";
    }

}
