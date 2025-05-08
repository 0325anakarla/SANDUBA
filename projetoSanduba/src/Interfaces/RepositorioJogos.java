package Interfaces;

import java.util.List;

import Pessoa.Empresa;
import projetoSanduba.Jogo;

public interface RepositorioJogos {
	
	List<Jogo> checarTipo(Class<?>clazz);

	List<Jogo> procurarEmpresa(Empresa empresa);
	
	Jogo procurarNome(String titulo);
}
