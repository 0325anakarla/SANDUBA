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
		if(email == null || email.isBlank())
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
	
	public abstract void seusJogos(); //jogos cadastrados e jogos comprados
	
	public abstract String mostrarDetalhesUsuario();

	public String mostrarDetalhesUsuarios() {
		return null;
	}
	
}