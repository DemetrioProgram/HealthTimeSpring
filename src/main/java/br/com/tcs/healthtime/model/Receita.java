package br.com.tcs.healthtime.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cdArquivo;
	@Column(name = "nmarquivo", nullable = false)
	private String nmarquivo;
	@Column(name = "arquivo", nullable = false)
	private Blob arquivo;
	
	public Receita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receita(Integer cdArquivo, String nmarquivo, Blob arquivo) {
		super();
		this.cdArquivo = cdArquivo;
		this.nmarquivo = nmarquivo;
		this.arquivo = arquivo;
	}

	public Receita(String nmarquivo, Blob arquivo) {
		super();
		this.nmarquivo = nmarquivo;
		this.arquivo = arquivo;
	}

	public Integer getCdArquivo() {
		return cdArquivo;
	}

	public void setCdArquivo(Integer cdArquivo) {
		this.cdArquivo = cdArquivo;
	}

	public String getNmarquivo() {
		return nmarquivo;
	}

	public void setNmarquivo(String nmarquivo) {
		this.nmarquivo = nmarquivo;
	}

	public Blob getArquivo() {
		return arquivo;
	}

	public void setArquivo(Blob arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public String toString() {
		return "Receita [cdArquivo=" + cdArquivo + ", nmarquivo=" + nmarquivo + ", arquivo=" + arquivo + "]";
	}
}
