package br.com.fiap.fintech.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RecebidoModel {

	private int cd_usuario;
	private int cd_recebido;
	private double vl_valor;
	private Calendar dt_data;
	private String ds_categoria;
	private String ds_descricao;
	
	
	public RecebidoModel() {
	}

	public RecebidoModel(int cd_usuario, int cd_recebido, double vl_valor, Calendar dt_data, String ds_categoria,
			String ds_descricao) {
		super();
		this.cd_usuario = cd_usuario;
		this.cd_recebido = cd_recebido;
		this.vl_valor = vl_valor;
		this.dt_data = dt_data;
		this.ds_categoria = ds_categoria;
		this.ds_descricao = ds_descricao;
	}
	
	public int getCd_usuario() {
		return cd_usuario;
	}
	public void setCd_usuario(int cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	public int getCd_recebido() {
		return cd_recebido;
	}
	public void setCd_recebido(int cd_recebido) {
		this.cd_recebido = cd_recebido;
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
	public String getDs_categoria() {
		return ds_categoria;
	}
	public void setDs_categoria(String ds_categoria) {
		this.ds_categoria = ds_categoria;
	}
	public String getDs_descricao() {
		return ds_descricao;
	}
	public void setDs_descricao(String ds_descricao) {
		this.ds_descricao = ds_descricao;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "RecebidoModel [cd_usuario=" + cd_usuario + ", cd_recebido=" + cd_recebido + ", vl_valor=" + vl_valor
				+ ", dt_data=" + sdf.format(dt_data.getTime()) + ", ds_categoria=" + ds_categoria + ", ds_descricao=" + ds_descricao + "]";
	}
	
}
