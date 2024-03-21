package com.ProvaRelacionamentos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProvaRelacionamentos.Entities.ProdutoEntities;
import com.ProvaRelacionamentos.service.ProdutoService;

	
import jakarta.validation.Valid;


@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*")
public class ProdutoController {

	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("/{id}")

	public ResponseEntity<ProdutoEntities> buscaProdutoControlId(@PathVariable Long id) {
		ProdutoEntities Produto = produtoService.buscaProdutosId(id);
		if (Produto != null) {
			return ResponseEntity.ok(Produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping

	public ResponseEntity<List<ProdutoEntities>> buscaTodosProdutoControl() {
		List<ProdutoEntities> Produto = produtoService.buscaTodosProduto();
		return ResponseEntity.ok(Produto);
	}

	@PostMapping

	public ResponseEntity<ProdutoEntities> salvaProdutoControl(@RequestBody @Valid ProdutoEntities produto) {
		ProdutoEntities salvaProduto = produtoService.salvaProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
	}

	@PutMapping("/{id}")

	public ResponseEntity<ProdutoEntities> alterarProdutoControl(@PathVariable Long id, @RequestBody @Valid ProdutoEntities Produto) {
		ProdutoEntities alterarProduto = produtoService.alterarProduto(id, Produto);
		if (alterarProduto != null) {
			return ResponseEntity.ok(Produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<ProdutoEntities> apagaProdutoControl(@PathVariable Long id) {
		boolean apagar = produtoService.apagarProdutos(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
