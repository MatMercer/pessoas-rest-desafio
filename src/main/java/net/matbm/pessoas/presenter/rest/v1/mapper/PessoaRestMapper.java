package net.matbm.pessoas.presenter.rest.v1.mapper;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.presenter.rest.v1.request.PessoaRequest;
import net.matbm.pessoas.presenter.rest.v1.response.PessoaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaRestMapper {

    Pessoa toCore(PessoaRequest request);

    PessoaResponse toResponse(Pessoa core);
}
