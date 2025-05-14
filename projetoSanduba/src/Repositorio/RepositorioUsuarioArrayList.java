package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Repositorio;
import Interfaces.RepositorioUsuario;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.Gambiarras;

// importar os exceptions
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RepositorioUsuarioArrayList implements Repositorio<Usuarios>, RepositorioUsuario {

	private final List<Usuarios> usuarios; // Vai armazenar os Usuarios na list
	private Scanner sc;

	public RepositorioUsuarioArrayList(Scanner sc) {
		this.usuarios = new ArrayList<>();
		this.sc = sc;
	}

	@Override
	public void add(Usuarios addUsuario) {
		usuarios.add(addUsuario);
		// ok
	}

	@Override
	public List<Usuarios> getTodos() { // vai varrer todo o arraylist [e tipo um getall
		return new ArrayList<>(usuarios);
	}

	@Override
	public void alterarDados(Usuarios upUsuario) {
		if (upUsuario instanceof Cliente) {
			Cliente cliente = (Cliente) upUsuario;
			boolean continuarAlterar = true;

			while (continuarAlterar) {
				System.out.println("\n╔════════════════════════════════════════╗");
				System.out.println("║      ✏️ ALTERAR DADOS DO CLIENTE       ║");
				System.out.println("╠════════════════════════════════════════╣");
				System.out.println("║ [1] ✏️ Alterar Nome                    ║");
				System.out.println("║ [2] 📧 Alterar Email                   ║");
				System.out.println("║ [3] 🔒 Alterar Senha                   ║");
				System.out.println("║ [4] 🆔 Alterar CPF                     ║");
				System.out.println("║ [5] 🎂 Alterar Data de Nascimento      ║");
				System.out.println("║ [6] 🔙 Voltar ao Menu                  ║");
				System.out.println("╚════════════════════════════════════════╝");

				System.out.print("Escolha uma opção: ");
				int opcao = Integer.parseInt(sc.nextLine());

				try {
					switch (opcao) {
					case 1:
						System.out.println(">Digite o novo nome:");
						cliente.setNome(sc.nextLine());
						break;
					case 2:
						System.out.println(">Digite o novo email:");
						String novoEmail = sc.nextLine();
						cliente.setEmail(sc.nextLine());
						break;
					case 3:
						System.out.println(">Digite a nova senha (mínimo 6 caracteres):");
						cliente.setSenha(sc.nextLine());
						break;
					case 4:
						System.out.println(">Digite o novo CPF (apenas números):");
						cliente.setCpf(sc.nextLine());
						break;
					case 5:
						System.out.println(">Digite a nova data de nascimento (dd/MM/yyyy):");
						//Transformando o localDate em String
						DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						String novaData = sc.nextLine();
						try {
							LocalDate data = LocalDate.parse(novaData, formato);
						    cliente.setNatalicio(data);
						}
						catch(DadoInvalidoException e) {
							System.out.println("Formato de data invalido");
						}

						break;
					case 6:
						Gambiarras.textoLento("->Voltando ao menu...",80);
						continuarAlterar = false;
						break;
					default:
						System.out.println("Opção inválida. Digite novamente.");
					}
				} catch (Exception e) {
					System.out.println("Erro ao atualizar dados: " + e.getMessage());
				}

				if (continuarAlterar) {
					System.out.println("\n->Deseja alterar outro dado?\n");
					System.out.println(" [1] Sim");
					System.out.println(" [2] Não");
					System.out.print("Escolha a opção: ");
					int refazer = Integer.parseInt(sc.nextLine());

					if (refazer == 2) {
						continuarAlterar = false;
					}
				}
			}
		} else if (upUsuario instanceof Empresa) {
			Empresa empresa = (Empresa) upUsuario;
			boolean continuarAlterar = true;

			while (continuarAlterar) {
				System.out.println("\n╔════════════════════════════════════════════════════╗");
				System.out.println("║        🏢 ALTERAR DADOS DA EMPRESA                 ║");
				System.out.println("╠════════════════════════════════════════════════════╣");
				System.out.println("║ [1] ✏️ Alterar Nome                               ║");
				System.out.println("║ [2] 📧 Alterar Email                              ║");
				System.out.println("║ [3] 🔒 Alterar Senha                              ║");
				System.out.println("║ [4] 🆔 Alterar CNPJ                                ║");
				System.out.println("║ [5] 📍 Alterar Endereço                            ║");
				System.out.println("║ [6] 🏦 Alterar Banco da Empresa                    ║");
				System.out.println("║ [7] 🧾 Alterar Razão Social                        ║");
				System.out.println("║ [8] 🔙 Voltar ao Menu                              ║");
				System.out.println("╚════════════════════════════════════════════════════╝");
				System.out.print("\n-> Digite a opção desejada: ");

				System.out.print("Escolha uma opção: ");
				int opcao = Integer.parseInt(sc.nextLine());

				try {
					switch (opcao) {
					case 1:
						System.out.print(">Digite o novo nome: ");
						try {
							empresa.setNome(sc.nextLine());
							System.out.println("✅ Nome atualizado com sucesso!");
						} catch (DadoInvalidoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
						}
						break;
					case 2:
						System.out.print(">Digite o novo email: ");
						try {
							empresa.setEmail(sc.nextLine());
							System.out.println("✅ Email atualizado com sucesso!");
						} catch (DadoInvalidoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
						}
						
						break;
					case 3:
						System.out.print(">Digite a nova senha (mínimo 6 caracteres): ");
						try {
							empresa.setSenha(sc.nextLine());
							System.out.println("✅ Senha atualizada com sucesso!");
						} catch (DadoInvalidoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
						}
						
						break;
					case 4:
						System.out.print("Digite o novo CNPJ (somente números): ");
						try {
							empresa.setCpnj(sc.nextLine());
							System.out.println("✅ CNPJ atualizado com sucesso!");
						} catch (DadoInvalidoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
						}
						break;
					case 5:
						System.out.print("Digite o novo endereço: ");
						try {
							empresa.setEndereco(sc.nextLine());
							System.out.println("✅ Endereço atualizado com sucesso!");
						} catch (DadoInvalidoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
						}
						break;
					case 6:
						try {
							empresa.setBancoEmpresa(sc.nextLine()); //ver isso
							System.out.println("✅ Banco atualizado com sucesso!");
						} catch (DadoInvalidoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
						}
						break;
					case 7:
						System.out.print("Digite a nova razão social: ");
						try {
							empresa.setRazaoSocial(sc.nextLine());
							System.out.println("✅ Razão social atualizada com sucesso!");
						} catch (DadoInvalidoException e) {
							System.out.println("❌ Erro: " + e.getMessage());
						}
						break;
					case 8:
						System.out.println("Voltando ao menu...");
						continuarAlterar = false;
						break;
					default:
						System.out.println("Opção inválida. Digite novamente.");
					}
				} catch (Exception e) {
					System.out.println("Erro ao atualizar dados: " + e.getMessage());
				}

				if (continuarAlterar) {
					System.out.println("\nDeseja alterar outro dado?");
					System.out.println("1. Sim");
					System.out.println("2. Não");
					System.out.print("Escolha a opção: ");
					int refazer = Integer.parseInt(sc.nextLine());

					if (refazer == 2) {
						continuarAlterar = false;
					}
				}
			}

		}
	}

	@Override
	public Usuarios procurarEmailSenha(String email, String senha) {
		for (Usuarios u : usuarios) {
			if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public void deletar(Usuarios byeUsuario) {
		usuarios.remove(byeUsuario);
	}

	@Override
	public List<Usuarios> getTipo(Class<?> clazz) throws DadoInvalidoException {
		if (clazz == null) {	throw new DadoInvalidoException("A classe tem que existir.");}
		
		List<Usuarios> resultadoUsuario = new ArrayList<>();
		for (Usuarios usuario : usuarios) {
			if (clazz.isInstance(usuario)) {
				resultadoUsuario.add(usuario);
			}
		}
		return resultadoUsuario;
	}

	// -------------- metodos para procurar coisas especificas.
	@Override
	public Usuarios procurarNome(String nome) throws DadoInvalidoException {

		for (Usuarios usuario : usuarios) {
			if (usuario.getNome().equalsIgnoreCase(nome)) {

				return usuario;
			}
		}
		throw new DadoInvalidoException("Nome" + nome + " não encontrada para exclusão.");
	}

	@Override
	public Usuarios procurarEmail(String email) {
		for (Usuarios usuario : usuarios) {
			if (usuario.getEmail().equalsIgnoreCase(email)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public List<Usuarios> varrer() {
		// TODO Auto-generated method stub
		return null;
	}

}
