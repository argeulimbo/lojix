package com.br.lojix.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.lojix.model.Pedido;
import com.br.lojix.repository.PedidoRepository;
import com.br.lojix.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido findById(Long id) {
		return pedidoRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Iterable<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido create(Pedido pedidoToCreate) {
		if (pedidoToCreate.getId() != null && pedidoRepository.existsById(pedidoToCreate.getId())) {
			throw new IllegalArgumentException(String.format("Erro: O pedido do ID %d já existe!", pedidoToCreate.getId()));
		}
		else {
			return pedidoRepository.save(pedidoToCreate);
		}
	}

	@Override
	public Pedido update(Long id, Pedido pedidoToUpdate) {
		if (pedidoToUpdate.getId() == null && !pedidoRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d para atualizar!", id));
		}
		else {
			return pedidoRepository.save(pedidoToUpdate);
		}
	}

	@Override
	public Pedido delete(Long id) {
		if (id == null & !pedidoRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d para exclusão!", id));
		}
		else {
			Pedido pedido = pedidoRepository.findById(id).orElse(null);
			pedidoRepository.deleteById(id);
			return pedido;
		}
		 
	}

}
