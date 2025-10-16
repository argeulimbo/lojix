package com.br.lojix.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.lojix.model.Fornecedor;
import com.br.lojix.repository.FornecedorRepository;
import com.br.lojix.service.FornecedorService;

public class FornecedorServiceImpl implements FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Override
	public Fornecedor findById(Long id) {
		return fornecedorRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Iterable<Fornecedor> findAll() {
		return fornecedorRepository.findAll();
	}

	@Override
	public Fornecedor create(Fornecedor fornecedorToCreate) {
		if (fornecedorToCreate.getId() != null && fornecedorRepository.existsById(fornecedorToCreate.getId())) {
			throw new IllegalArgumentException(String.format("Erro: O ID %d já existe!", fornecedorToCreate.getId()));
		}
		else {
			return fornecedorRepository.save(fornecedorToCreate);
		}
	}

	@Override
	public Fornecedor update(Long id, Fornecedor fornecedorToUpdate) {
		if (fornecedorToUpdate.getId() == null && !fornecedorRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d para atualizar!", id));
		}
		else { 
			return fornecedorRepository.save(fornecedorToUpdate);
		}
	}

	@Override
	public Fornecedor delete(Long id) {
		if (id == null && !fornecedorRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d informado para exclusão", id));
		}
		else {
			Fornecedor fornecedor = fornecedorRepository.findById(id).orElse(null);
			fornecedorRepository.deleteById(id);
			return fornecedor;
		}
	}

}
