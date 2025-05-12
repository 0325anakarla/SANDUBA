package Console;

import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoNaoEncontradoException;
import jogo.Jogo;

public class BibliotecaJogos {
	
	RepositorioJogoArrayList jogosCadastrados = new RepositorioJogoArrayList();
	Scanner sc = new Scanner(System.in);
	TelaCliente minhaConta = new TelaCliente();
	CarrinhoDeCompras carCompras = new CarrinhoDeCompras();
	TelaCarrinhoDeCompras mostrarCarCompras = new TelaCarrinhoDeCompras();
	
	public void Biblioteca() {
		
		System.out.println("\n╔════════════════════════════════════════════╗\n");
	    System.out.println("║          🎮 JOGOS DISPONÍVEIS NA LOJA       ║\n");
	    System.out.println("╚════════════════════════════════════════════╝\n");
	    
	    jogosCadastrados.resumoJogos();
	    
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
		    			Jogo resultado = jogosCadastrados.procurarNome(sc.nextLine());
		    			resultado.mostrarDados();
		    		}catch(DadoNaoEncontradoException e) {
		    			System.out.println("❌ Erro: " + e.getMessage());
		    			System.out.println("Digite novamente o jogo que procura.");
		    		}
		    		break;
		    	case 2:
		    		minhaConta.telaMinhaContaCliente(null);
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
				break;
			case 2:
				carCompras.adiciona(jogo);
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
						mostrarCarCompras.CarrinhoDeCompras(jogo);
						break;
					default:
						 System.out.println("⚠️ Opção inválida.");
						 break;
				}
		}
	}
	
}
