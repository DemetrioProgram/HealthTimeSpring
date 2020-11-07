package br.com.tcs.healthtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tcs.healthtime.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>,JpaRepository<Endereco, Long>{

}
