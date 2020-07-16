package net.matbm.pessoas.core.pessoas.usecase;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.anotacao.UseCase;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListarPessoasUseCase {
    private final PessoasGateway pessoasGateway;

    public List<Pessoa> listarPessoas() {
        return pessoasGateway.listarPessoas();
    }
}
