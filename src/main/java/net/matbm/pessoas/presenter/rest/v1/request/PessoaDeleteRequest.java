package net.matbm.pessoas.presenter.rest.v1.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class PessoaDeleteRequest {
    @CPF
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;
}
