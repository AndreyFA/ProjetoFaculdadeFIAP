package br.com.alura.entidade;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 2844877260919637435L;

	private int registro;
	private String nomeCompleto;
	private String descricaoCargo;
	private double salario;

	public Funcionario(int registro, String nomeCompleto, String descricaoCargo, double salario) {
		super();
		this.registro = registro;
		this.nomeCompleto = nomeCompleto;
		this.descricaoCargo = descricaoCargo;
		this.setSalario(salario);
	}

	public Funcionario() {

	}

	public int getRegistro() {
		return registro;
		
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public String getNomeCompleto() {
		nomeCompleto.le
		
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoCargo == null) ? 0 : descricaoCargo.hashCode());
		result = prime * result + ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
		result = prime * result + registro;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (descricaoCargo == null) {
			if (other.descricaoCargo != null)
				return false;
		} else if (!descricaoCargo.equals(other.descricaoCargo))
			return false;
		if (nomeCompleto == null) {
			if (other.nomeCompleto != null)
				return false;
		} else if (!nomeCompleto.equals(other.nomeCompleto))
			return false;
		if (registro != other.registro)
			return false;
		return true;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
