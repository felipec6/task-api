# Projeto de Gerenciamento de Tarefas

## Tecnologias Utilizadas

- **Java 21**  
  A versão mais recente do Java com melhorias de desempenho, segurança e recursos modernos para desenvolvimento robusto.

- **Spring Boot 3.5.4**  
  Framework que facilita a criação de aplicações Java baseadas em Spring, com configuração automática e suporte para microsserviços.

- **Spring Data JPA**  
  Simplifica a integração com bancos de dados relacionais, facilitando a manipulação de dados usando entidades Java e repositórios.

- **Banco H2 (modo compatível DB2)**  
  Banco de dados relacional em memória para desenvolvimento e testes rápidos, com sintaxe compatível com DB2.

- **Lombok**  
  Biblioteca para reduzir código boilerplate no Java, gerando getters, setters, builders, construtores e outros automaticamente.

- **Flyway**  
  Ferramenta para versionamento e migração automática do banco de dados, garantindo que o esquema esteja sempre atualizado conforme o código evolui.
---

## Como rodar o projeto

### Pré-requisitos

- Java 21 instalado e configurado no PATH
- Maven (ou Gradle) instalado para buildar o projeto
- IDE recomendada: IntelliJ IDEA, Eclipse ou VS Code com suporte Java

### Passos para rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/felipec6/task-api.git

2. Build do projeto:
   ```bash
    mvn clean install
   
3. Executar a aplicação:
   ```bash
    mvn spring-boot:run
   
4. A aplicação estará disponível em:
    ```bash
    http://localhost:8080
   
5. Para acessar o console do banco H2 (modo desenvolvimento), acesse:
    ```bash
    http://localhost:8080/h2-console

Use as configurações do arquivo application.properties para conectar.

## Banco de Dados e Migrações

- O Flyway gerencia as migrações do banco automaticamente ao iniciar a aplicação, aplicando os scripts SQL na pasta src/main/resources/db/migration.
- Mantenha os scripts organizados e nomeados no padrão V1__descricao.sql, V2__descricao.sql, etc.
- Isso garante que seu esquema de banco de dados esteja sincronizado com a versão do código.

## Endpoints principais
- POST /tasks - Criar nova tarefa
- GET /tasks - Listar tarefas com paginação e filtros
- DELETE /tasks/{id} - Excluir tarefa por ID

## Observações
- Os IDs das entidades são gerados automaticamente pelo banco.
- Tratamento de exceções customizado retorna erros padronizados em JSON.
- O banco H2 é usado para desenvolvimento e testes; para produção substitua pela base adequada.


