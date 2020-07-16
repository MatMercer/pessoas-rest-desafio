package net.matbm.pessoas.presenter.rest.v1.mapper;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.presenter.rest.v1.request.PessoaRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static net.matbm.pessoas.util.Podam.PODAM;
import static org.assertj.core.api.Assertions.assertThat;

class PessoaRestMapperTest {
    PessoaRestMapper restMapper = Mappers.getMapper(PessoaRestMapper.class);

    @Test
    @DisplayName("Deve mapear para core")
    void toCore() {
        PessoaRequest request = PODAM.manufacturePojo(PessoaRequest.class);
        request.setSexo("F");

        var core = restMapper.toCore(request);

        assertThat(core.getCpf())
                .isEqualTo(request.getCpf());
        assertThat(core.getDataNascimento())
                .isEqualTo(request.getDataNascimento());
        assertThat(core.getEmail())
                .isEqualTo(request.getEmail());
        assertThat(core.getNacionalidade())
                .isEqualTo(request.getNacionalidade());
        assertThat(core.getNaturalidade())
                .isEqualTo(request.getNaturalidade());
        assertThat(core.getSexo().name())
                .isEqualTo(request.getSexo());
    }

    @Test
    @DisplayName("Deve mapear sexo para core de maneira mais flexível")
    void toCoreSexoFlexivel() {
        PessoaRequest request = PODAM.manufacturePojo(PessoaRequest.class);
        request.setSexo("f");

        var core = restMapper.toCore(request);

        assertThat(core.getSexo().name())
                .isEqualTo(request.getSexo().toUpperCase());
    }

    @Test
    @DisplayName("Deve mapear para response")
    void toResponse() {
        Pessoa pessoa = PODAM.manufacturePojo(Pessoa.class);

        var response = restMapper.toResponse(pessoa);

        assertThat(response.getCpf())
                .isEqualTo(pessoa.getCpf());
        assertThat(response.getDataNascimento())
                .isEqualTo(pessoa.getDataNascimento());
        assertThat(response.getEmail())
                .isEqualTo(pessoa.getEmail());
        assertThat(response.getNacionalidade())
                .isEqualTo(pessoa.getNacionalidade());
        assertThat(response.getNaturalidade())
                .isEqualTo(pessoa.getNaturalidade());
        assertThat(response.getSexo())
                .isEqualTo(pessoa.getSexo().name());
    }
}