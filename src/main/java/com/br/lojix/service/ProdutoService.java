package com.br.lojix.service;

import org.springframework.stereotype.Service;

import com.br.lojix.model.Produto;

@Service
public interface ProdutoService {
	
	Produto findById(Long id);
	
	Iterable<Produto> findAll();
	
	Produto create(Produto produtoToCreate);
	
	Produto update(Long id, Produto produtoToUpdate);
	
	Produto delete(Long id);

}
