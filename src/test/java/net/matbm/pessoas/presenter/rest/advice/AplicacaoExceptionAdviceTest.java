package net.matbm.pessoas.presenter.rest.advice;

import net.matbm.pessoas.core.erro.AplicacaoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AplicacaoExceptionAdviceTest {
    AplicacaoExceptionAdvice advice = new AplicacaoExceptionAdvice();

    @Test
    @DisplayName("Deve tratar exception de aplicação")
    @SuppressWarnings("ConstantConditions")
    void tratarExceptionAplicacao() {
        var ex = new AplicacaoException("teste", null, 404);

        var response = advice.erroAplicacao(ex);
        var body = response.getBody();

        assertThat(response.getStatusCodeValue())
                .isEqualTo(ex.getStatusHttp());
        assertThat(body.getMensagem())
                .isEqualTo(ex.getMessage());
    }

}