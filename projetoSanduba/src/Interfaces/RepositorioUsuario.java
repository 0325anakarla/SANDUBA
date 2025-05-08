package Interfaces;
import java.util.List;

import Pessoa.Usuarios;

public interface RepositorioUsuario {
	Usuarios procurarNome(String  nome);
	Usuarios procurarEmail(String email);
	
}
