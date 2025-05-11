package Console;

import java.util.Scanner;
import Repositorio.RepositorioUsuarioArrayList;

public class InicioSanduba {

	private static  Scanner sc = new Scanner(System.in);
	
	static RepositorioUsuarioArrayList repositorio;
	static Menu novoStart =  new Menu();
	
	public InicioSanduba(RepositorioUsuarioArrayList repositorio) {
		InicioSanduba.repositorio = RepositorioUsuarioArrayList.getInstance(); 
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
			novoStart.cadastroUsuario();
			break;

		case 2:
			novoStart.loginUsuario();
			break;
		case 3:
			// mais informacoes: agradecer quem usou - dizer quem fez o codigo - eatereggis
			break;
		case 0:
			System.out.println("Saindo...");
		default:
			System.out.println("Opcao invalida. Digite novamente");
		}
	}
}
