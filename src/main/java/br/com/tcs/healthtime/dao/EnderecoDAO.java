package br.com.tcs.healthtime.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.healthtime.model.Endereco;
import br.com.tcs.healthtime.repository.EnderecoRepository;

@Service
public class EnderecoDAO {
	
	@Autowired
	EnderecoRepository repository;

	public Endereco saveEndereco(Endereco endereco) {
		Endereco novoEndereco = null;
		try {
			return novoEndereco = repository.save(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return novoEndereco;
		}
	}

	public List<Endereco> listAll() {
		List<Endereco> enderecos = null;
		try {
			return enderecos = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return enderecos;
		}
	}
	
	public Optional<Endereco> findById(Long id) {
		Optional<Endereco> endereco = null;
		try {
			return endereco = repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return endereco;
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
