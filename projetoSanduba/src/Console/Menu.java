package Console;
import java.util.Scanner;

import Pessoa.Usuarios;
import Repositorio.RepositorioUsuarioArrayList;
import funcionalidades.ControleDeCadastros;

public class Menu {
	// - parte burocratica de chamar as funcoes -//
	private static Scanner sc = new Scanner(System.in);
	
	private RepositorioUsuarioArrayList repositorio;
	private static ControleDeCadastros controle;

	final ControleDeCadastros novoCada = new ControleDeCadastros();
	
	public Menu() {
		this.repositorio = RepositorioUsuarioArrayList.getInstance();

	}
	
	public static void start() {
		
	    System.out.println("\n╔══════════════════════════════════════╗");
	    System.out.println("║       🥪 BEM-VINDO AO SANDUBA!       ║");
	    System.out.println("╚══════════════════════════════════════╝");
	    System.out.println("");
	    System.out.println("Escolha uma opção:");
	    System.out.println("  [1] 📝 Fazer cadastro");
	    System.out.println("  [2] 🔐 Fazer login");
	    System.out.println("  [3] ℹ️  Mais informações");
	    System.out.println("  [0] ❌ Sair do sistema");
	    System.out.print("\nDigite a opção desejada: ");


	int num = sc.nextInt();

	switch (num) {

	case 1:
		cadastroUsuario();
		break;

	case 2:
		loginUsuario();
		break;
	case 3:
		
		System.out.println("Obrigado por utilizar o Sanduba Deus te abencoe");
		
		System.out.print("\n[1]-  Voltar.. \nResposta:");
		int num1 = sc.nextInt();
		switch(num1) {
		
			case 1: 
				start();
				break;
			default:
				System.out.println("Opcao invalida. Digite novamente");
		}

		break;
	case 0:
		System.out.println("Saindo...");
		break;
	default:
		System.out.println("Opcao invalida. Digite novamente");
	}
}

	public static void loginUsuario() throws IllegalArgumentException {
		
		Usuarios usuarioLogin = null;
		boolean logado = false;
		int tentativa =0;
		
		while(!logado && tentativa < 3) {
			
			System.out.println("\n╔══════════════════════════════════════╗");
			System.out.println("║          🔐 DIGITE SEU LOGIN         ║");
			System.out.println("╚══════════════════════════════════════╝");
			System.out.println("");
			System.out.print("  📧 Email: ");
			String email = sc.nextLine();
			System.out.println("");
			System.out.print("  🔒 Senha: ");
			String senha = sc.nextLine();
			//usuarioLogin = ServicoGeral.login(email, senha, repositorio);

			if (usuarioLogin != null) {
				logado = true;
			    System.out.println("Login realizado com sucesso! Bem-vindo(a), " + usuarioLogin.getNome());
			   
			    /* if() {
			    	// se for cliente tela do client
			    }
			    if else(){
			    	// se for empresa tela da empresa
			    }
			    else {
			    	// se for adm tela do adm
			    }
			    */
			    	
			} else {
			    System.out.println("Email ou senha incorretos.");
			    tentativa ++;
			    break;
			}
	
	}
	}
	
	public static void cadastroUsuario() {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║          🆕 CRIE SUA CONTA          ║");
		System.out.println("╚══════════════════════════════════════╝");
		System.out.println("");
		System.out.println("Escolha o tipo de cadastro:");
		System.out.println("  [1] 👤 Pessoa física");
		System.out.println("  [2] 🏢 Empresa");
		System.out.println("  [0] ❌ Voltar");
		System.out.print("\nDigite a opção desejada: ");

		int choice = sc.nextInt();

		switch(choice) {
		    case 1:
		        controle.CadastrarClientes();
		        break;
		    case 2:
		        controle.CadastrarEmpresa();
		        break;
		    case 0: 
		        System.out.println("Voltando...");
		        start();
		        break;
		    default:
		        System.out.println("Opção inválida. Digite novamente");
		}	
				
	}

}
