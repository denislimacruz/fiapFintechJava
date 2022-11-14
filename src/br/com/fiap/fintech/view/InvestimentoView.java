package br.com.fiap.fintech.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.model.InvestimentoModel;

public class InvestimentoView {

	public static void main(String[] args) {

		//Instanciando objetos  de investimento
		InvestimentoModel investimentoModel = new InvestimentoModel();
		InvestimentoDAO investimentoDAO = DAOFactory.getInvestimentoDAO();
		
		//controlar se será cadastrado um novo investimento
		Boolean cadastrarTransacao = false;
		
		//cadastrar nova transação
		if(cadastrarTransacao) {
			investimentoModel.setCd_usuario(1);
			investimentoModel.setNm_nome("TESOURO DIRETO"); 
			investimentoModel.setVl_valor(550);
			investimentoModel.setDs_rendimento("rendimento mensal");
			Calendar dataCadastro = new GregorianCalendar(2022 , Calendar.NOVEMBER , 15);
			investimentoModel.setDt_data(dataCadastro);
			Calendar dtVencimento = new GregorianCalendar(2023 , Calendar.NOVEMBER , 15);
			investimentoModel.setDt_vencimento(dtVencimento);
			
			investimentoDAO.adicionarInvestimento(investimentoModel);
		}
		
		//buscando todos os investimentos
		List<InvestimentoModel> investimentos = investimentoDAO.findAll();
			for(InvestimentoModel invest: investimentos) {
				System.out.println(invest.toString());
			}
			

	}

}
