# Cursos Online API

Este projeto é um sistema de gerenciamento de cursos online desenvolvido com Spring Boot, utilizando persistência com JDBC e JPA/Hibernate, integrado a um banco de dados MySQL rodando em Docker.

## Funcionalidades
- Gerenciamento de cursos e instrutores com operações CRUD.
- Consultas dinâmicas e personalizadas.
- Gerenciamento de transações com rollback.
- Suporte a JDBC e JPA/Hibernate para persistência.
- Otimizações como pooling de conexões e validações.
- Endpoints REST para interagir com o sistema.

---

## Pré-requisitos
- [Docker](https://www.docker.com/)
- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)

---

## Iniciar o Docker e o Projeto

### 1. Subir o Banco MySQL com Docker
1. Certifique-se de que o Docker está instalado e em execução.
2. Clone este repositório:
   ```bash
   git clone https://github.com/matheus3pires/cursos-online-api.git
   cd cursos-online-api
   ```
3. Suba o container do MySQL com o seguinte comando:
   ```bash
   docker-compose up -d
   ```
   Isso cria o banco de dados `cursos_online` no MySQL, acessível em `localhost:3306` com as credenciais:
   - **Usuário:** `root`
   - **Senha:** `senha`

4. Verifique se o container está rodando:
   ```bash
   docker ps
   ```

### 2. Iniciar a Aplicação
1. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
2. A API estará disponível em: `http://localhost:8080`.

---

## Testar os Endpoints com cURL ou Postman

### Exemplos de Requisições

#### Criar um Curso
```bash
POST http://localhost:8080/api/jpa/cursos
{"titulo": "Curso de Java", "duracaoHoras": 40, "instrutorId": 1}
```

#### Buscar Todos os Cursos
```bash
GET http://localhost:8080/api/jpa/cursos
```

#### Atualizar um Curso
```bash
PUT http://localhost:8080/api/jpa/cursos/{id}
{"titulo": "Curso de Spring Boot", "duracaoHoras": 50, "instrutorId": 1}
```

#### Deletar um Curso
```bash
DELETE http://localhost:8080/api/jpa/cursos/{id}
```

### Testar com Postman
1. Certifique-se de que a API está rodando em `http://localhost:8080`.

---

## Boas Práticas Aplicadas

### JDBC
1. **Prevenção de SQL Injection**:
   - Uso de parâmetros no `PreparedStatement` para evitar SQL Injection.
2. **Batch Processing**:
   - Implementação de métodos para inserir múltiplos registros de forma eficiente.
3. **Mapeamento de ResultSet**:
   - Conversão de resultados SQL em objetos Java com clareza e robustez.

### JPA
1. **FetchType.LAZY**:
   - Configurado para carregar relacionamentos sob demanda, evitando o problema N+1.
2. **Consultas Derivadas e JPQL**:
   - Métodos personalizados para consultas eficientes.
3. **Validações**:
   - Uso de anotações como `@NotNull` e `@Positive` para garantir integridade dos dados.

### Geral
1. **Gerenciamento de Transações**:
   - Uso de `@Transactional` para rollback em erros.
2. **Pooling de Conexões**:
   - Configuração do HikariCP para melhorar a performance.

---

## Comparação entre JDBC e JPA

### JDBC
- **Vantagens**:
  - Controle direto sobre as queries SQL.
  - Ideal para cenários onde a performance é crítica e o controle sobre a base de dados é essencial.
  - Mais adequado para operações em lote (batch processing).
- **Desvantagens**:
  - Necessidade de código repetitivo para mapear resultados.
  - Menor produtividade em consultas complexas.

### JPA
- **Vantagens**:
  - Simplifica o gerenciamento de objetos e relacionamentos.
  - Permite abstrair as consultas com JPQL e métodos derivados.
  - Suporte a estratégias de cache e otimizações automáticas.
- **Desvantagens**:
  - Overhead em cenários de alto desempenho.
  - Requer entendimento das configurações de mapeamento e caching.

**Resumo**: JDBC é mais indicado para controle e performance em baixo nível, enquanto JPA aumenta a produtividade e a abstração em projetos com foco em objetos e relacionamentos.

---

## Evidências
Em anexo na atividade do Teams.
