# 004 - Deletar Pessoas

# Regra de negócio

É necessário deletar uma pessoa pelo CPF.

## Detalhamento técnico

Uma request DELETE com o body:

```json
{
  "cpf": "12345678909"
}
```

Deleta a pessoa. Caso uma pessoa com o CPF não exista, retornar 404.
