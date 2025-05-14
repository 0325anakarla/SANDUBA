package funcionalidades;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import jogo.ClassificacaoIndicativa;
import jogo.Idiomas;
import jogo.Jogo;
import jogo.PlataformasDisponiveis;


public class ControleDeJogos{
	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	private RepositorioJogoArrayList listJogos;
	
	public ControleDeJogos(Scanner sc, VisualizacaoMenu visualizacaoMenu, RepositorioJogoArrayList listJogos) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		this.listJogos = listJogos;
	}
	
	// cadastrar Jogo
	public void CadastrarJogos(Empresa empresa) throws DadoInvalidoException {
		
		boolean continuarCadastro = true;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataCadastro = LocalDate.now().format(formato);
        

		
		while(continuarCadastro) {
			boolean dadosValidos = false;
			

			Jogo jogo = new Jogo(null, 0, null, new ArrayList<CategoriasJogos>(), new ArrayList<Idiomas>(), new ArrayList<PlataformasDisponiveis>(), null, null, null, null);

			
			do {
				try {
					System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
					System.out.println("║     🎮 CADASTRO DE JOGO - PREENCHA TODAS AS INFORMAÇÕES       ║");
					System.out.println("╚════════════════════════════════════════════════════════════════╝");

					System.out.println("📌 Adicione as informações obrigatórias:");
					
					System.out.print("📝 Título: ");
					jogo.setTitulo(sc.nextLine());

					System.out.print("💲 Preço: ");
					jogo.setPreco(sc.nextDouble());
					sc.nextLine();

					System.out.print("🗒️ Descrição: ");
					jogo.setDescricao(sc.nextLine());

					System.out.println("🏷️ Escolha as Categorias:");
					CategoriasJogos.imprimeCategorias();
					ArrayList<CategoriasJogos> categoriasEscolhidas = new ArrayList<>();
					while (true){
						Integer categoriaEscolhida = sc.nextInt();
						switch (categoriaEscolhida){
							case 1 :
								if  (!categoriasEscolhidas.contains(CategoriasJogos.RPG)){
									categoriasEscolhidas.add(CategoriasJogos.RPG);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 2 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.AVENTURA)){
									categoriasEscolhidas.add(CategoriasJogos.AVENTURA);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 3 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.ACAO)){
									categoriasEscolhidas.add(CategoriasJogos.ACAO);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 4 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.HORROR)){
									categoriasEscolhidas.add(CategoriasJogos.HORROR);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 5 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.MUNDOABERTO)){
									categoriasEscolhidas.add(CategoriasJogos.MUNDOABERTO);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 6 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.TIRO)){
									categoriasEscolhidas.add(CategoriasJogos.TIRO);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 7 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.PRIMEIRAPESSOA)){
									categoriasEscolhidas.add(CategoriasJogos.PRIMEIRAPESSOA);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 8 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.TERCEIRAPESSOA)){
									categoriasEscolhidas.add(CategoriasJogos.TERCEIRAPESSOA);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 9 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.PUZZLE)){
									categoriasEscolhidas.add(CategoriasJogos.PUZZLE);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 10 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.TURNO)){
									categoriasEscolhidas.add(CategoriasJogos.TURNO);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 11 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.ESPORTE)){
									categoriasEscolhidas.add(CategoriasJogos.ESPORTE);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 12 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.LUTA)){
									categoriasEscolhidas.add(CategoriasJogos.LUTA);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 13 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.FANTASIA)){
									categoriasEscolhidas.add(CategoriasJogos.FANTASIA);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 14 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.CONSTRUCAO)){
									categoriasEscolhidas.add(CategoriasJogos.CONSTRUCAO);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 15 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.RITMO)){
									categoriasEscolhidas.add(CategoriasJogos.RITMO);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							case 16 :
								if (!categoriasEscolhidas.contains(CategoriasJogos.BATTLEROYALE)){
									categoriasEscolhidas.add(CategoriasJogos.BATTLEROYALE);
								} else {
									System.out.println("Categoria já escolhida.");
								}
								break;

							default : System.out.println("Opção Inválida.");
						}
						System.out.println("");
						System.out.println("Deseja adicionar mais categorias?");
						System.out.println("1: SIM" + "-" + "2: NÃO");
						int add1 = sc.nextInt();
						if(add1 == 2){
							break;
						}
					}
					jogo.setCategoriasValidas(categoriasEscolhidas);

					System.out.print("🗣️ Escolha os Idiomas Disponíveis: ");
					Idiomas.imprimeIdiomas();
					ArrayList<Idiomas> idiomasEscolhidos = new ArrayList<>();
					while (true){
						Integer idiomaEscolhido = sc.nextInt();
						switch (idiomaEscolhido){
							case 1 :
								if  (!idiomasEscolhidos.contains(Idiomas.INGLES)){
									idiomasEscolhidos.add(Idiomas.INGLES);
								} else {
									System.out.println("Idioma já escolhido.");
								}
								break;

							case 2 :
								if (!idiomasEscolhidos.contains(Idiomas.ESPANHOL)){
									idiomasEscolhidos.add(Idiomas.ESPANHOL);
								} else {
									System.out.println("Idioma já escolhido.");
								}
								break;

							case 3 :
								if (!idiomasEscolhidos.contains(Idiomas.ALEMAO)){
									idiomasEscolhidos.add(Idiomas.ALEMAO);
								} else {
									System.out.println("Idioma já escolhido.");
								}
								break;

							case 4 :
								if (!idiomasEscolhidos.contains(Idiomas.FRANCES)){
									idiomasEscolhidos.add(Idiomas.FRANCES);
								} else {
									System.out.println("Idioma já escolhido.");
								}
								break;

							case 5 :
								if (!idiomasEscolhidos.contains(Idiomas.RUSSO)){
									idiomasEscolhidos.add(Idiomas.RUSSO);
								} else {
									System.out.println("Idioma já escolhido.");
								}
								break;

							case 6 :
								if (!idiomasEscolhidos.contains(Idiomas.CHINES)){
									idiomasEscolhidos.add(Idiomas.CHINES);
								} else {
									System.out.println("Idioma já escolhido.");
								}
								break;

							case 7 :
								if (!idiomasEscolhidos.contains(Idiomas.PORTUGUES)){
									idiomasEscolhidos.add(Idiomas.PORTUGUES);
								} else {
									System.out.println("Idioma já escolhido.");
								}
								break;

							default : System.out.println("Opção Inválida.");
						}
						System.out.println("");
						System.out.println("Deseja adicionar mais idiomas?");
						System.out.println("1: SIM" + "-" + "2: NÃO");
						int add2 = sc.nextInt();
						if(add2 == 2){
							break;
						}
					}
					jogo.setIdiomas(idiomasEscolhidos);

					System.out.print("🎮 Escolha as Plataformas Disponíveis: ");
					PlataformasDisponiveis.imprimePlataformas();
					ArrayList<PlataformasDisponiveis> plataformasEscolhidas = new ArrayList<>();
					while (true){
						Integer plataformaEscolhida = sc.nextInt();
						switch (plataformaEscolhida){
							case 1 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.XBOX)){
									plataformasEscolhidas.add(PlataformasDisponiveis.XBOX);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 2 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.XBOX1)){
									plataformasEscolhidas.add(PlataformasDisponiveis.XBOX1);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 3 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.PS4)){
									plataformasEscolhidas.add(PlataformasDisponiveis.PS4);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 4 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.PS5)){
									plataformasEscolhidas.add(PlataformasDisponiveis.PS5);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 5 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.NINTENDO)){
									plataformasEscolhidas.add(PlataformasDisponiveis.NINTENDO);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 6 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.WINDOWS)){
									plataformasEscolhidas.add(PlataformasDisponiveis.WINDOWS);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 7 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.MACOS)){
									plataformasEscolhidas.add(PlataformasDisponiveis.MACOS);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 8 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.IOS)){
									plataformasEscolhidas.add(PlataformasDisponiveis.IOS);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 9 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.LINUX)){
									plataformasEscolhidas.add(PlataformasDisponiveis.LINUX);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							case 10 :
								if  (!plataformasEscolhidas.contains(PlataformasDisponiveis.ANDROID)){
									plataformasEscolhidas.add(PlataformasDisponiveis.ANDROID);
								} else {
									System.out.println("Plataforma já escolhida.");
								}
								break;

							default : System.out.println("Opção Inválida.");
						}
						System.out.println("");
						System.out.println("Deseja adicionar mais plaformas?");
						System.out.println("1: SIM" + "-" + "2: NÃO");
						int add2 = sc.nextInt();
						if(add2 == 2){
							break;
						}
					}
					jogo.setPlataformasValidas(plataformasEscolhidas);
					
					System.out.print("🔞 Escolha a Classificação Indicativa: ");
					ClassificacaoIndicativa.imprimeClassificacoes();
					while(true){
						Integer classIndEscolhida = sc.nextInt();
						switch (classIndEscolhida) {
						case 1:
							jogo.setClassIndicativa(ClassificacaoIndicativa.LIVRE);
							break;
						case 2:
							jogo.setClassIndicativa(ClassificacaoIndicativa.ANOS10);
							break;
						case 3:
							jogo.setClassIndicativa(ClassificacaoIndicativa.ANOS12);
							break;
						case 4:
							jogo.setClassIndicativa(ClassificacaoIndicativa.ANOS14);
							break;
						case 5:
							jogo.setClassIndicativa(ClassificacaoIndicativa.ANOS16);
							break;
						case 6:
							jogo.setClassIndicativa(ClassificacaoIndicativa.ANOS18);
							break;
						default:
							System.out.println("Opção inválida, escolha novamente:");
						}
						if(classIndEscolhida >= 1 && classIndEscolhida <= 6){
							break;
						}
					}

					dadosValidos = true;
					
				} catch(DadoInvalidoException e) {
					System.out.println("⚠️ Erro: " + e.getMessage());
				}
			}while(!dadosValidos);

			System.out.println("\n╔═══════════════════════════════════════════╗");
			System.out.println("║     📄 DOCUMENTAÇÃO DE CADASTRO DE JOGO     ║");
			System.out.println("╚════════════════════════════════════════════╝");

	        //queria colocar o nome da empresa aqui so pra ter um termo bunitinho na hora de concuir o jogo.
	        System.out.println("Empresa: " + empresa.getRazaoSocial());
	        System.out.println("Jogo: " + jogo.getTitulo());
	        System.out.println("Data do Cadastro: " + dataCadastro);
	        System.out.println(" Repasse de Percentual – 5% da parte das vendas será destinada ao Sanduba.");
	        System.out.println(" Exibição na Plataforma – O jogo seguirá padrões de qualidade.");
	        System.out.println(" Condições de Remoção – A empresa deve comunicar previamente.");
	        System.out.println(" Aceite e Validade – O cadastro só será confirmado com aceite.");
			System.out.println();

			
			System.out.println("\n📥 Realmente deseja adicionar esse jogo?");
			System.out.println("1️⃣  Sim");
			System.out.println("2️⃣  Não");
			System.out.print("👉 Escolha a opção: ");

			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
				case 1:
					try{
						listJogos.add(jogo);
						jogo.setEmpresa(empresa);
						empresa.atualizarJogos(jogo);
						System.out.println("✅ O jogo \"" + jogo.getTitulo() + "\" foi adicionado com sucesso!");
					
					} catch (DadoDuplicadoException e) {
						System.out.println("❌ Erro: " + e.getMessage());
			            System.out.println("🔁 Você deseja refazer o cadastro de jogo?");
			            System.out.println("1️⃣  Sim");
			            System.out.println("2️⃣  Não");
			            System.out.print("👉 Escolha a opção: ");
						int refazer = sc.nextInt();
						sc.nextLine();
						
						if(refazer == 2) { 
							continuarCadastro = false;
							System.out.println("🚫 Cadastro cancelado.");
						}
					}
				break;
				case 2: 
					System.out.println("🚫 Cadastro de jogo cancelado!");
					continuarCadastro = false;
					break;
				default: 
					   System.out.println("⚠️ Opção inválida!");
			}	
	
		}
	}
	
    

	
	//deletar jogo
	public void deletarJogo(Empresa empresa) throws DadoInvalidoException {
		
		boolean continuarRemocao = true;

		System.out.println("\n╔══════════════════════════════╗");
		System.out.println("║       🗑️ REMOVER JOGO          ║");
		System.out.println("╚══════════════════════════════╝");

		
		while(continuarRemocao) {
			System.out.println("Qual desses jogos voce quer excluir.");
			System.out.print("Digite o nome do jogo:");
			String titulo = sc.nextLine();
			
			//CORRIGIR ISSO
			//para não permitir que uma empresa delete um jogo que não foi cadastrada por ela
			for (Jogo jogo : empresa.getJogosEmpresa()) {
				if (!jogo.getTitulo().equalsIgnoreCase(titulo)) {
					System.out.println("Este jogo não foi cadastrado por essa empresa!");
					continuarRemocao = false;
					break;
				}
			}
			
			//apenas temporário(alana)
			if (continuarRemocao == false) {
				break;
			}
			
			try {
				Jogo resultado = listJogos.procurarNome(titulo);
				System.out.println("O jogo que deseja excluir é "+resultado.getTitulo()+" tem certeza?");
				System.out.println("1️⃣  Sim");
		        System.out.println("2️⃣  Não");
		        System.out.print("👉 Escolha a opção: ");
				int opcao = Integer.parseInt(sc.nextLine());
				sc.nextLine();
				
				switch(opcao) {
					case 1:
						listJogos.deletar(resultado);
						empresa.deletarJogo(resultado);
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
				System.out.println("1️⃣  Sim");
		        System.out.println("2️⃣  Não");
		        System.out.print("👉 Escolha a opção: ");
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
			
			visualizacaoMenu.telaAlterarJogos(jogo);
			
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
			System.out.println("1️⃣  Sim");
	        System.out.println("2️⃣  Não");
	        System.out.print("👉 Escolha a opção: ");
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
			System.out.println("Nenhum jogo cadastrado pra essa empresa.");
		}
	}
	
	public void ListJogosComDesconto() {
		List<Jogo> jogos = listJogos.jogosComDesconto();
		
		for(Jogo jogo : jogos) {
			//chmar o mostrar dados basico do jogo
			System.out.println(listJogos.resumoJogos(jogo));

		
	}
	}
	
	
	public List<CategoriasJogos> catgEscolhidas(Scanner sc){
		CategoriasJogos.imprimeCategorias();
		ArrayList<CategoriasJogos> categoriasEscolhidas = new ArrayList<>();
		while (true){
			Integer categoriaEscolhida = sc.nextInt();
			switch (categoriaEscolhida){
				case 1 :
					if  (!categoriasEscolhidas.contains(CategoriasJogos.RPG)){
						categoriasEscolhidas.add(CategoriasJogos.RPG);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 2 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.AVENTURA)){
						categoriasEscolhidas.add(CategoriasJogos.AVENTURA);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 3 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.ACAO)){
						categoriasEscolhidas.add(CategoriasJogos.ACAO);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 4 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.HORROR)){
						categoriasEscolhidas.add(CategoriasJogos.HORROR);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 5 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.MUNDOABERTO)){
						categoriasEscolhidas.add(CategoriasJogos.MUNDOABERTO);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 6 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.TIRO)){
						categoriasEscolhidas.add(CategoriasJogos.TIRO);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 7 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.PRIMEIRAPESSOA)){
						categoriasEscolhidas.add(CategoriasJogos.PRIMEIRAPESSOA);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 8 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.TERCEIRAPESSOA)){
						categoriasEscolhidas.add(CategoriasJogos.TERCEIRAPESSOA);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 9 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.PUZZLE)){
						categoriasEscolhidas.add(CategoriasJogos.PUZZLE);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 10 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.TURNO)){
						categoriasEscolhidas.add(CategoriasJogos.TURNO);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 11 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.ESPORTE)){
						categoriasEscolhidas.add(CategoriasJogos.ESPORTE);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 12 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.LUTA)){
						categoriasEscolhidas.add(CategoriasJogos.LUTA);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 13 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.FANTASIA)){
						categoriasEscolhidas.add(CategoriasJogos.FANTASIA);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 14 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.CONSTRUCAO)){
						categoriasEscolhidas.add(CategoriasJogos.CONSTRUCAO);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 15 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.RITMO)){
						categoriasEscolhidas.add(CategoriasJogos.RITMO);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				case 16 :
					if (!categoriasEscolhidas.contains(CategoriasJogos.BATTLEROYALE)){
						categoriasEscolhidas.add(CategoriasJogos.BATTLEROYALE);
					} else {
						System.out.println("Categoria já escolhida.");
					}
					break;

				default : System.out.println("Opção Inválida.");
			}
			System.out.println("");
			System.out.println("Deseja adicionar mais categorias?");
			System.out.println("1: SIM" + "-" + "2: NÃO");
			int add1 = sc.nextInt();
			if(add1 == 2){
				break;
			}
		}
		
		return categoriasEscolhidas;
	}
	
	public void buscarJogoCtg(Scanner sc, RepositorioJogoArrayList listJogos) {
		System.out.println("🏷️ Escolha as Categorias para o :");
		List<CategoriasJogos> categorias = catgEscolhidas(sc);
		for(Jogo jogo : listJogos.procurarPorCategorias(categorias)){
			System.out.println(jogo.getResumo());
		}
		
	}
}





	




