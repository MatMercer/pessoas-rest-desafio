package net.matbm.pessoas.core.pessoas.entidade;

import lombok.Data;

import java.time.LocalDate;

/**
 * Representa a entidade pessoa.
 */
@Data
public class Pessoa {
    private String nome;
    private Sexo sexo;
    private String email;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
}
