package br.com.tcs.healthtime.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cdEndereco;
	@Column(name="cep", nullable = false)
	private String cep;
	@Column(name="rua", nullable = false)
	private String rua;
	@Column(name="numero", nullable = false)
	private Integer numero;
	@Column(name="bairro", nullable = false)
	private String bairro;
	@Column(name="cidade", nullable = false)
	private String cidade;
	@Column(name="uf", nullable = false)
	private String uf;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdUsuario", referencedColumnName = "cdUsuario", nullable = false)
	private Usuario usuario;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(Integer cdEndereco, String cep, String rua, Integer numero, String bairro, String cidade, String uf,
			Usuario usuario) {
		super();
		this.cdEndereco = cdEndereco;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.usuario = usuario;
	}

	public Endereco(String cep, String rua, Integer numero, String bairro, String cidade, String uf, Usuario usuario) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.usuario = usuario;
	}

	public Integer getCdEndereco() {
		return cdEndereco;
	}

	public void setCdEndereco(Integer cdEndereco) {
		this.cdEndereco = cdEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Endereco [cdEndereco=" + cdEndereco + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", usuario=" + usuario + "]";
	}

}
