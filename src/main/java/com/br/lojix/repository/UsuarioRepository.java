package com.br.lojix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.lojix.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByEmail(String email);

}
