package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.RecebidoModel;

public interface RecebidoDAO {
	
	RecebidoModel findById(int codigo);
	
	List<RecebidoModel> findAll();
	
	void inserirNovoRecebido(RecebidoModel recebido);
	
	void atualizarRecebido(RecebidoModel recebido);
	
	void excluirRecebido(int codigo);

}
