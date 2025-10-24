package com.br.lojix.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.lojix.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private String descricaoItem;
	
	@Column(nullable = false)
	private Integer quantidadeItem;
	
	@Column(nullable = false)
	private Double valorUnitarioItem;

    @ManyToOne
    @Autowired
	private Produto produtoPedido;
	
	@ManyToOne
	@Autowired
	private Fornecedor fornecedorPedido;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Status statusPedido;
	
	public Pedido() {}

	public Pedido(Integer numero, String descricaoItem, Integer quantidadeItem, Double valorUnitarioItem,
			Produto produtoPedido, Fornecedor fornecedorPedido, Status statusPedido) {
		super();
		this.numero = numero;
		this.descricaoItem = descricaoItem;
		this.quantidadeItem = quantidadeItem;
		this.valorUnitarioItem = valorUnitarioItem;
		this.produtoPedido = produtoPedido;
		this.fornecedorPedido = fornecedorPedido;
		this.statusPedido = statusPedido;
	}
	
	public Double valorTotalPedido() {
		if (produtoPedido != null && quantidadeItem != null) {
			return produtoPedido.getValorUnitario() * quantidadeItem;
		}
		return 0.0;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public Double getValorUnitarioItem() {
		return valorUnitarioItem;
	}

	public void setValorUnitarioItem(Double valorUnitarioItem) {
		this.valorUnitarioItem = valorUnitarioItem;
	}

	public Produto getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(Produto produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

	public Fornecedor getFornecedorPedido() {
		return fornecedorPedido;
	}

	public void setFornecedorPedido(Fornecedor fornecedorPedido) {
		this.fornecedorPedido = fornecedorPedido;
	}

	public Status getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(Status statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Pedido Nº " + numero + " | Descrição: " + descricaoItem + " | Status: " + getStatusPedido();
		}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedorPedido, id, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(fornecedorPedido, other.fornecedorPedido) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero);
	}	
	
}
