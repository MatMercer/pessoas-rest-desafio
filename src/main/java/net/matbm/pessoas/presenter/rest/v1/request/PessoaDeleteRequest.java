package net.matbm.pessoas.presenter.rest.v1.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PessoaDeleteRequest {
    @CPF
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;
}
