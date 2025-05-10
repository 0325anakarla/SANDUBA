package Console;

import java.util.Scanner;

import Financeiro.CarteiraDaEmpresa;
import Pessoa.Empresa;
import Repositorio.RepositorioJogoArrayList;
import TratamentoDeErro.DadoInvalidoException;
import funcionalidades.ControleDeJogos;
import jogo.Jogo;

public class TelaEmpresa {
	Scanner sc = new Scanner(System.in);
	VisualizacaoMenu menu = new VisualizacaoMenu();
	CarteiraDaEmpresa cdE = new CarteiraDaEmpresa(null);
	ControleDeJogos controlJogos = new ControleDeJogos();
	Empresa empresa = new Empresa();
	RepositorioJogoArrayList listJogos = new RepositorioJogoArrayList();	
	
	public void telaMinhaContaEmpresa(Empresa empresa) throws DadoInvalidoException {		
		int opcao = 0;
		
		do {
			
			menu.telaMenuMcEmpresa();
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					System.out.println("Mostra informaçoes pessoais");
					empresa.toString();
					break;
				case 2:
					System.out.println("Mostra carteira digital e suas opções");
					telaCarteiraDigital();
					break;
				case 3:
					System.out.println("Jogos cadastrados");
					controlJogos.ListJogosEmpresa(empresa);
					break;
				case 4:
					System.out.println("\n╔═══════════════════════════════╗");
					System.out.println("║       ➕ CADASTRAR JOGOS        ║");
					System.out.println("╚═══════════════════════════════╝");

					controlJogos.CadastrarJogos();
					break;
				case 5:
					System.out.println("Resumo de vendas");
					//list para resumo de vendas
					break;
				case 6:
					System.out.println("sair");
					break;
				default:
					System.out.println("Opção invalida. Digite novamente.");
			}
			
		}while(opcao != 6);
	}
	
	public void telaCarteiraDigital() {
		int opcao = 0;
		
		do {
			
			menu.telaMenuCdEmpresa(cdE);
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 1:
					double valor =0;
					
					System.out.println("Sacar");
					System.out.println("Quanto vai sacar: ");
					
					valor = sc.nextDouble();
					
					if(cdE.sacar(valor)) {
						System.out.println("O valor retirado foi: "+valor+ ". Seu saldo é de:"+cdE.getSaldo());
					}
					
					else {
						System.out.println("Transação invalida.");
					}
					break;
				case 2:
					System.out.println("Mostrar dados bancarios");
					
					break;
				case 3:
					System.out.println("Voltar para minha conta");
					break;
				default:
					System.out.println("Opção invalida. Digite novamente.");
					
			}
			
		}while(opcao != 3);
	}
	
	public void telaJogosCadastrados(Empresa empresa) {
		int opcao = 0;
		
		menu.telaJogosCadastrados();
		
		do {
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao){
				case 1: 
					System.out.print("Digite o jogo que irar alterar:");
					String titulo = sc.nextLine();
					Jogo jogo = listJogos.procurarNome(titulo);
					controlJogos.alterarDadosDosJogos(jogo);
					break;
				case 2:
					controlJogos.deletarJogo(empresa);
					break;
				case 3:
					System.out.println("Voltar para minha conta");
					break;
				default:
					System.out.println("Opção invalida. Digite novamente.");
					
			}
	}while(opcao != 3);
}
}
