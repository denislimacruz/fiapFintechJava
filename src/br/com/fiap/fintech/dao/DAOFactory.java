package br.com.fiap.fintech.dao;

public abstract class DAOFactory {
	
	public static BancoDAO getBancoDAO() {
		return new BancoDAOImpl();
	}
	
	public static CartaoDAO getCartaoDAO() {
		return new CartaoDAOImpl();
	}
	
	public static GastoDAO getGastoDAO() {
		return new GastoDAOImpl();
	}
	
	public static InvestimentoDAO getInvestimentoDAO() {
		return new InvestimentoDAOImpl();
	}
	
	public static RecebidoDAO getRecebidoDAO() {
		return new RecebidoDAOImpl();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}

}
