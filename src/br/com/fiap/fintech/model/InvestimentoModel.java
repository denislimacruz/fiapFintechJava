package br.com.fiap.fintech.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InvestimentoModel {

	private int cd_usuario;
	private int cd_investimento;
	private String nm_nome;
	private double vl_valor;
	private Calendar dt_data;
	private Calendar dt_vencimento;
	private String ds_rendimento;
	
	
	
	public InvestimentoModel() {
		super();
	}

	public InvestimentoModel(int cd_usuario, int cd_investimento, String nm_nome, double vl_valor, Calendar dt_data,
			Calendar dt_vencimento, String ds_rendimento) {
		super();
		this.cd_usuario = cd_usuario;
		this.cd_investimento = cd_investimento;
		this.nm_nome = nm_nome;
		this.vl_valor = vl_valor;
		this.dt_data = dt_data;
		this.dt_vencimento = dt_vencimento;
		this.ds_rendimento = ds_rendimento;
	}
	
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public int getCd_investimento() {
		return cd_investimento;
	}
	public void setCd_investimento(int cd_investimento) {
		this.cd_investimento = cd_investimento;
	}
	public String getNm_nome() {
		return nm_nome;
	}
	public void setNm_nome(String nm_nome) {
		this.nm_nome = nm_nome;
	}
	public double getVl_valor() {
		return vl_valor;
	}
	public void setVl_valor(double vl_valor) {
		this.vl_valor = vl_valor;
	}
	public Calendar getDt_data() {
		return dt_data;
	}
	public void setDt_data(Calendar dt_data) {
		this.dt_data = dt_data;
	}
	public Calendar getDt_vencimento() {
		return dt_vencimento;
	}
	public void setDt_vencimento(Calendar dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}
	public String getDs_rendimento() {
		return ds_rendimento;
	}
	public void setDs_rendimento(String ds_rendimento) {
		this.ds_rendimento = ds_rendimento;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "InvestimentoModel [cd_usuario=" + cd_usuario + ", cd_investimento=" + cd_investimento + ", nm_nome="
				+ nm_nome + ", vl_valor=" + vl_valor + ", dt_data=" + sdf.format(dt_data.getTime()) + ", dt_vencimento=" + sdf.format(dt_vencimento.getTime())
				+ ", ds_rendimento=" + ds_rendimento + "]";
	}

	
	
}
