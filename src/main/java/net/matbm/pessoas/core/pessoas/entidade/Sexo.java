package net.matbm.pessoas.core.pessoas.entidade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Define o Sexo de uma pessoa.
 */
@Getter
@RequiredArgsConstructor
public enum Sexo {
    F("Feminino"),
    M("Masculino"),
    O("Outro");

    private final String descricao;

    @Override
    public String toString() {
        return descricao;
    }
}
