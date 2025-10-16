package com.br.lojix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lojix.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
