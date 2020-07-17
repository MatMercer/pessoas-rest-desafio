package net.matbm.pessoas.dataprovider.pessoa;

import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PessoaDataProviderIntegrationTest {
    @Autowired
    PessoaDataProvider pessoaDataProvider;

    @Autowired
    PessoaRepository pessoaRepository;

    final static String CPF_JA_CADASTRADO = "12345678909";
    final static String CPF_NOVO = "12345678910";

    @Test
    @DisplayName("Deve retornar caso CPF já esteja cadastrado")
    @Sql("classpath:sql/pessoa-exemplo.sql")
    public void retornaCpfJaCadastrado() {
        assertThat(pessoaDataProvider.cpfJaCadastrado(CPF_JA_CADASTRADO))
                .isTrue();
    }

    @Test
    @DisplayName("Deve cadastrar uma pessoa nova")
    public void deveCadastrarUmaPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Mercer");
        pessoa.setCpf(CPF_NOVO);
        pessoa.setDataNascimento(LocalDate.now());

        assertThat(pessoaDataProvider.criarPessoa(pessoa))
                .isNotNull();
        assertThat(pessoaRepository.existsByCpf(CPF_NOVO))
                .isTrue();
    }

    @Test
    @DisplayName("Deve listar todas as pessoas")
    @Sql("classpath:sql/pessoa-exemplo.sql")
    public void deveListarAsPessoas() {
        assertThat(pessoaDataProvider.listarPessoas())
                .hasSize(1);
    }

    @Test
    @DisplayName("Deve atualizar uma pessoa")
    @Sql("classpath:sql/pessoa-exemplo.sql")
    public void atualizarPessoa() {
        Pessoa pessoaParaAtualizar = pessoaDataProvider.listarPessoas().get(0);
        pessoaParaAtualizar.setNome("Outro nome");

        pessoaDataProvider.atualizarPessoa(pessoaParaAtualizar);

        Pessoa pessoaAtualizada = pessoaDataProvider.listarPessoas().get(0);

        assertThat(pessoaAtualizada.getNome())
                .isEqualTo("Outro nome");
    }

}