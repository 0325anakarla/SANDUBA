package Interfaces;

import java.util.List;

import Pessoa.Usuarios;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;

public interface RepositorioUsuario extends Repositorio<Usuarios> {

	Usuarios procurarEmail(String email) throws DadoDuplicadoException, DadoInvalidoException;
	

}
