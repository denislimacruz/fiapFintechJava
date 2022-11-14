package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.InvestimentoModel;

public interface InvestimentoDAO {
	
	public InvestimentoModel findById(int codigo);
	
	List<InvestimentoModel> findAll();
	
	void adicionarInvestimento(InvestimentoModel investimento);
	
	void excluirInvestimento(int codigo);

}
