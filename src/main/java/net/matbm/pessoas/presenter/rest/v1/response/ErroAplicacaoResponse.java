package net.matbm.pessoas.presenter.rest.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroAplicacaoResponse {
    private String mensagem;
}
