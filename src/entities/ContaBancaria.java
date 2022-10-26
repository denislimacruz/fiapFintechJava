package entities;

public class ContaBancaria {
	
	private double numeroConta;
	private String agencia;
	private String bancoConta;
	
	
	public ContaBancaria() {
	}
	
	public double getNumeroConta() {
		return numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getBancoConta() {
		return bancoConta;
	}
	
	public void AddConta(double numeroConta, String agencia, String bancoConta) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.bancoConta = bancoConta;
	}

}
