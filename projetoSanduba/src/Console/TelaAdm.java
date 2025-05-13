package Console;

import java.util.Scanner;

import Pessoa.Adm;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;

import funcionalidades.ControleDeJogos;

public class TelaAdm {
	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	private Adm adm;
	private RepositorioUsuarioArrayList listUsuarios;
	private RepositorioJogoArrayList listJogos;
	private ControleDeJogos controleJogos;
	
	
	public TelaAdm(Scanner sc, VisualizacaoMenu visualizacaoMenu, Adm adm, RepositorioUsuarioArrayList listUsuarios, RepositorioJogoArrayList listJogos,  ControleDeJogos controleJogos) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
		this.adm = adm;
		this.listUsuarios = listUsuarios;
		this.listJogos = listJogos;
		this.controleJogos = controleJogos;
	}
	
	public void exibirMenuAdm() throws DadoInvalidoException, DadoNaoEncontradoException, DadoDuplicadoException {
		
		visualizacaoMenu.telaMenuMcAdm();
		int opcao = sc.nextInt();
		
////		[1] 🧑‍ Gerenciar Cliente");
//	    System.out.println("  [2] 🏦 Gerenciar Empresas");
//	    System.out.println("  [3] 🎮 Gerenciar Jogos");;
//	    System.out.println("  [4] ❌ Sair");;
//		
		do {
		
		switch(opcao) {
			case 1:
				visualizacaoMenu.telaAdmGerenciarCliente(adm);
				opcoesCase1();
				
				break;
			case 2:
				visualizacaoMenu.telaAdmGerenciarEmpresa(adm);
				opcoesCase2();
				
				break;
			case 3:
				visualizacaoMenu.telaAdmGerenciarJogo(adm);
				opcoesCase3();
				break;
			case 4:
				
				break;
			default:
				System.out.println("Opção invalida");
				opcao= sc.nextInt();
				
		}
		
		
	}while(opcao != 4);
		

	}
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
	
	public void opcoesCase1() throws DadoInvalidoException, DadoDuplicadoException {
		int opcao = sc.nextInt();
		do {
			
			switch(opcao) {
				case 1:
					adm.clientesCadastrados();
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
					Usuarios cliente =  listUsuarios.procurarNome(nome);
					if (cliente instanceof Cliente) { // Verifica se é um Cliente 
					    Cliente cliente2 = (Cliente) cliente;
					    System.out.println("Quer alterar que tipo de dado:");
					    System.out.println("[1]Dados pessoais.");
					    System.out.println("[2]Dasdos Financeiros.");
					    
					    do {
					    	opcao2 = sc.nextInt();
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
					
				case 6:
					System.out.println("Voltando ao munu...");
					//um pouco perdida se tem outra forma ou so volto pro menu mesmo
					exibirMenuAdm(); //tipo assim
				default:
					System.out.println("Opção invalida./nInsira um opção válida:");
					opcao= sc.nextInt();
			}
		}while(opcao != 5);
					
	}
	
////	 [System.out.println("  [1] 🏦 Ver lista de Empresa cadatrados.");
//	System.out.println("  [2] 🏦 Informações detalhadas. ");
//	System.out.println("  [3] 🏦 Aterar dados de uma Empresa");
//	System.out.println("  [4] 🏦 Remover uma conta.");
//	System.out.println("  [5] 🏦 Buscar uma Empresa.");
//	System.out.println("  [6] 🔙 Voltar para o menu. ");
	public void opcoesCase2() throws DadoInvalidoException, DadoDuplicadoException {
		int opcao = sc.nextInt();
		do {
			
			switch(opcao) {
				case 1:
					adm.empresasCadastradas();
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
					exibirMenuAdm(); //tipo assim
				default:
					System.out.println("Opção invalida./nInsira um opção válida:");
					opcao= sc.nextInt();
			}
			}while(opcao != 6);
					
	}
////	System.out.println("  [1] 🎮 Lista de Jogos Cadatrados.");
//	System.out.println("  [2] 🎮 Cadastrar novo Jogo.");
//	System.out.println("  [3] 🎮 Alterar dados de um jogo.");
//	System.out.println("  [4] 🎮 Deletar jogo.");
//	System.out.println("  [5] 🎮 Informações detalhada de um jogos.");
//	
//	System.out.println("  [6] 📊 Resumo de vendas");
//	
//	System.out.println("  [7 ] 🔙 Voltar para o menu. ");

	public void opcoesCase3() throws DadoInvalidoException, DadoDuplicadoException {
		int opcao = sc.nextInt();
		do {
			
			switch(opcao) {
			case 1:
				adm.jogoPorEmpresa();
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
//				ver diretinho
				break;
			case 6:
				//ver como funciona o resumo de vendas
				break;
			case 7:
				System.out.println("Voltando ao munu...");
				//um pouco perdida se tem outra forma ou so volto pro menu mesmo
				exibirMenuAdm(); //tipo assim
			default:
				System.out.println("Opção invalida./nInsira um opção válida:");
				opcao= sc.nextInt();
	}
		}while(opcao != 7);
	}
	
}
