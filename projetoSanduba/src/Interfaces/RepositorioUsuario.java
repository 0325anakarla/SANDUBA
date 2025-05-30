package Interfaces;

import java.util.List;

import Pessoa.Usuarios;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;

public interface RepositorioUsuario extends Repositorio<Usuarios> {

	Usuarios procurarEmail(String email) throws DadoDuplicadoException, DadoInvalidoException;

	Usuarios procurarEmailSenha(String email, String senha) throws DadoDuplicadoException, DadoInvalidoException;

	List<Usuarios> varrer();

}
