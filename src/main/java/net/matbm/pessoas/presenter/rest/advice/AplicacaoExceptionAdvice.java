package net.matbm.pessoas.presenter.rest.advice;

import net.matbm.pessoas.core.erro.AplicacaoException;
import net.matbm.pessoas.presenter.rest.v1.response.ErroAplicacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AplicacaoExceptionAdvice {

    @ExceptionHandler(AplicacaoException.class)
    public ResponseEntity<ErroAplicacaoResponse> erroAplicacao(AplicacaoException e) {
        return new ResponseEntity<>(new ErroAplicacaoResponse(e.getMessage()), HttpStatus.valueOf(e.getStatusHttp()));
    }
}
