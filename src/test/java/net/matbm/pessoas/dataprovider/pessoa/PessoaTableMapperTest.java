package net.matbm.pessoas.dataprovider.pessoa;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static net.matbm.pessoas.util.Podam.PODAM;
import static org.assertj.core.api.Assertions.assertThat;

class PessoaTableMapperTest {
    PessoaTableMapper tableMapper = Mappers.getMapper(PessoaTableMapper.class);

    @Test
    void toTable() {
        Pessoa core = PODAM.manufacturePojo(Pessoa.class);

        var table = tableMapper.toTable(core);

        assertThat(core)
                .isEqualToComparingFieldByField(table);
    }

    @Test
    void toCore() {
        PessoaTable table = PODAM.manufacturePojo(PessoaTable.class);

        var core = tableMapper.toCore(table);

        assertThat(table)
                .isEqualToComparingFieldByField(core);
    }
}