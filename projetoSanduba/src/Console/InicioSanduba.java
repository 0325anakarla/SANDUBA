package Console;

import java.util.Scanner;

import funcionalidades.ControleDeCadastros;

public class InicioSanduba {
	
	Scanner sc = new Scanner(System.in);
	Menu novoStart = new Menu();
	
	public static void start() {
		System.out.println("Bem- vindos ao sanduba");
		
		/*
		*
		*
		*
		* fotinha do sandubinha
		*
		*
		*
		*/
		
		System.out.println(" :D ");
		
		System.out.println("1- Fazer Cadastro");
		System.out.println("2- Logar na sua conta");
		System.out.println("3- Mais infos");
		System.out.println("0- Sair");
		
		 
		 
		 int num = sc.nextInt();
		switch(num) {
		
		case 1:
			novoStart.cadastroUsuario();
			break;
		
		case 2:
			novoStart.loginUsuario();
			break;
		case 3:
			//mais informacoes: agradecer quem usou - dizer quem fez o codigo - eatereggis 
			
			
			break;
		case 0: 
			System.out.println("Saindo...");
		default:
			System.out.println("Opcao invalida. Digite novamente");}
			
	}
}
