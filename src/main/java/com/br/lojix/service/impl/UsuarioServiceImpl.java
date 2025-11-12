package com.br.lojix.service.impl;

import com.br.lojix.model.Usuario;
import com.br.lojix.repository.UsuarioRepository;
import com.br.lojix.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByUser(Usuario user) {

    }

    @Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario create(Usuario usuarioToCreate) {
		if (usuarioToCreate.getId() != null && usuarioRepository.existsById(usuarioToCreate.getId())) {
			throw new IllegalArgumentException(String.format("Erro: O ID %d já existe!", usuarioToCreate.getId()));
		}
		else {
			return usuarioRepository.save(usuarioToCreate);
		}
	}

	@Override
	public Usuario update(Long id, Usuario usuarioToUpdate) {
		if (usuarioToUpdate.getId() == null && !usuarioRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d para atualizar!", id));
		}
		else { 
			return usuarioRepository.save(usuarioToUpdate);
		}
	}

	@Override
	public Usuario delete(Long id) {
		if (id == null && !usuarioRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Erro: Não foi possível encontrar o ID %d informado para exclusão", id));
		}
		else {
            Usuario usuario = usuarioRepository.findById(id).orElse(null);
			usuarioRepository.deleteById(id);
			return usuario;
		}
	}

}
