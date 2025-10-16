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

import com.br.lojix.model.Produto;
import com.br.lojix.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		var produto = produtoService.findById(id);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Produto>> findAll() {
		var produto = produtoService.findAll();
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produtoToCreate) {
		var produto = produtoService.create(produtoToCreate);
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produtoToUpdate) {
		var produto = produtoService.update(id, produtoToUpdate);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping
	public ResponseEntity<Produto> delete(@PathVariable Long id) {
		var produto = produtoService.delete(id);
		return ResponseEntity.ok(produto);
	}

}
