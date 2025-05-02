package Console;

import java.util.Scanner;

import projetoSanduba.CarteiraDaEmpresa;

public class TelaEmpresa {
	Scanner sc = new Scanner(System.in);
	veiwsMenu menu = new veiwsMenu();
	CarteiraDaEmpresa cdE = new CarteiraDaEmpresa(null);
	
	public void telaMinhaContaEmpresa() {
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
					System.out.println("Jogos cadastrados");
					//list para jogos comprados
					break;
				case 4:
					System.out.println("Cadastrar Jogos");
					//repositorio
					break;
				case 5:
					System.out.println("Resumo de vendas");
					//list para resumo de vendas
					break;
				case 6:
					System.out.println("sair");
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
			
			menu.telaMenuCdCliente();
			
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1:
					double valor =0;
					
					System.out.println("Retirar");
					System.out.println("Qual valor vai retirar: ");
					
					valor = sc.nextDouble();
					
					//ta dando erro nesse aqui o saldo nao ta mostrando certo(anaalice),mas o depositar ta certo
					if(cdE.retirar(valor, null)) {
						System.out.println("O valor retirado foi: "+valor+ ". Seu saldo é de:"+cdE.getSaldo());
					}
					
					else {
						System.out.println("Transação invalida.");
					}
					break;
				case 2:
					System.out.println("Mostrar dados bancarios");
					
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
