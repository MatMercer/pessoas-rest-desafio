package net.matbm.pessoas.core.erro;

public class DadoDuplicadoException extends AplicacaoException {
    public DadoDuplicadoException() {
        super("net.matbm.pessoas.erro.duplicado", null, 409);
    }

    public DadoDuplicadoException(String message) {
        super(message, null, 409);
    }
}
