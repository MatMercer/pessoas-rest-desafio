package net.matbm.pessoas.core.pessoas.gateway;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;

import java.util.List;

/**
 * Gateway para persistir/consultar/atualizar/deletar a entidade Pessoa
 */
public interface PessoasGateway {
    Pessoa criarPessoa(Pessoa pessoa);

    boolean cpfJaCadastrado(String cpf);

    List<Pessoa> listarPessoas();
}
