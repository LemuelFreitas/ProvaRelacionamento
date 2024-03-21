package com.ProvaRelacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProvaRelacionamentos.Entities.FornecedorEntities;

public interface FornecedorRepository extends JpaRepository<FornecedorEntities,Long> {

}
