package Interfaces;

import java.util.List;


public interface Repositorio<T> {
	void add(T object);
	
	List<T> search();
	
	T procurarNome(String titulo);
	
	void alterarDadosDoJogo(T object);
	
	void delete(T object);

	List<T> checarTipo(Class<?> clazz);  //listar 

}
