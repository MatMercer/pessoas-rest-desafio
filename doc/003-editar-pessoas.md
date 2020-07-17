# 003 - Editar Pessoas

# Regra de negócio

## Premissa

Chamar um endpoint com PUT. Caso a pessoa não exista, retornar 404.
Caso exista, atualizar.

## Detalhamento técnico

```
GET /v1/pessoas
PessoasController       -- chama -> EditarPessoaUseCase
EditarPessoaUseCase   -- chama -> PessoasGateway.pesquisaPorCPF(cpf)
Optional Vazio?
    -- sim -> throw NaoEncontradoException()
pessoaAtualizada = Optional.get()
gateway.atualizarPessoa(pessoa)
```

