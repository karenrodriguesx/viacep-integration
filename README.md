## API de cadastro de clientes integrada com o ViaCep <img align="center" alt="karen-java" height="35" width="45" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"><img align="center" alt="karen-spring" height="35" width="45" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">

### Descrição
- Esta API foi desenvolvida em Java usando Spring Boot 3 e utiliza o padrão de projeto Façade para realizar operações CRUD em uma entidade de cliente.
- O banco de dados utilizando é o H2, um banco em memória, que é apagado cada vez que o projeto é inicializado.
- A aplicação também se integra com o serviço ViaCEP para obter informações de endereço quando necessário.

---
### Como utilizar
- Após rodar o projeto, utilize Postman ou Insomnia para testar as requisições
- A URL base para acessar as funcionalidades é ```localhost:8080/clientes```

#### Método POST (Salvar)
URL: ```localhost:8080/clientes```

**Descrição:** Cria um novo cliente. Caso o enderecoId não exista no banco de dados, a aplicação busca o endereço no ViaCEP e o salva.

Estrutura JSON:
```
{
    "nome": "",
    "cpf": "",
    "enderecoId": 0,
    "cep": ""
}
```
#### Método PUT (Atualizar)
URL: ```localhost:8080/clientes/{id}```

**Descrição:** Atualiza um cliente existente. Caso o enderecoId não exista no banco de dados, a aplicação busca o endereço no ViaCEP e o salva.

Estrutura JSON:
```
{
    "id": 1,
    "nome": "",
    "cpf": "",
    "enderecoId": 1,
    "cep": ""
}
```

#### Método GET (Buscar por Id)
URL: ```localhost:8080/clientes/{id}```

**Descrição:** Retorna as informações do cliente conforme o id enviado.

Estrutura JSON:
```
{
    "id": 1,
    "nome": "",
    "cpf": "",
    "endereco": {
        "id": 1,
        "cep": "00000-000",
        "logradouro": "",
        "complemento": "",
        "bairro": "",
        "localidade": "",
        "uf": "",
        "ibge": "",
        "gia": "",
        "ddd": "",
        "siafi": ""
    }
}
```

#### Método GET (Listar)
URL: ```localhost:8080/clientes```

**Descrição:** Retorna uma lista de todos os clientes cadastrados.

Estrutura JSON:
```
[
    {
        "id": 1,
        "nome": "Karen",
        "cpf": "02100000000",
        "endereco": {
            "id": 1,
            "cep": "00000-000",
            "logradouro": "",
            "complemento": "",
            "bairro": "",
            "localidade": "",
            "uf": "",
            "ibge": "",
            "gia": "",
            "ddd": "",
            "siafi": ""
        }
    }
]
```
#### Método DELETE (Excluir)
URL: ```localhost:8080/clientes/{id}```

**Descrição:** Deleta um cliente existente pelo id informado.
