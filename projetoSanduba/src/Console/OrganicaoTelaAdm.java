package Console;

import java.util.List;
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
import TratamentoDeErro.FormatoDoNumeroException;
import funcionalidades.ControleDeJogos;
import funcionalidades.Gambiarras;
import jogo.CategoriasJogos;
import jogo.Jogo;

public class OrganicaoTelaAdm {

	public OrganicaoTelaAdm() {
		/* DÁ DOIS ENTERS AO PASSAR AS INFORMAÇÕES PELA TELA DE ADM*/
	}
	
	public void opcoesCase1(Scanner sc,Adm adm,RepositorioUsuarioArrayList listUsuarios,VisualizacaoMenu visualizacaoMenu) throws DadoInvalidoException, DadoDuplicadoException {
		int case1 = -1;
		
		do {
			
			try {
			visualizacaoMenu.telaAdmGerenciarCliente(adm);
			case1 = sc.nextInt();
			
			switch(case1) {
				case 1:
					sc.nextLine();
					adm.clientesCadastrados(listUsuarios);
					sc.nextLine();
					break;
				case 2:
					sc.nextLine();
					System.out.println("Deseja obter informaões de um cliente em especifio ou de todos?");
					System.out.println("[1] Um em especifico.");
					System.out.println("[2] Todos");
					int opcao2 =sc.nextInt();
					if(opcao2 ==1) {
						sc.nextLine();
						System.out.println("> Insira o nome do Cliente que deseja obter informações detalhadas <");
						String nome = sc.nextLine();
						Usuarios cliente =  listUsuarios.procurarNome(nome);
						if (cliente instanceof Cliente) {
						    Cliente cliente2 = (Cliente) cliente;
						    System.out.println(cliente2.mostrarDetalhesUsuario());
						    
						} else {
						    Gambiarras.textoLento(">Usuário encontrado não é um Cliente.",60);
						}

					}else if(opcao2 ==2) {
						adm.informacoesTodosClientes(listUsuarios);
					}
					break;
				case 3:
					sc.nextLine();
					System.out.println("> Insira o nome do Cliente que deseja alterar dados:");
					String nome = sc.nextLine();
					Usuarios cliente1 =  listUsuarios.procurarNome(nome);
					if (cliente1 instanceof Cliente) {
					    Cliente cliente2 = (Cliente) cliente1;
					  
					    listUsuarios.alterarDados(cliente2);		
					    
					} else {
					    System.out.println("> Usuário encontrado não é um Cliente.");
					}
					
					break;
				case 4:
					sc.nextLine();
					System.out.println("> Insira o nome do Cliente que deseja remover");
					String nome1 = sc.nextLine();
					listUsuarios.deletar(listUsuarios.procurarNome(nome1));
					break;
				case 5:
					sc.nextLine();
					System.out.println("> Insira o nome do Cliente que deseja buscar:");
					String nome11 = sc.nextLine();
					Usuarios cliente11 =  listUsuarios.procurarNome(nome11);
					if (cliente11 instanceof Cliente) {
					    Cliente cliente2 = (Cliente) cliente11;
					    System.out.println(cliente2.mostrarDetalhesUsuario());
					    
					} else {
					    Gambiarras.textoLento("Usuário encontrado não é um Cliente.", 60);
					}
					break;
				case 6:
					Gambiarras.textoLento("> Voltando ao munu...", 70);
					System.out.println("> Voltando ao menu...");
					break;
				default:
					sc.nextLine();
					System.out.println("Opção invalida./nInsira um opção válida:");
					case1= sc.nextInt();	
			}
			}
			catch(DadoDuplicadoException e) {
				System.out.println("⚠️  Dado duplicado.");
			}
			catch(DadoInvalidoException e) {
				System.out.println("⚠️  Formato inválido.");
			}
			catch(DadoNaoEncontradoException e) {
				System.out.println("⚠️  Dado não encontrado.");
			}
			catch(FormatoDoNumeroException e) {
				System.out.println("⚠️  Formato de número inválido.");
			}
			
		}while(case1!=6 );
					
	}
	
	public void opcoesCase2(Scanner sc , Adm adm,RepositorioUsuarioArrayList listUsuarios, VisualizacaoMenu visualizacaoMenu) throws DadoInvalidoException, DadoDuplicadoException {
		 
		int case2 =-1;
		sc.nextLine();
		do {
			try {
			visualizacaoMenu.telaAdmGerenciarEmpresa(adm);
			case2 = sc.nextInt();

			switch(case2) {
				case 1:
					sc.nextLine();
					adm.empresasCadastradas(listUsuarios);
					break;
				case 2:
					sc.nextLine();
					System.out.println("Deseja obter informaões de uma Empresa em especifio ou de todos?");
					System.out.println("[1] Um em especifico.");
					System.out.println("[2]Todos");
					int opcao2 =sc.nextInt();
					boolean deuCerto= true;
					do {
					if(opcao2 ==1) {
						sc.nextLine();
						System.out.println("Insira o nome  da Empresa que deseja obter informações detalhadas");
						String nome = sc.nextLine();
						Usuarios empresa =  listUsuarios.procurarNome(nome);
						if (empresa instanceof Empresa) {
							Empresa empresa2 = (Empresa) empresa;
							System.out.println(empresa2.mostrarDetalhesUsuario()); 
							sc.nextLine();
						} else {
						    Gambiarras.textoLento(">Usuário encontrado não é uma Empresa.",60);
						}
						 
					}else if(opcao2 ==2) {
						adm.informacoesTodasEmpresas(listUsuarios);
						sc.nextLine();
					}else {
						System.out.println("invalido");
						deuCerto=false;
					}
					}while(!deuCerto);
					
					break;
				case 3:
					sc.nextLine();
					System.out.println("> Insira o nome da Empresa que deseja alterar dados:");
					String nome = sc.nextLine();
					Usuarios empresa =  listUsuarios.procurarNome(nome);
					if (empresa instanceof Empresa) {
						Empresa empresa2 = (Empresa) empresa;
					    
						listUsuarios.alterarDados(empresa2);
					} else {
						Gambiarras.textoLento(">Usuário encontrado não é uma Empresa.",60);
					}
					break;
				case 4:
					sc.nextLine();
					System.out.println("> Insira o nome da Empresa que deseja remover");
					String nome1 = sc.nextLine();
					listUsuarios.deletar(listUsuarios.procurarNome(nome1));
					break;
				case 5:
					sc.nextLine();
					System.out.println("> Insira o nome da Empresa que deseja buscar:");
					String nome2 = sc.nextLine();
					Usuarios empresa22 =  listUsuarios.procurarNome(nome2);
					if (empresa22 instanceof Empresa) {
					    Empresa empresa2 = (Empresa) empresa22;
					    System.out.println(empresa2.mostrarDetalhesUsuario()); 
					} else {
					    Gambiarras.textoLento("Usuário encontrado não é um Empresa.", 60);
					}
					break;
				case 6:
					Gambiarras.textoLento("> Voltando ao munu...",60);
					System.out.println("> Voltando ao menu...");
					break;
				default:
					Gambiarras.textoLento("> Opção invalida.\nInsira um opção válida:",60);
					case2= sc.nextInt(); 
			}
			}
			catch(DadoDuplicadoException e) {
				System.out.println("⚠️  Dado duplicado.");
			}
			catch(DadoInvalidoException e) {
				System.out.println("⚠️  Formato inválido.");
			}
			catch(DadoNaoEncontradoException e) {
				System.out.println("⚠️  Dado não encontrado.");
			}
			catch(FormatoDoNumeroException e) {
				System.out.println("⚠️  Formato de número inválido.");
			}
			
			}while(case2!=6);
					
	}

	public void opcoesCase3(Scanner sc, Adm adm,RepositorioUsuarioArrayList listUsuarios, VisualizacaoMenu visualizacaoMenu, RepositorioJogoArrayList listJogos,ControleDeJogos controleJogos ) throws DadoInvalidoException, DadoDuplicadoException {
		
		int case3=-1; 
		sc.nextLine();
		do {
			try {
			visualizacaoMenu.telaAdmGerenciarJogo(adm);
			case3 = sc.nextInt();
			sc.nextLine();
			switch(case3) {
			case 1:
				adm.jogoPorEmpresa(listUsuarios, listJogos);
				sc.nextLine();
				break;
			case 2: 
				System.out.println("Insira o nome  da Empresa que deseja cadastrar seu jogo:");
				String nome = sc.nextLine();
				Usuarios empresa =  listUsuarios.procurarNome(nome);
				if (empresa instanceof Empresa) {
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
				System.out.println("Insira o nome  da Jogo que deseja remover:");
				String nomeJogo = sc.nextLine();
				Jogo resultado = listJogos.procurarNome(nomeJogo);
				listJogos.deletar(resultado);
				resultado.getEmpresa().deletarJogo(resultado);		
				System.out.println("\\ Jogo "+nomeJogo+ " removido com sucesso //");
				break;
			case 5:
				System.out.println("Deseja obter informaões de um Jogo em especifio ou de todos?");
				System.out.println("[1] Um em especifico.");
				System.out.println("[2] Todos");
				int opcao2 =sc.nextInt();
				sc.nextLine();
				boolean deuErrado = false;
				do {
				if(opcao2 ==1) {
					System.out.println("Insira o título do jogo que deseja obter informações detalhadas");
					Jogo jogo1 = listJogos.procurarNome(sc.nextLine());
					jogo1.mostrarDados();
				}else if(opcao2 ==2) {
					adm.infoTodosJogos(listUsuarios, listJogos);
				}else {
					System.out.println("\nINVALIDO!\n insira correto:");
					opcao2 =sc.nextInt();
				}
				}while(deuErrado);
				break;
			case 6:
				System.out.println(adm.getNome()+"> Você quer aplicar desconto por:");
				System.out.println("[1] Ano de lançamento");
				System.out.println("[2] Categoria");
				
				int opcao21 =sc.nextInt();
				
				if(opcao21 ==1) {
				System.out.println("> Insira o ano de referência: todos os jogos lançados até esse ano sofrerão desconto. (ex:2010) ");
				int ano =sc.nextInt();
				System.out.println("> Insira o desconto que será aplicado: (ex:20)");
				double desconto = sc.nextDouble();
				adm.descontoPorAno(ano, desconto, listUsuarios, listJogos);
				
				}else if(opcao21 ==2) {
					List<CategoriasJogos> categorias = controleJogos.catgEscolhidas(sc);
					System.out.println("Desconto que será aplicado é tempo limitado - (Dia ou Mês)");
					System.out.println("-----------------------------------------------------------------------------------------");
					System.out.println("Insira o tempo que sera.  ");
					System.out.println("[1] Por dias ");
					System.out.println("[2] Por mês.");
					int tipo =sc.nextInt();
					
					System.out.println("> Insira o tempo que será aplicado - (ex:20): ");
					int tempo = sc.nextInt();
					
					System.out.println(": Insira o desconto que será aplicado '%' - (ex:20): ");
					double desconto = sc.nextDouble();
					//adm.descontoPorTempoLimt( tipo,  tempo,  desconto, categorias  );
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
				Gambiarras.textoLento("Voltando ao munu Adm...",70);
				System.out.println("> Voltando ao munu Adm...");
				break;
			default:
				System.out.println("> Opção invalida./nInsira um opção válida:");
				case3= sc.nextInt(); 
	}
		}
		catch(DadoDuplicadoException e) {
			System.out.println("⚠️  Dado duplicado.");
		}
		catch(DadoInvalidoException e) {
			System.out.println("⚠️  Formato inválido.");
		}
		catch(DadoNaoEncontradoException e) {
			System.out.println("⚠️  Dado não encontrado.");
		}
		catch(FormatoDoNumeroException e) {
			System.out.println("⚠️  Formato de número inválido.");
		}
		}while(case3 != 9);
	}
}
