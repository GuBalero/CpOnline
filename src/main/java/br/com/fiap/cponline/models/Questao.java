package br.com.fiap.cponline.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Questao [id=" + id + ", enunciado=" + enunciado + ", alternativaA=" + alternativaA + ", alternativaB="
                + alternativaB + ", alternativaC=" + alternativaC + ", alternativaD=" + alternativaD + ", alternativaE="
                + alternativaE + ", alternativaCorreta=" + alternativaCorreta + "]";
    }

    public Questao(int i, String string, String string2, String string3, String string4, String string5, String string6,
            String string7, Questao questao) {
    }

    public Questao(int i, String string, String string2, String string3, String string4, String string5, String string6,
            String string7) {
    }

}
