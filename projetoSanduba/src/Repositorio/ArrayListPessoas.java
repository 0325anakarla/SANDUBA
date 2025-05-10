package Repositorio;

import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;
import projetoSanduba.Adm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListPessoas extends Usuarios {
	Scanner dados = new Scanner(System.in);
	private Adm adm;
	private Cliente cliente;
	private Empresa empresa;

	public ArrayListPessoas(String nome, String email, String senha) {

		super(nome, email, senha);

	}

	private final List<Usuarios> usuario = new ArrayList<>();

	public void cadastrarConta(Usuarios usuario1) {
		usuario.add(usuario1);
	}

	public List<Usuarios> getUsusario() {
		return usuario;
	}

	@Override
	public void exibirInformacaoPublica(Usuarios usuario1) {
		if (usuario1 instanceof Cliente) {
			cliente = (Cliente) usuario1;
			String cpf1 = String.valueOf(cliente.getCpf());
			String ultimos2DadoCpf = cpf1.substring(cpf1.length() - 2);
			// String primeiros2DadoEmail = cliente.getEmail().substring(0, 2);
			// String ultimos13DadoEmail =
			// cliente.getEmail().substring(cliente.getEmail().length() - 13);
			System.out.println("Olá " + cliente.getNome() + " seus dados gerais:\n" + "Email:" + cliente.getEmail()
					+ "Sua senha: ****" +

					// será que precisa ocultar n sei
					"\nSua data de natalidade: " + cliente.getNatalicio() + "\nSeu Cpf: ***.***.**-" + ultimos2DadoCpf);

			// n sei oque mais é importante

		} else if (usuario1 instanceof Empresa) {
			Empresa empresa = (Empresa) usuario1;
			String primeiros2DadoEmail = empresa.getEmail().substring(0, 2);
			String ultimos13DadoEmail = empresa.getEmail().substring(empresa.getEmail().length() - 13);
			System.out.println("OS dados  gerais da empresa " + empresa.getRazaoSocial() + " são: \n" + "Email:"
					+ empresa.getEmail() + "Senha: ****\n" + "Endereço: " + empresa.getEndereco() + "\nCnpj :"
					+ empresa.getCpnj()
			// acho que o cnpj de uma empreja é oublic
			);
		}

	}

	@Override
	// add dados
	public void exibirInformacaoPrivada(Usuarios usuario1) {
		if (usuario1 instanceof Cliente) {
			cliente = (Cliente) usuario1;

			System.out.println(cliente.toString());

		} else if (usuario1 instanceof Empresa) {
			Empresa empresa = (Empresa) usuario1;
			System.out.println(empresa.toString());

		}

	}

	@Override
	public String alterarSenha(String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterarEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seusJogos(usuario1) {
		if(usuario1 instanceof Cliente){
			//vou precisar do historico de compras
		} else if (usuario1 instanceof Empresa) {
			Empresa empresa = (Empresa) usuario1;
			//n sei usar as coisas aqui no novo negocio, ai n sei criar a classe do array dos jogos
			adm.jogos.stream()
					.filter(jogo -> jogo.getEmpresa().getNome().equalsIgnoreCase(empresa))
					.sort(( Jogo jogo, Jogo jogo2 ) -> jogo.getTitulo().toUpperCase().compareTo(jogo2.getTitulo().toUpperCase()))
					.collect(Collectors.toList());

			for(Jogo j : jogos) {
				System.out.println(j+"\n");
			}
		}

		
	}

	@Override
	public void excluirConta() {
		System.out.println("Insira dados para poder excluir a conta:");
		System.out.println("Nome:");
		String opcao = dados.nextLine();
		System.out.println("Cpf ou Cnpj:");
		String opcao2 = dados.nextLine();
		if (opcao2.length() == 11) {
			String cpf1 = String.valueOf(cliente.getCpf());
			boolean excluir = usuario
					.removeIf(usuario -> usuario instanceof Cliente && (cpf1.equalsIgnoreCase(opcao2)));

			if (excluir) {
				System.out.println(" CONTA APAGADA COM SUCESSO");
			} else {
				System.out.println("CPF INVALIDO!");
			}
		} else if (opcao2.length() == 14) {
			String cnpj = String.valueOf(empresa.getCpnj());
			boolean excluir = usuario
					.removeIf(usuario -> usuario instanceof Empresa && (cnpj.equalsIgnoreCase(opcao2)));

			if (excluir) {
				System.out.println(" CONTA APAGADA COM SUCESSO");
			} else {
				System.out.println("CNPJ INVALIDO!");
			}

		} else {
			System.out.println("OPÇÃO INVALIDA");
		}

	}

	@Override
	public void exibirInformacaoPublica() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exibirInformacaoPrivada() {
		// TODO Auto-generated method stub

	}

}
