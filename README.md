# 🚀 Quarkus Playground

Este projeto é um ambiente de testes e aprendizado com o framework **[Quarkus](https://quarkus.io/)**, explorando alternativas ao ecossistema **Spring Boot** no desenvolvimento Java moderno.

## 📚 Objetivo

Explorar o Quarkus na prática para entender:
- A inicialização e performance otimizadas
- Suporte a microserviços e cloud-native
- Comparações com Spring Boot (quando aplicável)
- Ecossistema e boas práticas do Quarkus

## 🧪 Funcionalidades em teste

- Estrutura básica de um projeto Quarkus
- RESTful APIs com Jakarta REST (JAX-RS)
- Injeção de dependência com CDI
- Configurações via `application.properties`
- Testes com JUnit e REST Assured
- Hot reload com Dev Mode (`quarkus:dev`)

## 🚀 Como rodar

```bash
./mvnw quarkus:dev
```

Ou, se estiver usando Gradle:

```bash
./gradlew quarkusDev
```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

## 🛠 Requisitos

- Java 17+
- Maven ou Gradle
- IDE de sua preferência (VSCode, IntelliJ, etc.)

## 📦 Como gerar o projeto

Você pode gerar um novo projeto usando o Quarkus CLI:

```bash
quarkus create app com.seuprojeto.quarkus-playground
cd quarkus-playground
```

Ou usando o site oficial: [code.quarkus.io](https://code.quarkus.io)

## 📌 Notas

- Este projeto **não é para produção**.
- O foco é aprendizado e experimentação com o Quarkus e sua abordagem para APIs e microserviços.

## 📄 Licença

MIT – sinta-se livre para usar, modificar e aprender com o código.
