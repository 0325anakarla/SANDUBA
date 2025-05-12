package funcionalidades;

import java.util.ArrayList;
import java.util.List;

import Pessoa.Cliente;
import jogo.Jogo;

public class ListaDeDesejo {
	//apenas um teste 
	
	private final List<Jogo> listaDeDesejos = new ArrayList<>();

	public List<Jogo> getJogos(Cliente cliente) {
		return listaDeDesejos;
	}
}
