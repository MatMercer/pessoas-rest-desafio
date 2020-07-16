package net.matbm.pessoas.presenter.rest.v1.mapper;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.entidade.Sexo;
import net.matbm.pessoas.presenter.rest.v1.request.PessoaRequest;
import net.matbm.pessoas.presenter.rest.v1.response.PessoaResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaRestMapper {

    Pessoa toCore(PessoaRequest request);

    default Sexo toSexoCore(String value) {
        if (value == null)
            return null;

        return Sexo.valueOf(value.toUpperCase());
    }

    PessoaResponse toResponse(Pessoa core);
}
