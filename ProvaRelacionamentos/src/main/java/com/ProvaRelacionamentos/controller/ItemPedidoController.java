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

import com.ProvaRelacionamentos.Entities.ItemPedidoEntities;
import com.ProvaRelacionamentos.service.ItemPedidoService;

	
import jakarta.validation.Valid;


@RestController
@RequestMapping("/itemPedido")
@CrossOrigin(origins="*")
public class ItemPedidoController {

	private final ItemPedidoService itemPedidoService;

	@Autowired
	public ItemPedidoController(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	@GetMapping("/{id}")

	public ResponseEntity<ItemPedidoEntities> buscaItemPedidoControlId(@PathVariable Long id) {
		ItemPedidoEntities ItemPedido = itemPedidoService.buscaItemPedidosId(id);
		if (ItemPedido != null) {
			return ResponseEntity.ok(ItemPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping

	public ResponseEntity<List<ItemPedidoEntities>> buscaTodosItemPedidoControl() {
		List<ItemPedidoEntities> ItemPedido = itemPedidoService.buscaTodosItemPedido();
		return ResponseEntity.ok(ItemPedido);
	}

	@PostMapping

	public ResponseEntity<ItemPedidoEntities> salvaItemPedidoControl(@RequestBody @Valid ItemPedidoEntities itemPedido) {
		ItemPedidoEntities salvaItemPedido = itemPedidoService.salvaItemPedido(itemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemPedido);
	}

	@PutMapping("/{id}")

	public ResponseEntity<ItemPedidoEntities> alterarItemPedidoControl(@PathVariable Long id, @RequestBody @Valid ItemPedidoEntities ItemPedido) {
		ItemPedidoEntities alterarItemPedido = itemPedidoService.alterarItemPedido(id, ItemPedido);
		if (alterarItemPedido != null) {
			return ResponseEntity.ok(ItemPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<ItemPedidoEntities> apagaItemPedidoControl(@PathVariable Long id) {
		boolean apagar = itemPedidoService.apagarItemPedidos(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}