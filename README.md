<h1 align="center"> Compassouol Testes Unitários da API de Produtos em Estoque<h1>

# Índice

- [Sobre](#-sobre)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Testes](#testes)
- [Como baixar o projeto](#-como-baixar-o-projeto)

## 🔖&nbsp; Sobre
A API foi implimentada com testes unitários. Eles são realizados para verificar se a lógica ou regra de negócio de um método da API ou do Sistema está funcionando corretamente, se o seu retorno está sendo o esperado da funcionalidade. A grande vantagem de utilizar testes unitários é a possibilidade de não depender do funcionamento total da API, as ferramentas permitem isolar aquele método ou função, e rodar a sua lógica sem a necessidade de tudo na API estar funcionando, além de serem baratos e rápidos que possuem a vantagem de serem criados durante a fase de desenvolvimento.

Ter uma boa cobertura de testes nas funcionalidades da API é essencial para garantir a qualidade do software. Durante o build da aplicação são rodados os testes que foram implementados, e se algum dos testes apresentar falha, o deploy da aplicação não será realizado.

A utilização de testes unitários traz, ainda, uma certeza em todo o trabalho da equipe. Assim, a segurança de apresentar um produto com todos os erros solucionados dá garantias de uma durabilidade maior, além de aprimorar a qualidade do novo software. 

Na API de Produtos em Estoque, a classe que foi implementada os testes é o ProdutosRepository, classe que é responsável por guardar e tratar os objetos a ela instanciados, ela que realiza essa ponte entre a aplicação e o banco de dados. Foi passado um objeto “Produtos” como teste, e esse objeto passa por quatro testes unitários da classe, primeiramente no método **“salvaProdutoTest”** ele testa o método “repository.save()”, e verifica-se se os dados que foram instanciados foram mandados sem erros ou alterações. O segundo teste **“encontaProdutoPelaDescricaoTest”** é de realizar a busca pelo campo “descricao” pelo produto cadastrado, que deve retornar uma lista com um produto.
O terceiro teste **“deletaProdutoTest”** é realizar a exclusão desse produto, e para verificar o funcionamento correto, realiza-se uma busca pelo produto, esta tem que retornar vazia. E o quarto teste **“ataualizaProdutoTest”** é atualizar um produto cadastrado, onde e realizado dois “repository.save()”, um para o produto desatualizado e outro para sua atualização. 

Os testes unitários assim passaram pelas quatro principais funcionalidades da API, que são o cadastro, a atualização, busca, e exclusão de um produto. Garantindo que o software está funcionando de maneira devida para estas funcionalidades, permitindo uma segurança, qualidade, e facilidade para implementar novas funcionalidades ou regras de negócio.

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

Para realizar os testes unitários da aplicação, **verifique as configurações do banco de dados MySQL e configure de acordo com banco de dados da sua máquina**, após isso bastar entrar no diretório src/test/java/com/compassouol/produtos/ProdutosReposioryTest, e rodar jUnit Test.
Para realizar os testes da aplicação pode ser utilizado o Postman ou a própria documentação Swagger do projeto (http://localhost:8080/swagger-ui.html).

---

## 🗂 Como baixar o projeto

```bash
    # Clonar o repositório
    $ git clone https://github.com/RomuloCado/compassouol
    # Entrar no diretório
    $ cd compassouol
```

---

Desenvolvido por Rômulo Cadó Dorneles.

