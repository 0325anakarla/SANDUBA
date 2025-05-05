package projetoSanduba;


import java.util.ArrayList;
import java.util.List;

import Interfaces.ControleDeJogos;


public class ArrayListJogo implements ControleDeJogos{
	
	private Jogo jogo;

    public ArrayListJogo(Jogo jogo){
    }

    public List<Jogo> getJogo() {
		return (List<Jogo>) jogo;
	}

	private final List<Jogo> jogo= new ArrayList<>();

}
