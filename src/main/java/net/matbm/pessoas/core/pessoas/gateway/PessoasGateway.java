package net.matbm.pessoas.core.pessoas.gateway;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;

import java.util.List;
import java.util.Optional;

/**
 * Gateway para persistir/consultar/atualizar/deletar a entidade Pessoa
 */
public interface PessoasGateway {
    boolean cpfJaCadastrado(String cpf);

    Pessoa criarPessoa(Pessoa pessoa);

    List<Pessoa> listarPessoas();

    void atualizarPessoa(Pessoa pessoa);

    void deletarPorCpf(String cpf);
}
