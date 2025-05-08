package Pessoa;



public abstract class Usuarios {
	private String nome;
	private String email;
	private String senha;
	
	public Usuarios(String nome, String email, String senha) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}

	/* ----- Gets e sets -----*/
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract void exibirInformacaoPublica(); //nome de usuario
	public abstract void exibirInformacaoPrivada(); //detalhes da conta
	
	public abstract String alterarSenha(String senha); //alterar dados
	public abstract String alterarEmail(String email);
	
	public abstract void seusJogos(); //jogos cadastrados e jogos comprados
	
	public abstract void excluirConta(); //excluir conta
	
}