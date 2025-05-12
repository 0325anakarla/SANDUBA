package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Repositorio;
import Interfaces.RepositorioUsuario;
import Pessoa.Usuarios;
import TratamentoDeErro.DadoInvalidoException;
// importar os exceptions

public class RepositorioUsuarioArrayList implements Repositorio<Usuarios>, RepositorioUsuario {

    private final List<Usuarios> usuarios = new ArrayList<>(); //Vai armazenar os Usuarios na list
    
	@Override
	public void add(Usuarios addUsuario) {
		usuarios.add(addUsuario);
		// ok
	}

	@Override
	public List<Usuarios> getTodos() { // vai varrer todo o arraylist [e tipo um getall
		return new ArrayList<>(usuarios);
	}

	@Override
	public void alterarDados(Usuarios upUsuario) {

	}

	@Override
	public void deletar(Usuarios byeUsuario) {
		usuarios.remove(byeUsuario);
	}

	@Override
	public List<Usuarios> getTipo(Class<?> clazz) /*throws DadoDuplicadoException, DadoInvalidoException*/ {
		if (clazz == null)
			throw new DadoInvalidoException("A classe tem que existir.");
		
		List<Usuarios> resultadoUsuario = new ArrayList<>();
		for (Usuarios usuario : usuarios) {
			if (clazz.isInstance(usuario)) {
				resultadoUsuario.add(usuario);
			}
		}
		return null;
	}

	// -------------- metodos para procurar coisas especificas.
	@Override
	public Usuarios procurarNome(String nome) {

		for (Usuarios usuario : usuarios) {
			if (usuario.getNome().equalsIgnoreCase(nome)) {

				return usuario;
			}
		}
		throw new DadoInvalidoException("Nome" + nome + " não encontrada para exclusão.");
	}

	@Override
	public Usuarios procurarEmail(String email) {
		for (Usuarios usuario : usuarios) {
			if (usuario.getEmail().equalsIgnoreCase(email)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public List<Usuarios> varrer() {
		// TODO Auto-generated method stub
		return null;
	}
}
