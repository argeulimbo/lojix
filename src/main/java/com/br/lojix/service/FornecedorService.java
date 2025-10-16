package com.br.lojix.service;

import com.br.lojix.model.Fornecedor;

public interface FornecedorService {
	
	Fornecedor findById(Long id);
	
	Iterable<Fornecedor> findAll();
	
	Fornecedor create(Fornecedor fornecedorToCreate);
	
	Fornecedor update(Long id, Fornecedor fornecedorToUpdate);
	
	Fornecedor delete(Long id);

}
