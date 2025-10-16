package com.br.lojix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.lojix.model.Fornecedor;
import com.br.lojix.service.FornecedorService;

public class FornecedorController {
	
	private FornecedorService fornecedorService;
	
	public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
		var fornecedor = fornecedorService.findById(id);
		return ResponseEntity.ok(fornecedor);
	}
	
	public ResponseEntity<Iterable<Fornecedor>> findAll() {
		var fornecedor = fornecedorService.findAll();
		return ResponseEntity.ok(fornecedor);
	}
	
	public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedorToCreate) {
		var fornecedor = fornecedorService.create(fornecedorToCreate);
		return ResponseEntity.ok(fornecedor);
	}
	
	public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedorToUpdate) {
		var fornecedor = fornecedorService.update(id, fornecedorToUpdate);
		return ResponseEntity.ok(fornecedor);
	}
	
	public ResponseEntity<Fornecedor> delete(@PathVariable Long id) {
		var fornecedor = fornecedorService.delete(id);
		return ResponseEntity.ok(fornecedor);
	}

}