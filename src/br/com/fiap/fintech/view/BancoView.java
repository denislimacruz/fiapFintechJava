package br.com.fiap.fintech.view;

import java.util.List;

import br.com.fiap.fintech.dao.BancoDAO;
import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.model.BancoModel;

public class BancoView {

	public static void main(String[] args) {
		
		//instancias dados bancarios
		BancoModel bancoModel = new BancoModel();
		BancoDAO bancoDAO = DAOFactory.getBancoDAO();
		
		Boolean adicionaBanco = false;
		
		//cadatro de dados bancarios
		if(adicionaBanco) {
			bancoModel.setCd_usuario(4);
			bancoModel.setNr_conta(112233);
			bancoModel.setDigito_conta(5);
			bancoModel.setNr_agencia(5461);
			bancoModel.setDigito_agencia(2);
			
			bancoDAO.adicionarBanco(bancoModel);	
		}
		
		//imprime todos os dados de todo os bancos cadastrados
		List<BancoModel> bancos = bancoDAO.findAll();
			for(BancoModel banco: bancos) {
				System.out.println(banco.toString());
			}

	}

}
