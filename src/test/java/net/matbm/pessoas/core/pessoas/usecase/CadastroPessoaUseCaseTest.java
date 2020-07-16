package net.matbm.pessoas.core.pessoas.usecase;

import net.matbm.pessoas.core.erro.DadoDuplicadoException;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;
import net.matbm.pessoas.core.pessoas.usecase.CadastroPessoaUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CadastroPessoaUseCaseTest {
    @Mock
    PessoasGateway gateway;

    @InjectMocks
    CadastroPessoaUseCase useCase;

    @Test
    @DisplayName("Deve cadastrar uma pessoa")
    void cadastrarPessoa() {
        var pessoa = new Pessoa();
        useCase.cadastrarPessoa(pessoa);

        Mockito.verify(gateway, Mockito.times(1))
                .criarPessoa(pessoa);
    }

    @Test
    @DisplayName("Deve dar erro caso CPF já exista")
    void cadastrarPessoaDuplicadoErro() {
        var cpf = "cpf";
        var pessoa = new Pessoa();
        pessoa.setCpf(cpf);

        when(gateway.cpfJaCadastrado(cpf))
                .thenReturn(true);

        assertThatThrownBy(() -> useCase.cadastrarPessoa(pessoa))
                .isInstanceOfSatisfying(DadoDuplicadoException.class, d -> {
                    assertThat(d.getMessage())
                            .isEqualTo("net.matbm.pessoas.erro.cpf-duplicado");
                });
    }
}