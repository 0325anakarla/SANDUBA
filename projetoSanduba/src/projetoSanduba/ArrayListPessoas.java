package projetoSanduba;

import Pessoa.Adm;
import Pessoa.Cliente;
import Pessoa.Empresa;
import Pessoa.Usuarios;

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
		// TODO Auto-generated constructor stub
	}

	private final List<Usuarios> usuario= new ArrayList<>();
	
	public void cadastrarConta(Usuarios usuario1) {
		usuario.add( usuario1);
	}

	public List<Usuarios> getUsusario() {
		return usuario;
	}

	@Override
	public void exibirInformacaoPublica(Usuarios usuario1) {
		if(usuario1 instanceof Cliente){
					cliente = (Cliente) usuario1;
			String ultimos2DadoCpf = cliente.getCpf().substring(cliente.getCpf().length() - 2);
			//String primeiros2DadoEmail = cliente.getEmail().substring(0, 2);
			//String ultimos13DadoEmail = cliente.getEmail().substring(cliente.getEmail().length() - 13);
			System.out.println("Olá "+cliente.getNome()+" seus dados gerais:\n" +
					"Email:"+cliente.getEmail()+
					"Sua senha: ****"+

					//será que precisa ocultar n sei
					"\nSua data de natalidade: "+cliente.getNatalicio()+
					"\nSeu Cpf: ***.***.**-"+ ultimos2DadoCpf);

					// n sei oque mais é importante

		}
		else if (usuario1 instanceof Empresa){
			Empresa empresa = (Empresa) usuario1;
			String primeiros2DadoEmail = empresa.getEmail().substring(0, 2);
			String ultimos13DadoEmail = empresa.getEmail().substring(email.length() - 13);
			System.out.println("OS dados  gerais da empresa "+empresa.getRazaoSocial()+" são: \n"+
							"Email:"+primeiros2DadoEmail +"****"+ultimos13DadoEmail+
							"Sua senha: ****"+

					)
		}
		
	}





	@Override
	//add dados
	public void exibirInformacaoPrivada() {
		if(usuario1 instanceof Cliente){
			Cliente cliente = (Cliente) usuario1;
			String ultimos2DadoCpf = cliente.getcCpf().substring(cliente.getcCpf().length() - 2);
			String primeiros2DadoEmail = cliente.getEmail().substring(0, 2);
			String ultimos13DadoEmail = cliente.getEmail().substring(cliente.getEmail().length() - 13);
			System.out.println("Olá "+cliente.getNome()+" seus dados :\n" +
					"Email:"+primeiros2DadoEmail +"****"+ultimos13DadoEmail+
					"Sua senha: ****"+

					//será que precisa ocultar n sei
					"\nSua data de natalidade: "+cliente.getNatalicio()+
					"\nSeu Cpf: ***.***.**-"+ ultimos2DadoCpf);

			// n sei oque mais é importante

		}
		else if (usuario1 instanceof Empresa){
			Empresa empresa = (Empresa) usuario1;
			String primeiros2DadoEmail = empresa.getEmail().substring(0, 2);
			String ultimos13DadoEmail = empresa.getEmail().substring(email.length() - 13);
			System.out.println("OS dados da empresa "+empresa.getRazaoSocial()+" são: \n"+
					"Email:"+primeiros2DadoEmail +"****"+ultimos13DadoEmail+
					"Sua senha: ****"

			);
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
		String opcao= dados.nextLine();
		System.out.println("Cpf ou Cnpj:");
		String opcao2= dados.nextLine();
		if(opcao2.length()==11){
			boolean excluir= usuario.removeIf(usuario->usuario instanceof Cliente && ((Cliente) usuario ).getCpf().equalsIgnoreCase(opcao2));

			if (excluir) {
				System.out.println(" CONTA APAGADA COM SUCESSO");
			} else {
				System.out.println("CPF INVALIDO!");
			}
		} else if (opcao2.length()==14) {
			boolean excluir= usuario.removeIf(usuario->usuario instanceof Empresa && ((Empresa) usuario ).getCnpj().equalsIgnoreCase(opcao2));

			if (excluir) {
				System.out.println(" CONTA APAGADA COM SUCESSO");
			} else {
				System.out.println("CNPJ INVALIDO!");
			}

		}else{
			System.out.println("OPÇÃO INVALIDA");
		}


	}
	

}
