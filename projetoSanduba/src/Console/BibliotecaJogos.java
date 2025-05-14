package Console;

import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;

public class BibliotecaJogos {
	private Scanner sc;
	private CarrinhoDeCompras carrinho;
	private RepositorioJogoArrayList listJogos;
	private TelaCliente telaCliente;
	private TelaCarrinhoDeCompras mostrarCarrinho;
	
	public BibliotecaJogos(Scanner sc,  CarrinhoDeCompras carrinho, RepositorioJogoArrayList listJogos, TelaCliente telaCliente) {
		this.sc = sc;
		this.listJogos = listJogos;
		this.telaCliente = telaCliente;
		this.carrinho = carrinho;
	}
	
	public void setMostrarCarrinho(TelaCarrinhoDeCompras mostrarCarrinho) {
		this.mostrarCarrinho = mostrarCarrinho;
	}
	
	public void Biblioteca() {
		
		System.out.println("\n╔════════════════════════════════════════════╗\n");
	    System.out.println("║          🎮 JOGOS DISPONÍVEIS NA LOJA       ║\n");
	    System.out.println("╚════════════════════════════════════════════╝\n");
	    
	    listJogos.resumoJogos();
	    
	    System.out.println("\n════════════════════════════════════════════");
	    
	    int opcao = 0;
	    
	    //talvez aqui precise de um while, verificar quando testar
	    do {
		    System.out.println("Escolha uma opção:");
		    System.out.println("  [1] 🔍 Procurar um jogo");
		    System.out.println("  [2] 🛒 Ver carrinho de compras");
		    System.out.println("  [3] 👤 Ir para minha conta");
		    System.out.println("  [4] ❌ Sair");
		    System.out.print("\nDigite a opção desejada: ");
		    
		    opcao = Integer.parseInt(sc.nextLine());
		    
		    switch(opcao) {
		    	case 1: 
		    		System.out.print("\n📝 Digite o nome do jogo: ");
		    		try{
		    			Jogo resultado = listJogos.procurarNome(sc.nextLine());
		    			resultado.mostrarDados();
		    		}catch(DadoNaoEncontradoException e) {
		    			System.out.println("❌ Erro: " + e.getMessage());
		    			System.out.println("Digite novamente o jogo que procura.");
		    		}
		    		break;
		    	case 2:
		    		telaCliente.telaMinhaContaCliente(null);
		    }
	    }while(opcao != 4);
	}
	
	public void opcoesDeCompra(Jogo jogo) {
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println("║       🛍️ OPÇÕES DE COMPRA / AÇÕES        ║");
		System.out.println("╚════════════════════════════════════════╝");
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] 💖 Adicionar à lista de desejos");
		System.out.println("  [2] 🛒 Adicionar ao carrinho");
		System.out.println("  [3] ❌ Sair");
		System.out.print("\nDigite a opção desejada: ");
		
		int opcao = Integer.parseInt(sc.nextLine());
		
		switch(opcao) {
			case 1:
				//adicionar ao um array list do tipo jogo, que vai conter os jogos desejados
				break;
			case 2:
				carrinho.adiciona(jogo);
				System.out.println("O jogo "+jogo.getTitulo()+"  foi adicionado com sucesso ao carinho.");
				System.out.println("Escolha uma opção:");
				System.out.println("  [1] 🔙 Voltar para a biblioteca");
				System.out.println("  [2] ✅ Finalizar compra");
				System.out.print("\nDigite a opção desejada: ");
				int subOpcao = Integer.parseInt(sc.nextLine());
				
				switch(subOpcao) {
					case 1:
						Biblioteca();
						break;
					case 2:
<<<<<<< HEAD
						mostrarCarrinho.CarrinhoDeCompras(jogo);

=======
						mostrarCarrinho.CarrinhoDeCompras();
>>>>>>> a1bfe3ce5bd3441d34225fc358aac91b33b97ceb
						break;
					default:
						 System.out.println("⚠️ Opção inválida.");
						 break;
				}
		}
	}
	
}
