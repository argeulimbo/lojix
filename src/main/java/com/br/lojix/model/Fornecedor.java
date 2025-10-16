package com.br.lojix.model;

import java.util.List;
import java.util.Objects;

public class Fornecedor {
	
	private Long id;
	private String name;
	private String documento;
	private List<Pedido> listPedido;
	
	public Fornecedor() {}
	
	public Fornecedor(int id, String name, String documento) {
		this.name = name;
		this.documento = documento;		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public List<Pedido> getListPedido() {
		return listPedido;
	}
	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}

	@Override
	public String toString() {
		return String.format("ID: %d | %s | Documento: %s ", id, name, documento);
	}

	@Override
	public int hashCode() {
		return Objects.hash(documento, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(documento, other.documento) && Objects.equals(id, other.id);
	}

}
