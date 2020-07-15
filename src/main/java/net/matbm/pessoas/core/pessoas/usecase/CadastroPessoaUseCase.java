package net.matbm.pessoas.core.pessoas.usecase;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;

@RequiredArgsConstructor
public class CadastroPessoaUseCase {
    private final PessoasGateway gateway;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return gateway.criarPessoa(pessoa);
    }
}
