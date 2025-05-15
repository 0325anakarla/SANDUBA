package Interfaces;

import java.util.List;

import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;

public interface Repositorio<T> {


	void add(T object) throws DadoDuplicadoException, DadoInvalidoException;

	List<T> getTodos();

	T procurarNome(String nome)throws DadoInvalidoException;

	void alterarDados(T object);

	void deletar(T object);
	
	List<T> getTipo(Class<?> clazz) throws DadoInvalidoException;
}
