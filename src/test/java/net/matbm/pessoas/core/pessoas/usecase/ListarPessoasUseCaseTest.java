package net.matbm.pessoas.core.pessoas.usecase;


import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;
import net.matbm.pessoas.util.Podam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarPessoasUseCaseTest {
    @Mock
    PessoasGateway gateway;

    @InjectMocks
    ListarPessoasUseCase useCase;

    @Test
    @DisplayName("Deve listar as pessoas")
    void listarPessoas() {
        var pessoa = Podam.PODAM.manufacturePojo(Pessoa.class);

        when(gateway.listarPessoas())
                .thenReturn(Collections.singletonList(pessoa));

        List<Pessoa> pessoas = useCase.listarPessoas();

        assertThat(pessoas.get(0))
                .isEqualTo(pessoa);
    }

}