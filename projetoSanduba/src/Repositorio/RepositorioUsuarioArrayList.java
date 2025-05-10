package Repositorio;


import java.util.ArrayList;
import java.util.List;

import Interfaces.Repositorio;
import Interfaces.RepositorioUsuario;
import Pessoa.Usuarios;
// importar os exceptions



public class RepositorioUsuarioArrayList implements Repositorio<Usuarios>, RepositorioUsuario {

	private final List<Usuarios> usuarios = new ArrayList<>(); 
	
	@Override
	public void add(Usuarios usuario) {
		usuarios.add(usuario); // adiciona usuario em na list usuarios
	}

	@Override
	public List<Usuarios> varrer() {
		return new ArrayList<>(usuarios);
	}

	@Override
	public void alterarDados(Usuarios usuario) {

		
	}

	@Override
	public void deletar(Usuarios usuario) {
		usuarios.remove(usuario);
	}

	@Override
	public List<Usuarios> checarTipo(Class<Usuario> clazz) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Usuarios procurarNome(String nome){
		
		return null;
	}

	@Override
	public Usuarios procurarEmail(String email) {
		return null;
	}
	
}
