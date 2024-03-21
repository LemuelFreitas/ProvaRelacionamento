package com.ProvaRelacionamentos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProvaRelacionamentos.Entities.ClienteEntities;
import com.ProvaRelacionamentos.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	@Autowired

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	public  List<ClienteEntities> buscaTodosCliente(){
		return clienteRepository.findAll();
	}
	public ClienteEntities buscaClientesId(Long id) {
		Optional <ClienteEntities> Clientes = clienteRepository.findById(id);
		return Clientes.orElse(null);
	}
	public ClienteEntities salvaCliente(ClienteEntities Cliente){
		return clienteRepository.save(Cliente);
	}
	public ClienteEntities alterarCliente(Long id, ClienteEntities alterarClientes) {
		Optional <ClienteEntities> existeClientes = clienteRepository.findById(id);
		if (existeClientes.isPresent()) {
			alterarClientes.setId(id);
			return clienteRepository.save(alterarClientes);
		}
		return null;
	}
	public boolean apagarClientes (Long id) {
		Optional <ClienteEntities> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
