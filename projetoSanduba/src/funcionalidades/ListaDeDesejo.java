package funcionalidades;

import java.util.ArrayList;
import java.util.List;

import Pessoa.Cliente;
import jogo.Jogo;

public class ListaDeDesejo {
	// apenas um teste
	private Cliente cliente;

	private List<Jogo> listaDeDesejos = new ArrayList<>();

	public List<Jogo> getListaDeDesejos(Cliente cliente) {
		return listaDeDesejos;
	}

	public void addListaDesejos(Jogo jogo) {
		listaDeDesejos.add(jogo);
	}

	public void removeListaDesejos(Jogo jogo) {
		listaDeDesejos.remove(jogo);
	}

}
