# Events Microservice

Microsserviço desenvolvido em Java com Spring Boot para gerenciamento de eventos e inscrições de participantes, com integração a um serviço externo de envio de e-mails.

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

O microsserviço de envio de e-mails também deve estar em execução para que a funcionalidade de confirmação por e-mail funcione.

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

A aplicação será iniciada na porta 8081.

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

Após a inscrição, o sistema registra o participante e solicita o envio de um e-mail de confirmação ao microsserviço de e-mail.

## Banco de dados

O projeto utiliza o H2 Database em memória, integrado ao Spring Data JPA.

Como o banco é configurado em memória, os dados cadastrados são perdidos quando a aplicação é encerrada.

## Integração com o serviço de e-mail

A comunicação entre os microsserviços é realizada por meio de requisições HTTP, utilizando Spring Cloud OpenFeign.

O serviço de eventos envia uma solicitação ao microsserviço de e-mail, que é responsável pelo envio da mensagem de confirmação utilizando a AWS Simple Email Service (SES).

Por padrão, o serviço de e-mail deve estar disponível em:

```text
http://localhost:8080/api/email/send
```

E o microsserviço de eventos utiliza a porta `8081`.

## Autora

Desenvolvido por [Sanna Damasceno](https://github.com/sanna-damasceno).