package com.br.lojix.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lojix.model.Produto;
import com.br.lojix.repository.ProdutoRepository;
import com.br.lojix.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto findById(Long id) {
		return produtoRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Iterable<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto create(Produto produtoToCreate) {
		if (produtoToCreate.getId() != null && !produtoRepository.existsById(produtoToCreate.getId())) {
			throw new IllegalArgumentException(String.format("Erro: O ID %d já existe!", produtoToCreate.getId()));
		}
		else {
			return produtoRepository.save(produtoToCreate);
		}
	}

	@Override
	public Produto update(Long id, Produto produtoToUpdate) {
		if (produtoToUpdate.getId() == null && !produtoRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d para atualizar!", id));
		}
		else {
			return produtoRepository.save(produtoToUpdate);
		}
	}

	@Override
	public Produto delete(Long id) {
		if (id == null && !produtoRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d informado para exclusão", id));
		}
		else {
			Produto produto = produtoRepository.findById(id).orElse(null);
			produtoRepository.deleteById(id);
			return produto;
		}
	}

}
