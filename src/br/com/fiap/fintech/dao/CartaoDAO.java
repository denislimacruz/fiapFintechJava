package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.CartaoModel;


public interface CartaoDAO {
	
	CartaoModel findById(int codigo);
	
	List<CartaoModel> findAll();
	
	void adicionarCartao(CartaoModel cartao);
	
	void alterarDadosDoCartao(CartaoModel cartao);
	
	void excluirCartao(int codigo);
	

}
