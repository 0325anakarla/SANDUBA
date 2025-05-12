package Interfaces;

import java.util.List;

public interface Repositorio<T> {


	void add(T object);

	List<T> getTodos();

	T procurarNome(String nome);

	void alterarDados(T object);

	void deletar(T object);

	List<T> getTipo(Class<?> clazz);
}
