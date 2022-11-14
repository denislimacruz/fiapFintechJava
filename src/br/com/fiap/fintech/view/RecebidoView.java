package br.com.fiap.fintech.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.RecebidoDAO;
import br.com.fiap.fintech.model.RecebidoModel;

public class RecebidoView {

	public static void main(String[] args) {
		//instancias recebido
		RecebidoModel recebidoModel = new RecebidoModel();
		RecebidoDAO recebidoDAO = DAOFactory.getRecebidoDAO();
		
		Boolean cadastrarRecebido = false;
		
		//cadastrar recebido
		if(cadastrarRecebido) {
			recebidoModel.setCd_usuario(4);
			recebidoModel.setDs_descricao("Adiantamento");
			recebidoModel.setDs_categoria("Salario");
			Calendar data= new GregorianCalendar(2022 , Calendar.JANUARY , 15);
			recebidoModel.setDt_data(data);
			recebidoModel.setVl_valor(3000);
			
			recebidoDAO.inserirNovoRecebido(recebidoModel);
		}
		List<RecebidoModel> recebidos = recebidoDAO.findAll();
			for(RecebidoModel recebido: recebidos){
				System.out.println(recebido.toString());
			}

	}

}
