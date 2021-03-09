package com.compassouol.produtos;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.compassouol.produtos.models.Estoque;
import com.compassouol.produtos.models.Produtos;
import com.compassouol.produtos.repository.ProdutosRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProdutosRepositoryTest {

	@Autowired
	private ProdutosRepository repository;


	@Test
	public void salvaProdutoTest() {
		Produtos produto = exemploProduto();
		this.repository.save(produto);

		assertThat(produto.getId()).isNotNull();
		assertThat(produto.getDescricao()).isEqualTo("Playstation 5");
		assertThat(produto.getValor()).isEqualTo(new BigDecimal(5000));
		assertThat(produto.getEstoque().getQuantidade()).isEqualTo(78);
	}

	@Test
	public void encontraProdutoPelaDescricaoTest() {
		Produtos produto = exemploProduto();

		this.repository.save(produto);

		List<Produtos> studentList = repository.findByDescricao("Playstation 5");

		assertThat(studentList.size()).isEqualTo(1);

	}

	@Test
	public void deletaProdutoTest() {
		Produtos produto = exemploProduto();
		this.repository.save(produto);
		repository.delete(produto);
		assertThat(repository.findById(produto.getId())).isEmpty();

	}

	@Test
	public void atualizaProdutoTest() {
		Produtos produto = exemploProduto();
		this.repository.save(produto);

		produto = new Produtos("Playstation 4", new BigDecimal(2500), new Estoque(150));
		this.repository.save(produto);

		produto = repository.findById(produto.getId()).orElse(null);

		assertThat(produto.getDescricao()).isEqualTo("Playstation 4");
		assertThat(produto.getValor()).isEqualTo(new BigDecimal(2500));
		assertThat(produto.getEstoque().getQuantidade()).isEqualTo(150);
	}



	public Produtos exemploProduto() {
		Produtos produto = new Produtos("Playstation 5", new BigDecimal(5000), new Estoque(78));
		return produto;
	}

}