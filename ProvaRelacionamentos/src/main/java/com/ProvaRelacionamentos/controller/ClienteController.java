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

import com.ProvaRelacionamentos.Entities.ClienteEntities;
import com.ProvaRelacionamentos.service.ClienteService;

	
import jakarta.validation.Valid;


@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins="*")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/{id}")

	public ResponseEntity<ClienteEntities> buscaClienteControlId(@PathVariable Long id) {
		ClienteEntities Cliente = clienteService.buscaClientesId(id);
		if (Cliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping

	public ResponseEntity<List<ClienteEntities>> buscaTodosClienteControl() {
		List<ClienteEntities> Cliente = clienteService.buscaTodosCliente();
		return ResponseEntity.ok(Cliente);
	}

	@PostMapping

	public ResponseEntity<ClienteEntities> salvaClienteControl(@RequestBody @Valid ClienteEntities cliente) {
		ClienteEntities salvaCliente = clienteService.salvaCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
	}

	@PutMapping("/{id}")

	public ResponseEntity<ClienteEntities> alterarClienteControl(@PathVariable Long id, @RequestBody @Valid ClienteEntities Cliente) {
		ClienteEntities alterarCliente = clienteService.alterarCliente(id, Cliente);
		if (alterarCliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<ClienteEntities> apagaClienteControl(@PathVariable Long id) {
		boolean apagar = clienteService.apagarClientes(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

