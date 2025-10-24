package com.br.lojix.service;

import com.br.lojix.model.Usuario;

public interface UsuarioService {
	
	Usuario findById(Long id);
	
	Iterable<Usuario> findAll();
	
	Usuario create(Usuario usuarioToCreate);

    Usuario update(Long id, Usuario usuarioToUpdate);

    Usuario delete(Long id);

}
