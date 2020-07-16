package net.matbm.pessoas.presenter.rest.v1.request;

import net.matbm.pessoas.util.DtoTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaRequestDtoTest extends DtoTest<PessoaRequest> {

    @Test
    @DisplayName("Deve validar fields obrigatórias")
    public void fieldsObrigatorias() {
        shouldFailWhenEmpty(dto::setNome);
        shouldFailWhenEmpty(dto::setNome);
        shouldFailValidation(d -> d.setDataNascimento(null));
    }

    @Test
    @DisplayName("Deve validar sexo")
    public void validaSexo() {
        shouldPassValidation(d -> d.setSexo(null));
        shouldPassValidation(d -> d.setSexo("f"));
        shouldPassValidation(d -> d.setSexo("F"));
        shouldFailValidation(d -> d.setSexo(""));
        shouldFailValidation(d -> d.setSexo("A"));
    }

    @Test
    @DisplayName("Deve validar email")
    public void validaEmail() {
        shouldPassValidation(d -> d.setEmail(null));
        shouldFailValidation(d -> d.setEmail("teste@"));
        shouldFailValidation(d -> d.setEmail("@teste"));
    }

    @Test
    @DisplayName("Deve validar cpf")
    public void validaCpf() {
        shouldFailValidation(d -> d.setCpf(""));
        shouldPassValidation(d -> d.setCpf("12345678909"));
        shouldFailValidation(d -> d.setCpf("123.456.789-09"));
        shouldFailValidation(d -> d.setCpf("12345678908"));
    }

    @Override
    public PessoaRequest validDto() {
        var pessoa = new PessoaRequest();
        pessoa.setCpf("12345678909");
        pessoa.setDataNascimento(LocalDate.of(1999, 1, 22));
        pessoa.setNome("Mercer");
        pessoa.setEmail("contato@matbm.net");
        pessoa.setNacionalidade("Brasileira");
        pessoa.setNaturalidade("Londrinense");
        pessoa.setSexo("m");
        return pessoa;
    }
}
