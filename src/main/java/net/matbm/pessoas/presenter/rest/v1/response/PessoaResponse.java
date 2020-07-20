package net.matbm.pessoas.presenter.rest.v1.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PessoaResponse {
    private String nome;
    private String sexo;
    private String email;
    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
}
