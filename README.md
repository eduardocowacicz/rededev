# RedeDev

Sistema de vagas para programadores desenvolvido como trabalho final da disciplina de Análise e Programação Orientada a Objetos.

## Sobre

O RedeDev é uma plataforma que conecta programadores e contratantes. Programadores cadastram seu perfil com competências e experiências, e podem se candidatar a vagas. Contratantes publicam vagas e gerenciam as candidaturas.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- HTML, CSS e JavaScript
- Bootstrap

## Como executar

Precisa ter o Java 17 e o Maven instalados.

```
mvn spring-boot:run
```

Depois acesse http://localhost:8082

## Usuários para teste

Programadores:
- joao@email.com / 123456
- maria@email.com / 123456

Contratante:
- carlos@email.com / 123456

## Estrutura

O projeto segue o padrão DDD:

- domain - entidades do sistema
- repository - acesso ao banco
- service - regras de negócio
- controller - endpoints REST
