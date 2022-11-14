package br.com.fiap.fintech.model;

import java.io.Serializable;

public class BancoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cd_usuario;
	private int nr_conta;
	private int nr_agencia;
	private int digito_conta;
	private int digito_agencia;
	
	
	public BancoModel(int cd_usuario, int nr_conta, int nr_agencia) {
		super();
		this.cd_usuario = cd_usuario;
		this.nr_conta = nr_conta;
		this.nr_agencia = nr_agencia;
	}
	public BancoModel() {
	}
	
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public int getNr_conta() {
		return nr_conta;
	}
	public void setNr_conta(int nr_conta) {
		this.nr_conta = nr_conta;
	}
	public int getNr_agencia() {
		return nr_agencia;
	}
	public void setNr_agencia(int nr_agencia) {
		this.nr_agencia = nr_agencia;
	}
	public int getDigito_conta() {
		return digito_conta;
	}
	public void setDigito_conta(int digito_conta) {
		this.digito_conta = digito_conta;
	}
	public int getDigito_agencia() {
		return digito_agencia;
	}
	public void setDigito_agencia(int digito_agencia) {
		this.digito_agencia = digito_agencia;
	}
	@Override
	public String toString() {
		return "BancoModel [cd_usuario=" + cd_usuario + ", nr_conta=" + nr_conta + ", nr_agencia=" + nr_agencia
				+ ", digito_conta=" + digito_conta + ", digito_agencia=" + digito_agencia + "]";
	}
		
}

	