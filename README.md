# Projeto DSProducts

## Features

- CRUD completo de Departamentos (incluindo listagem de departamentos para que o usuário selecione um departamento)
- Busca de produtos por nome do departamento
- Busca de produtos por texto na descrição
- Buscar todos detalhes de um produto inclusive suas propriedades

## Diagrama

![CASSANDRA SYSTEM](https://user-images.githubusercontent.com/12695598/129626658-895e5270-2a29-4aae-b482-6698be75a22b.PNG)

## Tech

Tecnologia e Patterns utilizados:

- Java/Spring - Backend!.
- Cassandra.

## Documentação 
Cassandra https://cassandra.apache.org/doc/latest

Spring Data Cassandra
https://docs.spring.io/spring-data/cassandra/docs/current/reference/html

## DECISOES

Utilizar cassandra para trabalhar com agregacoes e ter em apenas uma consulta todos os dados necessarios como departamento e caracteristicas do produto que esta na tabela props

COMANDOS - TESTE

```sh
describe keyspaces

CREATE KEYSPACE testdb WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

use testdb;

describe tables

CREATE TABLE post(id uuid, moment timestamp, body text, author varchar, PRIMARY KEY (id));

INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-26T10:00:00Z', 'Bom dia!', 'Bob');
INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-27T10:00:00Z', 'Partiu viagem', 'Maria');
INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-27T10:00:00Z', 'Que dia bonito!', 'Maria');

SELECT * FROM post;

SELECT * FROM post WHERE author = 'Maria' ALLOW FILTERING;

CREATE CUSTOM INDEX body_idx ON post (body) USING 'org.apache.cassandra.index.sasi.SASIIndex' WITH OPTIONS = {'mode': 'CONTAINS', 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer','case_sensitive': 'false'};

SELECT * FROM post WHERE body LIKE '%MORNING%';

```
