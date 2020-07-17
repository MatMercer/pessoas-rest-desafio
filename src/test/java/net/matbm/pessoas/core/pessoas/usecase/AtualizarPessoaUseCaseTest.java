package net.matbm.pessoas.core.pessoas.usecase;

import net.matbm.pessoas.core.erro.NaoEncontradoException;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static net.matbm.pessoas.util.Podam.PODAM;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AtualizarPessoaUseCaseTest {
    @Mock
    PessoasGateway pessoasGateway;

    @InjectMocks
    AtualizarPessoaUseCase atualizarPessoaUseCase;

    private final String CPF = "cpf";

    @Test
    @DisplayName("Caso pessoa não encontrada, deve dar throw")
    public void pessoaNaoEncontrada() {
        when(pessoasGateway.cpfJaCadastrado(CPF))
                .thenReturn(false);

        var pessoa = PODAM.manufacturePojo(Pessoa.class);
        pessoa.setCpf(CPF);

        assertThatThrownBy(() -> atualizarPessoaUseCase.atualizarPessoa(pessoa))
                .isInstanceOf(NaoEncontradoException.class);
    }

    @Test
    @DisplayName("Caso encontre deve atualizar não encontrada, deve dar throw")
    public void pessoaEncontrada() {
        var pessoa = PODAM.manufacturePojo(Pessoa.class);
        pessoa.setCpf(CPF);

        when(pessoasGateway.cpfJaCadastrado(CPF))
                .thenReturn(true);

        atualizarPessoaUseCase.atualizarPessoa(pessoa);

        verify(pessoasGateway, times(1))
                .atualizarPessoa(pessoa);
    }
}