package com.br.lojix.controller;

import com.br.lojix.model.Usuario;
import com.br.lojix.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		var usuario = usuarioService.findById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Usuario>> findAll() {
		var usuario = usuarioService.findAll();
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuarioToCreate) {
		var usuario = usuarioService.create(usuarioToCreate);
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuarioToUpdate) {
		var usuario = usuarioService.update(id, usuarioToUpdate);
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping
	public ResponseEntity<Usuario> delete(@PathVariable Long id) {
		var usuario = usuarioService.delete(id);
		return ResponseEntity.ok(usuario);
	}
	
}
