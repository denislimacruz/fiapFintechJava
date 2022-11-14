package br.com.fiap.fintech.view;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.fintech.dao.CartaoDAOImpl;
import br.com.fiap.fintech.model.CartaoModel;

public class CartaoView {

	public static void main(String[] args) {
		
		//instancias do cartao
		CartaoModel cartaoModel = new CartaoModel();
		CartaoDAOImpl cartaoDAO = new CartaoDAOImpl();
		
		Boolean cadastrarCartao = false;
		
		//cadastrar cartao
		if(cadastrarCartao) {
			cartaoModel.setCd_usuario(3);
			cartaoModel.setNr_conta(11653);
			cartaoModel.setNr_numero_cartao(987456321);
			cartaoModel.setNm_nome("Banco JAVASQL");
			Calendar data = new GregorianCalendar(2027 , Calendar.OCTOBER , 18);
			cartaoModel.setDt_vencimento(data);
			
			cartaoDAO.adicionarCartao(cartaoModel);
		}
		
		//selecionar todos os cartoes
		System.out.println();
		List<CartaoModel> cartoes = cartaoDAO.findAll();
			for(CartaoModel cartao: cartoes) {
				System.out.println(cartao.toString());
			}
			
		//selecionar cartao
		System.out.println();
		System.out.println(cartaoDAO.findById(123456789).toString());

		
	}
}
