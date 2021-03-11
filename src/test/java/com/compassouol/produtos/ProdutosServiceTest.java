package com.compassouol.produtos;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import com.compassouol.produtos.controller.form.ProdutosForm;
import com.compassouol.produtos.models.Estoque;
import com.compassouol.produtos.models.Produtos;
import com.compassouol.produtos.repository.EstoqueRepository;
import com.compassouol.produtos.repository.ProdutosRepository;
import com.compassouol.produtos.service.ProdutosService;

public class ProdutosServiceTest {
 

	@Mock
	private ProdutosRepository repositoryProdutos;
	
	@Mock
	private EstoqueRepository repositoryEstoque;
	
	@InjectMocks
	private ProdutosService produtosService; 
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		this.produtosService = new ProdutosService(repositoryProdutos, repositoryEstoque);
	}

	@Test
	public void atualizaProduto() {

		Produtos produto = exemploProduto();
		
	    when(repositoryProdutos.getOne(produto.getId())).thenReturn(produto);
	    when(repositoryEstoque.getOne(produto.getEstoque().getId())).thenReturn(produto.getEstoque());
	    
	    ProdutosForm produtoAtualizado = new ProdutosForm(exemploProduto2());
	    
	    produtosService.atualizaProduto(produto.getId(), produtoAtualizado);
	    
	    // Apartir daqui o produto foi atualizado para o seundo exemplo 
	    assertThat(produto.getDescricao()).isEqualTo("Playstation 4");
		assertThat(produto.getValor()).isEqualTo(new BigDecimal(2500));
		assertThat(produto.getEstoque().getQuantidade()).isEqualTo(50);		

	}

	public Produtos exemploProduto() {
		Produtos produto = new Produtos("Playstation 5", new BigDecimal(5000), new Estoque(78));
		return produto;
	}

	public Produtos exemploProduto2() {
		Produtos produto = new Produtos("Playstation 4", new BigDecimal(2500), new Estoque(50));
		return produto;
	}

}