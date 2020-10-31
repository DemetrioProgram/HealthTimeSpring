package br.com.tcs.healthtime.model;

import java.time.LocalDate;

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
@Table(name = "consulta")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cdConsulta;
	@Column(name = "data", nullable = false)
	private LocalDate data;
	@Column(name = "flretorno", nullable = false)
	private boolean retorno;
	@Column(name = "flvacina", nullable = true)
	private boolean flvacina;
	@Column(name = "deprediagnostico", nullable = true)
	private String deprediagnostico;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdArquivo", referencedColumnName = "cdArquivo", nullable = true)
	private Receita cdArquivo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdPaciente", referencedColumnName = "cdUsuario", nullable = true)
	private Usuario cdPaciente;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdMedico", referencedColumnName = "cdUsuario", nullable = false)
	private Usuario cdMedico;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cdFuncioanrio", referencedColumnName = "cdUsuario", nullable = false)
	private Usuario cdFuncioanrio;
	
	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consulta(Integer cdConsulta, LocalDate data, boolean retorno, boolean flvacina, String deprediagnostico,
			Receita cdArquivo, Usuario cdPaciente, Usuario cdMedico, Usuario cdFuncioanrio) {
		super();
		this.cdConsulta = cdConsulta;
		this.data = data;
		this.retorno = retorno;
		this.flvacina = flvacina;
		this.deprediagnostico = deprediagnostico;
		this.cdArquivo = cdArquivo;
		this.cdPaciente = cdPaciente;
		this.cdMedico = cdMedico;
		this.cdFuncioanrio = cdFuncioanrio;
	}

	public Consulta(LocalDate data, boolean retorno, boolean flvacina, String deprediagnostico, Receita cdArquivo,
			Usuario cdPaciente, Usuario cdMedico, Usuario cdFuncioanrio) {
		super();
		this.data = data;
		this.retorno = retorno;
		this.flvacina = flvacina;
		this.deprediagnostico = deprediagnostico;
		this.cdArquivo = cdArquivo;
		this.cdPaciente = cdPaciente;
		this.cdMedico = cdMedico;
		this.cdFuncioanrio = cdFuncioanrio;
	}

	public Integer getCdConsulta() {
		return cdConsulta;
	}

	public void setCdConsulta(Integer cdConsulta) {
		this.cdConsulta = cdConsulta;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}

	public boolean isFlvacina() {
		return flvacina;
	}

	public void setFlvacina(boolean flvacina) {
		this.flvacina = flvacina;
	}

	public String getDeprediagnostico() {
		return deprediagnostico;
	}

	public void setDeprediagnostico(String deprediagnostico) {
		this.deprediagnostico = deprediagnostico;
	}

	public Receita getCdArquivo() {
		return cdArquivo;
	}

	public void setCdArquivo(Receita cdArquivo) {
		this.cdArquivo = cdArquivo;
	}

	public Usuario getCdPaciente() {
		return cdPaciente;
	}

	public void setCdPaciente(Usuario cdPaciente) {
		this.cdPaciente = cdPaciente;
	}

	public Usuario getCdMedico() {
		return cdMedico;
	}

	public void setCdMedico(Usuario cdMedico) {
		this.cdMedico = cdMedico;
	}

	public Usuario getCdFuncioanrio() {
		return cdFuncioanrio;
	}

	public void setCdFuncioanrio(Usuario cdFuncioanrio) {
		this.cdFuncioanrio = cdFuncioanrio;
	}

	@Override
	public String toString() {
		return "Consulta [cdConsulta=" + cdConsulta + ", data=" + data + ", retorno=" + retorno + ", flvacina="
				+ flvacina + ", deprediagnostico=" + deprediagnostico + ", cdArquivo=" + cdArquivo + ", cdPaciente="
				+ cdPaciente + ", cdMedico=" + cdMedico + ", cdFuncioanrio=" + cdFuncioanrio + "]";
	}
}
