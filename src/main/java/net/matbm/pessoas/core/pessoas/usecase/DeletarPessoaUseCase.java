package net.matbm.pessoas.core.pessoas.usecase;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.erro.NaoEncontradoException;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;

@RequiredArgsConstructor
public class DeletarPessoaUseCase {
    private final PessoasGateway pessoasGateway;

    public void deletarPorCpf(String cpf) {
        if (!pessoasGateway.cpfJaCadastrado(cpf))
            throw new NaoEncontradoException();

        pessoasGateway.deletarPorCpf(cpf);
    }
}
