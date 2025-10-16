package com.br.lojix.service;

import org.springframework.stereotype.Service;

import com.br.lojix.model.Pedido;

@Service
public interface PedidoService {
	
	Pedido findById(Long id);
	
	Iterable<Pedido> findAll();
	
	Pedido create(Pedido pedidoToCreate);
	
	Pedido update(Long id, Pedido pedidoToUpdate);
	
	Pedido delete(Long id);

}
