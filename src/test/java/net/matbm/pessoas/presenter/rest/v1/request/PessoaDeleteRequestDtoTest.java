package net.matbm.pessoas.presenter.rest.v1.request;

import net.matbm.pessoas.util.DtoTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaDeleteRequestDtoTest extends DtoTest<PessoaDeleteRequest> {

    @Test
    @DisplayName("Deve validar cpf")
    public void validaCpf() {
        shouldFailValidation(d -> d.setCpf(""));
        shouldPassValidation(d -> d.setCpf("12345678909"));
        shouldFailValidation(d -> d.setCpf("123.456.789-09"));
        shouldFailValidation(d -> d.setCpf("12345678908"));
    }

    @Override
    public PessoaDeleteRequest validDto() {
        var pessoa = new PessoaDeleteRequest();
        pessoa.setCpf("12345678909");
        return pessoa;
    }
}
