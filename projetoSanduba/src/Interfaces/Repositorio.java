package Interfaces;

public interface Repositorio<T> {
	void add(T object);
	
	
	void atualizar(T object);
	void deletar(String cpf); 

}
