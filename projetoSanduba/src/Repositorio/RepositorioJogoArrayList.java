package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Repositorio;
import Interfaces.RepositorioJogos;
import Pessoa.Empresa;
import projetoSanduba.Jogo;


public class RepositorioJogoArrayList implements Repositorio<Jogo>, RepositorioJogos{
	
	private final List<Jogo> jogos= new ArrayList<>(); 
	
	
	
	@Override
	public void add(Jogo jogo) {
		jogos.add(jogo);
	}

	@Override
	public List<Jogo> search() {
		return new ArrayList<>(jogos);
	}

	//perguntar ao monitor
	@Override
	public void update(Jogo jogo) {
		
		
	}
	

	@Override
	public void deletar(Jogo jogo) {
		jogos.remove(jogo);
		
	}

	public List<Jogo> getJogo() {
		return jogos;
	}

//perguntar para o monitor

	@Override
	public List<Jogo> checarTipo(Class<?> clazz) {
		return null;
	}

	@Override
	public Jogo procurarNome(String titulo) {
		for(Jogo jogo: jogos) 
		{
			if(((projetoSanduba.Jogo) jogo).getTitulo().equalsIgnoreCase(titulo)) {
				return jogo;
			}
		}
		return null;
	}

	@Override
	public void alterarDados(Jogo jogo) {
		// TODO Auto-generated method stub
		
	}

	public List<Jogo> procurarEmpresa(Empresa empresa) {
		List<Jogo> resultados = new ArrayList<Jogo>();
	
		for(Jogo jogo: jogos) {
			if(jogo.getEmpresa().equals(empresa)) {
				resultados.add(jogo);
			}
		}
		return resultados;
	}

}
