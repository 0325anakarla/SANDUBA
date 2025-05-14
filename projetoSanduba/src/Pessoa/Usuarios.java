package Pessoa;

import TratamentoDeErro.DadoInvalidoException;

public abstract class Usuarios {
	private String nome;
	private String email;
	private String senha;
	
	public Usuarios(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	/* ----- Gets e sets -----*/
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws DadoInvalidoException {
		if(senha == null) {
			throw new DadoInvalidoException("Senha invalida");
		}
		else this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws DadoInvalidoException{
		if(email == null || email.isBlank() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
			throw new DadoInvalidoException("Email invalido. Insira um email válido!");
		}
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome)throws DadoInvalidoException{
		if(nome == null || nome.isBlank()) {
			throw new DadoInvalidoException("Nome invalido");
		}
		this.nome = nome;
	}
	

//	public abstract void exibirInformacaoPublica(); //nome de usuario
//	public abstract void exibirInformacaoPrivada(); //detalhes da conta
//	
//	public abstract String alterarSenha(String senha); //alterar dados
//	public abstract String alterarEmail(String email);
//	
//	public abstract void seusJogos(); //jogos cadastrados e jogos comprados
//	
//	public abstract void excluirConta(); //excluir conta
	
	public abstract String mostrarDetalhesUsuario();

	public String mostrarDetalhesUsuarios() {
		return null;
	}

	public void seusJogos() {
		// TODO Auto-generated method stub
		
	}
}