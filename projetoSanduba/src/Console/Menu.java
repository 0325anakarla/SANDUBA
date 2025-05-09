package Console;
import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	CadastroUsuario novoUsu = new CadastroUsuario();
	
	
	// -- Funcao para o usuario ou empresa fazerem login -- //
	public void login() {
		System.out.println("\n------------------------");
		System.out.println("#-   DIGITE SEU LOGIN   -#");
		System.out.println("------------------------");
	}
	
	// -- funcao para cadastro -- //
	public void cadastro() {
		//Usuarios iPessoa= new Usuarios(null, null, null);
		
				//while :D
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
					System.out.println("Cadastro de usuario aqui");
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
