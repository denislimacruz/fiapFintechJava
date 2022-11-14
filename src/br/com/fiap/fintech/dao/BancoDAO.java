package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.BancoModel;

public interface BancoDAO {
	
	BancoModel findById(int codigo);
	
	List<BancoModel> findAll();
	
	void adicionarBanco(BancoModel bancoModel);
	
	void alterarDadosDoBanco(BancoModel bancoModel);
	
	void excluirBanco(int codigo);

}
