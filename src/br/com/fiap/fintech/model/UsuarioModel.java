package br.com.fiap.fintech.model;

import java.io.Serializable;

public class UsuarioModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cd_usuario;
	private String nm_nome;
	private String ds_email;
	private String ds_senha;
	private String nm_apelido;
	private String nr_cpf;
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(int cd_usuario, String nm_nome, String ds_email, String ds_senha, String nm_apelido,
			String nr_cpf) {
		super();
		this.cd_usuario = cd_usuario;
		this.nm_nome = nm_nome;
		this.ds_email = ds_email;
		this.ds_senha = ds_senha;
		this.nm_apelido = nm_apelido;
		this.nr_cpf = nr_cpf;
	}
	
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public String getNm_nome() {
		return nm_nome;
	}
	public void setNm_nome(String nm_nome) {
		this.nm_nome = nm_nome;
	}
	public String getDs_email() {
		return ds_email;
	}
	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}
	public String getDs_senha() {
		return ds_senha;
	}
	public void setDs_senha(String ds_senha) {
		this.ds_senha = ds_senha;
	}
	public String getNm_apelido() {
		return nm_apelido;
	}
	public void setNm_apelido(String nm_apelido) {
		this.nm_apelido = nm_apelido;
	}
	public String getNr_cpf() {
		return nr_cpf;
	}
	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}
	
	@Override
	public String toString() {
		return "UsuarioModel [cd_usuario=" + cd_usuario + ", nm_nome=" + nm_nome + ", ds_email=" + ds_email
				+ ", ds_senha=" + ds_senha + ", nm_apelido=" + nm_apelido + ", nr_cpf=" + nr_cpf + "]";
	}

}
