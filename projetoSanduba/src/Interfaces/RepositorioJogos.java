package Interfaces;

import java.util.List;

import Pessoa.Empresa;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import jogo.Jogo;

public interface RepositorioJogos extends Repositorio<Jogo> {

	@Override
	List<Jogo> getTipo(Class<?> clazz) throws IllegalArgumentException;

	List<Jogo> procurarEmpresa(Empresa empresa) throws DadoDuplicadoException, DadoInvalidoException;

	//resumo para a biblioteca(Ana Alice)
	String resumoJogos(Jogo jogo);
	
	List<Jogo> varrer();

}
