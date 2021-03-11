package com.compassouol.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassouol.produtos.controller.form.ProdutosForm;
import com.compassouol.produtos.models.Estoque;
import com.compassouol.produtos.models.Produtos;
import com.compassouol.produtos.repository.EstoqueRepository;
import com.compassouol.produtos.repository.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	
	public ProdutosService() {
		
	}


	public ProdutosService(ProdutosRepository repositoryProdutos, EstoqueRepository repositoryEstoque) {
		this.estoqueRepository = repositoryEstoque;
		this.produtosRepository = repositoryProdutos;
	}


	public List<Produtos> retornaProdutoPelaDescricao(String descricao) {
		
		return produtosRepository.findByDescricao(descricao);
		
		
	}

	public List<Produtos> retornaTodosProdutos() {
		
		return produtosRepository.findAll();
		
	}
	
	public Produtos atualizaProduto(Long id, ProdutosForm form) {
		Produtos produto = produtosRepository.getOne(id);
		Estoque estoque = estoqueRepository.getOne(id);
		estoque.setQuantidade(form.getQuantidade());
		produto.setDescricao(form.getDescricao());
		produto.setValor(form.getValor());
		produto.setEstoque(estoque);
		return produto;
	}
	
	
	
}
