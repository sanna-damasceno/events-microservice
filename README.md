# Events Microservice

Microsserviço desenvolvido em Java com Spring Boot para gerenciamento de eventos e inscrições de participantes, com integração a um segundo microsserviço responsável pelo envio de e-mails de confirmação.

## Tecnologias utilizadas

- Java 21
- Spring Boot 4.1.2
- Spring Data JPA
- Spring Web MVC
- Spring Cloud OpenFeign
- H2 Database
- Maven
- Lombok

## Funcionalidades

- Cadastro de eventos.
- Listagem de todos os eventos.
- Consulta de eventos futuros.
- Inscrição de participantes em eventos.
- Verificação da disponibilidade de vagas.
- Registro das inscrições no banco de dados.
- Envio de e-mail de confirmação após a inscrição, por meio de outro microsserviço.

## Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- JDK 21 ou superior.
- Git.
- Uma IDE, como IntelliJ IDEA ou Visual Studio Code.

Além disso, para que a funcionalidade de confirmação por e-mail funcione, o microsserviço de envio de e-mails também deve estar em execução.

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/sanna-damasceno/events-microservice.git
```

### 2. Entrar na pasta do projeto

```bash
cd events-microservice
```

### 3. Executar a aplicação

No Windows, utilize:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada na porta `8081`.

## Endpoints disponíveis

A API possui os seguintes endpoints:

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/events` | Lista todos os eventos |
| GET | `/events/upcoming` | Lista os próximos eventos |
| POST | `/events` | Cadastra um novo evento |
| POST | `/events/{eventId}/register` | Inscreve um participante em um evento |

### Exemplos de requisições

#### Cadastrar evento

**POST** `/events`

```json
{
  "maxParticipants": 50,
  "registeredParticipants": 0,
  "date": "2026-12-15T19:00:00",
  "title": "Workshop de Java",
  "description": "Workshop sobre desenvolvimento com Java e Spring Boot."
}
```

#### Inscrever participante

**POST** `/events/{eventId}/register`

```json
{
  "participantEmail": "participante@email.com"
}
```

Após a inscrição, o sistema registra o participante, atualiza a quantidade de inscritos e solicita o envio de um e-mail de confirmação ao microsserviço de e-mail.

## Banco de dados

O projeto utiliza o H2 Database em memória, integrado ao Spring Data JPA.

Como o banco é configurado em memória, os dados cadastrados são perdidos quando a aplicação é encerrada.

## Integração com o microsserviço de envio de e-mails

A comunicação entre os microsserviços é realizada por meio de requisições HTTP, utilizando Spring Cloud OpenFeign.

O `events-microservice` envia uma solicitação ao segundo microsserviço, responsável pelo envio da mensagem de confirmação utilizando a AWS Simple Email Service (SES).

O microsserviço de envio de e-mails foi desenvolvido com base no projeto de referência da Fernanda Kipper:

- **Repositório:** [desafio-backend-uber](https://github.com/Fernanda-Kipper/desafio-backend-uber)

Para que a integração funcione, o serviço de e-mail deve estar em execução na porta `8080`, disponibilizando o endpoint:

```text
http://localhost:8080/api/email/send
```

O microsserviço de eventos, por sua vez, utiliza a porta `8081`.

## Créditos e finalidade educacional

Este projeto foi desenvolvido exclusivamente para fins educacionais, como atividade prática de aprendizado e aplicação dos conceitos de desenvolvimento de microsserviços com Spring Boot.

O desenvolvimento foi baseado no conteúdo apresentado por **Fernanda Kipper**, por meio de seu vídeo sobre construção de microsserviços com Java, acompanhado durante o processo de implementação.
- **Vídeo de referência:** [CONSTRUINDO MICROSSERVIÇOS COM JAVA – Fernanda Kipper](https://www.youtube.com/watch?v=yACzWg9gUGM)

## Autora

**Sanna Damasceno**

GitHub: [sanna-damasceno](https://github.com/sanna-damasceno)