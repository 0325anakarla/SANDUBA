package Interfaces;
import java.util.List;

import Pessoa.Usuarios;

public interface RepositorioUsuario {
	Usuarios procurarNome(String  nome);
	Usuarios procurarEmail(String email);
	
	//clazz permite que você passe qualquer classe sem restrições e trabalhe com ela dinamicamente.
	
	List<Usuarios> checarTipo(Class<?>clazz);
}
