package Console;
import java.util.Scanner;

import Interfaces.Repositorio;
import Pessoa.Usuarios;
import funcionalidades.ControleDeCadastros;
import funcionalidades.ServicoGeral;

public class Menu {
	// - parte burocratica de chamar as funcoes -//
	Scanner sc = new Scanner(System.in);
	ControleDeCadastros novoCada = new ControleDeCadastros();
	
	public void loginUsuario(Repositorio<Usuarios> repositorio) {
		
		Usuarios usuarioLogin = null;
		boolean logado = false;
		int tentativa =0;
		
		while(!logado && tentativa < 3) {
			
			System.out.print("\n------------------------");
			System.out.print("#-   DIGITE SEU LOGIN   -#");
			System.out.print("------------------------");
			
			System.out.print("\nEmail: ");
			String email =  sc.nextLine();
			
			System.out.print("\nSenha: ");
			String senha = sc.nextLine();
			
			usuarioLogin = ServicoGeral.login(email, senha, repositorio);

			if (usuarioLogin != null) {
				logado = true;
			    System.out.println("Login realizado com sucesso! Bem-vindo(a), " + usuarioLogin.getNome());
			    if() {
			    	// se for cliente tela do client
			    }
			    if else(){
			    	// se for empresa tela da empresa
			    }
			    else {
			    	// se for adm tela do adm
			    }
			    
			    	
			} else {
			    System.out.println("Email ou senha incorretos.");
			    tentativa ++;
			    break;
			}
			
			
	}
	}
	
	public void cadastroUsuario() {
				
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
					novoCada.CadastrarEmpresa();
					break;
				case 0: 
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opcao invalida. Digite novamente");}
	}
	

}
