package Console;

import java.util.Scanner;

import Pessoa.Adm;
import Repositorio.RepositorioJogoArrayList;
import Repositorio.RepositorioUsuarioArrayList;
import TratamentoDeErro.DadoDuplicadoException;
import TratamentoDeErro.DadoInvalidoException;
import TratamentoDeErro.DadoNaoEncontradoException;
import funcionalidades.ControleDeCadastros;
import funcionalidades.ControleDeJogos;

public class TelaAdm {
	Scanner sc = new Scanner(System.in);

	VisualizacaoMenu menu = new VisualizacaoMenu();
	Adm adm = Adm.getInstancia(null, null, null);
	
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();
	RepositorioUsuarioArrayList listUsuario = new RepositorioUsuarioArrayList();
	private ControleDeCadastros cC;
	private ControleDeJogos cJ;
	
	
	public void exibirMenuAdm() throws DadoInvalidoException, DadoNaoEncontradoException, DadoDuplicadoException {
		
		menu.telaMenuMcAdm();
		int opcao = sc.nextInt();
		
		
//		[1] 🏷️ Ver Lista de Clientes cadastrados");
//	    System.out.println("  [2] 🏢 Ver Lista de Empresas cadastradas");
//	    System.out.println("  [3] 🧑‍💼 Cadastrar Cliente");
//	    System.out.println("  [4] 🏦 Cadastrar Empresa");
//	    System.out.println("  [5] 🎮 Ver todos os Jogos cadastrados");
//	    System.out.println("  [6] 💵 Cadastrar desconto anual");
//	    System.out.println("  [7] 📊 Resumo de vendas");
//	    System.out.println("  [8] ❌ Sair");
		
		do {
		
		switch(opcao) {
			case 1:
				System.out.println("\n╔══════════════════════════════════════╗");
				System.out.println("║         👤 CLIENTES CADASTRADOS        ║");
				System.out.println("╚══════════════════════════════════════╝");
				System.out.println();
				adm.clientesCadastrados();

				System.out.println(adm.getNome()+"  deseja:");
				System.out.println("  [1] 👤 Cadastrar novo Cliente.");
				System.out.println("  [2] 👤 Alterar dados de um cliente.");
				System.out.println("  [3] 👤 Informações detalhadas.");
				System.out.println("  [4] 👤 Remover uma conta.");
				
				System.out.println("  [5] 🔙 Voltar para o menu. ");
				
				System.out.println("Escolha uma opção:");
				opcoesCase1();
				
				break;
			case 2:
				System.out.println("\n╔══════════════════════════════════════╗");
				System.out.println("║         🏦 EMPRESAS CADASTRADAS        ║");
				System.out.println("╚══════════════════════════════════════╝");
				System.out.println();
				adm.empresasCadastradas();
				
				System.out.println(adm.getNome()+" oque você deseja:");
				System.out.println("  [1] 🏦 Cadastrar nova Empresa.");
				System.out.println("  [2] 🏦 Cadastrar Jogo de uma das Empresas.");
				System.out.println("  [3] 🏦 Alterar dados de uma empresa.");
				System.out.println("  [4] 🏦 Informações detalhadas.");
				System.out.println("  [5] 🔙 Voltar para o menu. ");
				
				System.out.println("Escolha uma opção:");
				opcoesCase2();
				
				break;
			case 3:
				//cadatrar Cliente 
				cC.CadastrarClientes();
				break;
			case 4:
				//casdastrarEmpresa
				cC.CadastrarEmpresa();
				break;
			case 5:
				System.out.println("\n╔═════════════════════════════════════════════╗");
				System.out.println("║         🎮 Lista de jogos por empresa         ║");
				System.out.println("╚═════════════════════════════════════════════╝");
				System.out.println();
				adm.jogoPorEmpresa();
				System.out.println(adm.getNome()+" oque você deseja:");
				//System.out.println("  [1] 🎮 Cadastrar novo Jogo.");
				System.out.println("  [2] 🎮 Alterar dados de um jogo.");
				System.out.println("  [3] 🎮 Deletar jogo.");
				System.out.println("  [4] 🎮 Informações detalhada de um jogos.");
				System.out.println("  [5] 🔙 Voltar para o menu. ");
				
				System.out.println("Escolha uma opção:");
				opcoesCase5();
				
				break;
			case 6:
				System.out.println("\n╔═════════════════════════════════════════════════════════════╗");
				System.out.println("║         💵 CADASTRAR DESCONTO PELO ANO DE LANÇAMENTO         ║");
				System.out.println("╚════════════════════════════════════════════════════════════╝");
				System.out.println();
				System.out.print(" => Insira o ano até o qual os jogos terão desconto aplicado:");
				int ano = sc.nextInt();
				System.out.print(" => Insira o desconto que sera aplicado.(ex: 20.0):");
				double desconto = sc.nextInt();
				
				adm.descontoPorAno(ano, desconto);
				break;
			case 7:
				//chmar o resumo de vendas
				break;
			case 8:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção invalida");
				opcao= sc.nextInt();
				
		}
		
		
	}while(opcao != 8);
		

	}
	
//	 [1] 👤 Cadastrar novo Cliente.");
//		System.out.println("  [2] 👤 Alterar dados de um cliente.");
//		System.out.println("  [3] 👤 Informações publicas.");
//		System.out.println("  [4] 👤 Remover uma conta.");
	
	public void opcoesCase1() throws DadoInvalidoException, DadoDuplicadoException {
		int opcao = sc.nextInt();
		do {
			
			switch(opcao) {
				case 1:
					cC.CadastrarClientes();
					break;
				case 2:
					System.out.println("Insira o nome do Cliente que deseja alterar dados:");
					//meio perdida em achar o alterar dados
					break;
				case 3:
					System.out.println("Deseja obter informaões de um cliente em especifio ou de todos?");
					System.out.println("[1] Um em especifico.");
					System.out.println("[2]Todos");
					int opcao2 =sc.nextInt();
					if(opcao2 ==1) {
						System.out.println("Insira o nome do Cliente que deseja obter informações detalhadas");
						//String nome = sc.nextLine();
						//falta completar isso de alterar o cliente pelo nome 
					}else if(opcao2 ==2) {
						adm.informacoesTodosClientes();
					}
					break;
				case 4:
					System.out.println("Insira o nome do Cliente que deseja remover");
					String nome = sc.nextLine();
					listUsuario.deletar(listUsuario.procurarNome(nome));
					break;
				case 5:
					System.out.println("Voltando ao munu...");
					//um pouco perdida se tem outra forma ou so volto pro menu mesmo
					exibirMenuAdm(); //tipo assim
					
			}
		}while(opcao != 5);
					
	}
	
//	 [1] 🏦 Cadastrar nova Empresa.");
//		System.out.println("  [2] 🏦 Cadastrar Jogo de uma das Empresas.");
//		System.out.println("  [3] 🏦 Alterar dados de uma empresa.");
//		System.out.println("  [4] 🏦 Informações detalhadas.");
//		System.out.println("  [5] 🔙 Voltar para o menu. ");
	public void opcoesCase2() throws DadoInvalidoException, DadoDuplicadoException {
		int opcao = sc.nextInt();
		do {
			
			switch(opcao) {
				case 1:
					cC.CadastrarEmpresa();
					break;
				case 2:
					System.out.println("Insira o nome(Razão social) da Empresa que deseja alterar dados:");
					//meio perdida em achar o alterar dados
					break;
				case 3:
					System.out.println("Deseja obter informaões de uma Empresa em especifio ou de todos?");
					System.out.println("[1] Um em especifico.");
					System.out.println("[2]Todos");
					int opcao2 =sc.nextInt();
					if(opcao2 ==1) {
						System.out.println("Insira o nome(Razão social) da Empresa que deseja obter informações detalhadas");
						//String nome = sc.nextLine();
						//falta completar isso de alterar o cliente pelo nome 
					}else if(opcao2 ==2) {
						adm.informacoesTodasEmpresas();
					}
					break;
				case 4:
					System.out.println("Insira o nome da Empresa que deseja remover");
					String nome = sc.nextLine();
					listUsuario.deletar(listUsuario.procurarNome(nome));
					break;
				case 5:
					System.out.println("Voltando ao munu...");
					//um pouco perdida se tem outra forma ou so volto pro menu mesmo
					exibirMenuAdm(); //tipo assim
					
			}
			}while(opcao != 5);
					
	}
//	System.out.println("  [1] 🎮 Cadastrar novo Jogo.");
//	System.out.println("  [2] 🎮 Alterar dados de um jogo.");
//	System.out.println("  [3] 🎮 Deletar jogo.");
//	System.out.println("  [4] 🎮 Informações detalhada de um jogos.");
//	System.out.println("  [5] 🔙 Voltar para o menu. ");

	public void opcoesCase5() throws DadoInvalidoException, DadoDuplicadoException {
		int opcao = sc.nextInt();
		do {
			
			switch(opcao) {
			case 1:
				//ver direitinho isso de cadastrar jogo
				break;
			case 2:
				System.out.println("Insira o título Jogo que deseja alterar dados:");
				String titulo = sc.nextLine();
				cJ.alterarDadosDosJogos(listJogos.procurarNome(titulo));
				break;
			case 3:
//				ver diritinho
				break;
			case 4:
//				ver diretinho
			case 5:
				System.out.println("Voltando ao munu...");
				//um pouco perdida se tem outra forma ou so volto pro menu mesmo
				exibirMenuAdm(); //tipo assim
				
	}
		}while(opcao != 5);
	}
	
}
