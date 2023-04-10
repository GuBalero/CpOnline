package br.com.fiap.cponline.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @Size(min = 15, max = 2000)
    private String descricao;
    @NotNull
    @NotBlank
    @Size(min = 6, max = 500)
    private String urlAcesso;
    @NotNull
    private LocalDate data;
    private boolean ativo;

    @ManyToOne
    private Questao questao;

    @Override
    public String toString() {
        return "Prova [id=" + id + ", descricao=" + descricao + ", urlAcesso=" + urlAcesso + ", data=" + data
                + ", ativo=" + ativo + "]";
    }

}
