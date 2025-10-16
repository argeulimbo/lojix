package com.br.lojix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.lojix.model.Pedido;
import com.br.lojix.service.PedidoService;

public class PedidoController {
	
	private PedidoService pedidoService;
	
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		var pedido = pedidoService.findById(id);
		return ResponseEntity.ok(pedido);
	}
	
	public ResponseEntity<Iterable<Pedido>> findAll() {
		var pedido = pedidoService.findAll();
		return ResponseEntity.ok(pedido);
	}

	public ResponseEntity<Pedido> create(@RequestBody Pedido pedidoToCreate) {
		var pedido = pedidoService.create(pedidoToCreate);
		return ResponseEntity.ok(pedido);
	}
	
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedidoToUpdate) {
		var pedido = pedidoService.update(id, pedidoToUpdate);
		return ResponseEntity.ok(pedido);
	}
	
	public ResponseEntity<Pedido> delete(@PathVariable Long id) {
		var pedido = pedidoService.delete(id);
		return ResponseEntity.ok(pedido);
	}
	
}
