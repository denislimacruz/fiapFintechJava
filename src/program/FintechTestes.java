package program;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fia.fintech.dao.BancoDAO;
import br.com.fia.fintech.dao.CartaoDAO;
import br.com.fia.fintech.dao.ConexaoBanco;
import br.com.fia.fintech.dao.GastoDAO;
import br.com.fia.fintech.dao.InvestimentoDAO;
import br.com.fia.fintech.dao.RecebidoDAO;
import br.com.fia.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.BancoModel;
import br.com.fiap.fintech.model.CartaoModel;
import br.com.fiap.fintech.model.GastoModel;
import br.com.fiap.fintech.model.InvestimentoModel;
import br.com.fiap.fintech.model.RecebidoModel;
import br.com.fiap.fintech.model.UsuarioModel;

public class FintechTestes {

	public static void main(String[] args) {
		
		//verifica conexão com o banco de dados
		ConexaoBanco.getConexao();
		System.out.println("Conectou com o Banco de Dados");	
		
		System.out.println();
		
		//Controla funções de usuario
		Boolean cadastrarUser = false;
		Boolean alterarSenha = false;
		Boolean alterarEmail = false;
		Boolean excluirUsuario = false;
		int idUsuario = 1;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioModel usuarioModel = new UsuarioModel();
		
		//Cadastro de usuario
		if (cadastrarUser) {
			usuarioModel.setNm_nome("João da Silva");
			usuarioModel.setDs_email("joaodasilva@teste.com");
			usuarioModel.setNm_apelido("joãozinho");
			usuarioModel.setNr_cpf("22233344455");
			usuarioModel.setDs_senha("senhajoao");
			
			usuarioDAO.criarUsuario(usuarioModel);
		}
		
		//alteraçao de senha
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
				
		System.out.println();
			
		//Instanciando objetos  de investimento
		InvestimentoModel investimentoModel = new InvestimentoModel();
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		
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
			
		System.out.println();
			
		//instancias dados bancarios
		BancoModel bancoModel = new BancoModel();
		BancoDAO bancoDAO = new BancoDAO();
		
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
			
		System.out.println();	
		
		//instancias recebido
		RecebidoModel recebidoModel = new RecebidoModel();
		RecebidoDAO recebidoDAO = new RecebidoDAO();
		
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
		
			System.out.println();
			
		//intancias gasto
		GastoModel gastoModel = new GastoModel();
		GastoDAO gastoDAO = new GastoDAO();
		
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
		
		//instancias do cartao
		CartaoModel cartaoModel = new CartaoModel();
		CartaoDAO cartaoDAO = new CartaoDAO();
		
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
