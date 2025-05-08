package Interfaces;

import java.util.List;

import projetoSanduba.Jogo;

public interface RepositorioJogos {
	
	List<Jogo> checarTipo(Class<?>clazz);

	Jogo procurarNome(String titulo);
}
