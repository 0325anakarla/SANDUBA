package projetoSanduba;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Interfaces.ControleDeJogos;


public class ArrayListJogo implements ControleDeJogos{
	
	Scanner dados = new Scanner(System.in);
	
	private Jogo jogo;

    public ArrayListJogo(Jogo jogo){
    }

    public List<Jogo> getJogo() {
		List<Jogo> jogo2 = (List<Jogo>) jogo;
		return jogo2;
	}

	private final List<Jogo> jogos= new ArrayList<>();
	

	@Override
	public void cadastrarJogos(String titulo, double preco, String descricao, String categorias, int classEtaria,
			String idiomas, String plataDisp, String modAtivacao) {
		// TODO Auto-generated method stub
		
	}
	
	public String opcoeJogo() {
		return "1- Titulo\n2- Preco\n3- Descricao\n4- Categorias\n5- Classificaçao Etaria\n6- idiomas\n7-plataDisp\n8- Modo de Ativacao\n ";
	}

	@Override
	public void alterarDadosDoJogo(Jogo jogo) {
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
				//ALTERAR
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
				//ALTERAR
				String descriç =dados.nextLine();
				jogo.setTitulo(descriç);
				break;
			case 7:
				System.out.println("plataDisp");
				//ALTERAR
				String desci =dados.nextLine();
				jogo.setTitulo(desci);
				break;
			case 8:
				System.out.println("Modo de Ativacao");
				//ALTERAR
				String dscriç =dados.nextLine();
				jogo.setTitulo(dscriç);
				break;
			default:
				System.out.println("Opção invalida!");
	}
	}

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
		System.out.println("Deseja pesquisar o jogo pelo seu titulo ou pelo nome da empresa?");
		System.out.println("1- Titulo\n2-Empresa");
		int opcoes =dados.nextInt();
		switch (opcoes) {
		//FALTA EMPRESA
			case 1:
				System.out.println("Insira o titulo para pesquisa:");
				String pesquisa = dados.nextLine().toLowerCase();
				
				ArrayList<String> resultado = new ArrayList<>();

		        for (Jogo busca : jogos) {
		            if (busca.getTitulo().toLowerCase().contains(pesquisa)) {
		                resultado.add(busca);
		            }
		        }

		        // Exibe o resultado
		        //VER DIREITONHO 
		        if (resultado.isEmpty()) {
		            System.out.println("Nada encontrado sobre '" + pesquisa + "'.");
		        } else {
		            System.out.println("Jogos com o titulo " + pesquisa + ": " );
		            
		            resultado.sort(Comparator.comparing(jogo -> ((Jogo) jogo).getTitulo().toUpperCase()));
;
		            
		            for(String j : resultado) {
		    			System.out.println(j);
		    		}

		        }

		}
				
				
		
		
	}

}
