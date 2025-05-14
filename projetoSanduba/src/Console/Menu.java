package Console;

import java.util.Scanner;

import Pessoa.Adm;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.ControleDeCadastros;
import funcionalidades.Gambiarras;

public class Menu {
	// - parte burocratica de chamar as funcoes -//
	private Scanner sc;
	private final RepositorioUsuarioArrayList listUsuarios;
	private final ControleDeCadastros controleCadastros;
	private BibliotecaJogos bibJogos;
	private TelaEmpresa telaEmpresa;
	private TelaAdm telaAdm;

	public Menu(Scanner sc, RepositorioUsuarioArrayList listUsuarios, ControleDeCadastros controleCadastros,
			BibliotecaJogos bibJogos, TelaEmpresa telaEmpresa, TelaAdm telaAdm) {
		this.sc = sc;
		this.listUsuarios = listUsuarios;
		this.controleCadastros = controleCadastros;
		this.bibJogos = bibJogos;
		this.telaEmpresa = telaEmpresa;
		this.telaAdm = telaAdm;
	}

	public void start() throws DadoInvalidoException {

		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║       🥪 BEM-VINDO AO SANDUBA!       ║");
		System.out.println("╚══════════════════════════════════════╝\n");

		System.out.println("Escolha uma opção:  ");
		System.out.println(" > [1] 📝 Fazer cadastro");
		System.out.println(" > [2] 🔐 Fazer login");
		System.out.println(" > [3] ℹ️  Mais informações");
		System.out.println(" > [0] ❌ Sair do sistema");
		System.out.print("\n-> Digite a opção desejada: ");

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

			System.out.println("Obrigado por utilizar o Sanduba");

			System.out.print("\n[1]-  Voltar.. \nResposta:");
			int choice2 = sc.nextInt();
			sc.nextLine();

			switch (choice2) {
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

	public void loginUsuario() throws DadoInvalidoException {

		Usuarios usuarioLogin = null;
		boolean logado = false;
		int tentativas = 0;

		while (!logado && tentativas < 3) {
			try {
				System.out.println("\n╔══════════════════════════════════════╗");
				System.out.println("║          🔐 DIGITE SEU LOGIN         ║");
				System.out.println("╚══════════════════════════════════════╝");

				System.out.print("\n📧 Email: ");
				String email = sc.nextLine().trim();

				System.out.print("\n🔒 Senha: ");
				String senha = sc.nextLine().trim();

				usuarioLogin = listUsuarios.procurarEmailSenha(email, senha);

				if (usuarioLogin != null) {
					if (usuarioLogin.getSenha().equals(senha)) {
						logado = true;

						Gambiarras.textoLento("-> ✅ LOGIN REALIZADO COM SUCESSO  ", 50);

						Gambiarras.textoLento("\nBem-vindo(a), " + usuarioLogin.getNome() + "!", 60);

						Gambiarras.limparTela();

						if (usuarioLogin instanceof Cliente) {
							bibJogos.Biblioteca((Cliente) usuarioLogin);
						} else if (usuarioLogin instanceof Empresa) {
							telaEmpresa.telaMinhaContaEmpresa((Empresa) usuarioLogin);
						} else if (usuarioLogin instanceof Adm) {
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

		if (!logado) {
			System.out.println("\n⚠️ Número máximo de tentativas atingido. Voltando ao menu principal...");
			start();
		}

	}

	public void cadastroUsuario() throws DadoInvalidoException {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║          🆕 CRIE SUA CONTA           ║");
		System.out.println("╚══════════════════════════════════════╝");
		System.out.println("");
		System.out.println("Escolha o tipo de cadastro:");
		System.out.println(">  [1] 👤 Pessoa física");
		System.out.println(">  [2] 🏢 Empresa");
		System.out.println(">  [0] ❌ Voltar");
		System.out.print("\n-> Digite a opção desejada: ");

		int choice3 = sc.nextInt();
		sc.nextLine();

		switch (choice3) {
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
