package funcionalidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Console.VisualizacaoMenu;
import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.CategoriasJogos;
import jogo.Jogo;

public class ControleDeJogos{
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();	
	
	VisualizacaoMenu menu = new VisualizacaoMenu();
	
	//final
	Scanner sc = new Scanner(System.in);
	
	// cadastrar Jogo
	public void CadastrarJogos() throws DadoInvalidoException {
		
		boolean continuarCadastro = true;
		
		while(continuarCadastro) {
			boolean dadosValidos = false;
			
			Jogo jogo = new Jogo(null, 0, null, null, 0, null, null, null, null, null);
			
			do {
				try {
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
					
					dadosValidos = true;
					
				} catch(DadoInvalidoException e) {
					System.out.println("Erro: "+ e.getMessage());
				}
			}while(!dadosValidos);
			
			System.out.println("Realmente deseja adicionar esse jogo?");
			System.out.println("1. Sim");
			System.out.println("2. Não");
			System.out.print("Escolha a opção:");
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
			case 1:
				try{
					listJogos.add(jogo);	
					System.out.println("O " +jogo.getTitulo()+ " foi adicionado com sucesso");
					continuarCadastro = false;
					
				} catch (DadoDuplicadoException e) {
					System.out.println("Erro: " +e.getMessage());
					System.out.println("Você refazer o cadastro de jogo?");
					System.out.println("1. Sim");
					System.out.println("2. Não");
					System.out.print("Escolha a opção:");
					int refazer = sc.nextInt();
					sc.nextLine();
						
					if(refazer == 2) { 
						continuarCadastro = false;
						System.out.println("Cadastro cancelado.");
					}
				}
				break;
			case 2: 
				System.out.println("Cadastro de jogo cancelado!");
				break;
			default: 
				System.out.println("Opção invalida!");
			}	
	
			}
	}
	
	//deletar jogo
	public void deletarJogo(Empresa empresa) {
		
		boolean continuarRemocao = true;

		System.out.println("\n--- REMOVER JOGO ---");
		
		while(continuarRemocao) {
			System.out.println("Qual desses jogos voce quer excluir.");
			System.out.print("Digite o nome do jogo:");
			String titulo = sc.nextLine();
			try {
				Jogo resultado = listJogos.procurarNome(titulo);
				System.out.println("O jogo que deseja excluir é "+resultado.getTitulo()+" tem certeza?");
				System.out.println("1. Sim");
				System.out.println("2. Não");
				int opcao = Integer.parseInt(sc.nextLine());
				sc.nextLine();
				
				switch(opcao) {
					case 1:
						listJogos.deletar(resultado);
						System.out.println("O jogo "+resultado.getTitulo()+" foi deletado com sucesso.");
						continuarRemocao = false;
						break;
					case 2:
						System.out.println("Remoção cancelada.");
						break;
					default: 
						System.out.println("Opção invalida.\nInsira um valido:");
						break;
				}
			}catch(DadoNaoEncontradoException e){
				System.out.println("Erro:" +e.getMessage());
				System.out.println("Deseja refazer a remoção");
				System.out.println("1. Sim");
				System.out.println("2. Não");
				int refazer = Integer.parseInt(sc.nextLine());
				
				if(refazer == 2) {
					continuarRemocao = false; 
				}
			}
		}
	}
	
	//estrutura falta apenas colocar pra receber os dados
	public void alterarDadosDosJogos(Jogo jogo) {
		int opcao =0;
		
		boolean continuarAlterar = true;
		
		while(continuarAlterar) {
			
			menu.telaAlterarJogos(jogo);
			
			opcao = Integer.parseInt(sc.nextLine());
			
			try {
				switch(opcao) {
					case 1:
						System.out.println("Digite o novo titulo do jogo que escolheu:");
						jogo.setTitulo(sc.nextLine());
					case 2:
						System.out.println("Digite o novo preço do jogo que escolheu:");
						jogo.setPreco(sc.nextDouble());
					case 3:
						System.out.println("Digite a nova descrição do jogo que escolheu:");
						jogo.setDescricao(sc.nextLine());
					case 4:
						System.out.println("Digite as novas categorias do jogo que escolheu:");
					case 5:
						System.out.println("Digite a nova classificação etária do jogo que escolheu:");
					case 6:
						System.out.println("Digite os novos idiomas do jogo que escolheu:");
					case 7:
						System.out.println("Digite as novas plataformas disponíveis do jogo que escolheu:");
					case 8:
						System.out.println("Digite a nova data de lançamento do jogo que escolheu:");
					case 9: 
						System.out.println("Voltar para minha conta.");
						continuarAlterar = false;
					default:
						System.out.println("Opção inválida. Digite novamente.");
				}
			}catch(DadoInvalidoException e) {
				System.out.println("Erro: "+ e.getMessage());
			}
			
			System.out.println("Deseja alterar outro dado:");
			System.out.println("1. Sim");
			System.out.println("2. Não");
			System.out.print("Escolha a opção:");
			int refazer = Integer.parseInt(sc.nextLine());
			
			if(refazer == 2) {
				continuarAlterar = false;
			}
		}
		}
	
	//Listar todos os jogos da empresa por titulo
	public void ListJogosEmpresa(Empresa empresa) {
		try{
			List<Jogo> jogos = listJogos.procurarEmpresa(empresa);
			System.out.println("Jogos da empresa:");
			for (int i = 0; i < jogos.size(); i++) {
			    System.out.println((i+1) + ". " + jogos.get(i).getTitulo());
			}

		}catch(DadoNaoEncontradoException e) {
			System.out.println("Erro:"+e.getMessage());
			System.out.println("Nenhum jogo cadastrado pra essa empresa. Adicione um antes de tentar remover.");
		}
	}

	}
	
	//@Override
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
		
	}
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
				
				
		
		
	}*/




