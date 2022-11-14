package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.GastoModel;

public interface GastoDAO {
	
	GastoModel findById(int codigo);
	
	List<GastoModel> findAll();
	
	void inserirGasto(GastoModel gastoModel);
	
	void atualizarGasto(GastoModel gastoModel);
	
	void exclurGasto(int codigo);

}
