package net.matbm.pessoas.presenter.rest.v1;

import net.matbm.pessoas.core.pessoas.usecase.CadastroPessoaUseCase;
import net.matbm.pessoas.core.pessoas.usecase.ListarPessoasUseCase;
import net.matbm.pessoas.dataprovider.pessoa.PessoaDataProvider;
import net.matbm.pessoas.presenter.rest.v1.mapper.PessoaRestMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(value = PessoaController.class)
@WithMockUser
class PessoaControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    CadastroPessoaUseCase useCase;

    @MockBean
    ListarPessoasUseCase listarPessoasUseCase;

    @MockBean
    PessoaDataProvider pessoaDataProvider;

    @MockBean
    PessoaRestMapper mapper;

    @Test
    @DisplayName("Deve cadastrar uma pessoa com dados de entrada válidos")
    void cadastroPessoa() throws Exception {
        mvc.perform(post("/v1/pessoas")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"nome\": \"Mercer\", \"cpf\": \"12345678909\", \"data_nascimento\": \"2019-01-22\" }")
        ).andExpect(status().is(201));
    }

    @Test
    @DisplayName("Deve listar as pessoas")
    void listarPessoas() throws Exception {
        when(listarPessoasUseCase.listarPessoas())
                .thenReturn(Collections.emptyList());

        mvc.perform(get("/v1/pessoas")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }
}