package com.ProvaRelacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProvaRelacionamentos.Entities.ProdutoEntities;

public interface ProdutoRepository extends JpaRepository<ProdutoEntities,Long> {

}