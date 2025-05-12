package funcionalidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Console.Menu;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoInvalidoException;

public class ControleDeCadastros {
	RepositorioUsuarioArrayList listUsuarios = new RepositorioUsuarioArrayList();
	

	// Scanner
	Scanner sc = new Scanner(System.in);
	

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
					System.out.println("\n╔══════════════════════════════════════╗");
					System.out.println("║         👤 CADASTRO DE CLIENTE         ║");
					System.out.println("╚══════════════════════════════════════╝");
					System.out.println();

					System.out.println("\n->Preencha todos os campos\n");

					System.out.print("Nome: ");
					cliente.setNome(sc.nextLine());

					System.out.print("Email: ");
					cliente.setEmail(sc.nextLine());

					System.out.print("Senha:");
					cliente.setSenha(sc.nextLine());

					while (tentativas < 3) {
						System.out.print("Cpf: ");
						String Icpf = sc.nextLine();

						if (Icpf.matches("\\d{11}")) {
							cliente.setCpf(Icpf);
							break;
						} else {

							System.out.println("Cpf invalido");
							tentativas++;

						}
					}

					while (natalicio == null && tentativas < 3) {
						try {
							System.out.println("Data de Nascimento(dd/MM/yyyy):");
							String Idata = sc.nextLine();
							natalicio = LocalDate.parse(Idata, formato);
							cliente.setNatalicio(natalicio);
						} catch (Exception e) {
							System.out.println("Formato de data Invalido");
						}
						tentativas++;
					}

					dadosValidos = true;
				} catch (DadoInvalidoException e) {
					System.out.println("Erro: " + e.getMessage());
				}
			} while (!dadosValidos);
		}

	}

	public void CadastrarEmpresa() {
		boolean dadosValidos = false;
     
		Empresa empresa = new Empresa(null, null, null, null, null, null, null);
	}

}
