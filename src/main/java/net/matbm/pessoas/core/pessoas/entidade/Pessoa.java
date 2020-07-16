package net.matbm.pessoas.core.pessoas.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Representa a entidade pessoa.
 */
@Data
@NoArgsConstructor
public class Pessoa {
    private String nome;
    private Sexo sexo;
    private String email;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
}
