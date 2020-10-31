package br.com.tcs.healthtime.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gestor")
public class Gestor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cdGestor;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "nucontatogestor", nullable = false)
	private String contatoGestor;
	
	public Gestor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gestor(Integer idGestor, String nome, String cpf, String email, String contatoGestor) {
		super();
		this.cdGestor = idGestor;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.contatoGestor = contatoGestor;
	}

	public Gestor(String nome, String cpf, String email, String contatoGestor) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.contatoGestor = contatoGestor;
	}

	public Integer getCdGestor() {
		return cdGestor;
	}

	public void setCdGestor(Integer cdGestor) {
		this.cdGestor = cdGestor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContatoGestor() {
		return contatoGestor;
	}

	public void setContatoGestor(String contatoGestor) {
		this.contatoGestor = contatoGestor;
	}

	@Override
	public String toString() {
		return "Gestor [idGestor=" + cdGestor + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email
				+ ", contatoGestor=" + contatoGestor + "]";
	}

}
