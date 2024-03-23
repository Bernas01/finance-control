# Finance Control

API do projeto Finance Control - Controle de Despesas pessoais

## Requisitos

- [x] CRUD de Categorias 
- [ ] CRUD de Movimentações
- [ ] CRUD de Usuários
- [ ] Autenticação
- [ ] Dashboard

## Documentação

### Endpoints

- [Listar Categorias](#listar-categorias)
- [Cadastrar Categoria](#cadastrar-categoria)
- [Detalhes da Categoria](#detalhes-da-categoria)
- [Apagar Categoria](#apagar-categoria)
- [Atualizar Categoria](#atualizar-categoria)

### Listar Categorias

`GET` /category

Retorna um array com todas as categorias cadastradas.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "name": "Alimentação",
        "icon": "fast-food"
    },
    {
        "id": 2,
        "name": "Educação",
        "icon": "book"
    }
]
```

#### Código de Status

| código | descrição
|--------|-----------
|200|Categorias retornadas com sucesso
|401|Usuário não autenticado. Realize autenticação em /login

---

### Cadastrar Categoria

`POST` /category

Cadastrar uma nova categoria para o usuário logado com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅| Um nome curto para a categoria
|icone| string | ❌ | O nome do ícone conforme Material Icons

```js
{
    "name": "Alimentação",
    "icon": "fast-food"
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "name": "Alimentação",
    "icon": "fast-food"
}
```

#### Código de Status

| código | descrição
|--------|-----------
|201|Categoria cadastrada com sucesso
|400|Validação falhou. Verifique as regras para o corpo da requisição
|401|Usuário não autenticado. Realize autenticação em /login

---

### Detalhes da Categoria

`GET` /category/`{id}`

Retorna os dados detalhados da categoria com o `id` informado no parâmetro de path.

### Exemplo de Resposta
```js
// requisição para /category/1
{
    "id": 1,
    "name": "Alimentação",
    "icon": "fast-food"
}
```

#### Código de Status

| código | descrição
|--------|-----------
|200|Dados da categoria retornados com sucesso
|401|Usuário não autenticado. Realize autenticação em /login
|404|Não existe categoria com o `id` informado. Consulte lista em /categoria

---

### Apagar Categoria

`DELETE` /category/`{id}`

Apaga a categoria indicada pelo `id` enviado no parâmetro de path.

#### Código de Status

| código | descrição
|--------|-----------
|204|Categoria apagada com sucesso
|401|Usuário não autenticado. Realize autenticação em /login
|404|Não existe categoria com o `id` informado. Consulte lista em /categoria

---

### Atualizar Categoria

`PUT` /category/`{id}`

Atualizar os dados da categoria com o `id` informado no path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅| Um nome curto para a categoria
|icone| string | ✅ | O nome do ícone conforme Material Icons

```js
{
    "name": "Alimentação",
    "icon": "fast-food"
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "name": "Alimentação",
    "icon": "fast-food"
}
```

#### Código de Status

| código | descrição
|--------|-----------
|200|Categoria atualizada com sucesso
|400|Validação falhou. Verifique as regras para o corpo da requisição
|401|Usuário não autenticado. Realize autenticação em /login
|404|Não existe categoria com o `id` informado. Consulte lista em /categoria
---






