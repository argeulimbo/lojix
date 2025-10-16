package com.br.lojix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lojix.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
