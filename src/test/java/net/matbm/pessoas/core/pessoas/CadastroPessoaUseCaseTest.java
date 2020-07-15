package net.matbm.pessoas.core.pessoas;

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

@ExtendWith(MockitoExtension.class)
class CadastroPessoaUseCaseTest {
    @Mock
    PessoasGateway gateway;

    @InjectMocks
    CadastroPessoaUseCase useCase;

    @Test
    @DisplayName("Deve cadastrar uma pessoa")
    void cadastrarPessoa() {
        Pessoa pessoa = new Pessoa();
        useCase.cadastrarPessoa(pessoa);

        Mockito.verify(gateway, Mockito.times(1))
                .criarPessoa(pessoa);
    }
}