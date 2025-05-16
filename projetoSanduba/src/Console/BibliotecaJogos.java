package Console;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Pessoa.Cliente;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import funcionalidades.ControleDeJogos;
//import TratamentoDeErro.FormatoDoNumeroException;
import jogo.Jogo;

public class BibliotecaJogos {
	private Scanner sc;
	private CarrinhoDeCompras carrinho;
	private RepositorioJogoArrayList listJogos;
	private TelaCliente telaCliente;
	private TelaCarrinhoDeCompras mostrarCarrinho;
	private Menu menu;
	private ControleDeJogos controleDeJogos;
	RepositorioJogoArrayList jogosClasf = new RepositorioJogoArrayList();
	
	public BibliotecaJogos(Scanner sc,  CarrinhoDeCompras carrinho, RepositorioJogoArrayList listJogos, TelaCliente telaCliente, ControleDeJogos controleDeJogos) {
		this.sc = sc;
		this.listJogos = listJogos;
		this.telaCliente = telaCliente;
		this.carrinho = carrinho;
		this.controleDeJogos= controleDeJogos;
	}
	
	public void setMostrarCarrinho(TelaCarrinhoDeCompras mostrarCarrinho) {
		this.mostrarCarrinho = mostrarCarrinho;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	public void Biblioteca(Cliente cliente) throws DadoInvalidoException {
		int opcao = 0;
		for(Jogo jogo : listJogos.getTodos()) {
	    	LocalDate dataAtual = LocalDate.now();
	    	Period periodo = Period.between(cliente.getNatalicio(), dataAtual);
	        int idade = periodo.getYears();
	    	if (idade>= jogo.classInd()) {
	    		System.out.println(jogo.getResumo());
	    		jogosClasf.add(jogo);
	    	}
	    }
		
		do {
			System.out.println("\n╔════════════════════════════════════════════╗");
		    System.out.println("║          🎮 JOGOS DISPONÍVEIS NA LOJA      ║");
		    System.out.println("╚════════════════════════════════════════════╝\n");
		    
		    System.out.println(jogosClasf.resumoJogos());
		    
		    
		    System.out.println("\n════════════════════════════════════════════");
		    
		    System.out.println("| Escolha uma opção |\n");
		    System.out.println("  [1] 🔍 Procurar um jogo");
		    System.out.println("  [2] 🛒 Ver carrinho de compras");
		    System.out.println("  [3] 👤 Ir para minha conta");
		    System.out.println("  [4] ❌ Sair");
		    System.out.print("\n📝 Digite a opção desejada: ");
		    
		    boolean opcaoValida = false;
		    while(!opcaoValida) {
			    try {
			    	opcao = Integer.parseInt(sc.nextLine());
			    	opcaoValida = true;
			    }catch(NumberFormatException  e) {
			    	System.out.println("❌ Erro: " + e.getMessage());
			    	System.out.print("\nTenta de novo: ");
			    }
			 }
			    switch(opcao) {
			    	case 1: 
			    		boolean opcaoValida1 = false;
			    		
			    		System.out.println("🔍 Deseja buscar jogo por: ");
			    		System.out.println("[1]Nome");
			    		System.out.println("[2]Categoria:");
			    		int buscar = Integer.parseInt(sc.nextLine());
			    		while(!opcaoValida1) {
<<<<<<< HEAD
			    			System.out.println("------------------------------------------------\n");
=======

			    		 	if(buscar==1) {
			    			
>>>>>>> bad99703c644e09ba7a90513304441156b1e7fe1
				    		System.out.print("\n📝 Digite o nome do jogo: ");
				    		try{
				    			Jogo resultado = jogosClasf.procurarNome(sc.nextLine());
				    			resultado.mostrarDados();
				    			opcoesDeCompra(resultado, cliente);
				    			opcaoValida1 = true;
				    		}catch(DadoNaoEncontradoException e) {
				    			System.out.println("❌ Erro: " + e.getMessage());
				    			System.out.println("\n| Digite novamente o jogo que procura: |");
				    		}
			    		}else if(buscar==2) {
			    			 controleDeJogos.buscarJogoCtg( sc,  jogosClasf);
			    			 opcaoValida1 = true;
			    			 break;
			    			 
			    		 }
			    		}
			    	
			    		
			    		break;
			    	case 2:
			    		mostrarCarrinho.CarrinhoDeCompras(cliente, carrinho);
			    		break;
			    	case 3:
			    		telaCliente.telaMinhaContaCliente(cliente);
			    		break;
			    	case 4:
			    		break;
			    	default:
			    		System.out.println("⚠️ Opção inválida.");
						break;
			    }
		    
		    switch(opcao) {
		    	case 1: 
		    		System.out.print("\n📝 Digite o nome do jogo: ");
		    		try{
		    			Jogo resultado = jogosClasf.procurarNome(sc.nextLine());
		    			resultado.mostrarDados();
		    			opcoesDeCompra(resultado, cliente);
		    		}catch(DadoNaoEncontradoException e) {
		    			System.out.println("❌ Erro: " + e.getMessage());
		    			System.out.println("📝 Digite novamente o jogo que procura.");
		    		}
		    		break;
		    	case 2:
		    		mostrarCarrinho.CarrinhoDeCompras(cliente, carrinho);
		    		break;
		    	case 3:
		    		telaCliente.telaMinhaContaCliente(cliente);
		    	case 4:
		    		System.out.println("==========================================================");
		    		System.out.println("\n| Realmente deseja sair da sua conta? |");
					System.out.println("  [1] Sim!!");
					System.out.println("  [2] Não.");
					opcaoValida = false;
				    while(!opcaoValida) {
					    try {
					    	int subSubOpcao = Integer.parseInt(sc.nextLine());
					    	opcaoValida = true;
					    	if(subSubOpcao == 1) {
					    		menu.start();
					    		break;
					    	}
					    }catch(NumberFormatException  e) {
					    	System.out.println("❌ Erro: " + e.getMessage());
					    	System.out.print("\n📝 Digite um número válido: ");
					    }
					 }
		    		break;
		    	default:
		    		System.out.println("⚠️ Opção inválida.");
					break;
		    }

	    }while(opcao != 4);
	}
	
	public void opcoesDeCompra(Jogo jogo, Cliente cliente) throws DadoInvalidoException {
		int opcao = 0;
		
		do {
			System.out.println("\n╔════════════════════════════════════════╗");
			System.out.println("║       🛍️ OPÇÕES DE COMPRA / AÇÕES      ║");
			System.out.println("╚════════════════════════════════════════╝");
			System.out.println("Escolha uma opção:");
			System.out.println("  [1] 💖 Adicionar à lista de desejos");
			System.out.println("  [2] 🛒 Adicionar ao carrinho");
			System.out.println("  [3] ❌ Sair");
			System.out.print("\nDigite a opção desejada: ");
			
			boolean opcaoValida = false;
		    while(!opcaoValida) {
			    try {
			    	opcao = Integer.parseInt(sc.nextLine());
			    	opcaoValida = true;
			    }catch(NumberFormatException  e) {
			    	System.out.println("❌ Erro: " + e.getMessage());
			    	System.out.print("\n📝 Digite um número válido: ");
			    }
			 }
			
			switch(opcao) {
				case 1:
					try {
						cliente.addListaDeDesejo(jogo);
						System.out.println("💖 O jogo "+jogo.getTitulo()+" foi adicionado a lista de desejos com sucesso.");
					} catch(DadoDuplicadoException e) {
						System.out.println("❌ Erro: " + e.getMessage());
					} catch(DadoInvalidoException e) {
						System.out.println("❌ Erro: " + e.getMessage());
					}
					break;
				case 2:
					carrinho.adiciona(jogo);
					System.out.println("🛒 O jogo "+jogo.getTitulo()+"  foi adicionado com sucesso ao carrinho.");
					System.out.println("Escolha uma opção:");
					System.out.println("  [1] 🔙 Voltar para a biblioteca");
					System.out.println("  [2] ✅ Finalizar compra");
					System.out.print("\n📝 1Digite a opção desejada: ");
					int subOpcao =0;
					
					opcaoValida = false;
				    while(!opcaoValida) {
					    try {
					    	subOpcao = Integer.parseInt(sc.nextLine());
					    	opcaoValida = true;
					    	switch(subOpcao) {
							case 1:
								Biblioteca(cliente);
								break;
							case 2:
								mostrarCarrinho.CarrinhoDeCompras(cliente, carrinho);
								break;
							default:
								System.out.println("⚠️ Opção inválida.");
								System.out.println("\n| Digite apenas um dos números acima. |");
								break;
						}
					    }catch(NumberFormatException  e) {
					    	System.out.println("❌ Erro: " + e.getMessage());
					    	System.out.print("\n| Digite um número válido: |");
					    }
					 }
				break;
				case 3:
					Biblioteca(cliente);
					break;
				default:
					System.out.println("⚠️ Opção inválida.");
					break;
			}
		}while(opcao != 3);
	}
}
