package com.ProvaRelacionamentos.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProvaRelacionamentos.Entities.ProdutoEntities;
import com.ProvaRelacionamentos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	@Autowired

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	public  List<ProdutoEntities> buscaTodosProduto(){
		return produtoRepository.findAll();
	}
	public ProdutoEntities buscaProdutosId(Long id) {
		Optional <ProdutoEntities> Produtos = produtoRepository.findById(id);
		return Produtos.orElse(null);
	}
	public ProdutoEntities salvaProduto(ProdutoEntities Produto){
		return produtoRepository.save(Produto);
	}
	public ProdutoEntities alterarProduto(Long id, ProdutoEntities alterarProdutos) {
		Optional <ProdutoEntities> existeProdutos = produtoRepository.findById(id);
		if (existeProdutos.isPresent()) {
			alterarProdutos.setId(id);
			return produtoRepository.save(alterarProdutos);
		}
		return null;
	}
	public boolean apagarProdutos (Long id) {
		Optional <ProdutoEntities> existeProduto = produtoRepository.findById(id);
		if (existeProduto.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}