package com.compassouol.produtos.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.compassouol.produtos.models.Produtos;
/**
 *classe que retorna os dados da entidade produto
 *sem a necessidade do controler relacionar-se com a própria entidade
 *permitindo uma maior segurança de estado dos dados
 */
public class ProdutosDto {

	private Long id;
	private String descricao;
	private BigDecimal valor;
	private Integer quantidade;
	
	public ProdutosDto(Produtos produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
		this.quantidade = produto.getEstoque().getQuantidade();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public static List<ProdutosDto> converter(List<Produtos> produtos) {
		return produtos.stream().map(ProdutosDto::new).collect(Collectors.toList());
	}

}
