package net.matbm.pessoas.dataprovider.pessoa;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaTableMapper {
    PessoaTable toTable(Pessoa pessoa);

    Pessoa toCore(PessoaTable pessoa);
}
