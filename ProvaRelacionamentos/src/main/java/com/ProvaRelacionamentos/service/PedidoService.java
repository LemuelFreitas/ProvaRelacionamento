package com.ProvaRelacionamentos.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProvaRelacionamentos.Entities.PedidoEntities;
import com.ProvaRelacionamentos.repository.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	@Autowired

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	public  List<PedidoEntities> buscaTodosPedido(){
		return pedidoRepository.findAll();
	}
	public PedidoEntities buscaPedidosId(Long id) {
		Optional <PedidoEntities> Pedidos = pedidoRepository.findById(id);
		return Pedidos.orElse(null);
	}
	public PedidoEntities salvaPedido(PedidoEntities Pedido){
		return pedidoRepository.save(Pedido);
	}
	public PedidoEntities alterarPedido(Long id, PedidoEntities alterarPedidos) {
		Optional <PedidoEntities> existePedidos = pedidoRepository.findById(id);
		if (existePedidos.isPresent()) {
			alterarPedidos.setId(id);
			return pedidoRepository.save(alterarPedidos);
		}
		return null;
	}
	public boolean apagarPedidos (Long id) {
		Optional <PedidoEntities> existePedido = pedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
