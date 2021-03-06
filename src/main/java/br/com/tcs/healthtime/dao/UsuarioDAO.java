package br.com.tcs.healthtime.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.healthtime.dto.Cpf;
import br.com.tcs.healthtime.model.Usuario;
import br.com.tcs.healthtime.repository.UsuarioRepository;

@Service
public class UsuarioDAO {

	@Autowired
	UsuarioRepository repository;

	public Usuario saveUser(Usuario usuario) {
		Usuario novoUsuario = null;
		try {
			return novoUsuario = repository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return novoUsuario;
		}
	}

	public List<Usuario> listAll() {
		List<Usuario> usuarios = null;
		try {
			return usuarios = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return usuarios;
		}
	}
	
	public Usuario findById(Long id) {
		Usuario usuario = null;
		try {
			return usuario = repository.findId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return usuario;
		}
	}
	
	public Usuario findByCpf(String cpfParam) {
		Usuario usuario = null;
		try {
			System.out.println("findByCpf"+cpfParam);
			return usuario = repository.findByCpf(cpfParam);
		} catch (Exception e) {
			e.printStackTrace();
			return usuario;
		}
	}
	
	public List<Usuario> findByName(String name) {
		List<Usuario> usuario = null;
		try {
			return usuario = repository.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return usuario;
		}
	}
	
	public Boolean delete(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
