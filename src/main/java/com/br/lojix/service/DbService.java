package com.br.lojix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.lojix.repository.FornecedorRepository;
import com.br.lojix.repository.PedidoRepository;
import com.br.lojix.repository.ProdutoRepository;

@Service
public class DbService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public void instanciaDB() {
		System.out.println("Callback: Método instanciaDB() chamado!");
	}
	
}
