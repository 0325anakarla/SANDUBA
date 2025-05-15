package Console;

import java.util.List;
//import java.util.ArrayList;
import java.util.Scanner;

import Pessoa.Adm;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.ControleDeJogos;
import jogo.CategoriasJogos;
//import jogo.CategoriasJogos;
import jogo.Jogo;

public class OrganicaoTelaAdm {
	
//	adm.jogoPorEmpresa();
//	adm.empresasCadastradas();
//	adm.clientesCadastrados();
//	
////	 [System.out.println("  [1] 👤 Ver lista de Clientes cadatrados.");
//	System.out.println("  [2] 👤 Informações detalhadas. ");
//	System.out.println("  [3] 👤 Aterar dados de um Clientes");
//	System.out.println("  [4] 👤 Remover uma conta.");
//	System.out.println("  [5] 👤 Buscar um Cliente.");
//	System.out.println("  [6] 🔙 Voltar para o menu. ");
	//private TelaAdm telaAdm;
	public OrganicaoTelaAdm() {
		
	}
	public void opcoesCase1(Scanner sc,Adm adm,RepositorioUsuarioArrayList listUsuarios,VisualizacaoMenu visualizacaoMenu) throws DadoInvalidoException, DadoDuplicadoException {
		int case1;
		sc.nextLine();
		do {
			visualizacaoMenu.telaAdmGerenciarCliente(adm);
			case1 = sc.nextInt();
			switch(case1) {
				case 1:
					adm.clientesCadastrados(listUsuarios);
					sc.nextLine();
					break;
				case 2:
					System.out.println("Deseja obter informaões de um cliente em especifio ou de todos?");
					System.out.println("[1] Um em especifico.");
					System.out.println("[2]Todos");
					int opcao2 =sc.nextInt();
					if(opcao2 ==1) {
						System.out.println("Insira o nome do Cliente que deseja obter informações detalhadas");
						String nome = sc.nextLine();
						Usuarios cliente =  listUsuarios.procurarNome(nome);
						if (cliente instanceof Cliente) { // Verifica se é um Cliente
						    Cliente cliente2 = (Cliente) cliente;
						    cliente2.mostrarDetalhesUsuario();
						} else {
						    System.out.println("Usuário encontrado não é um Cliente.");
						}

					}else if(opcao2 ==2) {
						adm.informacoesTodosClientes();
					}
					
					
					break;
				case 3:
					System.out.println("Insira o nome do Cliente que deseja alterar dados:");
					String nome = sc.nextLine();
					Usuarios cliente1 =  listUsuarios.procurarNome(nome);
					if (cliente1 instanceof Cliente) { // Verifica se é um Cliente 
					    Cliente cliente2 = (Cliente) cliente1;
					    System.out.println("Quer alterar que tipo de dado:");
					    System.out.println("[1]Dados pessoais.");
					    System.out.println("[2]Dasdos Financeiros.");
					    
					    do {
					    	opcao2 = sc.nextInt();
					    	sc.nextLine();
					    	switch(opcao2) {
							case 1:
								listUsuarios.alterarDados(cliente2);
								break;
							case 2: 
								//chmar alterar dados financeiros
								break;
							default:
								System.out.println("Opção invalida./nInsira um opção válida:");
					    }
					    	
					    }while(opcao2!=1 && opcao2!=2);
					    
					} else {
					    System.out.println("Usuário encontrado não é um Cliente.");
					}
					
					break;
				case 4:
					System.out.println("Insira o nome do Cliente que deseja remover");
					String nome1 = sc.nextLine();
					listUsuarios.deletar(listUsuarios.procurarNome(nome1));
					break;
				case 5:
					System.out.println("Insira o nome do Cliente que deseja buscar:");
					String nome11 = sc.nextLine();
					Usuarios cliente11 =  listUsuarios.procurarNome(nome11);
					if (cliente11 instanceof Cliente) { // Verifica se é um Cliente
					    Cliente cliente2 = (Cliente) cliente11;
					    cliente2.mostrarDetalhesUsuario();
					    
					} else {
					    System.out.println("Usuário encontrado não é um Cliente.");
					}
				case 6:
					System.out.println("Voltando ao munu...");
					//um pouco perdida se tem outra forma ou so volto pro menu mesmo
					System.out.println("Vltando ao menu..."); //tipo assim
					break;
				default:
					System.out.println("Opção invalida./nInsira um opção válida:");
					case1= sc.nextInt();
					
			}
		}while(case1!=6 );
					
	}
	
////	 [System.out.println("  [1] 🏦 Ver lista de Empresa cadatrados.");
//	System.out.println("  [2] 🏦 Informações detalhadas. ");
//	System.out.println("  [3] 🏦 Aterar dados de uma Empresa");
//	System.out.println("  [4] 🏦 Remover uma conta.");
//	System.out.println("  [5] 🏦 Buscar uma Empresa.");
//	System.out.println("  [6] 🔙 Voltar para o menu. ");
	public void opcoesCase2(Scanner sc , Adm adm,RepositorioUsuarioArrayList listUsuarios, VisualizacaoMenu visualizacaoMenu) throws DadoInvalidoException, DadoDuplicadoException {
		 
		int case2 ;
		sc.nextLine();
		do {
			
			visualizacaoMenu.telaAdmGerenciarEmpresa(adm);
			case2 = sc.nextInt();
			switch(case2) {
				case 1:
					adm.empresasCadastradas(listUsuarios);
					break;
				case 2:
					System.out.println("Deseja obter informaões de uma Empresa em especifio ou de todos?");
					System.out.println("[1] Um em especifico.");
					System.out.println("[2]Todos");
					int opcao2 =sc.nextInt();
					if(opcao2 ==1) {
						System.out.println("Insira o nome  da Empresa que deseja obter informações detalhadas");
						//String nome = sc.nextLine();
						//falta completar isso de alterar o cliente pelo nome 
					}else if(opcao2 ==2) {
						adm.informacoesTodasEmpresas();
					}
					
					break;
				case 3:
					System.out.println("Insira o nome da Empresa que deseja alterar dados:");
					String nome = sc.nextLine();
					Usuarios empresa =  listUsuarios.procurarNome(nome);
					if (empresa instanceof Empresa) { // Verifica se é um empresa 
						Empresa empresa2 = (Empresa) empresa;
					    System.out.println("Quer alterar que tipo de dado:");
					    System.out.println("[1]Dados pessoais.");
					    System.out.println("[2]Dasdos Financeiros.");
					    int opcao3 = sc.nextInt();
					    do {
					    	
					    	switch(opcao3) {
							case 1:
								listUsuarios.alterarDados(empresa2);
								break;
							case 2: 
								//chmar alterar dados financeiros
								break;
							default:
								System.out.println("Opção invalida./nInsira um opção válida:");
					    }
					    	
					    }while(opcao3!=1 && opcao3!=2);
					    
					} else {
					    System.out.println("Usuário encontrado não é uma Empresa.");
					}
					
					break;
				case 4:
					System.out.println("Insira o nome da Empresa que deseja remover");
					String nome1 = sc.nextLine();
					listUsuarios.deletar(listUsuarios.procurarNome(nome1));
					break;
				case 5:
					//ver se nescessario
					
					break;
				case 6:
					System.out.println("Voltando ao munu...");
					//um pouco perdida se tem outra forma ou so volto pro menu mesmo
//					telaAdm.exibirMenuAdm(); //tipo assim
				default:
					System.out.println("Opção invalida./nInsira um opção válida:");
					case2= sc.nextInt();
					 
			}
			}while(case2!=6);
					
	}

	public void opcoesCase3(Scanner sc, Adm adm,RepositorioUsuarioArrayList listUsuarios, VisualizacaoMenu visualizacaoMenu, RepositorioJogoArrayList listJogos,ControleDeJogos controleJogos ) throws DadoInvalidoException, DadoDuplicadoException {
		
		int case3; 
		sc.nextLine();
		do {
			visualizacaoMenu.telaAdmGerenciarJogo(adm);
			case3 = sc.nextInt();
			switch(case3) {
			case 1:
				adm.jogoPorEmpresa(listUsuarios, listJogos);
				break;
			case 2: 
				System.out.println("Insira o nome  da Empresa que deseja cadastrar seu jogo:");
				String nome = sc.nextLine();
				Usuarios empresa =  listUsuarios.procurarNome(nome);
				if (empresa instanceof Empresa) { // Verifica se é um empresa 
					Empresa empresa2 = (Empresa) empresa;
					controleJogos.CadastrarJogos(empresa2);
				} else {
				    System.out.println("Usuário encontrado não é uma Empresa.");
				}
				
					
				break;
			case 3:
				System.out.println("Insira o título Jogo que deseja alterar dados:");
				String titulo = sc.nextLine();
				controleJogos.alterarDadosDosJogos(listJogos.procurarNome(titulo));
				break;
			case 4:
				System.out.println("Insira o nome  da Empresa que deseja cadastrar seu jogo:");
				String nome1 = sc.nextLine();
				Usuarios empresa1 =  listUsuarios.procurarNome(nome1);
				if (empresa1 instanceof Empresa) { // Verifica se é um empresa 
					Empresa empresa2 = (Empresa) empresa1;
					controleJogos.deletarJogo(empresa2);
				} else {
				    System.out.println("Usuário encontrado não é uma Empresa.");
				}
				break;
			case 5:
				System.out.println("Deseja obter informaões de um Jogo em especifio ou de todos?");
				System.out.println("[1] Um em especifico.");
				System.out.println("[2] Todos");
				int opcao2 =sc.nextInt();
				if(opcao2 ==1) {
					System.out.println("Insira o título do jogo que deseja obter informações detalhadas");
					Jogo jogo1 = listJogos.procurarNome(sc.nextLine());
					jogo1.mostrarDados();
				}else if(opcao2 ==2) {
					adm.infoTodosJogos();
				}
				break;
			case 6:
				System.out.println(adm.getNome()+" você quer aplicar desconto por:");
				System.out.println("[1] ano de lançamento");
				System.out.println("[2] categoria");
				
				int opcao21 =sc.nextInt();
				
				if(opcao21 ==1) {
				System.out.println("Insira o ano de referência: todos os jogos lançados até esse ano sofrerão desconto. (ex:2010) ");
				int ano =sc.nextInt();
				System.out.println("Insira o desconto que será aplicado: (ex:20)");
				double desconto = sc.nextDouble();
				adm.descontoPorAno(ano, desconto);
				}else if(opcao21 ==2) {
					List<CategoriasJogos> categorias = controleJogos.catgEscolhidas(sc);
					System.out.println("Desconto que será aplicado é tempo limitado(dias ou mes)");
					System.out.println("Insira o tempo que sera.  ");
					System.out.println("[1] por dias ");
					System.out.println("[2] por mês.");
					int tipo =sc.nextInt();
					
					System.out.println("Insira o tempo que será aplicado: (ex:20)");
					int tempo = sc.nextInt();
					
					System.out.println("Insira o desconto que será aplicado '%' : (ex:20)");
					double desconto = sc.nextDouble();
					adm.descontoPorTempoLimt( tipo,  tempo,  desconto, categorias  );
					
				}
				
				break;
			case 7: 
				controleJogos.buscarJogoCtg(sc, listJogos);
				break; 
			case 8:
				visualizacaoMenu.telaResumoVendEmpresa();
				adm.resumoVendaJogos(listUsuarios);
				break;
			case 9:
				System.out.println("Voltando ao munu...");
				//um pouco perdida se tem outra forma ou so volto pro menu mesmo
//				exibirMenuAdm(); //tipo assim
				break;
			default:
				System.out.println("Opção invalida./nInsira um opção válida:");
				case3= sc.nextInt();
				 
	}
		}while(case3 != 9);
	}

	
	
	
	



}
