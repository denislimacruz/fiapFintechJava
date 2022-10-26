package entities;


public class Cartao {
	
	private String numeroCartao;
	private String dtVencimento;
	private String nomeTitular;
	
	public Cartao() {
	}
	
	
	public String getNumeroCartao() {
		return numeroCartao;
	}


	public String getDtVencimento() {
		return dtVencimento;
	}


	public String getNomeTitular() {
		return nomeTitular;
	}


	public void AddCartao(String numeroCartao, String dtVencimento, String nomeTitular) {
		
		this.numeroCartao = numeroCartao;
		this.dtVencimento = dtVencimento;
		this.nomeTitular = nomeTitular;
	}
	

}
