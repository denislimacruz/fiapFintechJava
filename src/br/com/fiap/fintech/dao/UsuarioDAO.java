package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.model.UsuarioModel;

public interface UsuarioDAO {
	
	UsuarioModel findById (int codigo);
	
	List<UsuarioModel> findAll();
	
	void criarUsuario (UsuarioModel usuario);
	
	void mudarSenha(UsuarioModel usuario);
	
	void alterarEmail(UsuarioModel usuario);
	
	void atualizarUsuario(UsuarioModel usuario);
	
	void excluirUsuario (int codigo);

}
