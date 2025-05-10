package projetoSanduba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Interfaces.ControleDeJogos;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import jogo.Jogo;

public class Adm extends Usuarios implements ControleDeJogos{
	Scanner dados = new Scanner(System.in);

	
	private Cliente cliente;
	private Empresa empresa;
	private Jogo jogo;
	
	private static List<Jogo> jogos = new ArrayList<>();
	private static List<Usuarios> ususario= new ArrayList<>();
	
	public Adm(String nome, String email, String senha) {
		super(nome, email, senha);
	}

	@Override
	public void exibirInformacaoPublica() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibirInformacaoPrivada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String alterarSenha(String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterarEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	//mostrar os jogos em ordem alfabetica
	@Override
	public void seusJogos() {
		jogos.sort(( Jogo jogo, Jogo jogo2 ) -> jogo.getTitulo().toUpperCase().compareTo(jogo2.getTitulo().toUpperCase()));
		
		for(Jogo j : jogos) {
			System.out.println(j);
		}
	}
	
	public void cadastrarConta() {
		System.out.println("QUE");
	}

	@Override 
	public void excluirConta() {
		System.out.println("Insira o Nome da conta que deseja excluir:");
		String opcao= dados.nextLine();
		boolean excluir= ususario.removeIf(ususario->ususario.getNome().equalsIgnoreCase(opcao));
		
		 if (excluir) {
		        System.out.println("Jogo excluido com sucesso!");
		    } else {
		        System.out.println("Titulo invalido!");
		    }
		
	}

	@Override
	public void resumoDeVendasindividual() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumoDeVendasGeral() {
		// TODO Auto-generated method stub
		
	}

/* -----------ARRUMAR ISSO ------------ */	
	
//	@Override
//	public void cadastrarJogos(String titulo, double preco, String descricao, String categorias, int classEtaria,
//			String idiomas, String plataDisp, String modAtivacao) {
//		Jogo jogo= new Jogo( titulo,  preco,  descricao,  categorias,  classEtaria,  idiomas,
//				 plataDisp,  modAtivacao);
//		jogos.add( jogo);
//		
//	}

	
	@Override
	/*public void alterarDadosDoJogo(Jogo jogo) {
		System.out.println(" oque você deseja alterar? ");
		System.out.println(opcoeJogo());
		int opcoes =dados.nextInt();
		switch (opcoes) {
			case 1:
				System.out.println("Insira o tituto que você deseja colocar no lugar de "+jogo.getTitulo());
				String titu =dados.nextLine();
				jogo.setTitulo(titu);
				break;
			case 2:
				System.out.println("Insira o novo preço do jogo "+jogo.getTitulo()+" para alterar");
				double pre =dados.nextDouble();
				jogo.setPreco(pre);
				break;
			case 3:
				System.out.println("Insira a nova descriçao do jogo "+jogo.getTitulo()+" para alterar");
				String descri =dados.nextLine();
				jogo.setTitulo(descri);
				break;
			case 4:
				System.out.println("CATEGORIA!!");
				String descriçao =dados.nextLine();
				jogo.setTitulo(descriçao);
				break;
			case 5:
				System.out.println("Insira a nova classificçao etaria do jogo "+jogo.getTitulo()+" que você deseja alterar");
				int classi =dados.nextInt();
				jogo.setClassEtaria(classi);
				break;
			case 6:
				System.out.println("idiomas");
				String descriç =dados.nextLine();
				jogo.setTitulo(descriç);
				break;
			case 7:
				System.out.println("plataDisp");
				String desci =dados.nextLine();
				jogo.setTitulo(desci);
				break;
			case 8:
				System.out.println("Modo de Ativacao");
				String dscriç =dados.nextLine();
				jogo.setTitulo(dscriç);
				break;

				
		
		}
		
	}*/

	@Override
	public void excluirJogo() {
		System.out.println("Insira o jogo que deseja excluir:");
		String opcao= dados.nextLine();
		boolean excluir= jogos.removeIf(jogo->jogo.getTitulo().equalsIgnoreCase(opcao));
		
		 if (excluir) {
		        System.out.println("Jogo excluido com sucesso!");
		    } else {
		        System.out.println("Titulo invalido!");
		    }
		
		
	}

	@Override
	public void pesquisarJogo() {
		// TODO Auto-generated method stub
		
	}
	
	public String opcoeJogo() {
		return "1- Titulo\n2- Preco\n3- Descricao\n4- Categorias\n5- Classificaçao Etaria\n6- idiomas\n7-plataDisp\n8- Modo de Ativacao\n ";
	}
	
	
	
	
}
