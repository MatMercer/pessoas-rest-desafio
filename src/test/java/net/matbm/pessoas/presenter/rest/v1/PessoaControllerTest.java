package net.matbm.pessoas.presenter.rest.v1;

import net.matbm.pessoas.core.pessoas.usecase.CadastroPessoaUseCase;
import net.matbm.pessoas.presenter.rest.v1.mapper.PessoaRestMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PessoaController.class)
@WithMockUser
class PessoaControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    CadastroPessoaUseCase useCase;

    @MockBean
    PessoaRestMapper mapper;

    @Test
    @DisplayName("Deve cadastrar uma pessoa com dados de entrada válidos")
    void cadastroPessoa() throws Exception {
        mvc.perform(post("/v1/pessoas")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        ).andExpect(status().is(201));
    }
}