package net.matbm.pessoas.dataprovider.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaTable, String> {
    boolean existsByCpf(String cpf);
}
