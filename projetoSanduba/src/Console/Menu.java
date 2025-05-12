package Console;
import java.util.Scanner;

import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.ControleDeCadastros;

public class Menu {
	// - parte burocratica de chamar as funcoes -//
	private private static Scanner sc;
	
	final RepositorioUsuarioArrayList repositorio = new RepositorioUsuarioArrayList();

	final ControleDeCadastros novoCada = new ControleDeCadastros();
	final InicioSanduba inicio = new InicioSanduba(repositorio);
	private final RepositorioUsuarioArrayList repositorio;
	private ControleDeCadastros controleCadastros;
	private TelaCliente telaCliente;
	private TelaEmpresa telaEmpresa;
	
	public Menu(Scanner sc, RepositorioUsuarioArrayList repositorio, ControleDeCadastros controleCadastros, TelaCliente telaCliente, TelaEmpresa telaEmpresa) {
		this.sc = sc;
		this.repositorio = repositorio;
		this.controleCadastros = controleCadastros;
		this.telaCliente = telaCliente;
		this.telaEmpresa = telaEmpresa;
	}
	
	
	public void start(){
		
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


	int choice = sc.nextInt();

	switch (choice) {

	case 1:
		cadastroUsuario();
		break;

	case 2:
		loginUsuario();
		break;
	case 3:

		System.out.println("Obrigado por utilizar o Sanduba Deus te abencoe");
		
		System.out.print("\n[1]-  Voltar.. \nResposta:");
		int choice2 = sc.nextInt();
		
			switch(choice2) {
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

	public void loginUsuario() {

		    Usuarios usuarioLogin = null;
		    boolean logado = false;
		    int tentativas = 0;
		 
		    while (!logado && tentativas < 3) {
		        try {
		            System.out.println("\n╔══════════════════════════════════════╗");
		            System.out.println("║          🔐 DIGITE SEU LOGIN         ║");
		            System.out.println("╚══════════════════════════════════════╝");

		            if (tentativas == 0) {
		                sc.nextLine();
		            }
		            
		            System.out.print("\n📧 Email: ");
		            String email = sc.nextLine().trim();
		            
		            System.out.print("\n🔒 Senha: ");
		            String senha = sc.nextLine().trim();

		            usuarioLogin = repositorio.procurarEmail(email);
		            
		            if (usuarioLogin != null) {
		                if (usuarioLogin.getSenha().equals(senha)) {
		                    logado = true;
		                    System.out.println("\n╔══════════════════════════════════════╗");
		                    System.out.println("║      ✅ LOGIN REALIZADO COM SUCESSO  ║");
		                    System.out.println("╚══════════════════════════════════════╝");
		                    System.out.println("\nBem-vindo(a), " + usuarioLogin.getNome() + "!");
		                    
		                    if (usuarioLogin instanceof Cliente) {
		                        telaCliente.telaMinhaContaCliente((Cliente)usuarioLogin);
		                    } 
		                    else if (usuarioLogin instanceof Empresa) {
		                        telaEmpresa.telaMinhaContaEmpresa((Empresa) usuarioLogin);
		                    }
		                    
		                   else {
		                        System.out.println("PARTE DO ADMMM");
		                    }
		                }   
		            }
		        } catch (DadoInvalidoException e) {
		            System.out.println("\n⚠️ Erro: " + e.getMessage());
		        } catch (Exception e) {
		            System.out.println("\n⚠️ Ocorreu um erro inesperado: " + e.getMessage());
		            tentativas++;
		        }
		    }
		    
		    // Caso exceda as tentativas
		    if (!logado) {
		        System.out.println("\n⚠️ Número máximo de tentativas atingido. Voltando ao menu principal...");
		        start();
		    }
		}
	
	public void cadastroUsuario() {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║          🆕 CRIE SUA CONTA          ║");
		System.out.println("╚══════════════════════════════════════╝");
		System.out.println("");
		System.out.println("Escolha o tipo de cadastro:");
		System.out.println("  [1] 👤 Pessoa física");
		System.out.println("  [2] 🏢 Empresa");
		System.out.println("  [0] ❌ Voltar");
		System.out.print("\nDigite a opção desejada: ");

		int choice3 = sc.nextInt();

		switch(choice3) {
		    case 1:
		    	controleCadastros.CadastrarClientes();
		        break;
		    case 2:
		    	controleCadastros.CadastrarEmpresa();
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
