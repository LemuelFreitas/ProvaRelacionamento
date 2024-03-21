package com.ProvaRelacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProvaRelacionamentos.Entities.PedidoEntities;

public interface PedidoRepository extends JpaRepository<PedidoEntities,Long> {

}
