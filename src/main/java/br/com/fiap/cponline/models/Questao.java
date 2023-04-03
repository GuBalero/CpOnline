package br.com.fiap.cponline.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2000)
    private String enunciado;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2000)
    private String alternativaA;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2000)
    private String alternativaB;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2000)
    private String alternativaC;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2000)
    private String alternativaD;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2000)
    private String alternativaE;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 2000)
    private String alternativaCorreta;

    public Questao() {

    }

    public Questao(int id, String enunciado, String alternativaA, String alternativaB, String alternativaC,
            String alternativaD, String alternativaE, String alternativaCorreta) {
        this.id = id;
        this.enunciado = enunciado;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.alternativaE = alternativaE;
        this.alternativaCorreta = alternativaCorreta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    @Override
    public String toString() {
        return "Questao [id=" + id + ", enunciado=" + enunciado + ", alternativaA=" + alternativaA + ", alternativaB="
                + alternativaB + ", alternativaC=" + alternativaC + ", alternativaD=" + alternativaD + ", alternativaE="
                + alternativaE + ", alternativaCorreta=" + alternativaCorreta + "]";
    }

}
