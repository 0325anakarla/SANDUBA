package Console;

import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Pessoa.Cliente;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import TratamentoDeErro.FormatoDoNumeroException;
import jogo.Jogo;

public class BibliotecaJogos {
	private Scanner sc;
	private CarrinhoDeCompras carrinho;
	private RepositorioJogoArrayList listJogos;
	private TelaCliente telaCliente;
	private TelaCarrinhoDeCompras mostrarCarrinho;
	private Menu menu;
	
	public BibliotecaJogos(Scanner sc,  CarrinhoDeCompras carrinho, RepositorioJogoArrayList listJogos, TelaCliente telaCliente) {
		this.sc = sc;
		this.listJogos = listJogos;
		this.telaCliente = telaCliente;
		this.carrinho = carrinho;
	}
	
	public void setMostrarCarrinho(TelaCarrinhoDeCompras mostrarCarrinho) {
		this.mostrarCarrinho = mostrarCarrinho;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	public void Biblioteca(Cliente cliente) throws DadoInvalidoException {
		int opcao = 0;
		
		do {
			System.out.println("\n╔════════════════════════════════════════════╗");
		    System.out.println("║          🎮 JOGOS DISPONÍVEIS NA LOJA       ║");
		    System.out.println("╚════════════════════════════════════════════╝");
		    
		    System.out.println(listJogos.resumoJogos());
		    
		    System.out.println("\n════════════════════════════════════════════");
		    
		    System.out.println("Escolha uma opção:");
		    System.out.println("  [1] 🔍 Procurar um jogo");
		    System.out.println("  [2] 🛒 Ver carrinho de compras");
		    System.out.println("  [3] 👤 Ir para minha conta");
		    System.out.println("  [4] ❌ Sair");
		    System.out.print("\nDigite a opção desejada: ");
		    
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
			    		while(!opcaoValida1) {
				    		System.out.print("\n📝 Digite o nome do jogo: ");
				    		try{
				    			Jogo resultado = listJogos.procurarNome(sc.nextLine());
				    			resultado.mostrarDados();
				    			opcoesDeCompra(resultado, cliente);
				    			opcaoValida1 = true;
				    		}catch(DadoNaoEncontradoException e) {
				    			System.out.println("❌ Erro: " + e.getMessage());
				    			System.out.println("\nDigite novamente o jogo que procura:");
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
		    			Jogo resultado = listJogos.procurarNome(sc.nextLine());
		    			resultado.mostrarDados();
		    			opcoesDeCompra(resultado, cliente);
		    		}catch(DadoNaoEncontradoException e) {
		    			System.out.println("❌ Erro: " + e.getMessage());
		    			System.out.println("Digite novamente o jogo que procura.");
		    		}
		    		break;
		    	case 2:
		    		mostrarCarrinho.CarrinhoDeCompras(cliente, carrinho);
		    		break;
		    	case 3:
		    		telaCliente.telaMinhaContaCliente(cliente);
		    	case 4:
		    		menu.start();
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
			System.out.println("║       🛍️ OPÇÕES DE COMPRA / AÇÕES        ║");
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
			    	System.out.print("\nDigite um número válido: ");
			    }
			 }
			
			switch(opcao) {
				case 1:
					cliente.addListaDeDesejo(jogo);
					System.out.println("💖 O jogo "+jogo.getTitulo()+" foi adicionado a lista de desejos com sucesso.");
					break;
				case 2:
					carrinho.adiciona(jogo);
					System.out.println("🛒 O jogo "+jogo.getTitulo()+"  foi adicionado com sucesso ao carrinho.");
					System.out.println("Escolha uma opção:");
					System.out.println("  [1] 🔙 Voltar para a biblioteca");
					System.out.println("  [2] ✅ Finalizar compra");
					System.out.print("\nDigite a opção desejada: ");
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
								System.out.println("\nDigite apenas um dos números acima.");
								break;
						}
					    }catch(NumberFormatException  e) {
					    	System.out.println("❌ Erro: " + e.getMessage());
					    	System.out.print("\nDigite um número válido: ");
					    }
					 }
				break;
				case 3:
					
					System.out.println("Relamente deseja sair da sua conta?");
					System.out.println("  [1] Sim.");
					System.out.println("  [2] Não.");
					opcaoValida = false;
				    while(!opcaoValida) {
					    try {
					    	int subSubOpcao = Integer.parseInt(sc.nextLine());
					    	opcaoValida = true;
					    	if(subSubOpcao == 1) {
					    		//voltar para o start
					    		break;
					    	}
					    }catch(NumberFormatException  e) {
					    	System.out.println("❌ Erro: " + e.getMessage());
					    	System.out.print("\nDigite um número válido: ");
					    }
					 }
					break;
				default:
					System.out.println("⚠️ Opção inválida.");
					break;
			}
		}while(opcao != 3);
	}
}
