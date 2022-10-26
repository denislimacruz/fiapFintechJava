package entities;


public abstract class Transacao{
	
	protected int codTransacao;
	protected double valor;
	protected String dataTransacao;
	protected String descricaoTransacao;
	
	public Transacao() {
	}
	
	public int getCodTransacao() {
		return codTransacao;
	}
	
	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getDataTransacao() {
		return dataTransacao;
	}


	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}


	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}


	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}
	
	public void CadastrarTransacao(int codTransacao, double valor, String dataTransacao, String descricaoTransacao) {
		
		this.codTransacao = codTransacao;
		this.valor = valor;
		this.dataTransacao = dataTransacao;
		this.descricaoTransacao = descricaoTransacao;
	}
	
	
	public void EditarTransacao(int codTransacao) {
			
		if (codTransacao == this.codTransacao) {
			
			this.valor = valor;
			this.dataTransacao = dataTransacao;
			this.descricaoTransacao = descricaoTransacao;
		}
	}
	
	public void VerTransacao() {
		System.out.println("Transação: " + codTransacao);
		System.out.println("Realizada no dia: " + dataTransacao);
		System.out.printf("Valor da transação: %.2f%n", valor);
		System.out.println("Descrição: " + descricaoTransacao);
	}
	
}
