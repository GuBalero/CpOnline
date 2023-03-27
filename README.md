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

---

### Cadastrar Aluno

`POST` /cponline/api/aluno

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|nome | string | sim | o nome do aluno
|email | string | sim | o email do aluno, também será seu usuário de acesso
|instituicao| string | sim | a instituição de ensino do aulno
|senha | string | sim | a senha de usuário do aluno

**Exemplo de corpo de requisição**

```js
{
    nome: 'Marcelo Gimenes',
    email: 'rm93987@fiap.com.br',
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

### Apagar aluno

`DELETE` /cponline/api/aluno/{id}

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | aluno removido com sucesso
| 404 | não existe aluno com o id informado

----

### Alterar Aluno

`PUT` /cponline/api/aluno/{id}

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|nome | string | sim | o nome do aluno
|email | string | sim | o email do aluno
|instituicao| string | sim | a instituição de ensino que do aluno
|senha | string | sim | a senha de usuário do aluno, caso for permanecer a mesma, passar uma string vazia

**Exemplo de corpo de requisição**

```js
{
    nome: 'Marcelo Gimenes',
    email: 'rm93897@fiap.com.br',
    instituicao: 'FIAP',
    senha: 'password123'
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | Aluno alterado com sucesso
| 400 | campos inválidos
| 404 | não existe aluno com o id informado

----

### Mostrar detalhes do aluno

`GET` /cponline/api/aluno/{id}

**Exemplo de Resposta**

```js
{
    nome: 'Marcelo Gimenes',
    email: 'rm93897@fiap.com.br',
    instituicao: 'FIAP'
}
```
**Códigos de Respostas**

| código | descrição
|-|-
| 200 | dados do aluno retornados com sucesso
| 404 | não existe aluno com o id informado

---

### Cadastrar Prova

`POST` /cponline/api/professor

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|descricao | string | sim | Descrição da prova
|url | string | sim | url de acesso do aluno a prova
|data| Localdate | sim | Local e data de prova 
|ativo | boolean | sim | Se a prova está ativa

**Exemplo de corpo de requisição**

```js
{
    descricao: 'Pova de Matemática',
    url: 'www.fiap.com.br/prova de matematica',
    data: '2023-03-23',
    status: ativo
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | prova criada com sucesso
| 400 | campos inválidos

----

### Apagar prova

`DELETE` /cponline/api/prova/{id}

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | prova removida com sucesso
| 404 | não existe prova com o id informado

----

### Alterar Prova

`PUT` /cponline/api/prova/{id}

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|descricao | string | sim | Descrição da prova
|url | string | sim | url de acesso do aluno a prova
|data| Localdate | sim | Local e data de prova 
|ativo | boolean | sim | Se a prova está ativa

**Exemplo de corpo de requisição**

```js
{
    descricao: 'Pova de Matemática',
    url: 'www.fiap.com.br/prova de matematica',
    data: '2023-03-23',
    status: ativo
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | prova alterada com sucesso
| 400 | campos inválidos
| 404 | não existe prova com o id informado

---

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

### Listar todas provas por aluno

`GET` /cponline/api/prova/aluno/{id}

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
| 200 | dados das provas do aluno retornados com sucesso
| 404 | não existe professor com o id informado

----

### Mostrar detalhes do professor

`GET` /cponline/api/prova/professor{id}

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
| 200 | dados do prova/professor retornados com sucesso
| 404 | não existe professor/prova com o id informado

---

### Mostrar detalhes do aluno

`GET` /cponline/api/prova/aluno{id}

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
| 200 | dados do prova/aluno retornados com sucesso
| 404 | não existe prova/aluno com o id informado

----

### Cadastrar Questões

`POST` /cponline/api/questao

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|enunciado | string | sim | descrever o enunciado da questão
|altervativaA | string | sim | respostas das perguntas
|altervativaB | string | sim | respostas das perguntas
|altervativaC | string | sim | respostas das perguntas
|altervativaD | string | sim | respostas das perguntas
|altervativaE | string | sim | respostas das perguntas
|altervativaCorreta | string | sim | informação da resposta correta

**Exemplo de corpo de requisição**

```js
{
    enunciado: 'Quanto é a soma de 2 + 2',
    alternativaA: '5',
    alternativaB: '4',
    alternativaC: '2',
    alternativaD: '8',
    alternativaE: '25',
    alternativaCorreta: alternativaB
    
    
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | questão criada com sucesso
| 400 | campos inválidos

----

### Apagar Questão

`DELETE` /cponline/api/questao/{id}

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | questão removida com sucesso
| 404 | não existe questao com o id informado

----

### Alterar Questão

`PUT` /cponline/api/questao/{id}

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|enunciado | string | sim | descrever o enunciado da questão
|altervativaA | string | sim | respostas das perguntas
|altervativaB | string | sim | respostas das perguntas
|altervativaC | string | sim | respostas das perguntas
|altervativaD | string | sim | respostas das perguntas
|altervativaE | string | sim | respostas das perguntas
|altervativaCorreta | string | sim | informação da resposta correta

**Exemplo de corpo de requisição**

```js
{
    enunciado: 'Quanto é a soma de 2 + 2',
    alternativaA: '5',
    alternativaB: '4',
    alternativaC: '2',
    alternativaD: '8',
    alternativaE: '25',
    alternativaCorreta: alternativaB
    
    
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 202 | questao alterada com sucesso
| 400 | campos inválidos
| 404 | não existe questao com o id informado

----

### Mostrar detalhes do professor

`GET` /cponline/api/questao/professor/{id}

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
| 200 | dados do questao/professor retornados com sucesso
| 404 | não existe questao/professor com o id informado

----

