package com.br.lojix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.lojix.model.Pedido;
import com.br.lojix.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		var pedido = pedidoService.findById(id);
		return ResponseEntity.ok(pedido);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Pedido>> findAll() {
		var pedido = pedidoService.findAll();
		return ResponseEntity.ok(pedido);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedidoToCreate) {
		var pedido = pedidoService.create(pedidoToCreate);
		return ResponseEntity.ok(pedido);
	}
	
	@PutMapping
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedidoToUpdate) {
		var pedido = pedidoService.update(id, pedidoToUpdate);
		return ResponseEntity.ok(pedido);
	}
	
	@DeleteMapping
	public ResponseEntity<Pedido> delete(@PathVariable Long id) {
		var pedido = pedidoService.delete(id);
		return ResponseEntity.ok(pedido);
	}
	
}
