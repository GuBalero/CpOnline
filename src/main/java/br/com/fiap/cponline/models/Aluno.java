package br.com.fiap.cponline.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @Pattern(regexp = "[0-9]*8")
    @NotBlank
    private String senha;
    @NotNull
    @NotBlank
    private String instituicao;

    public Aluno() {

    }

    public Aluno(int id, String nome, String email, String senha, String instituicao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.instituicao = instituicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", instituicao="
                + instituicao + "]";
    }

}
