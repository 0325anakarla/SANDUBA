package Console;

import java.util.Scanner;

import Financeiro.CarteiraDoCliente;
import Financeiro.RegistroDeCompras;
import Pessoa.Cliente;
import jogo.Jogo;

public class TelaCliente {
	
	Scanner sc = new Scanner(System.in);
	//veiwsMenu menu1 = new veiwsMenu();
	
	public void telaMinhaContaCliente(Cliente cliente) {
		int opcao = 0;
		
		do {
			
			//menu1.telaMenuMcCliente();
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("Mostra informaçoes pessoais");
					System.out.println(cliente.mostrarDetalhesUsuario());
					break;
				case 2:
					System.out.println("Mostra carteira digital e suas opções");
					if (cliente.getCarteiraDigital() != null) {
						telaCarteiraDigital(cliente.getCarteiraDigital());
					} else {
						System.out.println("Sem carteira digital!");
					}
					break;
				case 3:
					System.out.println("Mostra seus jogos");
					if (!cliente.getJogosAdquiridos().isEmpty()) {
						for (Jogo jogo : cliente.getJogosAdquiridos()) {
							System.out.println(jogo.getTitulo());
						}
					} else {
						System.out.println("Você ainda não comprou jogos!");
					}
					break;
				case 4:
					System.out.println("Mostra a lista de desejos");
					//list para jogos desejados
					break;
				case 5:
					System.out.println("mostra historico de pedidos");
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
			
			menu.telaMenuCdCliente(cdC);
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					double valor =0;
					
					System.out.println("Depositar");
					System.out.println("Qual valor vai depositar: ");
					
					valor = sc.nextDouble();
					
					if(cdC.depositar(valor)) {
						System.out.println("O valor depositado foi: "+valor+ ". Seu saldo é de:"+cdC.getSaldo());
					}
					
					else {
						System.out.println("Transação invalida.");
					}
					break;
				case 2:
					System.out.println("Cartoes cadastrados");
					//criar list para todos os cartoes cadastrados
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
