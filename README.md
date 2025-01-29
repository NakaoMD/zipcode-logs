# ZipCode Logs API

## Descrição
A **ZipCode Logs API** é uma aplicação em **Java** desenvolvida com **Spring Boot**, **PostgreSQL**, **Docker** e **WireMock** para realizar consultas de **CEPs**, armazenar logs das consultas e expor uma interface documentada com **Swagger**.

A arquitetura segue os **princípios SOLID**, garantindo modularidade e facilidade de manutenção.

---

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (Spring Web, Data JPA, Flyway)
- **PostgreSQL** (Banco de dados relacional)
- **Docker** (Conteinerização da aplicação e serviços auxiliares)
- **WireMock** (Simulação de API externa)
- **OpenAPI/Swagger** (Documentação da API)
- **Spring Dependency Injection** (Injeção de dependências)
- **JUnit/Testcontainers** (Testes automatizados)

---

## Funcionalidades
1. Consultar informações de um CEP.
2. Salvar logs de todas as consultas realizadas.
3. Listar todos os logs armazenados no banco.
4. Retornar erros customizados para CEPs inexistentes.
5. API documentada com **Swagger**.
6. Implementação seguindo os princípios **SOLID**.

---

## Endpoints da API

### **Consulta de CEP**
- **GET /zipcode/{cep}**
    - Consulta um CEP e salva o log.
    - **Exemplo de retorno:**
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
    - Retorna todos os logs armazenados.
    - **Exemplo de retorno:**
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

### **Pré-requisitos**
- **Java 17**
- **Maven**
- **Docker**

### **Passos**
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/zipcode-logs.git
   cd zipcode-logs
   ```

2. **Suba os contêineres Docker**:
   ```bash
   docker-compose up --build
   ```

3. **Acesse a API Swagger para testar os endpoints**:
    - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

4. **Acesse o banco de dados PostgreSQL**:
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
    |   |-- RestTemplateConfig.java  # Configuração de beans do RestTemplate
    |   |-- SwaggerConfig.java       # Configuração da documentação Swagger
    |
    |-- controllers
    |   |-- ZipCodeController.java   # Controlador que expõe os endpoints da API
    |
    |-- domain
    |   |-- ZipCodeLog.java          # Entidade JPA que representa os logs no banco
    |
    |-- dtos
    |   |-- ZipCodeResponse.java     # DTO para resposta de consulta de CEP
    |   |-- ErrorResponse.java       # DTO para padronizar erros
    |
    |-- exceptions
    |   |-- GlobalExceptionHandler.java # Captura e trata erros na API
    |
    |-- repositories
    |   |-- ZipCodeLogRepository.java  # Interface para operações no banco de dados
    |
    |-- services
        |-- implementations
            |-- ZipCodeService.java    # Implementação do serviço de busca de CEP
            |-- ZipCodeLogService.java # Implementação do serviço de logs
        |
        |-- interfaces
            |-- IZipCodeService.java    # Interface para busca de CEP
            |-- IZipCodeLogService.java # Interface para logs de CEP

src/main/resources
|-- db/migration
    |-- V1_create_zipcode_logs_table.sql  # Script para criar a tabela de logs
|-- wiremock/mappings
    |-- fallback.json  # Simulação de erro para CEPs inválidos
    |-- mapping.json   # Simulação de resposta para CEPs existentes
|-- application.properties  # Configuração do banco e API externa
```

---

## Documentação Swagger
Acesse a interface Swagger para visualizar e testar os endpoints da API:
- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Contato
Caso tenha dúvidas ou sugestões, entre em contato:
- **Desenvolvedor**: [Maicon Nakao]
- **Email**: [nakao.mds@gmail.com]
- **GitHub**: [https://github.com/NakaoMD]

---

### **📌 Últimas Melhorias**
✅ Implementação de **injeção de dependência via construtor**  
✅ Uso de **interfaces** para desacoplamento dos serviços  
✅ **GlobalExceptionHandler** para tratamento de erros centralizado  
✅ **Testes automatizados** com JUnit e Testcontainers

---

