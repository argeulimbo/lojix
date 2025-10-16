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

import com.br.lojix.model.Fornecedor;
import com.br.lojix.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
		var fornecedor = fornecedorService.findById(id);
		return ResponseEntity.ok(fornecedor);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Fornecedor>> findAll() {
		var fornecedor = fornecedorService.findAll();
		return ResponseEntity.ok(fornecedor);
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedorToCreate) {
		var fornecedor = fornecedorService.create(fornecedorToCreate);
		return ResponseEntity.ok(fornecedor);
	}
	
	@PutMapping
	public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedorToUpdate) {
		var fornecedor = fornecedorService.update(id, fornecedorToUpdate);
		return ResponseEntity.ok(fornecedor);
	}
	
	@DeleteMapping
	public ResponseEntity<Fornecedor> delete(@PathVariable Long id) {
		var fornecedor = fornecedorService.delete(id);
		return ResponseEntity.ok(fornecedor);
	}

}