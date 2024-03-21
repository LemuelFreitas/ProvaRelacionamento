package com.ProvaRelacionamentos.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProvaRelacionamentos.Entities.FornecedorEntities;
import com.ProvaRelacionamentos.repository.FornecedorRepository;

@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;
	@Autowired

	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	public  List<FornecedorEntities> buscaTodosFornecedor(){
		return fornecedorRepository.findAll();
	}
	public FornecedorEntities buscaFornecedorsId(Long id) {
		Optional <FornecedorEntities> Fornecedors = fornecedorRepository.findById(id);
		return Fornecedors.orElse(null);
	}
	public FornecedorEntities salvaFornecedor(FornecedorEntities Fornecedor){
		return fornecedorRepository.save(Fornecedor);
	}
	public FornecedorEntities alterarFornecedor(Long id, FornecedorEntities alterarFornecedors) {
		Optional <FornecedorEntities> existeFornecedors = fornecedorRepository.findById(id);
		if (existeFornecedors.isPresent()) {
			alterarFornecedors.setId(id);
			return fornecedorRepository.save(alterarFornecedors);
		}
		return null;
	}
	public boolean apagarFornecedors (Long id) {
		Optional <FornecedorEntities> existeFornecedor = fornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			fornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
