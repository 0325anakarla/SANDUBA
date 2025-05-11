package funcionalidades;
import Pessoa.Usuarios;

import java.util.Scanner;

import Interfaces.Repositorio;


public class ServicoGeral {
	Scanner sc = new Scanner(System.in);

	public static Usuarios login(String email,String senha,Repositorio<Usuarios> repositorio ) throws IllegalArgumentException{
		if(email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email invalido");
		}
		if(senha ==null || senha.isBlank()) {
			throw new IllegalArgumentException("senha invalida");
		}
		if(repositorio == null) {
			throw new IllegalArgumentException("nao existe essa conta");
		}
		for(Usuarios usuario : repositorio.getTodos()) {
			if(usuario.getEmail() != null && usuario.getSenha() != null && repositorio != null) {
				return usuario;
			}
			
		}
		return null;
	}
	
	
}
