package Console;
import java.util.Scanner;

import funcionalidades.ControleDeCadastros;

public class Menu {
	// - parte burocratica de chamar as funcoes -//
	Scanner sc = new Scanner(System.in);
	ControleDeCadastros novoCada = new ControleDeCadastros();
	
	public void login() {
		System.out.println("\n------------------------");
		System.out.println("#-   DIGITE SEU LOGIN   -#");
		System.out.println("------------------------");
	}
	
	public void cadastro() {
				
				System.out.println("\n------------------------");
				System.out.println("#-   CRIE SUA CONTA   -#");
				System.out.println("------------------------");
				
				
				System.out.println("\n -> Escolha o tipo de cadastro: ");
				
				System.out.println("1- Pessoa fisica");
				System.out.println("2- Empresa");
				System.out.println("0- Sair");
				
				int choice = sc.nextInt();
				
				switch(choice) {
				
				case 1:
					novoCada.CadastrarClientes();
					break;
				
				case 2:
					System.out.println("Cadastro da Empresa");
					break;
				case 0: 
					System.out.println("Saindo...");
				default:
					System.out.println("Opcao invalida. Digite novamente");}
	}
	
	
	//-- funcao para sair a qualquer momento do projeto --//
	public void sair() {
		System.out.println("Encerrando sessao...");
	}
}
