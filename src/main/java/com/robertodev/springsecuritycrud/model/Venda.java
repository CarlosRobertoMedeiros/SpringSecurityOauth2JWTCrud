package com.robertodev.springsecuritycrud.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_venda")
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	//TODO: Ajustar a criação da tabela de relacionamento n para n 
	// Uma venda tem varios produtos e varios produtos podem estar em varias vendas
	//se diferencia apenas a data
	@OneToMany
	private List<Produto> produtos;
	
	@NotNull
	private Integer qtdeProdutos;
	
	@NotNull
	private BigDecimal valorTotalDaVenda;
	
}
