package Pessoa;
import java.util.ArrayList;
import java.util.List;

import Interfaces.RepositorioUsuario;

public class ClienteArrayList implements RepositorioUsuario {
	 List<Usuarios> usuario = new ArrayList<>();


	@Override
	public Usuarios procurarNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios procurarEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> checarTipo(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 
	
	
	
}
