package net.matbm.pessoas.presenter.rest.v1;

import lombok.RequiredArgsConstructor;
import net.matbm.pessoas.core.pessoas.entidade.Pessoa;
import net.matbm.pessoas.core.pessoas.usecase.AtualizarPessoaUseCase;
import net.matbm.pessoas.core.pessoas.usecase.CadastroPessoaUseCase;
import net.matbm.pessoas.core.pessoas.usecase.DeletarPessoaUseCase;
import net.matbm.pessoas.core.pessoas.usecase.ListarPessoasUseCase;
import net.matbm.pessoas.presenter.rest.v1.mapper.PessoaRestMapper;
import net.matbm.pessoas.presenter.rest.v1.request.PessoaDeleteRequest;
import net.matbm.pessoas.presenter.rest.v1.request.PessoaRequest;
import net.matbm.pessoas.presenter.rest.v1.response.PessoaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PessoaController {
    private final CadastroPessoaUseCase cadastroPessoaUseCase;
    private final ListarPessoasUseCase listarPessoasUseCase;
    private final AtualizarPessoaUseCase atualizarPessoaUseCase;
    private final DeletarPessoaUseCase deletarPessoaUseCase;
    private final PessoaRestMapper restMapper;

    @PostMapping("/v1/pessoas")
    public ResponseEntity<PessoaResponse> cadastrarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoaNova = cadastroPessoaUseCase.cadastrarPessoa(restMapper.toCore(pessoaRequest));

        return new ResponseEntity<>(restMapper.toResponse(pessoaNova), HttpStatus.CREATED);
    }

    @GetMapping("/v1/pessoas")
    public ResponseEntity<List<PessoaResponse>> listarPessoas() {
        return new ResponseEntity<>(listarPessoasUseCase.listarPessoas().stream()
                .map(restMapper::toResponse).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PutMapping("/v1/pessoas")
    public ResponseEntity<Void> listarPessoas(@Valid @RequestBody PessoaRequest pessoaRequest) {
        atualizarPessoaUseCase.atualizarPessoa(restMapper.toCore(pessoaRequest));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/v1/pessoas")
    public ResponseEntity<Void> removerPEssoa(@Valid @RequestBody PessoaDeleteRequest deleteRequest) {
        deletarPessoaUseCase.deletarPorCpf(deleteRequest.getCpf());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
