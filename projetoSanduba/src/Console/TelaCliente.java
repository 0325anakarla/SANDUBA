package Console;

import java.util.Scanner;

import Financeiro.CarteiraDoCliente;
import Financeiro.RegistroDeCompras;
import Pessoa.Cliente;
import jogo.Jogo;

public class TelaCliente {
	private Scanner sc;
	private VisualizacaoMenu visualizacaoMenu;
	

	public TelaCliente(Scanner sc, VisualizacaoMenu visualizacaoMenu) {
		this.sc = sc;
		this.visualizacaoMenu = visualizacaoMenu;
	}
	
	public void telaMinhaContaCliente(Cliente cliente) {
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuMcCliente();
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("\n╔═══════════════════════════╗");
					System.out.println("║    🧑‍💻 INFORMAÇÕES PESSOAIS ║");
					System.out.println("╚══════════════════════════════╝");
					System.out.println(cliente.mostrarDetalhesUsuario());
					break;
				case 2:
					if (cliente.getCarteiraDigital() != null) {
						telaCarteiraDigital(cliente.getCarteiraDigital());
					} else {
						System.out.println("Sem carteira digital!");
					}
					break;
				case 3:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║          🎮 MEUS JOGOS         ║");
					System.out.println("╚══════════════════════════════╝");
					if (!cliente.getJogosAdquiridos().isEmpty()) {
						for (Jogo jogo : cliente.getJogosAdquiridos()) {
							System.out.println(jogo.getTitulo());
						}
					} else {
						System.out.println("Você ainda não comprou jogos!");
					}
					break;
				case 4:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║       💖 LISTA DE DESEJOS      ║");
					System.out.println("╚══════════════════════════════╝");
					break;
				case 5:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║   📜 HISTÓRICO DE PEDIDOS      ║");
					System.out.println("╚══════════════════════════════╝");
					if (!cliente.getHistorico().isEmpty()) {
						for (RegistroDeCompras registro : cliente.getHistorico()) {
							System.out.println(registro.toString()+"\n");
							System.out.println("Lista de jogos comprados: ");
							registro.exibiJogos();
						}
					} else {
						System.out.println("Sem registro de compras!");
					}
					break;
				case 6:
					System.out.println("Volta para biblioteca de jogos");
					break;
				default:
					System.out.println("Opção invalida. digite novamente:");
					opcao = sc.nextInt();
			}
			
		}while(opcao != 6);
	}
	
	public void telaCarteiraDigital(CarteiraDoCliente cdC) {
		int opcao = 0;
		
		do {
			
			visualizacaoMenu.telaMenuCdCliente(cdC);
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					double valor =0;
					
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║         ➕ DEPÓSITO           ║");
					System.out.println("╚══════════════════════════════╝");

					System.out.print("Qual valor vai depositar:");
					
					valor = sc.nextDouble();
					
					if(cdC.depositar(valor)) {
						System.out.println("O valor depositado foi: "+valor+ ". Seu saldo é de:"+cdC.getSaldo());
					}
					
					else {
						System.out.println("Transação invalida.");
					}
					break;
				case 2:
					System.out.println("\n╔══════════════════════════════╗");
					System.out.println("║     💳 CARTÕES CADASTRADOS     ║");
					System.out.println("╚══════════════════════════════╝");
					break;
				case 3:
					System.out.println("Voltar para minha conta");
					break;
				default:
					System.out.println("Opção invalida. digite novamente:");
					opcao = sc.nextInt();
					
			}
			
		}while(opcao != 3);
	}
}
