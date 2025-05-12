package funcionalidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//import Console.Menu;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoInvalidoException;

public class ControleDeCadastros {
	private Scanner sc;
	private final RepositorioUsuarioArrayList repositorio;
	//private Menu menu;

	public ControleDeCadastros(Scanner sc, RepositorioUsuarioArrayList repositorio/*, Menu menu*/) {
		this.sc = sc;
		this.repositorio = new RepositorioUsuarioArrayList();
		//this.menu = menu;
	}
	
	public void CadastrarClientes() {

		boolean continuarCadastro = true;

		while (continuarCadastro) {
			boolean dadosValidos = false;
			// nome email senha cpf data//
			Cliente cliente = new Cliente(null, null, null, null, null);
			LocalDate natalicio = null;
			int tentativas = 0;
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			do {
				try {
					System.out.println("\n╔════════════════════════════════════════════════════╗");
					System.out.println("║        🧾 CADASTRO DE CLIENTE - PREENCHA OS DADOS   ║");
					System.out.println("╚════════════════════════════════════════════════════╝");

					System.out.print("🧍 Nome completo: ");
					cliente.setNome(sc.nextLine());

					System.out.print("📧 Email: ");
					cliente.setEmail(sc.nextLine());

					System.out.print("🔒 Senha: ");
					cliente.setSenha(sc.nextLine());

					while (tentativas < 3) {
						System.out.print("🪪 CPF - (11 dígitos): ");
						String Icpf = sc.nextLine();

						if (Icpf.matches("\\d{11}")) {
							cliente.setCpf(Icpf);
							break;
						} else {
							tentativas++;
							System.out.println("⚠️  CPF inválido. Tente novamente. (" + tentativas + "/3)");

							if (tentativas == 3) {

								System.out.println("\n╔════════════════════════════════════════════════╗");
								System.out.println("║ ❌ Cadastro cancelado: número de tentativas excedido ║");
								System.out.println("╚════════════════════════════════════════════════╝");
								return;

							}
						}
					}

					while (natalicio == null && tentativas < 3) {
						try {
							System.out.print("📅 Data de Nascimento - (dd/MM/yyyy): ");
							String Idata = sc.nextLine();
							natalicio = LocalDate.parse(Idata, formato);
							cliente.setNatalicio(natalicio);
						} catch (Exception e) {
							tentativas++;
							System.out.println("⚠️  Formato de data inválido. Tente novamente. (" + tentativas + "/3)");

							if (tentativas == 3){
								System.out.println("\n╔════════════════════════════════════════════════╗");
								System.out.println("║ ❌ Cadastro cancelado: número de tentativas excedido ║");
								System.out.println("╚════════════════════════════════════════════════╝");
								return; 
							}
						}
					}

					dadosValidos = true;
				} catch (DadoInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
				}
			} while (!dadosValidos);
			
			System.out.println("\n╔══════════════════════════════════════╗");
			System.out.println("║ ✅ Cadastro realizado com sucesso!  ║");
			System.out.println("╚══════════════════════════════════════╝");
			System.out.println("😄 Seja bem-vindo(a), " + cliente.getNome() + "!");
			
			repositorio.add(cliente);
			System.out.println("\n🔄 Redirecionando para a tela inicial...\n");
			//pensar em uma forma de voltar para a tela inicial
			//sem criar um objeto do tipo menu
			//menu.start();
			break;
		}
	}

	public void CadastrarEmpresa() {
		boolean continuarCadastro = true;
		
		while(continuarCadastro){
		boolean dadosValidos = false;
		
		//nome  email  senha RazaoS cpnj endereco  dados bancarios (para n esquecer nada)
		Empresa empresa = new Empresa(null, null, null, null, null, null, null);
		int tentativas = 0;
		
		do {
			try {
				//dados normais
				System.out.println("\n╔════════════════════════════════════════════════════╗");
				System.out.println("║   🧾 CADASTRO DE EMPRESA - PREENCHA OS DADOS   ║");
				System.out.println("╚════════════════════════════════════════════════════╝");

				System.out.print("🧍 Nome: ");
				empresa.setNome(sc.nextLine());

				System.out.print("📧 Email: ");
				empresa.setEmail(sc.nextLine());

				System.out.print("🔒 Senha: ");
				empresa.setSenha(sc.nextLine());
				
				System.out.print("🧍 Razão Social: ");
				empresa.setNome(sc.nextLine());
				
				while (tentativas < 3) {
					System.out.print("🪪 CNPJ - (14 dígitos): ");
					String Icpnj = sc.nextLine();

					if (Icpnj.matches("\\d{14}")) {
						empresa.setCpnj(Icpnj);
						break;
					} else {
						tentativas++;
						System.out.println("⚠️  CNPJ inválido. Tente novamente. (" + tentativas + "/3)");

						if (tentativas == 3) {

							System.out.println("\n╔════════════════════════════════════════════════╗");
							System.out.println("║ ❌ Cadastro cancelado: número de tentativas excedido ║");
							System.out.println("╚════════════════════════════════════════════════╝");
							return;

						}
					}
				}
				
				System.out.print("📍 Endereco: ");
				empresa.setNome(sc.nextLine());
				
			//DADOS BANCARIOS -
				
				System.out.println("\n╔════════════════════╗");
				System.out.println("║   🏦 DADOS BANCARIOS   ║");
				System.out.println("╚══════════════════════╝");	
				

			} catch(DadoInvalidoException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		} while(!dadosValidos);
		
		}
	}
}
