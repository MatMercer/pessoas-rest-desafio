package net.matbm.pessoas.dataprovider.pessoa;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;
import net.matbm.pessoas.dataprovider.anotacao.Dataprovider;
import org.springframework.stereotype.Component;

@Component
@Dataprovider
@RequiredArgsConstructor
public class PessoaDataProvider implements PessoasGateway {
    private final PessoaRepository repository;
    private final PessoaTableMapper mapper;

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        return mapper.toCore(repository.saveAndFlush(mapper.toTable(pessoa)));
    }

    @Override
    public boolean cpfJaCadastrado(String cpf) {
        return repository.existsByCpf(cpf);
    }
}
