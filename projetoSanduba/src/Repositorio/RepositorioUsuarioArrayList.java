package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Repositorio;
import Interfaces.RepositorioUsuario;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import TratamentoDeErro.DadoInvalidoException;
// importar os exceptions
import verAdm.DateTimeFormatter;
import verAdm.LocalDate;
import verAdm.Scanner;

public class RepositorioUsuarioArrayList implements Repositorio<Usuarios>, RepositorioUsuario {


    private static RepositorioUsuarioArrayList instance; // eh o singleton
    Scanner sc = new Scanner(System.in);
    
    //Contrutor privado para ngm conseguir criar outras listas de usuarios
    public RepositorioUsuarioArrayList() {
        usuarios = new ArrayList<>();
    }

    //get para fazer o singleton
    public static RepositorioUsuarioArrayList getInstance() {
    	if(instance == null) {
    		instance = new RepositorioUsuarioArrayList();
    	}
        return instance;
    }

    private final List<Usuarios> usuarios = new ArrayList<>(); //Vai armazenar os Usuarios na list

    
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
		if(upUsuario instanceof Cliente) {
			Cliente cliente = (Cliente) upUsuario;
			boolean continuarAlterar = true;

            while (continuarAlterar) {
                System.out.println("\n==== ALTERAR DADOS DO CLIENTE ====");
                System.out.println("[1] Alterar Nome");
                System.out.println("[2] Alterar Email");
                System.out.println("[3] Alterar Senha");
                System.out.println("[4] Alterar CPF");
                System.out.println("[5] Alterar Data de Nascimento");
                System.out.println("[6] Voltar ao Menu");

                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(sc.nextLine());

                try {
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o novo nome:");
                            cliente.setNome(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Digite o novo email:");
                            String novoEmail = sc.nextLine();
                            cliente.setEmail(sc.nextLine());
                            break;
                        case 3:
                            System.out.println("Digite a nova senha (mínimo 6 caracteres):");
                            cliente.setSenha(sc.nextLine());
                            break;
                        case 4:
                            System.out.println("Digite o novo CPF (apenas números):");
                            cliente.setCpf(sc.nextLine());
                            break;
                        case 5:
                            System.out.println("Digite a nova data de nascimento (dd/MM/yyyy):");
                            cliente.setNatalicio(sc.nextLine());
                            break;
                        case 6:
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
        }else if(upUsuario instanceof Empresa) {
			Empresa empresa = (Empresa) upUsuario;
			boolean continuarAlterar = true;

			while (continuarAlterar) {
			    System.out.println("\n==== ALTERAR DADOS DA EMPRESA ====");
			    System.out.println("[1] Alterar Nome");
			    System.out.println("[2] Alterar Email");
			    System.out.println("[3] Alterar Senha");
			    System.out.println("[4] Alterar CNPJ");
			    System.out.println("[5] Alterar Endereço");
			    System.out.println("[6] Alterar Banco da Empresa");
			    System.out.println("[7] Alterar Razão Social");
			    System.out.println("[8] Voltar ao Menu");

			    System.out.print("Escolha uma opção: ");
			    int opcao = Integer.parseInt(sc.nextLine());

			    try {
			        switch (opcao) {
			            case 1:
			                System.out.print("Digite o novo nome: ");
			                empresa.setNome(sc.nextLine());
			                break;
			            case 2:
			                System.out.print("Digite o novo email: ");
			                empresa.setEmail(sc.nextLine());
			                break;
			            case 3:
			                System.out.print("Digite a nova senha (mínimo 6 caracteres): ");
			                empresa.setSenha(sc.nextLine());
			                break;
			            case 4:
			                System.out.print("Digite o novo CNPJ (somente números): ");
			                empresa.setCpnj(sc.nextLine());
			                break;
			            case 5:
			                System.out.print("Digite o novo endereço: ");
			                empresa.setEndereco(sc.nextLine());
			                break;
			            case 6:
			                System.out.print("Digite o novo banco da empresa: ");
			                empresa.setBancoEmpresa(sc.nextLine());
			                break;
			            case 7:
			                System.out.print("Digite a nova razão social: ");
			                empresa.setRazaoSocial(sc.nextLine());
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
	public void deletar(Usuarios byeUsuario) {
		usuarios.remove(byeUsuario);
	}

	@Override
	public List<Usuarios> getTipo(Class<?> clazz) /*throws DadoDuplicadoException, DadoInvalidoException*/ {
		if (clazz == null)
			throw new DadoInvalidoException("A classe tem que existir.");
		
		List<Usuarios> resultadoUsuario = new ArrayList<>();
		for (Usuarios usuario : usuarios) {
			if (clazz.isInstance(usuario)) {
				resultadoUsuario.add(usuario);
			}
		}
		return null;
	}

	// -------------- metodos para procurar coisas especificas.
	@Override
	public Usuarios procurarNome(String nome) {

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
