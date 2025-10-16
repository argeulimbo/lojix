package com.br.lojix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.lojix.model.Produto;
import com.br.lojix.service.ProdutoService;

public class ProdutoController {
	
	private ProdutoService produtoService;
	
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		var produto = produtoService.findById(id);
		return ResponseEntity.ok(produto);
	}
	
	public ResponseEntity<Iterable<Produto>> findAll() {
		var produto = produtoService.findAll();
		return ResponseEntity.ok(produto);
	}
	
	public ResponseEntity<Produto> create(@RequestBody Produto produtoToCreate) {
		var produto = produtoService.create(produtoToCreate);
		return ResponseEntity.ok(produto);
	}
	
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produtoToUpdate) {
		var produto = produtoService.update(id, produtoToUpdate);
		return ResponseEntity.ok(produto);
	}
	
	public ResponseEntity<Produto> delete(@PathVariable Long id) {
		var produto = produtoService.delete(id);
		return ResponseEntity.ok(produto);
	}

}
