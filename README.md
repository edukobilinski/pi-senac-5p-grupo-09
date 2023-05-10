<!-- Título -->
# PI: Análise de Soluções Integradas para Organizações


<!-- Descrição -->
## Sobre o Projeto

O objetivo do projeto é criar uma ferramenta web que possa ser utilizada para 
promover campanhas de doação e arrecadação coletiva para causas sociais, 
atreladas a divulgação em redes sociais dos usuários, para promover a 
comunicação e atender às necessidades de pessoas que precisam de ajuda e assim, 
usando o _DoeAção_ como veículo de ajuda e comunicação.


<!-- TOC -->
## Table of contents

- [PI: Análise de Soluções Integradas para Organizações](#pi-analise-de-solucoes-integradas-para-organizacoes)
  - [Sobre o Projeto](#sobre-o-projeto)
  - [Table of contents](#table-of-contents)
  - [Features](#features)
  - [Demonstração da aplicação](#demonstração-da-aplicação)
    - [Modelo conceitual](#modelo-conceitual)
  - [Pré-requisitos](#pré-requisitos)
    - [Rodando a aplicação](#rodando-a-aplicação)
    - [Rodando o Back-end](#rodando-o-back-end)
  - [Tecnologias Utilizadas](#tecnologias-utilizadas)
    - [Front-end](#front-end)
    - [Back-end](#back-end)
    - [Cloud](#cloud)
  - [Autores](#autores)
- [Trabalho Escrito](#trabalho-escrito)


<!-- Features -->
## Features

- [x] Cadastro de campanha
- [ ] Contribuição para campanha
- [ ] Divulgação em redes sociais



<!-- Demonstração da aplicação -->
## Demonstração da aplicação

- Ver.1.0
- Jornada do usuário criando campanhas:

![vídeo ou gif](https://github.com/edukobilinski/pi-senac-5p-grupo-09/blob/master/assets/doe-acao-gif01.gif)

### Modelo conceitual

![Diagrama de caso de uso](https://github.com/edukobilinski/pi-senac-5p-grupo-09/blob/master/assets/diagrama-de-caso-de-uso.png)



<!-- Pré-requisitos e como rodar a aplicação/testes -->
## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes 
ferramentas: [Git](https://git-scm.com), [Node.js](https://nodejs.org/en/) e 
[NPM](https://www.npmjs.com/). Além disto é bom ter um editor para trabalhar com 
o código como [VSCode](https://code.visualstudio.com/).

- Node v14.17.0
- Npm v6.14.13

### Rodando a aplicação

```bash
# Clone este repositório
$ git clone <https://github.com/edukobilinski/pi-senac>

# Acesse a pasta do projeto no terminal/cmd
$ cd frontend/doe-acao-frontend

# Instale as dependências
$ npm install

# Execute a aplicação em modo de desenvolvimento
$ http-server --port 8080

# O servidor inciará na porta: 8080 - acesse <http://localhost:8080/>
```


Com o guia acima já é o suficiente para ter acesso às funcionalidades da aplicação 
conforme as features já implementadas até o momento.

O backend está rodando e disponível no [Heroku](https://www.heroku.com/about), porém, 
caso queira rodar o backend de forma local, deve seguir os seguintes pré-requisitos:

Ter instalado em sua máquina as seguintes ferramentas: [Git](https://git-scm.com) 
e o [Docker](https://www.docker.com/).

### Rodando o Back-end

```bash
# Clone este repositório
$ git clone <https://github.com/edukobilinski/pi-senac>

# Acesse a pasta do projeto no terminal/cmd
$ cd backend

# Criar a Imagem/Container executando o Dockerfile
$ docker build -t doe-acao-front:1.0 .

# Executar o Container
$ docker run -p 8082:8082 doe-acao-front:1.0

# O servidor inciará na porta: 8082 - acesse <http://localhost:8082/doeacao>
```


<!-- Tecnologias utilizadas -->
## Tecnologias Utilizadas

Para o desenvolvimento foram utilizadas as seguintes tecnologias:

### Front-end

- Drawn.io [⏎](assets/diagrama-de-caso-de-uso.drawio) / sobre: [⏎](https://www.diagrams.net/)
- Figma [⏎](https://www.figma.com/file/1ysmi0XerRzNBmmEq2RdiK/DoeA%C3%A7%C3%A3o?node-id=0%3A1) / sobre: [⏎](https://www.figma.com/about/)
- HTML [⏎](https://html.spec.whatwg.org/multipage/)
- JavaScript [⏎](https://www.javascript.com/)
- Bootstrap [⏎](https://getbootstrap.com/)
- CSS [⏎](https://www.w3.org/Style/CSS/)

### Back-end

- Java 11 LTS [⏎](https://jdk.java.net/11/)
- Apache Maven [⏎](https://maven.apache.org/)
- Framework Spring [⏎](https://spring.io/)
- Banco de Dados Relacional H2 [⏎](https://app-doeacao.herokuapp.com/doeacao/h2-console/login.jsp?jsessionid=d8fbd8e7c7daa7ef12686b2b7a24c323) / sobre: [⏎](https://www.h2database.com/html/main.html)
- Swagger [⏎](https://app-doeacao.herokuapp.com/doeacao/swagger-ui/index.html) / sobre: [⏎](https://swagger.io/about/)
- **Dependências:**
  - Spring Boot Starter Web [⏎](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web)
  - Spring Data JPA [⏎](https://spring.io/projects/spring-data-jpa)
  - Lombok [⏎](https://projectlombok.org/)
  - OpenAPI [⏎](https://www.openapis.org/)

### Cloud

- Heroku [⏎](https://www.heroku.com/about)



<!-- Autor -->
## Autores

- Eduardo Henrique Batista Gomes
- Eduardo Kobilinski de Araujo
- Elias Gonçalves de Albuquerque Júnior
- Ezequias Manoel Monteiro Dos Santos
- Fernanda Fonseca Scherer




---





# Trabalho Escrito

- [Link Trabalho escrito .pdf](https://github.com/edukobilinski/pi-senac-5p-grupo-09/blob/master/Grupo%2009%20-%20PI%20parte%202.pdf)
