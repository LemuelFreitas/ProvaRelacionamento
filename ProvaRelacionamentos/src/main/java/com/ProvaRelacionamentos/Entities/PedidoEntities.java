package com.ProvaRelacionamentos.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="pedido")
public class PedidoEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable  =false)
	private Long id;

	@Column(name = "data_pedido", nullable = false, length = 100)
	private Date data_pedido;

	@Column(name = "valor_total", nullable = false, length = 100)
	private String valor_total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_cliente",nullable = false)
	private ClienteEntities clinteEntities;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_fornecedor",nullable = false)
	private FornecedorEntities fornecedorEntities;

}