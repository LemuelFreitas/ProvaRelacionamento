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

import com.ProvaRelacionamentos.Entities.FornecedorEntities;
import com.ProvaRelacionamentos.service.FornecedorService;

	
import jakarta.validation.Valid;


@RestController
@RequestMapping("/fornecedor")
@CrossOrigin(origins="*")
public class FornecedorController {

	private final FornecedorService fornecedorService;

	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@GetMapping("/{id}")

	public ResponseEntity<FornecedorEntities> buscaFornecedorControlId(@PathVariable Long id) {
		FornecedorEntities Fornecedor = fornecedorService.buscaFornecedorsId(id);
		if (Fornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping

	public ResponseEntity<List<FornecedorEntities>> buscaTodosFornecedorControl() {
		List<FornecedorEntities> Fornecedor = fornecedorService.buscaTodosFornecedor();
		return ResponseEntity.ok(Fornecedor);
	}

	@PostMapping

	public ResponseEntity<FornecedorEntities> salvaFornecedorControl(@RequestBody @Valid FornecedorEntities fornecedor) {
		FornecedorEntities salvaFornecedor = fornecedorService.salvaFornecedor(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFornecedor);
	}

	@PutMapping("/{id}")

	public ResponseEntity<FornecedorEntities> alterarFornecedorControl(@PathVariable Long id, @RequestBody @Valid FornecedorEntities Fornecedor) {
		FornecedorEntities alterarFornecedor = fornecedorService.alterarFornecedor(id, Fornecedor);
		if (alterarFornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<FornecedorEntities> apagaFornecedorControl(@PathVariable Long id) {
		boolean apagar = fornecedorService.apagarFornecedors(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
