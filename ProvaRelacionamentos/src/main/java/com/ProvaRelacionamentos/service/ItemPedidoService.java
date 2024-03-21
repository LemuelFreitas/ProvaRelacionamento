package com.ProvaRelacionamentos.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProvaRelacionamentos.Entities.ItemPedidoEntities;
import com.ProvaRelacionamentos.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	private final ItemPedidoRepository itemPedidoRepository;
	@Autowired

	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}
	public  List<ItemPedidoEntities> buscaTodosItemPedido(){
		return itemPedidoRepository.findAll();
	}
	public ItemPedidoEntities buscaItemPedidosId(Long id) {
		Optional <ItemPedidoEntities> ItemPedidos = itemPedidoRepository.findById(id);
		return ItemPedidos.orElse(null);
	}
	public ItemPedidoEntities salvaItemPedido(ItemPedidoEntities ItemPedido){
		return itemPedidoRepository.save(ItemPedido);
	}
	public ItemPedidoEntities alterarItemPedido(Long id, ItemPedidoEntities alterarItemPedidos) {
		Optional <ItemPedidoEntities> existeItemPedidos = itemPedidoRepository.findById(id);
		if (existeItemPedidos.isPresent()) {
			alterarItemPedidos.setId(id);
			return itemPedidoRepository.save(alterarItemPedidos);
		}
		return null;
	}
	public boolean apagarItemPedidos (Long id) {
		Optional <ItemPedidoEntities> existeItemPedido = itemPedidoRepository.findById(id);
		if (existeItemPedido.isPresent()) {
			itemPedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
