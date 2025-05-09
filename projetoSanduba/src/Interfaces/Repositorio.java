package Interfaces;

import java.util.List;

import Pessoa.Empresa;
import jogo.Jogo;


public interface Repositorio<T> {
	void add(T object);
	
	List<T> search();
	
	T procurarNome(String titulo);
	
	void alterarDados(T object);
	
	void deletar(T object);

	List<T> checarTipo(Class<?> clazz);  
	//clazz permite que você passe qualquer classe sem restrições e trabalhe com ela dinamicamente.


}
