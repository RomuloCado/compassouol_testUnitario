<h1 align="center"> Compassouol Testes Unitários da API de Produtos em Estoque<h1>

# Índice

- [Sobre](#-sobre)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Testes](#testes)
- [Como baixar o projeto](#-como-baixar-o-projeto)

## 🔖&nbsp; Sobre
A API Produtos em Estoque foi implimentada com testes unitários. Eles são realizados para verificar se a lógica ou regra de negócio de um método da API ou do Sistema está funcionando corretamente, se o seu retorno está sendo o esperado da funcionalidade. A grande vantagem de utilizar testes unitários é a possibilidade de não depender do funcionamento total da API, as ferramentas permitem isolar aquele método ou função, e rodar a sua lógica sem a necessidade de tudo na API estar funcionando, além de serem baratos e rápidos que possuem a vantagem de serem criados durante a fase de desenvolvimento.

Ter uma boa cobertura de testes nas funcionalidades da API é essencial para garantir a qualidade do software. Durante o build da aplicação são rodados os testes que foram implementados, e se algum dos testes apresentar falha, o deploy da aplicação não será realizado.

A utilização de testes unitários traz, ainda, uma certeza em todo o trabalho da equipe. Assim, a segurança de apresentar um produto com todos os erros solucionados dá garantias de uma durabilidade maior, além de aprimorar a qualidade do novo software. 

Na API de Produtos em Estoque, a classe que foi implementada os testes é o ProdutosService, classe que é responsável pelos serviços da aplicação. O teste realizado foi no método **"atualizaProduto()"**, que é responsável de pegar um produto que ja está cadastrado, e atualizar qualquer campo dele, como a descrição, valor, ou quantidade em estoque. No teste foi colocado como primeiro produto o Playstation 5, e depois foi atualizado para Playstation 4, assim como seu valor e quantidade em estoque também. Foi verificado que o produto que tinha sido cadastrado antes realmente foi atualizado com o método **assertThat().isEqualTo**, onde o produto inicial deixou de ser o Playstation 5 e passou a ser o Playstation 4.

O projeto **Produtos em Estoque** é uma API REST desenvolvida na linguagem Java, com o framework Spring Boot, tem o intuito de manipular no banco de dados a lista de produtos 
relacionados com seu estoque, contendo a descrição do produto, o valor, e sua quantidade em estoque. Permite o cadastro, busca, atualização, e exclusão.
Através dos métodos REST:
-GET
-POST
-PUT
-DELETE

---

## 🚀 Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias

- [SpringBoot](https://spring.io/projects/spring-boot)
- [Swagger](http://springfox.github.io/springfox/)
- [Flyway](https://flywaydb.org/documentation/usage/api/#download)
- [MySQL](https://www.mysql.com)
- [Docker](https://www.docker.com/get-started)
- [Mockito](https://site.mockito.org)
- [jUnit](https://junit.org/junit5/)

---

## Testes

Para realizar os testes unitários da aplicação, **verifique as configurações do banco de dados MySQL e configure de acordo com o banco de dados da sua máquina**, após isso basta entrar no diretório src/test/java/com/compassouol/produtos/ProdutosReposioryTest, e rodar jUnit Test.

Para realizar os testes da aplicação pode ser utilizado o Postman ou a própria documentação Swagger do projeto (http://localhost:8080/swagger-ui.html).

---

## 🗂 Como baixar o projeto

```bash
    # Clonar o repositório
    $ git clone https://github.com/RomuloCado/compassouol_testUnitario
    # Entrar no diretório
    $ cd compassouol
```

---

Desenvolvido por Rômulo Cadó Dorneles.

