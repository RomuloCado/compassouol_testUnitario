package com.compassouol.produtos.controller.form;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.compassouol.produtos.models.Estoque;
import com.compassouol.produtos.models.Produtos;
import com.compassouol.produtos.repository.EstoqueRepository;
import com.compassouol.produtos.repository.ProdutosRepository;

/**
 *a classe define quais parametros serão exigidos e validados para realizar mudanças
 *e cadastros de produtos e quantidade no estoque
 */
public class ProdutosForm {
	
	@NotNull @NotEmpty
	private String descricao;
	@NotNull @Min(0)
	private BigDecimal valor;
	@NotNull @Min(1)
	private Integer quantidade;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produtos converter() {
		Estoque estoque = new Estoque(this.quantidade);
		return new Produtos(descricao, valor, estoque);
	}

	public Produtos atualizar(Long id, ProdutosRepository produtosRepository, EstoqueRepository estoqueRepository) {
		Produtos produto = produtosRepository.getOne(id);
		Estoque estoque = estoqueRepository.getOne(id);
		estoque.setQuantidade(this.quantidade);
		produto.setDescricao(this.descricao);
		produto.setValor(this.valor);
		produto.setEstoque(estoque);
		return produto;
	}
	
}
