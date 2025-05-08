package funcionalidades;

import java.util.List;
import java.util.Scanner;

import Interfaces.Repositorio;
import Interfaces.RepositorioJogos;
import Repositorio.RepositorioJogoArrayList;
import projetoSanduba.Jogo;

public class ControleDeJogos{
	RepositorioJogoArrayList<Jogo> jogos = new RepositorioJogoArrayList<Jogo>();	
	
	//final
	Scanner sc = new Scanner(System.in);
	
	public void CadastrarJogos() {
	
		Jogo jogo = new Jogo(null, null);
		
		System.out.println("\n--- CADASTRAR JOGOS ---");
		
		System.out.println("Adicione as informações obrigatórias:");
		
		System.out.print("Titulo: ");
		jogo.setTitulo(sc.nextLine());
		
		System.out.print("Preço: ");
		jogo.setPreco(sc.nextDouble());
		sc.nextLine();
		
		System.out.print("Descrição: ");
		jogo.setDescricao(sc.nextLine());
		
		//a parte de categoria eu nao entendi como funciona vai ficar sem por enquanto
		
		System.out.print("Classificação etária: ");
		jogo.setClassEtaria(sc.nextInt());
		sc.nextLine();
		
		System.out.print("Idiomas Disponiveis: ");
		jogo.setIdiomas(sc.nextLine());
		
		System.out.print("Plataformas disponíveis: ");
		jogo.setPlataDisp(sc.nextLine());
		
		
		System.out.println("Realmente deseja adicionar esse jogo?");
		System.out.println("1. Sim");
		System.out.println("2. Não");
		System.out.print("Escolha a opção:");
		int opcao = sc.nextInt();
		sc.nextLine();
				
		switch(opcao) {
		case 1:
			jogos.add(jogo);
			System.out.println("O " +jogo.getTitulo()+ " foi adicionado com sucesso");
			break;
		case 2: 
			System.out.println("Cadastro de jogo cancelado!");
			break;
		default: 
			System.out.println("Opção invalida!");
		}	
	}

	
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

}
