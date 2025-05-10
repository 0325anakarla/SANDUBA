package Interfaces;

import java.util.List;

import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoNaoEncontradoException;

public interface Repositorio<T> {

	void add(T object) throws DadoDuplicadoException;
	
	List<T> varrer();
	
	List<T> getTodos();

	T procurarNome(String nome) throws DadoNaoEncontradoException;

	void alterarDados(T object);

	void deletar(T object);

	List<T> getTipo(Class<?> clazz);
}
