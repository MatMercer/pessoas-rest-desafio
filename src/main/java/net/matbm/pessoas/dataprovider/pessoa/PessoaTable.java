package net.matbm.pessoas.dataprovider.pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.matbm.pessoas.core.pessoas.entidade.Sexo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PESSOAS")
@Data
@NoArgsConstructor
public class PessoaTable {
    @Id
    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "NOME", nullable = false, unique = true)
    private String nome;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "SEXO")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NATURALIDADE")
    private String naturalidade;

    @Column(name = "NACIONALIDADE")
    private String nacionalidade;
}
