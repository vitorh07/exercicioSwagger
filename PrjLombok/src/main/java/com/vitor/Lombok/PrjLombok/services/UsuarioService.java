package com.vitor.Lombok.PrjLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.Lombok.PrjLombok.entities.Usuario;
import com.vitor.Lombok.PrjLombok.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {

		private final UsuarioRepositorio usuarioRepositorio;

		@Autowired
		public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
			this.usuarioRepositorio = usuarioRepositorio;
		}

		// preparando as buscas por id
		public Usuario findUsuarioById(Long id) {
			Optional<Usuario> Usuario = usuarioRepositorio.findById(id);
			return Usuario.orElse(null);
		}

		// preparando a busca geral
		public List<Usuario> findAllUsuario() {
			return usuarioRepositorio.findAll();
		}

		// salvando o Jogo
		public Usuario insertUsuario(Usuario usuario) {
			return usuarioRepositorio.save(usuario);
		}

		// fazendo o update do jogo com o optional
		public Usuario updateUsuario(Long id, Usuario novoUsuario) {
			Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);
			if (usuarioOptional.isPresent()) {
				Usuario usuarioExistente = usuarioOptional.get();
				usuarioExistente.setNome(novoUsuario.getNome());
				usuarioExistente.setEmail(novoUsuario.getEmail());
				return usuarioRepositorio.save(usuarioExistente);
			} else {
				return null;
			}
		}

		// deletando o update do usuario com o optional
		public boolean deleteUsuario(Long id) {
			Optional<Usuario> usuarioExistente = usuarioRepositorio.findById(id);
			if (usuarioExistente.isPresent()) {
				usuarioRepositorio.deleteById(id);
				return true;
			} else {
				return false;
			}
		}

	}
