package Console;

import java.util.Map;
import java.util.Scanner;

import Financeiro.CarrinhoDeCompras;
import Repositorio.RepositorioJogoArrayList;
import jogo.Jogo;

public class TelaCarrinhoDeCompras {
	private Scanner sc;
	private CarrinhoDeCompras carrinho;
	private RepositorioJogoArrayList listJogos;
	private BibliotecaJogos bibJogos;
	private TelaCliente telaCliente;
	

	public TelaCarrinhoDeCompras(Scanner sc, CarrinhoDeCompras carrinho, RepositorioJogoArrayList listJogos, BibliotecaJogos bibJogos, TelaCliente telaCliente) {
		this.sc = sc;
		this.carrinho = carrinho;
		this.listJogos = listJogos;
		this.bibJogos = bibJogos;
		this.telaCliente = telaCliente;
	}
	
	public void CarrinhoDeCompras() {
		
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println("║          🛒 CARRINHO DE COMPRAS          ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		carrinho.imprimirCarrinho();
		
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] ❌ Remover item do carrinho");
		System.out.println("  [2] 💰 Finalizar compra");
		System.out.println("  [3] 🔙 Voltar para a biblioteca");
		System.out.print("\nDigite a opção desejada: ");
		int opcao = Integer.parseInt(sc.nextLine());
		
		switch(opcao) {
			case 1:
				int subOpcao = 0;
				do{
					System.out.println("Qual jogo deseja remover.");
					//duvida sobre isso (Ana alice)
					Jogo resultado = listJogos.procurarNome(sc.nextLine());
					carrinho.remove(resultado);
					System.out.println("O jogo "+ resultado.getTitulo()+" foi removido.");
					System.out.println("Deseja remover mais algum jogo?");
					System.out.println("1️⃣  Sim");
			        System.out.println("2️⃣  Não");
			        System.out.print("👉 Escolha a opção: ");
			        subOpcao = Integer.parseInt(sc.nextLine());   
				} while(subOpcao != 2); 
				break;
			case 2:
				carrinho.finalizarCompra(null);
				System.out.println("Compra finalizada com sucesso.");
				break;
			case 3:
				bibJogos.Biblioteca();
				break;
			default:
				 System.out.println("⚠️ Opção inválida.");
	               
		}
		
		System.out.println("Escolha uma opção:");
		System.out.println("  [1] 🔙 Voltar para a biblioteca");
		System.out.println("  [2] 👤 Ir para minha conta");
		System.out.print("\nDigite a opção desejada: ");
		opcao = Integer.parseInt(sc.nextLine());
		
		switch(opcao) {
			case 1:
				bibJogos.Biblioteca();
				break;
			case 2:
				telaCliente.telaMinhaContaCliente(null);
				break;
			default:
				System.out.println("⚠️ Opção inválida.");
				break;
		}
	}
}
