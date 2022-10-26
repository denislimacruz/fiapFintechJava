package entities;

public class Usuario {
	
	private int cdUsuario;
	private String nome;
	private String email;
	private String senha;
	private String apelido;
	private String cpf;
	
	public Usuario () {
	}
	
	public int getCdUsuario() {
		return cdUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void CriarUsuario(int cdUsuario, String nome, String email, String senha, String apelido, String cpf) {
		
		this.cdUsuario = cdUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.apelido = apelido;
		this.cpf = cpf;
	}
	
	public void MudarSenha(String senhaAntiga, String senhaNova) {
		
		if(senhaAntiga == senha) {
		
			senha = senhaNova;
		}
	}
	
	public void MudarEmail(String email) {
		
		this.email = email;
		
	}


}
