package net.matbm.pessoas.core.pessoas.usecase;

import net.matbm.pessoas.core.erro.NaoEncontradoException;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeletarPessoaUseCaseTest {

    @Mock
    PessoasGateway pessoasGateway;

    @InjectMocks
    DeletarPessoaUseCase deletarPessoaUseCase;

    @Test
    @DisplayName("Caso pessoa com CPF não exista, dar throw")
    void pesosaNaoExisteThrow() {
        when(pessoasGateway.cpfJaCadastrado("cpf"))
                .thenReturn(false);

        assertThatThrownBy(() -> deletarPessoaUseCase.deletarPorCpf("cpf"))
                .isInstanceOf(NaoEncontradoException.class);
    }
}