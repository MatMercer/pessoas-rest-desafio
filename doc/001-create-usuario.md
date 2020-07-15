# 001 - Create Usuário

# Regra de negócio

## Premissa

API de cadastro de pessoas com os dados:

|Field|Tipo
|---|---|
|Nome|String|
|Sexo|Regex [ffmmoo]|
|Email|String|
|Data Nascimento|LocalDate|
|Naturalidade|String|
|Nacionalidade|String|
|CPF|String|

## Campos obrigatórios

* Nome
* Data de nascimento
* CPF

## Validações

* Nome      @NotBlank
* Sexo      @Pattern(regex = "[FfOoMm])
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

