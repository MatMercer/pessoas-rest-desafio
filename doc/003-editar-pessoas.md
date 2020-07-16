# 003 - Editar Pessoas

# Regra de negócio

## Premissa

Chamar um endpoint com PUT. Caso a pessoa não exista, retornar 404.
Caso exista, e cpf for igual ao atual, e já não existir no banco, atualizar.

## Detalhamento técnico

```
GET /v1/pessoas
PessoasController       -- chama -> EditarPessoaUseCase
EditarPessoaUseCase   -- chama -> PessoasGateway.pesquisaPorCPF(cpf)
Optional Vazio?
    -- sim -> throw NaoEncontradoException()
pessoaAtualizada = Optional.get()
pessoaAtualizada.cpf == request.cpf?
    -- sim -> gateway.atualizarPessoa(pessoa)
    -- não -> PessoasGateway.cpfExiste(request.cpf)
            -- sim -> throw CpfDuplicadoException()
            -- não -> gateway.atualizarPessoa(pessoa)
```

