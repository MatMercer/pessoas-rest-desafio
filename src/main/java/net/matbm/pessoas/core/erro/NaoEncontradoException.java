package net.matbm.pessoas.core.erro;

public class NaoEncontradoException extends AplicacaoException {
    public NaoEncontradoException() {
        super("net.matbm.pessoas.erro.nao-encontrado", null, 404);
    }

    public NaoEncontradoException(String message) {
        super(message, null, 404);
    }
}
