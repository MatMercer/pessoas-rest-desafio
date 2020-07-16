package net.matbm.pessoas.dataprovider.pessoa;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.gateway.PessoasGateway;
import net.matbm.pessoas.dataprovider.anotacao.Dataprovider;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Dataprovider
@RequiredArgsConstructor
public class PessoaDataProvider implements PessoasGateway {
    private final PessoaRepository repository;
    private final PessoaTableMapper mapper;

    @Override
    @Transactional
    public Pessoa criarPessoa(Pessoa pessoa) {
        return mapper.toCore(repository.save(mapper.toTable(pessoa)));
    }

    @Override
    public boolean cpfJaCadastrado(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return repository.findAll().stream()
                .map(mapper::toCore)
                .collect(Collectors.toList());
    }
}
