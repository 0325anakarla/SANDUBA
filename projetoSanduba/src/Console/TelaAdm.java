package Console;

import java.util.Scanner;

public class TelaAdm {
	Scanner sc = new Scanner(System.in);
	veiwsMenu menu = new veiwsMenu();
	
	
	public void exibirMenuAdm() {
		
		menu.telaMenuMcAdm();
		int opcao = sc.nextInt();
		
		do {
		
		switch(opcao) {
			case 1:
				System.out.println("Lista de Clientes:");
				
				break;
			case 2:
				System.out.println("Lista de EmpresaS:");
				
				break;
			case 3:
				System.out.println("Cadastro de Cliente: ");
				//chamar cadastrar cliente
				break;
			case 4:
				System.out.println("Cadastro de Cliente: ");
				//chamar cadastro de empresa
				break;
			case 5:
				System.out.println("Jogos castrados");
				//chamr list de jogos
				break;
			case 6:
				System.out.println("Cadastrar descontos de jogos antigos");
//				basicamnete  vai ter so a opçao de adicionar o ano
				break;
			case 7:
				System.out.println("Saindo...");
				break;	
			default:
				System.out.println("Opção invalida");
				opcao= sc.nextInt();
				
		}
		
	}while(opcao != 7);

	}
}
