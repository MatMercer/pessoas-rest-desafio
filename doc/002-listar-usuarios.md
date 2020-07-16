# 002 - Listar Usuários

# Regra de negócio

## Premissa

Chamar um endpoint e listar os usuários.

## Detalhamento técnico

```
GET /v1/pessoas
PessoasController       -- chama -> ListarPessoasUseCase
ListarPessoasUseCase   -- chama -> PessoasGateway.listarTodas()
PessoasController       -- responde -> 200 OK
```

