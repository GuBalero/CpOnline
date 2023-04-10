package br.com.fiap.cponline.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    @Override
    public String toString() {
        return "Professor [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", instituicao="
                + instituicao + "]";
    }

}
