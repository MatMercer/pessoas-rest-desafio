package net.matbm.pessoas.core.pessoas.usecase;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.anotacao.UseCase;
import net.matbm.pessoas.core.erro.DadoDuplicadoException;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;

@UseCase
@RequiredArgsConstructor
public class CadastroPessoaUseCase {
    private final PessoasGateway gateway;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        if (gateway.cpfJaCadastrado(pessoa.getCpf()))
            throw new DadoDuplicadoException("net.matbm.pessoas.erro.cpf-duplicado");
        return gateway.criarPessoa(pessoa);
    }
}
