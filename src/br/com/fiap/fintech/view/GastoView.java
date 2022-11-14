package br.com.fiap.fintech.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.GastoDAO;
import br.com.fiap.fintech.model.GastoModel;

public class GastoView {

	public static void main(String[] args) {
		
		//intancias gasto
		GastoModel gastoModel = new GastoModel();
		GastoDAO gastoDAO = DAOFactory.getGastoDAO();
		
		Boolean cadastrarGasto = false;
		Boolean fazerUpdateGasto = false;
		
		//cadastrar gasto
		if(cadastrarGasto) {
			gastoModel.setCd_usuario(1);
			gastoModel.setDs_categoria("Aluguel");
			gastoModel.setDs_descricao("Gasto mensal");
			gastoModel.setVl_valor(2000);
			Calendar data= new GregorianCalendar(2022 , Calendar.OCTOBER , 10);
			gastoModel.setDt_data(data);
			
			gastoDAO.inserirGasto(gastoModel);
		}
		
		if(cadastrarGasto) {
			gastoModel.setCd_usuario(5);
			gastoModel.setDs_categoria("Carro");
			gastoModel.setDs_descricao("troca de pneu");
			gastoModel.setVl_valor(2800);
			Calendar data= new GregorianCalendar(2022 , Calendar.SEPTEMBER , 22);
			gastoModel.setDt_data(data);
			
			gastoDAO.inserirGasto(gastoModel);
		}
		
		if(cadastrarGasto) {
			gastoModel.setCd_usuario(2);
			gastoModel.setDs_categoria("Agua");
			gastoModel.setDs_descricao("Conta de agua");
			gastoModel.setVl_valor(134);
			Calendar data= new GregorianCalendar(2022 , Calendar.NOVEMBER , 5);
			gastoModel.setDt_data(data);
			
			gastoDAO.inserirGasto(gastoModel);
		}
		
		//selecionando todos os gastos
		List<GastoModel> gastos = gastoDAO.findAll();
		for(GastoModel gasto: gastos) {
			System.out.println(gasto.toString());
		}

			
		//update gasto
		if(fazerUpdateGasto) {
			gastoModel.setCd_gasto(2);
			gastoModel.setDs_categoria("Luz");
			gastoModel.setDs_descricao("Conta de luz");
			gastoModel.setVl_valor(200);
			Calendar data= new GregorianCalendar(2022 , Calendar.NOVEMBER , 5);
			gastoModel.setDt_data(data);
			
			gastoDAO.atualizarGasto(gastoModel);
		}

		System.out.println();
		//seleciona gasto atualizado
		System.out.println(gastoDAO.findById(2).toString());

	}

}
