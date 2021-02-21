package com.compassouol.produtos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.compassouol.produtos.controller.dto.ProdutosDto;
import com.compassouol.produtos.controller.form.ProdutosForm;
import com.compassouol.produtos.models.Produtos;
import com.compassouol.produtos.repository.EstoqueRepository;
import com.compassouol.produtos.repository.ProdutosRepository;


@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	/**
	  *O método listaTodos como padrão gera um lista com todos
	  *os produtos cadastrados, e também recebe como opcao de parametro
	  *uma string com a descricao do produto para filtrar a busca 
	  */
	@GetMapping
	public List<ProdutosDto> listaTodos(String descricao){
		
		if(descricao == null) {
			List<Produtos> produtos = produtosRepository.findAll();
			return ProdutosDto.converter(produtos);
		}else {
			List<Produtos> produtos = produtosRepository.findByDescricao(descricao);
			return ProdutosDto.converter(produtos);
		}		
	}
	
	/**
	  *O método cadastraProdutos recebe os dados de formulário através de uma requisição do Corpo,
	  *valida essa requisição, se algo vir fora do padrao da classe produtosForm será lançado um erro
	  *com a descrição d erro, se tudo estiver certo o produto é cadastrado no banco de dados
	  */
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutosDto> cadastrarProdutos(@RequestBody @Valid ProdutosForm produtosForm, UriComponentsBuilder uriBuider){
		Produtos produtos = produtosForm.converter();
		produtosRepository.save(produtos);
		
		URI uri = uriBuider.path("/produtos/{id}").buildAndExpand(produtos.getId()).toUri(); 
		
		return ResponseEntity.created(uri).body(new ProdutosDto(produtos));
	}
	
	/**
	  *O método produtoDetalhado recebe como parametro o id do produto
	  *e retorna se existir no banco de dados o produto
	  *se não lança o código not found
	  */
	@GetMapping("/{id}")
	public ResponseEntity<ProdutosDto> produtoDetalhado(@PathVariable Long id) {
		Optional<Produtos> produto = produtosRepository.findById(id);
		if(produto.isPresent()) {
			return ResponseEntity.ok(new ProdutosDto(produto.get()));
		}	
		return ResponseEntity.notFound().build();
		
	}
	
	/**
	  *O método atualizarProdutos recebe como parametro o id do produto
	  *e atualiza se existir no banco de dados o produto com o id do parametro,
	  *e se os novos dados estão de acordo com a validação, se não lança o código not found
	  */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutosDto> atualizarProdutos(@PathVariable Long id, @RequestBody @Valid ProdutosForm produtosForm){
		Optional<Produtos> produtos = produtosRepository.findById(id);
		if(produtos.isPresent()) {
			Produtos produto = produtosForm.atualizar(id, produtosRepository, estoqueRepository);
			return ResponseEntity.ok(new ProdutosDto(produto));
		}	
		return ResponseEntity.notFound().build();
	}
	
	/**
	  *O método deletarProdutos recebe como parametro o id do produto
	  *e deleta se existir no banco de dados o produto com o id do parametro,
	  *se não lança o código not found
	  */
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarProdutos(@PathVariable Long id){
		Optional<Produtos> produto = produtosRepository.findById(id);
		if(produto.isPresent()) {
			produtosRepository.deleteById(id);
			estoqueRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}	
		return ResponseEntity.notFound().build();
	}
}
