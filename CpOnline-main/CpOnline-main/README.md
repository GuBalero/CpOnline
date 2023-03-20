# CpOnline

Uma API para sistema de provas online.

## Endpoints

- Professor
    - [cadastrar](#cadastrar-professor)
    - [apagar](#apagar-professor)
    - [alterar](#alterar-professor)
    - [mostrar detalhes](#mostrar-detalhes-do-professor)
- Aluno
    - cadastrar
    - apagar
    - alterar
    - mostrar detalhes
- Prova
    - cadastrar
    - apagar
    - alterar
    - [listar todos por professor](#listar-todas-provas-por-professor)
    - listar todos por aluno
    - mostrar detalhes para professor
    - mostrar detalhes para aluno
    - entregar
- Questões 
    - cadastrar
    - apagar
    - alterar
    - listar todos por professor

---

### Cadastrar Professor

`POST` /cponline/api/professor

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|nome | string | sim | o nome do professor
|email | string | sim | o email do professor, também será seu usuário de acesso
|instituicao| string | sim | a instituição de ensino que o professor da aula
|senha | string | sim | a senha de usuário do professor

**Exemplo de corpo de requisição**

```js
{
    nome: 'Gustavo Balero',
    email: 'rm93090@fiap.com.br',
    instituicao: 'FIAP',
    senha: 'password123'
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | professor criado com sucesso
| 400 | campos inválidos

----

### Apagar professor

`DELETE` /cponline/api/professor/{id}

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | professor removido com sucesso
| 404 | não existe professor com o id informado

----

### Alterar Professor

`PUT` /cponline/api/professor/{id}

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|nome | string | sim | o nome do professor
|email | string | sim | o email do professor
|instituicao| string | sim | a instituição de ensino que o professor da aula
|senha | string | sim | a senha de usuário do professor, caso for permanecer a mesma, passar uma string vazia

**Exemplo de corpo de requisição**

```js
{
    nome: 'Gustavo Balero',
    email: 'rm93090@fiap.com.br',
    instituicao: 'FIAP',
    senha: 'password123'
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | professor alterado com sucesso
| 400 | campos inválidos
| 404 | não existe professor com o id informado

----

### Mostrar detalhes do professor

`GET` /cponline/api/professor/{id}

**Exemplo de Resposta**

```js
{
    nome: 'Gustavo Balero',
    email: 'rm93090@fiap.com.br',
    instituicao: 'FIAP'
}
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | dados do professor retornados com sucesso
| 404 | não existe professor com o id informado

----

### Listar todas provas por professor

`GET` /cponline/api/prova/professor/{id}

**Exemplo de Resposta**

```js
[
    {
        id: 54,
        descricao: 'CP1 Matematica'
    },
    {
        id: 102,
        descricao: 'GS 1°SEM Python'
    },
    {
        id: 2001,
        descricao: 'CP2 Banco de Dados'
    }
]
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | dados das provas do professor retornados com sucesso
| 404 | não existe professor com o id informado

----