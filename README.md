# Backend - Portaria UFN

API REST desenvolvida com **Spring Boot** para controle de entrada e saída de itens na portaria da Universidade Franciscana (UFN).

## 🚀 Funcionalidades

- 📦 Cadastro e listagem de itens
- 👨‍💼 Cadastro e listagem de usuários
- 🔄 Registro de empréstimos e devoluções
- 🧾 Histórico das movimentações (futuramente)
- 🔗 Integração com frontend React

## 🧰 Tecnologias usadas

- Java 23
- Spring Boot 3.5
- MongoDB
- Maven

## 📂 Estrutura do projeto

```
backend/
├── src/
│   └── main/
│       ├── java/br/edu/ufn/portaria/
│       │   ├── controller/
│       │   ├── model/
│       │   ├── repository/
│       │   └── BackendApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
```

## ⚙️ Configuração

No arquivo `application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/portaria
```

Certifique-se de que o **MongoDB esteja rodando** (via Docker ou serviço local).

## ▶️ Como rodar

1. Compile e execute com o IntelliJ ou:

```bash
cd backend
./mvnw spring-boot:run
```

A API será iniciada em `http://localhost:8080`.
