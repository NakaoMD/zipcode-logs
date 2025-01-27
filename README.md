# ZipCode Logs API

## Descrição

A **ZipCode Logs API** é uma aplicação em Java desenvolvida com Spring Boot, PostgreSQL, Docker e WireMock para consulta de CEPs, armazenamento de logs de consultas e exposição de uma interface documentada com Swagger.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Web, Data JPA, Flyway)
- **PostgreSQL** (Banco de dados)
- **Docker** (Conteinerização da aplicação e serviços auxiliares)
- **WireMock** (Mock de APIs externas)
- **OpenAPI/Swagger** (Documentação da API)

---

## Funcionalidades

1. Consultar informações de um CEP.
2. Salvar logs de todas as consultas realizadas.
3. Listar todos os logs armazenados.
4. Gerar erros customizados para CEPs não encontrados.

---

## Endpoints da API

### **Consulta de CEP**
- **GET /zipcode/{cep}**
    - Consulta as informações de um CEP e salva o log.
    - Exemplo de retorno:
      ```json
      {
        "cep": "041813040",
        "logradouro": "Rua Exemplo",
        "bairro": "Bairro Exemplo",
        "cidade": "Cidade Exemplo",
        "estado": "SP"
      }
      ```

### **Listar Logs**
- **GET /zipcode/logs**
    - Retorna todos os logs armazenados no banco de dados.
    - Exemplo de retorno:
      ```json
      [
        {
          "id": 1,
          "cep": "041813040",
          "logradouro": "Rua Exemplo",
          "bairro": "Bairro Exemplo",
          "cidade": "Cidade Exemplo",
          "estado": "SP",
          "timestamp": "2025-01-27T12:00:00"
        }
      ]
      ```

---

## Como Rodar o Projeto

### **Requisitos**
- **Java 17**
- **Maven**
- **Docker**

### **Passos**
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/zipcode-logs.git
   cd zipcode-logs
   ```

2. Suba os conteineres Docker:
   ```bash
   docker-compose up --build
   ```

3. Acesse a API Swagger para testar os endpoints:
    - URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

4. Para acessar o banco de dados PostgreSQL:
    - **Host:** `localhost`
    - **Porta:** `5432`
    - **Usuário:** `postgres`
    - **Senha:** `1234`
    - **Database:** `zipcode_logs`

---

## Estrutura do Projeto

```plaintext
src/main/java
|-- com.api
    |-- config
    |   |-- RestTemplateConfig.java
    |   |-- SwaggerConfig.java
    |
    |-- controllers
    |   |-- ZipCodeController.java
    |
    |-- domain
    |   |-- ZipCodeLog.java
    |
    |-- dtos
    |   |-- ZipCodeResponse.java
    |
    |-- repositories
    |   |-- ZipCodeLogRepository.java
    |
    |-- services
        |-- ZipCodeService.java
        |-- ZipCodeLogService.java

src/main/resources
|-- db/migration
    |-- V1_create_zipcode_logs_table.sql
|-- mappings
    |-- fallback.json
    |-- mapping.json
|-- application.properties
```

---

## Banco de Dados

### **Tabela `zipcode_logs`**

| Campo        | Tipo         | Restrições         |
|--------------|--------------|------------------|
| `id`         | SERIAL       | PRIMARY KEY      |
| `cep`        | VARCHAR(20)  | NOT NULL         |
| `logradouro` | VARCHAR(255) | NOT NULL         |
| `bairro`     | VARCHAR(255) | NOT NULL         |
| `cidade`     | VARCHAR(255) | NOT NULL         |
| `estado`     | VARCHAR(50)  | NOT NULL         |
| `timestamp`  | TIMESTAMP    | NOT NULL         |

---

## Documentação Swagger

Acesse a interface Swagger para visualizar e testar os endpoints da API:
- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---


