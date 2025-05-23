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

public class ControleDeJogos {
	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	private RepositorioJogoArrayList listJogos;

	public ControleDeJogos(Scanner sc, VisualizacaoMenu visualizacaoMenu, RepositorioJogoArrayList listJogos) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		this.listJogos = listJogos;
	}

	// tem que instanciar eles fora do metodo CadastrarJogos pra funcionar em todos
	// os outros metodos
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate lancamento = null;
	String dataCadastro = LocalDate.now().format(formato); // nao entendi pra que isso serve

	ArrayList<CategoriasJogos> categoriasEscolhidas = new ArrayList<>();
	ArrayList<Idiomas> idiomasEscolhidos = new ArrayList<>();
	ArrayList<PlataformasDisponiveis> plataformasEscolhidas = new ArrayList<>();

	// cadastrar Jogo
	public void CadastrarJogos(Empresa empresa) throws DadoInvalidoException {

		boolean continuarCadastro = true;

		while (continuarCadastro) {
			boolean dadosValidos = false;

			Jogo jogo = new Jogo(null, 0, null, new ArrayList<CategoriasJogos>(), new ArrayList<Idiomas>(),
					new ArrayList<PlataformasDisponiveis>(), null, null, null);

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
					boolean continuarCategorias = true;
					while (continuarCategorias) {
						try {
							System.out.print("👉 Digite o número da categoria: ");
							int categoriaEscolhida = Integer.parseInt(sc.nextLine());

							if (categoriaEscolhida >= 0 && categoriaEscolhida < CategoriasJogos.values().length) {
								CategoriasJogos categoria = CategoriasJogos.values()[categoriaEscolhida];

								if (!categoriasEscolhidas.contains(categoria)) {
									categoriasEscolhidas.add(categoria);
									System.out.println("✅ Categoria adicionada: " + categoria.getCategoria());
								} else {
									System.out.println("⚠️ Categoria já escolhida.");
								}
							} else {
								System.out.println("❌ Índice inválido. Tente novamente.");
							}

						} catch (NumberFormatException | DadoDuplicadoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
							continue;
						}

						System.out.println("\nDeseja adicionar mais categorias?");
						System.out.println("1️⃣ - ✅ SIM");
						System.out.println("2️⃣ - ❌ NÃO");

						boolean opcaoValida = false;
						while (!opcaoValida) {
							try {
								System.out.print("👉 Escolha a opção: ");
								int add1 = Integer.parseInt(sc.nextLine());
								if (add1 == 2) {
									jogo.setCategoriasValidas(categoriasEscolhidas);
									continuarCategorias = false;
									break;
								} else if (add1 == 1) {
									opcaoValida = true;
								} else {
									System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
								}
							} catch (NumberFormatException e) {
								System.out.println("❌ Erro: " + e.getMessage());
							}
						}
					}

					System.out.println("🗣️ Escolha os Idiomas Disponíveis:");
					Idiomas.imprimeIdiomas();
					continuarCategorias = true;
					while (continuarCategorias) {
						try {
							System.out.print("👉 Digite o número do idioma: ");
							int idiomaEscolhido = Integer.parseInt(sc.nextLine());

							if (idiomaEscolhido >= 0 && idiomaEscolhido < Idiomas.values().length) {
								Idiomas idioma = Idiomas.values()[idiomaEscolhido];

								if (!idiomasEscolhidos.contains(idioma)) {
									idiomasEscolhidos.add(idioma);
									System.out.println("✅ Idioma adicionado: " + idioma.getIdioma());
								} else {
									System.out.println("⚠️ Idioma já escolhido.");
								}
							} else {
								System.out.println("❌ Índice inválido. Tente novamente.");
							}

						} catch (NumberFormatException | DadoDuplicadoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
							continue;
						}

						System.out.println("\nDeseja adicionar mais idiomas?");
						System.out.println("1️⃣ - ✅ SIM");
						System.out.println("2️⃣ - ❌ NÃO");

						boolean opcaoValida = false;
						while (!opcaoValida) {
							try {
								System.out.print("👉 Escolha a opção: ");
								int add2 = Integer.parseInt(sc.nextLine());

								if (add2 == 2) {
									jogo.setIdiomas(idiomasEscolhidos);
									continuarCategorias = false;
									break;
								} else if (add2 == 1) {
									opcaoValida = true;
								} else {
									System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
								}

							} catch (NumberFormatException e) {
								System.out.println("❌ Erro: " + e.getMessage());
							}

						}
					}

					System.out.println("🎮 Escolha as Plataformas Disponíveis:");
					PlataformasDisponiveis.imprimePlataformas();
					continuarCategorias = true;
					while (continuarCategorias) {
						try {
							System.out.print("👉 Digite o número da plataforma: ");
							int plataformaEscolhida = Integer.parseInt(sc.nextLine());

							if (plataformaEscolhida >= 0
									&& plataformaEscolhida < PlataformasDisponiveis.values().length) {
								PlataformasDisponiveis plataforma = PlataformasDisponiveis
										.values()[plataformaEscolhida];

								if (!plataformasEscolhidas.contains(plataforma)) {
									plataformasEscolhidas.add(plataforma);
									System.out.println("✅ Plataforma adicionada: " + plataforma.getPlataforma());
								} else {
									System.out.println("⚠️ Plataforma já escolhida.");
								}
							} else {
								System.out.println("❌ Índice inválido. Tente novamente.");
							}

						} catch (NumberFormatException | DadoDuplicadoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
							continue;
						}

						// Pergunta se quer adicionar mais
						System.out.println("\nDeseja adicionar mais plataformas?");
						System.out.println("1️⃣ - ✅ SIM");
						System.out.println("2️⃣ - ❌ NÃO");

						boolean opcaoValida = false;
						while (!opcaoValida) {
							try {
								System.out.print("👉 Escolha a opção: ");
								int add2 = Integer.parseInt(sc.nextLine());

								if (add2 == 2) {
									jogo.setPlataformasValidas(plataformasEscolhidas);
									continuarCategorias = false;
									break;
								} else if (add2 == 1) {
									opcaoValida = true;
								} else {
									System.out.println("⚠️ Opção inválida. Digite 1 ou 2.");
								}

							} catch (NumberFormatException e) {
								System.out.println("❌ Erro: " + e.getMessage());
							}
						}
					}

					System.out.println("🔞 Escolha a Classificação Indicativa:");
					ClassificacaoIndicativa.imprimeClassificacoes();
					while (true) {
						try {
							System.out.print("👉 Digite o número correspondente: ");
							int escolha = Integer.parseInt(sc.nextLine());

							if (escolha >= 0 && escolha < ClassificacaoIndicativa.values().length) {
								ClassificacaoIndicativa classificacao = ClassificacaoIndicativa.values()[escolha];
								jogo.setClassIndicativa(classificacao);
								break;
							} else {
								System.out.println("⚠️ Opção inválida. Digite um número entre 0 e "
										+ (ClassificacaoIndicativa.values().length - 1));
							}
						} catch (NumberFormatException e) {
							System.out.println("❌ Erro: entrada inválida. Tenta de novo.");
						}
					}

					System.out.println("📅 Digite a data de lançamento (formato: dd/MM/yyyy): ");
					String ldata = sc.nextLine();
					lancamento = LocalDate.parse(ldata, formato);
					jogo.setDataDeLancamento(lancamento);

					System.out.print("🔐 O jogo " + jogo.getTitulo() + " será cadastrado sob a empresa "
							+ empresa.getRazaoSocial() + ".");

					dadosValidos = true;

				} catch (DadoInvalidoException e) {
					System.out.println("⚠️ Erro: " + e.getMessage());
				}
			} while (!dadosValidos);

			System.out.println("\n╔═══════════════════════════════════════════╗");
			System.out.println("║     📄 DOCUMENTAÇÃO DE CADASTRO DE JOGO     ║");
			System.out.println("╚════════════════════════════════════════════╝");

			System.out.println("🧍 Empresa: " + empresa.getRazaoSocial());
			System.out.println("🎮 Jogo: " + jogo.getTitulo());
			System.out.println("✅ Data do Cadastro: " + dataCadastro);
			System.out.println("➕ Repasse de Percentual – 5% da parte das vendas será destinada ao Sanduba.");
			System.out.println("🎮 Exibição na Plataforma – O jogo seguirá padrões de qualidade.");
			System.out.println("⚠️ Condições de Remoção – A empresa deve comunicar previamente.");
			System.out.println("💖 Aceite e Validade – O cadastro só será confirmado com aceite.");
			System.out.println();

			System.out.println("\n📥 Realmente deseja adicionar esse jogo?");
			System.out.println("1️⃣  Sim");
			System.out.println("2️⃣  Não");
			System.out.print("👉 Escolha a opção: ");

			int opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				try {
					listJogos.add(jogo);
					jogo.setEmpresa(empresa);
					empresa.atualizarJogos(jogo);
					System.out.println("✅ O jogo \"" + jogo.getTitulo() + "\" foi adicionado com sucesso!");
					continuarCadastro = false;
				} catch (DadoDuplicadoException e) {
					System.out.println("❌ Erro: " + e.getMessage());
					System.out.println("🔁 Você deseja refazer o cadastro de jogo?");
					System.out.println("1️⃣  Sim");
					System.out.println("2️⃣  Não");
					System.out.print("👉 Escolha a opção: ");
					int refazer = sc.nextInt();
					sc.nextLine();

					if (refazer == 2) {
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

	// deletar jogo
	public void deletarJogo(Empresa empresa) throws DadoInvalidoException {
		if (empresa.getJogosEmpresa().isEmpty()) {
			System.out.println("⚠️ A empresa não possui jogos cadastrados para remover.");
			return;
		}

		boolean continuarRemocao = true;
		while (continuarRemocao) {
			if (empresa.getJogosEmpresa().isEmpty()) {
				System.out.println("⚠️ A empresa não possui jogos cadastrados para remover.");
				break;
			}

			System.out.print("\nDigite o nome do jogo que deseja excluir: ");
			try {
				Jogo resultado = empresa.procurarNomeJC(sc.nextLine());
				System.out.println("\nTem certeza que deseja remover o jogo \"" + resultado.getTitulo() + "\"?");
				System.out.println("  [1️⃣] Sim");
				System.out.println("  [2️⃣] Não");
				System.out.print("👉 Escolha a opção: ");
				int opcao = Integer.parseInt(sc.nextLine());
				switch (opcao) {
				case 1:
					listJogos.deletar(resultado);
					empresa.deletarJogo(resultado);
					System.out.println("✅ O jogo \"" + resultado.getTitulo() + "\" foi deletado com sucesso!");
					continuarRemocao = false;
					break;
				case 2:
					System.out.println("❌ Remoção cancelada.");
					continuarRemocao = false;
					break;
				default:
					System.out.println("⚠️ Opção inválida. Tente novamente.");
					break;
				}
			} catch (DadoNaoEncontradoException e) {
				System.out.println("❌ Erro: " + e.getMessage());
				System.out.println("🔁 Tente novamente digitando o nome correto do jogo.");
			} catch (NumberFormatException e) {
				System.out.println("❌ Erro: Entrada inválida. Digite o número da opção.");
			}
		}
	}

	// está recebendo os dados novos agora
	// espero que o clear no arraylist nao estrague tudo
	public void alterarDadosDosJogos(Jogo jogo) {
		int opcao = 0;

		boolean continuarAlterar = true;

		while (continuarAlterar) {

			visualizacaoMenu.telaAlterarJogos(jogo);

			opcao = Integer.parseInt(sc.nextLine());

			try {
				switch (opcao) {
				case 1:
					System.out.println("➕ Digite o novo titulo do jogo que escolheu:");
					jogo.setTitulo(sc.nextLine());
				case 2:
					System.out.println("➕ Digite o novo preço do jogo que escolheu:");
					jogo.setPreco(sc.nextDouble());
				case 3:
					System.out.println("➕ Digite a nova descrição do jogo que escolheu:");
					jogo.setDescricao(sc.nextLine());
				case 4:
					System.out.println("➕ Digite as novas categorias do jogo que escolheu:");
					CategoriasJogos.imprimeCategorias();
					categoriasEscolhidas.clear();
					while (true) {
						Integer categoriaEscolhida = sc.nextInt();
						switch (categoriaEscolhida) {
						case 1:
							if (!categoriasEscolhidas.contains(CategoriasJogos.RPG)) {
								categoriasEscolhidas.add(CategoriasJogos.RPG);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 2:
							if (!categoriasEscolhidas.contains(CategoriasJogos.AVENTURA)) {
								categoriasEscolhidas.add(CategoriasJogos.AVENTURA);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 3:
							if (!categoriasEscolhidas.contains(CategoriasJogos.ACAO)) {
								categoriasEscolhidas.add(CategoriasJogos.ACAO);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 4:
							if (!categoriasEscolhidas.contains(CategoriasJogos.HORROR)) {
								categoriasEscolhidas.add(CategoriasJogos.HORROR);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 5:
							if (!categoriasEscolhidas.contains(CategoriasJogos.MUNDOABERTO)) {
								categoriasEscolhidas.add(CategoriasJogos.MUNDOABERTO);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 6:
							if (!categoriasEscolhidas.contains(CategoriasJogos.TIRO)) {
								categoriasEscolhidas.add(CategoriasJogos.TIRO);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 7:
							if (!categoriasEscolhidas.contains(CategoriasJogos.PRIMEIRAPESSOA)) {
								categoriasEscolhidas.add(CategoriasJogos.PRIMEIRAPESSOA);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 8:
							if (!categoriasEscolhidas.contains(CategoriasJogos.TERCEIRAPESSOA)) {
								categoriasEscolhidas.add(CategoriasJogos.TERCEIRAPESSOA);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 9:
							if (!categoriasEscolhidas.contains(CategoriasJogos.PUZZLE)) {
								categoriasEscolhidas.add(CategoriasJogos.PUZZLE);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 10:
							if (!categoriasEscolhidas.contains(CategoriasJogos.TURNO)) {
								categoriasEscolhidas.add(CategoriasJogos.TURNO);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 11:
							if (!categoriasEscolhidas.contains(CategoriasJogos.ESPORTE)) {
								categoriasEscolhidas.add(CategoriasJogos.ESPORTE);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 12:
							if (!categoriasEscolhidas.contains(CategoriasJogos.LUTA)) {
								categoriasEscolhidas.add(CategoriasJogos.LUTA);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 13:
							if (!categoriasEscolhidas.contains(CategoriasJogos.FANTASIA)) {
								categoriasEscolhidas.add(CategoriasJogos.FANTASIA);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 14:
							if (!categoriasEscolhidas.contains(CategoriasJogos.CONSTRUCAO)) {
								categoriasEscolhidas.add(CategoriasJogos.CONSTRUCAO);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 15:
							if (!categoriasEscolhidas.contains(CategoriasJogos.RITMO)) {
								categoriasEscolhidas.add(CategoriasJogos.RITMO);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						case 16:
							if (!categoriasEscolhidas.contains(CategoriasJogos.BATTLEROYALE)) {
								categoriasEscolhidas.add(CategoriasJogos.BATTLEROYALE);
							} else {
								System.out.println("💖 Categoria já escolhida.");
							}
							break;

						default:
							System.out.println("⚠️ Opção Inválida.");
						}
						System.out.println("");
						System.out.println("➕ Deseja adicionar mais categorias?");
						System.out.println("1 - ✅SIM");
						System.out.println("2 - ❌NÃO");
						int add3 = sc.nextInt();
						if (add3 == 2) {
							break;
						}
					}
					jogo.setCategoriasValidas(categoriasEscolhidas);
				case 5:
					System.out.println("➕ Digite os novos idiomas disponíveis do jogo que escolheu:");
					Idiomas.imprimeIdiomas();
					idiomasEscolhidos.clear();
					while (true) {
						Integer idiomaEscolhido = sc.nextInt();
						switch (idiomaEscolhido) {
						case 1:
							if (!idiomasEscolhidos.contains(Idiomas.INGLES)) {
								idiomasEscolhidos.add(Idiomas.INGLES);
							} else {
								System.out.println("💖 Idioma já escolhido.");
							}
							break;

						case 2:
							if (!idiomasEscolhidos.contains(Idiomas.ESPANHOL)) {
								idiomasEscolhidos.add(Idiomas.ESPANHOL);
							} else {
								System.out.println("💖 Idioma já escolhido.");
							}
							break;

						case 3:
							if (!idiomasEscolhidos.contains(Idiomas.ALEMAO)) {
								idiomasEscolhidos.add(Idiomas.ALEMAO);
							} else {
								System.out.println("💖 Idioma já escolhido.");
							}
							break;

						case 4:
							if (!idiomasEscolhidos.contains(Idiomas.FRANCES)) {
								idiomasEscolhidos.add(Idiomas.FRANCES);
							} else {
								System.out.println("💖 Idioma já escolhido.");
							}
							break;

						case 5:
							if (!idiomasEscolhidos.contains(Idiomas.RUSSO)) {
								idiomasEscolhidos.add(Idiomas.RUSSO);
							} else {
								System.out.println("💖 Idioma já escolhido.");
							}
							break;

						case 6:
							if (!idiomasEscolhidos.contains(Idiomas.CHINES)) {
								idiomasEscolhidos.add(Idiomas.CHINES);
							} else {
								System.out.println("💖 Idioma já escolhido.");
							}
							break;

						case 7:
							if (!idiomasEscolhidos.contains(Idiomas.PORTUGUES)) {
								idiomasEscolhidos.add(Idiomas.PORTUGUES);
							} else {
								System.out.println("💖 Idioma já escolhido.");
							}
							break;

						default:
							System.out.println("⚠️ Opção Inválida.");
						}
						System.out.println("");
						System.out.println("➕ Deseja adicionar mais idiomas?");
						System.out.println("1 - ✅SIM");
						System.out.println("2 - ❌NÃO");
						int add4 = sc.nextInt();
						if (add4 == 2) {
							break;
						}
					}
					jogo.setIdiomas(idiomasEscolhidos);
				case 6:
					System.out.println("➕ Digite as novas plataformas disponíveis do jogo que escolheu:");
					PlataformasDisponiveis.imprimePlataformas();
					plataformasEscolhidas.clear();
					while (true) {
						Integer plataformaEscolhida = sc.nextInt();
						switch (plataformaEscolhida) {
						case 1:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.XBOX)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.XBOX);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 2:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.XBOX1)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.XBOX1);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 3:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.PS4)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.PS4);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 4:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.PS5)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.PS5);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 5:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.NINTENDO)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.NINTENDO);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 6:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.WINDOWS)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.WINDOWS);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 7:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.MACOS)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.MACOS);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 8:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.IOS)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.IOS);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 9:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.LINUX)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.LINUX);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						case 10:
							if (!plataformasEscolhidas.contains(PlataformasDisponiveis.ANDROID)) {
								plataformasEscolhidas.add(PlataformasDisponiveis.ANDROID);
							} else {
								System.out.println("💖 Plataforma já escolhida.");
							}
							break;

						default:
							System.out.println("⚠️ Opção Inválida.");
						}
						System.out.println("");
						System.out.println("➕ Deseja adicionar mais plaformas?");
						System.out.println("1 - ✅SIM");
						System.out.println("2 - ❌NÃO");
						int add5 = sc.nextInt();
						if (add5 == 2) {
							break;
						}
					}
					jogo.setPlataformasValidas(plataformasEscolhidas);
				case 7:
					System.out.println("➕ Digite a nova classificação indicativa do jogo que escolheu:");
					ClassificacaoIndicativa.imprimeClassificacoes();
					while (true) {
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
							System.out.println("⚠️ Opção inválida, escolha novamente:");
						}
						if (classIndEscolhida >= 1 && classIndEscolhida <= 6) {
							break;
						}
					}

				case 8:
					System.out.println("➕ Digite a nova data de lançamento do jogo que escolheu:");
					String ldata = sc.nextLine();
					lancamento = LocalDate.parse(ldata, formato);
					jogo.setDataDeLancamento(lancamento);
				case 9:
					System.out.println("🔙 Voltar para minha conta.");
					continuarAlterar = false;
				default:
					System.out.println("Opção inválida. 🔙 Digite novamente.");
				}
			} catch (DadoInvalidoException e) {
				System.out.println("Erro: " + e.getMessage());
			}

			System.out.println("😄 Deseja alterar outro dado:");
			System.out.println("1️⃣  Sim");
			System.out.println("2️⃣  Não");
			System.out.print("👉 Escolha a opção: ");
			int refazer = Integer.parseInt(sc.nextLine());

			if (refazer == 2) {
				continuarAlterar = false;
			}
		}
	}

	// Listar todos os jogos da empresa por titulo
	public void ListJogosEmpresa(Empresa empresa) throws DadoDuplicadoException, DadoInvalidoException {
		try {
			List<Jogo> jogos = listJogos.procurarEmpresa(empresa);
			System.out.println("Jogos da empresa:");
			for (int i = 0; i < jogos.size(); i++) {
				System.out.println((i + 1) + ". " + jogos.get(i).getTitulo());
			}

		} catch (DadoNaoEncontradoException e) {
			System.out.println("Erro:" + e.getMessage());
			System.out.println("Nenhum jogo cadastrado pra essa empresa.");
		}
	}

	public void ListJogosComDesconto() {
		List<Jogo> jogos = listJogos.jogosComDesconto();

		for (Jogo jogo : jogos) {
			// chmar o mostrar dados basico do jogo
			System.out.println(jogo.getResumo());

		}
	}

	// modifiquei o arraylist para não entrar em conflito com o cadastro
	// esse arraylist é apenas para busca por categoria
	public void buscarJogoCtg(Scanner sc, RepositorioJogoArrayList listJogos) {
		ArrayList<CategoriasJogos> buscarCategorias = catgEscolhidas(sc);
		for (Jogo jogo : listJogos.procurarPorCategorias(buscarCategorias)) {
			System.out.println(jogo.getResumo());
		}

		// limpando o array depois que a busca é concluída, só por precaução
		buscarCategorias.clear();
	}

	public ArrayList<CategoriasJogos> catgEscolhidas(Scanner sc) {
		System.out.println("🏷️ Escolha as Categorias para o :");
		CategoriasJogos.imprimeCategorias();
		ArrayList<CategoriasJogos> categoriaEscolhida = new ArrayList<>();
		while (true) {
			Integer buscarCategoria = sc.nextInt();
			switch (buscarCategoria) {
			case 1:
				if (!categoriaEscolhida.contains(CategoriasJogos.RPG)) {
					categoriaEscolhida.add(CategoriasJogos.RPG);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 2:
				if (!categoriaEscolhida.contains(CategoriasJogos.AVENTURA)) {
					categoriaEscolhida.add(CategoriasJogos.AVENTURA);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 3:
				if (!categoriaEscolhida.contains(CategoriasJogos.ACAO)) {
					categoriaEscolhida.add(CategoriasJogos.ACAO);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 4:
				if (!categoriaEscolhida.contains(CategoriasJogos.HORROR)) {
					categoriaEscolhida.add(CategoriasJogos.HORROR);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 5:
				if (!categoriaEscolhida.contains(CategoriasJogos.MUNDOABERTO)) {
					categoriaEscolhida.add(CategoriasJogos.MUNDOABERTO);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 6:
				if (!categoriaEscolhida.contains(CategoriasJogos.TIRO)) {
					categoriaEscolhida.add(CategoriasJogos.TIRO);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 7:
				if (!categoriaEscolhida.contains(CategoriasJogos.PRIMEIRAPESSOA)) {
					categoriaEscolhida.add(CategoriasJogos.PRIMEIRAPESSOA);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 8:
				if (!categoriaEscolhida.contains(CategoriasJogos.TERCEIRAPESSOA)) {
					categoriaEscolhida.add(CategoriasJogos.TERCEIRAPESSOA);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 9:
				if (!categoriaEscolhida.contains(CategoriasJogos.PUZZLE)) {
					categoriaEscolhida.add(CategoriasJogos.PUZZLE);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 10:
				if (!categoriaEscolhida.contains(CategoriasJogos.TURNO)) {
					categoriaEscolhida.add(CategoriasJogos.TURNO);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 11:
				if (!categoriaEscolhida.contains(CategoriasJogos.ESPORTE)) {
					categoriaEscolhida.add(CategoriasJogos.ESPORTE);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 12:
				if (!categoriaEscolhida.contains(CategoriasJogos.LUTA)) {
					categoriaEscolhida.add(CategoriasJogos.LUTA);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 13:
				if (!categoriaEscolhida.contains(CategoriasJogos.FANTASIA)) {
					categoriaEscolhida.add(CategoriasJogos.FANTASIA);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 14:
				if (!categoriaEscolhida.contains(CategoriasJogos.CONSTRUCAO)) {
					categoriaEscolhida.add(CategoriasJogos.CONSTRUCAO);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 15:
				if (!categoriaEscolhida.contains(CategoriasJogos.RITMO)) {
					categoriaEscolhida.add(CategoriasJogos.RITMO);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			case 16:
				if (!categoriaEscolhida.contains(CategoriasJogos.BATTLEROYALE)) {
					categoriaEscolhida.add(CategoriasJogos.BATTLEROYALE);
				} else {
					System.out.println("😄 Categoria já escolhida.");
				}
				break;

			default:
				System.out.println("⚠️ Opção Inválida.");
			}
			System.out.println("");
			System.out.println("➕ Deseja adicionar mais categorias?");

			System.out.println("1 - ✅SIM");
			System.out.println("2 - ❌NÃO");
			int add1 = sc.nextInt();
			if (add1 == 2) {
				break;
			}
		}
		return categoriaEscolhida;
	}

}
