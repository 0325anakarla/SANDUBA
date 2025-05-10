package Console;

import java.util.Scanner;

import projetoSanduba.CarteiraDoCliente;

public class TelaCliente {
	
	Scanner sc = new Scanner(System.in);
	veiwsMenu menu = new veiwsMenu();
	CarteiraDoCliente cdC = new CarteiraDoCliente();
	
	public void telaMinhaContaCliente() {
		int opcao = 0;
		
		do {
			
			menu.telaMenuMcCliente();
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("Mostra informaçoes pessoais");
					
					break;
				case 2:
					System.out.println("Mostra carteira digital e suas opções");
					telaCarteiraDigital();
					break;
				case 3:
					System.out.println("Mostra seus jogos");
					//list para jogos comprados
					break;
				case 4:
					System.out.println("Mostra a lista de desejos");
					//list para jogos desejados
					break;
				case 5:
					System.out.println("mostra historico de pedidos");
					//list para pedidos feitos
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
	
	public void telaCarteiraDigital() {
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
