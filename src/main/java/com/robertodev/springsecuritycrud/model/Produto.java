package com.robertodev.springsecuritycrud.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="tb_produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotNull
	@Size(min = 5, max = 50)
	private String nome;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private SecaoDoProdutos secao;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Marca marca;

	@NotNull
	private BigDecimal precoDeCompra;

	@NotNull
	private BigDecimal precoDeVenda;

	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataDaCompra;

}
