package net.matbm.pessoas.dataprovider.pessoa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PessoaDataProviderIntegrationTest {
    @Autowired
    PessoaDataProvider pessoaDataProvider;

    final static String CPF_JA_CADASTRADO = "12345678909";

    @Test
    @DisplayName("Deve retornar caso CPF já esteja cadastrado")
    @Sql("classpath:sql/pessoa-exemplo.sql")
    public void retornaCpfJaCadastrado() {
        assertThat(pessoaDataProvider.cpfJaCadastrado(CPF_JA_CADASTRADO))
                .isTrue();
    }

}