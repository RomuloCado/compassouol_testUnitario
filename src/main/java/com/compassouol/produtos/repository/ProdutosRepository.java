package com.compassouol.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compassouol.produtos.models.Produtos;
//interface que realiza a busca filtrando pela coluna descricao no banco da tabela estoque 
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	List<Produtos> findByDescricao(String descricaoProduto);
		
}
