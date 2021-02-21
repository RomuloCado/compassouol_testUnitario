package com.compassouol.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compassouol.produtos.models.Estoque;
// interface que realiza a busca filtrando pela coluna quantidade no banco da tabela estoque 
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	Estoque findByQuantidade(Integer quantidade);

}
