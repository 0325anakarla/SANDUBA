package Console;
import java.util.Scanner;

import Pessoa.Adm;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.ControleDeCadastros;

public class Menu {
	// - parte burocratica de chamar as funcoes -//
	private Scanner sc;
	private final RepositorioUsuarioArrayList listUsuarios;
	private final ControleDeCadastros controleCadastros;
	private BibliotecaJogos bibJogos;
	private TelaEmpresa telaEmpresa;
	private TelaAdm telaAdm;
	
	public Menu(Scanner sc, RepositorioUsuarioArrayList listUsuarios, ControleDeCadastros controleCadastros, BibliotecaJogos bibJogos, TelaEmpresa telaEmpresa, TelaAdm telaAdm) {
		this.sc = sc;
		this.listUsuarios = listUsuarios;
		this.controleCadastros = controleCadastros;
		this.bibJogos = bibJogos;
		this.telaEmpresa = telaEmpresa;
		this.telaAdm = telaAdm;
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
	    sc.nextLine();

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
	    		sc.nextLine();
		
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

		            usuarioLogin = listUsuarios.procurarEmail(email);
		            
		            // SE A PESSOA ERRAR A SENHA 3 VEZES ELA PODE SOLICITAR UM ALTERAR SENHA...
		            
		            if (usuarioLogin != null) {
		                if (usuarioLogin.getSenha().equals(senha)) {
		                    logado = true;
		                    System.out.println("\n╔══════════════════════════════════════╗");
		                    System.out.println("║      ✅ LOGIN REALIZADO COM SUCESSO  ║");
		                    System.out.println("╚══════════════════════════════════════╝");
		                    System.out.println("\nBem-vindo(a), " + usuarioLogin.getNome() + "!");
		                    
		                    if (usuarioLogin instanceof Cliente) {
		                    	bibJogos.Biblioteca();
		                    } 
		                    else if (usuarioLogin instanceof Empresa) {
		                        telaEmpresa.telaMinhaContaEmpresa((Empresa) usuarioLogin);
		                    }
		                    else if (usuarioLogin instanceof Adm) {
		                    	telaAdm.exibirMenuAdm();
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
		sc.nextLine();

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
