# 001 - Create Usuário

# Regra de negócio

## Premissa

API de cadastro de pessoas com os dados:

* Nome
* Sexo
* E-mail
* Data de nascimento
* Naturalidade
* Nacionalidade
* CPF

## Campos obrigatórios

* Nome
* Data de nascimento
* CPF

## Validações

* Nome      @NotBlank
* Email     @Email
* CPF
    * @CPF
    * Não deve já existir no sistema

## Detalhamento técnico

```
POST /v1/pessoas
PessoasController       -- chama -> CadastroPessoaUseCase
CadastroPessoaUseCase   -- chama -> PessoasGateway.cpfExiste(cpfRecebido)
CPF existe?
    -- sim -> throw new DadoDuplicadoException()
CadastroPessoaUseCase   -- chama -> PessoasGateway.novaPessoa(pessoaRecebida)
PessoasController       -- responde -> 201 CREATED
```

