package br.com.fiap.fintech.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CartaoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int cd_usuario;
	private int nr_conta;
	private int nr_numero_cartao;
	private Calendar dt_vencimento;
	private String nm_nome;
	
	public CartaoModel() {
	}
	
	public CartaoModel(int cd_usuario, int nr_conta, int nr_numero_cartao, Calendar dt_vencimento, String nm_nome) {
		super();
		this.cd_usuario = cd_usuario;
		this.nr_conta = nr_conta;
		this.nr_numero_cartao = nr_numero_cartao;
		this.dt_vencimento = dt_vencimento;
		this.nm_nome = nm_nome;
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

	public int getNr_numero_cartao() {
		return nr_numero_cartao;
	}

	public void setNr_numero_cartao(int nr_numero_cartao) {
		this.nr_numero_cartao = nr_numero_cartao;
	}

	public Calendar getDt_vencimento() {
		return dt_vencimento;
	}

	public void setDt_vencimento(Calendar dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}

	public String getNm_nome() {
		return nm_nome;
	}

	public void setNm_nome(String nm_nome) {
		this.nm_nome = nm_nome;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "CartaoModel [cd_usuario=" + cd_usuario + ", nr_conta=" + nr_conta + ", nr_numero_cartao="
				+ nr_numero_cartao + ", dt_vencimento=" + sdf.format(dt_vencimento.getTime()) + ", nm_nome=" + nm_nome + "]";
	}
	
	
	
}

