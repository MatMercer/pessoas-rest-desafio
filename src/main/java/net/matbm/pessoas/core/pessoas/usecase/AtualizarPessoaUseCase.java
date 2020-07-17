package net.matbm.pessoas.core.pessoas.usecase;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.erro.NaoEncontradoException;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;

@RequiredArgsConstructor
public class AtualizarPessoaUseCase {
    private final PessoasGateway pessoasGateway;

    public void atualizarPessoa(Pessoa atualizacao) {
        if (!pessoasGateway.cpfJaCadastrado(atualizacao.getCpf()))
            throw new NaoEncontradoException();

        pessoasGateway.atualizarPessoa(atualizacao);
    }
}
