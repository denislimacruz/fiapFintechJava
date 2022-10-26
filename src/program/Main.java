package program;


import entities.ContaFintech;
import entities.Recebido;
import entities.Usuario;

public class Main {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		Recebido recebido = new Recebido();
		ContaFintech contaFintech = new ContaFintech();
		
		

		usuario.CriarUsuario(1, "Joao da Silva", "joao@email.com", "SenhaJoao", "Joaozinho", "111.111.111-11");
		System.out.println("Usuario " + usuario.getNome() + " criado com sucesso!");
		
		usuario.MudarSenha("SenhaJoao", "NovaSenhaJoao");
		System.out.println("Senha alterada com sucesso!");
		
		usuario.MudarEmail("joaozinho@email.com");
		System.out.println("E-mail alterado para: " + usuario.getEmail());


		recebido.CadastrarTransacao(1, 1000.00, "05/09/2022", "Pix");
		System.out.println("Transação registrada com sucesso!");
		recebido.VerTransacao();
		
		


	}

}
