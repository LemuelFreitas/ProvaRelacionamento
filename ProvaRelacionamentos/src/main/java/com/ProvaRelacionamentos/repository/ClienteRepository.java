package com.ProvaRelacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProvaRelacionamentos.Entities.ClienteEntities;

public interface ClienteRepository extends JpaRepository<ClienteEntities,Long> {

}