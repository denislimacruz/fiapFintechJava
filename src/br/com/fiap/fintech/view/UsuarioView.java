package br.com.fiap.fintech.view;

import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.UsuarioModel;

public class UsuarioView {

	public static void main(String[] args) {
		
		
		//Controla fun��es de usuario
		Boolean cadastrarUser = false;
		Boolean alterarSenha = false;
		Boolean alterarEmail = false;
		Boolean excluirUsuario = false;
		int idUsuario = 1;

		UsuarioModel usuarioModel = new UsuarioModel();
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	
		
		//Cadastro de usuario
		if (cadastrarUser) {
			usuarioModel.setNm_nome("Jo�o da Silva");
			usuarioModel.setDs_email("joaodasilva@teste.com");
			usuarioModel.setNm_apelido("jo�ozinho");
			usuarioModel.setNr_cpf("22233344455");
			usuarioModel.setDs_senha("senhajoao");
			
			usuarioDAO.criarUsuario(usuarioModel);
		}
		
		//altera�ao de senha
		if(alterarSenha) {
			usuarioModel.setCd_usuario(idUsuario);
			usuarioModel.setDs_senha("alterasenha");
			
			usuarioDAO.mudarSenha(usuarioModel);
			System.out.println("Senha alterada com sucesso!");
		}
		
		List<UsuarioModel> usuarios = usuarioDAO.findAll();
			for	(UsuarioModel user: usuarios) {
				System.out.println(user.toString());
			}

	}

}
