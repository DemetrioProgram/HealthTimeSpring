package br.com.tcs.healthtime.dto;

public class Cpf {

	private String cpf;

	public Cpf() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cpf(String cpf) {
		super();
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cpf [cpf=" + cpf + "]";
	}
}
