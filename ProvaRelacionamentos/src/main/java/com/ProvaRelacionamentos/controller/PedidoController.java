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

import com.ProvaRelacionamentos.Entities.PedidoEntities;
import com.ProvaRelacionamentos.service.PedidoService;

	
import jakarta.validation.Valid;


@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins="*")
public class PedidoController {

	private final PedidoService pedidoService;

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping("/{id}")

	public ResponseEntity<PedidoEntities> buscaPedidoControlId(@PathVariable Long id) {
		PedidoEntities Pedido = pedidoService.buscaPedidosId(id);
		if (Pedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping

	public ResponseEntity<List<PedidoEntities>> buscaTodosPedidoControl() {
		List<PedidoEntities> Pedido = pedidoService.buscaTodosPedido();
		return ResponseEntity.ok(Pedido);
	}

	@PostMapping

	public ResponseEntity<PedidoEntities> salvaPedidoControl(@RequestBody @Valid PedidoEntities pedido) {
		PedidoEntities salvaPedido = pedidoService.salvaPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
	}

	@PutMapping("/{id}")

	public ResponseEntity<PedidoEntities> alterarPedidoControl(@PathVariable Long id, @RequestBody @Valid PedidoEntities Pedido) {
		PedidoEntities alterarPedido = pedidoService.alterarPedido(id, Pedido);
		if (alterarPedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<PedidoEntities> apagaPedidoControl(@PathVariable Long id) {
		boolean apagar = pedidoService.apagarPedidos(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
