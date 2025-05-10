package Repositorio;


import java.util.ArrayList;
import java.util.List;

import Interfaces.Repositorio;
import Interfaces.RepositorioUsuario;
import Pessoa.Usuarios;
import TratamentoDeErro.DadoInvalidoException;
// importar os exceptions



public class RepositorioUsuarioArrayList implements Repositorio<Usuarios>, RepositorioUsuario {

	private final List<Usuarios> usuarios = new ArrayList<>(); 
	
	@Override
	public void add(Usuarios usuario) {
		if() {
			
		}
	}

	@Override
	public List<Usuarios> search() {
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
		
		for(Usuarios usuario : usuarios) {
			if(usuario.getNome().equalsIgnoreCase(nome)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public Usuarios procurarEmail(String email) {
		for(Usuarios usuario: usuarios) {
			if(usuario.getEmail().equalsIgnoreCase(email)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public List<Usuarios> varrer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
