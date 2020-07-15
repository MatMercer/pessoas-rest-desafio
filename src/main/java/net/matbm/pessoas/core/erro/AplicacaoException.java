package net.matbm.pessoas.core.erro;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AplicacaoException extends RuntimeException {
    private final int statusHttp;

    public AplicacaoException(String message, Throwable cause, int statusHttp) {
        super(message, cause);
        this.statusHttp = statusHttp;
    }
}
