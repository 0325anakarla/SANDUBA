package Pessoa;

import java.util.HashSet;
import java.util.Set;

import TratamentoDeErro.DadoInvalidoException;

public abstract class Usuarios {
	private String nome;
	private String email;
	private String senha;
	private static Set<String> dadosSrp = new HashSet<>();
	
	public Usuarios(String nome, String email, String senha) {
		this.nome = nome;
		String nomeFormat = nome.trim().toLowerCase();
		dadosSrp.add(nomeFormat);
		
		this.email = email;
		String nomeFormat2 = nome.trim().toLowerCase();
		dadosSrp.add(nomeFormat2);
		
		this.senha = senha;
	}

	public Usuarios() {
		
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
		String emailFormat = email.trim().toLowerCase();

        if (dadosSrp.contains(emailFormat)) {
            throw new DadoInvalidoException("⚠️ Email já cadastrado.");
        }

        if (this.email != null) {
            dadosSrp.remove(this.email.trim().toLowerCase());
        }
        this.email = email;
        dadosSrp.add(emailFormat);
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome)throws DadoInvalidoException{
		if(nome == null || nome.isBlank()) {
			throw new DadoInvalidoException(" ⚠️ Nome invalido");
		}
        String nomeFormat = nome.trim().toLowerCase();

        if (dadosSrp.contains(nomeFormat)) {
            throw new DadoInvalidoException("⚠️ Nome de usuário ja cadastrado.");
        }

        if (this.nome != null) {
            dadosSrp.remove(this.nome.trim().toLowerCase());
        }
        this.nome = nome;
        dadosSrp.add(nomeFormat);
		
		this.nome = nome;
	}
	

	
	public abstract String mostrarDetalhesUsuario();

	public String mostrarDetalhesUsuarios() {
		return null;
	}

	public void seusJogos() {
		// TODO Auto-generated method stub
		
	}
}