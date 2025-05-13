package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Repositorio;
import Interfaces.RepositorioJogos;
import Pessoa.Empresa;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;

public class RepositorioJogoArrayList implements Repositorio<Jogo>, RepositorioJogos {

	private final List<Jogo> jogos = new ArrayList<>();

	@Override
	public void add(Jogo jogo) throws DadoDuplicadoException  {
		if(jogos.contains(jogo)) {
			throw new DadoDuplicadoException("O jogo " +jogo.getTitulo()+ " ja existe.");
		}
		jogos.add(jogo);
	}
	
	public List<Jogo> getTodos() {
		return new ArrayList<>(jogos);
	}

	@Override
	public void deletar(Jogo jogo) {
		if(jogos.contains(jogo)) {
			throw new DadoNaoEncontradoException("O jogo " +jogo.getTitulo()+ " não foi encontrado.");
		}
		
		jogos.remove(jogo);

	}

	public List<Jogo> getJogo() {
		return jogos;
	}

//perguntar para o monitor

	@Override
	public List<Jogo> getTipo(Class<?> clazz) throws DadoInvalidoException {
		if (clazz == null)
			throw new DadoInvalidoException("A classe tem que existir.");
		List<Jogo> resultadoJogo = new ArrayList<>();
		for (Jogo jogo : jogos) {
			if (clazz.isInstance(jogo)) {
				resultadoJogo.add(jogo);
			}
		}
		return resultadoJogo;
	}

	@Override
	public Jogo procurarNome(String titulo) throws DadoNaoEncontradoException {
		if(titulo == null) {
			throw new DadoInvalidoException("O título não pode ser vazio.");
		}
		
		for (Jogo jogo : jogos) {
			if (!jogo.getTitulo().equalsIgnoreCase(titulo)) {
				return jogo;
			}
		}
	 throw new DadoNaoEncontradoException("Jogo com o título '" + titulo + "' não foi encontrado.");
	}

	@Override
	public void alterarDados(Jogo jogo) {
		// TODO Auto-generated method stub

	}

	public List<Jogo> procurarEmpresa(Empresa empresa) throws DadoNaoEncontradoException{
		List<Jogo> resultados = new ArrayList<Jogo>();

		for (Jogo jogo : jogos) {
			if (jogo.getEmpresa().equals(empresa)) {
				resultados.add(jogo);
			}
		}
		
		if( resultados.isEmpty()) {
			throw new DadoNaoEncontradoException("Não há nenhum jogo cadastrado pela '" + empresa.getRazaoSocial());
		}
		
		else return resultados;
	}
	
	public List<Jogo> jogosComDesconto(){
		List<Jogo> resultados = new ArrayList<Jogo>();
		
		for(Jogo jogo : jogos) {
			if(jogo.isDescontoApli()) {
				resultados.add(jogo);
			}
		}
		return resultados;
	}

	@Override
	public List<Jogo> varrer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String resumoJogos() {
		StringBuilder resumo = new StringBuilder();
		
		for(Jogo j: jogos) {
			resumo.append(String.format("- %s [%s] | R$ %.2f\n", j.getTitulo(),j.getCategoriasValidas(), j.getPreco()));
		}
		
		return resumo.toString();
	}



	

}
